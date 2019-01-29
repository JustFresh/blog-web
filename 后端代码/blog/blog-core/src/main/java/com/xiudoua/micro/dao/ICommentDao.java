package com.xiudoua.micro.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.CommentEntity;

/**
 * 
 * @desc 评论维护DAO层接口
 * @author JustFresh
 * @time 2018年11月23日 下午4:44:31
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface ICommentDao extends JpaRepository<CommentEntity, Integer>{

	/**
	 * 分页条件查询
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<CommentEntity> findAll(Specification<CommentEntity> specification,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByIsDelAndStatus(Byte isDel,Byte status);
}