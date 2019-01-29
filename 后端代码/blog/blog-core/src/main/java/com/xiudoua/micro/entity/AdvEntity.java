package com.xiudoua.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiudoua.micro.entity.basic.AbsEntity;

@Entity
@Table(name = "XDA_BLOG_ADV")
public class AdvEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 广告名称
	 */
	@Column(name = "adv_name", nullable = false,columnDefinition="varchar(255) comment '广告名称'")
	private String advName;
	
	/**
	 * 链接地址
	 */
	@Column(name = "adv_url", nullable = false,columnDefinition="varchar(255) default '#' comment '链接地址'")
	private String advUrl;
	
	/**
	 * 广告图片
	 */
	@Column(name = "thumb", nullable = false,columnDefinition="varchar(255) default '#' comment '广告图片'")
	private String thumb;
	
	/**
	 * 广告类型
	 * 1.PC 2.APP
	 */
	@Column(name = "adv_type", nullable = false,columnDefinition="tinyint(2) default 1 comment '广告类型'")
	private Byte advType;
	
	/**
	 * 所属广告位
	 */
	@Column(name = "position_id",columnDefinition="integer(11) comment '所属广告位ID'")
	private String positionId;
	
	/**
	 * 排序
	 */
	@Column(name = "reorder",columnDefinition="integer(11) default 1 comment '排序'")
	private Integer reorder;
	
	/**
	 * 点击量
	 */
	@Column(name = "click_num",columnDefinition="integer(11) default 0 comment '点击量'")
	private Integer clickNum;
	
	/**
	 * 是否新窗口打开
	 */
	@Column(name = "is_blank",columnDefinition="tinyint(2) default 0 comment '是否新窗口打开'")
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