package edu.kh.control;

import java.util.Scanner;

public class SwitchExample {

	public void ex4() {
		
		//정수 2개와 연산자(+, -, *, /, %) 1개를 입력받아서 결과를 출력한다.
		
		//ex
		//정수 1 입력 : 5
		//연산자 입력 : *
		//정수 2 입력 : 2
		
		//계산 결과 : 5 * 2 = 10
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력: ");
		int num1 = sc.nextInt();

		System.out.print("연산자 입력 : ");
		
		// sc.nextChar(); // Scanner는 문자 하나(char)를 입력 받는 기능이 없다. 그냥 char가 없다.
		
		String op = sc.next(); // 다음에 입력되는 한 단어(String) 읽어오기
		
		// (char)'a' != (String)"a"
		
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
		
		// case에 작성되는 값은 switch 식의 결과값 자료형의 리터럴 표기법이다.
		
		switch(op) {
		// op 를 case +, -, *, /, % 로 구분하는 것. String 값이기때문에 case +, case -가아닌 case "+", case "-"로 입력한다.
		
		case "+" : System.out.printf("%d + %d = %d%n",num1, num2, num1 + num2 ); break;
		
		case "-" : System.out.printf("%d - %d = %d%n",num1, num2, num1 - num2 ); break;
		
		case "*" : System.out.printf("%d * %d = %d%n",num1, num2, num1 * num2 ); break;
		
		case "/" : 
				if(num2 == 0) { // 오류가 발생되는 경우
					System.out.println("0으로 나눌 수 없습니다."); // 5 나누기 0 은 수학에선 무제한이고 자바에선 오류가 난다.
		}else {
			System.out.printf("%d / %d = %d%n",num1, num2, num1 / num2 ); 
		} break; // if 문까지 포괄하는 break; // if에 break 안하면 else 건너 뛰고 case "%"로 넘어와서 에러가 나는거임.
										  // if문에서 if가 true면 else 수행 안하니까.
		
		case "%" : System.out.printf("%d %% %d = %d%n",num1, num2, num1 % num2 ); break; // %는 printf에서 %%로 쓴다
		
		default : System.out.println("존재하지 않는 연산자 입니다.");	break;
		
		}
		
	}
	
	
}
