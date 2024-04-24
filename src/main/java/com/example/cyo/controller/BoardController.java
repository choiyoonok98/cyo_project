package com.example.cyo.controller;

import java.time.LocalDateTime;
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
	
	@RequestMapping(value={"/", "/index" , "/board/allBoardList"})
	public ModelAndView allBoardList(HttpServletRequest request, Model model) {
	    ModelAndView mv = new ModelAndView();
	    List<BOARD_INFO> allBoardList = boardService.allBoardList();

	    int totalRecords = allBoardList.size();
	    int recordsPerPage = 10; // 페이지당 보여줄 게시글 수
	    int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

	    mv.addObject("allBoardList", allBoardList);
	    mv.addObject("totalPages", totalPages); // 전체 페이지 수를 전달합니다.
	    mv.setViewName("/board/allBoardList"); 
	    return mv;
	}

	
	//게시글 상세
	@ResponseBody
	@RequestMapping("/board/boardDetail.view")
	public ModelAndView boardDetail(HttpServletRequest request , Model model , String boardSeq) {
		ModelAndView mv = new ModelAndView();
		int iBoardSeq = Integer.parseInt(boardSeq);
		List<BOARD_INFO> boardDetail = boardService.boardDetail(iBoardSeq);
		log.info(boardDetail + "boardDetail");
		mv.addObject("boardDetail",boardDetail);
		mv.addObject("boardSeq",boardSeq);
		mv.setViewName("/board/boardDetail");
		return mv;
	}
	
	
	//게시글 수정화면
	@ResponseBody
	@RequestMapping("/board/boardUpdate.view")
	public ModelAndView boardUpdate(HttpServletRequest request , Model model , String boardSeq) {
		ModelAndView mv = new ModelAndView();
		int iBoardSeq = Integer.parseInt(boardSeq);
		List<BOARD_INFO> boardDetail = boardService.boardDetail(iBoardSeq);
		mv.addObject("boardDetail",boardDetail);
		mv.addObject("boardSeq",boardSeq);
		mv.setViewName("/board/boardUpdate");
		return mv;
	}
	
	//게시글작성폼
	@ResponseBody
	@RequestMapping("/board/boardWrite.view")
	public ModelAndView boardWrite(HttpServletRequest request , Model model , String boardSeq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/boardWrite");
		return mv;
	}
	
	//게시글작성
	@ResponseBody
	@RequestMapping("/board/boardWrite.act")
	public String insert(BOARD_INFO boardInfo) {
	    log.info(boardInfo + "컨트롤러 게시글정보");
	    // 현재 시간을 LocalDateTime으로 가져옴
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    boardInfo.setInsDate(currentDateTime);

	    String result = "게시글을 등록했습니다.";
	    try {
	        boardService.insert(boardInfo);    // 게시글 정보 저장
	    } catch (Exception e) {
	        result = "게시글 등록 중 에러 발생:";
	        log.error(result + e.getMessage());
	        e.printStackTrace();
	    }
	    return result;
	}
	
	//게시글수정
	@ResponseBody
	@RequestMapping("/board/boardUpdate.act")
	public String update(BOARD_INFO boardInfo) {
	    log.info(boardInfo + "컨트롤러 게시글정보");
	    // 현재 시간을 LocalDateTime으로 가져옴
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    boardInfo.setInsDate(currentDateTime);
	
	    String result = "게시글을 수정했습니다.";
	    try {
	        boardService.update(boardInfo);    // 게시글 정보 저장
	    } catch (Exception e) {
	        result = "게시글 수정 중 에러 발생:";
	        log.error(result + e.getMessage());
	        e.printStackTrace();
	    }
	    return result;
	}
	
	//게시글삭제
	@ResponseBody
	@RequestMapping("/board/boardDelete.act")
	public String delete(Integer boardSeq) {
	    log.info(boardSeq + "삭제 게시글 일련번호");
	    String result = "게시글을 삭제했습니다.";
	    try {
	        boardService.delete(boardSeq);    // 게시글 정보 저장
	    } catch (Exception e) {
	        result = "게시글 삭제 중 에러 발생:";
	        log.error(result + e.getMessage());
	        e.printStackTrace();
	    }
	    return result;
	}
	
}
