package practice;



final class Singleton{ // 상속 불가
		
		private static Singleton s = new Singleton(); 
		
		// 자기 안에서도 인스턴스 생성 가능 근데 static으로 선언해서 클래스 로딩할때 바로 할당되서 공유됨
		// 다수의 객체를 생성할 필요 없이 하나의 인스턴스를 계속해서 재사용 할 수 있도록 구현된 것
		
		private Singleton() {}

		
		public static Singleton getInstance() { 
			if(s==null)
				s = new Singleton();
			 return s;
		}
		// 싱글톤 객체를 반환하는 메소드 
		// s 가 null이면 인스턴스를생성하고, 그렇지 않으면 저장된 인스턴스를 반환한다.
		// 이때 이걸 static으로 선언해서 호출 가능하다.
		
	}
	
	
class SingletonTest {
		
	public static void main(String[] args) {
		
		//Singleton a = new Singleton(); // private이라 직접접근 불가
		Singleton s = Singleton.getInstance(); // 간접접근 메소드 만들어서 get하기.
		
	}
		
	}
