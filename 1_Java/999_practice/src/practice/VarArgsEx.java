package practice;

public class VarArgsEx {

	static String concatenate(String delim, String... args) { // delim = 구분자
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
	String[] strArr = { "100", "200", "300"};
	
	System.out.println(concatenate("", "100", "200", "300"));
	System.out.println(concatenate("-", strArr));
	System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
	System.out.println(concatenate("[" +concatenate(",", new String[0])+ "]"));
	System.out.println(concatenate("[" +concatenate(",")+"]"));
	}
}
	

/*첫번째 메소드인 concatenate는 가변인자를 사용하여 문자열을 연결하는 함수입니다.

String... args는 가변인자로, 매개변수의 타입 앞에 ...을 붙이면 해당 타입의 인자를 여러 개 전달할 수 있습니다.

예를 들어, concatenate("", "100", "200", "300") 는 구분자가 없는 상태로 "100200300"을 반환합니다.

concatenate("-", strArr)에서 strArr는 String 배열이므로, 배열을 하나의 문자열로 연결하기 위해서는 구분자가 필요합니다. 그러므로 구분자로 '-'를 사용하여 "100-200-300"을 반환합니다.

concatenate(",", new String[] {"1", "2", "3"})에서는 구분자로 ','를 사용하여 new String[] {"1", "2", "3"} 배열의 원소들을 연결한 문자열 "1,2,3"을 반환합니다.

concatenate("[" +concatenate(",", new String[0])+ "]")에서는 빈 문자열 배열을 가변인자로 사용하여 ,구분자를 이용해 인자를 연결한 결과를 [] 사이에 두고 반환합니다.

concatenate("[" +concatenate(",") +"]")에서는 인자가 없는 상태로 호출되어 , 구분자로 인자를 연결합니다. 그러므로 "[]"를 반환합니다.*/