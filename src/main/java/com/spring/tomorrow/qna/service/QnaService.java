package com.spring.tomorrow.qna.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.qna.vo.QnaVO;

public interface QnaService {
	
	public List<QnaVO> selectQnaList(int curPage)throws DataAccessException;
	public int selectQnaCount()throws DataAccessException;

}
