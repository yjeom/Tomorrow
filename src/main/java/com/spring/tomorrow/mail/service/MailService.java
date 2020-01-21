package com.spring.tomorrow.mail.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.mail.vo.MailVO;

public interface MailService {
	
	public int sendWorryCount(int idx);
	public List<MailVO> sendWorryList(int idx,int start,int end);
	public int sendReplyCount(int idx);
	public List<MailVO> sendReplyList(int idx,int start,int end);
	public void sendWorryMail(MailVO mailVO);
	public int receiveWorryCount(int idx);
	public List<MailVO> receiveWorryList(int idx,int start,int end);
	public int receiveReplyCount(int idx);
	public List<MailVO> receiveReplyList(int idx,int start,int end);
	public MailVO getReceiveMail(int idx);
	public MailVO getSendMail(int idx);
	public void sendReplyMail(MailVO mailVO,String worryContent);
	public int getNewReceiveWorry(int idx);
	public int getNewReceiveReply(int idx);
	public void deleteSendMail(int idx);
	public void deleteReceiveMail(int idx);
	public void report(MailVO mailVO);
	public List<MailVO> reportList(int idx,int start,int end);
	public int reportCount(int idx);
	public int newReport(int idx);
	
	

}
