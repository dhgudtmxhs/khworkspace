package practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

	public void ex1() {
		
		// 점심메뉴 랜덤 선택
		
		String str[] = new String[] {"불닭", "우동", "김밥", "수제비", "고순조"};
		
		//int i = (int)Math.random()*5+1;  // 0.0 <= x < 1
		// 로 하면 하나의 값밖에 저장 안됨 우동만 계속나옴
		
		System.out.print("오늘의 점심은 : " + str[(int)(Math.random()* 5)]);
		
	}
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
			
			System.out.print("인원 수 입력 : ");
			int input = sc.nextInt();
			
			double height[] = new double[input];
			
			System.out.println(Arrays.toString(height));
			
			for(int i = 0; i < height.length; i++) {
				
				System.out.print(i + 1 +"번 키 : ");
				height[i] = sc.nextDouble();
			}
			System.out.println(Arrays.toString(height));
			
			System.out.print("입력 받은 키 : ");
			
			double sum = 0;
			
			for(int i = 0; i < height.length; i++) {
				
				System.out.print(height[i] + " ");
				sum += height[i];
			}
			System.out.println();
			System.out.printf("평균 : %.2f %n" ,( sum / input ) );
			System.out.printf("합계 : %.2f %n" ,  sum);
		
			double max = height[0];
			double min = height[0];
			
			for(int i = 0; i < height.length; i++) {
				
				if(height[i] > max) {
					max = height[i];
				}else if(height[i] < min) {
					min = height[i];
				}
			
			
			}
			
			System.out.println("최대값 = " + max);
			System.out.println("최소값 = " + min);
			
	}
	
	public void ex3() {
		
		int[][] arr = {{1,2,3},{4,5,6}}; // 2행 3열의 이차원 배열 생성 및 초기화
										 // 1 2 3
										 // 4 5 6
		
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length; j++) { // 행의
				System.out.print(arr[i][j]);
				
			}
			
		}
		
	}
	
	public void ex4() {
		
		     /*   // 4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후 아래의 내용처럼 처리하세요.
		        //      0열            1열               2열           3열
		        // 0행   값             값                값            0행 값들의 합
		        // 1행   값             값                값            1행 값들의 합
		        // 2행   값             값                값            2행 값들의 합
		        // 3행   0열 값들의 합 / 1열 값들의 합  / 2열 값들의 합 /      총합

		        int[][] arr = new int[4][4];
		        Random random = new Random();


		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                arr[i][j] = random.nextInt(10) + 1; // 랜덤 값 배열마다 쏙쏙 다 넣어주기
		            }
		        }

		        int[] rowSum = new int[3];         int[] colSum = new int[3];         int totalSum = 0;

		        for (int i = 0; i < 3; i++) {
		            int sum = 0;
		            for (int j = 0; j < 3; j++) {
		                sum += arr[i][j];
		            }
		            rowSum[i] = sum;
		            totalSum += sum;
		        }


		        for (int j = 0; j < 3; j++) {
		            int sum = 0;
		            for (int i = 0; i < 3; i++) {
		                sum += arr[i][j];
		            }
		            colSum[j] = sum;
		        }

		        for (int i = 0; i < 4; i++) {
		            for (int j = 0; j < 4; j++) {
		                if(i < 3 && j < 3) {
		                    System.out.print(arr[i][j] + "\t");
		                } else if(i == 3 && j < 3) {
		                    System.out.print(colSum[j] + "\t");
		                } else if(i < 3 && j == 3) {
		                    System.out.print(rowSum[i] + "\t");
		                } else {
		                    System.out.print(totalSum + "\t");
		                }
		            }
		            System.out.println();
		        }

		    }

		
	*/
		
	}
	
}

