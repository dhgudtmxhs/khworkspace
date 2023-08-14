package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Service Interface 사용 이유

// 1. 프로젝트에 규칙성을 부여하기 위해서

// 2. 클래스간의 결합도를 약화시키기 위해서(객체 지향적 설계)

// 3. Spring AOP 사용을 위해서

public interface MemberService { // MemberService service = new MemberServiceImpl();, Impl2, Impl3, ... > 결합도 약화

	/** 로그인 인터페이스 메소드
	 * @param inputMember
	 * @return 조회된 멤버 또는 null
	 */
	Member login(Member inputMember); 
	
	/** 회원 가입 서비스(비밀번호 암호화 필요)
	 * @param inputMember
	 * @return result(0:실패, 1:성공)
	 */
	public int signUp(Member inputMember);
	
	
}
