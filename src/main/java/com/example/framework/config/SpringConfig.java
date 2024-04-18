package com.example.framework.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

import com.example.cyo.controller.BoardController;
import com.example.cyo.repository.BoardRepository;
import com.example.cyo.repository.MybatisMapperBoardRepository;
import com.example.cyo.repository.mapper.BoardMapper;
import com.example.cyo.service.BoardService;

@Slf4j
@Configuration
public class SpringConfig {
	
	@Autowired
	BoardMapper boardMapper;
	
	

	 
	
}
