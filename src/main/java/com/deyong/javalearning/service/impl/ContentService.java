package com.deyong.javalearning.service.impl;

import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.dao.IContentMapper;
import com.deyong.javalearning.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *服务层
 *
 * @author dytong 童德勇 2019/3/26 18:29
 * @version 1.0
 * @since 1.0
 */
@Service
public class ContentService implements IContentService {

    @Autowired
    private IContentMapper contentMapper;

    @Override
    public void add(Content content) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String lastModify = simpleDateFormat.format(date);
        content.setLastModify(lastModify);
        contentMapper.add(content);
    }
}
