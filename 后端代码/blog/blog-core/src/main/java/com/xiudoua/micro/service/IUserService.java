package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.model.UserVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:03:06
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IUserService extends IBaseService<UserVO>{

	/**
	 * 
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<UserVO> page(UserVO vo,Pageable pageable);
	
}