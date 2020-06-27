package com.offway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.offway.common.mapper")
public class PopSetupApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopSetupApplication.class, args);
    }

}
