package com.deyong.javalearning.controller;

import com.deyong.javalearning.service.IShowEchartsService;
import com.deyong.javalearning.service.entity.EchartsResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * .显示表数据相关
 *
 * @author deyong_tong 童德勇 2019/4/5 11:15
 * @version V1.0
 */
@RestController
@RequestMapping("/index")
public class EchartsShowController {

    /**
     * Echarts显示数据服务
     */
    @Resource(name = "ShowEchartsServiceImpl")
    private IShowEchartsService showEchartsService;

    @GetMapping("/queryClass")
    public List<EchartsResult> queryClass() {
        return showEchartsService.queryClass();
    }

    @GetMapping("/queryModifyFruquery")
    public List<EchartsResult> queryModifyFruquery() {
        return showEchartsService.querymodify();
    }


}
