package com.spring.tomorrow.member.service;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.spring.tomorrow.SocialLogin;
import com.spring.tomorrow.member.dao.MemberDAO;
import com.spring.tomorrow.member.vo.MemberVO;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	SocialLogin login;
	
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
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
		
	}
	@Override
	public MemberVO getToken(String apiUrl, String param,MemberVO memberVO) {
		login=new SocialLogin();
		String tokenJson = login.getHttpConnection(apiUrl, param);
		System.out.println(tokenJson.toString());
		JSONObject jsonObj=new JSONObject(tokenJson);
		System.out.println(jsonObj.getString("access_token").toString()+"액세스토큰");
		memberVO.setAccess_token(jsonObj.getString("access_token").toString());
		if(!(jsonObj.isNull("refresh_token"))) {
		memberVO.setRefresh_token(jsonObj.getString("refresh_token").toString());
		}
		return memberVO;
	}
	@Override
	public MemberVO getSNSUserInfo(String sns,String apiUrl, MemberVO memberVO) {
		login=new SocialLogin();
		String UserJson=login.getHttpConnection(apiUrl);
		System.out.println(UserJson.toString());
		JSONObject jsonObj=new JSONObject(UserJson);
		if(sns.equals("google")) {
		memberVO.setGoogle_email(jsonObj.getString("email").toString());
		System.out.println(jsonObj.getString("email").toString()+"이메일");
		}
		else if(sns.equals("naver")) {
			JSONObject response=jsonObj.getJSONObject("response");
			System.out.println(response.get("email").toString());
			memberVO.setNaver_email(response.get("email").toString());
		}
		else if(sns.equals("kakao")) {
			JSONObject response=jsonObj.getJSONObject("kakao_account");
			System.out.println(response.get("email").toString());
			memberVO.setKakao_email(response.get("email").toString());
		}
		
		return memberVO;
	}
	@Override
	public MemberVO getSNSJoinCheck(String sns, String email) {
		MemberVO memberVO=null;
		if(sns.equals("google")) {
			memberVO= memberDAO.googleJoinCheck(email);
		}
		else if(sns.equals("naver")) {
			memberVO=memberDAO.naverJoinCheck(email);
		}
		else if(sns.equals("kakao")) {
			memberVO=memberDAO.kakaoJoinCheck(email);
		}
		return memberVO;
	}

}