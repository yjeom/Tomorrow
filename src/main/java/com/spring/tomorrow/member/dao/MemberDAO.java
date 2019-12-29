package com.spring.tomorrow.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberDAO {
	
	 public List selectAllMemberList(int curPage) throws DataAccessException;
	 public int selectMemberCount() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws DataAccessException;
	 public String joinIDCheck(String id) throws DataAccessException;

}