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
 * @desc 评论PO类
 * @author JustFresh
 * @time 2018年11月23日 下午2:11:43
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Entity
@Table(name = "XDA_BLOG_COMMENT")
public class CommentEntity extends AbsEntity{

	/**
	 * 无关自增主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true,columnDefinition="integer(11)")
	private Integer id;
	
	/**
	 * 评论用户
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_user_id",nullable = false,columnDefinition="integer(11) comment '评论用户'")
	private UserEntity fromUser;
	
	/**
	 * 被评论用户
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_user_id",nullable = false,columnDefinition="integer(11) comment '被评论用户'")
	private UserEntity toUser;
	
	/**
	 * 所属文章
	 */
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id",nullable = false,columnDefinition="integer(11) comment '所属文章'")
	private ArticleEntity article;
	
	/**
	 * 评论内容
	 */
	@Column(name = "content", nullable = false,columnDefinition="varchar(256) comment '评论内容'")
	private String content;
	
	/**
	 * 父级评论ID
	 */
	@Column(name = "parent_id",columnDefinition="integer(11) comment '父级评论ID'")
	private Integer parentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserEntity fromUser) {
		this.fromUser = fromUser;
	}

	public UserEntity getToUser() {
		return toUser;
	}

	public void setToUser(UserEntity toUser) {
		this.toUser = toUser;
	}

	public ArticleEntity getArticle() {
		return article;
	}

	public void setArticle(ArticleEntity article) {
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

}