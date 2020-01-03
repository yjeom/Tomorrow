package com.spring.tomorrow.qna.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("replyVO")
public class ReplyVO {
	
	private int rnum;
	private int idx;
	private int qna_idx;
	private int writer_idx;
	private String writer;
	private String content;
	private Date regdate;
	private int views;
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public int getWriter_idx() {
		return writer_idx;
	}
	public void setWriter_idx(int writer_idx) {
		this.writer_idx = writer_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	

}
