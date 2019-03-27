package com.deyong.javalearning.service.impl;

import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.dao.IcontentMapper;
import com.deyong.javalearning.service.IcontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dytong 童德勇 2019/3/26 18:29
 * @version ancillary-3.3.6.0
 * @since ancillary-3.3.6.0
 */
@Service
public class ContentService implements IcontentService {

    @Autowired
    private IcontentMapper contentMapper;

    @Override
    public void add(Content content) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String lastModify = simpleDateFormat.format(date);
        System.out.println(lastModify);
        content.setLastModify(lastModify);
        contentMapper.add(content);
    }
}
