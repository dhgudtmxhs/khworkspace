package edu.kh.oop.method.model.vo;

public class Member {

	// 필드(속성)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
	// 기본 생성자
	//public Member () {}; //매개변수 생성자가 하나 있으면 컴파일러가 자동으로 생성해주지 않음. 
	
	//매개변수 생성자 (필드를 모두 초기화하는 용도)

		
	public Member (String memberId, String memberPw, String memberName, int memberAge) { //오버로딩 적용
																						  //매개변수 개수 다름
	// 전달받은 값을 필드로 옮겨닮기.
	this.memberId = memberId; 
	this.memberPw = memberPw;
	this.memberName = memberName;
	this.memberAge = memberAge;

	}
	// 기능 (getter setter)
	// getter = get + 필드명
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	// 매개변수로 전달 받은 값을 memberName 필드에 대입
	// 매개변수 == 전달 받은 값을 지니고 있는 변수
	public void setMemberName(String memberName) {
		this.memberName = memberName; // setter도 set+필드명으로 작성
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}


}
