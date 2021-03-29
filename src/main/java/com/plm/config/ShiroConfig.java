package com.plm.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // ShiroFilterFactoryBean  --->3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 关联 DefaultWebSecurityManager，设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器
        /**
         * anon: 无需认证就可访问
         * authc: 必须认证了才可访问
         * user: 必须拥有 记住我 功能才可访问
         * perms: 拥有对某个资源的权限才可访问
         * role: 拥有某个角色权限才可访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        // 拦截
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        // 授权
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        // 没有认证访问的页面
        shiroFilterFactoryBean.setLoginUrl("/");
        // 没有授权访问的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        return shiroFilterFactoryBean;

    }

    // DefaultWebSecurityManager  --->2
    // @Qualifier 限定哪个bean应该被自动注入
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // Realm --->1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    // shiro 整合 thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
