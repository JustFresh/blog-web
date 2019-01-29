package com.xiudoua.micro.model;

import java.io.Serializable;
import java.util.List;

import com.xiudoua.micro.model.basic.AbsModel;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午4:48:54
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class CommentVO extends AbsModel implements Serializable{

	private static final long serialVersionUID = -2071035860394793268L;

	private Integer id;
	
	/**
	 * 评论用户
	 */
	private UserVO fromUser;
	
	/**
	 * 被评论用户
	 */
	private UserVO toUser;
	
	/**
	 * 所属文章
	 */
	private ArticleVO article;
	
	/**
	 * 评论内容
	 */
	private String content;
	
	/**
	 * 父级评论ID
	 */
	private Integer parentId;
	
	private List<CommentVO> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserVO getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserVO fromUser) {
		this.fromUser = fromUser;
	}

	public UserVO getToUser() {
		return toUser;
	}

	public void setToUser(UserVO toUser) {
		this.toUser = toUser;
	}

	public ArticleVO getArticle() {
		return article;
	}

	public void setArticle(ArticleVO article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<CommentVO> getChildren() {
		return children;
	}

	public void setChildren(List<CommentVO> children) {
		this.children = children;
	}
	
}