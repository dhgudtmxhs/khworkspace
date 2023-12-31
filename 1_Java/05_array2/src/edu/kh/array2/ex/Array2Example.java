package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {

	public void ex1() {
		
		/*
		 * 2차원 배열
		 * 
		 * 자료형이 같은 1차원 배열을 묶음으로 다루는 것
		 * -> 행, 열 개념 추가
		 * 
		 */
		
		// 2차원 배열 선언
		int[][] arr;
		// int 2차원 배열을 참조하는 참조 변수 선언
		// (참조형 == 참조 변수 == 레퍼런스 변수 == 레퍼런스)
		
		// 2차원 배열 할당
		// new 자료형[행크기][열크기]
		
		arr = new int[2][3];
		// heap 영역에 int 2차원 배열 2행 3열 공간을 할당한다.
		
		// 2차원 배열 초기화
		
		//1) 행, 열 인덱스를 이용해서 직접 초기화
	/*	arr[0][0] = 10; //1행 1열
		arr[0][1] = 20; //1행 2열
		arr[0][2] = 30; //1행 3열
		
		arr[1][0] = 40; //2행 1열
		arr[1][1] = 50; //2행 2열
		arr[1][2] = 60; //2행 3열
	*/	
		int num = 10; // 배열 요소 초기화에 사용할 변수
		
		System.out.println(arr.length); // arr이 행을 참조하고 있어서 2로 나옴
		System.out.println(arr[0].length); // 1행이 참조하고 있는 열의 길이
		System.out.println(arr[1].length); // 2행이 참조하고 있는 열의 길이
		
		for(int row = 0; row < arr.length; row++) { // arr이 참조하고 있는 게 행이니까 의 행의 길이까지, 2까지. 
			
			for(int col = 0; col < arr[row].length; col++) {// arr[i]는 열을 참조하고 있으니까 열의 길이까지, 3까지.
				
					arr[row][col] = num;
					num += 10;
					
					// 0 0 = 10
					// 0 1 = 20
					// 0 2 = 30
					// 1 0 = 40
					// 1 1 = 50
					// 1 2 = 60
				
			}
		}

		
		//Arrays.toString(배열명); 참조하고 있는 1차원 배열값을 문자로 반환
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr)); // arr이 참조하고 있는 arr[0]과 arr[1]의 주소값 출력
												  // 주소값 0x5000은 대입값임.
		
		//Arrays.deepToString(배열명)
		// - 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서
		// 모든 값을 문자열로 반환한다. 
		
		System.out.println(Arrays.deepToString(arr)); // 값을 보는 메서드
	}
	
	public void ex2() {
		
		// 2차원 배열 선언과 동시에 초기화
		
		// 3행 3열짜리 정수형 2차원 배열 선언과 동시에
		// 1~9까지 초기화
		
		int[][] arr = { {1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9} };
		
		//행 별로 합 출력
		
		
		
		for(int row = 0; row < arr.length; row++) {
			
				int sum = 0;  // 안 쓰면 행이 바뀌어도 전 행의 값이 남아있음
			
			for(int col = 0; col < arr[row].length; col++) {
				
				sum += arr[row][col]; // 현재 행의 모든 열 값을 누적시킨다.
				
			}
				System.out.printf("%d 행의 합 : %d%n", row, sum);
			}
				System.out.println("-----------------------------------");
		
				// 열 별로 합 출력
				// 열 별로 지정 후 각 행의 값을 누적
				// 완전한 사각형의 형태를 지닌 4차원 배열은
				// 모든 열의 길이가 같다.
		
				for(int col = 0; col < arr[0].length; col++) { // 열 반복
						int sum = 0;
															// arr[0],[1],[2].length 아무거나 넣음
					for(int row = 0; row < arr.length; row++) {
						sum += arr[row][col];
						
						// 0  0
						// 1  0
						// 2  0
						// 0  1
						// 1  1
						// 2  1
						// 0  2
						// 1  2
						// 2  2
						
					}
					System.out.printf("%d 열의 합 : %d%n", col, sum);
					}
	
					System.out.println("-----------------------------------");
					
					//전체 합 출력
					
					int sum = 0;
					
					for(int row = 0; row < arr.length; row++) {
						
						for(int col = 0; col < arr[row].length; col++) {
							
							sum += arr[row][col];
					}
					}
					
					System.out.println("배열 전체의 합 : " + sum);
					
					/*for(int col = 0; col < arr[2].length; col++) {
							int sum = 0;
						for(int row = 0; row < arr.length; row++) {
							sum += arr[row][col];
						}
					 *	sysout(sum);
					 */
						
					}
	
	public void ex3() {
		
		// 가변 배열
		// - 2차원 배열 생성시 마지막 배열 차수(열)을 지정하지 않고
		//   나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열
		
		char[][] arr = new char[4][]; // char 2차원 배열 생성 시 행 부분만 생성한다.
		
				arr[0] = new char[3]; // 0행에 3열짜리 1차원 배열을 생성하여 주소값을 저장하겠다. ㅁㅁㅁ
				arr[1] = new char[4]; // 1행에 4열짜리 1차원 배열을 생성하여 주소값을 저장하겠다. ㅁㅁㅁㅁ
				arr[2] = new char[5]; // 2행에 5열짜리 1차원 배열을 생성하여 주소값을 저장하겠다. ㅁㅁㅁㅁㅁ
				arr[3] = new char[2]; // 3행에 2열짜리 1차원 배열을 생성하여 주소값을 저장하겠다. ㅁㅁ
		
									
		// 각 배열 요소에 'a' 부터 차례대로 대입한다.
		
		char ch = 'a';
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j <arr[i].length; j++) {
				
				arr[i][j] = ch++;
				// arr[i][j] = ch;
				// ch++;
				
			}
			System.out.println(arr[i]);
		}
			System.out.println(Arrays.deepToString(arr));
	}
	
}