package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	
	MemberVO getMember(String userId);
	
	List<MemberVO> getAllMember();
	
//	List<MemberVO> memberPaging(Map<String, Integer> maps);
	
	int selectMemberTotalCnt(SqlSession sqlSession);
	
	
	int insertMember(MemberVO memberVO);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO memberVO);
}