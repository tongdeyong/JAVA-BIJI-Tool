package com.deyong.javalearning.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import com.deyong.javalearning.service.entity.FilesMsg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deyong.javalearning.dao.IFilesMapper;
import com.deyong.javalearning.service.IFileUploadService;
import com.deyong.javalearning.util.DateUtil;

/**
 * 文件上传，下载实现类
 *
 * @author tong deyong
 */
@Service("fileUploadServiceImpl")
public class FileUploadServiceImpl implements IFileUploadService {

    @Resource
    private IFilesMapper filesMapper;

    @Override
    public void uploadFiles(MultipartFile file, String fileName, String fileDescription) {
        if (!file.isEmpty()) {
            saveFile(file, fileName, fileDescription);
        }
        System.out.println("文件保存！");
    }

    /*文件保存*/
    private void saveFile(MultipartFile multipartFile, String fileName, String fileDescription) {

        String path = System.getProperty("user.dir") + "\\files\\" + getNewName(multipartFile);
        try {
            multipartFile.transferTo(new File(path));
            filesMapper.insertFileMsg(new FilesMsg(fileName, fileDescription, path, multipartFile.getSize()));
        } catch (IOException e) {
            System.out.println("跑一个异常");
        }
    }

    @Override
    public String downloadFiles() {
        return null;
    }

    /**
     * 创建文件的新名称
     *
     * @param file 文件名
     * @return 新文件名 时间戳+类型后缀
     */
    private String getNewName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        return DateUtil.getDateTimeStr() + originalFilename.substring(originalFilename.indexOf("."));
    }

}
