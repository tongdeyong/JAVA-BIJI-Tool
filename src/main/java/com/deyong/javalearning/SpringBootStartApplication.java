package com.deyong.javalearning;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 *
 * @author dytong 童德勇 2019/3/27 10:07
 * @version 1.0
 * @since 1.0
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(JavalearningApplication.class);
    }
}
