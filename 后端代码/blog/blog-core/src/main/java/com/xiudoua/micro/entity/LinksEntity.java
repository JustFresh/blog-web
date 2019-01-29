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
 * @desc 
 * @author JustFresh
 * @time 2019年1月6日 下午12:55:28
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_LINKS")
public class LinksEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 友情链接标题
	 */
	@Column(name = "title", nullable = false,columnDefinition="varchar(255) comment '友情链接标题'")
	private String title;
	
	/**
	 * 友情链接LOGO
	 */
	@Column(name = "logo",columnDefinition="varchar(255) comment '友情链接LOGO'")
	private String logo;
	
	/**
	 * 友情链接地址
	 */
	@Column(name = "url", columnDefinition="varchar(255) comment '友情链接地址' default '#'")
	private String url;
	
	/**
	 * 是否新窗口打开
	 */
	@Column(name = "is_blank",columnDefinition="tinyint(2) default 0 comment '是否新窗口打开'")
	private Byte isBlank;
	
	/**
	 * 排序
	 */
	@Column(name = "reorder",columnDefinition="integer(11) default 1 comment '排序'")
	private Integer reorder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Byte getIsBlank() {
		return isBlank;
	}

	public void setIsBlank(Byte isBlank) {
		this.isBlank = isBlank;
	}

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}

}