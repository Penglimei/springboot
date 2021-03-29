package com.plm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2     // 开启Swagger
public class SwaggerConfig {

    // 分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("zs");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("ww");
    }


    // 配置 Swagger 的 Docket 的 Bean 实例
    @Bean
    public Docket docket(Environment environment){

        /**
         * 根据不同配置版本选择是否开启Swagger
         */
        // 设置要开启Swagger的配置版本
        Profiles profiles = Profiles.of("dev", "test");
        // 通过 environment.acceptsProfiles() 判断是否处在设定的开启Swagger的配置版本中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                /**
                 * enable() 是否启用Swagger,false为不启用
                 */
                .enable(true)
                .groupName("plm")
                .select()
                /**
                 * RequestHandlerSelectors  配置要扫描接口的方式
                 *  ---basePackage  指定要扫描的包
                 *  ---withClassAnnotation  扫描类上的注解，参数是一个注解的反射对象
                 *  ---withMethodAnnotation 扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.plm.controller"))
                /**
                 * paths()    过滤带有 /plm/** 路径的方法
                 */
                .paths(PathSelectors.ant("/plm/**"))
                .build();
    }

    // 配置 Swagger 信息
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("彭彭啊",
                "https://github.com/Penglimei/Penglimei.github.io.git",
                "xxx@qq.com");
        return new ApiInfo("Pp's Swaggger Api document",
                "Api Documentation",
                "1.0",
                "https://github.com/Penglimei/Penglimei.github.io.git",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
