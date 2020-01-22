package com.spring.tomorrow.diary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.diary.dao.DiaryDAO;
import com.spring.tomorrow.diary.vo.DiaryVO;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private DiaryDAO diaryDAO;

	public List<DiaryVO> diaryList(int idx, int start, int end){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("start", start);
		map.put("end", end);
		
		return diaryDAO.diaryList(map);
	}

	public int diaryListCount(int idx) {
		return diaryDAO.diaryListCount(idx);
	}

	public DiaryVO getQuestion(int idx) {
		int question_idx=0;
		int check=0;
		check=diaryDAO.qeustionCheck(idx);
		DiaryVO diaryVO=null;
		if(check==0) {//오늘 받은 질문이 없을 경우
			question_idx=diaryDAO.questionCount(idx);
			diaryVO=diaryDAO.getQuestion(question_idx+1);
		}
		return diaryVO;
	}

	public void insertDiary(DiaryVO diaryVO) {
		diaryDAO.insertDiary(diaryVO);
		
	}

	public DiaryVO getDiary(int idx) {
		return diaryDAO.getDiary(idx);
	}

	public void updateDiary(DiaryVO diaryVO) {
		diaryDAO.updateDiary(diaryVO);
	}

}
