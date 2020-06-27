package com.offway.popgxb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: BootSsm
 * @description: swagger接口测试工具
 * @author: gxb
 * @create: 2019-10-21 15:01
 */
@Configuration // 配置文件
@EnableSwagger2 // 启用Swagger
public class SwaggerConfig {

    /**
     * 创建文档说明
     */
    public ApiInfo createAI() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("很潮后端接口文档").
                description("很潮项目的所有接口信息，可以查看对应的接口信息和对接口进行测试").
                contact(new Contact("gxb", "http://www.gxb.top", "gxb@163.com")).build();
        return apiInfo;
    }

    /**
     * 创建Swagger扫描信息
     */
    @Bean
    public Docket createD() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select().
                apis(RequestHandlerSelectors.basePackage("com.offway.popgxb.controller")).build();
    }
}