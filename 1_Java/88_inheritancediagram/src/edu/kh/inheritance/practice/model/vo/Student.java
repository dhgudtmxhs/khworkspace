package edu.kh.inheritance.practice.model.vo;

public class Student extends Person{

	private int grade; 		// 학년
	private String major;	// 전공
	
	public Student(){}
	public Student(String name, int age, double height, double weight, int grade, String major){ 
		// name 값은 부모 필드 값에 직접 접근해서 초기화
		//  age, height, weight는 부모 생성자를 통해 초기화
		
		super(age, height, weight); 
		//this.setAge(age);
		//this.setHeight(height);
		//this.setWeight(weight); //

		this.setName(name);
		
		this.grade = grade;
		this.major = major;
		
		
	}

	@Override
	public String toString() {
		return getName() + " / " + super.toString() + " / " + grade + " / " + major ;
	}

	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
	
	
}
