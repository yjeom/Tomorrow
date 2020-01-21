package com.spring.tomorrow.member.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberDAO {
	
	 public List selectAllMemberList(HashMap<String, Object>map) throws DataAccessException;
	 public int selectMemberCount() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(int idx) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws DataAccessException;
	 public String idCheck(String id) throws DataAccessException;
	 public void updateReportCount(int idx)throws DataAccessException;
	 public void updateReportCheck(int idx)throws DataAccessException;

}