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
	
	public List selectNoticeList(int start,int end) throws DataAccessException {
		List noticeList = null;
		noticeList = noticeDAO.selectNoticeList(start,end);
		return noticeList;
	}

	public int insertNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=0;
		result=noticeDAO.insertNotice(noticeVO);
		return result;
	}

	public int deleteNotice(int idx) throws DataAccessException {
		int result=0;
		result=noticeDAO.deleteNotice(idx);
		return result;
	}

	public int updateNotice(NoticeVO noticeVO) throws DataAccessException {
		int result=0;
		result =noticeDAO.updateNotice(noticeVO);
		return result;
	}

	public NoticeVO getNotice(NoticeVO noticeVO) throws DataAccessException {
		
		noticeVO=noticeDAO.getNotice(noticeVO);
		return noticeVO;
	}

	public void updateNoticeViews(int idx) throws DataAccessException {
		noticeDAO.noticeViewsUpdate(idx);
		
	}

	public int selectNoticeCount() throws DataAccessException {
		int totalCount=noticeDAO.selectNoticeCount();
		return totalCount;
	}

}