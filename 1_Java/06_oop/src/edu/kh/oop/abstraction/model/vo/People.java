package edu.kh.oop.abstraction.model.vo;

	// VO (Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People { // 국민(사람) 클래스

	// 클래스란? 객체의 특성(속성, 기능)을 정의한 것
	// == 객체를 만들기 위한 설계도
	
	// 캡슐화 (Encapsulation)
	// - 데이터와 기능을 하나로 묶어서 관리하는 기법
	// - 데이터의 직접적인 접근을 제한하는 것이 원칙이다.
	// -> 직접접근을 못하기 때문에 
	//    클래스 내부에 간접 접근 방법을 제공하는 기능을 작성해둔다.
	
	// 데이터 직접 접근 제한
	// public(공공의) -> private(사적인, 개인적인)으로 변경해준다.
	
	// 속성 == 값 == data
	// 값을 저장하기 위한 변수 선언
	// -> 국민이라면 공통적으로 가지고 있는 속성만 정의한다.(추상화)
	
	private String name; // public 하면 캡슐화 원칙을 무시함
	private char gender;
	private String pNo; // "123456-1010101"
	private String address;
	private String phone;
	private int age;
	//double bitCoin; // 공통점이 아니므로 제거
	
	
	// 기능 == 행동 == method
	
	public void tax() {System.out.println("세금을 냅니다.");}
	public void vote() {System.out.println("투표를 합니다.");}
	
	// 캡슐화에서 사용할 간접 접근 기능(getter / setter)
	
	
	public void setName(String name) { // set = setter
		
		// 외부로부터 전달 받은 name을
		// 현재 객체의 속성 중 name ( == this.name) 에 대입
		this.name = name;
}
	
	public String getName() {
		
		// 현재 객체의 속성 중 name을 호출한 곳으로 반환한다(return)
		return name;
	}
		//alt + shift + s 또는 상단메뉴 Source 
		// -> Generate Getters and Setters ... 클릭
		// -> Select All -> generate
	
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
		
}
