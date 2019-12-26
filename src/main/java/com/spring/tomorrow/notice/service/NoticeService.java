package com.spring.tomorrow.notice.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.notice.vo.NoticeVO;

public interface NoticeService {
	
	 public List selectNoticeList(int page) throws DataAccessException;
	 public int insertNotice(NoticeVO noticeVO) throws DataAccessException ;
	 public int deleteNotice(int idx) throws DataAccessException;
	 public int updateNotice(int idx) throws DataAccessException;
	 public int getNotice(int idx) throws DataAccessException;

}
