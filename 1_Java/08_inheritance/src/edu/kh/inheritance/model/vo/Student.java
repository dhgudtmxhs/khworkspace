package edu.kh.inheritance.model.vo;

public class Student extends Person {
	// Student 클래스에 Person 클래스 내용을 연장한다.
	// == Student 클래스에 Person 클래스 내용(필드, 메소드)을 추가하여 확장한다.
	
	// 상속
	// extends : 확장하다, 연장하다
	
	//필드
	private int grade;
	private int classRoom;
	
	// 기본 생성자
	public Student(){
		
		// Student() 객체 생성시
		// 내부에 상속받은 Person 객체를 생성하기 위한
		// Person 생성자 호출 코드가 필요하다!
		
		// super : 상위 <-> sub : 하위
		// super == Student의 상위, 부모 Person을 뜻한다.
		
		super(); // super 생성자 // 생성자는 상속이 되지 않음
		// 부모의 생성자를 호출하는 코드
		// 반드시 자식 생성자 최 상단에 작성되어야 한다.
		
		// super() 생성자 때문에
		// 자식 객체 내부에 부모 객체가 생성되는 것.
		
		// *** super 생성자 미 작성 시
		// 컴파일러가 컴파일 단계에서 자동으로 추가해준다.
		
	}
	
	// 매개변수 생성자
	public Student(String name, int age, String nationality, int grade, int classRoom) {
		
		// 전달받은 값 중 name, age, nationality
		// 부모 필드에 세팅하기
		
		//this.name = name; 불가능
		//상속받은 부모의 field(name)을
		//자식의 필드처럼 사용하려 했으나 오류가 발생한다. 
		
		//왜? 부모의 field 에 private 접근 제한자가 있어서
		//아무리 물려 받은 자식이라도 다른 객체이기  때문에 직접 접근 불가능
		// -> 간접 접근 방법을 사용
		
		//setName(name);
		//setAge(age);
		//setNationality(nationality); // 이 방법도 있지만 비효율적임
		
		super(name, age, nationality); // 부모 매개변수 생성자 호출
		
		this.grade = grade;
		this.classRoom = classRoom;
	}
		
	//메서드	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}	
	
	@Override
	public String toString() {
		
		// super 참조변수
		return super.toString() + " / " + grade + " / " + classRoom;
			 // 이름, 나이, 국적을 가져온다.
			 // return name + " / " + age + " / " + nationality; 을 가져온다.
	
	
	}
	
	
	
	
	
	
}