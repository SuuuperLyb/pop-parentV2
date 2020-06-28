package com.offway.dyh;

import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Api
@SpringBootApplication
@MapperScan("com.offway.common.mapper")
@MapperScan("com.offway.dyh.dao")
public class dyhApplication {
    public static void main(String[] args) {

        SpringApplication.run(dyhApplication.class, args);
    }
}
