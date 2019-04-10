package com.deyong.javalearning.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传下载处理接口
 * @author tong deyong
 */

public interface IFileUploadService {

	/**
	 * 上传文件
	 * @param files 文件
	 * @param fileName 文件名
	 * @param fileDescription 文件描述
	 */
	void uploadFiles(MultipartFile files, String fileName, String fileDescription);
	
	/**
	 * 下载文件
	 * @return 下载
	 */
	String downloadFiles();
}
