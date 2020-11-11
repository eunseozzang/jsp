package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberServiceTest extends ModelTestConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@Test
	public void insertMember_SUCCESS_Test() {
		
		/***Given***/
		MemberVO memberVO = new MemberVO("test", "1111", "대덕인재", "개발원", "", "", "", "","");
		/***When***/
		int insertCnt = memberService.insertMember(memberVO);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	//@Test
	public void insertMember_FAIL_Test() {
		
		/***Given***/
		MemberVO memberVO = new MemberVO("ddit", "1111", "대덕인재", "개발원", "", "", "", "", "");
		/***When***/
		int insertCnt = memberService.insertMember(memberVO);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid = "sally";
		/***When***/
		MemberVO dbVO = memberService.getMember(userid);
		/***Then***/
		assertEquals("샐리", dbVO.getUsernm());
	}
	
	@Test
	public void getAllMemberTest() {
		
		/***Given***/
		
		/***When***/
		List<MemberVO> list = memberService.getAllMember();
		/***Then***/
		assertEquals(18, list.size());
	}
	
	@Test
	public void deleteMemberTest() {
		
		/***Given***/
		String userid="sally";
		/***When***/
		int cnt = memberService.deleteMember(userid);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		String usernm = "무지2";
		String pass = "muziPass2";
		String alias = "토끼2";
		String userid = "muzi";
		MemberVO memberVO = new MemberVO();
		memberVO.setUsernm(usernm);
		memberVO.setPass(pass);
		memberVO.setAlias(alias);
		memberVO.setUserid(userid);
		/***When***/
		int cnt = memberService.updateMember(memberVO);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		PageVO pageVo = new PageVO(1, 5);

		/***When***/
		//memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVO> memberList = (List<MemberVO>)map.get("memberList");
		
		//생성해야할 page 수
		int pages = (int)map.get("pages");

		/***Then***/
		assertEquals(5, memberList.size());
		assertEquals(4, pages);
		
	}
	
	

}
