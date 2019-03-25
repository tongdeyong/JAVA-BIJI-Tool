package com.deyong.javalearning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author deyong_tong 童德勇
 * @version V1.0
 * @date 2019/3/25 21:37
 */
@RestController
public class demo {

    @RequestMapping("/")
    String home() {
        return "hello!";
    }
}
