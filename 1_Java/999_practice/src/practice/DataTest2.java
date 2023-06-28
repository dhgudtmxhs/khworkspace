package practice;

public class DataTest2 {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10; // 참조변수 d가 가르키는 int x가 10이 된다.
		System.out.println("main() : x = " + d.x);
		
		
		change(d);  // change(c); 는 안됨. 참조변수 d를 메서드 쓰는거니까.
		// 메서드에 static이 붙지 않았다면 change는 이 클래스(DataTest2)
		// 에 대한 객체를 new 연산자로 만들어서 사용해야만 사용할 수 있음.
		

		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x); // 메서드에서 나오면 다시 10임.
	}
	
	static void change(Data c) { //참조형 매개변수 change(Data d) 가아니라 c여도 됨. 어처피 메서드 안에서만의 변수.
				c.x= 1000; 
				System.out.println("change() x = " + c.x); 
				
				//static 빼면 지역변수를 사용 못함.
				//static 메서드는 인스턴스 생성 전에 생성됨.
				
				// d.x를 1000으로 만든 것과 같음. 나가면 d잖아.
				// change 안에있는 c가 참조하는 d.x 값이 1000으로 바뀐 것임. c던 e던 a던 매개변수로 그렇게 선언하니까.
				
				
	} // x = 지역변수
	
	// 참조형 매개변수를 사용하니 main의 값이 복사되었는데 10이 복사된게 아니라
	// 객체 d를 바라보는 주소를 가져와줌.
	// 그래서 x 객체에 대한 주소를 갖고 있어서 change의 값이 바뀌면 x 객체의 값도 바뀌게 되는것.
	
	// 기본형 매개변수는 그냥 복사일 뿐임. x의 값이 복사되었다가 사라졌을 뿐 x는 전혀 바뀌지 않음.
	
	
	//static 키워드를 적은 변수나 메소드는 클래스에 귀속되고
	//그렇지 않은 것은 객체에 귀속된다.
	
}
