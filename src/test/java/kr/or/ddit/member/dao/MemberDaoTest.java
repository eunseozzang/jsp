package kr.or.ddit.member.dao;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDaoTest {
	
//	테스트 메소드 : 
	
//	@BeforeClass (static)
//	@Before => @Test => @After
//	@Before => @Test => @After
//	@Before => @Test => @After
//
//	@AfterClass (static)
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "eunseo";
		memberDao.deleteMember(userid);
	}

	// 실행하려고하는 메소드의 이름뒤에 test만 붙여준다.
	@Test
	public void getMembertest() {
		/***Given***/
		memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		answerMemberVo.setUsernm("브라운");
		answerMemberVo.setAlias("곰");
		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		
	}
	
	@Test
	public void getAllMembertest() {
		
		/***Given***/
		memberDao = new MemberDao();
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
		memberDao = new MemberDao();
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
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
	}
	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		memberDao = new MemberDao();
		memberDao.deleteMember("eunseo");
		MemberVO memberVO = new MemberVO("eunseo", "1234", "최은서", "es", "대전 중구 태평로 15", "139-802", "34890", "d:\\profile\\ces.png", "ces.png");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	


}
