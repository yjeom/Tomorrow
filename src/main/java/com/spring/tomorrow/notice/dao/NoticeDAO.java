package com.spring.tomorrow.notice.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;
import com.spring.tomorrow.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	 public List<NoticeVO> selectNoticeList(int start,int end) throws DataAccessException;
	 public int selectNoticeCount() throws DataAccessException;
	 public int insertNotice(NoticeVO noticeVO) throws DataAccessException ;
	 public int deleteNotice(int idx) throws DataAccessException;
	 public int updateNotice(NoticeVO noticeVO) throws DataAccessException;
	 public NoticeVO getNotice(NoticeVO noticeVO) throws DataAccessException;
	 public void noticeViewsUpdate(int idx)throws DataAccessException;
}
