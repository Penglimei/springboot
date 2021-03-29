package com.plm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/userIndex")
    public String toUserIndex(Model model){
        model.addAttribute("msg","this is userIndex.html");
        return "userIndex";
    }

    @RequestMapping("/user/add")
    public String addUser(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String updateUser(){
        return "user/update";
    }

    @RequestMapping("/user/del")
    public String delUser(){
        return "user/del";
    }

    @RequestMapping("/unauth")
    public String unauthorized(){
        return "error/404";
    }

}
