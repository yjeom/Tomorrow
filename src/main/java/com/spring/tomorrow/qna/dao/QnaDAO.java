package com.spring.tomorrow.qna.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.qna.vo.QnaVO;

public interface QnaDAO {
	
	public List<QnaVO> selectQnaList(int curPage)throws DataAccessException;
	public int selectQnaCount()throws DataAccessException;

}
