package practice;

abstract class Player{
	abstract void play(int pos);
	abstract void stop();
}

class AudioPlayer extends Player{
	void play(int pos) { System.out.println(pos+"위치부터 play합니다.");}
	void stop() {System.out.println("재생을 멈춥니다.");}
}

public class PlayerTest{

	public static void main(String[] args) {
		
		// Player p = new Player(); 추상클래스 인스턴스 생성 불가능
//		AudioPlayer ap = new AudioPlayer();
		Player ap = new AudioPlayer(); // 다형성, 동적바인딩
		ap.play(100);
		ap.stop();
		

	}

}
