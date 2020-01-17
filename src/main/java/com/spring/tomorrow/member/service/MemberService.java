package com.spring.tomorrow.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers(int start,int end) throws DataAccessException;
	 public int membersCount() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public String idCheck(String id)throws DataAccessException;
	 public int removeMember(int idx) throws DataAccessException;
	 public MemberVO login(MemberVO memberVO) throws DataAccessException;
	 public void reportMember(int idx)throws DataAccessException;
	 public void reportCheck(int idx)throws DataAccessException;
}