package com.spring.tomorrow.member.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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

import com.google.gson.Gson;
import com.spring.tomorrow.Paging;
import com.spring.tomorrow.SNSOauth;
import com.spring.tomorrow.SocialLogin;
import com.spring.tomorrow.mail.service.MailService;
import com.spring.tomorrow.member.service.MemberService;
import com.spring.tomorrow.member.vo.MemberVO;

import com.spring.tomorrow.Token;



@Controller("memberController")
@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO ;
	@Autowired
	private MailService mailService;

	SocialLogin login;
	
	@RequestMapping(value = "/member/oauth/googlecallback", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView googleCallback(@RequestParam String code,RedirectAttributes rAttr, HttpServletRequest request)  {
		System.out.println("google");
		ModelAndView mav = new ModelAndView();
		MemberVO member = new MemberVO();
		try {
			String param = "code=" + code
					+ "&client_id="+SNSOauth.getGoogleclientid()
					+ "&client_secret="+SNSOauth.getGooglesecret()
					+ "&redirect_uri="+SNSOauth.getGoogleredirecturl()
					+ "&grant_type=authorization_code";
			//getToken
			member = memberService.getToken("https://oauth2.googleapis.com/token", param, member);
			//getUserInfo
			member = memberService.getSNSUserInfo("google",
					"https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + member.getAccess_token(), member);
			
			//Join Check
			MemberVO check = memberService.idCheck(member.getGoogle_email());
			if (check == null) {
				member.setId(member.getGoogle_email());
				memberService.addMember(member);
				check = memberService.idCheck(member.getGoogle_email());
			}
			HttpSession session = request.getSession();
			session.setAttribute("member", check);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/home.do");
		} catch (Exception e) {
			e.printStackTrace();
			rAttr.addAttribute("result", "loginFailed");
			String msg = "죄송합니다. 로그인에 실패했습니다.";
			mav.addObject("msg", msg);
			mav.setViewName("/member/loginForm");
		}
		return mav;
	}
	
	@RequestMapping(value = "/member/oauth/naver", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView naverCallback(@RequestParam String code, @RequestParam String state, RedirectAttributes rAttr,
			HttpServletRequest request) {
		System.out.println("naver");
		ModelAndView mav = new ModelAndView();
		try {
			MemberVO member = new MemberVO();
			String storedState = request.getSession().getAttribute("state").toString();

			if (!state.equals(storedState)) {
				System.out.println("err");
				
			} else {
				String param = "client_id="+SNSOauth.getNaverclientid() 
								+ "&client_secret="+SNSOauth.getNaversecret()
						+ "&grant_type=authorization_code&" + "state=" + state + "&" + "code=" + code;
				login = new SocialLogin();
				//getToken
				member = memberService.getToken("https://nid.naver.com/oauth2.0/token", param, member);
				//getUserInfo
				member = memberService.getSNSUserInfo("naver",
						"https://openapi.naver.com/v1/nid/me?access_token=" + member.getAccess_token(), member);
				//JoinCheck
				MemberVO check = memberService.idCheck(member.getNaver_email());
				if (check == null) {
					member.setId(member.getNaver_email());
					memberService.addMember(member);
					check = memberService.idCheck(member.getNaver_email());
				}
				HttpSession session = request.getSession();
				session.setAttribute("member", check);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/home.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rAttr.addAttribute("result", "loginFailed");
			String msg = "죄송합니다. 로그인에 실패했습니다.";
			mav.addObject("msg", msg);
			mav.setViewName("/member/loginForm");
		}
		return mav;
	}
	
	@RequestMapping(value="/member/oauth/kakao" ,method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView kakaoCallback(@RequestParam String code, RedirectAttributes rAttr,HttpServletRequest request)  {
		System.out.println("kakao");
		ModelAndView mav = new ModelAndView();
		try {
			MemberVO member = new MemberVO();
				String param = "client_id="+SNSOauth.getKakaoclientid()
								+ "&client_secret="+SNSOauth.getKakaosecret()
								+ "&grant_type=authorization_code" 
								+ "&redirect_uri="+SNSOauth.getKakaoredirecturl() 
								+ "&code=" + code;
				login = new SocialLogin();
				//getToken
				member = memberService.getToken("https://kauth.kakao.com/oauth/token", param, member);
				//getUserInfo
				member = memberService.getSNSUserInfo("kakao",
						"https://kapi.kakao.com/v2/user/me?access_token=" + member.getAccess_token(), member);
				//JoinCheck
				MemberVO check = memberService.idCheck(member.getKakao_email());
				if (check == null) {
					member.setId(member.getKakao_email());
					memberService.addMember(member);
					check = memberService.idCheck(member.getKakao_email());
				}
				HttpSession session = request.getSession();
				session.setAttribute("member", check);
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/home.do");
		} catch (Exception e) {
			e.printStackTrace();
			rAttr.addAttribute("result", "loginFailed");
			String msg = "죄송합니다. 로그인에 실패했습니다.";
			mav.addObject("msg", msg);
			mav.setViewName("/member/loginForm");
		}
		return mav;
	}
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
	public ResponseEntity addMember(@ModelAttribute("member") MemberVO member,String sns,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
				memberService.addMember(member);
				HttpSession session = request.getSession();
			    session.setAttribute("member", member);
			    session.setAttribute("isLogOn", true);
		    message  = "<script>";
		    message +=" alert('가입을 환영합니다.');";
		    message += " location.href='"+request.getContextPath()+"/home.do';";
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
		
		//googleURL
		String googleUrl ="https://accounts.google.com/o/oauth2/v2/auth?"
				+ "redirect_uri="+SNSOauth.getGoogleredirecturl()
				+ "&response_type=code&client_id="+SNSOauth.getGoogleclientid()
				+ "&scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile&"
				+ "access_type=offline";
		mav.addObject("googleURL", googleUrl);
		
		//naverURL
		SecureRandom random=new SecureRandom();
		String state=new BigInteger(130,random).toString();
		HttpSession session=request.getSession();
		session.setAttribute("state", state);


		String naverUrl="https://nid.naver.com/oauth2.0/authorize?"
				+ "client_id="+SNSOauth.getNaverclientid()
				+ "&response_type=code&"
				+ "&redirect_uri="+SNSOauth.getNaverredirecturl()
				+ "&state="+state;
		mav.addObject("naverURL", naverUrl);
		
		//kakaoURL
		String kakaoUrl="https://kauth.kakao.com/oauth/authorize?client_id="
				+ SNSOauth.getKakaoclientid()
				+ "&redirect_uri="+SNSOauth.getKakaoredirecturl()
				+ "&response_type=code";
		mav.addObject("kakaoURL", kakaoUrl);
		
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

	@RequestMapping(value="/member/sendLoginForm.do",method=RequestMethod.GET)
	public ResponseEntity sendLoginForm(HttpServletRequest request) throws Exception {
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		 String message  = "<script> alert('로그인후 이용하실 수 있습니다');"
		    +" location.href='"+request.getContextPath()+"/member/loginForm.do';"
		    + " </script>";
		 resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}




}