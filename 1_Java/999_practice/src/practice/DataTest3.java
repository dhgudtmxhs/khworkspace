package practice;

public class DataTest3 {

	public static void main(String[] args) {
		
		int[] x = {10}; // 크기 1 {10} 하나밖에 없다.
		System.out.println("main() : x = " + x[0]);
		
		change(x);
		System.out.println("after change(x)");
		System.out.println("main() : x = " + x[0]);
		
	}		
		static void change(int[] y) {
			y[0] = 1000;
			System.out.println("change() : x = " + y[0]); 
		}
		
		// 배열은 참조변수를 통해 저장공간에 접근해서
		// 참조형 매개변수를 쓸 필요 없이 배열만 써줘도(int[] y) x값을 참조해서 x값을 바꾸게된다.
	
}
