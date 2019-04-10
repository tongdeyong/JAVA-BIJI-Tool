package com.deyong.javalearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 视图显示
 *
 * @author dytong 童德勇 2019/3/26 16:34
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ViewContoller {

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "add";
    }

    @GetMapping("/query")
    public String getQueryPage() {
        return "query";
    }

    @GetMapping("/detail")
    public String getDetailPage() {
        return "detail";
    }

    @GetMapping("/show")
    public String getShowPage() {
        return "show";
    }

    @GetMapping("/file")
    public String getFileUploadPage() {
        return "fileUpload";
    }
}
