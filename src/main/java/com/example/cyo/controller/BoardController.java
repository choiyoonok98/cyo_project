package com.example.cyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import com.example.cyo.domain.BOARD_INFO;
import com.example.cyo.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/*
	 * @RequestMapping("/board/allBoardList") public ModelAndView
	 * allBoardList(HttpServletRequest request, BOARD_INFO boardInfo, Model model) {
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * List<BOARD_INFO> allBoardList = boardService.allBoardList();
	 * mv.addObject("allBoardList",allBoardList);
	 * 
	 * return mv;
	 * 
	 * }
	 */
	
	@RequestMapping("/board/allBoardList")
    public ModelAndView allBoardList(HttpServletRequest request, Model model) {
        ModelAndView mv = new ModelAndView();
        List<BOARD_INFO> allBoardList = boardService.allBoardList();
        mv.addObject("allBoardList", allBoardList);
        mv.setViewName("allBoardList"); // 뷰 이름 설정
        return mv;
    }
	
}
