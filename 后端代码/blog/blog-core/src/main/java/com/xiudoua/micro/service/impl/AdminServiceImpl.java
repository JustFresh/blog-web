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
import com.xiudoua.micro.dao.IAdminDao;
import com.xiudoua.micro.entity.AdminEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.AdminVO;
import com.xiudoua.micro.service.IAdminService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;
import com.xiudoua.micro.utils.MD5Util;

/**
 * 
 * @desc 管理员数据处理service层实现
 * @author JustFresh
 * @time 2018年11月23日 下午5:06:34
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminDao adminDao;
	
/** ############################# JustFresh 2018-11-24 Begin 私有帮助方法部分 ##################################### */
	
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private AdminVO getVO(AdminEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			AdminVO vo = new AdminVO();
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
	private AdminEntity getEntity(AdminVO vo){
		if(vo != null){
			AdminEntity entity = new AdminEntity();
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
	private List<AdminVO> getVOList(List<AdminEntity> entityList){
		List<AdminVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(AdminEntity entity : entityList){
				AdminVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	
	/** ############################# JustFresh 2018-11-24 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<AdminVO> findAll() {
		List<AdminVO> resList = new ArrayList<>();
		List<AdminEntity> entityList = this.adminDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ADMIN_ID_REQUIRED);
		}
		try{
			this.adminDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_ADMIN_ERROR);
		}
	}

	@Override
	@Transactional
	public AdminVO save(AdminVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getUsername())){
			throw new FormException(ErrorCodeEnum.ADMIN_NAME_MUST_BE_NOT_NULL);
		}
		if(StringUtils.isEmpty(vo.getPassword())){
			throw new FormException(ErrorCodeEnum.ADMIN_PASSWORD_MUST_BE_NOT_NULL);
		}else{
			vo.setPassword(MD5Util.encode(vo.getPassword()));
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		try{
			AdminEntity entity = this.adminDao.save(this.getEntity(vo));
			if(entity != null && !StringUtils.isEmpty(entity.getId())){
				return this.getVO(entity);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AdminVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ADMIN_ID_REQUIRED);
		}
		return this.getVO(this.adminDao.findOne(id));
	}

	@Override
	@Transactional
	public AdminVO update(AdminVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.ADMIN_ID_REQUIRED);
		}
		if(StringUtils.isEmpty(vo.getUsername())){
			throw new FormException(ErrorCodeEnum.ADMIN_NAME_MUST_BE_NOT_NULL);
		}
		vo.setLastModifiedDate(new Date());
		AdminEntity entity = this.adminDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public AdminVO login(String username, String password) throws FormException {
		if(StringUtils.isEmpty(username)){
			throw new FormException(ErrorCodeEnum.ADMIN_NAME_MUST_BE_NOT_NULL);
		}
		if(StringUtils.isEmpty(password)){
			throw new FormException(ErrorCodeEnum.ADMIN_PASSWORD_MUST_BE_NOT_NULL);
		}
		AdminEntity entity = this.adminDao.findByUsernameAndPasswordAndIsDel(username, MD5Util.encode(password), CommonConstans.IS_DEL_NO);
		if(entity != null){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public boolean checkUsernameIsExist(String username) throws FormException {
		boolean flag = false;
		if(StringUtils.isEmpty(username)){
			throw new FormException(ErrorCodeEnum.ADMIN_NAME_MUST_BE_NOT_NULL);
		}
		List<AdminEntity> list = this.adminDao.findByUsernameAndIsDel(username, CommonConstans.IS_DEL_NO);
		if(list != null && !list.isEmpty()){
			flag = true;
		}
		return flag;
	}

	@Override
	public Page<AdminVO> page(AdminVO vo, Pageable pageable) {
		Page<AdminEntity> page = this.adminDao.findAll(new Specification<AdminEntity>() {
			@Override
			public Predicate toPredicate(Root<AdminEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					if(!StringUtils.isEmpty(vo.getUsername())){
	                    predicates.add(cb.like(root.get("username"), "%" + vo.getUsername() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getNickName())){
	                    predicates.add(cb.like(root.get("nickName"), "%" + vo.getNickName() + "%"));
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
