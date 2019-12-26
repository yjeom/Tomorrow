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
		System.out.println(noticeList.size()+"noticeList");
		return noticeList;
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(int idx) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(int idx) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotice(int idx) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
