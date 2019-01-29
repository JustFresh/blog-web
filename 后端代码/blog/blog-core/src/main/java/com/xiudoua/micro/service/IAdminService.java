package com.xiudoua.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.AdminVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:00:00
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IAdminService extends IBaseService<AdminVO>{

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws FormException
	 */
	AdminVO login(String username,String password) throws FormException;
	
	/**
	 * 
	 * @param username
	 * @return
	 * @throws FormException
	 */
	boolean checkUsernameIsExist(String username) throws FormException;
	
	/**
	 * 
	 * @param vo
	 * @param pageable
	 * @return
	 */
	Page<AdminVO> page(AdminVO vo,Pageable pageable);
	
}