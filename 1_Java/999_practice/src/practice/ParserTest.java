package practice;

interface Parseable{
	// 구문 분석작업 수행
	public abstract void parse(String fileName);
}

class ParserManager{
	// 리턴 타입이 Parseable인터페이스다.
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		}else {
			Parseable p = new HTMLParser();
			return p; // return new HTMLparser();
		}
	}
}

class XMLParser implements Parseable{
	public void parse(String fileName) {
		// 구문 분석작업 수행하는 코드
		System.out.println(fileName + "- XML parsing completed");
	}
}

class HTMLParser implements Parseable{
	public void parse(String fileName) {
		System.out.println(fileName + "- HTML parsing completed");
	}
}


public class ParserTest {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("document.xml"); // 동적바인딩되서 구현한 클래스의 오버라이딩 실현한다.

		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html"); // 동적바인딩되서 구현한 클래스의 오버라이딩 실현한다.
	}
	
}
