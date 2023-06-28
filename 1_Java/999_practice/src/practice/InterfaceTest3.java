package practice;

class A6 {
	void methodA() { 
		I6 i = (I6)InstanceManager.getInstance();
		i.methodB();
		System.out.println((i.toString()));
	}
	//A6는 I6을 구현하지 않은 클래스이다. 따라서 A6에서 직접 methodB를 호출할 수 없다. 동적호출도 가능하긴 함 보통 동적호출하고.
	//하지만 A6클래스는 instancemanager 클래스를 이용하여 I6 인터페이스의 구현체를 생성한다.
	//이렇게 생성된 인스턴스를 통해 methodB를 호출할 수 있다.

}

interface I6 {
	public abstract void methodB();
}

class B6 implements I6{
	public void methodB() {
		System.out.println("methodB in B class");
	}
	public String toString() { return "class B";}
	
}

class InstanceManager{
	public static I6 getInstance() { // I6 을 구현한 애들만 반환을 할 수 있다.
		
		return new B6(); // 다른 인스턴스로 바꾸려면 (C나 D같은) 여기만 변경하면 됨.
	
	}
}

public class InterfaceTest3 {
	
	public static void main(String[] args) {
		
	A6 a = new A6();
	a.methodA();
	
	}	
}
