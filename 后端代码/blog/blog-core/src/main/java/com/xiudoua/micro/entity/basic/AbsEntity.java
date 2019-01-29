package com.xiudoua.micro.entity.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsEntity {
	
	/**
	 * 创建时间
	 */
	@CreatedDate
	@Column(name = "create_time",columnDefinition="datetime comment '创建时间'")
    private Date createTime;

	/**
	 * 最近修改时间
	 */
    @LastModifiedDate
    @Column(name = "last_modified_date",columnDefinition="datetime comment '最近修改时间'")
    private Date lastModifiedDate;

    /**
	 * 账号状态（1启用，0禁用）
	 */
	@Column(name = "status", nullable = false,columnDefinition="tinyint(2) default 1 comment '账号状态（1启用，0禁用）'")
	private Byte status;
	
	/**
	 * 删除标识（1删除，0未删除）
	 */
	@Column(name = "is_del", nullable = false,columnDefinition="tinyint(2) default 0 comment '删除标识（1删除，0未删除）'")
	private Byte isDel;
    
    /**
     * 备注字段
     */
    @Column(name = "description",columnDefinition="varchar(1000) comment '备注字段'")
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