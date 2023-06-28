package edu.kh.poly.ex1.model.vo;

public class Car {

	private String engine; // 엔진
	private String fuel; // 연료
	private int wheel; // 바퀴 개수
	
	public Car() { // 기본 생성자

		super(); // 부모생성자 (Object)
		
	}

	public Car(String engine, String fuel, int wheel) { // 매개변수 생성자 alt shift s -> o 
		super();
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	@Override
	
	// Object 클래스의 toString 오버라이딩 한 것
	public String toString() {
		return engine + " / " + fuel + " / " + wheel;
	}
	
	
	// getter setter 자동완성 alt + shift + s -> r -> tab -> space -> shift
	
}
