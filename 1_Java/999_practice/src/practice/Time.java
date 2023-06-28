package practice;

/*public class Time {

		private int hour;
		private int minute;
		private float second;
		
		public int getHour() {return hour;}
		public int getMinute() {return minute;}
		public float getSecond() {return second;}
		
		public void setHour(int hour) {this.hour = hour;}
		public void setMinute(int minute) {this.minute = minute;}
		public void setSecond(float second) {this.second = second;}
}*/


public class Time {
	
	int hour;
	int minute;
	int second;
	
	// 이 멤버변수 (인스턴스 변수 + 클래스 변수) 영역에는 선언문만 들어갈 수 있다.
	// y = x + 3; or System.out.print(); 이런 것 넣을 수 없음.
	
	// 멤버변수의 위치와 메서드의 위치는 상관없음.
	// 메서드가 위로 올라와도 됨.
}

class TimeTest{
	
	Time t = new Time(); // 시분초를 하나로 묶어버림
	
}