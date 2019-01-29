package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.ArticleVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:02:18
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IArticleService extends IBaseService<ArticleVO>{

	/**
	 * 
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<ArticleVO> page(ArticleVO vo,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param vo
	 * @return
	 */
	Long count(ArticleVO vo);

	/**
	 * 通过前端页面点击一次查询文章详情请求
	 * @param id
	 * @return
	 */
	ArticleVO homeDetail(Integer id) throws FormException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	ArticleVO prevArticle(Integer id) throws FormException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	ArticleVO nextArticle(Integer id) throws FormException;
	
}