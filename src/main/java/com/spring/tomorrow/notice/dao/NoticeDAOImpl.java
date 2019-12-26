package com.spring.tomorrow.notice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.notice.vo.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{

	@Override
	public List selectNoticeList(int page) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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
