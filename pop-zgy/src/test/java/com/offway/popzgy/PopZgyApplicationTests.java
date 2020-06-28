package com.offway.popzgy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //启用事务
@SpringBootApplication
@MapperScan("com.offway.common.mapper")
@MapperScan("com.offway.popzgy.dao")
@ComponentScan("com.offway.common.conf")
@ComponentScan("com.offway.common.entity")
@ComponentScan("com.offway.popzgy.dto")
class PopZgyApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(PopZgyApplicationTests.class,args);
    }
}
