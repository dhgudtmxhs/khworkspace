package kh.edu.updown.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class MainService {

	private Scanner sc = new Scanner(System.in);
	
	// 회원 가입된 회원의 정보를 저장할 배열 선언 및 할당
	private Member[] members = new Member[3];  
	
	private int memberCount = 0; // 현재 가입한 회원 수 (회원 가입 시 members 인덱스 지정에 사용 가능)
	
	// 현재 로그인한 회원의 정보를 참조할 변수 선언.
	private Member loginMember = null; // 로그인 X == null,  로그인 O != null
	
	// LoginService 생성
	// -> 로그인 시 이용할 수 있는 기능만을 모아둔 객체
	private LoginService loginService = new LoginService();
	
	
	// 메뉴 출력 메소드
	// * 메뉴 출력 메소드를 분석해보세요!
	public void displayMenu() {

		int sel = 0; // 메뉴 선택용 변수
		
		do {
			try {
				
				System.out.println();
				System.out.println("=== UP/DOWN 게임 ===");
				
				
				if(loginMember == null) { // 로그인이 되어있지 않은 경우
				
					System.out.println("[메인 메뉴]");
					System.out.println("1. 회원가입");
					System.out.println("2. 로그인");
					System.out.println("0. 종료");
					System.out.print("메뉴 선택 >> ");
					
					sel = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행문자 제거
					System.out.println(); // 줄바꿈
					
					switch(sel) {
					case 1 : signUp(); break;
					case 2 : login(); break;
					case 0 : System.out.println("[프로그램 종료]"); break;
					default : System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
					}
					
				
				}else { // 로그인이 되어있는 경우
					
					System.out.println("[로그인 메뉴]");
					System.out.println("1. 업/다운 게임 start");
					System.out.println("2. 내 정보 조회");
					System.out.println("3. 전체 회원 조회");
					System.out.println("4. 비밀번호 변경");
					System.out.println("9. 로그아웃");
					System.out.println("메뉴 선택 >> ");
					
					sel = sc.nextInt();
					sc.nextLine();
					System.out.println();
					
					
					// 선택된 메뉴 번호에 따라 LoginService에서 알맞은 기능을 호출
					switch (sel) {
					case 1: loginService.startGame(loginMember); break;
					case 2: loginService.selectMyInfo(loginMember); break;
					case 3: loginService.selectAllMember(members); break;
					case 4: loginService.updatePassword(loginMember); break;
					
					case 9 : System.out.println("[로그아웃 되었습니다.]"); 
							 loginMember = null; // loginMember 필드에 아무것도 참조하고 있지 않음을 의미하는 null을 대입
							 break; // loginMember 안쓰면 로그아웃 했을 때 존재하지 않는 객체가 된다.
					
					default: System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
					}
					
				}
				
			}catch (InputMismatchException e) {
				System.out.println("정수만 입력해주세요.");
				sc.nextLine(); // 버퍼에 남아있는 문자열 제거
			}
		}while(sel != 0);
		
	}
	
	// [회원 가입]
	// 아이디, 비밀번호, 이름을 입력 받고
	// Member객체를 생성하여 members 리스트에 추가
	// 단, 이미 중복되는 아이디가 존재하는 경우 가입 불가
	
	public void signUp() { 
		
		
		
		
		System.out.println("[회원 가입]");
		
		// memberCount가 members 배열 길이 이상인 경우
		if(memberCount >= members.length) {
			System.out.println(" 인원 수 초과로 인해 회원 가입 불가능합니다. ");
		
		}else { // 회원가입 가능
			
			String memberId = null; // 아이디 저장할 변수

			boolean flag = true; // 중복 아이디 체크용 변수 // 얘를 while문 안에 넣어도 가능
			
			while(true) {
				
				System.out.print("아이디 : ");
				memberId = sc.next();
				
				for(int i = 0; i < members.length; i++){
							
					flag = true; //boolean flag = true; 얘를 while문 안 처음에 넣어도 가능
							
					if(members[i] != null) { // members 배열 요소가 null이 아닌 경우 == 회원 정보가 있는 경우
						
						if(memberId.equals(members[i].getMemberId())) {
							System.out.println("중복되는 아이디 입니다. 다시 입력해주세요.");
							flag = false;
							break;
						}
					
					}else { // members 배열 오소가 null인 경우 == 회원 정보가 없는 경우
						break; // 중복 검사 for문 종료
					}
					
				}// for문 끝
				
				if(flag) { // 중복되는 아이디가 없는 경우
					break; // 아이디를 반복적으로 입력받는 while문 종료
				}
			
			}// while 문 끝
		
		// 아이디 끝, 비밀번호 입력받기
			
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
			
			System.out.print("비밀번호 확인 : ");
			String memberPw2 = sc.next();
			
			System.out.print("이름 : ");
			String memberName = sc.next();
			
			// 입력받은 값으로 새로운 Member 객체를 생성하고 members 배열의 요소 중
			// memberCount번째 요소가 참조할 수 있도록 주소를 저장한다.
			
			if(memberPw.equals(memberPw2)) {
			members[memberCount] = new Member(memberId, memberPw, memberName);
			memberCount++;
			
			System.out.println(" 회원 가입이 완료되었습니다.");
			}else {
				System.out.println("회원가입 실패. 비밀번호가 다릅니다.");
			}
			
		} // 처음 else의 끝

	} // signUp 메소드의 끝 
	
	
	// [로그인]
	// 아이디, 비밀번호를 입력 받아 일치하는 회원이 members에 있을 경우 로그인
	// 없으면 "아이디 또는 비밀번호가 일치하지 않습니다." 출력
	public void login() {
		
		System.out.println("[로그인]");
		
		System.out.print("아이디 : ");
		String inputId = sc.next();
		
		System.out.print("비밀번호 : ");
		String inputPw = sc.next();
		
		
		for(int i = 0; i < members.length; i++) {
			
			if(members[i] != null) {
				
				if(inputId.equals(members[i].getMemberId()) && inputPw.equals(members[i].getMemberPw())) {
				
					loginMember = members[i]; // 얕은 복사 == 같은 객체를 바라보게 됨. 같은 memberId, memberPw, memberName를 갖게 되는것
					
					System.out.println(members[i].getMemberName() + "님 환영합니다.");
				
					
				}
				
			}else { // members 배열 요소가 null인 경우 == 회원 정보가 없는 경우
				break;
			}
					
		} // end for
		
		// 아이디, 비밀번호를 비교한 후에도 loginMember 필드가 null 인 경우 -> 로그인 실패
		if(loginMember == null) { // 로그인 멤버에 안담겼다 -> 아이디 비번이 일치하는 경우가 없었다.
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			
		}
	}
		
}
