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
		log.info("service 게시글 전체 리스트");
		return boardRepository.allBoardList();
	}

	public List<BOARD_INFO> boardDetail(int boardSeq) {
		log.info("service 게시글 번호로 게시글상세");
		return boardRepository.boardDetail(boardSeq);
	}

	
}
