package deu.kh.exception.model.vo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent{

	@Override
	public void method() throws FileNotFoundException {
		
		System.out.println("오버라이딩 된 자식 메소드");
		
		//오버라이딩시 예외는 같거나 더 좁은 범위다.
		// 좁은 범위 == 구체적인 예외를 말함
		
		//FileNotFoundException 은 IOException의 자식이므로
		//오버라이딩이 가능하다.
		
		//Exception(모든 예외의 부모)는
		// IOException의 부모 예외이므로 오버라이딩 불가
		
		// Collection 인터페이스 : list, set의 공통 코드를 작성한 단순한 부모 인터페이스
		// java collection : 자바의 자료구조 모음(list, set, map)
		
	}
	
	
}
