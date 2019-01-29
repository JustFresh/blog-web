package com.xiudoua.micro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.micro.constans.CommonConstans;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.ChannelVO;
import com.xiudoua.micro.service.IChannelService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:27:38
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("栏目接口")
@RestController
@RequestMapping(value = "/1.0/channel")
public class ChannelController {

	protected Logger logger = LoggerFactory.getLogger(ChannelController.class);
	
	@Autowired
	private IChannelService channelService;
	
	/**
	 * 树形表格分页条件查询
	 * @param Channel
	 * @param pageParam
	 * @return
	 */
	@ResponseBody
    @GetMapping("/treegrid")
	@ApiOperation(value = "分页条件查询栏目" ,  notes="分页条件查询栏目")
	public RestJson pageGet(ChannelVO channel){
		RestJson json = new RestJson();
		List<ChannelVO> tree = this.channelService.getTree(channel);
		if(tree != null && tree.size() > 0){
			json.setData(tree);
		}else{
			json.setCode(CommonConstans.UNKNOWED_ERROR);
			logger.info("分页条件查询栏目失败！");
		}
		return json;
	}
	
	/**
	 * 添加一条栏目
	 * @param Channel
	 * @return
	 */
	@ResponseBody
    @PostMapping("/add")
	@ApiOperation(value = "添加一条栏目" ,  notes="添加一条栏目")
	public RestJson addPost(@RequestBody ChannelVO channel){
		RestJson json = new RestJson();
		try {
			ChannelVO res = this.channelService.save(channel);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 删除一条栏目
	 * @param id
	 * @return
	 */
	@ResponseBody
    @DeleteMapping("/{id}")
	@ApiOperation(value = "删除一条栏目" ,  notes="删除一条栏目")
	public RestJson delete(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			this.channelService.delete(id);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 修改一条栏目
	 * @param Channel
	 * @return
	 */
	@ResponseBody
    @PutMapping("/update")
	@ApiOperation(value = "修改一条栏目" ,  notes="修改一条栏目")
	public RestJson updatePut(@RequestBody ChannelVO channel){
		RestJson json = new RestJson();
		try {
			ChannelVO res = this.channelService.update(channel);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询一条栏目
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/{id}")
	@ApiOperation(value = "查询一条栏目" ,  notes="查询一条栏目")
	public RestJson detail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			ChannelVO res = this.channelService.findOne(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
}