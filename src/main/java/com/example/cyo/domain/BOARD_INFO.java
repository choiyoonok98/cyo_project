package com.example.cyo.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BOARD_INFO")

@Alias("BOARD_INFO")
public class BOARD_INFO {

	@Id
	private int boardSeq;			//일련번호
	private String boardWriter; 	//작성자
	private String boardSubject; 	//게시글 제목
	private String boardContent; 	//게시글 내용
	private Date insDate;			//게시글 등록일
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	
	@Override
	public String toString() {
		return "BOARD_INFO [boardSeq=" + boardSeq + ", boardWriter=" + boardWriter + ", boardSubject=" + boardSubject
				+ ", boardContent=" + boardContent + ", insDate=" + insDate + "]";
	}
	
	
}
