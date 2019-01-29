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
import com.xiudoua.micro.dao.ILinksDao;
import com.xiudoua.micro.entity.LinksEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.LinksVO;
import com.xiudoua.micro.service.ILinksService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2019年1月6日 下午2:47:17
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class LinksServiceImpl implements ILinksService{

	@Autowired
	private ILinksDao linksDao;
	
	/** ############################# JustFresh 2019-01-06 Begin 私有帮助方法部分 ##################################### */
	/**
	 * 将entity对象转换成VO对象
	 * @param entity
	 * @return
	 */
	private LinksVO getVO(LinksEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			LinksVO vo = new LinksVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}
		return null;
	}
	
	/**
	 * 将VO对象转换成Entity对象
	 * @param vo
	 * @return
	 */
	private LinksEntity getEntity(LinksVO vo){
		if(vo != null){
			LinksEntity entity = new LinksEntity();
			BeanUtils.copyProperties(vo, entity,CopyPropertiesUtil.getNullPropertyNames(vo));
			return entity;
		}
		return null;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private List<LinksVO> getVOList(List<LinksEntity> entityList){
		List<LinksVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(LinksEntity entity : entityList){
				LinksVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	/** ############################# JustFresh 2019-01-06 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<LinksVO> findAll() {
		List<LinksVO> resList = new ArrayList<>();
		List<LinksEntity> entityList = this.linksDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.LINKS_ID_REQUIRED);
		}
		try{
			this.linksDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_LINKS_ERROR);
		}
	}

	@Override
	@Transactional
	public LinksVO save(LinksVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getTitle())){
			throw new FormException(ErrorCodeEnum.LINKS_TITLE_MUST_BE_NOT_NULL);
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		LinksEntity entity = this.linksDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public LinksVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.LINKS_ID_REQUIRED);
		}
		return this.getVO(this.linksDao.findOne(id));
	}

	@Override
	@Transactional
	public LinksVO update(LinksVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.LINKS_ID_REQUIRED);
		}
		vo.setLastModifiedDate(new Date());
		LinksEntity entity = this.linksDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public Page<LinksVO> page(LinksVO vo, Pageable pageable) {
		Page<LinksEntity> page = this.linksDao.findAll(new Specification<LinksEntity>() {
			@Override
			public Predicate toPredicate(Root<LinksEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					if(!StringUtils.isEmpty(vo.getTitle())){
	                    predicates.add(cb.like(root.get("title"), "%" + vo.getTitle() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getIsBlank())){
	                    predicates.add(cb.equal(root.get("isBlank"),vo.getIsBlank()));
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
	public Long count(LinksVO vo) {
		Long count = this.linksDao.countByIsDelAndStatus(CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
		if(count != null){
			return count;
		}
		return 0L;
	}

}