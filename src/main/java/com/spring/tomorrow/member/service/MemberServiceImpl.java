package com.spring.tomorrow.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tomorrow.member.dao.MemberDAO;
import com.spring.tomorrow.member.vo.MemberVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int membersCount() throws DataAccessException {
		int totalCount=memberDAO.selectMemberCount();
		return totalCount;
	}
	public List listMembers(int start,int end) throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList(start,end);
		return membersList;
	}

	public int addMember(MemberVO member) throws DataAccessException {
		return memberDAO.insertMember(member);
	}

	public int removeMember(int idx) throws DataAccessException {
		return memberDAO.deleteMember(idx);
	}
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		return memberDAO.login(memberVO);
	}
	public String idCheck(String id) throws DataAccessException {
		return memberDAO.idCheck(id);
	}
	public void reportMember(int idx) throws DataAccessException {
		memberDAO.updateReportCount(idx);
		
	}
	public void reportCheck(int idx) throws DataAccessException {
		memberDAO.updateReportCheck(idx);
		
	}


}