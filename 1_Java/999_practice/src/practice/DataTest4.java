package practice;

public class DataTest4 {

	public static void main(String[] args) {
		

	
	Data d = new Data();
	d.x = 10; // 참조변수 d가 가르키는 int x가 10이 된다.
	System.out.println("main() : x = " + d.x); // Data 참조하고
	
	DataTest2 b = new DataTest2(); // DataTest2 에있는 method 가져오기( static 뺴고 )
	
	b.change(d); // b에있는 메소드 change d

	System.out.println("After change(d)");
	System.out.println("main() : x = " + d.x); // 메서드에서 나오면 다시 10임.
	
	
	
	
	}

		
	}

