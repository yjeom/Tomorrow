package com.spring.tomorrow.diary.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.diary.vo.DiaryVO;

public interface DiaryService {
	public List<DiaryVO> diaryList (int idx,int start,int end);
	public int diaryListCount (int idx);
	public DiaryVO getQuestion(int idx);
	public void insertDiary(DiaryVO diaryVO);
	public DiaryVO getDiary(int idx);
	public void updateDiary(DiaryVO diaryVO);
}
