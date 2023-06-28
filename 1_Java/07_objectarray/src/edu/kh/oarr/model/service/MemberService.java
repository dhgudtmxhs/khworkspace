package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	
		private Scanner sc = new Scanner(System.in);
	
		// Member 5칸짜리 객체 배열 선언 및 할당
		private Member memberArr[] = new Member[5]; // 배열을 참조하는 참조변수라 따로 인덱스 초기화를 해줘야 함
		
		// 현재 로그인 한 회원의 정보를 저장할 변수 선언
		private Member loginMember = null;
		
		public MemberService() { // 기본 생성자
			
			// memberArr 배열 0,1,2 인덱스 초기화
			memberArr[0] = new Member("user01", "pass01", "고경표", 30, "서울");
			memberArr[1] = new Member("user02", "pass02", "카리나", 22, "경기");
			memberArr[2] = new Member("user03", "pass03", "카즈하", 37, "강원");
			memberArr[3] = new Member();
			memberArr[3].setMemberId("user04"); 
			memberArr[3].setMemberPw("pass04"); 
			memberArr[3].setMemberName("강호동"); 
			memberArr[3].setMemberAge(50); 
			memberArr[3].setRegion("화천"); 
			// memberArr[4] 는 Null임
			
		}
	
public void displayMenu() { // 메뉴 화면 출력 기능
		
		int menuNum = 0;
		
		do { 
			
			System.out.println("\n===== 회원 정보 관리 프로그램 v2 =====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt(); 
			sc.nextLine(); 
			
			switch(menuNum) {
			
			case 1 : System.out.print(signUp()); break;
			case 2 : System.out.print(login());break;
			case 3 : System.out.print(selectMember());break; 
			case 4 : 
				int result = updateMember(); // int로 1, 0, -1 해서 이렇게 해야함
				
				if(result == -1) {
					System.out.println("로그인 후 이용 해주세요.");
				} else if ( result == 0) {
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				} else { //result == 1
					System.out.println("회원 정보가 수정되었습니다.");} break;
			
			case 5 : searchRegion(); break;
			
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");	
			}
		}while(menuNum != 0); // 0이 아닐 때 반복, 0이면 멈춘다
	}
	
	//회원가입 메소드

	public String signUp() {
		
		System.out.println("\n========== 회원가입 ==========");
		
		//객체 배열(memberArr)에 가입한 회원의 정보를 저장할 예정
		// -> 새로운 회원 정보를 저장할 공간이 있는지 확인하고
		//    비었으면 빈 공간의 인덱스 번호를 얻어온다. = 새로운 메소드 작성
		
		int index = emptyIndex(); // memberArr배열에서 비어있는 인덱스를 반환 받음
		
		System.out.println("현재 회원 수 : " + index); // 가입 가능한 회원수? 
		
		if(index == 5) {return "회원가입이 불가능합니다.(인원수 초과)";} //menuNum = 0일때 끝나는거고 여기서 끝낼 수가 없음 break; 안써짐
		// 비어있는 인덱스가 없는 경우 -> 더이상 집어넣을 공간이 없음 회원가입 불가능함
		
		System.out.print("아이디 : ");
		String memberIdid = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw1 = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberNameeeee = sc.next();
		
		System.out.print("나이 : ");
		int memberAgeeeee = sc.nextInt();
		
		System.out.print("지역 : ");
		String region1 = sc.next();
		
		// 비밀번호, 비밀번호 확인 일치 시 회원가입 시키기
		if(memberPw1.equals(memberPw2)) { 
		
		// Member 객체를 생성해서 할당된 주소를 memberArr 비어있는 인덱스에 대입	
		memberArr[index] = new Member(memberIdid, memberPw1, memberNameeeee, memberAgeeeee, region1);
		// 배열 인덱스마다 다른 값이 저장될 수있게 함 //이 Member는 매개변수 생성자를 가리킴
			return "회원 가입 성공!";
		}
			return "회원가입이 불가능합니다.(인원수 초과)";
		
}
	
	
		// memberArr의 비어있는 인덱스 번호 반환하는 메소드
		// 단, 비어있는 인덱스가 없으면 -1 반환
		
		public int emptyIndex() {
			
			//memberArr 배열을 0번 인덱스부터 끝까지 접근해서
			//참조하는 값이 null인 경우(참조하는 게 없을 경우) 인덱스 반환해라
			
			for(int i = 0; i < memberArr.length; i++) {
				
				if(memberArr[i] == null) {return i;} // return = 현재 메소드를 종료하고 호출한 곳으로 i값을 가지고 돌아감
													 // 0이 null 이면 0을 반환함. 그럼 signUp의 int index = emptyIndex();
													 // do while입력한거 case로 [0] 쌓고 다시 입력할 때는 memberArr[0] 은 null 이 아니어서 memberArr[1] = 1을 반환함. 계속 반복 길이보다 작을 때 까지.
													 // 그래서 memberArr[index] = new Member(memberIdid, memberPw1, memberNameeeee, memberAgeeeee, region1);
													 // 는 [0]부터 [4]까지 쌓이는 식임. 콘솔창에 입력하는 대로 쌓인다는 것
			}
			return 5; // for문을 수행했지만 return이 되지 않은 경우 = 다돌았는데 하나도 null인게 없을때 수행 5 = 배열 길이
	}
		
		public String login() {
			
			System.out.println("\n========== 로그인 ==========");
			
			System.out.print("아이디 입력 : ");
			String memberIdidid = sc.next();
			
			System.out.print("비밀번호 입력 : ");
			String memberPwpw1 = sc.next();
			
			// 1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
			for(int i = 0; i < memberArr.length; i++) {
				
				if(memberArr[i] != null) { // 회원의 정보가 있을 경우
					
						if(memberArr[i].getMemberId().equals(memberIdidid) &&
							memberArr[i].getMemberPw().equals(memberPwpw1)) {
							
							// 2) 회원 정보(memberArr[i] 의 아이디, 비밀번호와
							// 입력 받은 아이디(memberIdidid), 비밀번호(memberPwpw1)가 같은지 확인
							
							// 3) 로그인 회원 정보 객체(Member)를 참조하는 변수 loginMember에
							// 현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사
							loginMember = memberArr[i]; // 뒤에서 loginMember 쓸라고 주소를 복사 = 배열의 값 참조
							
							// 더 이상 같은 아이디, 비밀번호가 없기 때문에 for문 종료
							break;
						
						}
					
				}
			} 
		
			// 4) 로그인 성공/ 실패 여부에 따라 결과 값을 반환
			if(loginMember == null) { // 로그인 실패
				return "아이디 또는 비밀번호가 일치하지 않습니다.";
			}else { // 로그인 성공
				return loginMember.getMemberName( )+ "님 환영합니다.";
			}

		}
	
	
		// 회원 정보 조회 메소드
		public String selectMember() {
			
			System.out.println("\n========== 회원 정보 조회 ==========");
			
			// 1) 로그인 여부 확인
			// 로그인이 안되어 있으면 로그인 후 이용해주세요 출력
			if(loginMember == null) {return "로그인 후 이용해주세요.";}
			
			// 로그인이 되어있는 경우
			// 회원 정보를 출력할 문자열을 만들어서 반환
			// 단, 비밀번호는 제외
			
			//이름 : 유저일
			//아이디 : user01
			//나이 : 25세
			//지역 : 서울
			
			String str = "이름 : " + loginMember.getMemberName();
			str += "\n아이디 : " + loginMember.getMemberId();
			str += "\n나이 : " + loginMember.getMemberAge() + "세";
			str += "\n지역 : " + loginMember.getRegion();
			
			return str;
			
		}
		
		//회원 정보 수정 메서드

		public int updateMember() {
			
			System.out.println("\n========== 회원 정보 수정 ==========");
			
			// 1) 로그인 여부 판별
			//    로그인이 되어있지 않으면 -1 반환
			if(loginMember == null) {return -1;}
			
			// 2) 수정할 회원 정보 입력 받기(이름, 나이, 지역)
			System.out.print("수정할 이름 : ");
			String name = sc.next();
			
			System.out.print("수정할 나이 : ");
			int age = sc.nextInt();
			
			System.out.print("수정할 지역 : ");
			String region = sc.next();
			
			
			// 3) 비밀번호를 입력 받아서
			//    로그인한 회원의 비밀번호와 일치한지 확인
			System.out.print("비밀번호를 입력하세요.");
			String Pw = sc.next();
			
			if(Pw.equals(loginMember.getMemberPw()) ) {
				
			// 4) 비밀번호가 같을 경우
			//    로그인한 회원의 이름, 나이 지역 정보를 입력 받은 값으로 변경 후
			//    1 반환	
				 
				loginMember.setMemberName(name);
				loginMember.setMemberAge(age);
				loginMember.setRegion(region);
				
				return 1;
			
			// 5) 비밀번호가 다를 경우 0 반환
			
			}else{return 0;}
			
			
		}
		
		// 회원 검색 (지역) 메소드
		public void searchRegion() {
			
			boolean flag = true; // 검색 결과 신호용 변수
			
			System.out.println("\n=========== 회원 검색(지역) ===========");
			System.out.print("검색할 지역을 입력하세요 : ");
			String inputRegion = sc.next();
			
			// 1) memberArr 배열의 모든 요소 순차 접근
			
			for(int i = 0; i < memberArr.length; i++) {
			
			// 2) memberArr[i]의 요소가 null인 경우 반복 종료
			
			if(memberArr[i] == null) {break;}
			
			// 3) memberArr[i]의 요소에 저장된 지역(getReigon())이
			//    입력 받은 지역과(region)과 같을 경우(equals), 회원의 아이디, 이름을 출력한다.
			
			else if(memberArr[i].getRegion().equals(inputRegion)) {
				
			System.out.printf("아이디 : %s, 이름 : %s%n", memberArr[i].getMemberId(), memberArr[i].getMemberName());
				flag = false;
			}
			
			}
			if(flag) {
				System.out.print("일치하는 검색 결과가 없습니다.");
			// 4) 검색 결과가 없을 경우 "일치하는 검색 결과가 없습니다." 출력
			
				
		}
		
		
		
		
		
		
		
		
		
		
		
}
}
