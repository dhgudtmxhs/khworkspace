/*
 * package practice;
 * 
 * public class A{
 * 
 * private B b;
 * 
 * }
 * 
 * public class B{
 * 
 * private String f1; private int f2;
 * 
 * }
 * 
 * public class Test1{
 * 
 * private Test2 t2;
 * 
 * public Test3 method1() {
 * 
 * Test3 t3 = new Test3(); return t3; } }
 * 
 * public class Test2{
 * 
 * private int f1; }
 * 
 * public class Test3{ private String str;
 * 
 * public String getStr() { return str; }
 * 
 * public void setStr(String str) { this.str = str; }
 * 
 * }
 * 
 * 
 * public abstract class Parent{
 * 
 * public void parentMethod() {
 * 
 * }
 * 
 * protected abstract void print();
 * 
 * }
 * 
 * public class Child extends Parent{
 * 
 * private String name;
 * 
 * public void childMethod() {
 * 
 * }
 * 
 * protected void print() {
 * 
 * @Override }
 * 
 * }
 * 
 * 
 * 
 * 
 * public abstract class Shape{
 * 
 * public void draw() {} public void erase() {} public int getLength() {}
 * protected abstract double getArea();
 * 
 * }
 * 
 * public interface Resizable{
 * 
 * public void resize();
 * 
 * }
 * 
 * public class Triangle extends Shape implements Resizable{
 * 
 * public boolean isEquilateral() {}
 * 
 * public void resize() {
 * 
 * @Override
 * 
 * } }
 * 
 * public Rectangle implements Resizable{
 * 
 * public boolean isSquare() {}
 * 
 * public void resize() {
 * 
 * @Override
 * 
 * }
 * 
 * }
 */


/*
 * public class ClassRoom{
 * 
 * private Student std;
 * 
 * public ClassRoom(Student std){ this.std = std; } }
 * 
 * public class Student{
 * 
 * private String name;
 * 
 * private int age;
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * public class Library{
 * 
 * private Book book;
 * 
 * public Library(){ this.book = new Book(); } }
 * 
 * public class Book{ private String title; private String author; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public class Shop{
 * 
 * private Product product;
 * 
 * private Employee emp;
 * 
 * public shop(Product p){ this.p = p; this.emp = new Employee(); }
 * 
 * 
 * 
 * 
 * }
 * 
 * public class Product{
 * 
 * private String pName;
 * 
 * private int price;
 * 
 * }
 * 
 * 
 * public class Employee{
 * 
 * private String name; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * public abstract class Coffee{ public String beans;
 * 
 * }
 * 
 * 
 * public class CafeLatte extends Coffee{
 * 
 * private String temperature;
 * 
 * private int price;
 * 
 * public void drink(){ Option option = new Option(); }
 * 
 * }
 * 
 * public class Cafe{
 * 
 * private string name;
 * 
 * private String address;
 * 
 * private CafeLatte latte;
 * 
 * public Cafe(CafeLatte latte) { this.latte = latte; }
 * 
 * }
 * 
 * public class Option{ public int shot; public String ice; public int syrup; }
 * 
 * 
 */