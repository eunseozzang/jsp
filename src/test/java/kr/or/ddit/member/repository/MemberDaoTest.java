package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDaoTest extends ModelTestConfig{
	
	@Resource(name="memberRepository")
	private MemberDaoI memberDao;
	
	@Test
	public void getAllMemberTest() {
		
		/***Given***/

		/***When***/
		List<MemberVO> memberList = memberDao.getAllMember();
		
		/***Then***/
		assertTrue(memberList.size() > 10);
	}
	
	@Test
	public void getMemberTest(){
		/***Given***/
		String userid = "sally";
		/***When***/
		MemberVO dbVO = memberDao.getMember(userid);
		/***Then***/
		assertEquals("샐리", dbVO.getUsernm());
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		
		/***Given***/

		/***When***/
		int cnt = memberDao.selectMemberTotalCnt();
		/***Then***/
		assertTrue(cnt > 10);
	}
	
	@Test
	public void selectMemberPageListTest() {
		
		/***Given***/
		PageVO pageVo = new PageVO(1, 5);
		//int page = 1;

		/***When***/
		List<MemberVO> memberList = memberDao.selectMemberPageList(pageVo);

		/***Then***/
		assertEquals(5, memberList.size());
	}
	
	@Test
	public void insertMemberTest() {
		
		/***Given***/
		MemberVO memberVO = new MemberVO("test", "1111", "대덕인재", "개발원", "", "", "", "","");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String userid = "muzi";
		/***When***/
		int chk = memberDao.deleteMember(userid);
		/***Then***/
		assertEquals(1, chk);
		
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
		int cnt = memberDao.updateMember(memberVO);
		/***Then***/
		assertEquals(1, cnt);
	}
}
