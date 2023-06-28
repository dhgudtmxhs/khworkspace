package edu.kh.oop.cls.model.vo;

 class TestV0 {

		
	// 접근 제한자 (default)(생략됨) 인 형태 : 같은 패키지 내에서만 import가 가능함을 나타낸다. 
	
	// Student와 같은 패키지
	// -> public, protected, (default) 3개만 접근 가능
	 
	 public void ex() {
		 
		 System.out.println("같은 패키지");
		
		 Student std = new Student(); // 학생 객체 생성, 같은 패키지임
		 
		 System.out.println(std.v1);
		 System.out.println(std.v2);
		 System.out.println(std.v3); 
		
		 // System.out.println(std.v4); 
		 // private는 같은 클래스에서만 사용 가능 
		 // 같은 패키지여도 직접 접근이 불가능
	 }
	 
	 
	 
	 
		
}
