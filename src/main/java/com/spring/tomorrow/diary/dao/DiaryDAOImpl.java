package com.spring.tomorrow.diary.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.diary.vo.DiaryVO;

@Repository("diaryDAO")
public class DiaryDAOImpl implements DiaryDAO{

	@Autowired
	private SqlSession sqlSession;

	public List<DiaryVO> diaryList(HashMap<String, Object>map) throws DataAccessException {
		return sqlSession.selectList("mapper.diary.diaryList",map);
	}

	public int diaryListCount(int idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.diary.diaryListCount",idx);
	}

	public int qeustionCheck(int idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.diary.questionCheck",idx);
	}

	public DiaryVO getQuestion(int idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.diary.getQuestion",idx);
	}

	public void insertDiary(DiaryVO diaryVO) throws DataAccessException {
		sqlSession.insert("mapper.diary.insertDiary", diaryVO);
		
	}
}
