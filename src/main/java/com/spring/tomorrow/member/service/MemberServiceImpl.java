package com.spring.tomorrow.member.service;

import java.util.HashMap;
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

	public int membersCount()  {
		int totalCount=memberDAO.selectMemberCount();
		return totalCount;
	}
	public List listMembers(int start,int end)  {
		List membersList = null;
		HashMap<String,Object>map =new HashMap<String, Object>();
		map.put("start", start);
		map.put("end",end);
		membersList = memberDAO.selectAllMemberList(map);
		return membersList;
	}

	public int addMember(MemberVO member)  {
		return memberDAO.insertMember(member);
	}

	public int removeMember(int idx)  {
		return memberDAO.deleteMember(idx);
	}
	
	public MemberVO login(MemberVO memberVO) {
		return memberDAO.login(memberVO);
	}
	public String idCheck(String id)  {
		return memberDAO.idCheck(id);
	}
	public void reportMember(int idx)  {
		memberDAO.updateReportCount(idx);
		
	}
	public void reportCheck(int idx)  {
		memberDAO.updateReportCheck(idx);
		
	}


}