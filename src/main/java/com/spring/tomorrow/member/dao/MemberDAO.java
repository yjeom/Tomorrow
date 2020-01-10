package com.spring.tomorrow.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberDAO {
	
	 public List selectAllMemberList(int start,int end) throws DataAccessException;
	 public int selectMemberCount() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws DataAccessException;
	 public String idCheck(String id) throws DataAccessException;

}