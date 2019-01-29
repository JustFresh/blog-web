package com.xiudoua.micro.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.LinksEntity;

/**
 * 
 * @desc 友情链接处理DAO层接口
 * @author JustFresh
 * @time 2019年1月6日 下午1:08:59
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface ILinksDao extends JpaRepository<LinksEntity, Integer>{

	/**
	 * 分页条件查询
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<LinksEntity> findAll(Specification<LinksEntity> specification,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByIsDelAndStatus(Byte isDel,Byte status);
	
}