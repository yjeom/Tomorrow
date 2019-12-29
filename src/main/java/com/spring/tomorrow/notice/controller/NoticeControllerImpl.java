package com.spring.tomorrow.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.Paging;
import com.spring.tomorrow.notice.service.NoticeService;
import com.spring.tomorrow.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl implements NoticeController{

	@Autowired
	private NoticeService noticeService;
	@Autowired
	NoticeVO noticeVO ;
	
	
	@RequestMapping(value = "/notice/noticeList.do", method = RequestMethod.GET)
	public ModelAndView noticeList(@RequestParam(defaultValue="1") int curPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount=noticeService.selectNoticeCount();
		Paging paging=new Paging(totalCount, curPage);
		List noticeList=noticeService.selectNoticeList(curPage);
		ModelAndView mav=new ModelAndView();
		mav.addObject("noticeList",noticeList);
		mav.addObject("paging",paging);
		mav.setViewName("/notice/noticeList");
		return mav;
	}


	@RequestMapping(value="/notice/noticeForm.do",method=RequestMethod.GET)
	public ModelAndView NoticeForm(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		boolean isNew=true;
		if(request.getParameter("idx")!=null) {
			notice.setIdx(Integer.parseInt(request.getParameter("idx")));
			notice=noticeService.getNotice(notice);
			mav.addObject("notice", notice);
			isNew=false;
		}
		mav.addObject("isNew", isNew);
		mav.setViewName("/notice/noticeForm");
		return mav;
	}
	@RequestMapping(value="/notice/noticeForm.do",method=RequestMethod.POST)
	public ModelAndView addNotice(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(notice.getTitle()+"TILE");
		int result=noticeService.insertNotice(notice);
		ModelAndView mav=new ModelAndView();
		mav.addObject("result", result);
		if(result>0)
			mav.setViewName("redirect:/notice/noticeList.do");
		else
			mav.setViewName("redirect:/notice/noticeForm.do");
		return mav;
	}


	@RequestMapping(value="/notice/getNotice.do",method=RequestMethod.GET)
	public ModelAndView getNotice(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		noticeService.updateNoticeViews(notice.getIdx());
		notice=noticeService.getNotice(notice);
		mav.addObject("notice", notice);
		mav.setViewName("/notice/getNotice");
		
		return mav;
	}


	@RequestMapping(value="/notice/noticeUpdate.do",method=RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO notice, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		int result =noticeService.updateNotice(notice);
		if(result>0)
			mav.setViewName("redirect:/notice/noticeList.do");
		else
			mav.setViewName("notice/noticeUpdate.do");
		return mav;
	}


	@RequestMapping(value="/notice/noticeDelete.do" ,method=RequestMethod.GET)
	public ModelAndView noticeDelete(int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		int result=noticeService.deleteNotice(idx);
		if(result>0)
			mav.setViewName("redirect:/notice/noticeList.do");
		else
			mav.setViewName("redirect:/notice/getNotice.do?idx="+idx);
		
		return mav;
	}
}
