package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDaoTest {

	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		answerMemberVo.setUsernm("브라운");
		answerMemberVo.setAlias("곰");
		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userId);
		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("1234", memberVo.getPassword());
		
		assertEquals(answerMemberVo.toString(), memberVo.toString());
		
	}
	
	@Test
	public void getAllMembertest() {
		
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		/***When***/
		List<MemberVO> memList = memberDao.getAllMember();
		/***Then***/
		assertEquals(15, memList.size());
	}
	
//	@Test
//	public void memberPaging() {
//		/***Given***/
//		MemberDaoI memberDao = new MemberDao();
//		Map<String, Integer> maps = new HashMap<>();
//		maps.put("page", 1);
//		maps.put("pageSize", 7);
//		/***When***/
//		List<MemberVO> memList = memberDao.memberPaging(maps);
//		/***Then***/
//		assertEquals(7,memList.size());
//	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		PageVO pageVo = new PageVO(1, 7);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//int page = 1;

		/***When***/
		List<MemberVO> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);

		/***Then***/
		assertEquals(7, memberList.size());
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
	}
	


}
