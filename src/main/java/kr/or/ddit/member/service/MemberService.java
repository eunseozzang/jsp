package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	@Resource(name="memberRepository")
	private MemberDaoI memberDao;
	
	public MemberService() {
//		memberDao = new MemberDao();
	}
	
	
	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}

	
	@Override
	public List<MemberVO> getAllMember() {
		return memberDao.getAllMember();
	}

	
//	@Override
//	public Map<String, Object> memberPaging(Map<String, Integer> maps) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("memberList", memberDao.memberPaging(maps));
//		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
//		int pages = (int) Math.ceil((double) totalCnt/ maps.get("pageSize"));
//		map.put("pages", pages);
//		
//		return map;
//	}
	


	@Override
	public int insertMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO);
	}


	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}


	@Override
	public int updateMember(MemberVO memberVO) {
		return memberDao.updateMember(memberVO);
	}
	
	@Override
	public Map<String, Object> selectMemberPageList(PageVO pageVO) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(sqlSession, pageVO));
		
		//15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14.... 올림을 하여 3개의 페이지가 필요
		//Math.ceil()
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		int pages = (int)Math.ceil( (double) totalCnt/ pageVO.getPageSize() );
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}
}
