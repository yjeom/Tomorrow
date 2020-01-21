package com.spring.tomorrow.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.tomorrow.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers(int start,int end) ;
	 public int membersCount() ;
	 public int addMember(MemberVO memberVO) ;
	 public String idCheck(String id);
	 public int removeMember(int idx) ;
	 public MemberVO login(MemberVO memberVO) ;
	 public void reportMember(int idx);
	 public void reportCheck(int idx);
}