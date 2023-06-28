package practice;

class Tv1 {
	
	void power() { power = !power;}
	void channelUp() { ++channel;}
	void channelDown() { --channel;} // 메서드가 위에있어도 됨.
	
	boolean power;
	int channel; // 부모 멤버 5개
	
}

class CaptionTv extends Tv1{ 
	
	boolean caption; // 캡션상태 on/off // 초기값 false
	void displayCaption(String text) {
		if (caption ) { // caption 상태 on일때만 text 보여줌 // if(caption) = if(caption == true) if 문이 true여야 하니까.
			System.out.println(text); // 자식 멤버 2개
		}
	}
}

class CaptionTvTest {
	
	public static void main(String[] args) {
		
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10; //상속받은 멤버
		ctv.channelUp();  //상속받은 멤버 사용 가능한 걸 확인할 수 있음
		
		System.out.println(ctv.channel);
		
		ctv.displayCaption("Hello World"); // caption = false
		ctv.caption = true;
		ctv.displayCaption("Hello World"); // caption = true;
		
		
	}
	
}