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
	
	@Override
	public List selectNoticeList(int page) throws DataAccessException {
		if(page==0)page=1;
		int totalCount=sqlSession.selectOne("mapper.notice.selectNoticeCount");
		int totalPage=0;
		if(totalCount%10>0)
			totalPage=(totalCount/10)+1;
		else
			totalPage=totalCount/10;
		int startPage=((page-1)/10)*10+1;
		int endPage=startPage+10-1;
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("startPage", startPage);
		map.put("endPage", endPage);	
		List<NoticeVO> noticeList = null;
		noticeList = sqlSession.selectList("mapper.notice.selectNoticeList",map);
		return noticeList;
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=0;
		result=sqlSession.insert("mapper.notice.insertNotice",noticeVO);
		return result;
	}

	@Override
	public int deleteNotice(int idx) throws DataAccessException {
		int result=0;
		result=sqlSession.delete("mapper.notice.deleteNotice",idx);
		return result;
	}

	@Override
	public int updateNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=sqlSession.update("mapper.notice.updateNotice",noticeVO);
		return result;
	}

	@Override
	public NoticeVO getNotice(NoticeVO noticeVO) throws DataAccessException {
		
		noticeVO=sqlSession.selectOne("mapper.notice.getNotice", noticeVO);
		return noticeVO;
	}

}
