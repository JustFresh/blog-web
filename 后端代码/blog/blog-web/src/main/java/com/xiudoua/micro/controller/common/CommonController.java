package com.xiudoua.micro.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.micro.model.AdminVO;
import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.service.IAdvService;
import com.xiudoua.micro.service.IArticleService;
import com.xiudoua.micro.service.IChannelService;
import com.xiudoua.micro.service.ICommentService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 共用处理接口
 * @author JustFresh
 * @time 2018年12月19日 下午3:29:12
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("共用接口")
@RestController
@RequestMapping(value = "/1.0/commom")
public class CommonController {

	protected Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IChannelService channelService;
	
	@Autowired
	private IAdvService advService;
	
	@Autowired
	private ICommentService commentService;
	
	@ResponseBody
    @GetMapping("/homeHeaderNavs")
	@ApiOperation(value = "前端顶部导航列表" ,  notes="前端顶部导航列表")
	public RestJson homeHeaderNavs(ChannelVO channel){
		RestJson json = new RestJson();
		json.setData(this.channelService.getSelectData());
		return json;
	}
	
	@ResponseBody
    @GetMapping("/counts")
	@ApiOperation(value = "统计数量接口" ,  notes="统计数量接口")
	public RestJson pageGet(AdminVO admin,@PageableDefault(sort={"id"}) Pageable pageable){
		RestJson json = new RestJson();
		Map<String,Long> map = new HashMap<String,Long>();
		map.put("articleCount", articleService.count(null));
		map.put("channelCount", channelService.count(null));
		map.put("advCount", advService.count(null));
		map.put("commentCount", commentService.count(null));
		json.setData(map);
		return json;
	}
	
	@ResponseBody
    @GetMapping("channelArticleCount")
	@ApiOperation(value = "统计各个栏目下的文章数量", notes="统计各个栏目下的文章数量")
	public RestJson channelArticleCount(){
		RestJson json = new RestJson();
		json.setData(this.channelService.countArticles());
		return json;
	}
}