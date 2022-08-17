package com.mystery.javautils.dao;

import com.mystery.javautils.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /*获取用户名*/
    void insertUser(User user);

    /**/

}
