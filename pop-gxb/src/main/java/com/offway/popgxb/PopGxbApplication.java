package com.offway.popgxb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @PackgeName: com.offway.popgxb
 * @ClassName: PopGxbApplication
 * @Author: gxb
 * Date: 2020/6/26 12:18:28
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@SpringBootApplication
// @ComponentScan("com.offway.common.conf")
@MapperScan(basePackages = "com.offway.common.mapper") // 扫描公共类中的 用mybatisplus生成的mapper类 相当于dao层
@MapperScan(basePackages = "com.offway.popgxb.dao") // 扫描自己的dao层 并获得xml文件
public class PopGxbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PopGxbApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PopGxbApplication.class);
    }

}
