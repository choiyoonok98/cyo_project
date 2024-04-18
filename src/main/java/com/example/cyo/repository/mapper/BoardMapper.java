package com.example.cyo.repository.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.cyo.domain.BOARD_INFO;

@Mapper
public interface BoardMapper {
	List<BOARD_INFO> allBoardList();
}
