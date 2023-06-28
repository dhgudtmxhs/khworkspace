package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;

public class MemberRun {

	public   static   void    main(String[] args) {
// [접근제한자] [예약어]	  반환형   메소드명([매개변수])
// [] 는 없을 수도 있다.
		
		MemberService service = new MemberService(); // import // () = 기본생성자
		//생성자 = 기본생성자 OR 매개변수생성자
		
		// MemberService의 기본생성자가 작성되어있지 않지만 
		// 문제없이 사용이 가능하다.
		
		// 왜? 컴파일러가 코드를 번역할 때
		// 클래스 내부에 생성자가 하나도 없다면
		// 자동으로 기본 생성자를 추가해줌
		
		// (주의) 생성자가 하나라도 있으면 자동생성을 안해준다!
		// The constructor MemberService() is undefined
		// public MemberService() {} 기본생성자를 멤버서비스에 만들면 오류해결
		
		
		service.displayMenu();
		
		//Member mem = new Member(); // 기본생성자 생성 안하면 이게 안됨
				
	}
	
	
	
}
