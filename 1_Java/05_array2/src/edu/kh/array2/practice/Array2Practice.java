package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	public void ex1() {
		
		//3행 3열짜리 문자열 배열을 선언 및 할당
		//인덱스 0행 0열부터 2행 2열까지 차례대로 접근해 "(0, 0)" 형식으로 출력
		
		String [][] arr = new String[3][3];
		
		for(int row = 0; row < arr.length; row++) { // arr.length = 행 3
			
			for(int col = 0; col < arr[row].length; col++) { // arr[row].length = 열 3
				
				System.out.printf("(%d, %d)", row, col);
			}
				System.out.println();
		}
	
	}
	
	public void ex2() {
		
		//4행 4열 정수형 배열 선언 및 할당
		// 1~16 차례대로 저장
		// 저장된 값 차례대로 출력
		
		int[][] arr = new int[4][4];
	
		int num = 1;
		
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = 0; col < arr[row].length; col++) { 
				
					arr[row][col] = num++;
					
					System.out.printf( "%3d" ,arr[row][col] );
			}
					System.out.println();
	}
}
	
	public void ex3() {
		
		int[][] arr = new int[4][4];
		
		int num = 16;
		
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = 0; col < arr[row].length; col++) { 
				
				arr[row][col] = num--;
					
					System.out.printf("%2d ", arr[row][col] );
			}
					System.out.println();
	}
	}

	public void ex4() {
		
		//4행 4열 2차원 배열 생성, 
		//0행 0열부터 2행 2열까지 1~10 임의의 정수 값 저장 후 표처럼 처리
		
		int[][] arr = new int[4][4];
		
		
		// 상수 사용법 : 변하지 않는 특정 값에 이름을 붙여준다.
		final int ROW_LAST_INDEX = arr.length-1;;// 행의 마지막 인덱스 마지막 인덱스는 길이 - 1 과 같다. 
		//행 마지막 인덱스
		final int COL_LAST_INDEX = arr[0].length-1; // 모든 행의 열 길이 같음 [0,1,2,3] 다 가능
		//열 마지막 인덱스
		
		
		for(int row = 0; row < arr.length; row++) { // 행 반복
			
			for(int col = 0; col <arr[row].length; col++) { // row번째 행의 열의 길이 반복 row의 모든 열의 길이는 같다.
				
				//마지막 행, 마지막 열이 아닌 경우
				if(ROW_LAST_INDEX != row && COL_LAST_INDEX != col) {
					
					int random = (int)(Math.random()*10 + 1); // 1 ~ 10 난수 
					arr[row][col] = random;
					
					
				// 각 행의 마지막 난수 누적
				arr[row][COL_LAST_INDEX] += arr[row][col]; // arr[0][3] arr[1][3] arr[2][3] arr[3][3] 뒤가 안변함  그래서 한 행의 마지막 인덱스에 한 행마다 합이 나옴.
	
				// 각 열의 마지막 행에 난수를 누적
				arr[ROW_LAST_INDEX][col] += arr[row][col]; // 
				
				//생성된 모든 난수를 마지막 행, 마지막 열에 누적
				arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col]; 
			}
			System.out.printf("%4d", arr[row][col]);
			}
			//열 반복 끝
			System.out.println();
			}// 행 반복 끝
}
		
	public void ex5() {
		
		//2차원 배열의 행과 열의 크기를 사용자에게 입력받음
		// 1~10 사이 수가 아니면 "반드시 1~10 사이의 정수를 입력해야 함" 출력 후 다시 정수 받게함
		// 크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 해라
		// char형은 숫자를 더해 문자 표현 가능, 65 = A, 알파벳은 총 26글자.
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
		System.out.print("행 크기 : ");
		int row = sc.nextInt();
		
		System.out.print("열 크기 : ");
		int col = sc.nextInt();
		
		if(row < 1 || row > 10 || col < 1 || col > 10) {
			
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				
			
		} else {
			
			int[][] arr = new int[row][col];
			
			for(int i = 0; i < row; i++) {
				
				for(int j = 0; j <col; j++) {
				
					arr[i][j] = (int)(Math.random() *26 );
													// 0 < = x < 26
		
					char result = (char)(arr[i][j] + 65);
				
					System.out.print(result + " ");
				}
					System.out.println();
				}
					break; // else문의 끝
				}
}
		/*	while(true) {// 무한반복
		
		System.out.print("행 크기 :");
		int input = sc.nextInt();
		
		System.out.print("열 크기 :");
		int input2 = sc.nextInt();
		
		if(1 <= input && input <= 10 && 1 <= input2 && input2 <= 10 ) {
			
		char[][] chArr = new char[input][input2];
			
			for(int i = 0; i < input; i++) { // 행 크기
				
				for(int j = 0; j < input2; j++) { // 열 크기 
					
					chArr[i][j] = (char)(Math.random()*26 + 65); // 0.0 <= x < 1
																 // 65 <= x < 92
					System.out.print(chArr[i][j] + " ");
			}
					System.out.println();
			}
					break;
			}
					System.out.println("반드시 1~10 사이의 정수를 입력해야 함");	
			
		
	}
	 */
}

	public void ex6() {
		
		// 행의 크기 입력받고 그 수만큼의 반복을 통해 열의 크기도 받아
		// 문자형 가변 배열을 선언 및 할당해라.
		// 각 인덱스에 'a' 부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		
		char[][] chArr = new char[input][];
		
		//열 크기 정하는 for문
		
		for(int i = 0; i < input; i++) { // i < chArr.lenght;
			
			System.out.print(i + "열의 크기 : ");
			int input2 = sc.nextInt();
			
			chArr[i] = new char[input2]; // 이렇게 생성을 해줘야 null 오류가 안남

			}
		
		// 출력용 for문
		
		char ch = 'a';
		
		for(int i = 0; i < chArr.length; i++) {
			
			for(int x =0; x <chArr[i].length; x++) {
				
				chArr[i][x] = ch++;
				
				System.out.print(chArr[i][x] + " ");	
			}
				System.out.println();
			}

}
	public void HomeWork() {

		int[][] arr = new int[4][4];
		     
			  int rowsum = arr.length-1; //3
		      int colsum = arr[0].length -1; // 3
		      for(int row=0; row<arr.length; row++) { // 0, 1, 2, 3
		         
		    	  for(int col=0; col<arr[row].length; col++) {// 0, 1, 2, 3
		    		 
		    		// 이렇게하면 3행 3열까지 출력임 3행 3열까지 랜덤 값이 다 들어감
		    		// 3행 3열이 아닐때만 난수 생성함
		    		  if(rowsum != row && colsum != col) {
		    		
		    		  arr[row][col] = (int)(Math.random()*10+1);
		           
		    		  
		            //    3      0   =   3  0  + 0  0 
		            //    3      1   =   3  1  + 0  1
		            //    3      2   =   3  2  + 0  2
		            
		            //    3      0   =   3  0  + 1  0
		            //    3      1   =   3  1  + 1  1
		            //    3      2   =   3  2  + 1  2
		            
		            //    3      0   =   3  0  + 2  0
		            //    3      1   =   3  1  + 2  1
		            //    3      2   =   3  2  + 2  2
		            
		            //여기까지 해야되는데
		            
		            //    3      0   =   3  0  + 3  0
		            //    3      1   =   3  1  + 3  1
		            //    3      2   =   3  2  + 3  2 까지 출력함
		    		// if 문 쓰면 이제 여길 하지 않음  그럼 밑의 식의 합이 잘 쌓임.
		    		  
		    		arr[rowsum][col] += arr[row][col];
		    		
		    		
		            arr[row][colsum] += arr[row][col];
		            
		            arr[rowsum][colsum] += arr[row][col]; // +=인데 =이라고 되어있음
		            
		         
		         }
		    		   System.out.printf("%3d" , arr[row][col] );  	
	}

		    	  System.out.println();
		      }
	// 0행 0열부터 2행 2열까지 1~10 난수 생성하고 마지막 행, 열에는 각 행, 열의 합을 구하려고 한다
	// 마지막 3행 3열에는 생성된 난수들만의 합을 구하려고 한다.
	// 코드가 틀린 이유와 출력값이 왜 저렇게 나오는지? 해결방법은?
	

}
	
	public void ex7() {
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피퐁표", "홍하하",};
		
		String[][] arr = new String[3][2];
		
		String[][] arr2 = new String[3][2];
	
		System.out.println("== 1분단 ==");
		
		int number = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = students[number];
				number++;
			System.out.print(arr[i][j] + " ");
			
			}
			System.out.println();
		}
		
		System.out.println("== 2분단 ==");
		
		int number2 = 6;
		
		for(int i = 0; i < arr2.length; i++) {
			
			for(int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = students[number];
				number++;
			System.out.print(arr2[i][j] + " ");
			
			}
			System.out.println();
		}
		
	}
	
	public void ex8() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피퐁표", "홍하하",};
		
		String[][] arr = new String[3][2];
		
		String[][] arr2 = new String[3][2];
	
		System.out.println("== 1분단 ==");
		
		int number = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = students[number];
				number++;
			System.out.print(arr[i][j] + " ");
			
			}
			System.out.println();
			
		}
		
		System.out.println("== 2분단 ==");
		
		int number2 = 6;
		
		for(int i = 0; i < arr2.length; i++) {
			
			for(int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = students[number];
				number++;
			System.out.print(arr2[i][j] + " ");
			
			}
			System.out.println();
		}
		
	System.out.println("==============================");
	
	
	System.out.print("검색할 학생 이름을 입력하세요 : ");
	String input = sc.next();
	
	for(int i = 0; i < arr.length; i++) {
		
		for(int j = 0; j < arr[i].length; j++) {
			
		if(input.equals(arr[i][j])) {
			
			if(j == 0) {
				System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.", input, i+1);
				break;
			
			}else if(j == 1) {
				System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.", input, i+1);
				break;
			
			}
		}
		}
		
	}

	for(int i = 0; i < arr2.length; i++) {
		
		for(int j = 0; j < arr2[i].length; j++) {
			
		if(input.equals(arr2[i][j])) {
			
			if(j == 0) {
				System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 왼쪽에 있습니다.", input, i+1);
				break;
			
			}else if(j == 1) {
				System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.", input, i+1);
				break;
			
			}
		}
		}
		
	}
	
	}

	public void ex9() {
		
		String[][] arr = new String[6][6];
	
		int num = 0;
		int num2 = 0;

		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 인덱스 입력 : ");
		int input = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		int input2 = sc.nextInt();
		
		for(int i = 0; i< arr.length; i++) {

			for(int x = 0; x < arr[i].length; x++) {
				
			if(i == 0 && x != 0) {
				arr[i][x] = num++ + " ";   
				
			}else if(x == 0 && i != 0) {
				arr[i][x] = num2++ + " ";
			
			}else if(i == input+1 && x == input2+1) {
				arr[i][x] = "X";
			}else {
				arr[i][x] ="  ";
			}
			System.out.print(arr[i][x]);
			}
			System.out.println();
			}
	}
	
	public void ex10() {
		
		String[][] arr = new String[6][6];
		
		int num = 0;
		int num2 = 0;

		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i< arr.length; i++) {

			for(int x = 0; x < arr[i].length; x++) {
				
			if(i == 0 && x != 0) {
				arr[i][x] = num++ + " ";   
				
			}else if(x == 0 && i != 0) {
				arr[i][x] = num2++ + " ";
			
			}else if(i == 0 && x == 0) {
				arr[i][x] = " ";
			}else {
				arr[i][x] ="  ";
			}
			}
		}
		
		while(true) {
			
			System.out.print("행 인덱스 입력 : ");
			int input = sc.nextInt();
			
			if(input == 99) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.print("열 인덱스 입력 : ");
			int input2 = sc.nextInt();
			
			arr[input+1][input2+1] = "X";
			for(int i = 0; i < arr.length; i++) {
				for (int x = 0; x < arr[i].length; x++) {
					System.out.print(arr[i][x]);
			}
			System.out.println();
				
			}
			
		}
		
	
}
	
	public void ex11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int input = sc.nextInt();
		
		String arr[][] = new String[input][input];
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[i].length; x++) { 
				arr[i][x] = " " +(int)(Math.random() * 25 + 1);
					//if(arr[i][x]) 
				System.out.printf("%3s", arr[i][x]);
			}
			System.out.println();
		}
		
		System.out.println("=================== 빙고게임 시작 ===================");
		while(true) {
		
		System.out.println("정수를 입력하세요 : ");
		String input2 = sc.nextLine();
		
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[i].length; x++) { 
				arr[i][x] = " " +(int)(Math.random() * 25 + 1);
					
				
				System.out.printf("%3s", arr[i][x]);
			}
			System.out.println();
		}
		
	}
}

	public void startBingo() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		// 1차원 배열로 빙고판에 입력될 값을 생성 + 중복 제거

		int[] tempArr = new int[num * num];
		// 빙고판의 크기는 가로 * 세로의 곱 만큼의 공간 필요
		
		// 중복 값 제거하면서 랜덤값 집어넣기
		for(int i = 0; i < tempArr.length; i++) {
			tempArr[i] = (int)(Math.random()*(num*num))+1;
			
			// 중복 제거
			for(int j = 0; j < i; j++) {
				if(tempArr[i] == tempArr[j]) {
					i--;
					break;
				}
				
			}
		}
		
		// 위에서 만들어진 중복제거한 1차원 배열을 2차원 배열에 넣기
		// String 배여로 변경해서 대입 진행 (★ 넣어야 해서)
		
		String[][] bingoBoard = new String[num][num];
		
		int index = 0; // 1차원 배열 인덱스 지정을 위한 변수
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				// 1차원 배열은 0번부터 num*num 까지 반복 진행
				
				bingoBoard[i][j] = tempArr[index]+ "";
					index++;
			
			}
		}

		// -------------------------------------------------
		
		// 랜덤 배치된 빙고판 최초 1회 출력

		for(int i = 0; i < bingoBoard.length; i++) {
			for(int j = 0; j < bingoBoard[0].length; j++) {
				
				System.out.printf("%4s",bingoBoard[i][j]);
				
			}
			
			System.out.println();
			
		}
		
		System.out.println("=============== 빙고게임 시작 ===============");
		
		while(true) {
			
			System.out.print("정수를 입력하시오 : ");
			String input = sc.nextLine(); // bingoBoard[i][j] = tempArr[index]+ ""; String형과의 비교를 위해
			
			boolean flag = true; // 검색된 값이 빙고판에 있는지 확인(잘못된 입력 확인)
			
			for(int i = 0; i < bingoBoard.length; i++) {
				for(int j = 0; j < bingoBoard[0].length; j++) {
					
					// 입력된 값과 일치되는 곳을 ★ 형태로 변환하기
					
					if(bingoBoard[i][j].equals(input)) {
						bingoBoard[i][j] = "★";
						flag = false;
					}
					
					System.out.printf("%4s", bingoBoard[i][j]);
					
				}
				System.out.println();
			}
			
			if(flag) { // 일치하는게 없다면 true 값이라 실행
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}
			
			// 빙고판의 크기에 따라
			// 빙고 기준이 되는 문자열 생성
			// ex 5*5 크기 빙고 -> 한 줄이 "★★★★★"면 빙고
			String bingoLine = "";
			for(int i = 0; i < num; i++) {
				bingoLine += "★";
				
			}
		
			// 빙고 검사
			int bingoCount = 0; // 빙고 수를 저장할 변수
			
			// 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
			// --> 저장된 문자열의 모양이 "★★★★★"인 경우 == 빙고
			// --> bingoCount++
			
			for(int i = 0; i < bingoBoard.length; i++) {
				String row = "";
				String col = ""; 
				// 매 반복시 마다 row, col을 빈 문자열로 초기화 해야한다.
				// --> 바깥쪽 for문이 반복될 때 마다 검사하는 행과 열이 이동하므로
				// 빙고 여부를 검사하기 위한 row, col을 빈 문자열로 초기화 해야한다.
				
				for(int j = 0; j < bingoBoard.length; j++) {
					
					row += bingoBoard[i][j]; // 현재 행의 문자를 모두 더한다.
					
					col += bingoBoard[j][i]; // i,j(행렬)반대로 해서 열의 몸든 문자 더하기
					
				}
			
				if(row.equals(bingoLine)) {
					bingoCount++; // 가로 빙고가 존재할 경우
				}
				if(col.equals(bingoLine)) {
					bingoCount++; // 새로 빙고가 존재할 경우
				}
				
			}
			
			// 대각선 빙고 여부
			// 대각선 : diagonal(다이애그널)
			
			// 대각선은 빙고판에 두 개만 존재
			// --> 대각선 문자를 더해서 저장할 변수 두 개 선언 및 빈 문자열로 초기화
			String dia1 = "";
			String dia2 = "";
			
			for(int i = 0; i < bingoBoard.length; i++) {
				dia1 += bingoBoard[i][i]; // 좌상 우하
				// 0 5 
				// 1 4
				// 2 3
				// 3 2
				// 4 1
				dia2 += bingoBoard[bingoBoard.length - 1 -i][i]; //우상 좌하
				
			}
			
			if(dia1.equals(bingoLine)) {
				bingoCount++;
			}
			
			if(dia2.equals(bingoLine)) {
				bingoCount++;
			}
			
			// 빙고 카운트 출력
			System.out.println("현재" + bingoCount + "빙고");
			
			if(bingoCount >= 3) { // 3빙고 이상
				System.out.println("********** BINGO!!! **********");
				break;
			}
			
			
			
			
		} // while문 종료
}
}