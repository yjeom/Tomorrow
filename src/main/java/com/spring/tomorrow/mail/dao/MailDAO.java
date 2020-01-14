package com.spring.tomorrow.mail.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.mail.vo.MailVO;


public interface MailDAO {
	
	public int sendWorryCount(int idx)throws DataAccessException;
	public List<MailVO> sendWorryList(int idx,int start,int end)throws DataAccessException;
	public int sendReplyCount(int idx)throws DataAccessException;
	public List<MailVO> sendReplyList(int idx,int start,int end)throws DataAccessException;
	public int getRandomReceiver(int sender_idx)throws DataAccessException;
	public void insertSendMail(MailVO mailVO) throws DataAccessException ;
	public void insertReceiveMail(MailVO mailVO) throws DataAccessException ;
	public int receiveWorryCount(int idx)throws DataAccessException;
	public List<MailVO> receiveWorryList(int idx,int start,int end)throws DataAccessException;
	public int receiveReplyCount(int idx)throws DataAccessException;
	public List<MailVO> receiveReplyList(int idx,int start,int end)throws DataAccessException;
	public int getSendMailSeq()throws DataAccessException;
	public MailVO getReceiveMail(int idx)throws DataAccessException;
	public MailVO getSendMail(int idx)throws DataAccessException;
	public void sendReplyAfter(int idx)throws DataAccessException;

}