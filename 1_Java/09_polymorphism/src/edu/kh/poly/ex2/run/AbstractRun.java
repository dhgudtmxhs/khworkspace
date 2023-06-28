package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.JHSCalculator;
import edu.kh.poly.ex2.model.service.OHSCalculator;

public class AbstractRun {

	public static void main(String[] args) {
		
		AbstractService service = new AbstractService();
		//service.ex2();

		
		  
		//Calculator cal = new Calculator(); // 인터페이스는 객체로 만들 수 없다. 미완성 설계도라서.
		
		//Calculator cal = (Calculator)new OHSCalculator(); // 인터페이스를 구현한 애를 객체로 만들어서 칼큘로 참조한다.
														  // 추상클래스처럼 참조 변수로는 사용이 가능함.
		
		//코드의 큰 수정 없이 객체 생성 코드만 바꾸면 새로운 클래스 코드를 수행할 수 있다.
		
		Calculator cal = (Calculator)new JHSCalculator(); // 이것만 바꾸면 되니까 유지보수성이 용이하다.
		
		
		System.out.println("합 : " + cal.plus(20, 15));
		System.out.println("차 : " + cal.minus(20, 15));
		System.out.println("곱 : " + cal.multiple(20, 15));
		System.out.println("몫 : " + cal.divide(20, 15));
		
		// 인터페이스의 특징
		// 1) 인터페이스를 부모 참조 변수로 사용하면
		// 다형성의 업캐스팅이 적용되서 상속받은 모든 클래스를 자식 객체로 참조할 수 있다.
		
		// 중요한 메인 코드의 수정을 최소화 할 수 있다.
		// 위의 합 차 곱 몫 을 전혀 수정 안하고 객체 생성 코드만 수정해서 다르게 작성된 기능을 수행한다.
	
		// 자식 클래스에 공통된 메소드 구현을 강제하기 때문에 모든 자식 클래스가 동일한 형태를 띈다.
		// 팀 프로젝트에 필요한 개발환경 조성 가능, 합 차 곱 몫 역할 분담같이.
	
	}
	
	
}
