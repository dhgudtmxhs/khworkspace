package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample2 {

		public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
	
			//사칙연산 계산기
			//두 실수를 입력받아 사칙연산 결과를 모두 출력하겠다.
		
			System.out.print("실수 하나를 입력하세요 : ");	
			double input1 = sc.nextDouble();
			
			System.out.print("실수 하나 더 입력하세요 : ");
			double input2 = sc.nextDouble();
			//nextDouble : 입력받은 다음 실수를 읽어온다.
		
			//ctrl + alt + 방향키 위 or 아래 => 복사
			
			System.out.printf("덧셈\t %.2f + %.2f = %.2f%n", input1, input2, input1 + input2);
			
			System.out.printf("뺄셈\t %.2f - %.2f = %.2f%n", input1, input2, input1 - input2);
			
			System.out.printf("곱셈\t %.2f * %.2f = %.2f%n", input1, input2, input1 * input2);
			
			System.out.printf("나눗셈\t %.2f / %.2f = %.2f%n", input1, input2, input1 / input2);
			
			
			}
		
}
