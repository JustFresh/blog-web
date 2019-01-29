package com.xiudoua.micro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.LinksVO;
import com.xiudoua.micro.service.ILinksService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 友情链接管理接口
 * @author JustFresh
 * @time 2019年1月6日 下午2:42:11
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("友情链接管理接口")
@RestController
@RequestMapping(value = "/1.0/links")
public class LinksController {

	protected Logger logger = LoggerFactory.getLogger(LinksController.class);
	
	@Autowired
	private ILinksService linksService;
	
	/**
	 * 分页查询
	 * @param User
	 * @param pageParam
	 * @return
	 */
	@ResponseBody
    @GetMapping("/page")
	@ApiOperation(value = "分页条件查询友情链接" ,  notes="分页条件查询友情链接")
	public RestJson pageGet(LinksVO user,@PageableDefault(sort={"id"}) Pageable pageable){
		RestJson json = new RestJson();
		json.setData(this.linksService.page(user, pageable));
		return json;
	}
	
	/**
	 * 添加一个友情链接
	 * @param User
	 * @return
	 */
	@ResponseBody
    @PostMapping("/add")
	@ApiOperation(value = "添加一个友情链接" ,  notes="添加一个友情链接")
	public RestJson addPost(@RequestBody LinksVO user){
		RestJson json = new RestJson();
		try {
			LinksVO res = this.linksService.save(user);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 删除一个友情链接
	 * @param id
	 * @return
	 */
	@ResponseBody
    @DeleteMapping("/{id}")
	@ApiOperation(value = "删除一个友情链接" ,  notes="删除一个友情链接")
	public RestJson delete(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			this.linksService.delete(id);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 修改一个友情链接
	 * @param User
	 * @return
	 */
	@ResponseBody
    @PutMapping("/update")
	@ApiOperation(value = "修改一个友情链接" ,  notes="修改一个友情链接")
	public RestJson updatePut(@RequestBody LinksVO user){
		RestJson json = new RestJson();
		try {
			LinksVO res = this.linksService.update(user);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询一个友情链接
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/{id}")
	@ApiOperation(value = "查询一个友情链接" ,  notes="查询一个友情链接")
	public RestJson detail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			LinksVO res = this.linksService.findOne(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
}