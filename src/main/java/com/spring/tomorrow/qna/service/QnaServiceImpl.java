package com.spring.tomorrow.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.qna.dao.QnaDAO;
import com.spring.tomorrow.qna.vo.QnaVO;

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

}
