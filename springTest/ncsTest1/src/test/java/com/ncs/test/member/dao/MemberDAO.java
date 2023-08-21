package com.ncs.test.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	/** login
	 * @param member
	 * @return loginMember
	 */
	public Member memberLogin(Member member) {
	
		return sqlsession.selectOne("memberMapper.loginMember", member);
	}

}
