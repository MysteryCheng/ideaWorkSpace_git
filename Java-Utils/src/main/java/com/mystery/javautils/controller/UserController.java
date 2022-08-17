package com.mystery.javautils.controller;

import com.mystery.javautils.domain.User;
import com.mystery.javautils.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServcie;

    /*获取用户名*/
    @RequestMapping("/insertUser")
    public void insertUser(User user){
        System.out.println("数据插入");
        userServcie.insertUser(user);
    }
}
