package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {

	// Set(집합)
	// - 순서를 유지하지 않는다. (== 인덱스가 없다.)
	// - 중복을 허용하지 않는다. (null도 중복이 안된다. 1개만 저장이 가능하다.)
	
	// Colletion은 객체만 저장할 수 있다.
	
	// Set이 중복을 확인하는 방법
	// -> 객체가 가지고 있는 필드 값이 모두 같으면 중복으로 판단
	// --> 이 때, 필드 값이 모두 같은지 비교하기 위해서
	// 객체에 "equals()"가 반드시 "오버라이딩" 되있어야 한다.
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>(); // 인터페이스라 new Set이 불가능함. 직접 객체못만듬
		
		// HashSet : Set의 대표적인 자식 클래스
		
		// 사용 조건 1 : 저장되는 객체에 equals() 오버라이딩 필수
		// 사용 조건 2 : 저장되는 객체에 hashCode() 오버라이딩 필수
		
		// *참고* : Hash라는 단어가 붙은 컬렉션은 반드시 저장되는 객체에 equals(), hashCode()를 오버라이딩 해야한다.
		
		
		// Set.add(Object e) 인데 제네릭스<> 써서
		// Set.add(String e) 가 됨.
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set); // toString 오버라이딩 되어있음
		// 확인할 것 : 1. 순서유지가 진짜 안되는지 2. 중복이 진짜 안되는지 3. null도 중복이 안되는지.
		
		// size() : 저장된 데이터의 개수 반환
		System.out.println("저장된 데이터의 수 : " + set.size()); 
		// 중복은 다 사라진 모습
		
		// remove(String e) : Set에 저장된 객체 중 매개변수 e와 필드 값이 같은 객체를 제거한다.
		//					  Hash라는 단어가 포함된 Set이면 HashCode()도 같아야함. 근데 string은 이미 다 되어있다고 함
		set.remove("네이버");
		System.out.println(set);

		System.out.println(set.remove("라인"));
		System.out.println(set.remove("야놀자"));
		System.out.println(set);
		
		//list에서는 set을 쓰면 기존 인덱스의 자료가 반환되고 새로운 게 들어온다.
		//Set에서는 remove 쓰면 true, false로 반환된다.??
		
		//Set은 get이 없다. 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없다.
		//-> 대신에 Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다.
		
		// 하나하나씩 접근하면서 찾을 수 있다. null부터 너 네이버네? 물어보면서 네이버가 나올 때 까지 찾음
		
		// 1. Iterator (반복자)
		// - 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
		// (컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할)
		
		// Iterator가 얻어온 데이터의 타입은 모두 String임을 알려준다.
		Iterator<String> it = set.iterator(); // new iterator 가 아님.
		
		// set.iterator() : Set을 Iterator 하나씩 꺼내갈 수 있는 모양으로 변환했다고 생각 일단
		
		while(it.hasNext()) { // 하나씩 꺼냈을 때 다음 값이 없을 때 까지 반복한다.
			// -> 다음 값이 있으면 반복해야한다.
			
			//it.hasNext() : 다음 값이 있으면 true 반환한다. 없으면 false 반환한다.
			//it.next()    : 다음 값(객체)를 얻어옴 
			
			String temp = it.next();
			System.out.println(temp);
			
		}
		
		System.out.println("----------------------------------------------------");
		
		//2. 향상된 for문 사용
		// for( 하나씩 꺼내서 저장할 변수 : 컬렉션 )
		for(String temp : set) {
			System.out.println(temp);
		} 
		//for문과 Iterator 의 내부 로직은 같다.
		
	}
	
	public void ex2() {
		
		// Object의 equals(), hashCode() 오버라이딩
		
		// A.equals(B) : A와 B가 가지고 있는 필드 값이 모두 같으면 true, 아니면 false
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수 ( 중복이 안된다. )
		// ex)  입력 : 111 -> "asdfg" (5글자)
		// ex)  입력 : 1234567 -> "qwer" (4글자) 단어의 길이와 상관 없이 길이 지정 가능
		
		// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메소드
		
		// -> 왜 만들까? 빠른 데이터 검색을 위해서(객체가 어디에 있는지 빨리 찾기 위해서)
		
		// HashSet() : 중복 없이 데이터 저장(Set)하고 데이터 검색이 빠름(Hash)
		
		Member mem1 = new Member("user01", "pass01", 30);
		Member mem2 = new Member("user01", "pass01", 30);
		Member mem3 = new Member("user02", "pass02", 20);
		
		// mem1과 mem2가 같은지 비교
		System.out.println(mem1 == mem2); // 참조하는 객체가 달라 주소값이 달라서 false
										  // 얕은 복사 경우가 아니라면 다 false
		
		// mem1과 mem2가 가지고 있는 필드 값이 같은지 비교
		
		if(mem1.getId().equals(mem2.getId())) { // 아이디가 같을 경우
			
			if(mem1.getPw().equals(mem2.getPw())) { // 비밀번호도 같은 경우
				
				if(mem1.getAge() == mem2.getAge()) {
					System.out.println("같은 객체 입니다. (true)");
				}
			}
		}
		
		// -> 매번 이렇게 비교하기 힘들다. 비교 코드를 작성해서 재활용하자.
		//== equals() 메소드 오버라이딩
		
		System.out.println("-----------------------------------");
		System.out.println(mem1.equals(mem2));
		System.out.println(mem1.equals(mem3));
		
		// 서로 다른 객체지만 필드 값이 같다 == 동등하다.
		// 비교하려는 것이 정말 같은 하나의 객체이다 == 동일하다.
	}
	
	public void ex3() {
		
		// equals()가 오버라이딩 된 Member를 Set에 저장
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add( new Member("user01", "pass01", 30) );
		memberSet.add( new Member("user02", "pass02", 40) );
		memberSet.add( new Member("user03", "pass03", 20) );
		memberSet.add( new Member("user04", "pass04", 25) );
		memberSet.add( new Member("user04", "pass04", 25) );
		
		for(Member a: memberSet) {
			System.out.println(a);
		}
		// 왜 중복값이 출력되지??
		// [KEY POINT] : 중복이 제거가 되는가?
		// Set이 중복을 확인하는 방법
		// -> 객체가 가지고 있는 필드 값이 모두 같으면 중복으로 판단
		// --> 이 때, 필드 값이 모두 같은지 비교하기 위해서
		// 객체에 "equals()"가 반드시 "오버라이딩" 되있어야 한다.
		
		// hashCode() 오버라이딩 전
		// -> equals()가 오버라이딩 되어있지만 중복 제거가 되지 않는다.
		// -> 왜? HashSet은 hashCode()도 오버라이딩 해야한다.
		
		// HashSet : Set의 대표적인 자식 클래스
		// 사용 조건 1 : 저장되는 객체에 equals() 오버라이딩 필수
		// 사용 조건 2 : 저장되는 객체에 hashCode() 오버라이딩 필수
		
		// 오버라이딩 하니까 중복 사라져서 출력됨.
		
		Member mem1 = new Member("user01", "pass01", 30);
		Member mem2 = new Member("user01", "pass01", 30);
		Member mem3 = new Member("user01", "pass01", 31);
		
		System.out.println(mem1.hashCode());
		System.out.println(mem2.hashCode());
		System.out.println(mem3.hashCode());
	
	}
	
	public void ex4() {
		
		// Wrapper 클래스 : 기본 자료형 -> 객체(속성+기능)로 포장하는 클래스
		
		// - 컬렉션에 기본 자료형 값을 저장할 때 사용한다.
		// - 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용한다. ( 속성+기능 인듯)
		
		// - <Wrapper 클래스 종류>
		// int 		-> Integer
		// double 	-> Double
		// Boolean, Byte, Short, Long, Float
		// char 	-> Character
		
		int iNum = 10;
		double dNum = 3.14;
		
		// 기본 자료형 -> 포장 
		Integer w1 = new Integer(iNum); // int 가 Integer로 포장이 되었다.
		Double w2 = new Double(dNum); // double 이 Double로 포장이 되었다.
		
		// Wrapper클래스 활용
		
		System.out.println("int 최대값 : " + w1.MAX_VALUE);
		System.out.println("double 최소값 : " + w2.MIN_VALUE);
											// 기울어진 글씨 == static
											// static은 /클래스명.필드명/ or /클래스명.메소드명()/ 으로 호출가능하다.
		
		System.out.println("w1 값 : " + w1);
		System.out.println("w2 값 : " + w2);
		
		System.out.println("==========================================");
		System.out.println("static 방식으로 Wrapper 클래스 사용하기");
		
		System.out.println("int 최소값 : " + Integer.MIN_VALUE); // 	객체를 안만들어도 가능. static 이니깐
		System.out.println("double 최대값 : " + Double.MAX_VALUE); // 프로그램 로딩 시 이미 만들어져있다.
		
		// ********************************************************************************************** //
		
		// parsing : 데이터의 형식을 변환한다. // int 10을 double 10.0으로 바꾸는 게 아니라 문자열 "10"을 int 10으로 바꾼다.
		
		// ! String 데이터를 기본 자료형으로 변환한다.
		
		int num1 = Integer.parseInt("100"); // 문자열 "100" 을 int 형식으로 변환한다.
		double num2 = Double.parseDouble("1.23456"); // 문자열 "1.23456" 을 double 형식으로 변환했다. // 포장한 int와 double로
		
		System.out.println(num1 + num2); // 1001.23456 이 아니라 101.23456 이 나온 모습 -> 형변환이 잘 됐다.
		
		// ********************************************************************************************** //
		
	}
	
	public void ex5() {
		
		//Wrapper 클래스의 AutoBoxing / AutoUnBoxing
		
		Integer w1 = new Integer(100);
		// 삭제선 == deprecated == 해당 구문은 삭제 예정이다.
		// => 사용을 권장하지 않는다.
		
		Integer w2 = 100;
		Integer w3 = 100;
	 //(integer)    (int -> Integer) 자동 포장 [AutoBoxing]
		
		// w2와 100은 원래 연산이 안되어야 하지만
		// Integer는 int의 포장 형식이라는 것을 Java가 인식하고 있어서
		// 위와 같은 경우 int를 Integer로 바로 포장 해준다. Integer w2 객체 만들때 = new Integer(int값)을 할 필요가 없다.
		
		System.out.println("w2 + w3 = " + (w2 + w3)); // 100 + 100 = 200 이 잘 나오는 모습
		
		// w2 (Integer 객체)
		// w3 (Integer 객체)
		// w2 + w3 == 객체 + 객체 --> 객체끼리 더하는게 원래는 불가능하다.
		
		// 하지만 Integer는 int 의 포장 형태 라는 걸 Java가 인식하고 있어서
		// + 연산을 했을 때 포장을 자동으로 벗겨준다.
		
		// Integer + Integer -> int + int (자동 포장 해제)
							 // AutoUnBoxing
	
	}
	
	
	
	public void lotto() {
		
		// 로또 번호 생성기 Version.2
		
		//Set<int> lotto = new HashSet<int>();
		// <>는 객체만 들어올 수 있음. int는 기본 자료형이기 때문에 타입 제한을 할 수 없다.
		
		// -> 해결 방법 : Wrapper Class를 이용해서 기본 자료형을 객체로 포장한다.
		
		//Set<Integer> lotto = new HashSet<Integer>(); 
		//Set<Integer> lotto = new LinkedHashSet<Integer>(); 
		// HashSet과 거의 동일하지만 Set에 추가되는 순서를 유지한다는 점이 다름 이게 뭔말?
	
		Set<Integer> lotto = new TreeSet<Integer>(); 
		
		// HashSet -> hashCode, equals 오버라이딩 되어 있어야 한다.
		// Integer 는 그게 되어있음. 그래서 그냥 쓰면 됨. (String 도 아까 되어있었음)
		
		while(lotto.size() < 6) { // size 0부터 시작임. 0일때 1개만들고.. 1 2 3 4 5.. 까지 하면 6개 다시 while문가면 size < 6 이 아님 
		
			int random = (int)(Math.random()*45+1);	
			
			System.out.println(random);
			
			lotto.add(random); // AutoBoxing (int -> Integer) 되어 lotto에 추가한다.
		
		}
		
		System.out.println("로또 번호 : " + lotto);
	}
	
	
}