package edu.kh.variable.ex2;

import java.util.Scanner;

public class Scnextline {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
			// 1이상 10이하의 수인지 확인
		System.out.print("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		
		boolean boo = (1<= a && a <=10);
		System.out.printf("%d은 1이상 10이하의 수 인가요? %b%n", a, boo);
		
		System.out.print("숫자를 입력하세요 :");
		int b = sc.nextInt();
		
		boolean booo = (b==3);
		System.out.printf("%d는 3인가요? %b%n", b, booo);
			
	}

}
