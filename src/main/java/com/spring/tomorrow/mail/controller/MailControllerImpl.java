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
			throws DataAccessException {
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
			throws DataAccessException {
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
			throws DataAccessException {
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
			mailVO.setMail_idx(0);
			mailService.sendWorryMail(mailVO);
			
		    message  = "<script>";
		    message +=" alert('���������� ���۵Ǿ����ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendWorryList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendWorryForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}
	@RequestMapping(value="/mail/receiveWorryList.do" ,method=RequestMethod.GET)
	public ModelAndView receiveWorryList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException {
		ModelAndView mav=new ModelAndView(); 
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int totalCount=mailService.receiveWorryCount(member.getIdx());
		Paging paging=new Paging(totalCount, curPage);
		List<MailVO>receiveWorryList=mailService.receiveWorryList(member.getIdx(), paging.getStartIndex(), paging.getEndIndex());
		mav.addObject("receiveWorryList", receiveWorryList);
		mav.setViewName("/mail/receiveWorryList");
		return mav;
	}
	
	@RequestMapping(value="/mail/receiveReplyList.do" ,method=RequestMethod.GET)
	public ModelAndView receiveReplyList(@RequestParam(defaultValue="1") int curPage, HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException {
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
			throws DataAccessException {
		ModelAndView mav=new ModelAndView();
		MailVO receiveWorry=null;
		receiveWorry=mailService.getReceiveMail(idx);
		mav.addObject("receiveWorry", receiveWorry);
		mav.setViewName("/mail/getReceiveWorry");
		return mav;
	}

	@RequestMapping(value="/mail/sendReply.do", method=RequestMethod.POST)
	public ResponseEntity sendReply(MailVO mailVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			mailService.sendReplyMail(mailVO);
			
		    message  = "<script>";
		    message +=" alert('������ ���۵Ǿ����ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/mail/sendReplyList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/mail/getReceiveWorry.do?idx="+mailVO.getIdx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}

	@RequestMapping(value="/mail/getSendWorry.do",method=RequestMethod.GET)
	public ModelAndView getSendWorry(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException {
		ModelAndView mav=new ModelAndView();
		MailVO sendWorry=mailService.getSendMail(idx);
		mav.addObject("sendWorry", sendWorry);
		mav.setViewName("/mail/getSendWorry");
		return mav;
	}

	@RequestMapping(value="/mail/getReceiveReply.do",method=RequestMethod.GET)
	public ModelAndView getReceiveReply(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException {
		ModelAndView mav =new ModelAndView();
		MailVO receiveReply=mailService.getReceiveMail(idx);
		MailVO sendWorry=mailService.getSendMail(receiveReply.getMail_idx());
		
		mav.addObject("receiveReply", receiveReply);
		mav.addObject("sendWorry", sendWorry);
		
		mav.setViewName("/mail/getReceiveReply");
		
		return mav;
	}

	@RequestMapping(value="/mail/getSendReply.do",method=RequestMethod.GET)
	public ModelAndView getSendReply(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException {
		ModelAndView mav=new ModelAndView();
		MailVO sendReply=mailService.getSendMail(idx);
		mav.addObject("sendReply", sendReply);
		mav.setViewName("/mail/getSendReply");
		return mav;
	}

}