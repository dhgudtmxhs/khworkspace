package edu.kh.poly.ex1.model.vo;

public class Spark extends Car { // 경차
	
	private double discountOffer;
	
	// 기본 생성자
	public Spark() {} // super 생략 시 컴파일러가 자동 추가

	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}
	
	// 매개변수 생성자(상속 버전)
		// alt + shift + s -> 0 -> 아래 방향키 -> enter
		
	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " / " + discountOffer;
	}
	
	
}
