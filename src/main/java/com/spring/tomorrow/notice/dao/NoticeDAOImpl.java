package com.spring.tomorrow.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.member.vo.MemberVO;
import com.spring.tomorrow.notice.vo.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeVO> selectNoticeList(HashMap<String, Object> map) throws DataAccessException {
		List<NoticeVO> noticeList = null;
		noticeList = sqlSession.selectList("mapper.notice.selectNoticeList",map);
		return noticeList;
	}

	public int insertNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=0;
		result=sqlSession.insert("mapper.notice.insertNotice",noticeVO);
		return result;
	}

	public int deleteNotice(int idx) throws DataAccessException {
		int result=0;
		result=sqlSession.delete("mapper.notice.deleteNotice",idx);
		return result;
	}

	public int updateNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=sqlSession.update("mapper.notice.updateNotice",noticeVO);
		return result;
	}

	public NoticeVO getNotice(NoticeVO noticeVO) throws DataAccessException {
		
		noticeVO=sqlSession.selectOne("mapper.notice.getNotice", noticeVO);
		return noticeVO;
	}

	public void noticeViewsUpdate(int idx) throws DataAccessException {
		sqlSession.update("mapper.notice.updateNoticeViews", idx);
	}

	public int selectNoticeCount() throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.notice.selectNoticeCount");
		return totalCount;
	}


}
