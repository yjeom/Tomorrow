package com.spring.tomorrow.mail.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("mailVO")
public class MailVO {
	
	
	private int rnum;
	private int idx;
	private int sender_idx;
	private int receiver_idx;
	private String title;
	private String content;
	private int reply_yn;
	private int reporter_idx;
	private Date regdate;
	private int views;
	private String reporter;
	private String sender;
	
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
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
	public int getSender_idx() {
		return sender_idx;
	}
	public void setSender_idx(int sender_idx) {
		this.sender_idx = sender_idx;
	}
	public int getReceiver_idx() {
		return receiver_idx;
	}
	public void setReceiver_idx(int receiver_idx) {
		this.receiver_idx = receiver_idx;
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
	public int getReply_yn() {
		return reply_yn;
	}
	public void setReply_yn(int reply_yn) {
		this.reply_yn = reply_yn;
	}
	public int getReporter_idx() {
		return reporter_idx;
	}
	public void setReporter_idx(int reporter_idx) {
		this.reporter_idx = reporter_idx;
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
