package com.spring.tomorrow.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.tomorrow.notice.dao.NoticeDAO;
import com.spring.tomorrow.notice.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List selectNoticeList(int start,int end)  {
		List noticeList = null;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		noticeList = noticeDAO.selectNoticeList(map);
		return noticeList;
	}

	public int insertNotice(NoticeVO noticeVO)  {
		int result=0;
		result=noticeDAO.insertNotice(noticeVO);
		return result;
	}

	public int deleteNotice(int idx)  {
		int result=0;
		result=noticeDAO.deleteNotice(idx);
		return result;
	}

	public int updateNotice(NoticeVO noticeVO)  {
		int result=0;
		result =noticeDAO.updateNotice(noticeVO);
		return result;
	}

	public NoticeVO getNotice(NoticeVO noticeVO)  {
		
		noticeVO=noticeDAO.getNotice(noticeVO);
		return noticeVO;
	}

	public void updateNoticeViews(int idx)  {
		noticeDAO.noticeViewsUpdate(idx);
		
	}

	public int selectNoticeCount()  {
		int totalCount=noticeDAO.selectNoticeCount();
		return totalCount;
	}

}
