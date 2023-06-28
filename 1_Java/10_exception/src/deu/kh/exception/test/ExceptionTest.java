package deu.kh.exception.test;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	
	
	while(true) {
		System.out.print("정수 입력(0 입력시 종료) : ");
		int input = sc.nextInt();
		
		int a = (int)99.9; // 자료형이 맞지 않아 연산을 못함 -> "컴파일 에러"(코드가 틀렸다.)
					  // 코드 변경으로 수정이 가능하다.
					  // 1) 변수 자료형을 double로 바꿔준다.
					  // 2) 99.9 리터럴을 (int)99.9 로 강제 형변환해준다.
					  // 3) 99.9 를 그냥 99나 100으로 변경해버린다.
		
		if(input == 0) {
			break;
		}
		
		
		
	}
	
	// 런타임 에러 예제
	// 런타임 에러 : 프로그램 수행 중 발생하는 에러
	//            주로 if문으로 처리가 가능하다.
	
	int[] arr = new int[3]; // 인덱스 2까지 있다. [0~2]
	
	arr[0] = 10;
	arr[1] = 20;
	arr[2] = 30;
	if(arr.length >= 3) {
		System.out.println("배열의 범위를 초과했습니다.");
	}else {
		arr[3] = 40;
	}
	 // Index 3 out of bounds for length 3

	// java.lang.ArrayIndexOutOfBoundsException : 배열 범위 초과 예외 발생
	
}
	
}
