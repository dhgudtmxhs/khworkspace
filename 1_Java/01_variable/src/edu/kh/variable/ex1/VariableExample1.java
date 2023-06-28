package edu.kh.variable.ex1;

public class VariableExample1 {

	public static void main(String[] args) {
	
		
		//생성문.java 파일과 class 오른쪽에 작성된 이름은 같아야 한다.
		
		System.out.println(2 * 3.141592653589793 * 10);
		
		System.out.println(3.141592653589793 * 10 * 10);
		
		System.out.println(3.141592653589793 * 10 * 10 * 20);
		
		System.out.println(4 * 3.141592653589793 * 10 * 10);
			
		
		/* 변수(Variable)
		 * -메모리(Ram)에 값을 기록하는 공간
		 * -공간에 기록되는 값(Data)은 변할 수 있어서 변수라고 한다.
		 * 
		 * 변수는 저장되는 값의 형태, 크기에 따라 여러 종류로 나뉜다.
		 *
		 * 변수 사용의 장점
		 * 1. 가독성 증가
		 * 2. 재사용성 증가 (한번 만든 변수를 계속 사용한다.)
		 * 3. 코드 길이의 감소
		 * 4. 유지보수성 증가 (코드수정이 간단해진다.)
		 *
		 */
		
		// 변수 사용하기
		
		double pi = 3.141592653589793; // 원주율
		int r = 10; //반지름(radius)
		int h = 20; //높이(height)
		
		
		System.out.println("------------------------------------");
		
		System.out.println(2 * pi * r); // 원의 둘레
		System.out.println(pi * r * r);	// 원의 넓이
		System.out.println(pi * r * r * h);	// 원기둥의 부피
		System.out.println(4 * pi * r * r);	// 구의 겉넓이
		
		int i = 10;
		
		int j;
		j = 200;
		
		final int Num = 100;
	
		final int Aaa;
		Aaa = 250;
		
		String str = "기차" + 123 + 45 + "출발"; // 다른자료형 + "문자열" = 문자열
		
		int a = 12;
		double d = 3.3;
		double result = a + d;
		System.out.println(result);
		
	
		
		// 자동 형변환 = 작은 자료형을 큰 자료형으로 변환할때는 따료 표기할 필요 x 알아서 됨
		// 강제 형변환 = 큰 자료형을 작은 자료형으로 변환할 때 사용 강제형변환시 데이터손실발생가능 감수해야함
		
		}
}
