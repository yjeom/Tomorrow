package com.spring.tomorrow.mail.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.mail.vo.MailVO;


public interface MailDAO {
	
	public int sendWorryCount(int idx)throws DataAccessException;
	public List<MailVO> sendWorryList(HashMap<String, Object>map)throws DataAccessException;
	public int sendReplyCount(int idx)throws DataAccessException;
	public List<MailVO> sendReplyList(HashMap<String, Object>map)throws DataAccessException;
	public int getRandomReceiver(int sender_idx)throws DataAccessException;
	public void insertSendMail(MailVO mailVO) throws DataAccessException ;
	public void insertReceiveMail(MailVO mailVO) throws DataAccessException ;
	public int receiveWorryCount(int idx)throws DataAccessException;
	public List<MailVO> receiveWorryList(HashMap<String, Object>map)throws DataAccessException;
	public int receiveReplyCount(int idx)throws DataAccessException;
	public List<MailVO> receiveReplyList(HashMap<String, Object>map)throws DataAccessException;
	public MailVO getReceiveMail(int idx)throws DataAccessException;
	public MailVO getSendMail(int idx)throws DataAccessException;
	public void deleteReceiveMail(int idx)throws DataAccessException;
	public void deleteSendMail(int idx)throws DataAccessException;
	public int getNewReceiveWorry(int idx)throws DataAccessException;
	public int getNewReceiveReply(int idx)throws DataAccessException;
	public void updateViewsSend(int idx)throws DataAccessException;
	public void updateViewsReceive(int idx)throws DataAccessException;
	public void reportAdmin(MailVO mailVO)throws DataAccessException;
	public List<MailVO> reportList(HashMap<String, Object>map)throws DataAccessException;
	public int reportCount(int idx)throws DataAccessException;
	public int newReport(int idx)throws DataAccessException;
	

}
