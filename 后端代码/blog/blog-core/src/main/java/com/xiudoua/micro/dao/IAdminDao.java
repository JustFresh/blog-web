package com.xiudoua.micro.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.AdminEntity;

/**
 * 
 * @desc 管理员维护DAO层接口
 * @author JustFresh
 * @time 2018年11月23日 下午4:42:29
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface IAdminDao extends JpaRepository<AdminEntity, Integer>{

	/**
	 * 
	 * @param username
	 * @param password
	 * @param isDel
	 * @return
	 */
	AdminEntity findByUsernameAndPasswordAndIsDel(String username,String password,Byte isDel);
	
	/**
	 * 
	 * @param username
	 * @param isDel
	 * @return
	 */
	List<AdminEntity> findByUsernameAndIsDel(String username,Byte isDel);
	
	/**
	 * 分页条件查询
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<AdminEntity> findAll(Specification<AdminEntity> spec, Pageable pageable);
	
}