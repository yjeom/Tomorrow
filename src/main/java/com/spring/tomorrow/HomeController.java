package com.spring.tomorrow;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.mail.service.MailService;
import com.spring.tomorrow.member.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = {"/home.do","/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {
		mav=new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member=(MemberVO) session.getAttribute("member");
		if(member!=null) {
			
			int newWorry=mailService.getNewReceiveWorry(member.getIdx());
			mav.addObject("newWorry", newWorry);
		}
		mav.setViewName("/home");
		return mav;
	}
	
}
