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
import com.xiudoua.micro.model.CommentVO;
import com.xiudoua.micro.service.ICommentService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:31:44
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("评论接口")
@RestController
@RequestMapping(value = "/1.0/comment")
public class CommentController {

	protected Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private ICommentService commentService;
	
	/**
	 * 分页查询
	 * @param Comment
	 * @param pageParam
	 * @return
	 */
	@ResponseBody
    @GetMapping("/page")
	@ApiOperation(value = "分页条件查询评论" ,  notes="分页条件查询评论")
	public RestJson pageGet(CommentVO comment,@PageableDefault(sort={"id"}) Pageable pageable){
		RestJson json = new RestJson();
		json.setData(this.commentService.page(comment, pageable));
		return json;
	}
	
	/**
	 * 添加一条评论
	 * @param Comment
	 * @return
	 */
	@ResponseBody
    @PostMapping("/add")
	@ApiOperation(value = "添加一条评论" ,  notes="添加一条评论")
	public RestJson addPost(@RequestBody CommentVO comment){
		RestJson json = new RestJson();
		try {
			CommentVO res = this.commentService.save(comment);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 删除一条评论
	 * @param id
	 * @return
	 */
	@ResponseBody
    @DeleteMapping("/{id}")
	@ApiOperation(value = "删除一条评论" ,  notes="删除一条评论")
	public RestJson delete(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			this.commentService.delete(id);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 修改一条评论
	 * @param Comment
	 * @return
	 */
	@ResponseBody
    @PutMapping("/update")
	@ApiOperation(value = "修改一条评论" ,  notes="修改一条评论")
	public RestJson updatePut(@RequestBody CommentVO comment){
		RestJson json = new RestJson();
		try {
			CommentVO res = this.commentService.update(comment);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询一条评论
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/{id}")
	@ApiOperation(value = "查询一条评论" ,  notes="查询一条评论")
	public RestJson detail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			CommentVO res = this.commentService.findOne(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
}