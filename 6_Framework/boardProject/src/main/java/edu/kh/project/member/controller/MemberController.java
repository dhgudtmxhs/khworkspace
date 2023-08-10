package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.dto.Member;

// @RequestMapping : 요청 주소에 맞는 클래스/메소드를 연결해준다.

// @RequestMapping("요청 주소")
// -> GET/POST 구분 없이 주소만 맞으면 모두 다 받는다

// @RequestMapping(value="요청 주소", method=RequestMethod.GET/POST)
// -> GET/POST 방식 구분한다.

@Controller // 요청/응답 처리하는 클래스 + bean으로 등록(Spring이 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분을 작성
						   // member로 시작하는 요청은 해당 컨트롤러에서 처리한다.
						   // 클래스도 RequestMapping 가능
public class MemberController {

	// 로그인		: /member/login
	// 로그아웃	: /member/logout
	
	// 로그인(member/login), POST 방식 처리
	// Class에 작성한 /member를 제외한 나머지 부분을 주소로 작성
	
	// @RequestMapping(value="/login", method=RequestMethod.POST)
					//value= 없이 "/login" 만 써도 되는듯? // 메소드를 적지 않는다면 get/post 다 받는다.
											
	public String login(HttpServletRequest req) {
						// extends Httpservlet 생략가능
		// 파라미터 전달 방법 1 : HttpServletRequest를 이용하는 방법
		// -> Controller 메소드에 매개변수로 HttpServletRequest를 작성
		
		// 매개변수에 적었는데 왜 사용이 가능??
		// Spring Framework가 제공하는 
		// Argument Resolver(매개변수 해결사)가 해결해줘서
		
		String inputEmail = req.getParameter("inputEmail");
		
		System.out.println("inputEmail : " + inputEmail);
		
		// ** redirect 방법 **
		
		// "redirect:요청주소"
		
		// Web project Setting에 / 로 설정했음
		
		return "redirect:/";
		
	}
	// PostMapping
	// -> @RequestMapping의 자식으로
	// 	  POST 방식 요청을 연결하는 어노테이션
	// @RequestMapping(value="/login", method=RequestMethod.POST) 에서 더 간단하게 바뀜.
	//@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail, // 변수명과 jsp에서의 name이 같다 -> @req param 생략 해도 그냥 넘어온다.
						/*@RequestParam("inputPw")*/ String inputPw) {
		
		// 파라미터 전달 방법 2 : @RequestParam 어노테이션 이용(+생략 방법)
		
		// ** 파라미터의 name 속성 값과
		//    매개 변수명이 같으면 @RequestParam 생략이 가능하다.
		
		// @RequestParam(value="name", required="false", defaultValue="1")
		// [속성]
		// value : 전달 받은 input 태그의 name 속성값
		  
		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request
		
		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용
		
		// @RequestParam 어노테이션
		
		// - request객체를 이용한 파라미터 전달 어노테이션
		// - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입된다.
		
		System.out.println("inputEmail :" + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// 메인 페이지 리다이렉트(재요청)
		return "redirect:/";
		
	}
	
	// Dispatcher Servlet(발송자 서블릿)
	// 요청 컨트롤러로 전달,응답
	
	// Handler Mapping(매핑처리)
	// 어떤 요청을 어떤 클래스/메소드로 연결하는지 제어하는 객체
	
	// View Resolver(뷰 해결사)
	// Controller에서 반환된 문자열("common/main")
	// 앞,뒤에 경로(/WEB-INF/views), 확장자(.jsp)를 붙여서
	// jsp 파일의 경로를 지정한 후 forward(요청 위임)을 하는 객체
	
	// <form action="/member/login" method="POST" id="loginFrm">
	@PostMapping("/login")
	public String login(/*@ModelAttribute*/ Member mem) { 
		
		// String 형이다(String str) -> 매개변수로 선언한 이름이 jsp의 name값과 같다면 넘어온다. @RequestParam("name값")는 생략이 가능하다.
		// dto 형이다(Member mem) -> 매개변수로 선언한 dto class 안에 담긴 한 변수와 jsp안의 name이 같다면 
		// dto객체에서 그 변수에 jsp의 같은 name의 parameter가 넘어온다. @ModelAttribute는 생략이 가능하다.
		// (아마 String형이 아니면 dto나 vo라고 프레임워크가 생각할듯해서 구분해서 어노테이션들의 생략이 가능한거 같음)
		
		
		// 파라미터 전달 방법 3 : @ModelAttribute를 이용한 방법
		// - DTO(또는 VO)와 같이 사용하는 어노테이션
		
		// - 전달 받은 파라미터의 name 속성값이
		//   같이 사용되는 DTO의 필드명과 같다면
		//   자동으로 setter를 호출해서 필드에 값을 세팅한다.
		
		// *** @ModelAttribute 사용 시 주의사항 ***
		// -DTO에 기본 생성자가 필수로 존재해야 한다.
		// -DTO에 setter가 필수로 존재해야 한다.
		
		// *** @ModelAttribute 어노테이션 <<<< 은 생략이 가능하다
		
		// *** @ModelAttribute를 이용해 값이 필드에 세팅된 객체를 
		//	   "커맨드 객체"라고 한다. ***
		
		System.out.println(mem);
		
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
