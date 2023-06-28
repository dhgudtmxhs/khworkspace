package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Tesla;
import edu.kh.poly.ex1.model.vo.Spark;


public class PolyService {

	public void ex1() {
		
		// 다형성 확인 예제
		
		Car car = new Car(); // 부모타입 참조변수로 부모객체를 참조하겠다.
		Tesla t = new Tesla(); // 자식타입 참조변수로 자식객체를 참조하겠다.
		
		// ***** 다형성 (업캐스팅) *****
		Car car2 = new Tesla(); // -> 오류 발생 안함
		// Tesla 객체를 참조하는 변수의 타입이 Car(부모) 이기 때문에
		// Tesla 객체가 Car(부모) 객체로 변화했다.
		
		Car car3 = new Spark(); // -> 오류 안남 똑같이 상속받음
		// 부모타입 참조변수 Car3 = 자식 객체 참조
		
		
		// ***** 다형석(업캐스팅) 작성법 *****
		
		// 1) 자식 객체가 부모 객체로 변하였기 때문에
		//    자식만의 고유한 필드, 메소드는 사용할 수 없다.
		
		// 1-1) car (부모 = 부모)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		// car 메소드 모두 사용 가능
		
		// 1-2) tesla (자식 = 자식)
		t.setEngine("전기모터");
		t.setFuel("전기");
		t.setWheel(4);
		t.setBatteryCarpacity(1000000);
		
		// 1-3) car2 (부모 = 자식(Tesla))
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(1000000); 자식꺼 전체 참조 불가능 자료형 달라서
		//The method setBatteryCapacity(int) is undefined for the type Car
		
		// 1-4) car3 (부모 = 자식(Spark))
		car3.setEngine("경차 엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setdiscountOffer(0.5); 자식꺼 전체 참조 불가능 자료형 달라서
		// The method setdiscountOffer(double) is undefined for the type Car
		
		System.out.println(car); // Car클래스
		System.out.println(car2); // Tesla클래스
		System.out.println(car3); // spark클래스
		
		// ---------------------------------------------------------------------
		
		// 2) 다형성을 이용한 객체 배열
		
		// 객체 배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		
		// + 다형성 적용 -> 부모 타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것

		Car[] arr = new Car[3]; // 부모타입 참조 변수 배열 선언 및 할당
								// 각 배열 요소가 Car타입 참조 변수
		
		arr[0] = car; // Car car = new Car(); // Car 주소에 car 객체가 있음
		// Car 참조변수 
		
		arr[1] = car2; // Car car2 = new Tesla(); car2엔 Tesla 객체 주소 들어가있음
		// Car 참조변수
		
		arr[2] = car3; // Car car3 = new Spark(); car3엔 Spark 객체 주소 들어가있음
		// Car 참조변수
		
		// 상속 + 다형성
		// 상속 특징 : 일련의 클래스들에 대한 공통적인 규약을 정의
		//        -> Car 상속 클래스들은 모두 getEngineFuelWheel() 을 가지고 있다를 정의
		// 다형성 (업캐스팅) : 부모 타입 참조변수 arr[i]로 자식 객체를 참조할 수 있다.
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.println(i + "번 째 인덱스의 엔진 : " + arr[i].getEngine());
			
		}
	}
	
	
	public void ex2() {
		
		// 3) 다형성(업캐스팅)을 이용한 매개변수 사용법 
		Tesla t = new Tesla("전기모터", "전기", 4, 1000000);
		Spark s = new Spark("경차 엔진", "휘발유", 4, 0.5);
		Car c = new Car("경유 엔진", "경유", 12);
		
		printCar(t); 
		printCar(s);
		printCar(c); // 다 참조변수 타입이 부모라 가능 상속받아서
	
		System.out.println("-------------------------------------");
		
		// 4) 다형성을 이용한 반환형 사용법
		
		//Car[] arr = {new Car(), new Tesla(), new Spark()};
		
		Car[] arr = { createCar(1), createCar(2), createCar(3) };
					//반환형 Car       반환형 Car      반환형 Car
				    // 				(Tesla 주소) 	  (Spark 주소) // 둘다 car를 품고있기 때문에 가능(메모리구조)
		
		
		
		//Car[] arr = { createCar(1), createCar(2), createCar(3) };
		//->Car[] arr = {new Car(), new Tesla(), new Spark()};
		//->Car[0] = new Car();
		//->Car[1] = new Tesla();
		//->Car[2] = new Spark();
		
		
		
		
	
		// arr[0]; // car
		// arr[1]; // Tesla
		// arr[2]; // Spark
		
		// instanceof 연산자 : 객체의 자료형을 검사하는 연산자
		// -> 참조하는 객체가 특정 자료형이거나 부모쪽 상속 관계인지를 확인
		
		//arr[1]이 참조하는 객체가 Tesla이면 true, 아니면 false
		System.out.println(arr[1] instanceof Tesla); // true
		//arr[1]이 참조하는 객체가 Spark이면 true, 아니면 false
		System.out.println(arr[1] instanceof Spark); // false
		//arr[1]이 참조하는 객체가 Car이면 true, 아니면 false
		System.out.println(arr[1] instanceof Car); // true 상속확인
		
		System.out.println("------------------------------------");
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] instanceof Tesla) {
				System.out.println("Tesla 객체 입니다.");
			}else if(arr[i] instanceof Spark) {
				System.out.println("Spark 객체 입니다.");
			}else { // arr[i] instanceof Car
				System.out.println("Car 객체 입니다.");
			}
			
		}
	
}
	
	// 전달 받은 Car 또는 자식 객체의 엔진, 연료, 바퀴 개수를 출력하는 메소드
	// 매개변수에 부모 타입 참조변수를 작성하면 모든 자식 개체를 전달 받을 수 있다.
	public void printCar(Car temp) { // 부모타입 참조변수 = 자식 객체 주소
		
		// 매개변수에 작성된 참조형 변수에는 주소가 저장된다. (얕은 복사)
		// 메소드 내부 변수 + 매개변수 == 지역 변수(Local Variable)
		
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 : " + temp.getWheel() + "개");
		System.out.println();
	}

	// 전달 받은 매개변수에 따라서 Car 또는 자식 객체를 생성하고
	// 생성된 객체의 주소를 반환하겠다.
	public Car createCar(int num) {
		
		Car result = null;
		// null == 아무것도 참조하고 있지 않음
		
		switch(num) {
		case 1: result = new Car(); break; // 객체의 주소가 담기게 됨
		case 2: result = new Tesla(); break;
		case 3: result = new Spark(); break;
		}
		
		// 반환형이 Car인데,
		// case가 2, 3이면 Car의 자식 객체의 주소가 반환됨.
		return result; // new Car(); or new Tesla(); or new Spark();
	
	}

	public void ex3() {
		
		// ***** 다형성 중 다운 캐스팅 *****
		
		// - 다운 캐스팅이란?
		// 부모 타입 참조 변수가 자식 객체를 참조하는
		// 업 캐스팅 상태에서만 진행 할 수 있는 기술.
		
		// 부모 타입을 자식 타입으로 " 강제 형변환" 해서
		// 자식 객체의 본래 필드, 메소를 사용 가능하게 한다.
		
		Car c1 = new Tesla("전기 모터", "전기", 4, 50000);
		
		System.out.println(((Tesla)c1).getBatteryCapacity());
		// 주의 : "." 연산자가
		//      (Tesla) 형변환 연산자보다 우선순위가 높다.
		
		// <효율적인 다운 캐스팅 방법>
		// -얕은 복사를 이용한다.
		
		Tesla t1 = (Tesla)c1; // 자식객체는 부모참조 불가능
		
		System.out.println(t1.getBatteryCapacity());
		
		
	}

	public void ex4() {
		
		Car c1 = new Tesla(); 
		
		//Spark s1 = (Spark)c1; // 다운 캐스팅 // Spark와 Tesla는 전혀 관계가 없음
		
		// java.lang.ClassCastException (형변환 예외)
		// -> c1이 참조하는 객체는
		//    Spark 참조변수로 Tesla 참조하려고 해서 문제 발생
		
		// @@@ 해결 방법 : instanceof와 같이 사용하자 ! @@@
		
		if(c1 instanceof Spark) { // 테슬라는 spark의 자료형이거나 상속관계인가? 를 물음
			Spark s1 = (Spark)c1; // 다운캐스팅
			System.out.println("성공");
		
		}else {
			System.out.println("실패(Spark 타입이 아님.)");
		}
	}

	public void ex5() {
		
		//바인딩(Binding)
		// - 실제 실행할 메소드 코드와 호출하는 코드를 연결 시키는 것
		
		Car c1 = new Car("경유 엔진", "경유", 8);
	
		System.out.println(c1.getEngine()); // or toString메소드
		// Car 객체에 있는 getEngine() 메소드를 호출
		
		// String edu.kh.poly.ex1.model.vo.Car.getEngine()
		
		// 프로그램 "실행 전"
		// - 컴파일러는 getEngine() 메소드가 Car에 있는 걸로 인식해서
		//   c1.getEngine() 호출 코드와 
		//   String edu.kh.poly.ex1.model.vo.Car.getEngine() 해당 메소드 코드를 연결해준다.
		// -> [정적 바인딩]
		
		System.out.println(c1.toString());
		// String edu.kh.poly.ex1.model.vo.Car.toString()
		// Car 참조변수 c1을 이용해서
		// Car 객체에 있는 오버라이딩 된 toString() 메소드를 호출
		
		// ** 다형성 적용 시 바인딩 **
		
		Car c2 = new Spark("경차 엔진", "휘발유", 4, 0.5);
		// 업캐스팅 적용 -> 부모 부분만 참조 가능한 상태다.
		System.out.println(c2.toString());
		// String edu.kh.poly.ex1.model.vo.Car.toString()
		// 참조변수 c2가 car 타입이므로 
		// toString도 car의 toString()을 호출한다. - 정적 바인딩
		
		// 하지만 실행 하보면 자식(Spark)의 toString이 호출된다. discountOffer까지 나옴.
		// -> 컴파일 시에는 부모(Car)와 바인딩 == [정적 바인딩]
		// -> 실행 시에는 자식(Spark)의 오버라이딩 된 메소드와 바인딩(연결) == [동적 바인딩]
		// 컴파일 시 정적 바인딩된 메소드를 실행할 당시의 객체 타입을 기준으로 바인딩 되는 것 -> spark의 toString
	
		// ** 동적 바인딩 활용 방법 **
		
		Car[] arr = {
						new Car("경유 엔진", "경유", 12),
						new Tesla("전기 모터", "전기", 4, 50000),
						new Spark("경차 엔진", "무연", 4, 0.3)
		};
		
		// arr 배열 요소가 참조하는 모든 객체의 필드 값을 출력

		for(int i = 0; i < arr.length; i++) {
			
			System.out.println(i + "번 째 요소 : " + arr[i].toString());
			// 실행 전 : String edu.kh.poly.ex1.model.vo.Car.toString() - 정적 바인딩
			// 실행 후 : 각 객체의 오버라이딩된 toString()이 호출됨 - 동적 바인딩
		}
		
		// ** 동적 바인딩 장점 **
		// - 업캐스팅 상태의 참조변수를 "별도의 다운캐스팅 없이" 자식의 오버라이딩된 메소드를 수행할 수 있다.
		
	}
	
	
	
	
	
	
	
}