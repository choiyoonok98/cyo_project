package com.example.cyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class CyoApplication {

	public static void main(String[] args) {
		log.info("cyoApplication Run");
		SpringApplication.run(CyoApplication.class, args);
	}

}
