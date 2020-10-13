package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
       
	//login 화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	//login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		logger.debug("userId : {}, password : {}",userId,password);
		
		/*
		파라미터로 온 userId가 DB상에 존재하는지 확인하고, 비밀번호가 데이터베이스에 저장된 비밀번호와 일치하는지 확인
		SELECT * FROM 회원
		WHERE 회원아이디 = 파라미터로 넘어온 userId;
		 */
		
		MemberServiceI memberService = new MemberService();
		MemberVO memberVO = memberService.getMember(userId);
		
		//디비에 등록된 회원이 없는 경우
		if(memberVO == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} // 비밀번호가 일치하는 경우 
		else if(memberVO.getPass().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memberVO);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} // 비밀번호가 틀린 경우
		else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		//쿠키정보
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			logger.debug("name : {}, value : {}",cookie.getName(),cookie.getValue());
		}
		
		Cookie cookie = new Cookie("SERVERCOOKIE","COOKIEVALUE");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
		
		
	}
}
