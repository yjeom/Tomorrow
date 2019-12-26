package com.spring.tomorrow.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.notice.dao.NoticeDAO;
import com.spring.tomorrow.notice.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List selectNoticeList(int page) throws DataAccessException {
		List noticeList = null;
		noticeList = noticeDAO.selectNoticeList(page);
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
