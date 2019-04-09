package com.deyong.javalearning.service.entity;

import lombok.Data;

/**
 * 文件信息类
 * @author tong deyong
 *
 */
@Data
public class FilesMsg {
	
	/**
	 * id
	 */
	private int id;
	/**
	 * 文件名
	 */
	private String FileName;
	/**
	 * 文件描述
	 */
	private String FileDescription;
	/**
	 * 文件路徑
	 */
	private String FilePath;
	/**
	 * 文件尺寸
	 */
	private long FileSize; 

}
