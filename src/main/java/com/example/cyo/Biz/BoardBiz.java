package com.example.cyo.Biz;

import com.example.cyo.Dto.BoardDto;

import java.util.List;

public interface BoardBiz {

	public List<BoardDto> selectList();
	public BoardDto selectOne(int board_seq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int board_seq);
}
