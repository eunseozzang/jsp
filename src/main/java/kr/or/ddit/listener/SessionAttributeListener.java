package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
	//	userid, MemberVO
	private Map<String, MemberVO> userMap = new HashMap<String, MemberVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
			
//			HttpSession session = event.getSession();
//			MemberVO memberVO = (MemberVO) session.getAttribute("S_MEMBER");
			
			//아래의 한줄로 표현
			MemberVO memberVO = (MemberVO) event.getValue();
			logger.debug("사용자 로그인 : {}",memberVO.getUserid());
			
			userMap.put(memberVO.getUserid(),memberVO);
			
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
		MemberVO memberVO = (MemberVO) event.getValue();
		logger.debug("사용자 로그아웃 : {}",memberVO.getUserid());
		userMap.remove(memberVO.getUserid());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
