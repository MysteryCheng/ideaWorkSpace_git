package com.mystery.javautils.service.impl;


import com.mystery.javautils.dao.UserMapper;
import com.mystery.javautils.domain.User;
import com.mystery.javautils.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServcieImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /*获取用户名*/
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
