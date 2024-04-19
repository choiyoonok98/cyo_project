package com.example.cyo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // 에러 페이지로 리다이렉트 또는 에러 페이지를 보여주는 뷰로 포워딩합니다.
        return "error"; // error.jsp 또는 error.html로 포워딩하도록 설정해주세요.
    }

    // ErrorController 인터페이스의 getErrorPath() 메서드를 구현합니다.
    public String getErrorPath() {
        return "/error";
    }
}
