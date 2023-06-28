package practice;

public class FactorialTest2 {

	

	static long factorial (int n) {
		
		if(n <= 0 || n > 20) return -1; // for문에서 result = factorial(21)부터 -1, 유효하지 않은 값 반환하네
		if(n == 1) return 1;
		
		return n * factorial(n-1); // 2~20
	}
	
	
	public static void main(String[] args) {
		
		int n = 21;
		long result = 0;
		
		for(int i = 1; i <= n; i++) {
			result = factorial(i);
			
			if(result == -1) { // - 1은 factorial(20)이 넘어가서 오버플로우 발생했을때를 의미하나봐
				System.out.printf("유효하지 않은 값입니다.(0<n<=20):%d%n", n); 
				break;
				
			}
			System.out.printf("%2d!=%20d%n", i, result);
		}
	}

	
	
	
	
}
