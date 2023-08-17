package edu.kh.project.member.model.service;

import org.springframework.stereotype.Service;



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

	
	
	
}
