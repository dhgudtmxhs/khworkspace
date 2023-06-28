package edu.kh.inheritance.practice.model.vo;

public class Person {

	private	String name;
	private	int age;
	private	double height;
	private	double weight;
	
	Person(){}
	Person(int age, double height, double weight){// name 필드는 초기화해주지않는다.
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return age + " / " + height + " / " + weight ;
	}
	
	public String getName() {	
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
