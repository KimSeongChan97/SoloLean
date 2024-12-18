package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //  DataSourceAutoConfiguration 는 exclude 하여 잠시 DB 정지
@EnableTransactionManagement
@ComponentScan(basePackages = {"user.controller", "user.service", "user.dao"})
@MapperScan("user.dao")
@SpringBootApplication
public class Chapter02MySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02MySqlApplication.class, args);
	}

}
