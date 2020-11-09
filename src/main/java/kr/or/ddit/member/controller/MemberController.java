package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.JSRMemberVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.MemberVoValidator;
import kr.or.ddit.member.model.PageVO;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {

	@Resource
	MemberServiceI memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 페이지 출력
	@RequestMapping("/memberList")
	public String getMemberList(Model model, String page) {

		logger.debug("페이지 : {}", page);

		int page2 = page == null ? 1 : Integer.parseInt(page);
		int pageSize = 5;

		PageVO pageVO = new PageVO(page2, pageSize);

		model.addAttribute("page", page2);
		model.addAttribute("pageSize", pageSize);

		// 필요한 페이지의 갯수
		pageVO.setPage(page2);
		// 한 페이지 당 출력할 글의 갯수
		pageVO.setPageSize(pageSize);

		Map<String, Object> map = memberService.selectMemberPageList(pageVO);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));

		return "/member/memberList";
	}

	// 개인정보 출력
	@RequestMapping("getMember")
	public String getMember(Model model, String userid) {

		logger.debug("userid : {}", userid);

		MemberVO memberVO = memberService.getMember(userid);

		model.addAttribute("memberVO", memberVO);
		return "/member/member";

	}

//	 사진 출력
	@RequestMapping("profileImg")
	public void profileImg(HttpServletResponse response , String userid) throws IOException {
	   
		MemberVO memberVO = memberService.getMember(userid);
	   
		memberVO.getFilename();
		FileInputStream fis = new FileInputStream(memberVO.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		//읽을것이 없을 때 까지
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		//응답이 안간게 있으면 마지막으로 보내기
		sos.flush();
		sos.close();
	   
	}
	
	@RequestMapping("memberRegistView")
	public String memberRegistView() {
		return "member/memberRegist";
	}
	
	
	@RequestMapping(path="memberRegist", method = RequestMethod.POST)
	public String memberRegist(@Valid MemberVO memberVO, BindingResult br, @RequestPart("file") MultipartFile file) {
		
		
//		new MemberVoValidator().validate(memberVO, br);
		// 검증을 통과하지 못했으므로 사용자 등록 화면으로 이동
		
		if (br.hasErrors()) {
			return "member/memberRegist";
		}
		String filename = UUID.randomUUID().toString();
		String extension = FileUploadUtil.getExtension(file.getOriginalFilename());
		String filepath = "D:\\profile\\" + filename + "." + extension;
		File uploadFile = new File(filepath);
		logger.debug("사용자 정보 : {}", memberVO);
		
		if (file.getSize() > 0) {
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			logger.debug("파일이름 : {}, 확장자 : {}", filename, extension);
			memberVO.setFilename(filepath);
			memberVO.setRealfilename(file.getOriginalFilename());
		}
		
		int insertCnt = memberService.insertMember(memberVO);
		logger.debug("등록 ? {}", insertCnt);
		if (insertCnt == 1) {
			return "redirect:/member/memberList";
		} else {
			return "member/memberRegist";
		}
	}

	@RequestMapping("memberUpdateView")
	public String memberUpdateView(String userid, Model model) {
		
		MemberVO memberVO = memberService.getMember(userid);
		
		model.addAttribute("memberVO", memberVO);
		return "member/memberUpdate";
	}
	
	@RequestMapping(path="memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberVO memberVO, @RequestPart("file") MultipartFile file) {
		//MultipartFile profile 이라고 써도 됨
		
		logger.debug("사용자 정보 : {}",memberVO);
		
		String filename = UUID.randomUUID().toString();
		String extension = FileUploadUtil.getExtension(file.getOriginalFilename());
		String filepath = "D:\\profile\\" + filename + "." + extension;
		File uploadFile = new File(filepath);
		
		MemberVO dbVO = memberService.getMember(memberVO.getUserid());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		if(file.getSize()>0) {
			
			memberVO.setFilename(filepath);
			memberVO.setRealfilename(file.getOriginalFilename());
			
		} else {
			
			memberVO.setFilename(dbVO.getFilename());
			memberVO.setRealfilename(dbVO.getRealfilename());
			
		}
		
		int upCnt = memberService.updateMember(memberVO);
		
		
		logger.debug("업데이트 ? {}",upCnt);
		
		if(upCnt == 1) {
			return "redirect:/member/memberList";
		} else {
			return "member/memberUpdate";
		}
	}
	
	@RequestMapping("profileDownload")
	public void profiileDownload(String userid, HttpServletResponse response) throws IOException {
		
		MemberVO dbVO = memberService.getMember(userid);
		
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + dbVO.getRealfilename() + "\"");
		response.setContentType("application/octet-stream");
		
		
		FileInputStream fis = new FileInputStream(dbVO.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		//읽을것이 없을 때 까지
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		//응답이 안간게 있으면 마지막으로 보내기
		sos.flush();
		sos.close();
		
	}
	

}