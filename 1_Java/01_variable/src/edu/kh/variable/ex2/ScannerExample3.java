package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample3 {

	public static void main(String[] args) {
	
			Scanner sc = new Scanner(System.in);
			
			// 문자열(String) 입력받기
			
			// 문자열을 3번 입력 받아 한 줄로 출력하기
			
			// ex
			// 입력 1 : 안녕?
			// 입력 2 : ㅎㅇ!
			// 입력 3 : 밥먹자.
			// -> 안녕? ㅎㅇ! 밥먹자.
			
			System.out.print("입력 1 :");
			String str1 = sc.next();
			// next(); 다음 입력된 '한 단어'를 읽어옴. 
			// nextString();은 없고 nextLine();을 사용하는듯
			System.out.print("입력 2 : ");
			String str2 = sc.next();
			
			System.out.print("입력 3 : ");
			String str3 = sc.next();
			
			System.out.printf("%s %s %s%n", str1, str2, str3);
	
			// 프로그램 : 컴퓨터가 인식할 수 있는 명령어의 집합
			// 컴파일 : 프로그램(명령어의 집합)을 컴퓨터가 이해할 수 있는 언어로 번역하는 것
			// 컴파일러 : 컴파일하는거
			// 변수 : 메모리(RAM)에 값을 기록하기 위한 공간
	
			

		}
	
}
