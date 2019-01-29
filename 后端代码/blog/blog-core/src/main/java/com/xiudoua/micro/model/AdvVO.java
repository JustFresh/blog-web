package com.xiudoua.micro.model;

import java.io.Serializable;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 广告VO层实体
 * @author JustFresh
 * @time 2018年12月15日 下午2:35:43
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class AdvVO extends AbsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3568209809769851213L;

	private Integer id;
	
	/**
	 * 广告名称
	 */
	private String advName;
	
	/**
	 * 广告图片
	 */
	private String thumb;
	
	/**
	 * 链接地址
	 */
	private String advUrl;
	
	/**
	 * 广告类型
	 * 1.PC 2.APP
	 */
	private Byte advType;
	
	/**
	 * 所属广告位
	 */
	private String positionId;
	
	/**
	 * 排序
	 */
	private Integer reorder;
	
	/**
	 * 点击量
	 */
	private Integer clickNum;
	
	/**
	 * 是否新窗口打开
	 */
	private Byte isBlank;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName;
	}

	public String getAdvUrl() {
		return advUrl;
	}

	public void setAdvUrl(String advUrl) {
		this.advUrl = advUrl;
	}

	public Byte getAdvType() {
		return advType;
	}

	public void setAdvType(Byte advType) {
		this.advType = advType;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public Integer getReorder() {
		return reorder;
	}

	public void setReorder(Integer reorder) {
		this.reorder = reorder;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Byte getIsBlank() {
		return isBlank;
	}

	public void setIsBlank(Byte isBlank) {
		this.isBlank = isBlank;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}