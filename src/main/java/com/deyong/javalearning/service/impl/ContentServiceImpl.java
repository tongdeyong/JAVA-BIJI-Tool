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
public class ContentServiceImpl implements IContentService {

    @Resource
    private IContentMapper contentMapper;

    @Override
    public void add(Content content) {
        content.setLastModifyDate(getDateStr(getLastModifyTime()));
        content.setLastModifyTime(getTimeStr(getLastModifyTime()));
        contentMapper.add(content);
    }


    @Override
    public List<Content> selectAll() {
        List<Content> contents = contentMapper.selectAll();
        contents.forEach(content -> content.setLastModifyDate(content.getLastModifyDate()));
        return contents;
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
        contents.forEach(backData -> backData.setLastModifyDate(backData.getLastModifyDate()));
        return contents;
    }

    @Override
    public void update(Content content) {
        content.setLastModifyDate(getDateStr(getLastModifyTime()));
        content.setLastModifyTime(getTimeStr(getLastModifyTime()));
        contentMapper.update(content);
    }

    /**
     * 获取最后修改时间
     *
     * @return 时间字符串 yyyy-MM-dd HH:mm:ss
     */
    private String getLastModifyTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
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

    /**
     * 将yyyy-MM-dd HH:mm:ss转成HH:mm:ss
     *
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return HH:mm:ss
     */
    private String getTimeStr(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return dateStr.substring(10, dateStr.length() - 1);
    }
}
