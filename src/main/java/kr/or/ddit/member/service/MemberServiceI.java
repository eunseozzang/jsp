package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

public interface MemberServiceI {
	
	MemberVO getMember(String userId);
	
	List<MemberVO> getAllMember();
	
//	Map<String, Object> memberPaging(Map<String, Integer> maps);
	
	
	int insertMember(MemberVO memberVO);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO memberVO);
}
