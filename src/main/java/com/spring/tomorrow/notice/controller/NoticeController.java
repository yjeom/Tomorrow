package com.spring.tomorrow.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface NoticeController {

	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
