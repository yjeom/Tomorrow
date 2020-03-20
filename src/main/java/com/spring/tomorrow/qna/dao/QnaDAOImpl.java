package com.spring.tomorrow.qna.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.qna.vo.QnaVO;
import com.spring.tomorrow.qna.vo.ReplyVO;

@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public List<QnaVO> selectQnaList(HashMap<String, Object>map) throws DataAccessException {
		List<QnaVO> qnaList=null;
		qnaList=sqlSession.selectList("mapper.qna.selectQnaList", map);
		return qnaList;
	}

	public int selectQnaCount() throws DataAccessException {
		int totalCount=0;
		totalCount=sqlSession.selectOne("mapper.qna.selectQnaCount");
		return totalCount;
	}
	
	public int insertQna(QnaVO qnaVO) throws DataAccessException {
		return sqlSession.insert("mapper.qna.insertQna", qnaVO);
		
	}

	public List<ReplyVO> selectReplyList(HashMap<String, Object>map) throws DataAccessException {
		List<ReplyVO> replyList=sqlSession.selectList("mapper.qna.selectReplyList",map);
		return replyList;
	}

	public int selectReplyCount(int qna_idx) throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.qna.selectReplyCount", qna_idx);
		return totalCount;
	}

	public QnaVO getQna(int idx) throws DataAccessException {
		QnaVO qnaVO=sqlSession.selectOne("mapper.qna.selectQna",idx);
		return qnaVO;
	}

	public int insertReply(ReplyVO replyVO) throws DataAccessException {
		return sqlSession.insert("mapper.qna.insertReply", replyVO);
	}

	public QnaVO passwordCheck(HashMap<String, Object>map) throws DataAccessException {
		return sqlSession.selectOne("mapper.qna.passwordCheck",map);
	}

	public int updateQna(QnaVO qnaVO) throws DataAccessException {
		return sqlSession.update("mapper.qna.updateQna",qnaVO);
	}

	public int deleteQna(int idx) throws DataAccessException {
		return sqlSession.delete("mapper.qna.deleteQna",idx);
	}

	public int updateReply(ReplyVO replyVO) throws DataAccessException {
		return sqlSession.update("mapper.qna.updateReply",replyVO);
	}

	public int deleteReply(int idx) throws DataAccessException {
		return sqlSession.delete("mapper.qna.deleteReply",idx);
	}

	public int updateViews(int idx) throws DataAccessException {
		return sqlSession.update("mapper.qna.updateViews",idx);
	}

	public List<QnaVO> selectMyQnaList(HashMap<String, Object> map) throws DataAccessException {
		return sqlSession.selectList("mapper.qna.selectMyQnaList",map);
	}

	@Override
	public int selectMyQnaCount(int idx) throws DataAccessException {
		return sqlSession.selectOne("mapper.qna.selectMyQnaCount",idx);
	}

}
