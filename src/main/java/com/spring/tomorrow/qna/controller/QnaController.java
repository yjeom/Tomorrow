package com.spring.tomorrow.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.tomorrow.notice.vo.NoticeVO;
import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

public interface QnaController {
	
	public ModelAndView qnaList(@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView qnaForm(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ResponseEntity addQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView getQnA(@RequestParam int idx,@RequestParam(defaultValue="1") int curPage,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addReply(@ModelAttribute("reply") ReplyVO reply,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ModelAndView passwordForm(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView passwordCheck(@RequestParam int idx,@RequestParam int pwd,RedirectAttributes rAttr,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ResponseEntity deleteQna(@RequestParam int idx,HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	public ResponseEntity updateReply(@ModelAttribute ReplyVO replyVO,HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ResponseEntity deleteReply(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
