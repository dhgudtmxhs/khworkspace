package practice;

public class DataTest{
	
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10; // 참조변수 d가 가르키는 int x가 10이 된다.
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x); // 메서드에서 나오면 다시 10임.
	}
	
	static void change(int x) { // 기본형 매개변수 int x = 10임
				x= 1000; // 10을 1000으로 변경 // d.x의 값이 바뀐게 아님. 메서드로 복사본을 만들었다고 생각.
				System.out.println("change() x = " + x); // 메서드 안에서만 1000임
	} // x = 지역변수
	
}
