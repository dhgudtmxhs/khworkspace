package edu.kh.project.myPage.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

@SessionAttributes("loginMember") // {} 내가 뺌 일단
// 1) Model에 세팅된 값의 key와 {} 에 작성된 값이 일치하면 Sessionscope로 이동
// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게 함
// 		-> @SessionAttribute(key)로 사용. Attributes 아님

@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받겠다.
@Controller // 요청/응답 제어 클래스 + Bean 등록
public class MyPageController {

	@Autowired // MyPageService의 자식 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;
	//MypageService service = new MyPageServiceImpl();
	// @Autowired 어노테이션을 통해 MyPageService 인터페이스를 구현한 MyPageServiceImpl의 객체를 자동으로 주입받게 됩니다. 
	// 이를 의존성 주입(Dependency Injection)이라고 합니다. 이후에는 MyPageServiceImpl의 메소드를 사용할 수 있게 됩니다.
	
	// @Autowired 
	// 알아서 의존 객체(Bean) 를 찾아서 주입한다.
	// 의존 객체(Bean) 가 2개 이상이면 오류를 발생시킨다.
	// 보통, 인터페이스 선언 시 사용된다.
	
	// DI(Dependency Injection = 의존성 주입) 은
	// 하나의 객체 내에서 필요에 의해 다른 객체를 생성자(Constructor) 또는 Setter 를 통해 주입시키는 것
	 
	// -> MyPageService 인터페이스의 service 변수에 MyPageService 인터페이스를
	// 	  재정의한 클래스 객체 MyPageServiceImpl을 주입시킨다.
	
