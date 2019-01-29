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
import com.xiudoua.micro.dao.ICommentDao;
import com.xiudoua.micro.entity.CommentEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.CommentVO;
import com.xiudoua.micro.service.ICommentService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:07:22
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	private ICommentDao commentDao;
	
	/** ############################# JustFresh 2018-11-24 Begin 私有帮助方法部分 ##################################### */
	
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private CommentVO getVO(CommentEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			CommentVO vo = new CommentVO();
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
	private CommentEntity getEntity(CommentVO vo){
		if(vo != null){
			CommentEntity entity = new CommentEntity();
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
	private List<CommentVO> getVOList(List<CommentEntity> entityList){
		List<CommentVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(CommentEntity entity : entityList){
				CommentVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	
	/** ############################# JustFresh 2018-11-24 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<CommentVO> findAll() {
		List<CommentVO> resList = new ArrayList<>();
		List<CommentEntity> entityList = this.commentDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.COMMENT_ID_REQUIRED);
		}
		try{
			this.commentDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_COMMENT_ERROR);
		}
	}

	@Override
	@Transactional
	public CommentVO save(CommentVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getContent())){
			throw new FormException(ErrorCodeEnum.COMMENT_CONTENT_MUST_BE_NOT_NULL);
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		CommentEntity entity = this.commentDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public CommentVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.COMMENT_ID_REQUIRED);
		}
		return this.getVO(this.commentDao.findOne(id));
	}

	@Override
	@Transactional
	public CommentVO update(CommentVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.COMMENT_ID_REQUIRED);
		}
		if(StringUtils.isEmpty(vo.getContent())){
			throw new FormException(ErrorCodeEnum.COMMENT_CONTENT_MUST_BE_NOT_NULL);
		}
		vo.setLastModifiedDate(new Date());
		CommentEntity entity = this.commentDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public Page<CommentVO> page(CommentVO vo, Pageable pageable) {
		Page<CommentEntity> page = this.commentDao.findAll(new Specification<CommentEntity>() {
			@Override
			public Predicate toPredicate(Root<CommentEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					/*if(!StringUtils.isEmpty(vo.getTitle())){
	                    predicates.add(cb.like(root.get("title"), "%" + vo.getTitle() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getKeywords())){
	                    predicates.add(cb.like(root.get("keywords"), "%" + vo.getKeywords() + "%"));
	                }*/
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
	public Long count(CommentVO vo) {
		Long count = this.commentDao.countByIsDelAndStatus(CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
		if(count != null){
			return count;
		}
		return 0L;
	}

}
