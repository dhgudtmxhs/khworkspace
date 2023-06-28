package practice;

public class SumTest {
	
	public static void main(String[] args) {
		
		Sum sum = new Sum(); //sum 객체 만들기
		
		int result = sum.add(3, 5); // 참조변수로 add
		
		System.out.println(result);
		
		long result1 = sum.max(5, 3);
		
		System.out.println(result1);
		
		long result2 = sum.max(11, 5);
	
		System.out.println(result2);
		
		sum.max(11,6); // 하면 동작은 하지만 저장할 곳이 없어서 아무 의미 없는 식임.

		long result3 = sum.min(3, 5);
		
		System.out.println(result3);
	
		long result4 = sum.min(12, 7);
		
		System.out.println(result4);
	
		double result5 = sum.divide(12, 7); // long을 호출했지만
		
		System.out.println(result5); // long이 메소드 안에서 double로 자동 형변환됨
	
		long result6 = sum.multiply(12, 7); // 여기서 long에 대입했으니까 int가 long으로 자동형변환됨
		
		System.out.println(result6); // 
		
		sum.printGugudan(3);
		sum.printGugudan(12); // return쓰니까 조건식 참되서 return 당함
		sum.printGugudan(6);
	}
}	


