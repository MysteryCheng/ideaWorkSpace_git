package com.mystery.javautils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mystery.javautils.dao")
public class JavaUtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaUtilsApplication.class, args);
	}

}
