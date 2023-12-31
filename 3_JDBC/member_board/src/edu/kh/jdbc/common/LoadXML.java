package edu.kh.jdbc.common;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoadXML {

	public static void main(String[] args) {
		
		//외부 XML 파일 읽어오기(Properties 사용)
		
		Properties prop = new Properties();
		// Key, Value가 String으로 제한된 Map
		
		try {
			prop.loadFromXML(new FileInputStream("driver.xml"));
			//입력할 때 사용하는 prop.loadFromXML() 메서드는 XML 파일에서 Properties 객체로 데이터를 읽어오는 명령입니다. 
			//FileInputStream 객체를 생성하여 XML 파일을 읽어온 뒤, Properties 객체로 변환하여 사용할 수 있습니다.
			// 출력할 때는 Properties 객체에 데이터를 저장하고 파일로 출력하고, 입력할 때는 파일에서 데이터를 읽어와 Properties 객체에 저장하여 사용하는 방법을 사용합니다.
			
			// Property : 속성(데이터)
			// Prop.getProperty("driver") : XML에서 얻어온 값 중 키가 driver인 엔트리의 value를 얻어와라.
			
			//	<!-- entry : Map의 Key, Value를 묶어서 부르는 명칭 -->
			//<entry key ="driver">oracle.jdbc.driver.OracleDriver2</entry> 
			
			System.out.println("driver : " + prop.getProperty("driver"));
		
			// 외부 파일 미사용
			String str = "oracle.jdbc.driver.OracleDriver"; 
			System.out.println(str);
			
			// 자바는 한글자만 바꿔도 처음부터 끝까지 컴파일을 다시한다.
			// 다시 처음부터 전체 내용을 컴파일(이진 코드로 번역)한다. --> 비효율적
			
			// 그런데, Java에 외부 파일을 읽어오는 변하지 않는 코드를 작성하면
			// 컴파일을 다시 하지 않는다. -> 효율적이다.
			
			// 컴파일을 다시 하지 않아도 외부파일 내용이 변하면 자동으로 반영된다.
			
			// DB 연결정보, SQL 내용은 빈번히 변화될 예정이다.
			// 1) Java 코드에 직접 작성 -> 다시 컴파일 -> 실행(비효율적)
			// 2) XML에 작성 -> 바로 실행(다시 컴파일X, 효율적)
			//	+ (추가 효과) db정보, sql 한곳에 모아서 관리 (보기 좋고, 관리 쉽다)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(JDBCTemplate.getConnection());
	}
	
	
}
