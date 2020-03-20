package com.spring.tomorrow.qna.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("qnaVO")
public class QnaVO {
	
	private int reply_count;
	private int rnum;
	private int idx;
	private int writer_idx;
	private String title;
	private String content;
	private int secret_yn;
	private int pwd;
	private Date regdate;
	private int views;
	
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
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
	public int getWriter_idx() {
		return writer_idx;
	}
	public void setWriter_idx(int writer_idx) {
		this.writer_idx = writer_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSecret_yn() {
		return secret_yn;
	}
	public void setSecret_yn(int secret_yn) {
		this.secret_yn = secret_yn;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
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
	
}
