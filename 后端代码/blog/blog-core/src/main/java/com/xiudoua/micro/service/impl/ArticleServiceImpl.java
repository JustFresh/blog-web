package com.xiudoua.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiudoua.micro.constans.CommonConstans;
import com.xiudoua.micro.constans.ErrorCodeEnum;
import com.xiudoua.micro.dao.IArticleDao;
import com.xiudoua.micro.entity.ArticleEntity;
import com.xiudoua.micro.entity.ChannelEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.ArticleVO;
import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.service.IArticleService;
import com.xiudoua.micro.utils.CopyPropertiesUtil;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:06:07
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private IArticleDao articleDao;
	
	/** ############################# JustFresh 2018-11-24 Begin 私有帮助方法部分 ##################################### */
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private ArticleVO getVO(ArticleEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			ArticleVO vo = new ArticleVO();
			BeanUtils.copyProperties(entity, vo);
			if(entity.getChannel() != null){
				ChannelVO channelVO = new ChannelVO();
				BeanUtils.copyProperties(entity.getChannel(), channelVO);
				vo.setChannel(channelVO);
			}
			return vo;
		}
		return null;
	}
	
	/**
	 * 将视图层VO对象转换成持久化层PO对象
	 * @param vo
	 * @return
	 */
	private ArticleEntity getEntity(ArticleVO vo){
		if(vo != null){
			ArticleEntity entity = new ArticleEntity();
			BeanUtils.copyProperties(vo, entity,CopyPropertiesUtil.getNullPropertyNames(vo));
			if(vo.getChannel() != null){
				ChannelEntity channelEntity = new ChannelEntity();
				BeanUtils.copyProperties(vo.getChannel(), channelEntity);
				entity.setChannel(channelEntity);
			}
			return entity;
		}
		return null;
	}
	
	/**
	 * 通过持久化层PO对象列表转换为对应视图层VO对象列表
	 * @param entityList
	 * @return
	 */
	private List<ArticleVO> getVOList(List<ArticleEntity> entityList){
		List<ArticleVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(ArticleEntity entity : entityList){
				ArticleVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	/** ############################# JustFresh 2018-11-24 End 私有帮助方法部分 ##################################### */
	
	@Override
	public List<ArticleVO> findAll() {
		List<ArticleVO> resList = new ArrayList<>();
		List<ArticleEntity> entityList = this.articleDao.findAll();
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ARTICLE_ID_REQUIRED);
		}
		try{
			this.articleDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_ARTICLE_ERROR);
		}
	}

	@Override
	@Transactional
	public ArticleVO save(ArticleVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getTitle())){
			throw new FormException(ErrorCodeEnum.ARTICLE_TITLE_MUST_BE_NOT_NULL);
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		try {
			ArticleEntity entity = this.articleDao.save(this.getEntity(vo));
			if(entity != null && !StringUtils.isEmpty(entity.getId())){
				return this.getVO(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArticleVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.ARTICLE_ID_REQUIRED);
		}
		return this.getVO(this.articleDao.findOne(id));
	}

	@Override
	@Transactional
	public ArticleVO update(ArticleVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.ARTICLE_ID_REQUIRED);
		}
		if(StringUtils.isEmpty(vo.getTitle())){
			throw new FormException(ErrorCodeEnum.ARTICLE_TITLE_MUST_BE_NOT_NULL);
		}
		vo.setLastModifiedDate(new Date());
		ArticleEntity entity = this.articleDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public Page<ArticleVO> page(ArticleVO vo, Pageable pageable) {
		Page<ArticleEntity> page = this.articleDao.findAll(new Specification<ArticleEntity>() {
			@Override
			public Predicate toPredicate(Root<ArticleEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(vo != null){
					if(!StringUtils.isEmpty(vo.getTitle())){
	                    predicates.add(cb.like(root.get("title"), "%" + vo.getTitle() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getKeywords())){
	                    predicates.add(cb.like(root.get("keywords"), "%" + vo.getKeywords() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getSource())){
	                    predicates.add(cb.like(root.get("source"), "%" + vo.getSource() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getAuthor())){
	                    predicates.add(cb.like(root.get("author"), "%" + vo.getAuthor() + "%"));
	                }
					if(!StringUtils.isEmpty(vo.getIsRecommend())){
						predicates.add(cb.equal(root.get("isRecommend"), vo.getIsRecommend()));
					}
					if(!StringUtils.isEmpty(vo.getIsTop())){
						predicates.add(cb.equal(root.get("isTop"), vo.getIsTop()));
					}
					if(!StringUtils.isEmpty(vo.getStatus())){
						predicates.add(cb.equal(root.get("status"), vo.getStatus()));
					}
					if(!StringUtils.isEmpty(vo.getChannelId())){
						ChannelEntity channel = new ChannelEntity();
						channel.setId(vo.getChannelId());
						predicates.add(cb.equal(root.get("channel"),channel));
					}
				}
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));	
			}
			
		},pageable);
		return new PageImpl<>(getVOList(page.getContent()), pageable,page.getTotalElements());
	}

	@Override
	public Long count(ArticleVO vo) {
		Long count = this.articleDao.countByIsDelAndStatus(CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
		if(count != null){
			return count;
		}
		return 0L;
	}

	@Override
	@Transactional
	public ArticleVO homeDetail(Integer id) throws FormException {
		if(id != null){
			ArticleEntity entity = this.articleDao.findOne(id);
			if(entity != null && !StringUtils.isEmpty(entity.getId())){
				Integer clickNum = entity.getClickNum();
				ArticleVO res = this.getVO(entity);
				entity.setClickNum(clickNum + 1);
				this.articleDao.saveAndFlush(entity);
				res.setClickNum(clickNum + 1);
				return res;
			}
		}
		return null;
	}

	@Override
	public ArticleVO prevArticle(Integer id) throws FormException {
		if(id != null){
			ArticleVO vo = this.findOne(id);
			if(vo != null && vo.getId() != null){
				List<ArticleEntity> list = this.articleDao.findPrevArticle(vo.getChannel().getId(), vo.getId());
				if(list != null && !list.isEmpty()){
					return this.getVO(list.get(0));
				}
			}
		}
		return null;
	}

	@Override
	public ArticleVO nextArticle(Integer id) throws FormException {
		if(id != null){
			ArticleVO vo = this.findOne(id);
			if(vo != null && vo.getId() != null){
				List<ArticleEntity> list = this.articleDao.findNextArticle(vo.getChannel().getId(), vo.getId());
				if(list != null && !list.isEmpty()){
					return this.getVO(list.get(0));
				}
			}
		}
		return null;
	}

}