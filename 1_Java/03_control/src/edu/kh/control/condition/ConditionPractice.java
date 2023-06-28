package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionPractice {

   public void ex1() {
      //키보드로 입력 받은 정수가 양수이면서 짝수일 때만 “짝수입니다.”를 출력하고
      //짝수가 아니면 “홀수입니다.“를 출력하세요.
      //양수가 아니면 “양수만 입력해주세요.”를 출력하세요.
   
      Scanner sc = new Scanner(System.in);
      
      System.out.print("숫자를 한 개 입력하세요 : ");
      int a = sc.nextInt();
      String abc;
      
      if(a<0){
         abc = "양수만 입력해주세요.";
      }else if(a % 2 !=0){
         abc = "홀수입니다.";
      }else {
         abc = "짝수입니다.";
      }
         System.out.print(abc);
   }
   
   public void ex2() {
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("국어점수 : ");
      int k = sc.nextInt();
      
      System.out.print("수학점수 : ");
      int m = sc.nextInt();
      
      System.out.print("영어점수 : " );
      int e = sc.nextInt();
      
      int total = k+m+e;
      double avg = total/3; 
      String xxx;
   
      if(k>=40 && m>=40 && e>=40 && avg>=60) {
         System.out.printf("국어 : %d%n수학 : %d%n영어 : %d%n합계 : %d%n평균 : %d%n", k, m, e, total, avg);
         xxx = "축하합니다, 합격입니다!";
         
      }else {
         xxx = "불합격입니다.";
      }
      System.out.println(xxx);
   }

      public void ex3() {
         //1~12 사이의 수를 입력 받아 해당 달의 일수를 출력하세요.(2월 윤달은 생각하지 않습니다.)
         //잘못 입력한 경우 “OO월은 잘못 입력된 달입니다.”를 출력하세요. (switch문 사용)
      
      Scanner sc = new Scanner(System.in);   
      
      System.out.print("1~12 사이의 정수 입력 :");   
      int month = sc.nextInt();
      int day = 0;
      
      switch(month) { 
      case 1 : case 3: case 5: case 7 : case 8 : case 10 : case 12: day = 31; break;
      
      case 4: case 6: case 9: case 11 : day = 30; break;   
      
      default : System.out.println(month + "월은 잘못 입력된 달입니다.");return; //?
      }
      System.out.printf("%d 월은 %d 일까지 있습니다.", month, day);
      
      // default 뒤 return 안쓰면 밑에 if문을 넣어서 가능
      
      
      /* sysout ("1~12")
       * int month = sc.nextInt();
       * string day;
       * 
       * case 1, ... : day = month + "월은 31일 까지 있습니다."; break;
       * case 4, ... : day = month + "월은 30일 까지 있습니다."; break;
       * default : month = " 월은 잘못 입력된 달입니다"; break;
       * 
       * system.out.println(day);
       */
      
      }
      public void ex4(){
      
         //키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
         //저체중/정상체중/과체중/비만을 출력하세요.
      
         /*BMI = 몸무게 / (키(m) * 키(m))
               BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
               BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
               BMI가 30이상일 경우 고도 비만
         */
      
         Scanner sc = new Scanner(System.in);
      
      System.out.print("키를 입력해 주세요. : ");
      double cm = sc.nextDouble();
      
      System.out.print("몸무게를 입력해 주세요. : ");
      double kg = sc.nextDouble();
      
      double m = cm/100;
      double bmi = kg / (m * m);
      
      System.out.println("bmi 지수 : " + bmi);
      String b;
      
      if(bmi >=30) {
         b = "고도비만";
      }else if(25 <= bmi && bmi <30){
         b = "비만";
      }else if(23 <= bmi && bmi <25){
         b = "과체중";
      }else if(bmi < 18.5) {
         b = "저체중";
      }else {
         b = "정상체중";
      }
      System.out.print(b);
      }

   public void ex5() {
      /*중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
      평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
      이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
      70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
      */
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("중간 고사 점수 : "); 
      int middleexam = sc.nextInt();
      
      System.out.print("기말 고사 점수 : ");
      int finalexam = sc.nextInt();
      
      System.out.print("과제 점수 : ");
      int project = sc.nextInt();

      System.out.print("출석 횟수 : ");  //double 5x20x0.2 로 표현 가능함 double로 표현했다면 attend *= 5 * 0.2;
      int attend = sc.nextInt();
      
      System.out.println("=============결과==============");
   
      double me = middleexam * 0.2;   // 애초에 middleexam을 double로 쓰면 middleexam *= 0.2 로 표현가능
      double fe = finalexam * 0.3;
      double pj = project * 0.3;
      double total = me + fe + pj + attend;
      // 처음부터 double로 정의, 위에 double 처리할때 그냥 project *= 0.3; 식으로 표현
      String score;
      
      if(attend <= 20 * (1 - 0.3)) { 
    	  // 20 * (1 - 0.3) 으로 표현가능 (30%이상 결석) // => 70% 미만 출석 
         System.out.printf("Fail [출석횟수부족 (%d/20)]%n", attend);
      
      }else {

     /* System.out.println("중간 고사 점수(20) : " + me); ////////// printf 써서 %.1f로 표현하는 게 더 좋은듯
      System.out.println("기말 고사 점수(20) : " + fe); // 중간 고사 점수(20) : 13.200000000000001 이런식으로 나와버림
      System.out.println("과제 점수(30) : " + pj);
      System.out.println("출석 점수(20) : " + attend);
      System.out.println("총점 : " + total);    
      */
    	  System.out.printf("중간 고사 점수(20) : %.1f%n" , me); 
          System.out.printf("기말 고사 점수(20) : %.1f%n" , fe); 
          System.out.printf("과제 점수(30) : %.1f%n" , pj);
          System.out.printf("출석 점수(20) %d%n", attend);
          System.out.printf("총점 : %.1f%n", total);      
      
      
      if(total >= 70) {
         score = "pass";
      }else {
         score = "Fail [점수미달]";
      }
      System.out.println(score);
      }
   
   }
} 