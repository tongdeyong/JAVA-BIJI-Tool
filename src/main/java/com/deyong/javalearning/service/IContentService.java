package com.deyong.javalearning.service;

import com.deyong.javalearning.controller.model.Content;

import java.util.List;

/**
 * 正文服务类
 *
 * @author dytong 童德勇 2019/3/26 18:27
 * @version 1.0
 * @since 1.0
 */
public interface IContentService {

    /**
     * 添加信息方法
     */
    void add(Content content);

    /**
     * 查询所有信息
     *
     * @return 所有信息集合
     */
    List<Content> selectAll();

    /**
     * 根据id删除一条信息
     *
     * @param id id
     */
    void deleteOne(Integer id);

    /**
     * 查询分类类别
     *
     * @return 分类集合
     */
    List<String> selectClass();

    /**
     * 模糊查询
     *
     * @param content 字段
     * @return 结果
     */
    List<Content> selectByWord(Content content);


    /**
     * 更新信息
     *
     * @param content 信息
     */
    void update(Content content);
}
