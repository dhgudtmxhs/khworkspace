package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {

	public void homework() {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] arr = new Student[3];
		
		arr[0] = new Student("카리나", 20, 168.2, 70.0, 1, "정보시스템공학과");
		arr[1] = new Student("정해인", 21, 187.3, 80.0, 2, "경영학과");
		arr[2] = new Student("박서준", 23, 179.0, 45.0, 4, "정보통신공학과");
		
		/*for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);	
		}*/
		
		for(Student a : arr) {
			System.out.println(a);
		}
		// for(변수타입 변수명 : 원본배열명) {실행코드블럭}
		
		Employee arr2[] = new Employee[10];
		int count = 0;
		
		while(true) {
			
			System.out.println("============================================");
	
			System.out.print("이름 : ");
			String input = sc.next();
			
			System.out.print("나이 : ");
			int input2 = sc.nextInt();
			
			System.out.print("신장 : ");
			double input3 = sc.nextDouble();
			
			System.out.print("몸무게 : ");
			double input4 = sc.nextDouble();
			
			System.out.print("급여 : ");
			int input5 = sc.nextInt();
			
			System.out.print("부서 : ");
			String input6 = sc.next();
		
			arr2[count] = new Employee(input, input2, input3, input4, input5, input6);	
			count++;
			
			System.out.print("계속 추가하시겠습니까?? (y/n) : ");
			String input7 = sc.next();
			
			if(input7.equals("y")) {
				continue;
			}else if(input7.equals("n")) {
				break;
			}
				
			}
			System.out.println("============================================");
			
			for(int i = 0; i < count; i++) {
				System.out.println(arr2[i].toString());
			}
			
			
		}
	}

