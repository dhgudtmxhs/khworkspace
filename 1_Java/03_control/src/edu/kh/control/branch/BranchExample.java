package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {

	
	public void ex1() {
		
		// 1부터 10까지 1씩 증가하며 출력하는 반복문을 작성
		// 단, 5를 출력하면 반복문을 멈춘다.
		
		for(int i = 1; i<=10; i++) {
			//System.out.print(i + " ");
			if(i == 5) {
					break; 	// 실행되면 반복문이 중단된다.	//5에서 "중단"했으니까 5를 출력 안하는거임
			}			
					 System.out.print(i + " "); //  그래서 여기는  i = 4 까지임.
		}	
}

	public void ex2() {
		
		// 0이 입력될 때 까지의 모든 정수의 합 구하기
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0;
		int sum = 0;
		
		// while문을 처음에 무조건 수행하고, 특정 조건에 종료하는 방법
		// 1) input에 초기값이 0이 아닌 다른 값 넣기
		// 	  while(input != 0)
			
		// 2) do ~ while 문 사용
		
		// 3) 무한 루프 상태의 while 문을 만들고
		//    내부에 break 조건을 작성한다.
		
		while(true) { // 무한루프
			
			System.out.print("정수 입력 : ");
			input = sc.nextInt(); // 입력
			sum += input;
			
			if(input == 0) { // 입력 받은 수가 0인지 검사 (while 종료 조건)
				break; // 무한루프인 반복문 종료
			}
			
		}
			System.out.println("합계 : " + sum);
		// Unreachable code (도달할 수 없는 코드)
	}
	
	public void ex3() {
		
		//입력 받은 모든 "문자열"을 누적
		// 단, "exit@" 를 입력 시 문자열 누적을 종료하고 결과 출력
		
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // 빈 문자열
						 // 쌍따옴표("") 기호를 사용해 String 리터럴임을 지정
						 // 내용은 없음
		
		while(true) {
			
			System.out.print("문자열 입력(exit@ 입력 시 종료) : " );
			String input = sc.nextLine();
			
			
			// next() : 다음 한 단어(띄어쓰기 포함 x)
			// nextLine() :다음 한 줄 (띄어쓰기 포함 o)
				
			
			//if(input == "exit@") {
			
			if(input.equals("exit@")) {
			
			//String 자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없다.
			//비교연산자는 보통 기본 자료형 끼리의 연산에만 사용 가능하다.
			//String 자료형은 기본 자료형이 아닌 참조형이다. 	
			
			// 해결 방법 : 문자열1.equals(문자열2) 로 비교 가능하다.	
				
				break; // 입력받은 문자열이 "exit@" 면 반복 종료
			}
		
			str += input + " \n"; // 누적 시 개행문자 추가 // %n은 %n이 출력됨 printf가 아니라서
		
		} // while 끝
			System.out.println("-------------------------");
			System.out.println(str);
			
		}
		
	public void ex4() {
		
		// 중첩 반복문 내부에서 break 사용하기
		
		// 구구단 2~9단까지 모두 출력
		// 단, 2단은 x2까지, 3단은 x3까지 ... 9단은 x9 까지만 출력
		
		for(int i = 2; i<=9; i++) {
			
			for(int x = 1; x<=9; x++) {
				
				System.out.printf("%d x %d = %-3d", i, x, i * x);
			
					if(i == x) { // 단과 곱해지는 수가 같을 경우
						break; // 분기문이 중첩 반복문 내에서 사용되면
							   // 가장 가까운 반복문에 작용한다! 
							   // for(int x = 1; x<=9; x++) 여기만 작동해서 단은 그대로고 
							   //x 2 x 3 x 4 만 단과 같으면 break 되는 방식
				}
				}
				System.out.println();
			}
		
}
	
	public void ex5() {
		
		// break : 가장 가까운 반복문을 멈춤
		// continue : 다음 반복으로 넘어간다
		
		// 1 ~ 10 까지 1씩 증가하며 출력
		// 단, 3의 배수는 제외

		for(int i = 1; i <= 10; i++) {
			
			if(i % 3 ==0) { // i가 3의 배수일때
				continue; // 다음 반복으로 넘어감. i = 3일때 밑의 sysout 3값을 출력 안하고 i = 4인 경우로 바로 넘어감 
				
			}

			System.out.print(i + " ");

		}
}

	public void ex6() {
		
		// 1 ~ 100까지 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 건너뛴다
		// 증가하는 값이 40이 되었을 때 반복을 멈춘다.
		
			for(int i = 1; i <= 100; i++) {
				
				if(i == 40) {
					break;
				}if(i % 5 == 0){
					continue;
				}//if (i == 40) break를 여기쓰면 
				//if문(i == 40)이 continue때문에 일어나지 않음.
				//continue는 일어나면 다음 반복 자체 (for문 처음)으로 넘어감
				
				System.out.print(i + " ");
			
			}
	}

	public void RPSGame() {
		
		   // 가위 바위 보 게임
		   
		   // 몇판? : 3
		   
		   // 1번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
		   // 컴퓨터는 [보]를 선택했습니다.
		   // 플레이어 승!
		   // 현재 기록 : 1승 0무 0패
		   
		   // 2번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  보
		   // 컴퓨터는 [보]를 선택했습니다.
		   // 비겼습니다.
		   // 현재 기록 : 1승 1무 0패
		   
		   // 3번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
		   // 컴퓨터는 [바위]를 선택했습니다.
		   // 졌습니다ㅠㅠ
		   // 현재 기록 : 1승 1무 1패
		
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("[가위 바위 보 게임]");
		   System.out.print("몇 판 할거니? ");
		   int round = sc.nextInt();
		 
		   // 승패 기록용 변수
		   int win = 0;
		   int draw = 0;
		   int lose = 0;
		   
		   
		   for(int i = 1; i <= round; i++) { // 입력 받은 판 수 만큼 반복
			   
			   System.out.println("\n" +i+ "번 째 게임");
			   System.out.print("가위/바위/보 중 하나를 입력 해주세요 :");
			   String input = sc.next(); // 플레이어가 가위/ 바위/ 보 입력 띄어쓰기 없으니까 nextLine 안해도 됨
			   
			   // 컴퓨터 가위/바위/보 정하기(랜덤)
			   // 1~3 사이 난수 생성
			   // -> 1이면 바위, 2면 바위, 3이면 보로 지정한다.
			   
			   // 난수 생성 방법 : Math.random()
			   // -> 호출하면 0.0 이상 1.0 미만의 난수가 생성된다.
			   
			   int random = (int)(Math.random() * 3 + 1); // 0.0 <= x < 1.0 
		   					  	  			 // 0.0 <= x < 3.0
			   						  		 // 1.0 <= x < 4.0		
			   								 // 1   <= x < 4		
			   								 // => 1이상 4미만의 정수 => 1, 2, 3 이 나올거다.
			   
			   String com = null; // case 밑 default 도 가능 컴퓨터가 com이 초기화됐는지 몰라서 씀
			   					  // null : 아무것도 참조하고 있지 않다.
			   switch(random) {
			   case 1 : com = "가위"; break;
			   case 2 : com = "바위"; break;
			   case 3 : com = "보"; break;
			   }
			   boolean win1 = input.equals("가위") && com.equals("보");
			   boolean win2 = input.equals("바위") && com.equals("가위");
			   boolean win3 = input.equals("보") && com.equals("바위");
			
			   System.out.printf("컴퓨터는 [%s]를 선택했습니다.", com);
			   // 컴퓨터와 플레이어(기준) 으로 가위 바위 보 승 패 무 판별
			   // win, draw, lose
			   
			   if(input.equals(com)) { // 비긴경우 // 둘다 String
				   System.out.println("비겼습니다.");
				   draw++;
				   
			   }else if(win1 || win2 || win3) {// 가위를 내서 이겼거나 바위를 내서 이겼거나 보를 내서 이겼을 때
					  System.out.println("플레이어 승"); 
					  win++;
					   
			   }else { // 비긴거 끝, 이긴거 끝이라 진 것 밖에 없음
					   System.out.println("졌습니다");
					   lose++;
			   }
			   System.out.printf("현재 기록 : %d승 %d무 %d패%n", win, draw, lose);
		   }
}
	
	
	
}
