package com.example.cyo.repository;

import java.util.HashMap;
import java.util.List;

import com.example.cyo.domain.BOARD_INFO;

public interface BoardRepository {
	List<BOARD_INFO> allBoardList();					//게시글 전체 리스트
	List<BOARD_INFO> boardDetail(int boardSeq);			//게시글 번호로 게시글상세

}
