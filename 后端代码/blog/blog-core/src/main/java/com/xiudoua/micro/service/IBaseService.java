package com.xiudoua.micro.service;

import java.util.List;

import com.xiudoua.micro.exceptions.FormException;

/**
 * 抽取通用基本service接口
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:40:26
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IBaseService<T> {

    /**
     * 
     * @return
     */
    List<T> findAll();

    /**
     * @param id
     */
    void delete(Integer id) throws FormException;

    /**
     * 
     * @param vo
     * @return
     * @throws FormException 表单校验异常
     */
    T save(T vo) throws FormException;

    /**
     * @param id
     * @return
     */
    T findOne(Integer id) throws FormException;

    /**
     * 
     * @param vo
     * @return
     * @throws FormException 表单校验异常
     */
    T update(T vo) throws FormException;

}