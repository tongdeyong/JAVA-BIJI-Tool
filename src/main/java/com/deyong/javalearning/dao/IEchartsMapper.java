package com.deyong.javalearning.dao;

import com.deyong.javalearning.service.entity.EchartsResult;

import java.util.List;

/**
 * .显示图表数据的dao层
 *
 * @author deyong_tong 童德勇 2019/4/5 11:16
 * @version V1.0
 */
public interface IEchartsMapper {

    /**
     * 查询分类类别的数量
     *
     * @return 不重复的分类和对应的数量
     */
    List<EchartsResult> queryClassQuantity();

    /**
     * 查询修改的频率，以天为单位计算
     *
     * @return 日期+数量
     */
    List<EchartsResult> queryModityFruquery();
}
