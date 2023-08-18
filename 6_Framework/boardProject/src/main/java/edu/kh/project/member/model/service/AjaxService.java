package edu.kh.project.member.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dto.Member;



@Service // service임을 명시 + bean 등록
public interface AjaxService {

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	/** 닉네임으로 전화번호 조회
	 * @param inputNickname
	 * @return memberTel
	 */
	String selectMemberTel(String nickname);

	/** 이메일 중복검사
	 * @param email
	 * @return email
	 */
	int emailDupCheck(String email);

	/** 닉네임 중복검사
	 * @param nickname
	 * @return nickname
	 */
	int nickDupCheck(String nickname);

	/** 이메일로 회원 정보 조회
	 * @param email
	 * @return member
	 */
	Member selectMember(String email);


	/** 이메일이 일부라도 일치하는 모든회원 조회
	 * @param input
	 * @return memberList
	 */
	List<Member> selectMemberList(String input);

	
	
	
}
