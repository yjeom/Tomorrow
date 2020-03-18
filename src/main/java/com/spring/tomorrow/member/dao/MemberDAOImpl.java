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
	public int selectMemberCount() throws DataAccessException {
		int totalCount=sqlSession.selectOne("mapper.member.selectMemberCount");
		return totalCount;
	}
	@Override
	public List selectAllMemberList(HashMap<String, Object>map) throws DataAccessException {
		
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList",map);
		return membersList;
	}

	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}
	@Override
	public int deleteMember(int idx) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", idx);
		return result;
	}
	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException{
		  MemberVO vo = sqlSession.selectOne("mapper.member.login",memberVO);
		return vo;
	}
	@Override
	public String idCheck(String id) throws DataAccessException {
		id=sqlSession.selectOne("mapper.member.joinIdCheck", id);
		return id;
	}
	@Override
	public void updateReportCount(int idx) throws DataAccessException {
		sqlSession.update("mapper.member.updateReportCount",idx);
	}
	@Override
	public void updateReportCheck(int idx) throws DataAccessException {
		sqlSession.update("mapper.member.updateReportCheck",idx);
		
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.update("mapper.member.updateMember",memberVO);
		
	}
	@Override
	public MemberVO googleJoinCheck(String email) throws DataAccessException {
		return sqlSession.selectOne("mapper.member.selectGoogleEmail", email);
	}

	@Override
	public MemberVO naverJoinCheck(String email) throws DataAccessException {
		return sqlSession.selectOne("mapper.member.selectNaverEmail", email);
	}
	@Override
	public MemberVO kakaoJoinCheck(String email) throws DataAccessException {
		return sqlSession.selectOne("mapper.member.selectKakaoEmail", email);
	}


}