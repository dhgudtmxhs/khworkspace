package kh.edu.updown.model.service;

import java.nio.channels.MembershipKey;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	public void startGame(Member loginMember) {
		
		System.out.println("[Game Start...]");
		
		int random = (int)(Math.random() * 100 + 1);
		
		int input = 1;
		
	do {
		
		System.out.print((input++) + "번 째 입력 : ");
		int input2 = sc.nextInt();
		
		if(random > input2) {
			System.out.println("--- UP ---");
			continue;
		}else if(random < input2) {
			System.out.println("--- DOWN ---");
			continue;
		}else { // random == input2
			System.out.println("정답!!");
			System.out.println("입력 시도 횟수 : " + (input-1));
		}
		
		if(loginMember.getHighScore() == 0 || loginMember.getHighScore() > input-1) {
			System.out.println("***** 최고 기록 달성 *****");
			loginMember.setHighScore(input-1);
		}
		break;
	/*	if(loginMember.getHighScore() == 0 || loginMember.getHighScore() > count) { // 최초
			System.out.println("***** 최고 기록 달성 *****");
			
			// 매개변수로 전달 받은 loginMember의 highScore 필드에 시도 횟수 저장
			loginMember.setHighScore(count);
			
		}
		break; 이렇게 하는게 더 간단하고 맞음.
	*/	
		
		
	}while(true);
		
	
}

	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
	
		System.out.println("아이디 : " + loginMember.getMemberId() + "\n이름 : "+ 
		loginMember.getMemberName() + "\n최고점수 : " + loginMember.getHighScore() + "회");
	
	
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출럭
	public void selectAllMember(Member[] members) {
		
		System.out.println("[전체 회원 조회]");
		
		for(int i = 0; i < members.length; i++) {
			
			if(members[i] != null) {
			System.out.println(members[i].toString());
			
			}
		}

		
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		
		System.out.print("비밀번호 확인 : ");
		String input = sc.next();
		
		if(input.equals(loginMember.getMemberPw())) {
			
			System.out.print("변경할 비밀번호 입력 :");
			String input2 = sc.next();
			loginMember.setMemberPw(input2);
			
		}else {
			System.out.println("비밀번호가 틀립니다.");
		}
		
		
	}

	
	
}
