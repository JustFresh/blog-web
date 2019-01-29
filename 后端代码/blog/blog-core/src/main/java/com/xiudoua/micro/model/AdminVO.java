package com.xiudoua.micro.model;

import java.io.Serializable;

import com.xiudoua.micro.model.basic.AbsModel;

public class AdminVO extends AbsModel implements Serializable{

	private static final long serialVersionUID = 267300478678472512L;

	private Integer id;
	
	/**
	 * 管理员登录名
	 */
	private String username;
	
	/**
	 * 管理员昵称
	 */
	private String nickName;
	
	/**
	 * 管理员登录密码
	 */
	private String password;
	
	/**
	 * 登录次数
	 */
	private Integer loginNum;
	
	/**
	 * 最近登录IP地址
	 */
	private String lastLoginIp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
}