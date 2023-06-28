package practice;


class Time1{
	private int hour;  // 0 ~ 23 사이의 값을 가져야 함. 
	private int minute;
	private int second;

	public void setHour(int hour) {
		
		if(isNotValidHour(hour)) return; // 아니면 빠져나간다.
		//void 반환하지 않는다 에서
		//return; 구문을 사용하여 메소드 실행을 종료할 수 있다.
		//반환할 값이 없기 때문에 return; 으로 종료 할 수 있는 원리.
		//if문에서 조건을 만족하지 안ㅇ흐면 메소드를 종료하기 위해 return; 구문을 사용한다.
		
		this.hour = hour;
	}

	public int getHour() { 
		return hour; // Time1의 hour를 반환한다.
	}
	
	private boolean isNotValidHour (int hour) {
		return hour < 0 || hour > 23;
	}
	
}

public class TimeTest1 {

	public static void main(String[] args) {
		Time1 t = new Time1();
		//t.hour = 25;
		t.setHour(21);
		System.out.println(t.getHour());
		t.setHour(30);
		System.out.println(t.getHour()); // if문에서 false라 return응로 빠져나가서
										 // this.hour = hour; 가 적용 안됨.
	}
}
