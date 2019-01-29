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
import com.xiudoua.micro.model.ArticleVO;
import com.xiudoua.micro.service.IArticleService;
import com.xiudoua.micro.utils.RestJson;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:26:02
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("文章接口")
@RestController
@RequestMapping(value = "/1.0/article")
public class ArticleController {

	protected Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private IArticleService ArticleService;
	
	/**
	 * 分页查询
	 * @param Article
	 * @param pageParam
	 * @return
	 */
	@ResponseBody
    @GetMapping("/page")
	@ApiOperation(value = "分页条件查询文章" ,  notes="分页条件查询文章")
	public RestJson pageGet(ArticleVO article,@PageableDefault(sort={"id"}) Pageable pageable){
		RestJson json = new RestJson();
		json.setData(this.ArticleService.page(article,pageable));
		return json;
	}
	
	/**
	 * 添加一条文章
	 * @param Article
	 * @return
	 */
	@ResponseBody
    @PostMapping("/add")
	@ApiOperation(value = "添加一条文章" ,  notes="添加一条文章")
	public RestJson addPost(@RequestBody ArticleVO article){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.save(article);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 删除一条文章
	 * @param id
	 * @return
	 */
	@ResponseBody
    @DeleteMapping("/{id}")
	@ApiOperation(value = "删除一条文章" ,  notes="删除一条文章")
	public RestJson delete(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			this.ArticleService.delete(id);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 修改一条文章
	 * @param Article
	 * @return
	 */
	@ResponseBody
    @PutMapping("/update")
	@ApiOperation(value = "修改一条文章" ,  notes="修改一条文章")
	public RestJson updatePut(@RequestBody ArticleVO article){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.update(article);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询一条文章
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/{id}")
	@ApiOperation(value = "查询一条文章" ,  notes="查询一条文章")
	public RestJson detail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.findOne(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 通过前端页面点击一次查询文章详情请求，点击量应该加一
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/home/{id}")
	@ApiOperation(value = "通过前端页面点击一次查询文章详情请求" ,  notes="通过前端页面点击一次查询文章详情请求")
	public RestJson homeDetail(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.homeDetail(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}

	/**
	 * 查询指定id对应文章的前一篇（同一栏目）
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/prev/{id}")
	@ApiOperation(value = "查询指定id对应文章的前一篇" ,  notes="查询指定id对应文章的前一篇")
	public RestJson prevArticle(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.prevArticle(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}
	
	/**
	 * 查询指定id对应文章的下一篇（同一栏目）
	 * @param id
	 * @return
	 */
	@ResponseBody
    @GetMapping("/next/{id}")
	@ApiOperation(value = "查询指定id对应文章的下一篇" ,  notes="查询指定id对应文章的下一篇")
	public RestJson nextArticle(@PathVariable(value = "id") Integer id){
		RestJson json = new RestJson();
		try {
			ArticleVO res = this.ArticleService.nextArticle(id);
			json.setData(res);
		} catch (FormException e) {
			logger.error(e.getErrorEnum().message(),e);
			json.setCode(e.getErrorEnum().code());
			json.setMsg(e.getErrorEnum().message());
		}
		return json;
	}

}