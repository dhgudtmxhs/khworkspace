package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {

		/*
		 * for문 
		 * - 끝이 정해져 있는(횟수가 지정되어 있는) 반복문
		 * 
		 * [작성법]
		 * 
		 * for(초기식; 조건식; 증감식){
		 * 		반복 수행할 코드
		 * }
		 * 
		 * - 초기식 : for문을 제어하는 용도의 변수 선언 (int num;)
		 * 
		 * - 조건식 : for문의 반복 여부를 지정하는 식 (다음 반복 진행 해? 말아?)
		 *			보통 초기식에 사용된 변수를 이용하여 조건식을 작성한다. 
		 * 
		 * - 증감식 : 초기식에 사용된 변수를 for문이 끝날 때 마다
		 * 			증가 또는 감소 시켜 조건식의 결과를 변하게 하는 식
		 * 
		 */

	public void ex1() {
		
		//for문 기초 사용법1
		// - 1~10 출력하기

		for(int i = 1; i <= 10; i++) {
		  //초기식   // 조건식  // 증감식
			System.out.println(i + "을 출력한다.");
		for(int j = 0; j <= 15; j++) {
			System.out.println("j는 " + j);
			}
			}
		// i for문 i = 1 => j for문 j= 1~15 까지 수행 후 다시 i for문 i=2 로 넘어옴. i가 10이고 j가 1~15까지 해야 조건식이 false가 되서 멈춤
		// 멈추는 원리 : 조건식이 true면 수행하고 조건식이 false면 수행하지 않는다.
	}
	public void ex2() {
		
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <=5; j++)	{
			System.out.print("*");
		}
		System.out.println();
		}
		System.out.println();
	for(int x = 1; x <=5;x++) {
		for(int y = 0; y<x; y++) {
			System.out.print("*");
		}
	System.out.println();
	}
	
	
	}
	public void ex3() {
		
		// for 기초 사용법2
		
		// -> 3에서 7까지 1씩 증가하며 출력
		// -> i의 값이 7 이하일때 true가 되는 조건식
		
		// 3 4 5 6 7
	
		for(int i = 3; i <= 7; i++ )
			System.out.print(i + " ");
		
	
	}

	public void ex4() {
		
		//2부터 15까지 1씩 증가하며 출력
		
		Scanner sc = new Scanner(System.in);
			
		System.out.print("끝 번호 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			System.out.println(i);
		}
		
		
		}
		
	public void ex5() {
		
		//1부터 입력 받은 수까지 2씩 증가하며 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("끝 번호: ");
		int last = sc.nextInt();
		
		for(int i = 1; i <= last; i+=2) {
			
			System.out.println(i + "을 출력합니다.");
		}
		
		
		
		
	}
	
	public void ex6() {
	
	// 1.0부터 입력 받은 실수까지 0.5씩 증가하며 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("끝나는 실수 : ");
		double last = sc.nextDouble();
		
		for(double d = 1.0; d <= last; d+=0.5) {
			System.out.print(d + " ");
		}
}

	public void ex7() {
		
		// 영어 알파벳 A부터 Z까지 한 줄로 출력
		
		// char 자료형은 문자형이지만 실제로는 정수(문자표 번호 유니코드)를 저장한다.
		
		for(int i = 'A'; i <= 'Z'; i++) { // 출력 가능 실제로 컴퓨터에 저장되는건 유니코드 숫자니까. 자동형변환
			System.out.print((char)i); // 강제형변환
		}
	System.out.println("\n--------------------------------");
	
	for(char i = 'A'; i <= 'Z'; i++) {
		System.out.print((int)i + " "); 
		
	
	}
	
	}

	public void ex8() {
		
		// 10에서 1까지 1씩 감소하며 출력
		for(int i = 10; i>=1; i-- ) {
			System.out.println(i);
		}
	}

	public void ex9() {
		
		//for문 응용 1 : 반복문을 이용한 값의 누적
	
		//1부터 10까지 모든 정수의 합 구하기
		
			int sum = 0; // 합계 구할 변수 선언 및 초기화
					 // 0으로 해야 정확한 합 구할 수 있다.
			for(int i = 1; i<=10; i++) {
			sum += i;
			System.out.println("합계 : " +sum); // int 1 ~ 10 까지 다 출력
		}
			System.out.println(sum); // for 문 밖에 써서 마지막에 계산 된 sum만. 즉 총합 만 출력한다.
	
			
	
	}

	public void ex10() {
		
		//for문 응용 2 : 정수 5개를 입력 받아서 합계 구하기
		
		//ex
		//입력 1: 10
		//입력 2: 20
		//입력 3: 30
		//입력 4: 40
		//입력 5: 50
		//합계 : 150
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("입력 1 : ");
		//int input = sc.nextInt(); 원래 했던 방식
		
		int sum = 0;
		
		for(int i = 1; i<=5; i++) {
			System.out.print("입력 " + i + " : "); // i = 1일때, i가 2일떄, ......
			int input = sc.nextInt();
		
			//System.out.println(i + " : " + input);
		
			sum += input; // sum에 input값을 누적
		}
	
		System.out.println(sum);
		
	}
	
	public void ex11() {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) {
			System.out.print("입력한 값  = ");
			int input = sc.nextInt(); // 내가 콘솔창에 입력하는거
		
			sum = sum + input;
			
			System.out.println(input);
		}
		//System.out.println(input); for 문 괄호{} 안에서 만들어진 변수는 for문 바깥에서 사용할 수 없다. 에러남
		
		System.out.println("입력한 값의 총 합 " + sum); // sum은 괄호 밖에서 생성했기 때문에 사용할 수 있다.
		
		
	}
	
	public void ex12() {
		
		  // 정수를 몇 번 입력 받을지 먼저 입력 받고
	      // 입력된 정수의 합계를 출력
	      
	      // ex)
	      // 입력 받을 정수의 개수 : 3
	      // 입력 1 : 10
	      // 입력 2 : 20
	      // 입력 3 : 30
	      // 합계 : 60
	      
	      // ex)
	      // 입력 받을 정수의 개수 : 2
	      // 입력 1 : 10
	      // 입력 2 : 20
	      // 합계 : 30
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		 
		System.out.print("입력 받을 정수의 개수 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			
		System.out.print("입력 " + i + " : ");
		int input = sc.nextInt();
		sum += input;
			 
		}
		System.out.println("합계 : " + sum);
		}
	
	public void ex13() {
		
		// 1부터 20까지 1씩 증가하면서 출력
		// 단, 5의 배수에 ()를 붙여서 출력
		// ex) 1 2 3 4 (5) 6 7 8 9 (10)
		
			for(int i = 1; i<=20; i++) {
			
			if(i % 5 != 0) {
				System.out.print(i + " ");
			
			}else {
				System.out.print("(" + i +") ");
			
			}
			}
}

	public void ex14() {
		
		  // 1 부터 20까지 1씩 증가하면서 출력
	      // 단, 입력 받은 수의 배수는 () 표시
	      
	      // ex)
	      // 괄호를 표시할 배수 : 3
	      // 1 2 (3) 4 5 (6) ...
	      
	      // 괄호를 표시할 배수 : 4
	      // 1 2 3 (4) 5 6 7 (8) 9 ...
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("괄호를 표시할 배수 : ");
		int num1 = sc.nextInt();
		
			for(int i = 1; i <= 20; i++) {
			
			if(i % num1 !=0) { // i는 num1의 배수가 아니면
				System.out.print(i + " ");
			
			}else { // i는 num1의 배수면
				System.out.print("(" + i + ") ");
			}		

		}
	
	}

	public void ex15() {
		
		  // [구구단 출력]
	      // 2 ~ 9 사이 수를 하나 입력 받아
	      // 해당 단을 출력
	      // 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력
	      
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		if(2 <= dan && dan <=9) { // 2 x i = 2 x 1,2,3,4,5, ...... 를 표현
			
		
			for(int i = 1; i<=9; i++) { // x1, x2, x3 ... x9 까지를 표현
			
				System.out.printf("%d X %d = %d%n",dan, i, dan*i);
			}
			}
			else {
				System.out.println("잘못 입력 하셨습니다!");
			}
		
		}

	public void ex16() {
			
			// [ 19단 출력기]
			// 2~19단 사이의 단을 입력받아 x1 ~ x 19 까지 출력
			// 단 2 ~19 사이 단어 입력되지 않으면 "잘못 입력하셨습니다." 출력

		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		if(2 <= dan && dan <= 19) { // 2단 ~ 19 단 까지 갈 때
			for(int i = 1; i <= 19; i++) { // 각 단마다 x 1~ 19 까지 하게 만든다.
				System.out.printf("%d x %d = %d%n", dan, i, dan * i); // 2단이 실행되고 for i = 1~19 다음 3단 실행
			}
		}else {
			System.out.println("잘못 입력하셨습니다."); // Scanner를 안쓰면 dan 값이 있어야 되고 dan = 3 이면 그 단만 출력될거임
		}
		
	
	
	
	}
	
	public void ex17() {
		
		// 중첩 반복문
		// 2023 - 04 - 21 09 : 16 : 47 
		// 초부터 왼쪽으로 6중첩 반복
		
		// 구구단 모두 출력하기
		
			for(int dan = 2; dan <=9; dan++) { // 2 ~ 9단까지 차례로 증가
				
		// 안쪽 for문이 반복하면서 하나의 단을 한 줄로 출력한다.
				for(int num = 1; num <= 9; num ++){ // 각 단에 곱해질 수 1~9 까지 차례대로 증가
													// num = 10 일때 다시 앞의 for문으로.
					System.out.printf("%2d x %2d = %2d ", dan, num, dan * num); 
				}
				System.out.println(" "); // 안의 for문을 빠져나온 뒤 바깥의 for문 가기 전 (2 -> 3 가기전) 줄바꿈을 한다.
			}
		
	}
	
	public void ex18() {
		
		//구구단 역순 출력
		
		// 9단 -> 2단까지 역방향
		// 곱해지는 수는 1 -> 9 까지 정방향
		
		
			for(int dan = 9; dan >=2; dan--) { // dan 이 9 => 2 역방향 출력이 된다.
				
				for(int num = 1; num <=9; num++){ // x 1~9 10이면 다음 단.
					
					System.out.printf("%2d x %d = %-2d", dan, num, dan * num);
					
				} // 한 단의 출력을 종료한다.
				System.out.println(); //줄바꿈
				System.out.println();
			}
		
		
	}

	public void ex19() {
		
			// 2중 for문으로 다음 모양을 출력해라.
		
			//12345
			//12345
			//12345
			//12345
			//12345
		
			for(int i = 1; i <= 5; i++) { // j
				
				for(int j = 1; j <= 5; j++) {// 1가 1일때 j는 12345 i가 5일때 까지 j는 12345
			
				System.out.print(j);
				//  i = 1 => 12345
				//  i = 2 => 12345
				//  i = 3 => 12345
				//  i = 4 => 12345
				//  i = 5 => 12345 
				//  i는 j를 5번 반복한다는 뜻
				}
				System.out.println();
			}
			
			System.out.println();
			
			for(int x = 1; x <= 7; x++){
				
				for(int y = 1; y<= 5; y++) { 
					System.out.print(x); // x를 1부터 7까지 5번 반복한다. 
										 //1일때 y = 1,2,3,4,5 근데 값이 없으니까 x를 5번 반복해서 11111
										 // x= 2 되면 y= 1,2,3,4,5 까지 x 5번 다시 반복 22222
				}
				System.out.println();
				}
			
				System.out.println("-------------------------------------");
			
					// 54321
					// 54321
					// 54321
				
				for(int m = 1; m<=3; m++) {
					for(int n = 5; n >= 1 ; n--) {
						
					System.out.print(n);
					}
					System.out.println();
					}
			
					// 바깥을 반복하면 1111, 2222, 3333
					// 안을 반복하면 1234, 1234, 1234
}

	public void ex20() {
		
		// 2중 for문을 이용하여 다음 모양을 출력하시오.
		
		// 1
		// 12
		// 123
		// 1234
		
		for(int i = 1; i <=4; i++) {
			
			for(int x =1; x <= i; x++) {
		
			System.out.print(x);
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		for(int m = 1; m<=5; m++) {
			
			for(int n =1; n <= m; n++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		for(int p = 1; p <= 5; p++) {
			
			for(int o = 5; o >= p; o--) {
				System.out.print(o);
			}
				System.out.println();
		}
		
		System.out.println("-------------------");
		
		for(int q = 1; q <= 3; q++) {
			for(int w = 1; w <=3; w++) {
				System.out.print("*");
			}
				System.out.println();
		}
		
		System.out.println("-------------------");
	
		// 4321
		// 321
		// 21
		// 1
	    for (int g = 4; g >= 1 ; g--) { // 줄 반복
		
		for(int t = g; t >= 1; t--) { // 숫자 출력
		
		// t = g g = 4 => t = 4
		// 4 3 2 1
		// t = g g = 3 => t = 3
		// 3 2 1
			
		System.out.print(t);
		}
		System.out.println();
		}
	    //x = 4  4 3 2 1 t=4
	    //x = 3  3 2 1 t=3
	    //x = 2  2 1 t=2
	    //x = 1  1 t=1
	    
	
	}
	
	public void ex21() {
		
		// count (숫자 세기)
		
		// 1부터 20까지 1씩 증가하면서
		// 3의 배수의 총 개수를 출력한다.
		// 3 6 9 12 15 18 : 6 개
	
		int count = 0; // 3의 배수의 개수를 세기 위한 변수
		int sum = 0;
		
		for(int i = 1; i <= 20; i++) {
			
			if(i % 3 == 0){
				System.out.print(i + " ");
				
				count++; // 3을 만날때마다 count가 1 증가한다.
				sum += i;
			}
		}
		System.out.println(" = " + count + "개");
		System.out.println("3의 배수의 합계 : " + sum );
	}
	
	public void ex22() {
		
		// 2중 for문과 count를 이용해서 아래 모양 출력하기
		
		// 1 2 3 4
		// 5 6 7 8
		// 9 10 11 12
		
		int count = 15;
		
		for(int i = 1; i<=3; i++) {
			
			for(int x = 1; x<=4; x++) {
				count ++; //출력하기 전 0에서 1만들어 주고 1~ 12
				System.out.printf("%4d", count);
			//  count ++; 여기다하면 출력 후 1 ~ 12
			}
			System.out.println();
		}
	
	
	
	}
	
	
	
}
	

	



