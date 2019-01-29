package com.xiudoua.micro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xiudoua.micro.constans.CommonConstans;
import com.xiudoua.micro.constans.ErrorCodeEnum;
import com.xiudoua.micro.dao.IArticleDao;
import com.xiudoua.micro.dao.IChannelDao;
import com.xiudoua.micro.entity.ChannelEntity;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.service.IChannelService;
import com.xiudoua.micro.utils.ChannelCountVO;
import com.xiudoua.micro.utils.CopyPropertiesUtil;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:07:03
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Service
public class ChannelServiceImpl implements IChannelService{
	
	@Autowired
	private IChannelDao channelDao;
	
	@Autowired
	private IArticleDao articleDao;
	
	/** ############################# JustFresh 2018-11-24 Begin 私有帮助方法部分 ##################################### */
	
	/**
	 * 将持久化层PO对象转换成视图层VO对象
	 * @param entity
	 * @return
	 */
	private ChannelVO getVO(ChannelEntity entity){
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			ChannelVO vo = new ChannelVO();
			BeanUtils.copyProperties(entity, vo);
			return vo;
		}
		return null;
	}
	
	/**
	 * 将视图层VO对象转换成持久化层PO对象
	 * @param vo
	 * @return
	 */
	private ChannelEntity getEntity(ChannelVO vo){
		if(vo != null){
			ChannelEntity entity = new ChannelEntity();
			BeanUtils.copyProperties(vo, entity,CopyPropertiesUtil.getNullPropertyNames(vo));
			return entity;
		}
		return null;
	}
	
	/**
	 * 通过持久化层PO对象列表转换为对应视图层VO对象列表
	 * @param entityList
	 * @return
	 */
	private List<ChannelVO> getVOList(List<ChannelEntity> entityList){
		List<ChannelVO> resList = new ArrayList<>();
		if(entityList != null && !entityList.isEmpty()){
			for(ChannelEntity entity : entityList){
				ChannelVO vo = this.getVO(entity);
				resList.add(vo);
			}
		}
		return resList;
	}
	
	/**
	 * 将列表数据转换为自关联树形结构数据
	 * @param list
	 * @return
	 */
	private List<ChannelVO> list2Tree(List<ChannelEntity> list) {
		if(list != null && !list.isEmpty()){
			List<ChannelVO> treeNodes = this.getVOList(list);
			List<ChannelVO> trees = new ArrayList<>();
	        for(ChannelVO treeNode : treeNodes) {
	            if(treeNode.getParentId() == null) {
	                //如果是1级节点，则调用查找对应子节点方法
	                trees.add(findChildren(treeNode,treeNodes));
	            }
	        }
	        return trees;
		}
		return null;
	}
	
	/**
	 * 
	 * @param treeNode
	 * @param tempList
	 * @return
	 */
	private ChannelVO findChildren(ChannelVO treeNode, List<ChannelVO> treeNodes) {
		for(ChannelVO it : treeNodes) {
            if(treeNode.getId().equals(it.getParentId())) {
                //如果当前节点为对应节点的子节点
                if(treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<ChannelVO>());
                }
                //递归查找当前节点的子节点存入
                treeNode.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return treeNode;
	}

	/** ############################# JustFresh 2018-11-24 End 私有帮助方法部分 ##################################### */

	@Override
	public List<ChannelVO> findAll() {
		List<ChannelVO> resList = new ArrayList<>();
		List<ChannelEntity> entityList = this.channelDao.findByStatus(CommonConstans.STATUS_ACTIVE);
		if(entityList != null && !entityList.isEmpty()){
			resList = this.getVOList(entityList);
		}
		return resList;
	}

	@Override
	@Transactional
	public void delete(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.CHANNEL_ID_REQUIRED);
		}
		try{
			this.channelDao.delete(id);
		}catch(Exception e){
			throw new FormException(ErrorCodeEnum.DELETE_CHANNEL_ERROR);
		}
	}

	@Override
	@Transactional
	public ChannelVO save(ChannelVO vo) throws FormException {
		if(StringUtils.isEmpty(vo.getChannelName())){
			throw new FormException(ErrorCodeEnum.CHANNEL_NAME_MUST_BE_NOT_NULL);
		}
		vo.setCreateTime(new Date());
		vo.setStatus(CommonConstans.STATUS_ACTIVE);
		vo.setIsDel(CommonConstans.IS_DEL_NO);
		ChannelEntity entity = this.channelDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public ChannelVO findOne(Integer id) throws FormException {
		if(StringUtils.isEmpty(id)){
			throw new FormException(ErrorCodeEnum.CHANNEL_ID_REQUIRED);
		}
		return this.getVO(this.channelDao.findOne(id));
	}

	@Override
	@Transactional
	public ChannelVO update(ChannelVO vo) throws FormException {
		if(vo == null || StringUtils.isEmpty(vo.getId())){
			throw new FormException(ErrorCodeEnum.CHANNEL_ID_REQUIRED);
		}
		if(StringUtils.isEmpty(vo.getChannelName())){
			throw new FormException(ErrorCodeEnum.CHANNEL_NAME_MUST_BE_NOT_NULL);
		}
		vo.setLastModifiedDate(new Date());
		ChannelEntity entity = this.channelDao.save(this.getEntity(vo));
		if(entity != null && !StringUtils.isEmpty(entity.getId())){
			return this.getVO(entity);
		}
		return null;
	}

	@Override
	public List<ChannelVO> getTree(ChannelVO vo) {
		try {
			List<ChannelEntity> list = this.channelDao.findAll(new Specification<ChannelEntity>() {
				@Override
				public Predicate toPredicate(Root<ChannelEntity> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> predicates = new ArrayList<>();
					if(vo != null){
						if(!StringUtils.isEmpty(vo.getChannelName())){
		                    predicates.add(cb.like(root.get("channelName"), "%" + vo.getChannelName() + "%"));
		                }
						if(!StringUtils.isEmpty(vo.getIsBlank())){
							predicates.add(cb.equal(root.get("isBlank"), vo.getIsBlank()));
						}
						if(!StringUtils.isEmpty(vo.getStatus())){
							predicates.add(cb.equal(root.get("status"), vo.getStatus()));
						}
					}
	                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				}
			});
			if(list != null && !list.isEmpty()){
				return this.list2Tree(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<ChannelVO> getSelectData() {
		return this.getVOList(this.channelDao.findByParentIdIsNull());
	}

	@Override
	public Long count(ChannelVO vo) {
		Long count = this.channelDao.countByIsDelAndStatus(CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
		if(count != null){
			return count;
		}
		return 0L;
	}

	@Override
	public Map<String, ChannelCountVO> countArticles() {
		List<ChannelVO> list = this.findAll();
		if(list != null && !list.isEmpty()){
			Map<String, ChannelCountVO> resMap = new HashMap<>();
			for(ChannelVO vo : list){
				Long count = this.articleDao.countByChannelAndIsDelAndStatus(getEntity(vo),CommonConstans.IS_DEL_NO, CommonConstans.STATUS_ACTIVE);
				ChannelCountVO countVO = new ChannelCountVO(vo.getId(),vo.getChannelName(),count);
				resMap.put(vo.getChannelName(), countVO);
			}
			return resMap;
		}
		return null;
	}

}