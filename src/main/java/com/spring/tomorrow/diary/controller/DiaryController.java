package com.spring.tomorrow.diary.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.diary.vo.DiaryVO;

public interface DiaryController {
	
	public ModelAndView diaryList(int curPage,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ResponseEntity getQuestion(HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView diaryForm(HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ResponseEntity insertDiary(DiaryVO diaryVO,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView getDiary(int idx,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ResponseEntity updateDiary(DiaryVO diaryVO,HttpServletRequest request,HttpServletResponse response)throws Exception;

}
