package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean 등록(IOC, 스프링이 객체 관리 (제어의 역전) )
public class MyPageDAO {

	// 등록된 Bean 중 타입이 SqlSessionTemplate으로 일치하는 Bean을 찾아서 주입 (DI)
	// -> root-context.xml에 <bean> 작성됨
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 정보 수정 Service
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {
								// <update id="updateInfo" parameterType="Member">
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	// mybatis.config.xml에서 sqlSession bean으로 등록
	}

	
	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo) {
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}


	/** 비밀번호 변경
	 * @param newPw
	 * @param memberNo
	 * @return
	 */
	public int changePw(String newPw, int memberNo) { // encode(newPw) 매개변수명 newPw로 바꿔줬음

		// Mybatis에서 SQL 수행 시
		// 전달할 수 있는 파라미터는 무조건 하나다.
		// 지금처럼 여러 파라미터를 전달해야하는 경우에는
		// Map 또는 DTO로 묶어서 전달한다.
		
		Member mem = new Member();
		
		mem.setMemberPw(newPw);
		mem.setMemberNo(memberNo);
		
		return sqlSession.update("myPageMapper.changePw", mem);
	}


	/** 회원 탈퇴 처리
	 * @param memberNo
	 * @return
	 */
	public int secession(int memberNo) {
		// sqlSessionTemplat : 마이바티스 + DBCP + close자동 + 트랜잭션 처리
		return sqlSession.update("myPageMapper.secession", memberNo);
	}


	/** 프로필 이미지 수정
	 * @param loginMember
	 * @return result
	 */
	public int updateProfileImage(Member loginMember) {
		return sqlSession.update("myPageMapper.updateProfileImage", loginMember);
	}

	
	
	
	
}
