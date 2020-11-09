package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.view.ProfileImgView;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model) throws IOException {
		
		//응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("filepath",memberVO.getFilename());
		
		return "profileImgView";
	}
	
	@RequestMapping("/profileDownloadView")
	public String profileDownloadView(String userid, Model model) throws IOException{
		
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("filepath",memberVO.getFilename());
		model.addAttribute("realfilename",memberVO.getRealfilename());
		
		return "profileDownloadView";
	}
			
}
