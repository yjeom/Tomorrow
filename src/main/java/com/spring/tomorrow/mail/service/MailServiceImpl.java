package com.spring.tomorrow.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.mail.dao.MailDAO;
import com.spring.tomorrow.mail.vo.MailVO;


@Service("mailService")
public class MailServiceImpl implements MailService{
	
	@Autowired
	private MailDAO mailDAO;

	public int sendWorryCount(int idx) throws DataAccessException {
		int totalCount=mailDAO.sendWorryCount(idx);
		return totalCount;
	}

	public List<MailVO> sendWorryList(int idx, int start, int end) throws DataAccessException {

		return mailDAO.sendWorryList(idx, start, end);
	}
	public int sendReplyCount(int idx) throws DataAccessException {
		int totalCount=mailDAO.sendReplyCount(idx);
		return totalCount;
	}

	public List<MailVO> sendReplyList(int idx, int start, int end) throws DataAccessException {

		return mailDAO.sendReplyList(idx, start, end);
	}


	public void sendWorryMail(MailVO mailVO) throws DataAccessException {
		int receiver=mailDAO.getRandomReceiver(mailVO.getSender_idx());//랜덤으로 회원 추첨
		mailVO.setReceiver_idx(receiver);
		mailDAO.insertSendMail(mailVO);//보내는 메일함 DB에 저장
		mailDAO.insertReceiveMail(mailVO);//받는 메일함 DB에 저장
	}
	public int receiveWorryCount(int idx) throws DataAccessException {
		int totalCount=mailDAO.receiveWorryCount(idx);
		return totalCount;
	}

	public List<MailVO> receiveWorryList(int idx, int start, int end) throws DataAccessException {

		return mailDAO.receiveWorryList(idx, start, end);
	}
	public int receiveReplyCount(int idx) throws DataAccessException {
		int totalCount=mailDAO.receiveReplyCount(idx);
		return totalCount;
	}

	public List<MailVO> receiveReplyList(int idx, int start, int end) throws DataAccessException {

		return mailDAO.receiveReplyList(idx, start, end);
	}

	public MailVO getReceiveMail(int idx) throws DataAccessException {
		mailDAO.updateViewsReceive(idx);
		return mailDAO.getReceiveMail(idx);
	}
	public MailVO getSendMail(int idx) throws DataAccessException {
		mailDAO.updateViewsSend(idx);
		return mailDAO.getSendMail(idx);
	}

	public void sendReplyMail(MailVO mailVO,String worryContent) throws DataAccessException {
		mailDAO.insertSendMail(mailVO);
		String content="========== 내가 보냈던 고민 =========="
				+"\n\n"+worryContent
				  +"\n\n=============================\n\n";
		mailVO.setContent(content+mailVO.getContent());
		mailDAO.insertReceiveMail(mailVO);
		mailDAO.deleteReceiveMail(mailVO.getIdx());
		
	}

	public int getNewReceiveWorry(int idx) throws DataAccessException {
		return mailDAO.getNewReceiveWorry(idx);
	}

	public int getNewReceiveReply(int idx) throws DataAccessException {
		return mailDAO.getNewReceiveReply(idx);
	}

	public void deleteSendMail(int idx) throws DataAccessException {
		mailDAO.deleteSendMail(idx);
	}

	public void deleteReceiveMail(int idx) throws DataAccessException {
		mailDAO.deleteReceiveMail(idx);
	}

}
