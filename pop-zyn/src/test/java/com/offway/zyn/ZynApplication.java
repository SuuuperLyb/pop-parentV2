package com.offway.zyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.offway.common.mapper")
@MapperScan("com.offway.zyn.mapper")
@ComponentScan("com.offway.common.conf")
@ComponentScan("com.offway.zyn.config")
public class ZynApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZynApplication.class, args);
    }
}
