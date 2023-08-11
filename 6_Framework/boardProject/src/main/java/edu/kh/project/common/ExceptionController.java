package edu.kh.project.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외 처리용 컨트롤러 (프로젝트 전역)
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class) 
	public String exceptionHandler(Exception e, Model model) {

		// Exception e : 예외 정보를 담고 있는 객체
		// Model model : 데이터 전달용 객체 (request scope가 기본)

		e.printStackTrace(); // 예외 내용/발생 메소드 확인

		model.addAttribute("e", e);

		// forward 방식으로 진행
		// -> Views Resolver의 prefix, suffix를 붙여 JSP 경로로 만듬

		
		return "common/error";

	}

}

//@ControllerAdvice 어노테이션은 예외 처리에 사용되는 공통 기능을 묶어주는 용도로 사용됩니다.

//@ExceptionHandler(Exception.class) 어노테이션은 특정 예외 클래스에 대한 예외 처리를 담당하는 메소드를 정의하는 것입니다. 

//예를 들어 위의 예제에서는 Exception 클래스에 대한 예외 처리를 담당하는 exceptionHandler() 메소드를 정의하고 있습니다.

//@ControllerAdvice 어노테이션을 사용하여 이 메소드를 전역으로 적용시킴으로써, 예외가 발생했을 때 해당 메소드가 실행되어 예외 처리를 수행하게 됩니다. 

//따라서, 예외가 발생하면 전역적으로 설정된 예외 처리 메소드가 동작하게 되는 것입니다.

//즉, 프로젝트 전역으로 적용되는 @ControllerAdvice 어노테이션을 이용하여 예외 처리를 담당하는 메소드를 정의하고, 

//@ExceptionHandler(Exception.class) 어노테이션으로 특정 예외에 대한 처리를 추가하는 것입니다.