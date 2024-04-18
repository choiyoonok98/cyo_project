package com.example.cyo.service;

import java.util.List;

import com.example.cyo.domain.BOARD_INFO;

import com.example.cyo.repository.BoardRepository;


public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public List<BOARD_INFO> allBoardList() {
		// TODO Auto-generated method stub
		return boardRepository.allBoardList();
	}

	
}