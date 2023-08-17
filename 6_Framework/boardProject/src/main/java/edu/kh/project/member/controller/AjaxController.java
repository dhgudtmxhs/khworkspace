package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.member.model.service.AjaxService;

@Controller // 요청/응답 제어 + bean 등록
public class AjaxController {

	@Autowired // DI
	private AjaxService service;
	
	// 이메일로 닉네임 조회
	// <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	@GetMapping(value="/selectNickname", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectNickname(String email) {
							// 쿼리스트링에 담긴 파라미터
		
		
		return service.selectNickname(email);
		
		
	}
	
	// 닉네임으로 전화번호 조회
	@GetMapping(value="/selectMemberTel", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public /*@ResponseBody 여기도 사용 가능*/String selectMemberTel(@RequestParam String nickname) {
		//fetch("/selectMemberTel?nickname=" + inputNickname.value)
		System.out.println(nickname);
		
		// return 리다이렉트 / 포워드 -> 새로운 화면이 보임(동기식)
		
		// return 데이터 -> 데이터를 요청한 곳으로 반환(비동기식)
		
		return service.selectMemberTel(nickname);
	}
	
	/* Ajax를 이용한 비동기 통신 시
     * 
     * - 요청 데이터를 얻어오는 방법
     * 1) GET : 요청 url에 쿼리스트링 형태로 파라미터가 담겨있어
     *          @RequestParam, @ModelAttribute를 이용해서 얻어옴
     * 
     * 2) POST : HTTP 요청 Body에 파라미터가 담겨 있으므로
     *           @RequestBody를 통해 값(JSON)을 얻어와 
     *           Java객체로 변환(HttpMessageConverter)
     * 
     * - 응답 방법(GET/POST 구분 X)
     * : @ResponseBody를 이용해 반환
     *   -> 해당 어노테이션을 작성하면  
     *   Controller에서 반환되는 값이 ViewResolver가 아닌 
     *   HttpMessageConverter로 전달되어  <- 타입 상관없이 알아서 다 바꿔줌
     *   반환된 Java객체를 text/JSON으로 변환 후 비동기 요청을 한 곳으로 응답함
     * 
     * 
     * ****************************
     * *** HttpMessageConverter ***
     * ****************************
     * 
     * HTTP 요청 Body의 내용을 Java 객체로 변환하고
     * HTTP 응답의 Body의 내용을 text/JSON 형태로 변환해주는 
     * Spring Framework 구성 요소
     * 
     * Spring에서 사용하는 MessageConverter 종류
     * 1순위 : ByteArrayHttpMessageConverter (바이트 배열 자동 변환)
     * 2순위 : StringHttpMessageConverter (Text 형식 자동 변환)
     * 3순위 : MappingJackson2HttpMessageConverter (요청 데이터 -> DTO/Map , 응답 데이터 -> JSON)
     * */   	// 자바의 json library (자동으로 만들어져있씀) 3종류 다 spring에 자동내장

	// 이메일 중복 검사
	
	// produces 속성은 한글이 깨질 때 사용한다. 한글 없으면 사용 안해도 됨.
	@GetMapping("/dupCheck/email")
	@ResponseBody // HttpMessageConverter를 이용해
				  // js에서 인식할 수 있는 형태(Text/json) 변환
				  // 비동기 요청한 곳으로 돌아감
	
	// jackson--databind dependency pom.xml에 추가 
	public int emailDupCheck(@RequestParam String email) {
		
		return service.emailDupCheck(email);
		
	}
	
	/*
	
	이 메소드가 MappingJackson2HttpMessageConverter를 사용하는 이유는 다음과 같습니다:

	클라이언트에게 응답하는 데이터를 JSON 형식으로 변환하기 위해 사용합니다. 
	
	@ResponseBody 애노테이션이 지정되어 있기 때문에 메소드의 반환값인 int가 JSON 형식으로 변환되어 클라이언트에게 전달됩니다.
	
	MappingJackson2HttpMessageConverter는 요청 데이터를 DTO/Map으로 변환하고 응답 데이터를 JSON으로 변환하는 역할을 수행합니다.

	클라이언트에서 전달하는 데이터를 DTO/Map으로 변환하기 위해 사용합니다.
	
	@RequestParam 애노테이션을 통해 클라이언트가 전달한 email 파라미터를 메소드의 인자인 email 변수에 바인딩합니다. 
	
	MappingJackson2HttpMessageConverter는 요청 데이터를 JSON으로 변환하고 이를 DTO/Map으로 변환하는 역할을 수행합니다.

	즉, MappingJackson2HttpMessageConverter는 JSON-format 데이터와 DTO/Map간의 변환을 담당하며, 
	
	이를 통해 Spring MVC 컨트롤러에서 JSON 형식의 데이터를 처리할 수 있게 됩니다.
	
	-> 받을때는 DTO/map을 변환 return할때는 JSON으로 변환
	
	*/
	
	// 닉네임 중복 검사
	
	@GetMapping(value = "/dupCheck/nickname") // produces = "application/text; charset=UTF-8" 하면 json형식으로 전달이 안되서 오류나는듯
	@ResponseBody
	public int nickDupCheck(@RequestParam String nickname) {
		
		return service.nickDupCheck(nickname);
		
	}
	
	
}
