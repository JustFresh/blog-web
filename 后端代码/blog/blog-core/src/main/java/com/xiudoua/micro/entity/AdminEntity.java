package com.xiudoua.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.xiudoua.micro.entity.basic.AbsEntity;

/**
 * @desc 管理员PO类
 * @author JustFresh
 * @time 2018年11月23日 下午2:08:47
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_ADMIN")
public class AdminEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 管理员登录名
	 */
	@Column(name = "username", nullable = false, unique = true,columnDefinition="varchar(64) comment '管理员登录名'")
	private String username;
	
	/**
	 * 管理员昵称
	 */
	@Column(name = "nick_name", nullable = false, unique = true,columnDefinition="varchar(64) comment '管理员昵称'")
	private String nickName;
	
	/**
	 * 管理员登录密码
	 */
	@Column(name = "password", nullable = false,columnDefinition="varchar(64) comment '管理员登录密码'")
	private String password;
	
	/**
	 * 登录次数
	 */
	@Column(name = "login_num", columnDefinition="integer(11) default 0 comment '登录次数'")
	private Integer loginNum;
	
	/**
	 * 最近登录IP地址
	 */
	@Column(name = "last_login_ip", columnDefinition="varchar(64) comment '最近登录IP地址'")
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}