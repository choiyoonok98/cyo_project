package com.example.cyo.service;

import java.util.List;

import com.example.cyo.domain.BOARD_INFO;

import com.example.cyo.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public List<BOARD_INFO> allBoardList() {
		log.info("서비스 호출");
		return boardRepository.allBoardList();
	}

	
}
