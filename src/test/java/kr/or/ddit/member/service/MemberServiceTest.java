package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	
	MemberServiceI memberService;
	
	@Before
	public void setup() {
		memberService = new MemberService();
		String userid = "eunseo";
		memberService.deleteMember(userid);
	}
	
	
	@Test
	public void getMembertest() {
		/***Given***/
		memberService = new MemberService();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
	}
	
	@Test
	public void getAllMembertest() {
		/***Given***/
		memberService = new MemberService();
		/***When***/
		List<MemberVO> memList = memberService.getAllMember();
		/***Then***/
		assertEquals(15, memList.size());
	}
	
//	@Test
//	public void memberPaging() {
//		/***Given***/
//		MemberServiceI memberService = new MemberService();
//		Map<String, Integer> maps = new HashMap<>();
//		maps.put("page", 1);
//		maps.put("pageSize", 7);
//		/***When***/
//		List<MemberVO> memList = memberService.memberPaging();
//		/***Then***/
//		assertEquals(5,memList.size());
//	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		memberService = new MemberService();
		PageVO pageVo = new PageVO(1, 7);

		/***When***/
		//memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVO> memberList = (List<MemberVO>)map.get("memberList");
		
		//생성해야할 page 수
		int pages = (int)map.get("pages");

		/***Then***/
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug("{}", locale);
		}
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		memberService = new MemberService();
		memberService.deleteMember("eunseo");
		MemberVO memberVO = new MemberVO("eunseo", "1234", "최은서", "es", "대전 중구 태평로 15", "139-802", "34890", "d:\\profile\\ces.png", "ces.png");
		/***When***/
		int insertCnt = memberService.insertMember(memberVO);
		/***Then***/
		assertEquals(1,insertCnt);
		
		
	}
}
