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

/*

 	@Controller 어노테이션은 현재 클래스가 컨트롤러 역할을 한다는 것을 명시해주는 역할을 합니다. 
	이 어노테이션이 붙은 클래스는 스프링이 관리하는 빈으로 등록되어서 사용될 수 있게 됩니다.
	
	@Controller 어노테이션이 붙은 클래스는 스프링이 자동으로 해당 클래스를 객체로 생성하고, 요청이 들어오면 해당 요청과 연결된 메소드를 실행시킵니다. 
	이렇게 스프링이 객체의 생성과 메소드의 실행을 관리해주는 개념을 IOC (Inversion Of Control, 제어의 역전)이라고 합니다.
	
*/

@Controller
public class MainController {

	// tip : spring에서 controller 메소드 작성 시
	// 반환 값을 모르겠으면 일단 String으로 작성해라. 대부분 String으로 반환한다.

	// @RequestMapping("/") : 요청 주소가 "/"인 경우 해당 메소드와 연결해준다.
	
	
	// 원래 밑의 메소드를 쓰려면 클래스에 대한 객체를 생성하고(MainController mc = new MainController(); )
	// mc.mainForward()이런 식으로 사용해야 했는데
	// 컨트롤러로 등록하면 자동으로 스프링이 객체(bean 형식)으로 생성해서, 위의 객체 생성같은 것 없이 
	// controller class 안의 메소드가 요청주소를 받으면  실행될 수 있게 한다.
	// 이 때 @Controller 어노테이션이 붙은 클래스의 메소드들은 @RequestMapping 어노테이션이 붙어야 해당 메소드가 요청과 매핑되어 실행될 수 있습니다. 
	// @RequestMapping 어노테이션은 요청 주소와 해당 메소드를 매핑해주는 역할을 합니다.
	
	// -> class를 controller로 만들고 메소드를 그 안에 RequestMapping 해서 만들면 간단하게 요청주소를 받아들일 수 있음. 
	// web-xml에서 첫번째로 나올 페이지 <load-on-startup>1</load-on-startup>
	// 에 대한 url-pattern을 <url-pattern>/</url-pattern> 로 설정했다.
	// 그래서 이 메소드가 수행되서 나오는 jsp가 index.jsp같이 첫 화면이 된다.
	
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


