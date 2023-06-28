package edu.kh.inheritance.practice.model.vo;

public class Employee extends Person{

	private int salary;
	private String dept;
	
	public Employee(){}
	
	public Employee(String name, int age, double height, double weight, int salary, String dept){
			// name 값은 부모 필드 값에 직접 접근해서 초기화
			// age, height, weight는 부모 생성자를 통해 초기화
		super(age, height, weight); // age,height,weight 필드 초기화
		this.setName(name); // private
		this.salary = salary;
		this.dept = dept;
		
	}
	
	@Override
	public String toString() {
		return getName() + " / " + super.toString() + " / " + salary + " / " + dept;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
	
	
}
