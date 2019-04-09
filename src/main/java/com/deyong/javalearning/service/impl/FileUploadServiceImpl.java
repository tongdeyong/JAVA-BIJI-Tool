package com.deyong.javalearning.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deyong.javalearning.dao.IFilesMapper;
import com.deyong.javalearning.excption.MyException;
import com.deyong.javalearning.service.IFileUploadService;
import com.deyong.javalearning.util.DateUtil;

/**
 * 文件上传，下载实现类
 * 
 * @author tong deyong
 *
 */
@Service("fileUploadServiceImpl")
public class FileUploadServiceImpl implements IFileUploadService {

	@Resource
	private IFilesMapper iFilesMapper;

	@Override
	public void UploadFiles(List<MultipartFile> files) {
		if (files == null || files.size() == 0) {
			// 以后做抛异常和日志处理
			try {
				throw new MyException("无上传文件");
			} catch (MyException e) {
				System.out.println("没有找到上传文件！");
			}
			System.out.println("异常外面的");
			return;
		} else {
				files.forEach(multipartFile->{
					SaveFile(multipartFile);
				});
		}

	}

	private void SaveFile(MultipartFile multipartFile) {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println(fileName);
		String fileNewName = DateUtil.getDateTimeStr()+fileName.substring(fileName.indexOf("."));
		
	}

	@Override
	public String DownloadFiles() {
		return null;
	}

}
