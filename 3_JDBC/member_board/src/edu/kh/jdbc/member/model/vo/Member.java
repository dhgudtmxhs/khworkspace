package edu.kh.jdbc.member.model.vo;

import java.sql.Date;

// VO(Value Object) : 값을 저장하는 용도의 객체
// -> 여러 값을 하나의 객체에 저장하여 매개변수 전달, 반환, 컬렉션 등에 이용할 수 있다.

public class Member {

	// 필드
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNm;
	private char memberGender;
	private Date enrollDate;
	private char secessionFlag; //DB에는 char타입이 없다. DATA_TYPE CHAR여도 문자열임 문자형이 아니고
	
	// 기본 생성자(필수)
	public Member() {}

	// 회원 가입용 생성자
	public Member(String memberId, String memberPw, String memberNm, char memberGender) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNm = memberNm;
		this.memberGender = memberGender;
		
	}

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

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getSecessionFlag() {
		return secessionFlag;
	}

	public void setSecessionFlag(char secessionFlag) {
		this.secessionFlag = secessionFlag;
	}

	public char getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNm="
				+ memberNm + ", memberGender=" + memberGender + ", enrollDate=" + enrollDate + ", secessionFlag="
				+ secessionFlag + "]";
	}

	
	
	
	
	
	
}
