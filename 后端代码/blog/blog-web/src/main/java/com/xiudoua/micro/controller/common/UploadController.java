package com.xiudoua.micro.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xiudoua.micro.utils.RestJson;
import com.xiudoua.micro.utils.UploadFile;
import com.xiudoua.micro.utils.UploadFileTool;

/**
 * 
 * @desc 文件上传下载接口
 * @author JustFresh
 * @time 2018年12月17日 上午9:26:32
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Api("文件上传下载接口")
@RestController
@RequestMapping(value = "/1.0/upload")
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Value("${spring.http.multipart.location}")
	private String UPLOAD_LOCATION_BASE;
	
	@Value("${upload.file.location.relative}")
	private String UPLOAD_FILE_LOCATION_RELATIVE;//上传文件相对访问地址
	
	/**
	 * 上传图片
	 */
	@ApiOperation(value = "上传图片" ,  notes="上传图片")
	@RequestMapping(value = "/image",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public RestJson uploadImg(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request, HttpSession session){
		if(UPLOAD_FILE_LOCATION_RELATIVE == null || "".equals(UPLOAD_FILE_LOCATION_RELATIVE)){
			UPLOAD_FILE_LOCATION_RELATIVE = "/Uploads";
		}
		RestJson json = new RestJson();
		try {
			UploadFile upload = UploadFileTool.upload(UPLOAD_LOCATION_BASE,UPLOAD_FILE_LOCATION_RELATIVE,file, "images", request, session);
			json = UploadFileTool.getJsonByStatus(upload);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("上传图片出现输入输出错误：",e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传图片出现错误：",e);
		}
		return json;
	}
	
	/**
	 * 上传Excel文件
	 */
	@ApiOperation(value = "上传Excel文件" ,  notes="上传Excel文件")
	@RequestMapping(value = "/excel",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public RestJson uploadExcel(@RequestParam(value = "file", required = false) CommonsMultipartFile file,HttpServletRequest request, HttpSession session){
		if(UPLOAD_FILE_LOCATION_RELATIVE == null || "".equals(UPLOAD_FILE_LOCATION_RELATIVE)){
			UPLOAD_FILE_LOCATION_RELATIVE = "/Uploads";
		}
		RestJson json = new RestJson();	
		try {
			UploadFile upload = UploadFileTool.upload(UPLOAD_LOCATION_BASE,UPLOAD_FILE_LOCATION_RELATIVE,file, "excel", request, session);
			json = UploadFileTool.getJsonByStatus(upload);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("上传Excel出现输入输出错误：",e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传Excel出现错误：",e);
		}
		return json;
	}
	
	/**
	 * 上传其他文件
	 */
	@ApiOperation(value = "上传其他文件" ,  notes="上传其他文件")
	@RequestMapping(value = "/file",headers = "Accept=application/json",produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public RestJson uploadFile(@RequestParam(value = "file", required = false) CommonsMultipartFile file,HttpServletRequest request, HttpSession session){
		if(UPLOAD_FILE_LOCATION_RELATIVE == null || "".equals(UPLOAD_FILE_LOCATION_RELATIVE)){
			UPLOAD_FILE_LOCATION_RELATIVE = "/Uploads";
		}
		RestJson json = new RestJson();	
		try {
			UploadFile upload = UploadFileTool.upload(UPLOAD_LOCATION_BASE,UPLOAD_FILE_LOCATION_RELATIVE,file, "files", request, session);
			json = UploadFileTool.getJsonByStatus(upload);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("上传文件出现输入输出错误：",e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传文件出现错误：",e);
		}
		return json;
	}
	
}