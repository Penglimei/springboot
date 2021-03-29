package com.plm.utils;



import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 自定义区域分解器

public class MyLocalResolver implements LocaleResolver {

    // 解析请求

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 获取请求中的语言参数链接 lan=XXX
        String lan = httpServletRequest.getParameter("lan");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lan)){
            String[] split = lan.split("_");
            // split[0]->语言 split[1]->国家
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
