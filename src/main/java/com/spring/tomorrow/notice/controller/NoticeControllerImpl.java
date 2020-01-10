package com.spring.tomorrow.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		List noticeList=noticeService.selectNoticeList(paging.getStartIndex(),paging.getEndIndex());
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
	public ResponseEntity addNotice(@ModelAttribute("notice") NoticeVO notice,HttpServletRequest request, HttpServletResponse response) throws Exception {

		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			noticeService.insertNotice(notice);
		    message  = "<script>";
		    message +=" alert('공지사항을 등록했습니다');";
		    message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/notice/noticeForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
		
		
		
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
	public ResponseEntity noticeUpdate(NoticeVO notice, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			noticeService.updateNotice(notice);
		    message  = "<script>";
		    message +=" alert('공지사항을 수정했습니다');";
		    message += " location.href='"+request.getContextPath()+"/notice/getNotice.do?idx="+notice.getIdx()+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/notice/noticeForm.do?idx="+notice.getIdx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		
		
	}


	@RequestMapping(value="/notice/noticeDelete.do" ,method=RequestMethod.GET)
	public ResponseEntity noticeDelete(int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			noticeService.deleteNotice(idx);
		    message  = "<script>";
		    message +=" alert('공지사항을 삭제했습니다');";
		    message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/notice/getNotice.do?idx="+idx+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}
