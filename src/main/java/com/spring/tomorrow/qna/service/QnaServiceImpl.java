package com.spring.tomorrow.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.qna.dao.QnaDAO;
import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{

	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaVO> selectQnaList(int start,int end)  {
		List<QnaVO> qnaList=null;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		qnaList=qnaDAO.selectQnaList(map);
		return qnaList;
	}

	public int selectQnaCount()  {
		int totalCount=0;
		totalCount=qnaDAO.selectQnaCount();
		return totalCount;
	}

	public int insertQna(QnaVO qnaVO)  {
		return qnaDAO.insertQna(qnaVO);
	}

	public List<ReplyVO> selectReplyList(int qna_idx, int start,int end)  {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("qna_idx", qna_idx);
		map.put("start", start);
		map.put("end", end);
		List<ReplyVO> replyList=qnaDAO.selectReplyList(map);
		return replyList;
	}

	public int selectReplyCount(int qna_idx)  {
		int totalCount=qnaDAO.selectReplyCount(qna_idx);
		return totalCount;
	}

	public QnaVO getQna(int idx)  {
		QnaVO qnaVO=qnaDAO.getQna(idx);
		return qnaVO;
	}

	public int insertReply(ReplyVO replyVO)  {
		return qnaDAO.insertReply(replyVO);
	}
	
	public QnaVO passwordCheck(int idx, int pwd)  {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("pwd", pwd);
		return qnaDAO.passwordCheck(map);
	}

	public int updateQna(QnaVO qnaVO)  {
		return qnaDAO.updateQna(qnaVO);
	}

	public int deleteQna(int idx)  {
		return qnaDAO.deleteQna(idx);
	}

	public int updateReply(ReplyVO replyVO)  {
		return qnaDAO.updateReply(replyVO);
	}

	public int deleteReply(int idx)  {
		return qnaDAO.deleteReply(idx);
	}

	public int updateViews(int idx)  {
		return qnaDAO.updateViews(idx);
	}

	public List<QnaVO> selectMyQnaList(int idx, int start, int end) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("start", start);
		map.put("end", end);
		return qnaDAO.selectMyQnaList(map);
	}

	public int selectMyQnaCount(int idx) {
		return qnaDAO.selectMyQnaCount(idx);
	}
}
