package com.xiudoua.micro.controller.layout;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.service.IChannelService;
import com.xiudoua.micro.utils.RestJson;
import com.xiudoua.micro.utils.SelectVO;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年12月14日 上午10:21:42
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("下拉菜单数据获取接口")
@RestController
@RequestMapping(value = "/1.0/admin")
public class SelectController {

	protected Logger logger = LoggerFactory.getLogger(SelectController.class);
	
	@Autowired
	private IChannelService channelService;
	
	@ResponseBody
    @GetMapping("/layout/channels")
	@ApiOperation(value = "栏目下拉菜单数据" ,  notes="栏目下拉菜单数据")
	public RestJson channelSelect(Model model){
		RestJson json = new RestJson();
		List<ChannelVO> voList = this.channelService.getSelectData();
		ChannelVO first = new ChannelVO();
		first.setChannelName("无");
		voList.add(0, first);
		json.setData(voList);
		return json;	
	}
	
	@ResponseBody
    @GetMapping("/layout/advPositions")
	@ApiOperation(value = "广告位下拉菜单数据" ,  notes="广告位下拉菜单数据")
	public RestJson advPositionSelect(){
		RestJson json = new RestJson();
		List<SelectVO> list = new ArrayList<>();
		SelectVO vo1 = new SelectVO("", "--请选择");
		SelectVO vo2 = new SelectVO("1", "首页大轮播");
		SelectVO vo3 = new SelectVO("2", "微信公众号");
		SelectVO vo4 = new SelectVO("3", "腰带轮播");
		SelectVO vo5 = new SelectVO("4", "安卓APP下载");
		SelectVO vo6 = new SelectVO("5", "苹果APP下载");
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		json.setData(list);
		return json;
	}
	
	@ResponseBody
    @GetMapping("/layout/advTypes")
	@ApiOperation(value = "广告类型下拉菜单数据" ,  notes="广告类型下拉菜单数据")
	public RestJson advTypeSelect(){
		RestJson json = new RestJson();
		List<SelectVO> list = new ArrayList<>();
		SelectVO vo1 = new SelectVO("", "--请选择");
		SelectVO vo2 = new SelectVO("1", "PC端");
		SelectVO vo3 = new SelectVO("2", "APP端");
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		json.setData(list);
		return json;
	}
	
}