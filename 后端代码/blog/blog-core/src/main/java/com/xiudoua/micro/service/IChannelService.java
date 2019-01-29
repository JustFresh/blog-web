package com.xiudoua.micro.service;

import java.util.List;
import java.util.Map;

import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.utils.ChannelCountVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:02:33
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public interface IChannelService extends IBaseService<ChannelVO>{

	/**
	 * 
	 * @param vo
	 * @return
	 */
	List<ChannelVO> getTree(ChannelVO vo);
	
	/**
	 * 获取前端所需下拉菜单筛选数据
	 * @return
	 */
	List<ChannelVO> getSelectData();
	
	/**
	 * 统计数量
	 * @param vo
	 * @return
	 */
	Long count(ChannelVO vo);
	
	/**
	 * 统计各个栏目下的文章数量
	 * @return
	 */
	Map<String,ChannelCountVO> countArticles();
}