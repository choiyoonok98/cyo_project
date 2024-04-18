package com.example.cyo.repository;

import java.util.HashMap;
import java.util.List;

import com.example.cyo.domain.BOARD_INFO;
import com.example.cyo.repository.mapper.BoardMapper;

public class MybatisMapperBoardRepository implements BoardRepository {

	private final BoardMapper boardMapper;
	
	public MybatisMapperBoardRepository(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BOARD_INFO> allBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}
