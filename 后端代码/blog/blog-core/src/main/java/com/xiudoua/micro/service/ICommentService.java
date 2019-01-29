package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.model.CommentVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:02:49
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface ICommentService extends IBaseService<CommentVO>{

	/**
	 * 
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<CommentVO> page(CommentVO vo,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param vo
	 * @return
	 */
	Long count(CommentVO vo);
	
}