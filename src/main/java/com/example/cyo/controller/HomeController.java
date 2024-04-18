package com.example.cyo.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	/*
	 * @RequestMapping(value="/") public String index() {
	 * 
	 * return "index"; }
	 */
	@RequestMapping(value={"/" , "/index"})
    private ModelAndView main(HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
			mv.setViewName("/board/allboardList.view");
			return mv;
		
		
    }
}
