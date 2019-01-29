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
import com.xiudoua.micro.dao.IUserDao;
import com.xiudoua.micro.entity.UserEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.UserVO;
import com.xiudoua.micro.service.IUserService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;
import com.xiudoua.micro.utils.MD5Util;

/**
 * 
 * @desc 用户数据维护service层实现类
 * @author JustFresh
 * @time 2018年11月23日 下午5:07:50
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	/** ############################# JustFresh 2018-11-24 Begin 私有帮助方法部分 ##################################### */
	
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private UserVO getVO(UserEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			UserVO vo = new UserVO();
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
	private UserEntity getEntity(UserVO vo){
		if(vo != null){
			UserEntity entity = new UserEntity();
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
	private List<UserVO> getVOList(List<UserEntity> entityList){
		List<UserVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(UserEntity entity : entityList){
				UserVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	
	/** ############################# JustFresh 2018-11-24 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<UserVO> findAll() {
		List<UserVO> resList = new ArrayList<>();
		List<UserEntity> entityList = this.userDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.USER_ID_REQUIRED);
		}
		try{
			this.userDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_USER_ERROR);
		}
	}

	@Override
	@Transactional
	public UserVO save(UserVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getUsername())){
			throw new FormException(ErrorCodeEnum.USERNAME_MUST_BE_NOT_NULL);
		}
		if(StringUtils.isEmpty(vo.getPassword())){
			throw new FormException(ErrorCodeEnum.PASSWORD_MUST_BE_NOT_NULL);
		}else{
			vo.setPassword(MD5Util.encode(vo.getPassword()));
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		UserEntity entity = this.userDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public UserVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.USER_ID_REQUIRED);
		}
		return this.getVO(this.userDao.findOne(id));
	}

	@Override
	@Transactional
	public UserVO update(UserVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.USER_ID_REQUIRED);
		}
		vo.setLastModifiedDate(new Date());
		UserEntity entity = this.userDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public Page<UserVO> page(UserVO vo, Pageable pageable) {
		Page<UserEntity> page = this.userDao.findAll(new Specification<UserEntity>() {
			@Override
			public Predicate toPredicate(Root<UserEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					if(!StringUtils.isEmpty(vo.getUsername())){
	                    predicates.add(cb.like(root.get("username"), "%" + vo.getUsername() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getNickName())){
	                    predicates.add(cb.like(root.get("nickName"), "%" + vo.getNickName() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getUserPhone())){
	                    predicates.add(cb.like(root.get("userPhone"), "%" + vo.getUserPhone() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getUserEmail())){
	                    predicates.add(cb.like(root.get("userEmail"), "%" + vo.getUserEmail() + "%"));
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

}