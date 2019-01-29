package com.xiudoua.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiudoua.micro.constans.CommonConstans;
import com.xiudoua.micro.constans.ErrorCodeEnum;
import com.xiudoua.micro.dao.IAdvDao;
import com.xiudoua.micro.entity.AdvEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.AdvVO;
import com.xiudoua.micro.service.IAdvService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年12月15日 下午2:39:53
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class AdvServiceImpl implements IAdvService{

	@Autowired
	private IAdvDao advDao;
	
	/** ############################# JustFresh 2018-12-15 Begin 私有帮助方法部分 ##################################### */
	
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private AdvVO getVO(AdvEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			AdvVO vo = new AdvVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}
		return null;
	}
	
	/**
	 * 将视图层VO对象转换成持久化层PO对象
	 * @param vo
	 * @return
	 */
	private AdvEntity getEntity(AdvVO vo){
		if(vo != null){
			AdvEntity entity = new AdvEntity();
			BeanUtils.copyProperties(vo, entity,CopyPropertiesUtil.getNullPropertyNames(vo));
			return entity;
		}
		return null;
	}
	
	/**
	 * 通过持久化层PO对象列表转换为对应视图层VO对象列表
	 * @param entityList
	 * @return
	 */
	private List<AdvVO> getVOList(List<AdvEntity> entityList){
		List<AdvVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(AdvEntity entity : entityList){
				AdvVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	
	/** ############################# JustFresh 2018-12-15 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<AdvVO> findAll() {
		List<AdvVO> resList = new ArrayList<>();
		List<AdvEntity> entityList = this.advDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ADV_ID_REQUIRED);
		}
		try{
			this.advDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_ADV_ERROR);
		}
	}

	@Override
	@Transactional
	public AdvVO save(AdvVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getAdvName())){
			throw new FormException(ErrorCodeEnum.ADVNAME_MUST_BE_NOT_NULL);
		}
		if(StringUtils.isEmpty(vo.getAdvUrl())){
			throw new FormException(ErrorCodeEnum.ADVURL_MUST_BE_NOT_NULL);
		}
		if(StringUtils.isEmpty(vo.getPositionId())){
			throw new FormException(ErrorCodeEnum.POSTIONID_MUST_BE_NOT_NULL);
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		AdvEntity entity = this.advDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public AdvVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ADV_ID_REQUIRED);
		}
		return this.getVO(this.advDao.findOne(id));
	}

	@Override
	@Transactional
	public AdvVO update(AdvVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.ADV_ID_REQUIRED);
		}
		vo.setLastModifiedDate(new Date());
		AdvEntity entity = this.advDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public Page<AdvVO> page(AdvVO vo, Pageable pageable) {
		Page<AdvEntity> page = this.advDao.findAll(new Specification<AdvEntity>() {
			@Override
			public Predicate toPredicate(Root<AdvEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					if(!StringUtils.isEmpty(vo.getAdvName())){
	                    predicates.add(cb.like(root.get("advName"), "%" + vo.getAdvName() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getAdvUrl())){
	                    predicates.add(cb.like(root.get("advUrl"), "%" + vo.getAdvUrl() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getAdvType())){
	                    predicates.add(cb.equal(root.get("advType"),vo.getAdvType()));
	                }
					if(!StringUtils.isEmpty(vo.getPositionId())){
	                    predicates.add(cb.equal(root.get("positionId"),vo.getPositionId()));
	                }
					if(!StringUtils.isEmpty(vo.getStatus())){
						predicates.add(cb.equal(root.get("status"), vo.getStatus()));
					}
				}
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));	
			}
			
		},pageable);
		return new PageImpl<>(getVOList(page.getContent()), pageable,page.getTotalElements());
	}

	@Override
	public Long count(AdvVO vo) {
		Long count = this.advDao.countByIsDelAndStatus(CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
		if(count != null){
			return count;
		}
		return 0L;
	}

}