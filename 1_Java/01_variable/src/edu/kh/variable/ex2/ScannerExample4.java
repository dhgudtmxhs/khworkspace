package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("입력 1 : "); // ln하면 내가 입력할 값이 한 줄 내려가버림.
		String str1 = sc.next() + " "; // next = 문자 + " " => 한 칸 띄어쓰기
						// 안녕
		System.out.println(str1); // 안녕 뒤 한칸 띄어짐
		
		System.out.print("입력 2 : ");
		str1 = str1 + sc.next() + " "; // 한줄에 뽑기 str1 은 안녕? 이었으니까. 왼쪽 str1 = 안녕 + 반가워
		//String str1 = 하면 변수명이 똑같음. 변수값은 바꿀 수 있어도 변수명을 바꾸면 안돼서 에러남.	
		
		
		// 대입연산자(=) : 오른쪽에 작성된 값을 왼쪽 변수에 대입한다.
		System.out.println(str1);
		
		System.out.print("입력 3 : ");
		str1 = str1 + sc.next() + " "; // str1 = 안녕? 반가워 + 입력3에 입력한 값
		System.out.println(str1);
		
		
		//누적효과 (변수의 재사용성)
	

		

		}
	
	
}
