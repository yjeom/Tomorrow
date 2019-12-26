package com.spring.tomorrow.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.tomorrow.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList(int page) throws DataAccessException {
		if(page==0)page=1;
		int totalCount=sqlSession.selectOne("mapper.member.selectMemberCount");
		int totalPage=0;
		if(totalCount%10>0)
			totalPage=(totalCount/10)+1;
		else
			totalPage=totalCount/10;
		int startPage=((page-1)/10)*10+1;
		int endPage=startPage+10-1;
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("startPage", startPage);
		map.put("endPage", endPage);	
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList",map);
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}
	
	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		  MemberVO vo = sqlSession.selectOne("mapper.member.login",memberVO);
		return vo;
	}
}