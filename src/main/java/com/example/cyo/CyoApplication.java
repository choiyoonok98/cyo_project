package com.example.cyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ComponentScan(basePackages = "com.exmaple")
@EnableScheduling
@SpringBootApplication
public class CyoApplication {

	public static void main(String[] args) {
		System.out.println("cyoapplication");
		SpringApplication.run(CyoApplication.class, args);
	}

}
