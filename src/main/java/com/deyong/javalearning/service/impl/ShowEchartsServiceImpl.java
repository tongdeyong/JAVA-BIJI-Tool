package com.deyong.javalearning.service.impl;

import com.deyong.javalearning.dao.IEchartsMapper;
import com.deyong.javalearning.service.IShowEchartsService;
import com.deyong.javalearning.service.entity.EchartsResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * .查询显示echarts数据
 *
 * @author deyong_tong 童德勇 2019/4/5 12:01
 * @version V1.0
 */
@Service("ShowEchartsServiceImpl")
public class ShowEchartsServiceImpl implements IShowEchartsService {

    /**
     * 查询图标要显示的数据的dao
     */
    @Resource
    private IEchartsMapper echartsMapper;

    /**
     * 查询分类的类别名和对应的数量
     *
     * @return 名和数量
     */
    @Override
    public List<EchartsResult> queryClass() {
        return echartsMapper.queryClassQuantity();
    }

    /**
     * 查询修改的频率
     *
     * @return 修改日期和数量
     */
    @Override
    public List<EchartsResult> querymodify() {
        return echartsMapper.queryModityFruquery();
    }
}
