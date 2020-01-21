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

	public int selectMemberCount() throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.member.selectMemberCount");
		
		return totalCount;
	}
	
	public List selectAllMemberList(HashMap<String, Object>map) throws DataAccessException {
		
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList",map);
		return membersList;
	}

	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	public int deleteMember(int idx) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", idx);
		return result;
	}
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		  MemberVO vo = sqlSession.selectOne("mapper.member.login",memberVO);
		return vo;
	}

	public String idCheck(String id) throws DataAccessException {
		id=sqlSession.selectOne("mapper.member.joinIdCheck", id);
		return id;
	}

	public void updateReportCount(int idx) throws DataAccessException {
		sqlSession.update("mapper.member.updateReportCount",idx);
	}

	public void updateReportCheck(int idx) throws DataAccessException {
		sqlSession.update("mapper.member.updateReportCheck",idx);
		
	}


}