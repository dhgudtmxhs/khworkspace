package practice;

public class CallStackTest2 {

	
	public static void main(String[] args) {
		
		System.out.println("main(String[] args)가 시작되었음.");
		firstMethod();
		System.out.println("main(String[] args)가 끝났음.");
		
	}

	static void firstMethod() {
		
		System.out.println("firstMethod()가 시작되었음.");
		secondMethod();
		System.out.println("firstMethod()가 끝났음");
		
	}
	
	static void secondMethod() {
		
		System.out.println("secondMethod()가 시작되었음.");
		System.out.println("secondMethod()가 끝났음.");
	}

	// main 시작 - fm - fm 시작 - sm - sm 시작 - sm 끝 - fm 끝 - main 끝
	
		
}



	

