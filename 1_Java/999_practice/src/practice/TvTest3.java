package practice;

class TvTest3 {

	public static void main(String[] args) {
		
	
	
	Tv t1 = new Tv();
	Tv t2 = new Tv();
	
	System.out.println("t1의 channel값은" + t1.channel + "입니다.");
	System.out.println("t1의 channel값은" + t1.channel + "입니다.");
	
	t2 = t1;
	t1.channel = 10;
	t2.channelUp();
	System.out.println(t1.channel);
	System.out.println(t2.channel);
	
	}
}

