package com.plm.service;


import com.plm.pojo.User;

public interface UserService {
    public User queryUserByName(String username);
}
