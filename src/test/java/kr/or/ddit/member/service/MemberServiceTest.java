package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
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
		MemberServiceI memberService = new MemberService();
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
		MemberServiceI memberService = new MemberService();
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
}
