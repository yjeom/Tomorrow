package com.spring.tomorrow.mail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import com.spring.tomorrow.mail.service.MailService;
import com.spring.tomorrow.mail.vo.MailVO;
import com.spring.tomorrow.member.vo.MemberVO;

@Controller("mailController")
public class MailControllerImpl implements MailController {
	@Autowired
	private MailService mailService;
	
	@Autowired
	MailVO mailVO;

	@RequestMapping(value="/mail/sendWorryList.do" ,method=RequestMethod.GET)
	public ModelAndView sendWorryList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView(); 
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=mailService.sendWorryCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO>sendWorryList=mailService.sendWorryList(member.getIdx(), paging.getStartIndex(), paging.getEndIndex());
		mav.addObject("sendWorryList", sendWorryList);
		mav.setViewName("/mail/sendWorryList");
		return mav;
	}
	
	@RequestMapping(value="/mail/sendReplyList.do" ,method=RequestMethod.GET)
	public ModelAndView sendReplyList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView(); 
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=mailService.sendReplyCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO>sendReplyList=mailService.sendReplyList(member.getIdx(), paging.getStartIndex(), paging.getEndIndex());
		mav.addObject("sendReplyList", sendReplyList);
		mav.setViewName("/mail/sendReplyList");
		return mav;
	}

	@RequestMapping(value="/mail/sendWorryForm.do",method=RequestMethod.GET)
	public ModelAndView sendWorryForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/mail/sendWorryForm");
		return mav;
	}

	@RequestMapping(value="/mail/sendWorry.do",method=RequestMethod.POST)
	public ResponseEntity sendWorry(@ModelAttribute MailVO mailVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			mailService.sendWorryMail(mailVO);
			
		    message  = "<script>";
		    message +=" alert('고민편지가 전송되었습니다');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendWorryList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendWorryForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}
	@RequestMapping(value="/mail/receiveWorryList.do" ,method=RequestMethod.GET)
	public ModelAndView receiveWorryList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView(); 
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=mailService.receiveWorryCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO>receiveWorryList=mailService.receiveWorryList(member.getIdx(), paging.getStartIndex(), paging.getEndIndex());
		mav.addObject("receiveWorryList", receiveWorryList);
		int newReply=mailService.getNewReceiveReply(member.getIdx());
		mav.addObject("newReply", newReply);
		mav.setViewName("/mail/receiveWorryList");
		return mav;
	}
	
	@RequestMapping(value="/mail/receiveReplyList.do" ,method=RequestMethod.GET)
	public ModelAndView receiveReplyList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView(); 
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=mailService.receiveReplyCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO>receiveReplyList=mailService.receiveReplyList(member.getIdx(), paging.getStartIndex(), paging.getEndIndex());
		mav.addObject("receiveReplyList", receiveReplyList);
		mav.setViewName("/mail/receiveReplyList");
		return mav;
	}

	@RequestMapping(value="/mail/getReceiveWorry.do", method=RequestMethod.GET)
	public ModelAndView getReceiveWorry(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		MailVO receiveWorry=null;
		receiveWorry=mailService.getReceiveMail(idx);
		mav.addObject("receiveWorry", receiveWorry);
		mav.setViewName("/mail/getReceiveWorry");
		return mav;
	}

	@RequestMapping(value="/mail/sendReply.do", method=RequestMethod.POST)
	public ResponseEntity sendReply(@ModelAttribute MailVO mailVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			String worryContent=request.getParameter("receiveWorry_content");
			mailService.sendReplyMail(mailVO,worryContent);
		    message  = "<script>";
		    message +=" alert('답장이 전송되었습니다');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendReplyList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/mail/getReceiveWorry.do?idx="+mailVO.getIdx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}

	@RequestMapping(value="/mail/getSendWorry.do",method=RequestMethod.GET)
	public ModelAndView getSendWorry(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		MailVO sendWorry=mailService.getSendMail(idx);
		mav.addObject("sendWorry", sendWorry);
		mav.setViewName("/mail/getSendWorry");
		return mav;
	}

	@RequestMapping(value="/mail/getReceiveReply.do",method=RequestMethod.GET)
	public ModelAndView getReceiveReply(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav =new ModelAndView();
		MailVO receiveReply=mailService.getReceiveMail(idx);
		
		mav.addObject("receiveReply", receiveReply);
		
		mav.setViewName("/mail/getReceiveReply");
		
		return mav;
	}

	@RequestMapping(value="/mail/getSendReply.do",method=RequestMethod.GET)
	public ModelAndView getSendReply(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		MailVO sendReply=mailService.getSendMail(idx);
		mav.addObject("sendReply", sendReply);
		mav.setViewName("/mail/getSendReply");
		return mav;
	}

	@RequestMapping(value= {"/mail/deleteReceiveReply.do","/mail/deleteReceiveReport"},method= {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity deleteReceiveMail(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		if(request.getServletPath().equals("/mail/deleteReceiveReply.do")) {
			try {
			mailService.deleteReceiveMail(idx);
			
		    message  = "<script>";
		    message +=" alert('삭제되었습니다');";
		    message += " location.href='"+request.getContextPath()+"/mail/receiveReplyList.do';";
		    message += " </script>";
		    
			}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/mail/getReceiveReply.do?idx="+idx+"';";
		    message += " </script>";
			e.printStackTrace();
			}
		}
		else {
			try {
				mailService.deleteReceiveMail(idx);
				
			    message  = "<script>";
			    message += " location.href='"+request.getContextPath()+"/admin/reportList.do';";
			    message += " </script>";
			    
				}catch(Exception e) {
				message  = "<script>";
			    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
			    message += " location.href='"+request.getContextPath()+"/admin/getReport.do?idx="+idx+"';";
			    message += " </script>";
				e.printStackTrace();
				}
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	@RequestMapping(value= {"/mail/deleteSendWorry.do","/mail/deleteSendReply.do"},method=RequestMethod.POST)
	public ResponseEntity deleteSendMail(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		if(request.getServletPath().equals("/mail/deleteSendWorry.do")) {
			try {
				mailService.deleteSendMail(idx);
			
				message  = "<script>";
				message +=" alert('보낸 고민이 삭제되었습니다');";
				message += " location.href='"+request.getContextPath()+"/mail/sendWorryList.do';";
				message += " </script>";
		    
			}catch(Exception e) {
				message  = "<script>";
				message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
				message += " location.href='"+request.getContextPath()+"/mail/getSendWorry.do?idx="+idx+"';";
				message += " </script>";
				e.printStackTrace();
			}
		
		}
		else {
			try {
				mailService.deleteSendMail(idx);
			
				message  = "<script>";
				message +=" alert('보낸 답장이 삭제되었습니다');";
				message += " location.href='"+request.getContextPath()+"/mail/sendReplyList.do';";
				message += " </script>";
		    
			}catch(Exception e) {
				message  = "<script>";
				message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
				message += " location.href='"+request.getContextPath()+"/mail/getSendReply.do?idx="+idx+"';";
				message += " </script>";
				e.printStackTrace();
			}
		
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value= {"/mail/reportWorry.do","/mail/reportReply.do"},method=RequestMethod.POST)
	public ResponseEntity report(@ModelAttribute MailVO mailVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		if(request.getServletPath().equals("/mail/reportWorry.do")) {
			try {
				mailService.report(mailVO);
			
				message  = "<script>";
				message +=" alert('해당 편지가 신고되었습니다');";
				message += " location.href='"+request.getContextPath()+"/mail/receiveWorryList.do';";
				message += " </script>";
		    
			}catch(Exception e) {
				message  = "<script>";
				message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
				message += " location.href='"+request.getContextPath()+"/mail/getReceiveWorry.do?idx="+mailVO.getIdx()+"';";
				message += " </script>";
				e.printStackTrace();
			}
		
		}
		else {
			try {
				mailService.report(mailVO);
			
				message  = "<script>";
				message +=" alert('해당 편지가 신고되었습니다');";
				message += " location.href='"+request.getContextPath()+"/mail/receiveReplyList.do';";
				message += " </script>";
		    
			}catch(Exception e) {
				message  = "<script>";
				message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
				message += " location.href='"+request.getContextPath()+"/mail/getReceiveReply.do?idx="+mailVO.getIdx()+"';";
				message += " </script>";
				e.printStackTrace();
			}
		
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value="/admin/reportList",method=RequestMethod.GET)
	public ModelAndView reportList(@RequestParam(defaultValue="1")int curPage, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		ModelAndView mav=new ModelAndView();
		int totalCount=mailService.reportCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO> reportList=mailService.reportList(member.getIdx(), paging.getStartIndex(),paging.getEndIndex());
		mav.addObject("paging", paging);
		mav.addObject("reportList", reportList);
		mav.setViewName("/admin/reportList");
		return mav;
	}
	
	@RequestMapping(value="/admin/getReport.do",method=RequestMethod.GET)
	public ModelAndView getReport(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav=new ModelAndView();
		MailVO report=mailService.getReceiveMail(idx);
		mav.addObject("report", report);
		mav.setViewName("/admin/getReport");
		
		return mav;
	}

}
