package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public interface MemberDaoI {
	
	MemberVO getMember(String userId);
	
	List<MemberVO> getAllMember();
	
//	List<MemberVO> memberPaging(Map<String, Integer> maps);
	
	int selectMemberTotalCnt(SqlSession sqlSession);
	
	List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pageVo);
}
