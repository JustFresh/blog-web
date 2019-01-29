package com.xiudoua.micro.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.ChannelEntity;

/**
 * 
 * @desc 栏目维护DAO层接口
 * @author JustFresh
 * @time 2018年11月23日 下午4:44:02
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface IChannelDao extends JpaRepository<ChannelEntity, Integer>{
	
	/**
	 * 可变条件查询
	 * @param spec
	 * @param entity
	 * @return
	 */
	List<ChannelEntity> findAll(Specification<ChannelEntity> spec);
	
	/**
	 * 
	 * @return
	 */
	List<ChannelEntity> findByParentIdIsNull();
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	List<ChannelEntity> findByStatus(Byte status);
	
	/**
	 * 统计数量
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByIsDelAndStatus(Byte isDel,Byte status);
	
}