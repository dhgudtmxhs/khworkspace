package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
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
		
}
