package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample { // 예제 코드 작성용 클래스

	
	// ex1() 메소드
	// -> OpExample이 가지고 있는 기능 중 ex1()이라는 기능
	
	public void ex1() {
		
		
		System.out.println("OpExample 클래스에 ex1 기능 수행");
		System.out.println("클래스 분리 테스트");
		System.out.println("println 자동완성 하기");
		
		
		
		
	}
	
	
	//ex2() 메소드(기능)
	
	public void ex2(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int i = sc.nextInt(); // 다음 입력되는 정수를 읽어옴
		
		System.out.print("정수 입력 2 : ");
		int j = sc.nextInt();
		
		System.out.printf("%d / %d = %d%n", i, j, i/j);
		System.out.printf("%d %% %d = %d%n", i, j, i%j); // printf ""안의 나누기 %는 %%로 써야 오류 안남.
		
	
	
	}
	
	public void ex3() {
		
		//증감(증가,감소) 연산자 : ++,--
		//-> 피연산자(값)을 1 증가 또는 감소시키는 연산자
		int j = 10;
		int jj = 10;
		j++;
		jj--;
		System.out.println("j = " + j);
		System.out.println("jj = " + jj);
		
		// 전위 연산 : ++3 --2 연산자가 앞에 위치한다.
		// 다른 연산자보다 먼저 증가 혹은 감소한다.
		
		int temp1 =5;
		System.out.println(++temp1 + 5);
						//++5 + 5
						//6 + 5 = 11
		System.out.println(temp1);
		// 후위 연산 : 10++ 6-- 연산자가 뒤에 위치한다.
		// 다른 연산자보다 나중에 증가 혹은 감소한다.
		int temp2 = 3;
		System.out.println(temp2-- +2);
						//3-- + 2 = 5 (값은 그대로 3+2 temp의 변화 x)
						//temp2 = 2(1감소)
		System.out.println("temp2 : " + temp2);
	
		int temp3 = 4;
		System.out.println(temp3++ +2); // 다른 연산자보다 나중에 증가해서 그대로 4+2
		// 이제 temp3이 5가 됨
		System.out.println(temp3); // temp3 = 5
	
		int temp4 = 7;
		System.out.println(--temp4 - 2); // 전위라 temp4가 바로 6이 되고 6-2 = 4
		System.out.println(temp4++); // 후위라 그대로 6
		System.out.println(temp4); // 다시출력하면 7이 된 모습
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		//바뀌는 순서
		// (a)3++ + --5(b)
		// c = (a)3++ + 4(b) // b만 계산되어짐
		// c = 7
		// 이 다음으로 3++가 계산되어 a=4가됨
		
		// a,b,c의 최종값은?
		System.out.printf("%d / %d / %d%n", a, b, c);
		}	

	public void ex4() {
		
		
		// 비교연산자 : >, <, >=, <=, ==, !=
		// - 비교 연산자의 결과는 항상 논리값(true / false)
		// - 등호(=)가 포함된 연산자에서 등호는 항상 오른쪽이다.
		
		//같다 기호는 =,== 중 무엇?
		// -> == 가 같다임.
		// = 는 대입연산자로 사용함. int i = 10; 에서 =
		// 구분을 위해 ==가 같다로 쓰임.
		
		int a = 10;
		int b = 20;
		
		System.out.println(a > b); // false
		System.out.println(a < b); // true
		System.out.println(a != b); // true
		System.out.println(a == b); // false
		System.out.println((a == b) == false); // true (false = false)
		
		int c = 4;
		int d = 5;
		System.out.println(c < d);
		System.out.println(c + 1 <= d);
		System.out.println((++c !=d) == (--c !=d)); // false == true => false
						 //(++4 != 5) -> 같으니까 false
						 //((--5 != 5) -> 다르니까 true
		
		System.out.println("-----------------------------------------------------");
		int temp = 723;
		
		System.out.println("temp는 짝수인가?" + (temp %2 ==0));
		System.out.println("temp는 짝수인가?" + (temp %2 !=1));
		
		System.out.println("temp는 홀수인가?" + (temp %2 ==1));
		System.out.println("temp는 홀수인가?" + (temp %2 !=0));
		
		System.out.println("temp는 3의 배수인가?" +(temp %3 ==0));
		System.out.println("temp는 4의 배수인가?" +(temp %3 ==4));
		System.out.println("temp는 5의 배수인가?" +(temp %4 ==5));
	
		
	
		}
	
	public void ex5() {
		// & = 엠퍼센트 && = AND
		// | = 버티컬바 || = OR
		
		//논리 연산자 : &&(AND), ||(OR)
		
		//&& AND연산자 : 둘다 true면 true, 나머진 다 false
		// ~와, 그리고, ~이고, ~면서, ~이면서, ~부터 ~까지, ~사이
		//ex)사과와 바나나, 사과 그리고 바나나, 사과 이면서 바나나
		int a = 100;
		// a는 100 이상이면서 짝수인가?
		System.out.println(a>=100);// a는 100 이상인가?
		System.out.println(a%2==0);// a는 짝수인가?
		System.out.println(a>=100 && a%2==0);// a는 100이상이면서 짝수인가?
		
		int b = 5;
		System.out.println(1<=b);
		System.out.println(b<=10);
		System.out.println(1<=b && b <=10);
		// b는 1부터 10까지 숫자 범위에 포함되어있는가?
		// b는 1부터 10사이의 숫자인가?		
	    // b는 1보다 크거나 같으면서 10보다 작거나 같은가?
		// 다 같은말
		
		System.out.println("---------------------------");
		
		//|| OR연산자 : 한 쪽만 true면 true 앞이 true 면 뒤를 볼 필요 없이 true
		// false + false만 false이고 나머진 true. AND의 반대
				int xx = 3000;
				System.out.println(xx<=4500); // xx는 4500보다 작은가? true
				System.out.println(xx%3!=0); // xx는 3의 배수가 아닌가? false
				System.out.println(xx <=4500 || xx%3 !=0); // true + false = true
														   //하나만 true여도 true가 됨
	
				int c = 10;
				System.out.println(10<c || c%2==0);// c는 10을 초과했거나 짝수인가? false + true = true
												   // 만약 앞이 true면 뒤를 볼 필요 없음.
	
	
	
		}
	
	public void ex6() {
		
		//논리 부정 연산자 : !
		//->논리 값을 반대로 바꾸는 연산자
		
		boolean bool1 = true;
		boolean bool2 = !bool1;
		System.out.println("bool1 : " + bool1); //true
		System.out.println("bool2 : " + bool2); //false
		
		System.out.println("-----------------------------");
	
		Scanner sc = new Scanner(System.in);
	
		// 정수를 하나 입력 받았을 때
		// 1) 해당 정수가 1부터 100 사이 값이 맞는지 확인
		// 2) 1부터 100 사이 값이 아닌지 확인
	
		System.out.print("정수를 입력하세요 : "); // 콘솔창
		int input = sc.nextInt(); // 내가 입력한 것 컴퓨터로 전송
		// 1 <= input <= 100
		boolean result1 = (1<= input && input <= 100); 
		// 내가 입력한 정수를 boolean의 범위를 정해 true인지 false인지 판단
	
		System.out.printf("%d은/는 1이상, 100이하의 정수인가? : %b%n",input, result1);
		// printf로 출력.
		
		//1이상이면서 100이하 <-> 1미만 또는 100 초과
		boolean result2 = input < 1 || input > 100;
		boolean result3 = (1<= input && input <= 100); 
		System.out.printf("%d은/는 1 미만, 100초과 정수인가? : %b / %b%n", input, result2, result3);
		
	
	}
	
	public void ex7() {
		
		// 복합 대입 연산자 : += -= *= /= %=
		// -> 피연산자가 자신과 연산 후 결과를 다시 자신에게 대입
		
		int a = 10;
		// a를 1증가시키기
		//a++; ++a; a = a + 1; a += 1
		a = a+1;
		System.out.println("a를 1 증가시킨다 :" + a);
		
		// a를 4 증가시킨다
		a += 4; // a += 4 는 a = a+4 와 같음
		System.out.println("a를 4 증가시킨다 :" + a);
		
		// a를 10 감소시킨다
		a -= 10;
		System.out.println("a를 10 감소시킨다 :" + a);
		
		//a를 3배 증가시킨다
		a = a * 3;
		System.out.println("a를 3배 증가시킨다 :" + a);
		
		//a를 6으로 나눴을 때 몫
		a /= 6;
		System.out.println("a를 6으로 나눴을 때 몫 : " + a);
		
		//a를 2로 나눴을 때 나머지
		a %= 2;
		System.out.println("a를 2로 나눴을 때 나머지 : " + a);
		
	}
	
	public void ex8() {
		
		//삼항 연산자 : 조건식 ? 식1 : 식2
		
		// - 조건식의 결과가 true면 식1 를 수행
		// - 조건식의 결과가 false면 식2 를 수행
		
		// 조건식 : 연산 결과가 true / false 인 식
		//            (비교, 논리, 논리 부정 연산자)
		
		
		int num = 30;	
		
		// num이 30보다 크면 : "num은 30보다 큰 수이다." 
		// num이 30보다 크지 않으면 : "num은 30 이하의 수 이다."
		
		String str1 =  "num은 30보다 큰 수 이다.";	
		String str2 = "num은 30 이하의 수 이다.";
		
		String result = num > 30 ? str1 : str2; // int result 아님
					//    조건식  ?  식1  :  식2	
					//             true : false
					// num 30 초과 => str1
					// num 30 초과못하면 => str2
					// result 변수에 저장
		System.out.println(result);
		// 조건식이 false임 - 식 2로 감 - 식 2에 저장된 str2 출력
		
		System.out.println("===================================");
		
		// 입력 받은 정수가 음수인지 양수인지 구분
		// 단, 0은 양수로 처리
		
		//ex 
		//정수입력 : 4
		//양수입니다.
		
		//정수 입력 : -5
		//음수입니다.
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int num2 = sc.nextInt();
		
		//String str3 = "양수입니다.";
		//String str4 = "음수입니다.";
		
		//String result2 = 0 <= num2 ? str3 : str4;
		String result2 = 0 <= num2 ? "양수" : "음수";
		System.out.println(result2 + "입니다.");
		
		
		
		
	}


}
