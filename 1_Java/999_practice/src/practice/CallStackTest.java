package practice;

class CallStackTest {
	
public static void main(String[] args) {
	
	firstMethod(); // 참조변수 만들 필요 없이 가능. 대신 tv를 써야지.
	
}

static void firstMethod(){
	
	secondMethod();
	
}

static void secondMethod() {
	
	System.out.println("secondMethod()");
}

}

