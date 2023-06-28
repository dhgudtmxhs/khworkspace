package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {

	
	public void practice() {
	
		
		Book a = new Book();
		
		Book b = new Book("자바의 정석", 30000, 0.2, "남궁성");
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		System.out.println("===============================");
	
		System.out.println("수정된 결과 확인");	
		
		a.setTitle("C언어");
		a.setPrice(30000);
		a.setDiscountRate(0.1);
		a.setAuthor("홍길동");
		System.out.println(a.toString());	
		
		System.out.println("===============================");
		
	
		 // 6) 각 객체의 할인율을 적용한 책 가격을 계산해서 출력
		// 7) 할인된 가격 = 가격 - (가격 * 할인율)
	
		System.out.println("도서명 = " + a.getTitle());
		System.out.println("할인된 가격 = " + (int)(a.getPrice() - (a.getPrice() * 0.1)) + "원");
		System.out.println("도서명 = " + b.getTitle());
		System.out.println("할인된 가격 = " + (int)(b.getPrice() - (b.getPrice() * 0.2)) + "원");
		
		
	}





}
