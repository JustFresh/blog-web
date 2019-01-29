package com.xiudoua.micro.utils;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.xiudoua.micro.constans.ErrorCodeEnum;
import com.xiudoua.micro.constans.UploadStateEnum;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 
 * @author: JustFresh
 * @date: 2018年7月8日 下午1:46:48 
 * @version: beta1.1
 */
public class UploadFileTool {
	
	/**
	 * 
	 * @param uplaodLocationBase 上传文件基本路径
	 * @param file
	 * @param fileType 上传文件类型：images 图片 、 excel 、 其他
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static UploadFile upload(String uplaodLocationBase,String locationRelative,MultipartFile file,String fileType,HttpServletRequest request, HttpSession session) throws IOException, Exception{
		if(fileType == null || "".equals(fileType)){
			fileType = "images";
		}
		String dirPath = request.getParameter("dirPath");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String month = now.get(Calendar.MONTH) + 1 < 10 ? "0" + (now.get(Calendar.MONTH) + 1) : now.get(Calendar.MONTH) + 1 + "";
		String day = now.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + now.get(Calendar.DAY_OF_MONTH) : now.get(Calendar.DAY_OF_MONTH) + "";
		String hour = now.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + now.get(Calendar.HOUR_OF_DAY) : now.get(Calendar.HOUR_OF_DAY) + "";
		String minite = now.get(Calendar.MINUTE) < 10 ? "0" + now.get(Calendar.MINUTE) : now.get(Calendar.MINUTE) + "";
		String second = now.get(Calendar.SECOND) < 10 ? "0" + now.get(Calendar.SECOND) : now.get(Calendar.SECOND) + "";
		String filePath = null;
		if(dirPath == null){
			filePath = "/" + fileType + "/default/" + year + "/" + month + "/" + day;
			dirPath = uplaodLocationBase +  "/" + fileType + "/default/" + year + "/" + month + "/" + day;
		}else{
			filePath = "/" + fileType + "/" + dirPath + "/" + year + "/" + month + "/" + day;
			dirPath = uplaodLocationBase +  "/" + fileType + "/" + dirPath + "/" + year + "/" + month + "/" + day;
		}
		String fileName = file.getOriginalFilename();
		// 获取文件后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		fileName = year + month + day + hour + minite + second + suffix;
		UploadFile uploadFile = new UploadFile();
		uploadFile.setFileName(fileName);
		uploadFile.setFileSuffix(suffix);
		uploadFile.setFilePath(locationRelative + filePath + "/" + fileName);
//		dirPath = request.getSession().getServletContext().getRealPath("/") + dirPath;
		String[] allowTypes = {"gif", "jpeg", "png", "jpg",};
		UploadStateEnum state = UploadFileUtils.upload4Stream(fileName,dirPath, file.getInputStream(),allowTypes);
		uploadFile.setState(state);
		return uploadFile;
	}
	
	/**
	 * 根据上传状态封装返回的Json格式数据
	 * @param upload
	 * @return
	 */
	public static RestJson getJsonByStatus(UploadFile upload){
		UploadStateEnum state = upload.getState();
		RestJson json = new RestJson();
		if(state == UploadStateEnum.UPLOAD_SUCCSSS){
			json.setData(upload);
			json.setMsg("上传完毕");
			json.setCode(ErrorCodeEnum.SUCCESS.code());
		}else if(state == UploadStateEnum.UPLOAD_TYPE_ERROR){
			json.setCode(ErrorCodeEnum.UPLOAD_FORMAT_IS_WRONG.code());
			json.setMsg(ErrorCodeEnum.UPLOAD_FORMAT_IS_WRONG.message());
		}else if(state == UploadStateEnum.UPLOAD_FAILURE){
			json.setCode(ErrorCodeEnum.UPLOAD_FAILURE.code());
			json.setMsg(ErrorCodeEnum.UPLOAD_FAILURE.message());
		}else if(state == UploadStateEnum.UPLOAD_ZEROSIZE){
			json.setCode(ErrorCodeEnum.UPLOAD_FILE_MUST_BE_NOT_NULL.code());
			json.setMsg(ErrorCodeEnum.UPLOAD_FILE_MUST_BE_NOT_NULL.message());
		}else if(state == UploadStateEnum.UPLOAD_OVERSIZE){
			json.setCode(ErrorCodeEnum.UPLOADING_FILE_IS_TOO_BIG.code());
			json.setMsg(ErrorCodeEnum.UPLOADING_FILE_IS_TOO_BIG.message());
		}
		return json;
	}
	
}