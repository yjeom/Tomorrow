package com.spring.tomorrow.qna.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

public interface QnaDAO {
	
	public List<QnaVO> selectQnaList(int curPage)throws DataAccessException;
	public int selectQnaCount()throws DataAccessException;
	public int insertQna(QnaVO qnaVO)throws DataAccessException;
	public QnaVO getQna(int idx)throws DataAccessException;
	public List<ReplyVO> selectReplyList(int qna_idx,int start,int end)throws DataAccessException;
	public int selectReplyCount(int qna_idx)throws DataAccessException;
	public int insertReply(ReplyVO replyVO)throws DataAccessException;
	public QnaVO passwordCheck(int idx,int pwd)throws DataAccessException;
	public int updateQna(QnaVO qnaVO)throws DataAccessException;
	public int deleteQna(int idx)throws DataAccessException;
	public int updateReply(ReplyVO replyVO)throws DataAccessException;
	public int deleteReply(int idx)throws DataAccessException;

}
