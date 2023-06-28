package edu.kh.poly.ex2.model.vo;

public class Person extends Animal {
    // The type Person must implement the inherited abstract method Animal.breath() 
	// = Animal의 추상 메소드를 정의안했다. 오버라이딩 하지 않으면 오류 날거라서 빨간줄. 아니면 person도 abstract하던가.
	
	
	//필드
	private String name;
	
	// 생성자

	public Person() {
		super(); // == Animal의 기본 생성자
	}
	
	public Person(String type, String eatType, String name) {
		super(type, eatType);
		this.name = name; // this type은 private라 안됨. setter는 되는데 하나하나 다입력해야함. 
																//setType(type); 처럼
	}
	
	// getter setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void eat() {

		System.out.println("숟가락, 젓가락, 나이프, 포크 등을 이용해서 먹는다.");
	}

	@Override
	public void breath() {

		System.out.println("코와 입으로 숨을 쉰다.");
	}
	
	// toString()
	@Override
	public String toString() {
		return "Person : " + super.toString() + " / " + name; // Animal = 
 	}
	
	
}
