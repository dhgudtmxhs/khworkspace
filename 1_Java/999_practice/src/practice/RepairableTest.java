package practice;

public class RepairableTest {
	
	public static void main(String[] args) {
		
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		//scv.repair(Marine);; Marine은 Repairable이 아니다.
	}
	
}

interface Repairable{} // 나중에 구현한 애들만 들어오게 하는 매개변수 메서드를 작성할거임.

class Unit5{
	
	int hitPoint;
	final int MAX_HP;
	
	Unit5(int hp){
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit5{
	GroundUnit(int hp){
		super(hp);
	}
}

class AirUnit extends Unit5{
	AirUnit(int hp){
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable{
	Tank(){
		super(150); // 탱크 hp 150
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}

}

class Dropship extends AirUnit implements Repairable{
	Dropship(){
		super(125);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}
}

class Marine extends GroundUnit{
	Marine(){
		super(40);
		hitPoint = MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(60);
		hitPoint = MAX_HP;
	}
	
	void repair(Repairable r) { // Repairable을 구현한 애들만 들어와라.
		if (r instanceof Unit5) { // Unit5 클래스를 상속받았는지 확인한다. 상속받았으면 부모자식관 형변환 무조건가능
			Unit5 u = (Unit5)r; 
			
			while(u.hitPoint != u.MAX_HP) {
				// hp 증가시키기.
				u.hitPoint++;
			}
			System.out.println(u.toString() + " 의 수리가 끝났습니다.");
		}
	}
}

