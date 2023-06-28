package edu.kh.variable.ex1;

public class VariableExample2 {

	public static void main(String[] args) {
					
		/* 자바 기본 자료형 8가지
		 * 
		 * 논리형 : boolean(1byte)
		 * 
		 * 정수형 : byte(1byte)
		 * 		: short(2byte)
		 * 		: int(4byte)
		 * 		: long(8byte)
		 * 
		 * 실수형 : float(4byte)
		 * 		: double(8byte) 
		 * 
		 * 문자형 : char(2byte, 유니코드)
		 * 
		 */
		
		 // 변수 선언 : /메모리에 값을 저장한 공간(변수)/ 을 할당 하는 것
		
		//카멜(낙타)표기법 : 연결되는 두 단어 중 후속단어의 첫문자를 대문자로 표기한다.
		boolean booleanData; 
		// 메모리에 논리값(true or false)을 저장할 공간을 1byte의 크기로 할당하고
		// 할당된 공간을 booleanData라고 부르겠다.
		booleanData = true;
		// booleanData 변수에 true 값을 대입한다. 집어넣는다.
		System.out.println("booleanData : " + booleanData);
		byte byteNumber;
		// 메모리에 정수값을 저장할 공간은 1byte의 크기로 할당하고
		// 할당된 공간을 byteNumber라고 부르겠다.
		byteNumber = 3;
		System.out.println("byteNumber : " + byteNumber);
		short shortNumber;
		// 메모리에 정수값을 저장할 공간을 2byte의 크기로 할당하고
		// 할당된 공간을 shortNumber라고 부르겠다.
		shortNumber = 5;
		
		int intNumber;
		// 메모리에 정수값을 저장할 공간을 4byte의 크기로 할당하고
		// 할당된 공간을 intNumber라고 부르겠다.
		intNumber = 32;
		
		long longNumber;
		longNumber = 54043122333L;
		
		float floatNumber;
		// 메모리에 실수값을 저장할 공간을 4byte의 크기로 할당하고
		floatNumber = 3.54f;
		
		double doubleNumber;
		// 메모리에 실수값을 저장할 공간을 8byte의 크기로 할당하고
		doubleNumber = 34.252;
		
		char ch;
		// 메모리에 문자값을 저장할 공간을 1byte의 크기로 할당하고
		ch = 'A';
		
		//변수값 대입
	
		//////////////선언과 동시에 초기화////////////////
		
		short shortMan = 350; // 변수값 선언과 동시에 초기화
		// 처음 변수에 값을 대입하는것 = 초기화 라고 함 
		System.out.println(shortMan);
		System.out.println("shortMan : " + shortMan);
		
		int is = 50;
		System.out.println(is);
		System.out.println("is : " + is);
		
		short shortShort = 32767; // 변수 선언 및 초기화
		//  자료형     변수명      리터럴
		
		// 리터럴 : 변수에 대입되거나 작성 되어지는 값 자체
		// 자료형에 따라 리터럴 표기법이 다름
		
		// 정수 자료형 기본형 = int
		int intInt = 214783647; // 변수 선언 및 초기화
		
		long longTime = 10000000000L;
		//The literal 10000000000 of type int is out of range 
		// 정수값이 int의 값을 넘어섰으니 long 인걸 표시해라  리터럴 뒤에 l이나 L로.
	
		float floatFe = 1.2345f;
		// Type mismatch: cannot convert from double to float
		// 실수는 double이 기본형이라 float 쓸때는 리터럴 뒤에 f나 F를 붙여야한다. 
		double doubleD = 3.141592;
	
		//short 와 byte는 옛날 코드의 잔재임 볼 일 없음.
		
		char chch = 'B'; // 문자형 리터럴 표기법	
						// ''는 문자 '하나' 를 의미한다. a,b,c,d 이런거
		
		System.out.println("chch : " + chch);
	
		char chch2 = 66;
		System.out.println("chch2 :" + chch2); // B가 유니코드로 66
		// char 자료형에 숫자가 대입될 수 있는 이유
		// - 컴퓨터에는 문자표가 존재함.
		// 숫자에 따라 지정된 문자모양이 매핑되어있음
		// 'B' 문자 그대로가 대입이 되면 변수에 숫자 66으로 변환되어 저장됨
		// 반대로 생각하면 변수에 애초에 66이라는 숫자를 저장하는 것이 가능하다
		// 어처피 숫자로 변환되어 저장되니까 콘솔창에 B라고 떠도 컴에는 66으로 저장됨 -?
	
	
		//변수 명명 규칙
	
		// 1. 대소문자 구분, 길이 제한 x
		int abcdefghijklmnopqrstuvwxyz;
		int abcdefghijklmnopqrstuvwxyZ; // 대소문자 구분
		
		// 2. 예약어 사용 x
		//double double;
	
		// 3. 숫자 시작 x
		//char 1abc;
		char abc1;
		
		// 4. 특수문자는 $와 _만 사용가능 (하지만 쓰지 않는다.)
		int $intNumber; // 문제는 없지만 걍 안씀
		int int_number; // 언더바 대신 카멜표기법
						// 나중에 DB에서 사용
		
		// 5. 카멜 표기법
		// -> 변수명 작성시 여러 단어를 이어서 작성하는 경우
		// 띄어쓰지 않고 후속 단어 첫 글자를 대문자로 작성한다.
		// 첫 시작 글자는 소문자로 하는 것이 관례이다. 대문자로 해도 오류는 안남.
		
		char helloWorldAppleBananaTomato;
		
		// 6. 변수명은 언어를 가리지 않는다. 하지만 쓰지 않는다.
		
		int 정수1번;
		
		double 실수2번 = 3.14; // 이런거
		
		System.out.println("실수2번 = " + 실수2번); // 안씀
		
		
		// -------------------------------------------------------------------------- //
		
		int number = 10;
		System.out.println(number); // 10이 출력
		
		number = 20; // 변수 number의 값을 10에서 20으로 변경 변수의 값은 바뀔 수 있음
		System.out.println(number); // 20이 출력
		
		/* 상수(항상 같은 수)
		 * - 상수도 변수의 한 종류임
		 * - 한 번 값이 대입되면 다른 값을 대입할 수 없다. 값을 변경할 수 없다.
		 * - 자료형 앞에 final 키워드를 작성 (마지막 대입되는 값)
		 * 
		 * - 상수 명명 규칙 : 모두 대문자, 여러 단어 작성 시 "_" 언더바 사용한다.
		 * 
		 * - 상수를 사용하는 경우
		 * 1) 변하면 안되는 고정된 값을 저장할 때
		 * 2) 특정한값에 의미를 부여하는 경우 
		 * 
		 * 
		 * 
		 */
	
		
		final double PI_VALUE = 3.14;
		//PI_VALUE = 2.3222; // 상수라 에러남 다른 값 대입할 수 없음.
		
		final int LEFT_MOVE = -1;
		final int RIGHT_MOVE = 1;
		
		System.out.println(1 + 1.3); // 1이 1.0으로 자동형변환
		// 컴파일러 = 우리가 작성하는거 2진수 0,1로 변경
		
		var num = 10;
		var dnum = 10.0;
		var str = "hello"; // var로 변수선언하면 다른 자료형으로 사용할 수 없음.
		
		final int MAX_NUM = 100;
		final int MIN_NUM;
		
		MIN_NUM = 50;
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
		
		//MAX NUM = 100000;
			
		
		
	
	
	
	
	
		}

}