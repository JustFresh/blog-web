package com.xiudoua.micro.utils;

import java.io.Serializable;

/**
 * 
 * @desc 模拟前端下拉菜单所需VO对象
 * @author JustFresh
 * @time 2018年12月15日 下午3:38:16
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class SelectVO implements Serializable{

	private static final long serialVersionUID = -214982138348403376L;

	private String key;
	
	private String value;
	
	public SelectVO(){}
	
	public SelectVO(String key,String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}