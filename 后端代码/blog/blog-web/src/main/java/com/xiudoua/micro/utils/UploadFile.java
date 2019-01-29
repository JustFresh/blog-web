package com.xiudoua.micro.utils;

import com.xiudoua.micro.constans.UploadStateEnum;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 用于封装文件上传的Java类
 * @author: JustFresh
 * @date: 2018年7月8日 下午1:19:40 
 * @version: beta1.1
 */
public class UploadFile {

	private String fileName;//上传文件名称
	
	private String fileSuffix;//上传文件后缀
	
	private String filePath;//上传文件存储路径
	
	private UploadStateEnum state = UploadStateEnum.UPLOAD_SUCCSSS;//枚举类型上传文件状态

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public UploadStateEnum getState() {
		return state;
	}

	public void setState(UploadStateEnum state) {
		this.state = state;
	}
	
}