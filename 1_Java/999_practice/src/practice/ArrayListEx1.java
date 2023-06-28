package practice;

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		// ArrayList에는 객체만 저장가능
		
		// AutoBoxing에 의해 기본형이 참조형으로 자동변환
		// java가 알고있음 
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(2));
		list.add(new Integer(0));
		list.add(new Integer(1));
		list.add(new Integer(3));
		// 0번째 인덱스부터 차례대로
		list.add(10); // 원래는 이게 안되는거임. 객체로 넣어야되는데 오토박싱
		
		ArrayList list2 = new ArrayList(list.subList(1, 4));
		// list 는 [0] = 5, [1] = 4, ..... 
		
		//subList = 1,4 로 하면 1<= x = 4 라 인덱스 1, 2, 3의 값만 불러오게 된다.
		//sub 는 읽기만 가능하다.
		
		// List sub = list1.subList(1,4);
		// ArrayList list2 = new ArrayList(sub);
		
		System.out.println(list);
		System.out.println(list2);
		
		//오름차순으로 정리 
		Collections.sort(list);
		Collections.sort(list2); 
		// 지금 이 Collections 는 클래스임.
		//Collection 은 인터페이스 ArrayList(Collection c) 이게 인터페이스 쓰는거
		
		System.out.println(list);
		System.out.println(list2);
		
		System.out.println("list.containsAll(list2) : " + list.containsAll(list2));
		// list 가 list2 의 모든 요소를 포함하고 있나? -> boolean이라 true or false
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); 
		// 3번째 인덱스에 A를 추가한다 -> 3번째 인덱스부터 한칸씩 밀림
		System.out.println(list2);
		
		list2.set(3, "AA");
		// 3번째 인덱스에 A 빼고 AA 넣겠다.
		System.out.println(list2); //A 가 사라지고 AA가 들어간 모습
		
		list.add(0, "1");
		System.out.println(list); // 뒤로 한칸씩 밀리는 모습
		
		System.out.println("index = " + list.indexOf("1")); // String
		System.out.println("index = " + list.indexOf((new Integer(1)))); 
		// integer; new Integer가 숨어있음. 안써도 됨 (오토박싱)
		// 자동으로 1로 변환된다. list indexof(1)은 integer 타입의 값 1이 저장된 인덱스를 찾는 것이다.
		System.out.println("index = " + list.indexOf(1));
		// indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
		// "" 을 하면 문자열을 찾는거고, 우리가 Integer로 저장한 건 ""을 빼고 1, 2 이런 정수형으로 찾아야한다.
		
		
		list.remove(0);
		System.out.println(list);
		
		list.remove((new Integer(1))); 
		System.out.println(list);
		
		list.remove(5); // 5번째 인덱스를 삭제한다. 숫자 5를 지우고 싶으면 이렇게 하면 안됨. 
		System.out.println(list); // 숫자 5가아닌 5번째 인덱스 정수 10이 지워진 모습
		
		list.remove((new Integer(5))); // 이렇게 지워야함 문자열이 아닌 정수형 숫자는
		System.out.println(list); // 5가 지워졌음
		
		
		
		
		
		// retainAll == 겹치는 부분만 남기고 나머지는 삭제한다.
		// list.retainAll(list2) --> list에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2) : " + list.retainAll(list2));
		System.out.println(list);
		System.out.println(list2);
		
		// list2에서 list1에 포함된 객체를 삭제한다.
		for(int i = list2.size()-1; i >=0; i--) {
			if(list.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		System.out.println(list);
		System.out.println(list2);
		
	/*	//===============================================================//
		
		System.out.println("index = " + list.indexOf((new Integer(1)))); 
		System.out.println("index = " + list.indexOf(1)); 
 		
		list.remove(5);
		list.remove((new Integer(5))); // integer는 equals가 오버라이딩 되어있어서 같은 값이면 같은 객체로 본다?
		
		// 이게 다른 이유 : Object remove 는 (int index)고 indexOf(Object o) 
		remove는 int index로 받으니 5를 하면 index 5, new Integer(5)를 하면 5가 들은 인덱스 반환??
		indexof는 object o라 그냥 둘다 정수형???????? 
		
		//===============================================================//
	*/
	
	}
	
	
}
