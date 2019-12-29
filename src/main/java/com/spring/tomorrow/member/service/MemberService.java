package com.spring.tomorrow.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers(int curPage) throws DataAccessException;
	 public int membersCount() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public String joinIDCheck(String id)throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws Exception;
}