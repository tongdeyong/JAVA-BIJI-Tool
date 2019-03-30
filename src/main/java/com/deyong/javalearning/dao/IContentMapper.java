package com.deyong.javalearning.dao;

import com.deyong.javalearning.controller.model.Content;

import java.util.List;

/**
 * 持久层
 *
 * @author dytong 童德勇 2019/3/26 18:35
 * @version 1.0
 * @since 1.0
 */
public interface IContentMapper {

    /**
     * 添加一条信息
     *
     * @param contet 一条信息内容
     */
    void add(Content contet);

    /**
     * 查询所有数据
     *
     * @return 信息集合
     */
    List<Content> selectAll();

    /**
     * 根据id删除一条信息
     *
     * @param id id
     */
    void deleteOne(Integer id);

    /**
     * 查询不重复的分类类别
     *
     * @return 分类类别集合
     */
    List<String> selectClass();

    /**
     * 模糊查询
     *
     * @param content 字段
     * @return 结果
     */
    List<Content> selectByWord(Content content);
}
