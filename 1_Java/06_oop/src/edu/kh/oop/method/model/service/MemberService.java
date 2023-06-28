package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService { // 클래스

	
	 //public MemberService(int a) {} // 매개변수 1개 생성자
	 // 기본 생성자
	
	// 속성(필드) 
	private Scanner sc = new Scanner(System.in); // 스캐너 앞에도 쓸 수 있음.
												 // (System.in) = 매개변수

	private Member memberInfo = null; // 가입한 회원의 정보를 저장할 변수
	       //자료형    변수명
		   //class Member(사용자정의자료형) // 자료형은 Member써서 선언함. class Member를 사용                                                                                      
	
	private Member loginmember = null; // 로그인한 회원의 정보를 저장할 변수

	//System.in : 자바에서 기본적으로 지정해둔 입력 장치(키보드)의 입력을 스캔하겠다.
	// 객체 만들면 메모리 어딘가에 있는 System.in 주소가 대입
	
	// 기능 (생성자, 메소드)
	//public MemberService() {}  // 기본 생성자

	// method 작성법
	
	// [접근제한자]      [예약어]       반환형   			  메소드명([매개변수]) {}
	// public		  static	  기본 자료형
	// protected	  final  	  참조형(배열,클래스)
	// (default)	  abstract    void(반환값이없다)
	// private		static final
	
	// 반환형 void
	// - 반환(return)이란? 메소드 수행 후 호출부로 돌아가는 것
	// - 반환 값 : 돌아가면서 가져갈 결과 값
	// - 반환 형 : 반환 값의 자료형
	// -> void : 돌려 보낼 값(반환 값)이 없다.
	
	public void displayMenu() { // 메뉴 화면 출력 기능
		
		int menuNum = 0;
		
		do { // 한번은 무조건 반복 -> 한번은 무조건 출력한다.
			
			System.out.println("===== 회원 정보 관리 프로그램 v1 =====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc를 사용한 것.
			sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거
			
			switch(menuNum) {
			
			case 1 : System.out.println(signUp()); break;
				// 같은 클래스 내부에 있는 필드, 메소드는 이름만 불러도 호출 가능
				// signUp() 메소드를 호출하여 수행 후 반환 받은 값을 출력한다.
				// 우리가 출력구문 return으로 적어줬으니깐 
			    // print 안하면 return 값 안나옴
			case 2 : System.out.println(login());break;
			
			case 3 : System.out.println(selectMember()); break;
			
			case 4 : 
				int result = updateMember();  // 회원정보수정 메소드 수행 후
												 	// 반환되는 결과를 result 변수에 저장

				if (result == -1) {
					System.out.println("로그인 후 이용 해주세요.");
				}else if (result == 0) {
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				}else {
					System.out.println("회원정보가 수정 되었습니다.");
					}break;
			
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");	
			
			}
		}while(menuNum != 0); // 0이 아닐 때 반복, 0이면 멈춘다
	}
	
	// 회원 가입 기능
	public String signUp() { // This method must return a result
		  // (반환형)
		  // 해당 메소드가 끝나고 호출한 곳으로 돌아갈 때
		  // void : 반환할 값이 없다
		  // String : String 자료형 값을 가지고 돌아간다.
		
		System.out.println("\n*******회원 가입 기능*******");
		
		System.out.print("아이디 : ");
		String memberIdid = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPwpw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2pw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberNamename = sc.next();
		
		System.out.print("나이 : ");
		int memberAgeage = sc.nextInt();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		
		if(memberPwpw.equals(memberPw2pw2)) { // String = equals
			
			// 입력받은 정보를 이용해서 Member 객체를 생성한 후
			// 생성한 객체의 주소를 필드에 있는 memberInfo에 대입
			
			memberInfo = new Member(memberIdid, memberPwpw, memberNamename, memberAgeage);
			// 비번 같으면 성공 -> 저장해야되니까 memberinfo 변수 null;로 생성해주고
			// memberinfo 변수에 signUp 안 객체 생성해서 매개변수로 대입
			// Member 클래스에 있는 매개변수 생성자 (메서드) 사용
			// 전달받은 값이 생성자 {} 끝나면 없어져야되는데
			// this 써서 member의 필드로 옮김. 값이 없어지지 않음
			
			//입력받은값 -> 매개변수 public member의 객체 생성(매개변수로 받음)
			
			return "회원 가입 성공";
			
		}else { // 불일치
			
			return "회원 가입 실패 (비밀번호가 일치하지 않습니다.)";
		}	
	}

	// 로그인 메서드(기능)
	
	public String login() {
		  //반환형
		
		System.out.println("\n***** 로그인 *****");
		
		// 회원 가입을 했는지 부터 확인
		// => memberInfo가 객체를 참조하고 있는지 확인
		
		if(memberInfo == null) { // 회원가입을 먼저 안한 경우 // null = 아무것도 참조하고 있지 않음
			return "회원 가입부터 진행 해주세요.";
		} // else 적지 않아도 아래 코드들이 else 역할을 함.
		
		System.out.print("아이디 입력 : ");
		String memberIdidid = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPwpwpw = sc.next();
		
		
		// 회원 가입 정보 (memberInfo가 참조하는 Member 객체)에서 
		// 저장된 아이디, 비밀번호가 
		// 입력된 아이디, 비밀번호와 같으면 " 로그인 성공 "
		// 같지 않으면 " 아이디 또는 비밀번호가 일치하지 않습니다. "
		if(memberIdidid.equals(memberInfo.getMemberId()) 
		&& memberPwpwpw.equals(memberInfo.getMemberPw())) {
		//입력받은 memberIdidid와 memberInfo필드에서 참조중인 Member객체의 memberId가 같은지 확인
			
				// 아이디 비번이 모두 일치할 경우
					loginmember = memberInfo;
				//     참조형      Member 객체 주소 (얕은 복사)
					
				// 회원 가입 정보를 loginmember에 대입하여
				// 어떤 회원이 로그인 했는지 구분할 수 있게 함
					
				return	loginmember.getMemberName() + "님 환영합니다.";
					
		}else {
				return "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
	}


	// 회원 정보 조회 기능
	public String selectMember() {
		
		System.out.println("***** 회원 정보 조회 *****");
		
		// 1) 로그인 여부 확인 -> 필드 loginmember가 참조하는 객체가 있는지 확인
		if(loginmember == null) {return "로그인 후 이용 해주세요.";} // null은 스트링값 아니라 equals아님
		// return 구문이 수행되면 해당 메소드는 즉시 종료되고 호출한 곳으로 돌아감
		
		// 2) 로그인이 되어있는 경우
		//    회원 정보를 출력할 문자열을 만들어서 반환(return)
		//    단, 비밀번호는 제외한다.
		
		// 이름 : 유저일
		// 아이디 : user01
		// 나이 : 25
		
		String str = "이름 : " + loginmember.getMemberName();
		str += "\n아이디 : " + loginmember.getMemberId();
		str += "\n나이 : " + loginmember.getMemberAge() + "세";
		// String 	edu.kh.oop.method.model.vo.Member.getMemberName()
		//  반환형                    메소드 코드 위치
			return str;
		
	}

	// 회원 정보 수정(update) 기능
	
	public int updateMember() {
		
		System.out.println("\n***** 회원 정보 수정 *****");
		
		// 1) 로그인 여부 판별
		
		//    로그인이 되어있지 않으면 -1 반환
		if(loginmember == null) {return -1;} // 반환값 int
		
		// 2) 수정할 회원 정보 입력 받기(이름, 나이)
		
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		
		
		
		// 3) 비밀번호를 입력 받아서
		//    로그인한 회원의 비밀번호와 일치한지 확인
		
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next(); // next로도 가능
		
		// 4) 비밀번호가 같은 경우
		// 로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경 후
		// 1 반환
		
		// 5) 비밀번호가 다를 경우 0 반환
		
		if(inputPw.equals(loginmember.getMemberPw() ) ) { 
			
			loginmember.setMemberName(inputName);
			// 입력받은 inputName을
			// loginmember가 참조하는 Member 객체의 필드 memberName에 대입.
			loginmember.setMemberAge(inputAge);
			return 1;
			
			
			}else {return 0;}
		
		
		
		
		
		
}
	











}
