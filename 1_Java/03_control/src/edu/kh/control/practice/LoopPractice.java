package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {

	public void ex1() {
		
		// 한 개의 값을 입력받아 1부터 그 숫자까지의 숫자 모두 출력
		// 단, 입력한 수는 1보다 크거나 같아야 함
		// 만약 1 미만의 숫자가 입력되면 "1 이상의 숫자를 입력해주세요" 출력

		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num >=1) {
			for(int i = 1; i<=num; i++){
				System.out.print(i + " ");
		}
		}	else {
			System.out.print("1 이상의 숫자를 입력해주세요.");
		}
}
	
	public void ex2() {
		
		// 한 개의 값을 입력 받아 1부터 그 숫자까지 모든숫자를 거꾸로 출력
		// 단, 입력한 수는 1보다 크거나 같아야 함
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 :");
		int num = sc.nextInt();
		
		if(num <1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}else {
			for(int i = num; i >= 1; i--) {
				System.out.print(i + " ");
			}
		}
		
		
		/*if(num >=1) {
			for(int i=1; i<=num; i++) {
			int num2 = num - i + 1;
				System.out.print(num2 + " " );
		}
		}	else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
		*/
		
		
}
	
	public void ex3() {
		
		// 1부터 입력받은 수까지의 정수들의 합을 for문을 이용해 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum = 0; 
		
			for(int i = 1; i<=num; i++) {
				System.out.print(i);
				sum += i;
				if(i != num) {
				System.out.print(" + ");
		}
		}
		System.out.print(" = " + sum );
}
	
	public void ex4() {
		
		// 두 개의 값을 입력받아 그 사이의 숫자를 모두 출력
		// 만약 1 미만의 숫자가 입력되면 "1 이상의 숫자"를 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		
		}else if(num1 <=num2) {
			for(int i = num1; i<=num2; i++) {
			System.out.print(i + " ");
		}
		}else{
			for(int i = num2; i<=num1; i++) {
				System.out.print(i + " ");
		}
	}
	
/*Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 :");
		int num = sc.nextInt();
		
		if(num >=1) {
			for(int i=1; i<=num; i++) {
			int num2 = num - i + 1;
				System.out.print(num2 + " " );
		}
		}	else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
*/
	
		
		
	}
	public void ex5() {
		
		//연도가 주어지고, 윤년이면 1 아니면 0 출력
		// 윤년은 연도가 4의 배수 이면서 100의 배수가 아닐때 또는 400의 배수일때
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도를 입력하세요. : ");
		int year = sc.nextInt(); 
		
			if(1<= year && year <=4000 &year % 4 == 0) {
			
				if(year % 100 != 0 || year % 400 == 0) {
						System.out.println(1);
			
				}else { 
						System.out.println(0);
				}
				}else {
					System.out.println(0);
					}
	
				
	}
	


}

	

