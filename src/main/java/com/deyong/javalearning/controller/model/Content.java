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

    private Integer id;

    private String contentClass;

    private String parentTitle;

    private String subheading;

    private String description;

    private String lastModify;

}
