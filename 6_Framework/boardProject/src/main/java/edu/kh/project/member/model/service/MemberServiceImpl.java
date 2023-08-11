package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer(class)
		 // 비즈니스 로직(데이터 가공, dao 호출, 트랜잭션 제어) 처리하는 클래스라고 명시
		 // 어노테이션 작성하면 Bean 등록 <context:component-scan base-package="edu.kh.project" /> 가 Bean으로 등록해줌
public class MemberServiceImpl implements MemberService{

	// private MemberDAO dao = new MemberDAO(); <- 원래 하던건데 이미 스프링이 Bean으로 등록함
	
	// Autowired : 작성된 필드와
	// Bean으로 등록된 객체 중 타입이 일치하는 Bean을
	// 해당 필드에 자동으로 주입(Injection)하는 어노테이션
	// == DI(Dependency Injection, 의존성 주입)
	// 	  -> 객체를 직접 만들지 않고 Spring이 만든걸 주입함(Spring에 의존)
	
	@Autowired
	private MemberDAO dao;

	@Autowired // bean으로 등록된 객체중 타입이 일치하는 객체를 DI 
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public Member login(Member inputMember) {
		
		// 암호화 추가 예정
		// System.out.println("암호화 확인 : " + bcrypt.encode( inputMember.getMemberPw() ) );
		
		// bcrypt 암호화는 salt가 추가되기 때문에
		// 계속 비밀번호가 바뀌게 되어 DB에서 비교 불가능!!!
		// -> 별도로 제공해주는 matches(평문, 암호문)을 이용해서 비교
		
		// dao 메소드 호출
		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우
			
			// 입력한 pw, 암호화된 pw가 같은지 확인 // sql문에서 암호화때문에 WHERE절로 확인 못해서 WHERE절 지우고 여기서 확인하는거
			if(bcrypt.matches(inputMember.getMemberPw(), 
							  loginMember.getMemberPw())) {
			
				loginMember.setMemberPw(null); // 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거해준다.
				
			} else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만들어줌
				
			}
			
		}
		
		return loginMember;
	}
	
}
