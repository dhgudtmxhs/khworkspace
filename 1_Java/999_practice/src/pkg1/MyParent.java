package pkg1;

public class MyParent{ // 소스파일과 일치해야 한다.
	private 	int prv; // 같은 클래스
				int dft; // 같은 패키지
	protected 	int prt; // 같은 패키지 + 다른 패키지의 자손
	public 		int pub; // 접근 제한 없음

	public void printMembers() {
		System.out.println(prv);
		System.out.println(dft);
		System.out.println(prt);
		System.out.println(pub);
	}

	public int getDft() {
		return dft;
	}

	public void setDft(int dft) {
		this.dft = dft;
	}

}

	


class MyParentTest1 { // 접근 제어자가 default 

	public static void main(String[] args) { 
		
		MyParent p = new MyParent();
		System.out.println(p.getDft()); // 같은 클래스에서만 돼서 getter 쓴다.
		System.out.println(p.dft); // ㅇㅋ
		System.out.println(p.prt); // ㅇㅋ
		System.out.println(p.pub); // ㅇㅋ
	}
	
	// public 클래스는 하나밖에 못만들고 소스파일과 일치해야 한다.
	// 메인이 퍼블릭 클래스가 아니라 실행 안됨.
	
	
	
}


