package com.xiudoua.micro.model;

import java.io.Serializable;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:47:31
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class UserVO extends AbsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1165580387002019179L;

	private Integer id;
	
	/**
	 * 登录账号
	 */
	private String username;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 登录安全码
	 */
	private String loginSecret;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 用户QQ号
	 */
	private String userQQ;
	
	/**
	 * 用户联系电话
	 */
	private String userPhone;
	
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	
	/**
	 * 用户头像
	 */
	private String thumb;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginSecret() {
		return loginSecret;
	}

	public void setLoginSecret(String loginSecret) {
		this.loginSecret = loginSecret;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}