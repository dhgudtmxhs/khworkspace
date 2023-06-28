package practice;

public class CastingTest2 {

	public static void main(String[] args) {

	// Car11 car = new Car11(); // 4개 생성		
		Car11 car = new FireEngine(); // 5개 생성
		Car11 car2 = null;
		System.out.println(car2);
		FireEngine fe = null;

		car.drive();
		fe = (FireEngine)car; // 지금 car는 FireEngine 객체를 참조하고있다.
		fe.drive();
	
	car2 = (Car11)fe; // fe를 car11로 형변환이 안됨. 근데 컴파일러가 인식 못함
	car2.drive(); 
	// java.lang.ClassCastException:
	// 4개 생성으로 하면 컴파일러는 오류 인식을 못하지만 실행하면 오류가 난다. 
	// car2 = (Car11)fe; 형변환이 불가능함. 5개짜리가 4개짜리를 참조하는 것은 불가능임.
	
	
	}
}
