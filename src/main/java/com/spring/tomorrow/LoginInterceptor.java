package com.spring.tomorrow;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uri=request.getRequestURI();
		System.out.println("uri"+uri);
		HttpSession session=request.getSession();
		Object isLogOn=session.getAttribute("isLogOn");
		if(isLogOn!=null) {
			return true;
		}
		else if(uri.contains("/member/loginForm")||uri.contains("/member/joinForm")||uri.contains("/member/idCheck")
				||uri.contains("/home")||uri.contains("/member/sendLoginForm")||uri.contains("/qna/qnaList")||uri.contains("/notice/noticeList")
				||uri.contains("/member/login")||uri.contains("/member/addMember")) {
			System.out.println("제외페이지");
			return true;
			
		}
		
		else {
			System.out.println(request.getContextPath()+"/member/sendLoginForm.do");
			response.sendRedirect(request.getContextPath()+"/member/sendLoginForm.do");
			return false;
		}
	}
	

}
