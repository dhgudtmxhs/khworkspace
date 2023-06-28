package practice;

class Car {

	String color;
	String gearType;
	int door;

	
	Car(){
		this("white", "auto", 4);
	}
	
	Car(String color){
		this(color, "auto", 4);
	}
	
	Car(Car c1){
		/*this.color = c1.color;
		this.gearType = c1.gearType;
		this.door = c1.door;*/
		
		this(c1.color, c1.gearType, c1.door);
		
}

	
	Car(String color, String gearType, int door){ // 원래 있던 변수로 들어옴
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	
	
	}
}
public class CarTest{ // 메인메소드가 있는 클래스는 소스파일과 클래스명이 일치해야 한다.
					  // 하나의 파일에 클래스가 여러 개 있을 때 위의 말대로인 클래스명에만 public을 붙이고, 나머지 class에는 public을 붙이면 안된다.
		public static void main(String[] args) {
			
			Car c1 = new Car();
			c1.color = "white";
			c1.gearType = "auto";
			c1.door = 4; // 이것들이 초기화임
			
			Car c2 = new Car("black", "manual", 2); // 생성자 // 객체는 new연산자가 만듬
												    // 생성자는 객체 초기화. 여기서 초기화는 기본값을 만든다는게 아님 값을 대입한다는거지
			System.out.println(c1.color + c1.gearType + c1.door);
			System.out.println(c2.color + c2.gearType + c2.door);
			
			
			
		}
		
	}
	

