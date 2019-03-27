package com.deyong.javalearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author deyong_tong
 * @date 2019-03-27
 */
@SpringBootApplication
@MapperScan("com.deyong.javalearning.dao")
public class JavalearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavalearningApplication.class, args);
    }

}
