package com.spring.tomorrow.notice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;
import com.spring.tomorrow.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	 public List selectNoticeList(int page) throws DataAccessException;
	 public int insertNotice(NoticeVO noticeVO) throws DataAccessException ;
	 public int deleteNotice(int idx) throws DataAccessException;
	 public int updateNotice(NoticeVO noticeVO) throws DataAccessException;
	 public NoticeVO getNotice(NoticeVO noticeVO) throws DataAccessException;
}
