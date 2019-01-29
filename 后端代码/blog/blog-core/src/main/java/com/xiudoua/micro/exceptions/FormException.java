package com.xiudoua.micro.exceptions;

import com.xiudoua.micro.constans.ErrorCodeEnum;

/**
 * 自定义表单校验异常类
 * 
 * <p> 
 *
 *
 * @author JustFresh
 *
 */
public class FormException extends Exception{

	private static final long serialVersionUID = 8184279831720421441L;

	/**
     * 错误编码
     */
    private String code;
    
    /**
     * 错误常量枚举
     */
    private ErrorCodeEnum errorEnum;
    
    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey = true;
    
    /**
     * 构造一个基本异常.
     * Creates a new instance of FormException.<br/>
     * Description: TODO<br/>
     * @param msg
     */
    public FormException(String msg){
        super(msg);
    }
    
    public FormException(ErrorCodeEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
    
    public FormException(String errorCode,String msg){
        this(errorCode,msg,true);
    }
    
    public FormException(String errorCode,String msg,Throwable cause){
        this(errorCode, msg, cause, true);
    }
    
    public FormException(String errorCode,String msg,boolean propertiesKey){
        super(msg);
        this.setCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public FormException(String errorCode,String msg,Throwable cause,boolean propertiesKey){
        super(msg,cause);
        this.setCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }
    
    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }

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
     * @return the errorEnum
     */
    public ErrorCodeEnum getErrorEnum() {
        return errorEnum;
    }

    /**
     * @param errorEnum the errorEnum to set
     */
    public void setErrorEnum(ErrorCodeEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
	
}
