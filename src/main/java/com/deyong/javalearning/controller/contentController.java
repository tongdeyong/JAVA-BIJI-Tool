package com.deyong.javalearning.controller;

import com.deyong.javalearning.controller.model.Content;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author deyong_tong 童德勇
 * @version V1.0
 * @date 2019/3/25 23:39
 */
@RestController
@RequestMapping("/content")
public class contentController {

    @PostMapping("/add")
    public Object add(@RequestBody Content content) {


        return true;
    }


}
