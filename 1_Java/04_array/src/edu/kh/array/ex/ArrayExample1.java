package edu.kh.array.ex;

import java.util.Scanner;

import java.util.Arrays;


public class ArrayExample1 {

	/* 
	 * 배열(Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것 (자료구조)
	 * - 묶여진 변수들은 하나의 배열명으로 불러지고
	 * - 구분은 index를 이용한다. (index = 0 부터 시작하는 정수)
	 *
	 */

	public void ex1() {
		
		// 변수 vs 배열
		
		// 1-1. 변수 선언 
		//stack 영역에 int 자료형을 저장할 수 있는 공간 4byte를 생성(할당)하고
		//그 공간에 num이라는 이름을 부여했다.
		int num;
		// 1-2. 변수 대입
		num = 10;
		// 생성된 num이라는 변수 공간에 10을 대입
		
		// 1-3. 변수 사용
		System.out.println("num에 저장된 값 : " + num);
		// num이 작성된 자리에 num에 저장된 값을 읽어와서 출력한다.
		
		// ----------------------------------------------------------------------------- //
		
		// 2-1. 배열 선언
		int[] arr; 
		//Stack 영역에 int[] (int 배열) 자료형 공간을 8byte 할당하고 
		//그 공간에 arr이라는 이름을 부여한다.
		//해당 변수는 참조형으로 주소 값(8byte)만을 저장할 수 있다.
		
		// 2-2. 배열 할당
		arr = new int[3]; // 참조형(int 배열)
		// new : "new 연산자" 라고 하며 
		//        Heap 메모리 영역에 새로운 공간(배열, 객체)를 할당
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		
		// new int[3] : heap 영역에 int 3칸짜리 int[]를 생성(할당)
					// 생선된 int[]에는 시작 주소가 지정된다.( 0x300 )
		// arr = new int[3];
		// int[]형 = int[]형 같은 자료형 => 연산 가능
		
		// heap 영역에 생성된 int[]의 시작 주소를
		// stack 영역에 생성된 arr 변수에 대입
		// -> arr 변수가 int[]를 참조하게 된다.
		// (그래서 arr을 참조형이라고 한다)
		

		// arr이 참조하고있는 배열의 x번 인덱스 값을 얻어온다.
		
		// 2-3. 배열 요소 값 대입
		// (int[])arr = (int)10; 자료형이 달라서 연산 안됨 
		// (int[]) 로 변환 불가능. 기본자료형만 댐
		
		// arr은 int[배열] 참조형 변수 이지만
		// arr[0,1,2] 에 있는 index의 값은 int 자료형 변수이기 때문에
		// 정수값을 대입할 수 있다.
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 350;
		
		// 2-4. 배열 요소 값 읽어오기
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
	}
	
	public void ex2() {
		
		// 배열의 선언 및 할당
		
		int[] arr = new int[4]; // 배열이 생성되면 배열의 시작 주소가 생성이 됨
		
		// 1) Stack 영역에 int[] 자료형 참조형 변수 arr 선언한다.
		// 2) Heap 영역에 int 자료형 4개를 묶음으로 다루는 int[]을 할당한다.	
		// 3) 생성된 int[]의 주소를 arr에 대입하여
		//    참조하는 형태를 만든다.
		
		// 배열의 길이(몇 칸인지) : 배열명.length 
		System.out.println("배열의 길이 : " + arr.length);
		
		arr[0] = 100;
		arr[1] = 400;
		arr[2] = 700;
		arr[3] = 1000;
		
		// 배열과 for문 
			
			for(int i = 0; i< arr.length; i++) { // i = index를 뜻함 
				// <= arr.length; 는 배열의 길이보다 1 커져서
				// < arr.length; 해야함
				// int i = 1을 하면 arr[0]에 저장된 값을 구할 수 없음.
				
				System.out.printf("arr[%d]에 저장된 값 : %d%n", i, arr[i]);
				
			}
	
		// 참고
			
		// 비어있다 : stack 영역에 선언된 변수에 값이 대입되지 않음 (=0 이런것도 없음)
		
		// null : 참조형 변수가 선언되었으나 아무것도 참조하지 않음 (빈칸이 아님) null 값도 값임 
			
		// 0 : int 자료형 0은 존재하는 값 (비어있지 않음)	
			
		// "" : String 자료형이지만 내용 없음 (빈 문자열)	
	
	}
	
