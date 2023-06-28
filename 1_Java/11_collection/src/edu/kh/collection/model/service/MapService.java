package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {
	
	// Map : key와 Value 한 쌍이 데이터가 되어 이를 모아둔 객체
	
	// - key를 모아두면 Set의 특징을 가지고 있다. (중복 허용 x)
	// - Value를 모아두면 List의 특징 (중복 o)
	
	public void ex1() {
		
		// HashMap<K, V> : Map의 자식 클래스 중 가장 대표되는 Map
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 객체만 쓸수 있어서 int 말고 Integer

		//Map은 add 가 아닌 put 사용
		//Map.put(Integer Key, String  Value) : 추가 (put=놓다)
		
	
		map.put(1, "홍길동");
		map.put(2, "김길동");
		map.put(3, "나길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "동길동");
	
		// Key 중복
		map.put(1, "홍홍홍"); // 중복 허용 안함. Value가 덮어써짐. 홍길동 -> 홍홍홍
		
		// Value 중복
		map.put(6, "홍홍홍"); // Value 중복 가능
		map.put(7, "나길동"); // Value 중복 가능
		
		System.out.println(map);

	}
	
	public void ex2() {
		
		// Map 사용 예제
		
		// VO(value object 값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		// 재사용이 적은 VO는 오히려 코드 낭비.
		// Map을 이용해서 VO와 비슷한 코드를 작성할 수 있다.
		
		// 1) VO 버전
		Member mem = new Member();
		
		// 값 세팅
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		// 값 출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
		
		System.out.println("-----------------------------------------");
		
		// 2) Map 버전
		Map<String, Object> map = new HashMap<String, Object>(); // 다형성
		// value가 Object 타입 == 어떤 객체든 value에 들어올 수 있다.
		
		// 값 세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25); // Integer로 오토박싱됨
		
		// 값 출력
		System.out.println(map.get("id").toString());
		// String java.lang.Object.toString() 정적바인딩
		// 실행 중 확인해보니까 @가 안나옴. 동적바인딩이 일어난 걸 알 수 있음.
		// String 자식 객체 - > 자식의 toString()을 호출했다. -> 동적 바인딩

		System.out.println(map.get("pw")); // string 자식객체 tostring
		System.out.println(map.get("age").toString()); // integer의? tostring 동적바인딩
		System.out.println(map);
		
		// *** Map에 저장된 데이터 순차적으로 접근하기 ***
		
		// Map에서 Key만 모아두면 Set의 특징을 가진다.
		// -> 이를 활용 할 수 있도록 Map에서
		// KeySet() 메소드 제공
		// -> Key만 모아서 Set으로 반환한다.
		
		Set<String> set = map.keySet(); // id, pw, age가 저장된 Set 반환한다.
		System.out.println(set);
		
		// 향상된 for문
		for(String key : set) { // key가 String 타입
			System.out.println(key);
			System.out.println(map.get(key));
									//key가 반복될 때마다 변경
									//변경된 key에 맞는 map의 value가 출력된다.
		}
		// map에 저장된 데이터가 많거나
		// 어떤 key가 있는지 불분명 할 때
		// 또는 map의 저장된 모든 데이터에 접근해야 할 때
		// keySet() + 향상된 for문 코드를 사용한다.
		
	}
	
	public void ex3() {
		
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>(); 
		
		 for(int i = 0; i < 10; i++) {
			 
			 // Map 생성
			 Map<String, Object> map = new HashMap<String, Object>();
			 
			 // Map에 데이터 추가
			 map.put("id","user0"+ i );
			 map.put("pw","pass0"+ i ); // 01 02 이런식 문자열 + 1 = 문자열 + 문자열
			 
			 // Map을 List에 추가
			 list.add(map);
			 
		 }
	
		 // for문 종료시 List에는 10개의 Map 객체가 추가되어있다.

		 // * List에 저장된 Map에서 key가 "id"인 경우의 value를 모두 출력하겠다.
		 
		 for(Map<String, Object> temp : list) {
			 System.out.println(temp.get("pw"));
		 }
		 
		 
	}
	
}
