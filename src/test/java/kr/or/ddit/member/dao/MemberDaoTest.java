package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
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
		MemberDao memberDao = new MemberDao();
		/***When***/
		List<MemberVO> memList = memberDao.getAllMember();
		/***Then***/
		assertEquals(5, memList.size());
	}

}
