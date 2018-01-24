package com.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.front.dao")
@EnableAutoConfiguration
public class FrontserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FrontserviceApplication.class, args);
	}
}
