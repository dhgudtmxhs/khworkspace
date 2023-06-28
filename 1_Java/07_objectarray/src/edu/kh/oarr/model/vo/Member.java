package edu.kh.oarr.model.vo;

public class Member {

	
	// 필드 ( == 멤버변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region; // 지역. 서울 경기 출북 전남
	
	Member arr[] = new Member[5];

	
	
	// 생성자
	public Member() {} // 클래스명과 같아야 하고 반환형 없음
	
	// 매개변수 생성자
	public Member(String memberId,String memberPw, String memberName, int memberAge, String region) {
		
		this.memberId = memberId; 
		this.memberPw = memberPw; // 매개변수 값 바꾸면 같은 이름이 아니라 구분되서 this 안써도 됨
		this.memberName = memberName; 
		this.memberAge = memberAge; 
		this.region = region;
	}
	
	
	// 메소드
	
	//getter setter
	
	//memberId
	
	public String getMemberId() {
		return this.memberId;  // return this.memberId지만 구분필요없어서 this 없는거
	} 		 																
	
	public void setMemberId(String memberId) {
	this.memberId = memberId; return;
    } 												// 모든 메소드는 종료시 호출한 곳으로 돌아가는 return 을 
									 				// 써야 하지만 void일 경우 생략 가능하다. 써도 오류 안남
									 				// 생략시 컴파일러가 자동으로 추가해 주는 원리
	public String getMemberPw() {
		return memberPw;
	} 
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public String getMemberName() {
		return memberName;
	} 
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	} 
	
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public String getRegion() {
		return region;
	} 
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	// public String getMemberName(){return this.memberName;}
	// public void setMemberName(){this.memberName = memberName; return;}
	
	// public int getMemberAge(){return memberAge;} // this 생략 가능 구분이 필요 없음
	// public void setMemberAge(){this.memberAge = memberAge;} // 구분필요해서 this 사용
															   // return 생략 가능 컴파일러 자동추가






}
