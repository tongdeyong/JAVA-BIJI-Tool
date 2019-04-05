package com.deyong.javalearning.service;

import com.deyong.javalearning.service.entity.EchartsResult;

import java.util.List;

/**
 * .查询显示图表数据的service层
 *
 * @author deyong_tong 童德勇 2019/4/5 11:53
 * @version V1.0
 */
public interface IShowEchartsService {

    /**
     * 查询分类的类别名和对应的数量
     *
     * @return 名和数量
     */
    List<EchartsResult> queryClass();

    /**
     * 查询修改的频率
     *
     * @return 修改日期和数量
     */
    List<EchartsResult> querymodify();


}
