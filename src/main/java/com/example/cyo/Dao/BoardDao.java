package com.example.cyo.Dao;

import java.util.List;

import com.example.cyo.Dto.BoardDto;

public interface BoardDao {
	
	String NAMESPACE = "myboard";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int board_seq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int board_seq);
}
