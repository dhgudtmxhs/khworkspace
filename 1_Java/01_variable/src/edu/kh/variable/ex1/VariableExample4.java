package edu.kh.variable.ex1;

public class VariableExample4 {

	public static void main(String[] args) {
		
		// main method(메소드) : 자바 어플리케이션(프로그램)을 실행하기 위해 반드시 필요한 메소드
		
		/* 강제 형변환
		 * - 기존 자료형을 원하는 자료형으로 강제 변환
		 * 
		 * 1) 값의 범위가 큰 자료형을 작은 자료형으로 변환할 때 사용
		 * 2) 출력되는 데이터의 표기법을 변화시키고 싶을때
		 * 
		 * 
		 * *강제 형변환 방법
		 * -자료형을 변환 시키고 싶은 값 도는 변수 앞에 (자료형)을 작성
		 * 
		 * ex) double temp = 3.14;
		 * 	 	int num = (int)temp;
		 * 
		 */
	
		double temp = 3.14;
		int num = (int)temp; //Type mismatch: cannot convert from double to int
		// (int)temp = double temp을 int 형으로 바꾼다.
		
		System.out.println("temp : " + temp);
		System.out.println("num : " + num);
		
		// 실수에서 정수형 변환 시 소수점 버림 처리한다. 데이터 손실이 발생한다.
		
		int iNum = 290;
		byte bNum = (byte)iNum; // 강제형변환
		
		System.out.println(iNum);
		System.out.println(bNum); // 290 >>> 34 앞의 비트가 다 날라감.
		
		System.out.println("int -> byte 강제 형변환");
		System.out.println("before : " + iNum);
		System.out.println("after : " + bNum);
		
		// 같은 정수형끼리의 변환시에도 강제형변환 할 시 값의 범위차이때문에 데이터 손실이 발생할 수 있다.
	
	
		// char -> int 강제 형변환
		
		char chtv = 'A'; //65
		int iNum2 = chtv;    // 자동 형변환 이용
		System.out.println(iNum2);
		
		System.out.println((int)chtv); // 강제형변환하기 
		
		// 자동형변환쓰면 댐 되는거면
		
		
		// int -> char 강제 형변환
	
		int iNum3 = 44033;
		System.out.println(iNum3 + "번째 문자 = " + iNum3);
		
		System.out.println(iNum3 + "번재 문자 = " + (char)iNum3); // 44033 -> 각
		
		
		// 소문자 'a' 보다 10칸 뒤에 있는 문자는?
		
		char chtv2 = 'a';
		
		int im = chtv2 + 10;
		
		System.out.println(chtv2);
		System.out.println(chtv2+10);
		System.out.println(im);
		
		System.out.println((char)im);
		
		System.out.println((char)((int)chtv2+10));
		
		System.out.println((char)(chtv2+10));
		
		
		
		
		
		
		
		
		
	}
	
}
