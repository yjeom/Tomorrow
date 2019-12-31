package com.spring.tomorrow.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.qna.vo.QnaVO;

@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public List<QnaVO> selectQnaList(int curPage) throws DataAccessException {
		List<QnaVO> qnaList=null;
				
		qnaList=sqlSession.selectList("mapper.qna.selectQnaList", curPage);
		return qnaList;
	}

	public int selectQnaCount() throws DataAccessException {
		int totalCount=0;
		totalCount=sqlSession.selectOne("mapper.qna.selectQnaCount");
		return totalCount;
	}

}
