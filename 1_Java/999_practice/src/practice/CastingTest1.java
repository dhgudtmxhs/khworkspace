package practice;

public class CastingTest1 {

	public static void main(String[] args) {
		
		Car11 car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; // car = (car)fe; car는 객체 4칸
		//car.water(); car 객체 안에는 water가 못들어옴
		fe2 = (FireEngine)car;
		fe2.water(); // 얜 이씀

		
		
	}
	
}


class Car11{
	
	String color;
	int door;
	
	void drive() {
		System.out.println("부릉부릉");
	}
	
	void stop() {
		System.out.println("끼익");
	}
	
}


class FireEngine extends Car11{
	void water() {
		System.out.println("water!!");
	}
	
}