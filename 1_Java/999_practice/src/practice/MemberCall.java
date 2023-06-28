package practice;

public class MemberCall {

	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	
	static int cv2 = new MemberCall().iv;  // 처럼 객체를 생성해야 클래스 변수가 인스턴스 변수 사용이 가능함
	// 생성자를 호출하는데 생성자는 결국 인스턴스를 리턴하게 되고, 인스턴스.iv를 호출한 것과 다를 게 없음
	


	static void staticMethod1() {
		
		System.out.println(cv);	
		// System.out.println(iv); 사용 불가
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
		
	}

	void instanceMethod1() {
		
		System.out.println(cv);
		System.out.println(iv);
		
	}
	
	static void staticMethod2() {
		
		staticMethod1();
		MemberCall c = new MemberCall();
		c.instanceMethod1(); // 객체 생성하면 인스턴스메소드 불러올 수 있다.
		// 아니면 객체를 생성한 지 아닌 지 몰라서 불러올 수 없음. 인스턴스 변수든 인스턴스 메소드든
	}
	
	void instanceMethod2() {
		
		staticMethod1();
		staticMethod2();
		instanceMethod1();
		
	}
	
}	