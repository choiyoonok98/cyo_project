package com.example.cyo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
    	log.info("##CYO ERROR");
        return "errorTest"; 
    }

    public String getErrorPath() {
        return "/errorTest";
    }
}
