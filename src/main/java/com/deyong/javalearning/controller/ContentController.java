package com.deyong.javalearning.controller;

import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.excption.MyExcption;
import com.deyong.javalearning.service.IContentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * .正文控制
 *
 * @author deyong_tong 童德勇 2019/3/25 23:39
 * @version V1.0
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Resource
    private IContentService contentService;

    /**
     * 添加信息
     *
     * @param content 对象
     * @return 返回信号
     */
    @PostMapping("/add")
    public Object add(Content content) {
        contentService.add(content);
        return true;
    }

    /**
     * 查询所有信息
     *
     * @return 所有信息集合
     */
    @GetMapping("/selectAll")
    public List<Content> selectAll() {
        return contentService.selectAll();
    }

    /**
     * 删除一条信息
     *
     * @param id 要删除信息的id
     * @return 返回是否删除
     */
    @GetMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable(name = "id") String id) {
        if (StringUtils.isEmpty(id)) {
            return "接收到的id值为空！";
        }
        contentService.deleteOne(Integer.valueOf(id));
        return "true";
    }

    /**
     * 查询分类类别，用于添加页面中的展示
     *
     * @return 分类集合
     */
    @GetMapping("/queryClass")
    public List<String> selectClass() {
        return contentService.selectClass();
    }
}
