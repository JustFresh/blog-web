package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.model.LinksVO;

/**
 * 
 * @desc 有情链接处理Service层接口
 * @author JustFresh
 * @time 2019年1月6日 下午1:10:09
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface ILinksService extends IBaseService<LinksVO>{

	/**
	 * 分页条件查询
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<LinksVO> page(LinksVO vo,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param vo
	 * @return
	 */
	Long count(LinksVO vo);
	
}