	public void ex3() {
		
		  // 5명의 키(cm)를 입력 받고 평균 구하기
	      
	      // 1번 키 입력 : 170.5
	      // 2번 키 입력 : 165.7
	      // 3번 키 입력 : 184.3
	      // 4번 키 입력 : 190.2
	      // 5번 키 입력 : 174.4
	      
	      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
	      // 평균 : 177.02cm
		
		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[5];
		// double 배열 자료형 참조 변수 height를 stack 영역에 생성
		// heap 영역에 새로 생성된 double 5칸짜리 double[]의 시작 주소를 height에 대입
		
		/*	height[0] = 170.5;
			height[1] = 165.7;
			height[2] = 184.3;
			height[3] = 190.2;
			height[4] = 174.4;
		*/
		
		for(int i = 0; i < height.length; i++) {
			
			System.out.print( i+1 + "번 키 입력 : "  );
			
			// height = sc.nextDouble(); 형 다름 double 배열 != double
			height[i] = sc.nextDouble();
			// 각 인덱스에 입력 받은 값을 대입하겠다.
		}
		System.out.print("입력 받은 키 : ");
			double sum = 0;	
			
		for(int i= 0; i < height.length; i++) {
			
			System.out.print(height[i] + " ");
			sum+= height[i];
			
		}
		System.out.printf("%n평균 :%.2f%n", sum / height.length);
		System.out.println("총점 : " + sum);
	}

	public void ex4() {

		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[4];
		
		for(int i = 0; i < height.length; i++) {
			System.out.print( i+1 + "번 키 입력 : ");
			height[i] = sc.nextDouble(); // index = double
		}
	
		System.out.print("입력받은 키 : ");
		
		double sum = 0;
		
		for(int i = 0; i < height.length; i++) {
			
			System.out.print(height[i] + " ");
			
			sum += height[i];
		}
		
		System.out.printf("%n평균 : %.2f%n" , sum / height.length);
		System.out.println("합계 : " + sum);
		
	}
	
	public void ex5() {
		
		  // 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
	      // 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
	      
	      // ex)
	      // 입력 받을 인원 수 : 4
	      // 1번 점수 입력 : 100
	      // 2번 점수 입력 : 80
	      // 3번 점수 입력 : 50
	      // 4번 점수 입력 : 60
	      
	      // 합계 : 290
	      // 평균 : 72.50
	      // 최고점 : 100
	      // 최저점 : 50
		
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.print("입력 받을 인원수 : ");
		  
		  int input = sc.nextInt();
		 
		  int[] score = new int[input]; // 입력받을 인원수 맞추기
		  
		  for(int i = 0; i < score.length; i++) {
			  System.out.print(i+1 +"번 점수 입력 : " );
			  
			  score[i] = sc.nextInt(); // 뒤에 sum+= score[i] 빌드업
	
		  } 
		  
		  int sum = 0;
		  
		  for(int i = 0; i < score.length; i++)	{
			  
			   sum += score[i];
		
		  }
		  
		  int max = score[0]; // 처음 배열 []안에 최대값 최저값
		  int min = score[0]; // 다저장시키고 끝까지 비교한다. // [0]으로 안해도 되는듯
		  
		  //아래 for문으로 score배열에 있는 모든 값과 max, min을 비교
		  //이 때,
		  //score[i] 값이 max보다 크면 max에 대입
		  //score[i] 값이 min보다 작으면 min에 대입
		  
		  for(int i = 0; i < score.length; i++) {
			  
			  if(score[i] > max) { // 최고점 비교
				  max = score[i];
				  
			  }else if(score[i] < min) { // 최저점 비교
				  min = score[i];
				  
			  }
			  
		  }
		  
		  System.out.println("합계 : " + sum);
		  //System.out.printf("평균 : %.2f%n", sum / score.length); // int / int = int형 
		  System.out.printf("평균 : %.2f%n", (double) sum / score.length); // 둘중 하나만 바꿔저도 강제형변환
		  System.out.println("최대값 : " + max);
		  System.out.println("최저값 : " + min);
		 
	
	}
	
	public void ex6() {
		
		// 배열 선언과 동시에 초기화
		
		char[] arr = new char[5];
		
		// char[] arr이 참조하는 배열 요소(배열 한 칸 한 칸)에
		// A,B,C,D 대입하기
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (char)('A' + i); // char = int(저장될 때 int) + int 
			// 'A' = 65 'B' = 66 'C' = 67
		
			System.out.print(arr[i] + " ");
		}
			System.out.println();
		// Arrays 클래스
		// -> 자바에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		// Arrays.toString(배열명) : 모든 요소 값을 출력한다.
		
			int[] arr2 = new int[4];
		
			System.out.println(arr2); // int 배열이므로 배열의 참조값(주소값)출력
		
			System.out.println(arr); // char 배열이므로 문자열로 출력
		
			System.out.println(Arrays.toString(arr2));
			
