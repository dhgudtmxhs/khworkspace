package practice;

public class Variables {
	// 인스턴스 변수
	int iv; // 객체를 생성하면 만들어짐.
	int hv;	// Variables의 참조변수 Variables cham = new Variables();
	int mv;	// 를 해야 얘네들이 비로소 생김. 메모리영역 생각 
	// 객체 생성을 해야 쓸 수 있음.
	
	static int cv; // 클래스 변수 
	// 자동으로 만들어짐. 객체 생성을 안해도 됨. 
	// 간단하게 내가 class를 입력하면 그냥 생김.
	//iv cv는 메소드영역 내 변수와는 달리 클래스 안에서 다 적용됨.
	// 객체 생성을 안해도 아무때나 사용 가능.
	
	// 클래스가 메모리에 올라갈 때
	// 객체를 만들기 위해 class를 사용. 쓸라고 하면
	// 이미 클래스는 올라가 있음. 그래서 그냥 아무때나 사용이 가능한 것임.
	
	
	void method() {
		int lv = 0; // lv라는 변수는 method가 끝날 때 
				   }//여기서 사라지게 됨. 메소드 아니면 못쓴다 이말인듯.

	

}
