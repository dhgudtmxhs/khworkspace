package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample5 {

		
		public static void main(String[] args) {
			
		
		Scanner sc = new Scanner(System.in);
		
	
		//nextline은 엔터를 제외하지 않는다.
	
		
		// 2) Scanner 입력 버퍼와 nextXXX의 의미
		// 입력 -> 입력 버퍼에 저장
		// 	   -> nextXXX() 통해 버퍼 내용을 읽어옴
		
		//                입력 버퍼             nextXXX()          후처리
		//nextLine() : hello world(엔터) -> hello world(엔터) -> 엔터 제거
		// 입력 버퍼에 hello world(엔터) 가 들어가있다.
		//nextInt() :     100(엔터)     ->  100(엔터)
		
		//next(),nextDouble(),nextInt() 등 
		// 모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어온다.
		//nextline은 엔터를 제외하지 않는다.//nextline은 엔터를 제외하지 않는다.//nextline은 엔터를 제외하지 않는다.
		
		System.out.println("--------------------------");
		
		System.out.print("nextInt() : "); // 입력버퍼 : [100(엔터)]
		int a = sc.nextInt(); // a에는 100이 담김. // 입력버퍼 : [(엔터)] 가 남아있음.
		
		sc.nextLine();// 엔터 제거하기 입력버퍼에 아무것도 남아있지 않음 []
		
		
		System.out.print("nextLine() : "); // 입력버퍼 : [a b c(엔터)] 할려했는데
		String s = sc.nextLine(); // nextLine은 엔터를 만나면 종료됨.
								  // 그래서 nextInt가 남긴 엔터때문에 나는 콘솔창에 입력 못하고 바로 종료됨.
								  // 그러면 그냥 다음 코드로 넘어가버림. 그래서 종료라는 값이 나옴
		System.out.println("종료");
		
		//[해결방법]
		// 입력을 위한 nextLine()수행 전에
		// 입력 버퍼에서 (엔터)를 제거한다
		// 빈 공간에 sc.nextLine() 구문을 한번 작성하면 (엔터)가 제거된다.
		
		
		
		
		}
			
}
