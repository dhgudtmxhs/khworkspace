package edu.kh.variable.ex2;

	import java.util.Scanner;
	//Scanner : 프로그램 실행 중 키보드 입력을 받을 수 있게 하는 역할
	//Scanner 생성
	// -> 프로그램 안에 스캐너라는 기계를 만드는 것
	// java.util.Scanner를 수입해오겠다.
	// import : 다른 패키지에 존재하는 클래스를 얻어오는 구문
	
	public class ExampleScanner1 {

	
			public static void main(String[] args) {
		
				Scanner sc = new Scanner(System.in); 
				// import java.util.Scanner같은 설계도(class)를 사용해야 만들어짐
				
				System.out.print("정수 1 입력 : ");
				int input1 = sc.nextInt(); // 입력받은 정수를 input1에 대입하겠다.
				// nextInt() : 다음 입력된 정수를 읽어온다. (키보드로 입력된 정수를 읽어온다 콘솔창에서 말하는듯)
				
				System.out.print("정수 2 입력 : ");
				int input2 = sc.nextInt(); // 입력받은 정수를 input2에 대입하겠다. 뒤에 이걸 넣어야 돌아간다
				
				System.out.printf("%d + %d = %d%n ", input1,input2,input1+input2);
				
				
			
				}
		
	
}
