package com.xiudoua.micro.model;

import java.io.Serializable;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2019年1月6日 下午1:06:28
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class LinksVO extends AbsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6681351674243347968L;
	
	private Integer id;
	
	/**
	 * 友情链接标题
	 */
	private String title;
	
	/**
	 * 友情链接LOGO
	 */
	private String logo;
	
	/**
	 * 友情链接地址
	 */
	private String url;
	
	/**
	 * 是否新窗口打开
	 */
	private Byte isBlank;
	
	/**
	 * 排序
	 */
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