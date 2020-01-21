package com.spring.tomorrow.qna.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

public interface QnaDAO {
	
	public List<QnaVO> selectQnaList(HashMap<String, Object>map)throws DataAccessException;
	public int selectQnaCount()throws DataAccessException;
	public int insertQna(QnaVO qnaVO)throws DataAccessException;
	public QnaVO getQna(int idx)throws DataAccessException;
	public List<ReplyVO> selectReplyList(HashMap<String, Object>map)throws DataAccessException;
	public int selectReplyCount(int qna_idx)throws DataAccessException;
	public int insertReply(ReplyVO replyVO)throws DataAccessException;
	public QnaVO passwordCheck(HashMap<String, Object>map)throws DataAccessException;
	public int updateQna(QnaVO qnaVO)throws DataAccessException;
	public int deleteQna(int idx)throws DataAccessException;
	public int updateReply(ReplyVO replyVO)throws DataAccessException;
	public int deleteReply(int idx)throws DataAccessException;
	public int updateViews(int idx)throws DataAccessException;
	

}
