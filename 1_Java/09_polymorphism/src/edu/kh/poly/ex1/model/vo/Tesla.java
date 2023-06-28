package edu.kh.poly.ex1.model.vo;

public class Tesla extends Car{

	private int batteryCapacity; // 배터리 용량
	
	// ctrl + space -> enter
	
	public Tesla() {
		super(); // 부모 생성자 = Car
	}

	public Tesla(String engine, String fuel, int wheel, int batteryCapacity) { // ctrl shift s o 에서 수정
		super(engine, fuel, wheel);
		this.batteryCapacity = batteryCapacity;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCarpacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " / " + batteryCapacity;
		
	}
	
	
}
