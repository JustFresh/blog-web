package com.xiudoua.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xiudoua.micro.entity.basic.AbsEntity;

/**
 * 
 * @desc 文章PO类
 * @author JustFresh
 * @time 2018年11月23日 下午2:09:32
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_ARTICLE")
public class ArticleEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 文章标题
	 */
	@Column(name = "title", nullable = false, unique = true,columnDefinition="varchar(256) comment '文章标题'")
	private String title;
	
	/**
	 * 文章缩略图
	 */
	@Column(name = "thumb",columnDefinition="varchar(128) comment '文章缩略图'")
	private String thumb;
	
	/**
	 * 文章简介
	 */
	@Column(name = "abstracts",columnDefinition="varchar(1000) comment '文章简介'")
	private String abstracts;
	
	/**
	 * 文章关键字
	 */
	@Column(name = "keywords",columnDefinition="varchar(1000) comment '文章关键字'")
	private String keywords;
	
	/**
	 * 文章来源
	 */
	@Column(name = "source",columnDefinition="varchar(64) comment '文章来源'")
	private String source;
	
	/**
	 * 文章作者
	 */
	@Column(name = "author",columnDefinition="varchar(64) comment '文章作者'")
	private String author;
	
	/**
	 * 是否为推荐文章
	 */
	@Column(name = "is_recommend",columnDefinition="tinyint(2) comment '是否为推荐文章' default 0")
	private Integer isRecommend;
	
	/**
	 * 是否为置顶文章
	 */
	@Column(name = "is_top",columnDefinition="tinyint(2) comment '是否为置顶文章' default 0")
	private Integer isTop;
	
	/**
	 * 点击次数
	 */
	@Column(name = "click_num",columnDefinition="integer(11) comment '点击次数' default 0")
	private Integer clickNum;
	
	/**
	 * 文章内容
	 */
	@Column(name = "content",columnDefinition="text comment '文章内容'")
	private String content;
	
	/**
	 * 文章所属栏目，封装多对一说
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "channel_id",nullable = false,columnDefinition="integer(11) comment '文章所属栏目'")
    private ChannelEntity channel;

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

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ChannelEntity getChannel() {
		return channel;
	}

	public void setChannel(ChannelEntity channel) {
		this.channel = channel;
	}
	
}