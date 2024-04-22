package com.example.cyo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import com.example.cyo.domain.BOARD_INFO;
import com.example.cyo.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//전체 게시글 리스트
	@RequestMapping(value={"/", "/index" , "/board/allBoardList"})
    public ModelAndView allBoardList(HttpServletRequest request, Model model) {
        ModelAndView mv = new ModelAndView();
        List<BOARD_INFO> allBoardList = boardService.allBoardList();
        mv.addObject("allBoardList", allBoardList);
        log.info("boardController"+ allBoardList);
        
        mv.setViewName("/board/allBoardList"); 
        return mv;
    }
	
	//게시글 상세
	@ResponseBody
	@RequestMapping("/board/boardDetail.view")
	public ModelAndView boardDetail(HttpServletRequest request , Model model , String boardSeq) {
		ModelAndView mv = new ModelAndView();
		log.info("boardSeq =="+boardSeq);
		int iBoardSeq = Integer.parseInt(boardSeq);
		log.info("iBoardSeq =="+iBoardSeq);
		List<BOARD_INFO> boardDetail = boardService.boardDetail(iBoardSeq);
		log.info("boardDetail=="+boardDetail);
		mv.addObject("boardDetail",boardDetail);
		mv.addObject("boardSeq",boardSeq);
		mv.setViewName("/board/boardDetail");
		return mv;
	}
	
	//게시글 상세
		@RequestMapping("/test")
		public ModelAndView test(HttpServletRequest request) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/board/boardDetail");
			return mv;
		}
	
}