			System.out.println(Arrays.toString(arr));
	
	}
	
	public void ex7() {
		
	
		char[] arr = new char[5];
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (char)('A' + i);
		
			System.out.print(arr[i] + " ");
			
		}
		
		System.out.println(Arrays.toString(arr));
	
	}
	
	public void ex8() {
		
		// 점심 메뉴 뽑기 프로그램
		
		String arr[] = {"김밥", "서브웨이", "햄버거", "백반", "국밥", "파스타"};
		
		// 무작위로 뽑고싶다
		// - > math.random
		// 0 ~ (배열길이 - 1)사이의 난수 발생
		
		
		System.out.println("오점뭐 : " + arr[(int)(Math.random() *6)]); 
		
		// 0.0 <= mr < 1
		// 0.0 <= x * 6 < 6.0
		// 0 <= (int)(x * 6) < 6
		// -> 0 1 2 3 4 5 
		
	}

	public void ex9() {
		
		// 배열을 이용한 검색
		
		// 입력 받은 정수가 배열에 있는지 없는지 확인
		// 만약 있다면 몇번 인덱스에 존재하는지도 출력
		
	
		int arr[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		// int arr[] = new int[]{100, ... 1000};
		System.out.println(Arrays.toString(arr));
		
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		  						// 신호를 나타내기 위한 변수
		boolean flag = false;   // 검사 전에는 없다고 가정 한 것임
		  						// flag == false : 일치하는 값이 존재하지 않음
		  						// flag == true : 일치하는 값이 존재 
		
		// arr 배열 요소 순차 접근(반복 접근)
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == input) {
				
				System.out.println(i + " 번 째 인덱스에 존재");
			
			flag = true; // 일치하는 값이 있으므로 true로 변경
			
		}
		}

		// flag 상태를 검사
		// 원래 if문은 true 여야만 수행
		if(!flag ) { // if(flag == false)
			System.out.println("존재하지 않음");
		}
	
	
		}
	
	public void ex10() {
		
		//입력받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		//없으면 "존재하지 않음"
		
		Scanner sc = new Scanner(System.in);
		
		String[] arr = {"사과", "딸기", "바나나", "키위", "멜론", "아보카도"};
		
		System.out.print("과일 입력 : ");
		String input = sc.next();
		
		boolean flag = false;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i].equals(input)) {
				
				System.out.println(i+ "번 인덱스");
			
			flag = true;
			}
			
		}if(flag == false) {// flag == false  !flag
			
				System.out.println("존재하지 않음");
		}
		}

	public void ex11() {
		
		// 1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		
		// 2. 문자 하나를 입력받아 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		
		// 3. 단, 일치하는 문자가 없을경우 "존재하지 않습니다." 출력
		
		// [사용 해야되는 기술, 기능]
		// 1) 배열 검색
		// 2) String.length : 문자열의 길이
		// ex) "Hello".length() -> 5
		// 3) String.charAt(index) : 문자열에서 특정 index에 위치한 문자 하나를 얻어온다.
		// ex) "Hello".charAt(1) -> H = 0번째 인덱스 .... O 는 5번째 인덱스 (01234) 
		// charAt(1) = 1번째 인덱스 'e' 를 가져옴
		
		// 4) count (숫자 세기)	
	
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine(); //문자열을 입력받아
		
		// 1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		
		char[] arr = new char[input.length()]; // 입력받은 만큼의 배열 길이 정해주기
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = input.charAt(i); // 
			
			//arr[i]에 입력 받은 문자열 중 i번 째 문자를 대입
			//char 배열에 순서대로 저장
			
		}
		
		// 중간확인
		System.out.println(Arrays.toString(arr));
		//System.out.println(arr);
		
		// 2. 문자 하나를 입력받아 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		
		System.out.print("검색할 문자 입력 : ");		
		char ch = sc.nextLine().charAt(0); //nextchar가 없음
				//Stirng.charAt(0) : 문자열 제일 앞 문자 얻어오기
	
		int count = 0; // 같은 글자 개수를 세기 위한 변수
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == ch) {
			//arr[i] 값과 검색할 문자 ch가 같은 경우
			// -> 카운트
				count++;
			}
			
		}
		if(count != 0) {
			System.out.println(count + "개 있음");
		}else {
			System.out.println("존재하지 않습니다.");
		}
		//결과 출력
		//단, 일치하는 문자가 없을경우 "존재하지 않습니다." 출력
		
	}

	public void ex12() {
		
		// 1. 문자열을 입력 받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 2. 문자 하나를 입력받아 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		// 3. 단, 일치하는 문자가 없을경우 "존재하지 않습니다." 출력
		
		Scanner sc = new Scanner(System.in);{
			
			System.out.print("문자열 입력 : ");
			String input = sc.nextLine();
			
			char[] arr = new char[input.length()]; 
			
			for(int i = 0; i < arr.length; i++) {
				
				arr[i] = input.charAt(i); // string으로 입력 받은 수 하나하나씩 char 에 저장
			}
			
			
			System.out.print("검색할 문자 입력 : ");
			char ch = sc.nextLine().charAt(0); // 문자열 제일 앞의 문자를 얻어온다
					
			int count = 0;
			
			for(int i = 0; i < arr.length; i++) {
			
				if(arr[i] == ch) {
					count++;
				}
				
			}if(count > 0) {
				System.out.println(count + "개 있음");
			}else {
				System.out.println("존재하지 않음");
			}
			
			}

			
		}
		

	
}

