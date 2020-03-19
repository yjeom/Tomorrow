package com.spring.tomorrow.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addMember(@ModelAttribute("info") MemberVO memberVO,String sns,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity removeMember(int idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
                              RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView idCheck(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity reportMember(int member_idx,int receive_idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView reportCheck(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateMember( MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView googleCallback(@RequestParam String code,RedirectAttributes rAttr, HttpServletRequest request) ;
	public ModelAndView naverCallback(@RequestParam String code, @RequestParam String state, RedirectAttributes rAttr,
			HttpServletRequest request) ;
	public ModelAndView kakaoCallback(@RequestParam String code, RedirectAttributes rAttr,HttpServletRequest request);
	public ResponseEntity sendLoginForm(HttpServletRequest request) throws Exception;
}