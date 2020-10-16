package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String userId) {
		
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// 우리는 controller기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		// Mock(가짜)
		
//		MemberVO memberVo = new MemberVO();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("1234");
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select
		// 한건 : SelectOne
		// 여러건 : selectList
		
		MemberVO memberVO = sqlSession.selectOne("member.getMember",userId);
		
		sqlSession.close();
		
		return memberVO;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memList = sqlSession.selectList("member.getAllMember");
		
		sqlSession.close();
		
		return memList;
	}

	// 사람수 가져오는거
	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}
	
	@Override
	public List<MemberVO> selectMemberPageList(SqlSession sqlSession, PageVO pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}
	
	/** 내가 한거
	@Override
	public List<MemberVO> memberPaging(Map<String, Integer> maps) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memList = sqlSession.selectList("member.memberPaging",maps);
		
		sqlSession.close();
		return memList;
	}
	**/

}
