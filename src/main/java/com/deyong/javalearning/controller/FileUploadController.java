package com.deyong.javalearning.controller;

import com.deyong.javalearning.service.IFileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件上传下载的控制类
 *
 * @author tong deyong
 */
@RestController
@RequestMapping("/files")
public class FileUploadController {

    @Resource
    private IFileUploadService fileUploadService;

    /**
     * 上传文件
     *
     * @return 是否成功
     */
    @PostMapping("/upload")
    public Object uploadFiles(@RequestParam("file") MultipartFile file, String fileName, String fileDescription) {
        if (fileName.isEmpty()) {
            return "文件名为空，上传失败！";
        }
        fileUploadService.uploadFiles(file, fileName, fileDescription);
        return true;
    }

}
