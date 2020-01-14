package com.spring.tomorrow.mail.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.mail.vo.MailVO;


@Repository("mailDAO")
public class MailDAOImpl implements MailDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public int sendWorryCount(int idx) throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.mail.sendWorryCount",idx);
		return totalCount;
	}

	public List<MailVO> sendWorryList(int idx, int start, int end) throws DataAccessException {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("sender_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.mail.sendWorryList",map);
	}

	public int sendReplyCount(int idx) throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.mail.sendReplyCount",idx);
		return totalCount;
	}

	public List<MailVO> sendReplyList (int idx, int start, int end) throws DataAccessException {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("sender_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.mail.sendReplyList",map);
	}

	public int getRandomReceiver(int sender_idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.mail.getRandomReceiver",sender_idx);
	}

	public void insertSendMail(MailVO mailVO) throws DataAccessException {
		sqlSession.insert("mapper.mail.insertSendMail", mailVO);
	}
	public void insertReceiveMail(MailVO mailVO) throws DataAccessException {
		sqlSession.insert("mapper.mail.insertReceiveMail", mailVO);
	}
	public int receiveWorryCount(int idx) throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.mail.receiveWorryCount",idx);
		return totalCount;
	}

	public List<MailVO> receiveWorryList(int idx, int start, int end) throws DataAccessException {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("receiver_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.mail.receiveWorryList",map);
	}

	public int receiveReplyCount(int idx) throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.mail.receiveReplyCount",idx);
		return totalCount;
	}

	public List<MailVO> receiveReplyList (int idx, int start, int end) throws DataAccessException {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("receiver_idx", idx);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mapper.mail.receiveReplyList",map);
	}

	public int getSendMailSeq() throws DataAccessException {
		return sqlSession.selectOne("mapper.mail.getSend_idx");
	}

	public MailVO getReceiveMail(int idx) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.mail.getReceiveMail",idx);
	}
	public MailVO getSendMail(int idx) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.mail.getSendMail",idx);
	}
	public void sendReplyAfter(int idx) throws DataAccessException {
		sqlSession.delete("mapper.mail.sendReplyAfter",idx);
	}


}