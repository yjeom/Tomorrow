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
	
	public List<QnaVO> selectQnaList(int curPage) throws DataAccessException {
		List<QnaVO> qnaList=null;
		qnaList=qnaDAO.selectQnaList(curPage);
		return qnaList;
	}

	public int selectQnaCount() throws DataAccessException {
		int totalCount=0;
		totalCount=qnaDAO.selectQnaCount();
		return totalCount;
	}

	public int insertQna(QnaVO qnaVO) throws DataAccessException {
		return qnaDAO.insertQna(qnaVO);
	}

	public List<ReplyVO> selectReplyList(int qna_idx, int curPage) throws DataAccessException {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("qna_idx", qna_idx);
		map.put("curPage", curPage);
		List<ReplyVO> replyList=qnaDAO.selectReplyList(qna_idx, curPage);
		return replyList;
	}

	public int selectReplyCount(int qna_idx) throws DataAccessException {
		int totalCount=qnaDAO.selectReplyCount(qna_idx);
		return totalCount;
	}

	public QnaVO getQna(int idx) throws DataAccessException {
		QnaVO qnaVO=qnaDAO.getQna(idx);
		return qnaVO;
	}

	public int insertReply(ReplyVO replyVO) throws DataAccessException {
		return qnaDAO.insertReply(replyVO);
	}
	
	public QnaVO passwordCheck(int idx, int pwd) throws DataAccessException {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("pwd", pwd);
		return qnaDAO.passwordCheck(idx, pwd);
	}

	public int updateQna(QnaVO qnaVO) throws DataAccessException {
		return qnaDAO.updateQna(qnaVO);
	}

	public int deleteQna(int idx) throws DataAccessException {
		return qnaDAO.deleteQna(idx);
	}
}
