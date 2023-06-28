package practice;

import java.util.Arrays;

class Product{
	int price;
	int bonuspoint;
	
	//Product(){}
	Product(int price){
		this.price = price;
		bonuspoint = (int)(price/10.0);
	}
}

class Tv0 extends Product{
	Tv0(){super(100);} //Product (int price) 를 호출한다.
	
	@Override
	public String toString() {return "TV";}

}

class Computer0 extends Product{ // 상위 클래스에 매개변수를 받는 생성자만 정의되어 있다면 하위 클래스에서는 반드시 이를 호출해야 합니다.
	Computer0(){super(200);} // Product (int price)
	@Override
	public String toString() {return "Computer0";}

}

class Audio0 extends Product{

	Audio0(){super(300);}
	@Override
	public String toString() {return "Audio0";}
}

class Buyer2{
	int money = 1000;
	int bonuspoint = 0;
	Product[] item = new Product[10];
	int i = 0;
/*	void buy(Tv0 t) {
		money -= t.price;
		bonuspoint += t.bonuspoint; 
	}

	void buy(Computer0 c) {
		money -= c.price;
		bonuspoint += c.bonuspoint; 
	}
	
	void buy(Audio0 a) {
		money -= a.price;
		bonuspoint += a.bonuspoint; // 오버로딩. 메소드가 너무 많이 필요함 이렇게 하면. 
	}*/

	void buy(Product p) { // 다형성때문에 tv0, computer0, audio0가 다 들어올 수 있다.
		
		if(money < p.price) {
			System.out.println("잔액이 부족해서 살 수 없어요.");
			return;
		}
		
		money -= p.price;
		bonuspoint += p.bonuspoint;
		item[i] = p;
		i++;
		System.out.println(p.toString() + " 을/를 구입하셨어요.");
		System.out.println(Arrays.toString(item));
	}

	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) break; 
			sum += item[i].price;
			itemList += (i==0) ? item[i] : ", " + item[i];
		}
		System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은" + itemList + "입니다.");
	}

}



public class PolyArgumentTest {

		public static void main(String[] args) {
			Buyer2 b = new Buyer2();
			
			Product p = new Tv0();
			b.buy(p);
			
			b.buy(new Tv0());			//buy(Product p) // 이렇게하면 참조변수가 없음.
			b.buy(new Computer0());		//buy(Product p)
			b.summary();
			System.out.println("현재 남은 돈은 "+ b.money + "만원입니다.");
			System.out.println("현재 보너스 점수는 "+ b.bonuspoint + "점입니다.");
			System.out.println();
			
		}
		
	
}
