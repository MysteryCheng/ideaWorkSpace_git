package com.mystery.javautils;

import com.mystery.javautils.domain.User;
import com.mystery.javautils.poi.PoiUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@SpringBootTest
public class IntegerParseIntTest {
    @Test
    public void test() throws Exception {


        int a = Integer.parseInt("EA",16);
        int b = Integer.parseInt("FF",16);


    }
}
