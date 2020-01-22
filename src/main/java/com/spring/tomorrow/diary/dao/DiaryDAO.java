package com.spring.tomorrow.diary.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.diary.vo.DiaryVO;

public interface DiaryDAO {
	
	public List<DiaryVO> diaryList(HashMap<String, Object>map)throws DataAccessException;
	public int diaryListCount(int idx)throws DataAccessException;
	public int qeustionCheck(int idx)throws DataAccessException;
	public DiaryVO getQuestion(int idx)throws DataAccessException;
	public void insertDiary(DiaryVO diaryVO)throws DataAccessException;
	public int questionCount(int idx)throws DataAccessException;
	public DiaryVO getDiary(int idx)throws DataAccessException;
	public void updateDiary(DiaryVO diaryVO)throws DataAccessException;

}
