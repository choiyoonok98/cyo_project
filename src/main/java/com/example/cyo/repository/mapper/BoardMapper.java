package com.example.cyo.repository.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.cyo.domain.BOARD_INFO;
import com.example.cyo.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Mapper
public interface BoardMapper {
	List<BOARD_INFO> allBoardList();
	List<BOARD_INFO> boardDetail(int boardSeq);
	void insert(BOARD_INFO boardInfo);
}
