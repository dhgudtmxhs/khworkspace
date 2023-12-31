package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {

	
	// 예제 1번 다시 쓰기
	// 1번의 결과를 오름차순으로 정렬(DB)해서 조회
	// + 급여 합계를 구해서 출력(Java)
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ohs", "ohs1234");
			
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE ORDER BY EMP_NAME";
			
			sm = con.createStatement();
			
			rs = sm.executeQuery(sql);
			
			int sum = 0;
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode = rs.getString("DEPT_CODE");
				
				System.out.printf("사번 : %d 이름 : %s 급여 : %d 부서코드 : %s\n",
									empId, empName, salary, deptCode);
				sum += salary;
			
			}
			System.out.println("급여 합계 : " + sum);
			
			
		}catch(SQLException e) { // 데이터베이스 연결 및 쿼리문 실행 과정에서 발생할 수 있는 예외
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("OJDBC 라이브러리 미등록 또는 경로 오타"); // 오라클 드라이버 관련 예외
			e.printStackTrace();
			
		}finally {
			
			try {
			
			if(rs != null)rs.close();
			if(sm != null)sm.close();
			if(con != null)con.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
