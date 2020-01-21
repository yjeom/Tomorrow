package com.spring.tomorrow.notice.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.notice.vo.NoticeVO;

public interface NoticeService {
	
	 public List selectNoticeList(int start,int end) ;
	 public int selectNoticeCount() ;
	 public int insertNotice(NoticeVO noticeVO)  ;
	 public int deleteNotice(int idx) ;
	 public int updateNotice(NoticeVO noticeVO) ;
	 public NoticeVO getNotice(NoticeVO noticeVO) ;
	 public void updateNoticeViews(int idx) ;

}
