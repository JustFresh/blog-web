package com.xiudoua.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiudoua.micro.entity.basic.AbsEntity;

/**
 * 
 * @desc 用户PO类
 * @author JustFresh
 * @time 2018年11月23日 下午2:12:41
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_USER")
public class UserEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 登录账号
	 */
	@Column(name = "username", nullable = false, unique = true,columnDefinition="varchar(64) comment '登录账号'")
	private String username;
	
	/**
	 * 登录密码
	 */
	@Column(name = "password", nullable = false,columnDefinition="varchar(64) comment '登录密码'")
	private String password;
	
	/**
	 * 登录安全码
	 */
	@Column(name = "login_secret", columnDefinition="varchar(64) comment '登录安全码'")
	private String loginSecret;
	
	/**
	 * 性别
	 */
	@Column(name = "sex", nullable = false, columnDefinition="varchar(10) comment '性别'")
	private String sex;
	
	/**
	 * 昵称
	 */
	@Column(name = "nick_name", columnDefinition="varchar(64) comment '昵称'")
	private String nickName;
	
	/**
	 * 用户QQ号
	 */
	@Column(name = "user_qq", columnDefinition="varchar(32) comment '用户QQ号'")
	private String userQQ;
	
	/**
	 * 用户联系电话
	 */
	@Column(name = "user_phone", nullable = false,columnDefinition="varchar(20) comment '用户联系电话'")
	private String userPhone;
	
	/**
	 * 用户邮箱
	 */
	@Column(name = "user_email", columnDefinition="varchar(32) comment '用户邮箱'")
	private String userEmail;
	
	/**
	 * 用户头像
	 */
	@Column(name = "thumb", columnDefinition="varchar(64) comment '用户头像'")
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
