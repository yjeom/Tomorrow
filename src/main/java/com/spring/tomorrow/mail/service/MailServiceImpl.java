package com.spring.tomorrow.mail.service;

import java.util.HashMap;
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

	public int sendWorryCount(int idx)  {
		int totalCount=mailDAO.sendWorryCount(idx);
		return totalCount;
	}

	public List<MailVO> sendWorryList(int idx, int start, int end)  {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("sender_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return mailDAO.sendWorryList(map);
	}
	public int sendReplyCount(int idx)  {
		int totalCount=mailDAO.sendReplyCount(idx);
		return totalCount;
	}

	public List<MailVO> sendReplyList(int idx, int start, int end)  {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("sender_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return mailDAO.sendReplyList(map);
	}


	public void sendWorryMail(MailVO mailVO)  {
		int receiver=mailDAO.getRandomReceiver(mailVO.getSender_idx());//랜덤으로 회원 추첨
		mailVO.setReceiver_idx(receiver);
		mailDAO.insertSendMail(mailVO);//보내는 메일함 DB에 저장
		mailDAO.insertReceiveMail(mailVO);//받는 메일함 DB에 저장
	}
	public int receiveWorryCount(int idx)  {
		int totalCount=mailDAO.receiveWorryCount(idx);
		return totalCount;
	}

	public List<MailVO> receiveWorryList(int idx, int start, int end)  {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("receiver_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return mailDAO.receiveWorryList(map);
	}
	public int receiveReplyCount(int idx)  {
		int totalCount=mailDAO.receiveReplyCount(idx);
		return totalCount;
	}

	public List<MailVO> receiveReplyList(int idx, int start, int end)  {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("receiver_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return mailDAO.receiveReplyList(map);
	}

	public MailVO getReceiveMail(int idx)  {
		mailDAO.updateViewsReceive(idx);
		return mailDAO.getReceiveMail(idx);
	}
	public MailVO getSendMail(int idx)  {
		mailDAO.updateViewsSend(idx);
		return mailDAO.getSendMail(idx);
	}

	public void sendReplyMail(MailVO mailVO,String worryContent)  {
		mailDAO.insertSendMail(mailVO);
		String content="========== 내가 보냈던 고민 =========="
				+"\n\n"+worryContent
				  +"\n\n=============================\n\n";
		mailVO.setContent(content+mailVO.getContent());
		mailDAO.insertReceiveMail(mailVO);
		mailDAO.deleteReceiveMail(mailVO.getIdx());
		
	}

	public int getNewReceiveWorry(int idx)  {
		return mailDAO.getNewReceiveWorry(idx);
	}

	public int getNewReceiveReply(int idx)  {
		return mailDAO.getNewReceiveReply(idx);
	}

	public void deleteSendMail(int idx)  {
		mailDAO.deleteSendMail(idx);
	}

	public void deleteReceiveMail(int idx)  {
		mailDAO.deleteReceiveMail(idx);
	}

	public void report(MailVO mailVO)  {
		mailDAO.reportAdmin(mailVO);
		mailDAO.deleteReceiveMail(mailVO.getIdx());
	}

	public List<MailVO> reportList(int idx, int start, int end)  {
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("start", start);
		map.put("end", end);
		return mailDAO.reportList(map);
	}

	public int reportCount(int idx)  {
		return mailDAO.reportCount(idx);
	}

	public int newReport(int idx)  {
		return mailDAO.newReport(idx);
	}

}
