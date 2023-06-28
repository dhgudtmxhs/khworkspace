package edu.kh.objarray.practice.model.service;

import java.util.Scanner;

import edu.kh.objarray.practice.model.vo.Student;

public class PracticeService {

	public void start() {
	
		Scanner sc = new Scanner(System.in);
		
		Student[] arr = new Student[10]; //
		
		int people = 0;

		String ans;
		
		do{
			System.out.print("학년 : ");
			int grade = sc.nextInt();
			
			System.out.print("반 : ");
			int classroom = sc.nextInt();
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("국어점수 : ");
			int kor = sc.nextInt();
			
			System.out.print("영어점수 : ");
			int eng = sc.nextInt();
			
			System.out.print("수학점수 : ");
			int math = sc.nextInt();
		
			arr[people] = new Student(grade, classroom, name, kor, eng, math);
			people++;
			
			if(people == arr.length) {
				break;
			}
			
			System.out.print("계속 입력하시겠습니까? (y/n) : ");
			ans = sc.next();
					
			if(!ans.equals("y") && !ans.equals("n")) {		
				
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.print("다시 계속 추가 하시겠습니까? (y/n) : ");
				String ans2 = sc.next();
				
				if(ans2.equals("y")) {
					continue;
				}else if(ans2.equals("n")) {
					break;
				}
			}
			
			else if( ans.equals("y")) {
				continue;
			}
			
			else if (ans.equals("n")) {
			
				for(int i = 0; i < people; i++) {
			System.out.println(arr[i].toString());
					
			}
			}
			
		}while(people < arr.length && !ans.equals("n"));
		
	}
	
}
	
