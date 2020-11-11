package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
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



	@Override
	public int insertMember(MemberVO memberVO) {
		
//		logger.debug("첫번째 insert 시작전");
		logger.debug("서비스1");
//		memberDao.insertMember(memberVO);
		logger.debug("서비스2");
//		logger.debug("첫번째 insert 종료후");
//		logger.debug("두번째 insert 시작전");
//		memberDao.insertMember(memberVO);
//		logger.debug("두번째 insert 종료후");
		
		//첫번째 쿼리 정상실행
		//두번째쿼리 PRIMARY KEY  제약조건 실행실패
		//첫번째는 성공했지만 트랜잭션 설정이 service
		//모든 실행쿼리를 rollback 처리한다
		
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
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(pageVO));
		
		//15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14.... 올림을 하여 3개의 페이지가 필요
		//Math.ceil()
		int totalCnt = memberDao.selectMemberTotalCnt();
		int pages = (int)Math.ceil( (double) totalCnt/ pageVO.getPageSize() );
		map.put("pages", pages);
		
		return map;
	}
}
