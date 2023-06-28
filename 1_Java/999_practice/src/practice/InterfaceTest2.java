package practice;

class A5{
	void autoplay(I5 i) {
		i.play();
	}
}

interface I5 {
	public abstract void play();
}

class B5 implements I5 {
	public void play() {
		System.out.println("play in B class");
	}
}

class C5 implements I5 {
	public void play() {
		System.out.println("play in C class");
	}
}

class InterfaceTest2 {
	
	public static void main(String[] args) {
		
		A5 a  = new A5();
		
		a.autoplay(new B5());
		
		C5 c = new C5();
		a.autoplay(c);
		
	}

}
