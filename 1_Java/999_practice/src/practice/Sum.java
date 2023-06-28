package practice;

public class Sum {

	
	
	int add(int x, int y) {
		
		//int result = x + y;
		//return result;
		// 한줄로 합치면 =
		return x + y;
	}
	
	long max(long a, long b) {
		
		return 	a > b ? a : b;
		// long result = 0;
		// long result = a > b ? a : b;
		// return result; 를 한문장 으로 한 것
		
	}
	
	 long min(long c, long d) {
		if(c > d)
			return c; // 여기까지만 쓰면 참일때만 return이라 에러가 뜸.
		else
			return d; // 조건식이 거짓일 때 실행
		
	}
	 
	 double divide (double a, double b) {
		 return a / b;
	 }
	
	 int multiply(int a, int b) {
		 return a * b;
	 }
	 
	 void printGugudan(int dan) {
		
		 if(!(2<=dan && dan <=9))
			 return; // 입력받은 단(dan)이 2~9가 아니면, 메서드 종료하고 돌아가기
			 
		 for(int i = 1; i <= 9; i ++) {
			 System.out.printf("%d * %d = %d%n", dan, i, dan * i);
		 }
		 	return; // 컴파일러가 알아서 해주는 return; void 일 때. 안써도 됨.
	 }
}
