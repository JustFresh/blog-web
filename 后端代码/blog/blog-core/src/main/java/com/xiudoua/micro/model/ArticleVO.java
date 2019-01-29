package com.xiudoua.micro.model;

import java.io.Serializable;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:54:15
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class ArticleVO extends AbsModel implements Serializable{

	private static final long serialVersionUID = -8835992457501540175L;

	private Integer id;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 文章缩略图
	 */
	private String thumb;
	
	/**
	 * 文章简介
	 */
	private String abstracts;
	
	/**
	 * 文章关键字
	 */
	private String keywords;
	
	/**
	 * 文章来源
	 */
	private String source;
	
	/**
	 * 文章作者
	 */
	private String author;
	
	/**
	 * 是否为推荐文章
	 */
	private Integer isRecommend;
	
	/**
	 * 是否为置顶文章
	 */
	private Integer isTop;
	
	/**
	 * 点击次数
	 */
	private Integer clickNum;
	
	/**
	 * 文章内容
	 */
	private String content;
	
	/**
	 * 文章所属栏目，封装多对一
	 */
    private ChannelVO channel;
    
    private Integer channelId;

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

	public ChannelVO getChannel() {
		return channel;
	}

	public void setChannel(ChannelVO channel) {
		this.channel = channel;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

}