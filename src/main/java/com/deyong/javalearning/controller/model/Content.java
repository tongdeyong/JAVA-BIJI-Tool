package com.deyong.javalearning.controller.model;

import lombok.Data;

/**
 * .正文信息
 *
 * @author deyong_tong 童德勇
 * @version V1.0
 * @date 2018-12-12
 */
@Data
public class Content {

    /**
     * id
     */
    private Integer id;

    /**
     * 分类
     */
    private String contentClass;

    /**
     * 父标题
     */
    private String parentTitle;

    /**
     * 子标题
     */
    private String subheading;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 修改日期
     */
    private String lastModifyDate;

    /**
     * 修改时间
     */
    private String lastModifyTime;

}
