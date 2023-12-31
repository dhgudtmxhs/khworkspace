package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML { // 혼자서 실행하면 파일 사라지는것 주의

	// XML(eXtensible Markup Language) : 단순화된 데이터 기술 형식
	
	// XML 사용하려는 이유
	// -DB 연결, SQL 같이 수정이 빈번한 내용을
	// 코드에 직접 작성하면 좋지 않다.
	
	// 왜? Java 는 컴파일 언어 -> 코드가 조금만 수정되도 전체 컴파일 다시함
	//					   -> 시간이 오래 걸린다.
	
	// 그런데, XML 외부 파일을 이용해서 XML 내용을 바꿔도
	// 		 Java에서 XML 파일을 읽어오는 코드는 변하지 않음 -> 컴파일 다시하지 않는다 -> 시간 효율이 상승한다.
	
	public static void main(String[] args) {
		
		// XML 은 K : V 형식의 map, XML은 문자열만 저장
		
		//Map<String, String> == Properties
		
		// * Properties 컬랙션 객체 *
		
		// 1. <String, String>으로 Key, Value가 타입 제한된 Map
		// 2. XML 파일을 생성하고 읽어오는데 특화되어있다.
		
		Properties prop = new Properties();
		
		try {
			
			FileOutputStream fos = new FileOutputStream("board-sql.xml");// 파일 이름
			prop.storeToXML(fos, "Board Service SQL"); // 뒤는 그냥 주석임
		//prop.storeToXML() 메서드는 Properties 객체에 저장된 내용을 XML 형식으로 파일에 출력하는 명령입니다.
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
	}
	
	
	
}
