package practice;

public class ReturnTest {

	public static void main(String[] args) {
		
	
	ReturnTest r = new ReturnTest(); // 자기 클래스 안에 클래스 인스턴스 생성 그냥 가능하다고 받아들이셈
	
	int result = r.add(3,5);
	System.out.println(result);
	
	int[] result2 = {0};
	r.add(3,5,result2);
	System.out.println(result2[0]);
	
	}

	int add(int i, int j) {return i + j;} // 반환값이 있는 메소드를

	void add(int a, int b, int[] result) {result[0] = a + b;} // 반환값이 없는 메소드로 바꾼다.	
	// 매개변수로 넘겨받은 배열에 연산결과를 저장

}
