package com.spring.tomorrow;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.tomorrow.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String path=request.getServletPath();
		HttpSession session=request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		if(member!=null) {
			return true;
		}
		else if(path.equals("/")||path.equals("/member/loginForm.do")||path.equals("/member/joinForm.do")||path.equals("/member/idCheck.do")
				||path.equals("/home.do")||path.equals("/member/sendLoginForm.do")||path.equals("/qna/qnaList.do")
				||path.equals("/notice/noticeList.do")||path.equals("/notice/getNotice.do")||path.equals("/qna/getQna.do")
				||path.equals("/member/login.do")||path.equals("/member/addMember.do")) {
			return true;
			
		}
		
		else {
			response.sendRedirect(request.getContextPath()+"/member/sendLoginForm.do");
			return false;
		}
	}
	

}