	@GetMapping("/info")
	public String info() {
		// ViewResolver
		return "myPage/myPage-info";
		// <a href="/myPage/info"> mapping으로 class에 /mypage 매소드에 /info
		// return은 ViewResolver에 /WEB-INF/views/ && .jsp라 myPage/myPage-xxx 이런식
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "myPage/myPage-profile";
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	@GetMapping("/secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	// 회원정보 수정
	@PostMapping("/info")
	public String info(Member updateMember, String[] memberAddress
						, @SessionAttribute("loginMember") Member loginMember
						, RedirectAttributes ra) {
		
		//-----------------------------매개 변수 설명 ------------------- //
		// Member updateMember : 수정할 닉네임, 전화번호가 담긴 커맨드 객체
		// String[] memberAddress : name="memberAddress"인 input 3개의 값(주소)
		
		
		
		// @SessionAttribute("loginMember") Member loginMember
		// : Session에서 얻어온 "loginMember"에 해당하는 객체를
		// : 매개변수 Member loginMember에 저장하겠다.
		
		// @SessionAttributes 를 사용하지 않는다면
		// public String info(HttpSession session) {
		// Member loginMember = (Member) session.getAttribute("loginMember");
		// 이런식으로 해야함 그냥 SessionAttributes한 클래스 SessionAttribute로 가져오게 하는게 날듯
		
		
		
		// RedirectAttributes ra : 리다이렉트 시 값 전달용 객체(request)
		
		// ---------------------------------------------------------- //
		
		// 주소 하나로 합치기 (서울^^^동대문구^^^답십리)
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		// 로그인한 회원의 번호를 updateMember에 추가
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// DB에 회원 정보 수정(UPDATE) 서비스 호출
		int result = service.updateInfo(updateMember);
		
		String path = "redirect:";
		
		String message = null;
		
		if(result > 0) {
		
			message = "회원 정보가 수정되었습니다.";
			
			// Session에 로그인된 회원 정보도 수정(동기화)
			
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
			
		}else {
			
			message = "회원 정보 수정 실패";
			
		}
	
		ra.addFlashAttribute("message", message);
		
		return "redirect:info"; // 상대경로
		// 절대경로 -> (/myPage/info) [get]


		}
		
		// 비밀번호 변경
		@PostMapping("/changePw")
								// 매개변수명,jsp의 name 명 동일 -> annotation 생략가능
		public String changePw(/*@RequestParam("currentPw")*/ String currentPw
															, String newPw
								, @SessionAttribute("loginMember") Member loginMember
								, RedirectAttributes ra) { 
			
		/*	<input type="password" name="currentPw" id="currentPw" maxlength="30" >
			<input type="password" name="newPw" id="newPw" maxlength="30">  
			<input type="password" name="newPwConfirm" id="newPwConfirm" maxlength="30"> */
			
			// 로그인한 회원 번호(DB에서 어떤 회원을 조회, 수정하는지 알아야 함)
			
			int memberNo = loginMember.getMemberNo();
			
			// 비밀번호 변경 서비스 호출
			int result = service.changePw(currentPw, newPw, memberNo);
			
			String path = "redirect:";
			String message = null;
			
			if(result > 0) { // 성공
				message = "비밀번호가 변경되었습니다.";
				path += "info";
			
			} else {
				message = "현재 비밀번호가 일치하지 않습니다.";
				path += "changePw";
			}
			
				ra.addFlashAttribute("message", message);
			
				return path;
		
		}
		
			
		@PostMapping("/secession")
		public String secession(@SessionAttribute("loginMember") Member loginMember
																, String memberPw 
																, RedirectAttributes ra
																, SessionStatus status
																, HttpServletResponse resp) {
			
			
			// 1. 로그인한 회원의 회원 번호 얻어오기
			int memberNo = loginMember.getMemberNo();
			
			// 2. 회원 탈퇴 서비스 호출
			int result = service.secession(memberNo, memberPw);
		
			String path = "redirect:";
			String message = null;
			
			if(result > 0) {
				
				// 3. 탈퇴 성공 시
				// - 로그아웃
				// - message : 탈퇴 되었습니다.
				// - redirect 메인페이지
				// + 쿠키 삭제
				message = "탈퇴되었습니다.";
				path += "/";
				status.setComplete();
				
				Cookie cookie = new Cookie("saveId", "");
				// 같은 쿠키가 이미 존재하면 덮어씌우는 형식
				cookie.setMaxAge(0); // 삭제
				cookie.setPath("/"); // 요청시 쿠키가 첨부되는 경로
				
				resp.addCookie(cookie); // 요청객체를 통해 클라이언트에 전달
										// -> 클라이언트 컴퓨터에 파일로 생성
				
			}else {
				
				// 4. 탈퇴 실패 시
				// - message : 현재 비밀번호가 일치하지 않습니다.
				// - 회원 탈퇴 페이지로 리다이렉트
				message = "탈퇴 실패";
				path += "secession";
				
			}
			
			ra.addFlashAttribute("message", message);
			
			return path;
		}
		
		/* 
		 * MultipartFile : input type="file"로 제출된 파일을 저장한 객체
		 * 
		 * [제공하는 메소드]
		 * - transferTo() : 파일을 지정된 경로에 저장(메모리 -> HDD/SSD)
		 * - getOriginalFileName() : 파일 원본명
		 * - getSize() : 파일 크기
		 * 
		 * */
		
		
		// 프로필 이미지 수정
		@PostMapping("/profile")
		public String updateProfile(@RequestParam("profileImage") MultipartFile profileImage
								   ,@SessionAttribute("loginMember") Member loginMember
								   , RedirectAttributes ra // 리다이렉트 시 메세지 전달
								   , HttpSession session // 새션 객체
								   ) throws IllegalStateException, IOException{ 
			
			// src 폴더는 웹에서 접근이 가능하다.
			// 웹 접근 경로 webapp기준 / == 하위 
			String webPath = "/resources/images/member/";
			
			// 실제로 이미지 파일이 저장되어야 하는 서버 컴퓨터 경로
			// C:\workspace\6_Framework\boardProject\src\main\webapp\resources\images 집에선 다를 수 있음
			String filePath = session.getServletContext().getRealPath(webPath);
			
			// 프로필 이미지 수정 서비스 호출
			int result = service.updateProfile(profileImage, webPath, filePath, loginMember);
			
			String message = null;
			
			if(result > 0) {
				
				message = "프로필 이미지가 변경되었습니다.";
				
			} else {
				
				message = "프로필 이미지 변경 실패";
				
			}
		
			ra.addFlashAttribute("message", message);
			
			return "redirect:profile";
			
		}
			
}
