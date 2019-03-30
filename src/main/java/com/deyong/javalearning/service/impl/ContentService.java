package com.deyong.javalearning.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.dao.IContentMapper;
import com.deyong.javalearning.service.IContentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 服务层
 *
 * @author dytong 童德勇 2019/3/26 18:29
 * @version 1.0
 * @since 1.0
 */
@Service("contentService")
public class ContentService implements IContentService {

    @Resource
    private IContentMapper contentMapper;

    @Override
    public void add(Content content) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastModify = simpleDateFormat.format(date);
        System.out.println(lastModify);
        content.setLastModify(lastModify);
        contentMapper.add(content);
    }

    @Override
    public List<Content> selectAll() {
        List<Content> contents = contentMapper.selectAll();
        contents.forEach(content -> content.setLastModify(getDateStr(content.getLastModify())));
        return contents;
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转成yyyy-MM-dd
     *
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd
     */
    private String getDateStr(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return dateStr.substring(0, 10);
    }

    @Override
    public void deleteOne(Integer id) {
        contentMapper.deleteOne(id);
    }

    @Override
    public List<String> selectClass() {
        return contentMapper.selectClass();
    }

    @Override
    public List<Content> selectByWord(Content content) {
        List<Content> contents = contentMapper.selectByWord(content);
        contents.forEach(backData -> backData.setLastModify(getDateStr(backData.getLastModify())));
        return contents;
    }
}
