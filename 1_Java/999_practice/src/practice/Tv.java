package practice;

class Tv {

	
	void power() { power = !power;}
	void channelUp() { ++channel;}
	void channelDown() { --channel;} // 메서드가 위에있어도 됨.
	
	String color;
	boolean power;
	int channel;
	
	//public static void firstMethod() {}
	//public static void secondMethod() {}


	
}
