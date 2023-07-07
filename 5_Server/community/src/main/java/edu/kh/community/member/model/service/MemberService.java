package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	/** 로그인 서비스
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception{

		// Connection 얻어오기
		Connection conn = getConnection();
		
		// DAO 수행
		Member loginMember = dao.login(mem, conn);
		
		// Connection 반환 (DAO에서 돌아왔을 때)
		close(conn);
		
		// 결과 반환
		return loginMember;
	}

	
	/** 회원가입 Service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	
	public int signUp(Member mem) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(mem, conn);
		
		// 트랜잭션 처리
		// result가 0인경우 -> DAO return 잘못쓰거나 insert 잘못하거나
		if (result > 0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
		
	}


}
