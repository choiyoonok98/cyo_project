package com.example.cyo.repository;

import java.util.HashMap;
import java.util.List;

import com.example.cyo.domain.BOARD_INFO;
import com.example.cyo.repository.mapper.BoardMapper;
import com.example.cyo.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisMapperBoardRepository implements BoardRepository {

	private final BoardMapper boardMapper;
	
	public MybatisMapperBoardRepository(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BOARD_INFO> allBoardList() {
		List<BOARD_INFO> list = boardMapper.allBoardList();
		log.info("mapper repository 호출");
		return list;
	}

}
