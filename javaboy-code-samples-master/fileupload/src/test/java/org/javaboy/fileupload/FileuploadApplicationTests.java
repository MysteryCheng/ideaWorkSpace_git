package org.javaboy.fileupload;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FileuploadApplicationTests {

    @Test
    void contextLoads() {
        String jsonStr = "{\"key01\":1111;\"key02\":2222}";
        Map map = new HashMap();
        String [] str2 = jsonStr.substring(1,jsonStr.length()).substring(0,jsonStr.length()-2).replace("\"","").split(";");
        for (int i = 0; i < str2.length; i++) {
            String temp = str2[i];
            map.put(temp.substring(0,temp.indexOf(":")),temp.substring(temp.indexOf(":")+1,temp.length()));
        }
        System.out.println(map);


    }

}
