package com.spring.tomorrow.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tomorrow.Paging;
import com.spring.tomorrow.qna.service.QnaService;
import com.spring.tomorrow.qna.vo.QnaVO;

@Controller("qnaController")
public class QnaControllerImpl implements QnaController{

	@Autowired
	private QnaService qnaService;
	@Autowired
	QnaVO qnaVO;
	
	@RequestMapping(value="/qna/qnaList.do", method = RequestMethod.GET)
	public ModelAndView qnaList(@RequestParam(defaultValue="1") int curPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int totalCount=qnaService.selectQnaCount();
		Paging paging=new Paging(totalCount, curPage);
		List<QnaVO> qnaList=null;
		qnaList=qnaService.selectQnaList(curPage);
		ModelAndView mav=new ModelAndView();
		mav.addObject("qnaList",qnaList);
		mav.addObject("paging",paging);
		mav.setViewName("/qna/qnaList");
		return mav;
	}

}
