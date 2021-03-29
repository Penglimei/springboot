package com.plm.service.impl;

import com.plm.mapper.UserMapper;
import com.plm.pojo.User;
import com.plm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String username) {
        User user = userMapper.queryUserByName(username);
        return user;
    }
}
