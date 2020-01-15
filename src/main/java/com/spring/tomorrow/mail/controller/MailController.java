package com.spring.tomorrow.mail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.mail.vo.MailVO;


public interface MailController {
	public ModelAndView sendWorryList(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView sendReplyList(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView sendWorryForm(HttpServletRequest request,HttpServletResponse response)
			throws DataAccessException;
	public ResponseEntity sendWorry(MailVO mailVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView receiveWorryList(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView receiveReplyList(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView getReceiveWorry(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ResponseEntity sendReply(MailVO mailVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView getSendWorry(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView getReceiveReply(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ModelAndView getSendReply(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException;
	public ResponseEntity deleteReceiveMail(int idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity deleteSendMail(int idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
