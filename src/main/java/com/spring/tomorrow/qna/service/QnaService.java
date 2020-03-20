package com.spring.tomorrow.qna.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

public interface QnaService {
	
	public List<QnaVO> selectQnaList(int start,int end);
	public List<QnaVO> selectMyQnaList(int idx,int start,int end);
	public int selectQnaCount();
	public int selectMyQnaCount(int idx);
	public int insertQna(QnaVO qnaVO);
	public List<ReplyVO> selectReplyList(int qna_idx,int start,int end);
	public int selectReplyCount(int qna_idx);
	public QnaVO getQna(int idx);
	public int insertReply(ReplyVO replyVO);
	public QnaVO passwordCheck(int idx,int pwd);
	public int updateQna(QnaVO qnaVO);
	public int deleteQna(int idx);
	public int updateReply(ReplyVO replyVO);
	public int deleteReply(int idx);
	public int updateViews(int idx);
}
