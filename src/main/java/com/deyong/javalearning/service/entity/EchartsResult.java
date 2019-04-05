package com.deyong.javalearning.service.entity;

import lombok.Data;

/**
 * .用于接受返回数据
 *
 * @author deyong_tong 童德勇 2019/4/5 13:26
 * @version V1.0
 */
@Data
public class EchartsResult {

    /**
     * 返回的字段名
     */
    private String name;

    /**
     * 返回的数量
     */
    private Integer num;
}
