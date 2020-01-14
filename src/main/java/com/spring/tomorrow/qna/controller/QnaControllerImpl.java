package com.spring.tomorrow.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.spring.tomorrow.notice.vo.NoticeVO;
import com.spring.tomorrow.qna.service.QnaService;
import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

@Controller("qnaController")
public class QnaControllerImpl implements QnaController{

	@Autowired
	private QnaService qnaService;
	@Autowired
	QnaVO qnaVO;
	@Autowired
	ReplyVO replyVO;
	
	@RequestMapping(value="/qna/qnaList.do", method = RequestMethod.GET)
	public ModelAndView qnaList(@RequestParam(defaultValue="1") int curPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount=qnaService.selectQnaCount();
		Paging paging=new Paging(totalCount, curPage);
		List<QnaVO> qnaList=null;
		qnaList=qnaService.selectQnaList(paging.getStartIndex(),paging.getEndIndex());
		System.out.println(qnaList.isEmpty());
		ModelAndView mav=new ModelAndView();
		mav.addObject("qnaList",qnaList);
		mav.addObject("paging",paging);
		mav.setViewName("/qna/qnaList");
		return mav;
	}
	
	@RequestMapping(value="/qna/qnaForm.do",method=RequestMethod.GET)
	public ModelAndView qnaForm(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		boolean isNew=true;
		if(request.getParameter("idx")!=null) {
			qna.setIdx(Integer.parseInt(request.getParameter("idx")));
			qna=qnaService.getQna(qna.getIdx());
			mav.addObject("qna", qna);
			isNew=false;
		}
		mav.addObject("isNew", isNew);
		mav.setViewName("/qna/qnaForm");
		return mav;
	}
	@RequestMapping(value="/qna/insertQna.do",method=RequestMethod.POST)
	public ResponseEntity addQna(@ModelAttribute("qna") QnaVO qna, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			qnaService.insertQna(qna);
		    message  = "<script>";
		    message +=" alert('QnA�� ����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/qnaList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/qnaForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}
	
	@RequestMapping(value= {"/qna/getQna.do","/qna/updateForm.do"},method=RequestMethod.GET)
	public ModelAndView getQnA(@RequestParam int idx,@RequestParam(defaultValue="1")int curPage, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		if(request.getServletPath().equals("/qna/updateForm.do")) {
			mav.addObject("isUpdate", request.getParameter("re"));
		}
		
		QnaVO qna=qnaService.getQna(idx);
		qnaService.updateViews(idx);
		mav.addObject("qna", qna);
		int totalCount=qnaService.selectReplyCount(idx);
		Paging paging=new Paging(totalCount, curPage);
		List<ReplyVO> replyList=qnaService.selectReplyList(idx, paging.getStartIndex(),paging.getEndIndex());
		mav.addObject("reList", replyList);
		mav.addObject("paging", paging);
		
		mav.setViewName("/qna/getQna");
		
		return mav;
	}

	@RequestMapping(value="/qna/insertReply.do",method=RequestMethod.POST)
	public ResponseEntity addReply(@ModelAttribute("reply")ReplyVO reply, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			qnaService.insertReply(reply);
		    message  = "<script>";
		    message +=" alert('�亯�� ����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+reply.getQna_idx()+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+reply.getQna_idx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		return resEntity;
	}

	@RequestMapping(value="/qna/passwordForm.do",method=RequestMethod.GET)
	public ModelAndView passwordForm(@RequestParam int idx,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("idx", idx);
		mav.setViewName("/qna/passwordForm");
		return mav;
	}
	
	@RequestMapping(value="/qna/passwordForm.do",method=RequestMethod.POST)
	public ModelAndView passwordCheck(@RequestParam int idx,@RequestParam int pwd,RedirectAttributes rAttr,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		QnaVO qna=qnaService.passwordCheck(idx, pwd);
		if(qna!=null) {
			mav.setViewName("redirect:/qna/getQna.do?idx="+qna.getIdx());
		}
		else {
			rAttr.addFlashAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			mav.setViewName("redirect:/qna/passwordForm.do?idx="+idx);
		}
		return mav;
	}

	@RequestMapping(value="/qna/updateQna.do",method=RequestMethod.POST)
	public ResponseEntity updateQna(@ModelAttribute QnaVO qna, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			if(qna.getSecret_yn()==0) {
				qna.setPwd(0);
			}
			qnaService.updateQna(qna);
		    message  = "<script>";
		    message +=" alert('QnA�� �����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+qna.getIdx()+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/qnaForm.do?idx="+qna.getIdx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value="/qna/deleteQna.do",method=RequestMethod.GET)
	public ResponseEntity deleteQna(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			qnaService.deleteQna(idx);
		    message  = "<script>";
		    message +=" alert('QnA�� �����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/qnaList.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/qnaForm.do?idx="+idx+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value="/qna/updateReply.do",method=RequestMethod.GET)
	public ResponseEntity updateReply(@ModelAttribute ReplyVO replyVO,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			qnaService.updateReply(replyVO);
		    message  = "<script>";
		    message +=" alert('�亯�� �����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+replyVO.getQna_idx()+"&curPage="
		    			+request.getParameter("curPage")+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/updateForm.do?idx="+replyVO.getQna_idx()+
		    			"&curPage="+request.getParameter("curPage")+"&re="+replyVO.getIdx()+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value="/qna/deleteReply.do",method=RequestMethod.GET)
	public ResponseEntity deleteReply(@RequestParam int idx, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			qnaService.deleteReply(idx);
		    message  = "<script>";
		    message +=" alert('�亯�� �����߽��ϴ�');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+request.getParameter("qna_idx")+"';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���');";
		    message += " location.href='"+request.getContextPath()+"/qna/getQna.do?idx="+request.getParameter("qna_idx")
		    			+"&curPage="+request.getParameter("curPage")+"';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

}