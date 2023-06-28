package edu.kh.variable.ex1;

public class VariableExample3 {

	public static void main(String[] args) {
				
		/* 형변환(casting) : 값의 자료형을 변환한다.
		 *					단, boolean은 제외 
		 * 
		 * 형변환이 필요한 이유
		 * 컴퓨터는 기본적으로 같은 자료형끼리만 연산이 가능함.
		 * 다른 자료형과 연산 시 오류 발생
		 * --> 그래서 형변환 쓴다.
		 * 
		 * 자동 / 강제 형변환이 존재
		 */
		
		//자동 형변환
		// 값의 범위(byte의 크기가 아님 long8byte < double4byte)가 큰 자료형과
		// 값의 범위가 작은 자료형의 연산시
		// 작은 자료형 -> 큰 자료형으로
		// 컴파일러에 의해 자동 변환되는 것
		
		int num1 = 10;
		double num2 = 3.5;
		System.out.println("자동 형변환 결과 :" + (num1 + num2)); 
		// 10.0 으로 double형으로 형변환 뒤 계산
		// 10.0 + 3.5 = 13.5
		// 괄호 안치면 연산 우선순위때문에 103.5가 됨
		// 아마 문자열 + 숫자열 + 숫자열로 읽혀서 그렇게 되는듯
		
		int i1 = 3;
		double d1 = i1;
		
		System.out.println("i1 : " + i1); 
		System.out.println("d1 : " + d1); // 3이 3.0으로 자동 형변환
		// double은 실수만 저장할 수 있는 자료형이다. d1이 3.0으로 저장된 거임 거꾸로 올라가는게 아니라
		
		System.out.println("d1 + num2 = " +(d1+num2)); // 3.0 + 3.5
		
		
		
		// short 와 char도 byte는 같지만 값의 범위가 다르다. 0~65535, -32768~32767 
		// 그래서 형변환 못함
		
		// int -> long 형변환
		int i2 = 2_100_000_000;
		long l2 = 10_000_000_000L;
		long result2 = i2 + l2;
		// int + long -> long + long = long
		
		System.out.println("result2 : " + result2);
		
		int i55 = 21_000;
		System.out.println(i55);
		//char -> int 형변환
		char ch3 = 'W';
		int i3 = ch3; // int 변수에 char 값 대입 문자형 char형 'W'가 정수형 int형으로 자동형변환됨
		
		System.out.println(ch3);
		
		System.out.println(i3);
		
		System.out.println((int)ch3);
		
		char ch4 = '각';
		int i4 = ch4;
		
		System.out.println('각');
	
		System.out.println(i4); // 각의 유니코드는 44033
		
		// long -> float
		long l5 = 123456789123456789L;
		float f1 = l5 * 100; // l5 * 100은 long 범위를 초과함
		//float = long(l5) * int
		//float = long(l5) * long 자료형
		//float = long 결과
		//float = float(자동 형변환)
		System.out.println(l5);
		System.out.println(f1); // -6.1010652E18 오버플로우  
		
		//오버플로우 현상은 컴퓨터가 예측할 수 없다.
		//개발자가 미리 예측해야 한다.
		
		int i6 = 2147483647; // int의 최대값
		int result6 = i6 + 1;
		System.out.println(result6);
		
		
		
		
		

	
		}

}
