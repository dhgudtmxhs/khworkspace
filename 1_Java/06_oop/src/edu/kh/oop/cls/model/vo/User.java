package edu.kh.oop.cls.model.vo;

public class User {

	// 속성 (== 필드)
	
	// 아이디, 비밀번호, 이름, 나이, 성별 (추상화 진행)
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender; // 캡슐화 원칙에 의해 기본적으로 private

	// 기능 (== 생성자 + 메소드)
	
	// 생성자 : new 연산자를 통해서 객체가 생성될 때
	// 		  생성된 객체의 필드 값 초기화 + 기능 수행 역할
	
	public User() {
		System.out.println("기본 생성자로 User 객체 생성");
	
	
	// 필드 초기화 값이 초기값이 된다. null, 0, 등
	userId = "user01";
	userPw = "pass01";
	userName = "홍길동";
	userAge = 20;
	userGender = '남';
	
	}
	// 기본 생성자

	// 캡슐화로 인한 간접접근 기능( getter / setter )
	
	public String getUserId() { // userId의 getter가 만들어짐
		return userId;
	}
	public void setUserId(String userId) { // serId의 setter가 만들어짐.
		this.userId = userId;
	}
	public String getUserPw() { // get return, set this
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}

	// 매개변수 생성자
	
	// 사용되는 기술, 변수 : 매개변수, Overloading(오버로딩), this
	
	// 매개변수 : 생성자나 메소드 호출시 
	//          ()안에 작성되어 전달되어지는 값을 저장하는 변수
	
	// -> 전달 받은 값을 저장하고 있는 매개체(지니고 있는)역할의 변수
	
	public User(String userId, String userPw) {
				// 매개변수 {안에서만 사용가능}
		
		System.out.println("매개변수 생성자를 이용해서 User 객체 생성");
		System.out.println(userId + " / " + userPw);
		
		// 전달 받은 값을 필드에 초기화(this 참조 변수)
		
		// public = 전체
		// protected = 후손 클래스 내
		// (default) = 같은 패키지 내
		// private = 해당 클래스 내부
		
		// 나가면 끝 user id, user pw 안변함
	
		// this 참조변수
		// - 객체가 자기 자신을 참조할 수 있도록 하는 변수
		// - 모든 객체 내부에 숨겨져 있다.
		
		// 왜 사용하는가???
		// -> 필드명과 매개변수명이 같을 경우
		// 이를 구분하기 위해서 주로 사용한다.
	
		this.userId = userId;
		// 필드 = 매개변수
		this.userPw = userPw; // 이걸 하지 않으면 여기 괄호 안에서 끝남
		
	}
	
	// 필드를 전부 초기화하는 목적의 매개변수 생성자
	// 생성자는 반환형이 없다.
	public User(String userId, String userPw, String userName, int userAge, char userGender) {
		
		// 매개변수로 전달 받은 값으로 필드 초기화
		//this.userId = userId; // 현재 객체가 가지고 있는 필드 userId에
		//this.userPw = userPw; // 매개변수 userId 값을 대입한다.
		
		this(userId,userPw); // this()생성자로 불러줌 같은 클래스의 다른 생성자를 호출한 것.
							 // - 같은 클래스의 다른 생성자를 호출할 때 사용한다.
							 // 생성자 내에서 반드시 첫번째 줄에 작성되어야 한다.
		
		// 왜 사용하는가?
		// 중복 코드 제거, 코드 길이 감소, 재사용성 증가
		//(가독성이 어려울 수 있어서 많이 사용되진 않는다.)
		
		
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		
		
	}
	
	// 자바는 기본적으로 필드명, 생성자명, 메소드명, 변수명의
	// 중복을 허용하지 않음. 
	/*	
 	private String userId; // Duplicate field User.userId 필드 유저아이디와 똑같다고 오류
	public User() {} // Duplicate method User() in type User 
	public String getUserId() {} // Duplicate method getUserId() in type User
	public void ex() {
		int num = 10;
		int num = 20; // Duplicate local variable num 변수명의 중복
	}
	*/
	
	// 오버로딩(Over Loading)
	// - 클래스 내에서 동일한 이름의 메소드(생성자도 포함)를
	//  여러 개 작성하는 기법
	
	// --> 하나의 이름으로 여러 기능을 수행할 수 있게 하는 것이다.
	
	// [오버로딩 조건]
	// 1. 메소드(생성자 포함)의 이름이 동일해야 한다.
	// 2. 매개변수의 개수, 타입, 순서 중 1개라도 달라야 한다.
	
	// public User() {} // 기본 생성자가 이미 작성되어 있어서 중복이다.
	
	public User(String userId) {} // 위에 매개변수 1개짜리 없었음. 그래서 가능
								  // 오버로딩 성립
	
	public User(int userAge) {} // 매개변수의 수는 같지만 타입이 다르다. 그래서 가능 
								// 오버로딩 성립
	
	public User(int userAge, String userId) {} //매개변수의 수 같고 타입 다름. 위는 String String 오버로딩 성립

	public User(String userId, int userAge) {} //매개변수의 개수, 타입은 같지만 순서가 다르다. 오버로딩 성립
																		// string, int의 순서.
	public User(String userId, String userPw, String userName) {} //
	
	//public User(String userName, String userId, String userPw) {}
	// 매개변수의 개수, 타입, 순서가 모두 같아서 오버로딩 불가
	// 변수명은 신경쓰지 않음 순서가 같다는건 string을 의미함.
	
	
	
	
	
	
	
	
}
