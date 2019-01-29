package com.xiudoua.micro.model.basic;

import java.util.Date;


/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:57:58
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public abstract class AbsModel {

	/**
	 * 添加时间
	 */
	private Date createTime;

	/**
	 * 最近修改时间
	 */
    private Date lastModifiedDate;

    /**
	 * 账号状态（1启用，0禁用）
	 */
	private Byte status;
	
	/**
	 * 删除标识（1删除，0未删除）
	 */
	private Byte isDel;
    
    /**
     * 备注字段
     */
    private String description;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}