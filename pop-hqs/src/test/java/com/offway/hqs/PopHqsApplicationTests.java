package com.offway.hqs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.offway.common.mapper")
@MapperScan("com.offway.hqs.dao")
@ComponentScan("com.offway.common.conf")
@ComponentScan("com.offway.hqs.config")
public class PopHqsApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(PopHqsApplicationTests.class, args);
    }

}
