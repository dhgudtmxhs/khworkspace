package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller annotation : 현재 클래스가 컨트롤러임을 명시한다.
//							-> 요청, 응답 처리
//							+ bean 등록

// instance : 클래스 -> 객체
//	--> new 클래스명(); // 객체 생성을 개발자가 직접 했다.

// IOC(Inversion Of Control, 제어의 역전)
// -> 프레임워크(Spring Container)가 객체를 생성하고 관리한다.
// --> 이 때 생성된 객체 == Bean

// -----> 서버키면 controller annotation이 알아서 객체생성해준다.

@Controller
public class MainController {

	// tip : spring에서 controller 메소드 작성 시
	// 반환 값을 모르겠으면 일단 String으로 작성해라. 대부분 String으로 반환한다.

	// @RequestMapping("/") : 요청 주소가 "/"인 경우 해당 메소드와 연결해준다.
	
	@RequestMapping("/")
	public String mainForward() {
		// main.jsp로 화면 전환
		
		// <beans:property name="prefix" value="/WEB-INF/views/" />
		// <beans:property name="suffix" value=".jsp" />
		
		// Spring에서 forward 하는 방법
		// -> webapp 폴더를 기준으로
		//    요청을 위임할 JSP 파일 경로를 리턴하면 된다.
		
		// 단, servlet-context.xml에 작성된
		// prefix, suffix 부분을 제외하고 작성
		
		//return "/WEB-INF/views/common/main.jsp";
		// -> prefix + return 값 + suffix로 경로 완성.
		// ** View Resolver **
		
		return "common/main";
		
	}
	
}


