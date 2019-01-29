package com.xiudoua.micro.model;

import java.io.Serializable;
import java.util.List;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:51:30
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class ChannelVO extends AbsModel implements Serializable{

	private static final long serialVersionUID = 7456445514274157482L;
	
	private Integer id;
	
	/**
	 * 栏目名称
	 */
	private String channelName;
	
	/**
	 * 父级栏目ID
	 */
	private Integer parentId;
	
	/**
	 * 排序
	 */
	private Integer reorder;
	
	/**
	 * 链接地址
	 */
	private String uri;
	
	/**
	 * icon样式
	 */
	private String icon;
	
	/**
	 * 是否新窗口弹出
	 */
	private Byte isBlank;
	
	/**
	 * 逻辑自关联子节点列表
	 */
	private List<ChannelVO> children;

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

	public List<ChannelVO> getChildren() {
		return children;
	}

	public void setChildren(List<ChannelVO> children) {
		this.children = children;
	}

}