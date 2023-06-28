package edu.kh.variable.ex2;

public class PrintExample {

	public static void main(String[] args) {
		
	
		//System.out.print() : 단순 출력 (출력 후 줄바꿈 X)
		//System.out.println() : 한 줄 출력 (출력 후 줄바꿈 수행)
		
		System.out.println("테스트1");
		System.out.println("테스트2");
		
		System.out.print("테스트3");
		System.out.println(); // 내용없는 println => 줄바꿈해줌
		System.out.print("테스트4");
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		// 10 + 5 = 15
		System.out.println("iNum1 + iNum2 = " + (iNum1+iNum2));
		System.out.println(iNum1 + "+" + iNum2 + "=" + (iNum1 + iNum2));
		
		//System.out.printf() 출력될 문자열 형식을 패턴으로 지정하는 출력구문
		//System.out.printf("패턴", 패턴에 들어갈 값);
		
		System.out.printf("%d + %d = %d%n", iNum1, iNum2, iNum1+iNum2);
		System.out.printf("%5d%n", iNum1);
		System.out.printf("%-5d%n", iNum1);
		
		//10 + 10 * 5 / 2 = 35
		System.out.println(iNum1 + "+"+ iNum1 + "*" +iNum2 + "/" + 2 +"=" + (iNum1 + iNum1 * iNum2 / 2));
		System.out.println(iNum1 + "+"+ iNum1 + "*" +iNum2 + "/2=" + (iNum1 + iNum1 * iNum2 / 2));
		
		System.out.printf("%d + %d * %d / %d = %d%n", iNum1, iNum1, iNum2, 2, iNum1+iNum1*iNum2/2);
		System.out.printf("%d + %d * %d / 2 = %d%n", iNum1, iNum1, iNum2, iNum1+iNum1*iNum2/2);
	
		//패턴 연습
		int iNum3 = 3;
		System.out.printf("%d%n", iNum3);
		System.out.printf("%7d%n", iNum3); // 7칸 공간 확보 후 오른쪽 정렬
		System.out.printf("%-7d%n", iNum3); // 7칸 공간 확보 후 왼쪽 정렬
		
		
		//소수점 자리 제어
		System.out.printf("%f%n", 10 / 4.0);
		System.out.printf("%.2f%n", 10 / 4.0);
		System.out.printf("%.0f%n", 10 / 4.0); // %.XF는 반올림 처리해줌
		
		
		//문자, 문자열, boolean
		
		boolean isTrue = false;
		char ch = '얍';
		String str = "배고파요"; // String은 참조형이다.(기본자료형 8가지를 뺀 나머지)
		
		// '' : char의 리터럴(값) 표기법
		// "" : String의 리터럴(값) 표기법
		
		System.out.printf("%b / %c / %s%n", isTrue, ch, str); // ch str 바꾸면 창에는 오류 안뜨는데 출력시 오류뜸
		
		
		// escape 문자 : 일반문자가 아닌 특수문자 표현
		System.out.println("\\"); // "\ = 백슬래시 출력 방법 
		System.out.println("a\tbcd"); // \t = 탭키 출력 방법
		System.out.println(" \" "); // \" 쌍따옴표 출력 방법
		System.out.println(" \' "); // \' 홑따옴표 출력 방법
		System.out.println("\u0041"); // \유(영어오류남) 유니코드(16진수)번호로 출력
		
		System.out.printf("%d \t\"%d\" ", iNum3, iNum2);
	
	
	
	
		}
	
	
}
