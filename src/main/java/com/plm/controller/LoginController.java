package com.plm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
//        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        }else {
//            model.addAttribute("msg","用户名或密码错误！");
//            return "index";
//        }

        // shiro获取当前用户，用于后续认证授权
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            // 执行登录方法，无异常
            subject.login(token);
            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
            return "userIndex";
        } catch (UnknownAccountException e) {// 用户名不存在
            model.addAttribute("msg","用户名错误");
            return "index";
        }catch (IncorrectCredentialsException e){// 密码错误
            model.addAttribute("msg","密码错误");
            return "index";
        }

    }

    @RequestMapping("/user/signOut")
    public String signOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
