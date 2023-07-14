package edu.kh.community.member.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.member.model.vo.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	// Service에서 dao 객체를 생성하고 dao로 넘어옴 -> heap 메모리 안에 null값 이미 들어가있음 
	// private Statement stmt = null 안해도 이미 null임
	
	
	// 기본 생성자
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath =  MemberDAO.class.getResource("/edu/kh/community/sql/member-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/** 로그인 DAO
	 * @param mem
	 * @param conn
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem, Connection conn) throws Exception{
	
		Member loginMember = null; // 결과 저장용 변수
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("login");
			
			// 위치홀더 쓰기 위한 PreparedStatement 생성 및 SQL 적재
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			
			pstmt.setString(2, mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(         rs.getInt("MEMBER_NO")       );
	            loginMember.setMemberEmail(    rs.getString("MEMBER_EMAIL") );
	            loginMember.setMemberNickname(    rs.getString("MEMBER_NICK")    );
	            loginMember.setMemberTel(       rs.getString("MEMBER_TEL")     );
	            loginMember.setMemberAddress(    rs.getString("MEMBER_ADDR")  );
	            loginMember.setProfileImage(    rs.getString("PROFILE_IMG")  );
	            loginMember.setEnrollDate(       rs.getString("ENROLL_DT")     );
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return loginMember; // null 또는 Member 객체 주소
	
	}


	
	/**
	 * @param mem
	 * @param conn
	 * @return result
	 * @throws Exception
	 */

	public int signUp(Member mem, Connection conn) throws Exception{
	
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberNickname());
			pstmt.setString(4, mem.getMemberTel());
			pstmt.setString(5, mem.getMemberAddress());
			
			result = pstmt.executeUpdate();
	
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}


	/** 회원 정보 수정 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member mem) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberNickname());
			pstmt.setString(2, mem.getMemberTel());
			pstmt.setString(3, mem.getMemberAddress());
			pstmt.setInt(4, mem.getMemberNo());
			
				result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}

		return result;
	}


	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String currentPw, String newPw, int memberNo) throws Exception{

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, currentPw);
			
			result = pstmt.executeUpdate();
			
		}finally {
			// try - finally 왜 사용하는가?
			// -> try 구문에서 JDBC 관련 예외가 발생하더라도
			// 	  사용중이던 JDBC 객체 자원을 무조건 반환하기 위해서
			// -> close 할라고 쓴 거다.
			close(pstmt);
			
		}
		
		return result;
	}


	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	/*
	 * public int secession(Connection conn, int memberNo, String memberPw) throws
	 * Exception{
	 * 
	 * int result = 0;
	 * 
	 * try {
	 * 
	 * String sql = prop.getProperty("secession");
	 * 
	 * pstmt = conn.prepareStatement(sql);
	 * 
	 * pstmt.setInt(1, memberNo); pstmt.setString(2, memberPw);
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * 
	 * }finally { close(pstmt); }
	 * 
	 * return result; }
	 */
	
	public int secession(Connection conn, int memberNo, String memberPw) throws Exception {
	      
	      int result = 0;

	      try {
	         String sql = prop.getProperty("secession");

	         pstmt = conn.prepareStatement(sql);

	         pstmt.setInt(1, memberNo);
	         pstmt.setString(2, memberPw);

	         result = pstmt.executeUpdate();

	      }finally {
	         // try - finally 왜 사용하는가?
	         // -> try 구문해서 JDBC 관련 예외가 발생하더라도
	         //     사용중이던 JDBC 객체 자원을 무조건 반환하기 위해서
	         close(pstmt);
	      }

	      return result;
	   }


	/** 이메일 중복 검사 DAO
	 * @param conn
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(Connection conn, String memberEmail) throws Exception {
		
		int result = 0; // 결과 저장용 변수
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("emailDupCheck");
			
			// pstmt 생성 
			pstmt = conn.prepareStatement(sql);
					
			// 위치홀더에 알맞은 값 세팅
			pstmt.setString(1, memberEmail);
					
			// SQL(SELECT) 수행 후 결과 반환 받기
			
			rs = pstmt.executeQuery();
			
			// rs.next()로 조회 결과를 확인
				if(rs.next()) {
					
					//result = 1;
					result = rs.getInt(1); // 1번 컬럼 결과를 result에 대입하겠다.
					
				} /*
					 * else {
					 * 
					 * result = 0; }
					 */
		
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return result;
		
	}

	/** 이메일 중복 검사 확인 DAO
	 * @param conn
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(Connection conn, String memberNickname) throws Exception{

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("nicknameDupCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberNickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
				result = rs.getInt(1);
				
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}


	/** 이메일로 정보 조회 DAO
	 * @param conn
	 * @param memberEmail
	 * @return loginMember
	 * @throws Exception
	 */
	public Member selectOne(Connection conn, String memberEmail) throws Exception{

		Member member = null;
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("selectOne");
			
			// 위치홀더 쓰기 위한 PreparedStatement 생성 및 SQL 적재
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberEmail); //
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberNickname(rs.getString("MEMBER_NICK"));
				member.setMemberTel(rs.getString("MEMBER_TEL"));
				member.setMemberAddress(rs.getString("MEMBER_ADDR"));
				member.setEnrollDate(rs.getString("ENROLL_DATE")); // getstring 1, 2, 3, 4, 5 로 해도 됨
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return member;
	}


	/** 전체 회원 목록 조회 DAO
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn) throws Exception{
		
		List<Member> memberList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();		
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Member mem = new Member();
				
				mem.setMemberNo(rs.getInt(1));
				mem.setMemberEmail(rs.getString(2));
				mem.setMemberNickname(rs.getString(3));
			
				memberList.add(mem);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return memberList;
		
	}

}