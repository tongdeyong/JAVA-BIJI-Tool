package com.deyong.javalearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图显示
 *
 * @author dytong 童德勇 2019/3/26 16:34
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ViewContoller {

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }

    @RequestMapping("/add")
    public String getAddPage() {
        return "add";
    }

    @RequestMapping("/query")
    public String getQueryPage() {
        return "query";
    }

    @RequestMapping("/detail")
    public String getDetailPage() {
        return "detail";
    }

}
