package practice;

abstract class Unit {
	int x,y;
	abstract void move(int x, int y);
	void stop() {System.out.println("멈춥니다.");}
}

interface Fightable { // 인터페이스의 모든 메소드는 전부 다 public abstract다. 나중에 예외도 배움.
	public abstract void move(int x, int y);
	public abstract void attack(Fightable f);
}

class Fighter extends Unit implements Fightable{
	
	public void move(int x, int y) {
		System.out.println("[" +x +"," +y+"]로 이동");
	}
	public void attack(Fightable f) { 
		System.out.println(f + "를 공격"); // public 안쓰면 안됨. 오버라이드 한거라 조상보다 접근제어자가 좁으면 안된다.
	}


	Fightable getFightable() { // 반환타입이 Fightable 이면 이 인터페이스를 구현한 Fighter를 반환한다.
		Fighter f  = new Fighter();
		return (Fightable)f;
		
	}
}

public class FighterTest {
	public static void main(String[] args) {
	
		//Fighter f = new Fighter();
		
		Fighter f = new Fighter();
		Fightable f3 = f.getFightable(); // Fightable getFightable()과 반환타입을 같게 한다.		
		
		
		/*		
		Unit u = new Fighter(); // Unit에는 attack()이 없어서 호출불가
		u.stop();
		
		Fightable f1 = new Fighter();
		f1.move(100, 200);
		f1.attack(new Fighter()); // Fightable 에는 stop()이 없어서 호출 불가
		f1.attack(f1);
		//f.stop();
		
		Fighter f2 = new Fighter();
		f2.move(100, 200);
		
		f2.attack(new Fighter());
		f2.attack(f2);
		
		f2.stop(); // Fighter 에는 상속받은 stop, 인터페이스 받은 attack 다 있다.
		*/
	}
}
