package practice;

public class BindingTest {
	
	public static void main(String[] args) {
		
		Parent p = new Child(); // child 객체를 바라보게 만듬
		Child c = new Child();
		
		System.out.println("p.x = " + p.x);
		p.method(); 
		// p.method는 child 객체에 있는 method를 쓴다는 걸 의미. 그래서 Parent의 메소드가 안나옴.
		// 하지만 Parent에 method가 없으면 이 문구는 오류가 남.
		// Parent p 에서 컴파일러는 Parent에있는 method 를 가리키려 함.
		
		//컴파일러는 참조 변수의 데이터 타입을 기준으로 해당 클래스에 있는 멤버 변수와 메소드를 찾습니다. 그래서 Parent 클래스에 method가 없으면 
		//Parent 클래스의 method를 호출할 수 없습니다. 부모 클래스의 메소드를 호출하려면, 상속받은 자식 클래스에서 오버라이딩을 하지 않으면 됩니다.
		
		System.out.println("c.x = " + c.x);
		c.method();
	}
}

class Parent{
	
	int x = 100;
	
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent{
	
	int x = 200;
	
	@Override
	void method() {
		System.out.println("Child Method");
	}
}
