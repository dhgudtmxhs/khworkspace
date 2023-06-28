package edu.kh.poly.ex2.model.vo;

public abstract class Animal {

	// 추상 클래스(abstract class)
	// 1. 미완성 메소드(추상 메소드)를 보유하고 있는 클래스
	
	// 2. (추상 메소드는 없지만) 객체로 만들면 안되는 클래스도 추상클래스.
	
	// 필드
	private String type; // 종/과 를 구분
	private String eatType; // 식성(초식, 육식, 잡식)
	
	// 생성자
	// - 추상 클래스는 new 연산자를 이용해서 직접적인 객체 생성은 못한다.
	//   하지만 상속 받은 객체 생성시 부모 부분이 생성될 때 사용된다.
	//   == super() 생성자
	
	public Animal() {
		super(); // (Object) 생략시 컴파일러가 추가해준다.
	}
	
	// 기본 생성자
	public Animal(String type, String eatType) { // 매개변수 생성자 (오버로딩)
	
		this.type = type;
		this.eatType = eatType; 
		
	}	
	
	// 메소드
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	// toString() 오버라이딩
	@Override
	public String toString() {
		
		return type + " / " + eatType;
		
	}
	
	// 동물의 공통 기능 추출(추상화)
	
	// -> 동물은 공통적으로 먹고, 숨쉬지만
	//    어떤 동물이냐에 따라 그 방법이 다르다.
	
	// --> 어떡하지?
	//    미완성 상태로 두어 상속받은 자식이 해당 메소드를 정의 하도록
	//    오버라이딩을 강제화 시킨다. --> 추상(abstract)메소드로 작성한다.
	
	// 먹다
	public abstract void eat(); //{} 없애고 세미클론
	
	// 숨쉬다
	public abstract void breath(); //{} 없애고 세미클론
	
	//The abstract method breath in type Animal can only be defined by an abstract class
	
	
	
	
	
	
	
}

