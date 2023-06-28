package practice;

public class MyMath3 {

	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	
	long add(long a, long b) {
		System.out.print("long add(long a, long b) -");
		return a+b;
	}
	
	int add(int[] a) { // 배열형도 다르니까 오버로딩 가능
		System.out.print("int add(int[] a) - "); // 원래 println같은 출력은 printlnboolean(boolean x)
												 // pirintlnString(String x)이렇게 다 나뉨. 오버로딩된 메소드를 자동으로 가져오는거 
		int result = 0;
		
		for(int i = 0; i < a.length; i++)
		
		result += a[i]; //a 배열의 i번째 요소를 더한다. a 배열은 arr배열이 int[] a배열로 들어온것
		
		return result;
	
	}
	
	// 연산자 오버로딩도 있음 + 는 부호, 덧셈, 문자열 결합으로 쓰임
	// 하지만 자바에서 그냥 제공해주는거고 우리가 사용할 수는 없다고 함
	
	public static void main(String[] args) {
		
		MyMath3 m = new MyMath3();
		
		System.out.println("결과 : " + m.add(3,3)); // 
		//int result = m.add(3,3);
		//System.out.println(result); 와 같음.
		
		
		System.out.println(" 결과 : " + m.add(3l,3l));
		
		//int[] arr = {1,2,3,4,5};
		//int result3 = m.add(arr);
		//System.out.println(result3);
		// int result3 = m.add({1,2,3,4,5});로 못하는 이유
		// 배열을 생성하고 초기화할때는 중괄호{}를 사용할 수 있지만
		// 메서드를 호출할 때는 해당 배열 변수명을 인자로 전달해야 한다.
		// 변수를 정해서 넣어줘야 한다.
				
		int[] arr = {100, 200, 300};
		System.out.println(m.add(arr));
		
		
		
		
	}
}



