package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People; // 다른 패키지

// Service : 특정 기능(비즈니스 로직)을 제공하는 클래스

public class AbstractionService {

	// 해당 클래스가 객체가 되면 아래 예제 기능을 수행할 수 있다.
	
	public void ex1() {
		
		// 국민 객체 만들기
	
		People p1 = new People(); // vo 안의 people은 다른 패키지라 import 해줘야 한다.
		
		// People p1; : 자료형이 People인 p1 참조변수를 만든다.
		// new People() : 새로운 People 객체를 Heap 영역에 생성
		// People p1 = new People(); = 자료형이 People인 p1 참조변수는 새로운 객체 People을 참조한다.
		
		// 클래스 이름이 자료형처럼 사용되어진다.
		// 그래서 클래스를 "사용자 정의 자료형" 이라고도 한다.
		
		People p2 = new People();
		
		// 만들어진 객체는 추상화가 적용되어 있어 누군지 알 수 없다.
		// -> 속성(데이터)를 추가하여 누구인지 알 수 있게 함(구체화)
		//The field(속성) People.name is not visible
		
	/*	p1.name = "다나카"; 는 직접 접근 방법. 캡슐화가 아님.
		p1.age = 27;
		p1.gender = '남';
		p1.phone = "010-1234-1234";
		p1.pNo = "002022-12345678";
		p1.address = "서울시 강남구 어쩌고 저쩌고";
	*/	
		
		
		p1.setName("다나카"); // setter를 이용한 간접 접근 방법
		p1.setAge(27);
		p1.setGender('남');
		p1.setPhone("010-1010-0101");
		p1.setpNo("002022-1234567"); // 왜 얘는 setPNo 아님?
		p1.setAddress("서울시 강남구 어쩌고 저쩌고");
		
		/*/setter 메소드의 이름은 관례상 set 뒤에 해당 속성의 첫 글자를 대문자로 바꾼 이름으로 작성합니다. 
		하지만 pNo 같은 경우 name 의 경우와는 달리 첫 글자가 대문자가 아니라 소문자인 경우가 많기 때문에, 
		set 메소드의 이름이 setpNo 로 되어있을 수도 있습니다. 이는 관례상을 따르는 것이 아니라 
		개발자의 선택이나 회사의 규칙 등에 따라 달라질 수 있습니다. 
		따라서 set 메소드의 이름이 setpNo 인 경우도 충분히 있을 수 있습니다.
		*/
		
		System.out.println("p1의 name : " + p1.getName());
		System.out.println("p1의 age : " + p1.getAge());
		System.out.println("p1의 gender : " + p1.getGender());
		System.out.println("p1의 phone : " + p1.getPhone());
		System.out.println("p1의 pNo : " + p1.getpNo());
		System.out.println("p1의 address : " + p1.getAddress());
	
		System.out.println("==================================");
	/*	
		p2.name = "오형석";
		p2.age = 27;
		p2.gender = '남';
		p2.phone = "010-9999-9999";
		p2.pNo = "970000-1000001";
		p2.address = "서울시 동대문구";
		
		System.out.println("p2의 name : " + p2.name);
		System.out.println("p2의 age : " + p2.age);
		System.out.println("p2의 gender : " + p2.gender);
		System.out.println("p2의 phone : " + p2.phone);
		System.out.println("p2의 pNo : " + p2.pNo);
		System.out.println("p2의 address : " + p2.address);
		
		
		System.out.println("==================================");
		
		p2 = p1;
		
		System.out.println("p2의 name : " + p2.name);
		System.out.println("p2의 age : " + p2.age);
		System.out.println("p2의 gender : " + p2.gender);
		System.out.println("p2의 phone : " + p2.phone);
		System.out.println("p2의 pNo : " + p2.pNo);
		System.out.println("p2의 address : " + p2.address);
		*/
		p1.tax();
		p1.vote();
		p2.tax();
		p2.vote();
		
	}

}
