package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;

public class MemberControllerTest extends WebTestConfig{

	@Test
	public void getMemberListTest() throws Exception {
		mockMvc.perform(get("/member/memberList")
						.param("page", "1"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/memberList"));
	}
	
	@Test
	public void getMemberTest() throws Exception {
		mockMvc.perform(get("/member/getMember")
						.param("userid", "apeach"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/member"))
				.andExpect(model().attributeExists("memberVO"));
	}
	
	@Test
	public void memberRegistViewTest() throws Exception {
		
		mockMvc.perform(get("/member/memberRegistView"))
				.andExpect(status().is(200))
				.andExpect(view().name("member/memberRegist"));
	}
	
	// 회원등록 성공 테스트
	@Test
	public void memberRegistTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberRegist").file(file)
						.param("userid", "a1234")
						.param("pass", "1234")
						.param("usernm", "테스트")
						.param("alias", "테스터")
						.param("addr1", "대전 중구 태평로15")
						.param("addr2", "123-456")
						.param("zipcode", "34890"))
				.andExpect(status().is(302))
				.andExpect(view().name("member/memberList"));
	}
	
	// 회원등록 실패 테스트
		@Test
		public void memberRegistFailTest() throws Exception {
			InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/sally.png");
			MockMultipartFile file = new MockMultipartFile("file", "sally.png", "image/png", is);
			mockMvc.perform(fileUpload("/member/memberRegist").file(file)
							.param("userid", "a1234")
							.param("pass", "1234")
							.param("usernm", "테스트")
							.param("alias", "테스터")
							.param("addr1", "대전 중구 태평로15")
							.param("addr2", "123-456")
							.param("zipcode", "34890"))
					.andExpect(status().is(200))
					.andExpect(view().name("member/memberRegist"));
		}
		
		@Test
		public void memberUpdateTest() throws Exception {
			InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/apeach.jpg");
			MockMultipartFile file = new MockMultipartFile("file", "apeach.jpg", "image/jpg", is);
			
			mockMvc.perform(fileUpload("/member/memberUpdate").file(file)
								.param("userid", "a1234")
								.param("pass", "4567")
								.param("usernm", "테스트2")
								.param("alias", "테스터2")
								.param("addr1", "대전 중구 태평로16")
								.param("addr2", "456-789")
								.param("zipcode", "12345"))
							.andExpect(status().is(302))
							.andExpect(view().name("redirect:/member/memberList"));
			
		}
		
		@Test
		public void profileImgTest() throws Exception {
			mockMvc.perform(get("/member/profileImg")
							.param("userid", "apeach"))
							.andExpect(status().is(200));
		}
		
		@Test
		public void profileDownloadTest() throws Exception {
			mockMvc.perform(get("/member/profileDownload")
								.param("userid", "apeach"))
							.andExpect(status().is(200));
		}
}
