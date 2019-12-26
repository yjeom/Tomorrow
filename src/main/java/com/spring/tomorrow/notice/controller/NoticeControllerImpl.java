package com.spring.tomorrow.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.member.service.MemberService;
import com.spring.tomorrow.member.vo.MemberVO;
import com.spring.tomorrow.notice.service.NoticeService;
import com.spring.tomorrow.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController{

	@Autowired
	private NoticeService noticeService;
	@Autowired
	NoticeVO noticeVO ;
	
	
	@RequestMapping(value = "/notice/noticeList.do", method = RequestMethod.GET)
	public ModelAndView noticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page=0;
		if(request.getParameter("page")==null)
			page=1;
		else
		page=Integer.parseInt((String)request.getParameter("page"));
		List noticeList=noticeService.selectNoticeList(page);
		ModelAndView mav=new ModelAndView();
		mav.addObject("noticeList",noticeList);
		mav.setViewName("/notice/noticeList");
		return mav;
	}

}
