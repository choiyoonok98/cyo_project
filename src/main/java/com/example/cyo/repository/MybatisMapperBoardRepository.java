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
		log.info("mapper repository 게시글 리스트");
		return list;
	}

	@Override
	public List<BOARD_INFO> boardDetail(int boardSeq) {
		List<BOARD_INFO> list = boardMapper.boardDetail(boardSeq);
		log.info("mapper repository 게시글 상세");
		return list;
	}

	@Override
	public BOARD_INFO insert(BOARD_INFO boardInfo) {
		boardMapper.insert(boardInfo);
		return boardInfo;
	}

	@Override
	public void delete(int boardSeq) {
		boardMapper.delete(boardSeq);
		
	}

	@Override
	public void update(BOARD_INFO boardInfo) {
		boardMapper.update(boardInfo);
		
	}

}
