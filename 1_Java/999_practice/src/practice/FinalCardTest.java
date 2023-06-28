package practice;

class Card1{

	final int NUMBER;
	final String KIND;
	static int width = 100;
	static int height = 250;
	
	Card1(int num, String kind){
		
		KIND = kind;
		NUMBER = num;
	}
	
	Card1(){
		//this(1, "HEART");
		this.NUMBER =1;
		this.KIND = "HEART"; // this를 안써도 상관이 없긴 하다.
	}
	
	@Override
	public String toString() {
		return KIND + " " + NUMBER;
	}
	
}

public class FinalCardTest {
	
	public static void main(String[] args) {
		
		Card1 c = new Card1(10, "Heart"); 
		// c.NUMBER = 5; 상수라 변경 불가
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c.toString());
		
		Card1 c1 = new Card1(); // this 쓴 기본생성자 불러오기.
		System.out.println(c1.KIND);
		System.out.println(c1.NUMBER);
		System.out.println(c1.toString());
	}

}