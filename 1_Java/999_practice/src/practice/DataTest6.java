package practice;



public class DataTest6 {


public static void main(String[] args) {
	
	Data d = new Data();
	d.x = 10;
	DataTest6 r = new DataTest6();
			
	Data d2 = copy(d); // static 없애고 r.copy(d); 객체생성하면 참조변수 생략 불가능함.
	System.out.println("d.x = " + d.x);
	System.out.println("d2.x = " + d2.x);
}

static Data copy(Data e) {
		Data tmp = new Data(); // tmp 생성
		
		tmp.x = e.x; // d.x 값을 tmp.x에 복사
		
		return tmp; // 복사한 객체의 주소를 반환한다.
		
	}

	// 같은 클래스에서 static 은 객체없이 호출가능, 참조변수를 생략 가능함

}