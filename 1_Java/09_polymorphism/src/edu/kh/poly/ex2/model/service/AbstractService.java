package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;

public class AbstractService {

	public void ex1() {
		
		// 추상 클래스는 객체로 만들 수 있을까? (X)
		
		//Animal a1 = new Animal();
		// Cannot instantiate the type Animal = 객체화 할 수 없다.
		
		// 클래스 : 객체의 속성, 기능을 정의한 것. 일종의 설계도.
		// 추상 클래스 : 미완성 메소드를 포함한 클래스. 미완성 설계도.
		// -> 미완성 설계도로는 객체를 만들 수 없다!! -> 오류 발생
	
		// 해결 방법 : Animal을 상속 받아 미완성 부분을 구현한 클래스를 이용해 객체를 생성한다.
		
		// * 추상 클래스를 상속 받은 자식 객체 생성하기
		Person p1 = new Person();
		
		p1.setName("공유");
		
		// 상속받은 기능 호출
		p1.setType("척추동물");
		p1.setEatType("잡식");
		
		// 오버라이딩한 메소드 호출
		p1.eat();
		p1.breath();
	
		Fish f1 = new Fish();
		
		f1.setType("고등어");
		f1.setEatType("잡식");
		
		f1.eat();
		f1.breath();
		
		System.out.println(p1.toString());
		System.out.println(p1);
		System.out.println(f1.toString());
		System.out.println(f1);
	}
	
	
	public void ex2() {
		
		// * 추상 클래스와 다형성 + 바인딩
		
		// - 추상 클래스는 객체로 만들 수 없다.
		// 하지만 "참조 변수"로는 사용할 수 있다.
		
		// ex) 동물 -> 사람? 물고기?
		//    Animal a1 = new Animal(); (x)
		
		// 사람 -> 동물                      / 물고기 -> 동물
		// Animal a1 = new Person(); / Animal a2 = new Fish(); 
		// 에서 person과 fish가 Animal의 참조변수로 사용됨
		
		Animal[] arr = new Animal[2];
		// Animal 참조 변수 배열 선언 및 할당
		// 왜 만들어짐? 추상클래슨데
		/*Animal이 추상클래스이기 때문에 Animal 클래스 자체를 인스턴스화하는 것은 불가능합니다. 
		 * 하지만 추상클래스를 상속받아 자식 클래스에서 Animal을 구현하고 인스턴스화하여 사용할 수 있습니다. 
		 * Animal[] arr = new Animal[2]; 는 Animal 클래스를 상속받은 자식 클래스를 배열로 선언하는 것이므로 가능합니다.
		 * 이후 해당 배열에 자식 클래스의 인스턴스를 할당하면 Animal 클래스를 구현한 자식 클래스의 객체를 사용할 수 있게 됩니다.
		 */
		
		
		arr[0] = new Person("사람", "잡식", "김사랑");
		// Animal 부모 = Person 자식 객체의 주소값(안의 자기 자신) 참조 (다형성 중 업캐스팅)
		// 김사랑 안나와야 대는거 아닌가? -> 바인딩 확인
	
		arr[1] = new Fish("물고기", "잡식");
		// Animal 부모 = Fish 자식 객체의 주소값(안의 자기 자신) 참조 (다형성 중 업캐스팅)
		
		// 바인딩 확인 
		for(int i = 0; i < arr.length; i++) {
			arr[i].eat();
			arr[i].breath();
			System.out.println(arr[i].toString()); //하면 김사랑이 나옴. 동적바인딩 됨.
			System.out.println(arr[i]); // == toString
			// void edu.kh.poly.ex2.model.vo.Animal.eat() 컴파일 전 - 정적 바인딩 Animal.eat
			
			// 프로그램 실행 시
			// 참조하고 있는 자식 객체의 오버라이딩 된 eat() 메소드 수행
			// - 동적 바인딩
			// (부모 타입 참조 변수로 메소드를 호출 했지만
			// 자식 타입에 오버라이딩 된 메소드가 수행된다.)
			
			// 업캐스팅 상태(부모 참조 = 자식 객체)에서,
			// 부모 메소드 호출 시, 오버라이딩 된 자식 메소드를 수행한다.
			System.out.println("----------------------------------------");
		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
