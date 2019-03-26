/*
 * Copyright(c): 2018 中国民航信息网络股份有限公司 All rights reserved.
 * 密级：CONFIDENTIAL
 * 项目名称：新一代航空公司业务前端
 * 模块名称：ancillary-service
 * 文件名称：FlightPO
 * 创建日期：2019-03-14
 * 注意：本内容仅限于中国民航信息网络股份有限公司内部传阅，禁止外泄以及用于其他的商业目的.
 */
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
