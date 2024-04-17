package com.example.cyo.Dto;

import java.sql.Date;

public class BoardDto {
	private int board_seq;
	private String board_writer;
	private String board_subject;
	private String board_content;
	private Date ins_date;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int board_seq , String board_writer, String board_subject , String board_content , Date ins_Date) {
		super();
		this.board_seq = board_seq;
		this.board_writer = board_writer;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.ins_date = ins_date;
		
	}
	
	/**
	 * @return the board_seq
	 */
	public int getBoard_seq() {
		return board_seq;
	}
	/**
	 * @param board_seq the board_seq to set
	 */
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	/**
	 * @return the board_writer
	 */
	public String getBoard_writer() {
		return board_writer;
	}
	/**
	 * @param board_writer the board_writer to set
	 */
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	/**
	 * @return the board_subject
	 */
	public String getBoard_subject() {
		return board_subject;
	}
	/**
	 * @param board_subject the board_subject to set
	 */
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	/**
	 * @return the board_content
	 */
	public String getBoard_content() {
		return board_content;
	}
	/**
	 * @param board_content the board_content to set
	 */
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	/**
	 * @return the ins_date
	 */
	public Date getIns_date() {
		return ins_date;
	}
	/**
	 * @param ins_date the ins_date to set
	 */
	public void setIns_date(Date ins_date) {
		this.ins_date = ins_date;
	}
}
