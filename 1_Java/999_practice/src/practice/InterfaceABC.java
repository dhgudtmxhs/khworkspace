package practice;

class A{
	public void methodA(B b) { // B타입의 b를 받겠다.
		b.methodB();
	}
}

class B{
	public void methodB() {
		System.out.println("methodB()");
	}
}

class C{
	public void method() {
		System.out.println("methodC()");
	}
}

public class InterfaceABC {

	public static void main(String[] args) {
		
		A a  = new A();
		B c  = new B();
		
		a.methodA(new B());
		//a.methodA(new C()); 불가능 A클래스에선 B타입을 받고있음. 인터페이스를 안쓰면 이렇게 됨.
		
		a.methodA(c);
		c.methodB();
	}
	
	
	
}
