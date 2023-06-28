package practice;

public class StaticTest {

	static int width = 200;
	static int height = 120;	
	
	static {} 
	
	static int max(int a, int b) {
		
		return a > b ? a :b ;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(width);
		System.out.println(height);
		System.out.println(max(width, height));
		
	}
	
	
}
