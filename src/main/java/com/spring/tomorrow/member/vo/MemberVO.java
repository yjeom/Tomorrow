package com.spring.tomorrow.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


@Component("memberVO")
public class MemberVO {
	
	private int idx;
	private String id;
	private String pwd;
	private String email;
	private String google_email;
	private String naver_email;
	private String kakao_email;
	private Date join_date;
	private int report_count;
	private int report_check;
	private String access_token;
	private String refresh_token;
	
	public String getKakao_email() {
		return kakao_email;
	}
	public void setKakao_email(String kakao_email) {
		this.kakao_email = kakao_email;
	}
	public String getGoogle_email() {
		return google_email;
	}
	public void setGoogle_email(String google_email) {
		this.google_email = google_email;
	}
	public String getNaver_email() {
		return naver_email;
	}
	public void setNaver_email(String naver_email) {
		this.naver_email = naver_email;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public int getReport_count() {
		return report_count;
	}
	public void setReport_count(int report_count) {
		this.report_count = report_count;
	}
	public int getReport_check() {
		return report_check;
	}
	public void setReport_check(int report_check) {
		this.report_check = report_check;
	}
	

}
