package edu.kh.poly.ex2.model.vo;

public class Fish extends Animal{

	
	public Fish() {
		super();
	}// 생성자 미작성 시 컴파일러가 해줌. 매개변수 생성자 있으면 안해줌.
	
	// 추상 메소드는 상속 받으면 오버라이딩이 강제된다.
	
	
	public Fish(String type, String eatType) {
		
		super(type, eatType);
		
	}
	
	@Override
	public void eat() {
		System.out.println("입을 뻐끔 뻐끔 거리면서 먹는다.");
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}

	@Override
	public String toString() {
		
		return "Fish : " + super.toString();
		
	}
	
	
	
}
