package com.plm.config;

import com.plm.utils.LoginHandlerIntercepter;
import com.plm.utils.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// SpringBoot扩展SpringMVC

@Configuration
public class myMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置一个视图映射
        // 既保留了自动配置，也能用我们扩展的配置
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        // 用于隐藏数据传输路径
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    // 往容器中注册 自定义的国际化组件MyLocaleResolver

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    // 将自定义拦截器LoginHandlerIntercepter 注册到容器中

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // "/"表示绝对路径,从根路径开始去寻找资源；“/*”会匹配这个目录下的子女节点；"/**"会匹配这个目录下的所有后代节点
//        registry.addInterceptor(new LoginHandlerIntercepter())
//                .addPathPatterns("/*")
//                .excludePathPatterns("/index.html","/","user/login","/asserts/**");
//    }
}
