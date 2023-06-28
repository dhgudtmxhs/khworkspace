package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;

public class OHSCalculator implements Calculator {

	@Override
	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int multiple(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public double divide(int num1, int num2) {
		return num1 / num2;
	}

	// 클래스 - 클래스 상속 시에는 extends (추상클래스도 포함)
	
	// 부모 클래스 - 자식 클래스 상속시에는 extends 사용 (추상클래스도)
	
	// 부모 인터페이스 - 자식 클래스 상속시 implements 사용
	
	

	
}
