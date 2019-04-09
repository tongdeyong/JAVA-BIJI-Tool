package com.deyong.javalearning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传下载的控制类
 * @author tong deyong
 *
 */
@RestController
public class FileUploadController {
	
	/**
	 * 上传文件
	 * @return 是否成功
	 */
	@PostMapping
	public Object UploadFiles(@RequestParam("files") List<MultipartFile> files) {
		
		return true;
	}

}
