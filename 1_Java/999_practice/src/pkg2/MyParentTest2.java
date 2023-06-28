package pkg2;

import pkg1.MyParent;

class MyChild extends MyParent{
	
	public void printMembers() {
	//	System.out.println(prv); // 에러 같은 클래스만 가능.
	//	System.out.println(dft); // 에러 같은 패키지만 가능
		System.out.println(prt); // ㅇㅋ
		System.out.println(pub); // ㅇㅋ
	}
	
}






public class MyParentTest2 {

	public static void main(String[] args) {
		
		// 이건 지금 자손 패키지가 아님. 다른 패키지의 다른 클래스임.
		
		MyParent p = new MyParent();
//		System.out.println(p.prv); // 불가능
//		System.out.println(p.dft); // 불가능
//		System.out.println(p.prt); // 불가능
		System.out.println(p.pub); // ㅇㅋ
		
		
		
	}
	
	
	
}
