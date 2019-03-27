package com.deyong.javalearning.controller;

import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.service.IcontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author deyong_tong 童德勇
 * @version V1.0
 * @date 2019/3/25 23:39
 */
@RestController
@RequestMapping("/content")
public class contentController {

    @Autowired
    private IcontentService contentService;
    /**
     * 添加信息
     *
     * @param content 对象
     * @return 返回信号
     */
    @PostMapping("/add")
    public Object add(Content content) {
        System.out.println(content.toString());
        contentService.add(content);
        return true;
    }


}
