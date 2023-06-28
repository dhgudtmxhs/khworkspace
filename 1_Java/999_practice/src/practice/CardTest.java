package practice;

public class CardTest {

	public static void main(String[] args) {
		
	
	System.out.println("Card.width = " + Card.width);
	System.out.println("Card.width = " + Card.width); 
	// 클래스 변수는 객체 생성 없이 그냥 가능.

	Card c1 = new Card();
	c1.kind = "Heart";
	c1.number = 7;
	
	Card c2 = new Card();
	c2.kind = "space";
	c2.number = 4;
	
	System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + "," + c1.height + ")");
	System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + "," + c2.height + ")");

	System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
	
	//c1.width = 50;
	//c1.height = 80; 
	// 참조변수로 다루는데 iv가 아님 c1만의 코드가 아님.
	// c2 참조변수로 바꿔도 static을 바꾼거기 때문에 c1이 바뀜.
	//오해하지 않게 하려면
	Card.width = 50;
	Card.height = 80;
	// 이렇게 해야함 근데 위의 코드도 틀린건 아님 헷갈릴 뿐
	
	
	System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + "," + c1.height + ")");
	System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + "," + c2.height + ")");
	// 
	

	
	}

	
	


	}

