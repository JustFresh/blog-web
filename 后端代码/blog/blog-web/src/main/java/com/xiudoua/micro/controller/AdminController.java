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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.AdminVO;
import com.xiudoua.micro.service.IAdminService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:16:38
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("管理员接口")
@RestController
@RequestMapping(value = "/1.0/admin")
public class AdminController {

	protected Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private IAdminService adminService;
	
	/**
	 * 分页查询
	 * @param admin
	 * @param pageParam
	 * @return
	 */
	@ResponseBody
    @GetMapping("/page")
	@ApiOperation(value = "分页条件查询管理员" ,  notes="分页条件查询管理员")
	public RestJson pageGet(AdminVO admin,@PageableDefault(sort={"id"}) Pageable pageable){
		RestJson json = new RestJson();
		json.setData(this.adminService.page(admin, pageable));
		return json;
	}
	
	/**
	 * 添加一个管理员
	 * @param admin
	 * @return
	 */
	@ResponseBody
    @PostMapping("/add")
	@ApiOperation(value = "添加一个管理员" ,  notes="添加一个管理员")
	public RestJson addPost(@RequestBody AdminVO admin){
		RestJson json = new RestJson();
		try {
			AdminVO res = this.adminService.save(admin);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 删除一个管理员
	 * @param id
	 * @return
	 */
	@ResponseBody
    @DeleteMapping("/{id}")
	@ApiOperation(value = "删除一个管理员" ,  notes="删除一个管理员")
	public RestJson delete(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			this.adminService.delete(id);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 修改一个管理员
	 * @param admin
	 * @return
	 */
	@ResponseBody
    @PutMapping("/update")
	@ApiOperation(value = "修改一个管理员" ,  notes="修改一个管理员")
	public RestJson updatePut(@RequestBody AdminVO admin){
		RestJson json = new RestJson();
		try {
			AdminVO res = this.adminService.update(admin);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询一个管理员
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/{id}")
	@ApiOperation(value = "查询一个管理员" ,  notes="查询一个管理员")
	public RestJson detail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			AdminVO res = this.adminService.findOne(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
    @GetMapping("/login")
	@ApiOperation(value = "管理员登录" ,  notes="管理员登录")
	public RestJson login(@RequestParam("username") String username,@RequestParam("password")String password){
		RestJson json = new RestJson();
		try {
			AdminVO res = this.adminService.login(username,password);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
}