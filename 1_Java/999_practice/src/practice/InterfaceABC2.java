package practice;


class A2 {
	
	public void methodA(I i) { // I i로 B2 C2 다 가능해짐. // 인터페이스 I를 구현한 놈들만 들어와라.
		i.methodB();
	}
}

interface I { public abstract void methodB();}

class B2 implements I {
	
	public void methodB() {
		System.out.println("methodB()");
	}
	
}

class C2 implements I{
	public void methodB() {
		System.out.println("methodB() in C");
	}
}

public class InterfaceABC2 {

	public static void main(String[] args) {
		
	
	A2 a2 = new A2();
	a2.methodA(new B2());  // new 부분은 구현하는 클래스가 와야한다. new I() 불가능
	a2.methodA(new C2());  // A2를 변경 안하고도 C2가 들어와지는 모습.
	}
}
