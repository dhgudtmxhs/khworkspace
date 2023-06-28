package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

   
   
      public void ex1() {
      
      
      // 모든 사람이 사탕을 골고루 나눠가지려고 한다. 
      // 인원 수와 사탕 개수를 키보드로 입력 받고
      // 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은사탕의 개수를 출력하세요.
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("인원 수 : ");
      int people = sc.nextInt();
      
      System.out.print("사탕 개수 : ");
      int candy = sc.nextInt();
      
         
      System.out.printf("1인당 사탕 개수 : %d%n", (candy / people));
      System.out.printf("남는 사탕 개수 : %d%n", (candy % people));
      
      
   }

      public void ex2() {
         /*ex.
         이름 : 홍길동
         학년(정수) : 3
         반(정수) : 4
         번호(정수) : 15
         성별(남학생/여학생) : 남학생
         성적(소수점 아래 둘째 자리까지) : 85.75
         3학년 4반 15번 홍길동 남학생의 성적은 85.75점 입니다
         */
         
      Scanner sc = new Scanner(System.in);   
         System.out.print("이름 : ");
         String name = sc.nextLine();
         
         System.out.print("학년 : ");
         int grade = sc.nextInt();
                  
         System.out.print("반 : ");
         int cls = sc.nextInt();
         
         System.out.print("번호 : ");
         int num = sc.nextInt();
         
         sc.nextLine();
         
         System.out.print("성별 : ");
         String gender = sc.nextLine(); //next로 하는게 난듯
         
         
         System.out.print("성적(소수점 아래 둘째 자리까지) : ");
         double score = sc.nextDouble();
         
         System.out.printf("%d학년 %d반 %d번 홍길동 %s의 성적은 %.2f점입니다.%n", grade, cls, num, gender, score);
         // Scanner 클래스에서 nextInt() 메서드를 사용한 후에 nextLine() 메서드를 사용하면
         //입력 대기열에 개행 문자가 남아 있어 원하는 대로 입력을 받지 못하는 문제가 발생합니다. 
         //이를 해결하기 위해서는 nextInt() 메서드를 사용한 후에
         //nextLine() 메서드를 한번 더 호출하여 개행 문자를 제거해 주어야 합니다.
         
      }

      public void ex3() {
         
      //정수를 하나 입력받아 짝수/홀수를 구분하세요.(0은짝수)
         
         Scanner sc = new Scanner(System.in);
         System.out.print("정수 입력 : ");
         int i = sc.nextInt();
         String str;
         
         
         if(i%2 ==0) {
            str = "짝수입니다.";
         }else { // (i%2 !=0)
            str = "홀수입니다.";
         }
         System.out.println(str);
         
         
      }

      public void ex4() {
         
         /*국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고, 
         세 과목에 대한 합계(국어+영어+수학)와 평균(합계/3.0)을 구하세요.
         세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
         세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요.
         */
         
         Scanner sc = new Scanner(System.in);
         
         System.out.print("국어 : ");
         int k = sc.nextInt(); 
         
         System.out.print("영어 : ");
         int e = sc.nextInt();
         
         System.out.print("수학 : ");
         int m = sc.nextInt(); 
         String str1;
         
         int total = k+e+m;
         double avg = total / 3; 
         System.out.println("합계 : " + total);
         System.out.println("평균 : " + avg);
         
      /*   if(k<40 || e<40 || m<40 || avg <60.0) {
            str1 = "불합격";
         
         }else {
            str1 = "합격";
         }
      */
         
         if(k>=40 && e >=40 && m >=40 && avg >=60) {
        	 str1 = "합격";
         }else {
        	 str1 = "불합격";
         }
         System.out.println(str1);
      }



} 