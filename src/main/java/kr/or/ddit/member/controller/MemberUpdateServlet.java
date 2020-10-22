package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
	private MemberServiceI memberService;
       
//	해당 서블릿이 초기화될 때 한번만 호출
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberVO memberVO = memberService.getMember(userid);
		request.setAttribute("memberVO", memberVO);
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		MemberVO memberVO = new MemberVO();
		memberVO = memberService.getMember(userid);
		
		String usernm = request.getParameter("usernm");
		
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1= request.getParameter("addr1");
		String addr2= request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		logger.debug("parameter : {},{},{},{},{},{},{}",userid,usernm,alias,pass,addr1,addr2,zipcode);
	
		String filename = "";
		String realfilename = "";
		String filePath = "";
		String extension = "";
		Part profile = request.getPart("realfilename");
		System.out.println(realfilename);
		if(profile.getSize() > 0) {
			realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			filename = UUID.randomUUID().toString();
			extension = FileUploadUtil.getExtension(realfilename);
			System.out.println("O");
		} else {
			filePath = memberVO.getFilename();
			realfilename = memberVO.getRealfilename();
			System.out.println("X");
		}
		logger.debug("file : {}",profile.getHeader("Content-Disposition"));

		if(profile.getSize() > 0) {
			filePath = "D:\\profile\\" + filename + "." + extension;
			profile.write(filePath);
		}
//		 사용자 정보 등록
		
		if(filePath != null && realfilename != null) {
			MemberVO memberVO2 = new MemberVO(userid,pass,usernm,alias,addr1,addr2,zipcode,filePath,realfilename);
			int updateCnt = memberService.updateMember(memberVO2);
			
			if(updateCnt > 0) {
				response.sendRedirect(request.getContextPath() + "/member?userid=" + userid);
			} else {
				response.sendRedirect(request.getContextPath() + "/memberList");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/memberList");
		}
	}
}
