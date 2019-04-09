package com.deyong.javalearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传下载处理接口
 * @author tong deyong
 */

public interface IFileUploadService {

	/**
	 * 上传文件
	 * @param files 文件
	 */
	void UploadFiles(List<MultipartFile> files);
	
	/**
	 * 下载文件
	 * @return 下载
	 */
	String DownloadFiles();
}
