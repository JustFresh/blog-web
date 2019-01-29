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
 * @desc 栏目PO类
 * @author JustFresh
 * @time 2018年11月23日 下午2:10:38
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_CHANNEL")
public class ChannelEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 栏目名称
	 */
	@Column(name = "channel_name", nullable = false, unique = true,columnDefinition="varchar(64) comment '栏目名称'")
	private String channelName;
	
	/**
	 * 父级栏目ID
	 */
	@Column(name = "parent_id",columnDefinition="integer(11) comment '父级栏目ID'")
	private Integer parentId;
	
	/**
	 * 排序
	 */
	@Column(name = "reorder",nullable = false,columnDefinition="integer(11) comment '排序' default 1")
	private Integer reorder;
	
	/**
	 * 链接地址
	 */
	@Column(name = "uri",columnDefinition="varchar(64) comment '链接地址' default '#'")
	private String uri;
	
	/**
	 * icon样式
	 */
	@Column(name = "icon",columnDefinition="varchar(64) comment 'icon样式'")
	private String icon;
	
	/**
	 * 是否新窗口弹出
	 */
	@Column(name = "is_blank",columnDefinition="tinyint(2) comment '是否新窗口弹出' default 0")
	private Byte isBlank;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Byte getIsBlank() {
		return isBlank;
	}

	public void setIsBlank(Byte isBlank) {
		this.isBlank = isBlank;
	}

}