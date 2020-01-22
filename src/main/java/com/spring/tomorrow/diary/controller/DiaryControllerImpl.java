package com.spring.tomorrow.diary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.spring.tomorrow.diary.service.DiaryService;
import com.spring.tomorrow.diary.vo.DiaryVO;
import com.spring.tomorrow.member.vo.MemberVO;

@Controller("diaryController")
public class DiaryControllerImpl implements DiaryController{

	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	DiaryVO diaryVO;

	@RequestMapping(value="/diary/diaryList.do", method=RequestMethod.GET)
	public ModelAndView diaryList(@RequestParam(defaultValue="1")int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=diaryService.diaryListCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<DiaryVO> diaryList=diaryService.diaryList(member.getIdx(),paging.getStartIndex(),paging.getEndIndex());
		mav.addObject("paging", paging);
		mav.addObject("diaryList", diaryList);
		mav.setViewName("/diary/diaryList");
		return mav;
	}

	@RequestMapping(value="/diary/getQuestion.do",method=RequestMethod.GET)
	public ResponseEntity getQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			HttpSession session = request.getSession();
			MemberVO member=(MemberVO) session.getAttribute("member");
			DiaryVO diaryVO=diaryService.getQuestion(member.getIdx());
			if(diaryVO==null) {
				 message  = "<script>";
				 message +=" alert('이미 오늘의 질문을 받으셨습니다.');";
				 message += " location.href='"+request.getContextPath()+"/diary/diaryList.do';";
				 message += " </script>";
				    
			}
			else {
				session.setAttribute("question", diaryVO.getQuestion());
				System.out.println("질문가져오기:"+diaryVO.getQuestion());
				session.setAttribute("question_idx", diaryVO.getQuestion_idx());
		    message  += "<script>";
		    message += " location.href='"+request.getContextPath()+"/diary/diaryForm.do';";
		    message += " </script>";
			}
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/diary/diaryList.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value="/diary/diaryForm.do",method=RequestMethod.GET)
	public ModelAndView diaryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav =new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println("question!!!"+session.getAttribute("question"));
		mav.addObject("question",session.getAttribute("question") );
		mav.addObject("question_idx",session.getAttribute("question_idx") );
		session.removeAttribute("qeustion");
		session.removeAttribute("qeustion_idx");
		mav.setViewName("/diary/diaryForm");
		return mav;
	}

	@RequestMapping(value="/diary/insertDiary.do",method=RequestMethod.POST)
	public ResponseEntity insertDiary(@ModelAttribute DiaryVO diaryVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			diaryService.insertDiary(diaryVO);
				 message  = "<script>";
				 message +=" alert('오늘의 기록을 담았습니다.');";
				 message += " location.href='"+request.getContextPath()+"/diary/diaryList.do';";
				 message += " </script>";
				    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/diary/diaryForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}

	@RequestMapping(value= {"/diary/getDiary.do","/diary/updateForm.do"},method=RequestMethod.GET)
	public ModelAndView getDiary(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		DiaryVO getDiary=diaryService.getDiary(idx);
		
		if(request.getServletPath().equals("/diary/getDiary.do")) {
			mav.addObject("readDiary", getDiary);
		}
		else {
			mav.addObject("updateDiary", getDiary);
		}
		mav.setViewName("/diary/getDiary");
		return mav;
	}

	@RequestMapping(value="/diary/updateDiary.do",method=RequestMethod.POST)
	public ResponseEntity updateDiary(@ModelAttribute DiaryVO diaryVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			diaryService.updateDiary(diaryVO);
				 message  = "<script>";
				 message +=" alert('기록을 수정했습니다.');";
				 message += " location.href='"+request.getContextPath()+"/diary/diaryList.do';";
				 message += " </script>";
				    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/diary/updateForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}
