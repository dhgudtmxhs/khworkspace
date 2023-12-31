package edu.kh.jdbc.member.model.service;

// import static 구문 : static 메소드를 import 해서 
// 클래스명.static메소드() 형태에서 클래스명을 생략할 수 있게 하는 구문
// Connection conn = JDBCTemplate.getConnection(); 에서 JDBCTemplate 을 없애기
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.vo.Member;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;
// Service : 데이터 가공(요청에 맞는 데이터를 만드는 것)
//			+ 트랙잭션 제어 처리
//			-> 하나의 Service 메소드에서 n개의 DAO 메소드를 호출할 수 있다.
//			-> n개의 DAO에서 수행된 SQL을 한번에 commit/rollback 처리한다. 
// 			3개 dao 호출, 2개 성공 1개 실패 (하나라도 실패하면) rollback하고 다성공해야 commit

// *** Service에서 트랜잭션을 처리하기 위해서는 Connection 객체가 필요하다. ***
//	== Service에서 Connection 객체를 생성하고 반환 해야한다.

public class MemberService {

	// 회원 관련 SQL 수행 및 결과를 반환할 DAO 객체 생성 및 참조
	private MemberDAO dao = new MemberDAO();
	
	
	/**
	 * 아이디 중복 검사 Service
	 * @param memberId
	 * @return
	 */
	public int duplicateCheck(String memberId) throws Exception{
	
		// 1. Connection 객체 생성
		// -> JDBCTemplate에 작성된 getConnection() 메소드를 이용해 생성 후 얻어온다.
		Connection conn = getConnection(); //Connection conn = JDBCTemplate.getConnection();
		
		
		// 2. DAO 메소드(SELECT) 호출 후 결과 반환 받음
		int result = dao.duplicateCheck(conn, memberId);
		
		
		// (SELECT는 별도의 트랜잭션 제어 필요 없음)
		// 3. 사용한 Connection 객체 반환
		//JDBCTemplate.close(conn);
		close(conn);

		// 4. 중복 검사 결과 View로 반환
		
		return result;
	}


	/**
	 * 회원 가입 Service
	 * @param signUpMember
	 * @return result
	 * throws Exception
	 */
	public int signUp(Member signUpMember) throws Exception{

		// 1) Connection 생성
		Connection conn = getConnection(); // JDBCTemplate.getConnection();
		
		// 2) 회원 가입 DAO 메소드 호출하고 결과 반환
		int result = dao.signUp(conn, signUpMember);
		
		// 3) DAO 수행 결과에 따라 트랜잭션 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		
		
		// 4) 사용한 Connection 반환
		close(conn); // JDBCTemplate.close();
		
		// 5) DAO 수행 결과 View로 반환
		
		return result;
	}


	/**
	 * 로그인 Service
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {
		
		// 1) Connection 생성
		Connection conn = getConnection(); 
		
		// 2) DAO 메소드 수행 후 결과 반환
		Member loginMember = dao.login(conn, mem);
		
		// SELECT는 수행 뒤 트랜잭션 제어 필요 없음.
		
		// 3) 사용한 Connection 반환
		close(conn);
		
		// 4) DAO 조회 결과 View로 반환
				
		return loginMember;
	}


	/**
	 * 가입된 회원 목록 조회 Service
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception {
		
		// 1) Connection 생성
		Connection conn = getConnection();
		// 2) DAO 메소드(SELECT 수행) 호출 후 결과 반환 받기
		List<Member> memberList = dao.selectAll(conn);
		
		// 3) Connection 반환
		close(conn);
		
		// 4) DAO 호출 결과 View 반환
		
		
		return memberList;
	}


	/**
	 * 내 정보 수정
	 * @param updateMember
	 * @return result
	 * @throws Exception
	 */
	public int updateMyInfo(Member updateMember) throws Exception {
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.updateMyInfo(conn, updateMember);
		
		// -- dao 호출 후 반한 된 뒤 트랜잭션 제어처리로 넘어감
		
		// 3) 트랜잭션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 4) Connection 반환
		close(conn);
	
		// 5) DAO 수행 결과를 View로 반환
		return result;

		
	
	
	}


	/** 비밀번호 변경 Service
	 * @param memberNo
	 * @param currentPw
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int updatePw(int memberNo, String currentPw, String newPw) throws Exception{
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.updateMyPw(conn, memberNo, currentPw, newPw);
										// loginMember.getMemberNo 를 매개변수 memberNo로 받음
		// -- dao 호출 후 반한 된 뒤 트랜잭션 제어처리로 넘어감
		
		// 3) 트랜잭션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 4) Connection 반환
		close(conn);
	
		// 5) DAO 수행 결과를 View로 반환
		return result;
	}


	/** 회원 탈퇴 Service
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception{
		
		// 1) Connection 생성
		Connection conn = getConnection();
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.secession(conn, memberNo, memberPw);
										// loginMember.getMemberNo 를 매개변수 memberNo로 받음
		// -- dao 호출 후 반한 된 뒤 트랜잭션 제어처리로 넘어감
		
		// 3) 트랜잭션 제어 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 4) Connection 반환
		close(conn);
	
		// 5) DAO 수행 결과를 View로 반환
		return result;
		
		
	}

	
	
	
	
	
}
