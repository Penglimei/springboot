//package com.plm.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DruidConfig {
//
//    @ConfigurationProperties(prefix = "spring.databsource")
//    @Bean
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//
//    // druid后台监控功能
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
//        // 增加后台登录账户密码
//        HashMap<String,String> initParameters = new HashMap<String,String> ();
//        initParameters.put("loginUsername","admin");
//        initParameters.put("loginPassword","123456");
//        // 允许谁访问
//        initParameters.put("allow","");
//        // 禁止谁访问
////        initParameters.put("pp","192.168.11.123");
//        bean.setInitParameters(initParameters);
//        return bean;
//    }
//
//    // 过滤器
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean bean = new FilterRegistrationBean<>();
//        bean.setFilter((new WebStatFilter()));
//        // 可以过滤那些请求
//        Map<String,String> initParameter = new HashMap<>();
//        // 此路径下的文件不会被拦截
//        initParameter.put("exclusion","*.js,*.css,/druid/*");
//        bean.setInitParameters(initParameter);
//        return bean;
//    }
//}
