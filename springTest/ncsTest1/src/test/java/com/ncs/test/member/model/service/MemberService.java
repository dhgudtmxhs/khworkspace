package com.ncs.test.member.model.service;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {

	/** login
	 * @param member
	 * @return loginMember
	 */
	Member memberLogin(Member member);
	
	
}
