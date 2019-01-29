package com.xiudoua.micro.utils;

import java.io.Serializable;

import com.xiudoua.micro.constans.ErrorCodeEnum;

/**
 * 
 * @desc 自定义统一接口JSON格式返回类
 * @author JustFresh
 * @time 2018年11月23日 下午4:37:25
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class RestJson implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2515330514361592399L;

	//默认操作成功
	private String code = ErrorCodeEnum.SUCCESS.code();
    
    private String msg;
    
    private Object data;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    
}