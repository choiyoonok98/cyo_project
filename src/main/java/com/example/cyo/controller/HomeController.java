package com.example.cyo.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	
	/*
	 * @RequestMapping(value="/") public String index() {
	 * System.out.println("index 호출"); return "allBoardList"; }
	 */
	 
	
	 @RequestMapping(value={"/" , "/index"}) 
	 private ModelAndView main(HttpServletRequest request, Model model) { 
			
		 /*  1.
			 * ModelAndView mv = new ModelAndView();
			 * System.out.println("board/allboardList 호출"); mv.setViewName("allBoardList");
			 * return mv;
	     */
		 
		 //2
		 return new ModelAndView("redirect:/board/allBoardList");
	 }
	 
	 
	 
}
