package kh.edu.updown.collection.model.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
   
   private Scanner sc = new Scanner(System.in);

   public void startGame(Member loginMember) {
      
      System.out.println("[Game Start...]");
      
  	  int random = (int)(Math.random() * 100 + 1);
      
  	  int count = 0;
  	  
  	  try {
  	  
  	  while(true) {
  		  
  		  count++;
  		  
  		  System.out.print(count + "번 째 입력 : ");
  		  int input = sc.nextInt();
  		  sc.nextLine();
  		  
  		  if(input == random) {
  			  System.out.println("정답입니다.");
  			  System.out.println("입력 시도 횟수 : " + count);
  		  
  		  
  		  if(loginMember.getHighScore() == 0 || loginMember.getHighScore() > count) {
  			  System.out.println("최고기록 달성");
  			  loginMember.setHighScore(count);
  		  }
  		  	  break;
  		  }
  		  else {
  		  
  		  if(random > input) {
  			  System.out.println("--UP--"); 
  		  
  		  }else {
  			  System.out.println("--Down--");
  		  }
 
  		  }
  	  }
  	  }catch(InputMismatchException e) {
  		  System.out.println("1~100 사이 정수만 입력해주세요.");
  		  sc.nextLine();
  		  e.getStackTrace();
  	  }
}

   public void selectMyInfo(Member loginMember) {
      
      System.out.println("[내 정보 조회]");
      
      System.out.println(loginMember.getMemberId() + " / " +loginMember.getMemberPw() + " / " +
      loginMember.getMemberName() + " / " +loginMember.getHighScore() );
      
      
      
   }

   public void selectAllMember(List<Member> members) {
      
      System.out.println("[전체 회원 조회]");
      
      for(Member m : members) {
    	  System.out.println(m);
      }
      
      
   }
   
   public void updatePassword(Member loginMember) {
      
      System.out.println("[비밀번호 변경]");
      
      System.out.print("비밀번호 확인 :");
      String input = sc.next();
      
      if(input.equals(loginMember.getMemberPw())) {
    	  System.out.print("변경할 비밀번호 입력 : ");
    	  String input1 = sc.next();
    	  
    	  System.out.print("비밀번호 확인 : ");
    	  String input2 = sc.next();
    	  
    	  if(input1.equals(input2)) {
    		 
    		 loginMember.setMemberPw(input1);
             System.out.println("비밀번호가 변경되었습니다.");
             
    	  }else {
    		  System.out.println("변경할 비밀번호가 일치하지 않습니다.");
    	  }
    	  
      }else {
    	  System.out.println("비밀번호가 일치하지 않습니다.");
      }
      
   }

   
   
}