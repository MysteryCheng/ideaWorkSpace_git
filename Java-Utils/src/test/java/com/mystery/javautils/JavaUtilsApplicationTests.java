package com.mystery.javautils;

import com.mystery.javautils.controller.UserController;
import com.mystery.javautils.domain.User;
import com.mystery.javautils.poi.PoiUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@SpringBootTest
class JavaUtilsApplicationTests {
    @Autowired
    private  UserController userController;
    @Test
    public void test() throws Exception {
        String filepath = "C:\\Users\\华硕\\Desktop\\测试.xls";
        FileInputStream inputStream = new FileInputStream(new File(filepath));
        User user = new User();
        List<List<Object>> list = PoiUtil.getListByExcel(inputStream, filepath);
        for (int i = 0; i < list.size(); i++) {
            user.setName((String) list.get(i).get(0));
            user.setRole((String) list.get(i).get(1));
            user.setHash((String) list.get(i).get(2));
            /**往数据库插入数据*/
            userController.insertUser(user);
        }

    }

}
