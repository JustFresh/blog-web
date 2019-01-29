package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.model.AdvVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年12月15日 下午2:39:02
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IAdvService extends IBaseService<AdvVO>{

	/**
	 * 分页条件查询
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<AdvVO> page(AdvVO vo,Pageable pageable);
	
	/**
	 * 统计数量
	 * @param vo
	 * @return
	 */
	Long count(AdvVO vo);
	
}