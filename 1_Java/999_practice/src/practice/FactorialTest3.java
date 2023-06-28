package practice;

public class FactorialTest3 {

	public static void main(String[] args) {
		
		int x = 2;
		int n = 5;
		long result = 0;
		
		for(int i = 1; i <= n; i++) {
			
			result += power(x, i); // 2의 1승 + 2의 2승 + 2의 3승 + 2의 4승 + 2의 5승
								   // power(2,5) = 2의 5승
								  // 2의 1승부터 2의 5승까지 더한다.
		}
		
		System.out.println(result);
	}

		static long power(int x, int n) {
			
			if(n==1) return x;
			
			return x * power(x, n-1); // 팩토리얼과 유사
			// 2 * 2,4  
			// 2 * 2 * 2,3
			// 2 * 2 * 2 * 2,2
			// 2 * 2 * 2 * 2 * 2,1
			// 2 * 2 * 2 * 2 * 2
		}

	
}
