package com.spring.tomorrow.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.tomorrow.Paging;
import com.spring.tomorrow.mail.service.MailService;
import com.spring.tomorrow.member.service.MemberService;
import com.spring.tomorrow.member.vo.MemberVO;



@Controller("memberController")
@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO ;
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/admin/adminHome.do" ,method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView listMembers(@RequestParam(defaultValue="1") int curPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount=memberService.membersCount();
		Paging paging=new Paging(totalCount, curPage);
		
		List memberList = memberService.listMembers(paging.getStartIndex(),paging.getEndIndex());
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		int newReport=mailService.newReport(member.getIdx());
		mav.addObject("newReport", newReport);
		mav.addObject("memberList", memberList);
		mav.addObject("paging", paging);
		mav.setViewName("/admin/adminHome");
		return mav;
	}

	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.addMember(member);
		    message  = "<script>";
		    message +=" alert('가입을 환영합니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/joinForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
		
		
	}
	
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.POST)
	public ResponseEntity removeMember(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.removeMember(idx);
		    message  = "<script>";
		    message +=" alert('회원 탈퇴가 정상적으로 수행되었습니다');";
		    message += " location.href='"+request.getContextPath()+"/member/logout.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/myPage.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	memberVO = memberService.login(member);
	if(memberVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("member", memberVO);
		    session.setAttribute("isLogOn", true);
		    if(memberVO.getId().equals("rhksflwk")) {
		    	mav.setViewName("redirect:/admin/adminHome.do");
		    }
		    else {
		    	mav.setViewName("redirect:/home.do");
		    }
	}else {
		    rAttr.addAttribute("result","loginFailed");
		    String msg="아이디 또는 비밀번호가 틀립니다.";
		    mav.addObject("msg",msg);
		    mav.setViewName("/member/loginForm");
	}
	return mav;
	}

	@Override
	@RequestMapping(value = "/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		//session.removeAttribute("member");
		//session.removeAttribute("isLogOn");
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.do");
		return mav;
	}	

	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/member/idCheck.do", method =  {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView idCheck(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result=true;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/idCheck");
			if(memberService.idCheck(id)!=null) {
				result=true;
				mav.addObject("result", result);
				mav.addObject("id", id);
			}
			else {
				result=false;
				mav.addObject("result", result);
				mav.addObject("id", id);
			}
		return mav;
	}

	@RequestMapping(value="/admin/reportMember.do",method=RequestMethod.POST)
	public ResponseEntity reportMember(@RequestParam int member_idx,@RequestParam int receive_idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.reportMember(member_idx);
		    message  = "<script>";
		    message +=" alert('해당 회원을 신고 처리 했습니다');";
		    message += " location.href='"+request.getContextPath()+"/mail/deleteReceiveReport.do?idx="+receive_idx+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/admin/getReport.do?idx="+receive_idx+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		
	}

	@RequestMapping(value="/member/reportCheck.do",method=RequestMethod.GET)
	public ModelAndView reportCheck(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		ModelAndView mav=new ModelAndView();
		memberService.reportCheck(member.getIdx());
		member.setReport_check(member.getReport_check()+1);
		session.removeAttribute("member");
		session.setAttribute("member", member);
		mav.setViewName("redirect:/home.do");
		return mav;
	}

	@RequestMapping(value="/member/myPage.do",method=RequestMethod.GET)
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/myPage");
		return mav;
	}

	@RequestMapping(value="/member/updateMember.do",method=RequestMethod.POST)
	public ResponseEntity updateMember(@ModelAttribute MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			memberService.updateMember(memberVO);
		    message  = "<script>";
		    message +=" alert('회원정보를 수정했습니다');";
		    message += " location.href='"+request.getContextPath()+"/home.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/myPage.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		
	}




}