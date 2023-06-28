package edu.kh.jdbc.ex1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExmaple1 {

	public static void main(String[] args) {
		
		// JDBC : java와 DB와 연결할 수 있게 해주는 jav API
		
		// [1단계] : JDBC 객체 참조 변수 선언
		
		Connection conn = null; 
		// DB 연결 정보를 담은 객체
		// -> Java와 DB 사이를 연결 해주는 일종의 s통로(Stream과 비슷)
		
		Statement stmt = null;
		// Connection 객체를 통해
		// Java에서 작성된 SQL을 DB로 전달하여 수행한 후
		// 결과를 반환 받아 다시 Java로 돌아오는 역할의 객체
		
		ResultSet rs = null;
		// SELECT 질의 성공 시 반환되는
		// 결과 행의 집합(Result Set)을 나타내는 객체
		// 자바에서는 오라클 형식으로 행 열 을 담을 수 없음
		
		try {
		
			// [2단계] 참조변수에 알맞은 객체 대입하기
			
			// 1. DB연결에 필요한 Oracle JDBC Driver 메모리 로드하기
			// --> Oracle JDBC Driver, 경로가 어디에 있는지만 알려주면 알아서 메모리 로드함
			// (생략도 가능함)
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// ClassNotFoundException 발생 가능성이 있음
			
			// 2. 연결 정보를 담은 Connection을 생성
			//		(이때, DriverManager 객체가 필요함)
			//		DriverManager : JDBC 드라이버를 통해 Connection 객체를 만드는 역할
			
			
			String type = "jdbc:oracle:thin:@"; // JDBC드라이버가 thin 타입이다.
			
			String ip = "localhost"; 
			// DB 서버 컴퓨터 IP -- 내 oracle에 localhost가아닌 주소값이라면 주소값을 넣어야함
			// localhost == 127.0.0.1
			
			String port = ":1521";
			// port도 내 컴퓨터 오라클에있는 port쓰면 됨 근데 다 같을듯
			
			String sid = ":xe"; // DB 이름
			
			String user = "ohs"; // 내 이니셜 계정
			
			String pw = "ohs1234"; // 내 비번
			
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
			// 이렇게 이어쓰면
			// "jdbc:oracle:thin:@localhost:1521:xe 를 나눠서 한 것
			
			//중간확인
			System.out.println(conn); // oracle.jdbc.driver.T4CConnection@4961f6af
			
			// 3. Statement 객체에 적재할 SQL 작성하기
			
			// ***** JAVA에서 작성된 SQL문은 마지막에 ;(세미콜론)을 찍지 않아야 한다! *****
			// -> "유효하지 않은 문자" 오류를 발생시킨다.
			
			// 왕복으로 갔다 오게 하는 법???
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE";
			
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL을 Statement에 적재 후
			//    DB로 전달하여 수행한 후
			//	  결과를 반환 받아와 rs 변수에 대입한다.
			
			rs = stmt.executeQuery(sql);
			
			// DB에서 SELECT를 수행한 결과(ResultSet) 객체를 얻어와 rs가 참조하게 한다.
			
			// [3단계] SELECT 수행 결과를 한 행 씩 접근하여 
			//		  원하는 컬럼 값 얻어오기

			while(rs.next()) {
				// rs.next() : 참조하고 있는 ResultSet 객체의
				//			   첫 번째 컬럼부터 순서대로 한 행씩 이동하며
				//			   다음 행이 있을 경우 true를 반환한다.
				
				// rs.get[Type]("컬럼명") : 현재 가리키고 있는 행의 특정 컬럼 값을 얻어온다.
				// [Type]은 DB에서 얻어와서 Java에 저장할 자료형(Java쪽 자료형)
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode = rs.getString("DEPT_CODE");
				
				// 조회 결과 출력
				System.out.printf("사번 : %d 이름 : %s 급여 : %7d 부서코드 : %s\n",
									empId, empName, salary, deptCode);
			}
			
		}catch(SQLException e) {
				//SQLException : DB 연결관련 예외의 최상의 부모
				e.printStackTrace();
		}catch(ClassNotFoundException e) {
			System.out.println("OJDBC 라이브러리 미등록 또는 경로 오타");
				e.printStackTrace();
		}finally {
			
			// [4단계] 사용한 JDBC 객체 자원 반환(close)
			// -> 자원 반환 순서는 객체 생성 순서의 "역순"으로
			// 생성 순서 : Connection, Statement, ResultSet
			// 반환 순서 : ResultSet, Statement, Connection
			// Connection = 스트림 (통로) 느낌, 처음에 열고 마지막에 닫아야만 한다.
			
			try {
				
				// NullPointerException 방지를 위한 if문 추가 // if문 안쓰면 null.close 가 되어버림
				if(rs != null) rs.close(); 
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		
		
		
		
	}
	
	// JDBC 관련 JavaAPI(java.sql 패키지)
	// Connection
	// Statement
	// ResultSet
	// 어떤 DB와 연결?
	// -> 오라클DB(오라클 JDBC 드라이버 필요)
	// -> OJDBC11.jar(오라클 JDBC 드라이버 포함 라이브러리)
	
	// Run, View, Service, VO, DAO 클래스를 만들거임
	
	// Run = 실행
	// View = 키보드 입력(Scanner), 콘솔화면 출력(Print)
	// Service = 기능 제공 메소드
	// DAO = DB 연결용 클래스(SQL, JDBC)
	// VO = 값 저장용 객체
	
	// 이렇게 세분화 하는 것 ==> 모듈화
	// MVC = MODEL, VIEW, CONTROL 모델의 가장 기본적인 모양
	
	
	
	
	
}
