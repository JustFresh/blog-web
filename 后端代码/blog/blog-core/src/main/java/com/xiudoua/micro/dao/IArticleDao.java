package com.xiudoua.micro.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xiudoua.micro.entity.ArticleEntity;
import com.xiudoua.micro.entity.ChannelEntity;

/**
 * 
 * @desc 文章维护DAO层接口
 * @author JustFresh
 * @time 2018年11月23日 下午4:43:27
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Repository
public interface IArticleDao extends JpaRepository<ArticleEntity, Integer>{

	/**
	 * 分页条件查询
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<ArticleEntity> findAll(Specification<ArticleEntity> specification,Pageable pageable);

	/**
	 * 统计数量
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByIsDelAndStatus(Byte isDel,Byte status);
	
	/**
	 * 统计数量
	 * @param channel
	 * @param isDel
	 * @param status
	 * @return
	 */
	Long countByChannelAndIsDelAndStatus(ChannelEntity channel,Byte isDel,Byte status);
	
	/**
	 * 查找上一条
	 * @param channdId
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT * FROM xda_blog_article WHERE channel_id = ?1 and id < ?2 ORDER BY id desc limit 1",nativeQuery = true)
	List<ArticleEntity> findPrevArticle(Integer channdId,Integer id);
	
	/**
	 * 查询下一条
	 * @param channelId
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT * FROM xda_blog_article WHERE channel_id = ?1 and id > ?2 ORDER BY id ASC limit 1", nativeQuery = true)
	List<ArticleEntity> findNextArticle(Integer channelId,Integer id);
}
