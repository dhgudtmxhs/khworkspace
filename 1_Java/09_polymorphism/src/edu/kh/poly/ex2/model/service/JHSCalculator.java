package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;

public class JHSCalculator extends Animal implements Calculator{
						// 클래스와 인터페이스는 동시 상속이 가능하다. (이건 다중 상속이 아님)
						// 인터페이스는 다중 상속이 가능하다.
	
	
	@Override
	   public int plus(int num1, int num2) {
	      return num1 + num2 + MAX_NUM;
	   }

	   @Override
	   public int minus(int num1, int num2) {
	      return num1 - num2 + MAX_NUM;
	   }

	   @Override
	   public int multiple(int num1, int num2) {
	      return num1 * num2 + MAX_NUM;
	   }

	   @Override
	   public double divide(int num1, int num2) {
	      return (double)num1 / num2 + MAX_NUM;
	   }

	@Override
	public void eat() {
	}

	@Override
	public void breath() {
	}
	
}
