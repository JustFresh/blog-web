package com.xiudoua.micro.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.AdvEntity;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年12月15日 下午2:41:22
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface IAdvDao extends JpaRepository<AdvEntity, Integer>{

	/**
	 * 分页条件查询
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<AdvEntity> findAll(Specification<AdvEntity> specification,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByIsDelAndStatus(Byte isDel,Byte status);
}