package com.deyong.javalearning.service.entity;

import lombok.Data;

/**
 * 文件信息类
 *
 * @author tong deyong
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
    private String fileName;
    /**
     * 文件描述
     */
    private String fileDescription;
    /**
     * 文件路徑
     */
    private String filePath;
    /**
     * 文件尺寸
     */
    private long fileSize;

    /**
     * 有意空构造
     */
    public FilesMsg() {
    }

    /**
     * 全构造方法
     */
    public FilesMsg(String fileName, String fileDescription, String filePath, long fileSize) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}
