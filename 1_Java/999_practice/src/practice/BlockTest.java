package practice;

public class BlockTest {

	static { 
		System.out.println("static { } ");
	}
	
	{
		System.out.println("{ } "); // 이건 거의 쓰지 않음 생성자로 초기화하지.
	}
	
	public BlockTest() {
		System.out.println("생성자"); // 인스턴스 초기화블럭은 인스턴스가 생성될 때마다 수행됨
	}

	public static void main(String[] args) {
		
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest bt = new BlockTest();
		
		System.out.println("BlockTest bt2 = new BlockTest2();");
		BlockTest bt2 = new BlockTest();
		
	}

	// 스태틱 젤먼저 수행
	// 그다음 main 메서드가 수행되어 BlockTest인스턴스가 생성됨
	// 인스턴스 초기화 블록이 먼저 수행됨
	// 끝으로 생성자가 수행됨
	
	// * 인스턴스 초기화블럭은 인스턴스가 생성될 때 마다 수행됨. *


}



	