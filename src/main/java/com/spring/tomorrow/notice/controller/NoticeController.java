package com.spring.tomorrow.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.member.vo.MemberVO;
import com.spring.tomorrow.notice.vo.NoticeVO;

public interface NoticeController {

	public ModelAndView noticeList(@RequestParam(defaultValue="1") int curPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addNotice(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView getNotice(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView NoticeForm(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView noticeUpdate(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView noticeDelete(@RequestParam("idx") int idx,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
