package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Child;
import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Parent;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		
		// 상속 확인
		// - Person을 상속 받은 Student가 Person의 필드, 메소드를 사용할 수 있는가?
		
		Person p = new Person();
	
		// p.name = "홍길동"; private이라 직접 접근 불가
		
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		System.out.println("dddd");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
	
		System.out.println("----------------------------------------");
		
		Student std = new Student();
		
		// Student 클래스 만의 고유한 메소드
		std.setGrade(3);
		std.setClassRoom(5);
		
		// Person에게 상속받아 Student 클래스가 갖고있는 메소드
		std.setName("고아라");
		std.setAge(19);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade() + "학년");
		System.out.println(std.getClassRoom() + "반");
		
		//Student가 Person의 메소드 뿐만 아니라 필드도 상속 받았는지 확인
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
	
		System.out.println("----------------------------------------");
		Employee e = new Employee();
		
		// Employee 꺼
		e.setCompany("KH정보교육원");
		
		// Person에게 상속받아 Employee가 갖고 있는 메소드
		e.setName("다나카");
		e.setAge(35);
		e.setNationality("일본");
	
		System.out.println(e.getCompany());
		
		System.out.println(e.getName());
		System.out.println(e.getAge());
		System.out.println(e.getNationality());
		
		System.out.println("----------------------------------------");
		
		p.breath();
		e.breath();
		std.breath();
	
	}
	
	public void ex2() {
		
		// super() 생성자 사용 방법
		
		// Student 매개변수 5개 짜리 생성자를 이용해서 Student 객체 만들고 참조변수는 std
		
		Student std = new Student("공유", 35, "한국", 1, 3);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
	}
	
	public void ex3() {
		
		// 오버라이딩 확인예제
		
		Student std = new Student();
		Employee emp = new Employee();
		
		std.move();;// 오버라이딩 안한거 -> Person의 메소드를 수행했다.
		
		emp.move();;// 오버라이딩 한거 -> Employee의 메소드를 수행했다.
	}
	
	public void ex4() {
		
		// 모든 클래스는 Object 클래스의 후손이다.
		// == 모든 클래스의 최상위 부모는 Object이다.
		
		// 1) Object 상속 여부 확인
		Person p = new Person(); // Object를 상속 받은 Person 객체를 생성
		
		Student std = new Student(); // Person을 상속 받은 student 객체 생성
		
		Scanner sc = new Scanner(System.in); 
		// Object -> Person -> Student (상속 관계)
		
		String str = "abc";
		
		
		// ** Object 상속과 단계적인 상속을 확인
		
		System.out.println(p.hashCode()); // Object에서 물려 받은 hashCode()
		
		System.out.println(std.getAge()); // Person에서 물려받은 getAge()
		
		System.out.println(std.hashCode());
		// Person이 Object에서 물려 받은 hashCode()를
		// Student가 또 물려 받아서 사용하고 있다.
		
		// -> 상속의 상속의 상속의 ... 상속 가능
		
		// * Object가 모든 클래스의 최상위 부모인지 확인
		
		System.out.println(sc.hashCode());
		// Object - hashCode()
		
		System.out.println(str.hashCode());
		// String - hashCode()
		// -> String이 Object에게 물려 받은 hashCode()를 오버라이딩 한 것.
	
	}
	
	public void ex5() {
		
		Person p = new Person("강호동", 50, "한국");
		
		System.out.println(p.toString()); // 자바의 약속같은것
		System.out.println(p); // = p.toString
		
		// print 구문 수행 시 참조 변수명을 작성하면
		// 자동으로 toString() 메소드를 호출해서 출력한다.
		
		Student std = new Student("윈터", 27, "미국", 2, 6);
	
		System.out.println(std.toString()); // string - person
		// 1) Student 클래스 toString() 오버라이딩 전
		// Person으로부터 상속받은 오버라이딩 된 toString을 수행한다.
		
		// 2) Student 클래스 toString 오버라이딩 후
		// Student의 toString 수행
		System.out.println(std); // = std.toString
		
		Employee emp = new Employee("김근로", 26, "한국", "OO증권");
		
		// 출력시 김근로 / 26 / 한국 / OO 증권이 나오게 해라.
		
		System.out.println(emp.toString());
		System.out.println(emp);
		
	}

	public void ex6() {
		
		Parent p = new Parent();
		Child c = new Child();
		
		p.method();
		c.method();
		
}

	
	
}
