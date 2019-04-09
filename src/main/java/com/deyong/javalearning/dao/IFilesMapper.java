package com.deyong.javalearning.dao;

import com.deyong.javalearning.service.entity.FilesMsg;

/**
 * 文件上传/下载dao层接口
 * @author tong deyong
 */
public interface IFilesMapper {
	
	void insertFileMsg(FilesMsg fileMsg);

}
