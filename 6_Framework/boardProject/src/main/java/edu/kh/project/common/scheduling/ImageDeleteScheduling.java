package edu.kh.project.common.scheduling;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.kh.project.board.model.service.BoardService;

// spring이 일정 시간마다 해당 객체를 이용해서 코드를 수행
// == 스프링이 해당 클래스를 객체로 만들어서 관리를 해야한다.
// == Bean 등록

@Component // @Controller, @Service, @Repository의 부모 어노테이션
		   // Bean 등록을 하겠다고 명시하는 어노테이션
public class ImageDeleteScheduling {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BoardService service;
	
	//@Scheduled(fixedDelay = 10000) // ms 단위
	// 일(5초) -> 10초 대기 -> 일(5초) -> 10초 대기
	
	//@Scheduled(fixedRate = 5000)
	
	// cron = "초 분 시 일 월 요일 [년도]" [] 생략가능
	//@Scheduled(cron = "0,30 * * * * *") // 매분 0초 30초 마다

	@Scheduled(cron="0 0 * * * *") // 매 정시(*시 0분 0초)
	public void test() {
		
		// System.out.println("스케쥴러가 일정시간마다 자동으로 출력");
	
		System.out.println("------------ 게시판 DB, 서버 불일치 파일 제거 ------------");
		
		// 서버에 저장된 파일 목록을 조회해서
		// DB에 저장된 파일 목록과 비교하여
		// 매칭되지 않는 서버 파일 제거
		
		// 서버에 저장된 파일 목록 조회
		// -> application 객체를 이용해서
		//    /resources/images/board의 실제 서버 경로를 얻어오겠다.
		String filePath = servletContext.getRealPath("/resources/images/board"); 
		//c\workspace\.... 실제경로 얻어옴 // 윈도우는 백슬래시가 \ 인데 일단 되긴함 
	
		// filePath에 저장된 모든 파일 목록 읽어오기
		File path = new File(filePath); // 파일 담을 객체 만듬
		File[] imageArr = path.listFiles(); // 배열로 담기
		
		// 배열 -> List로 변환
		List<File> serverImageList = Arrays.asList(imageArr);
		
		/*
		 * // 임시 확인 for(File list :serverImageList) {
		 * System.out.println(list.toString()); }
		 */
		
		// 3) DB 파일 목록 조회 (rename만 가져오기)
		List<String> dbImageList = service.selectImageList();
		
		/*
		 * for(String s : dbImageList) { System.out.println(s); }
		 */
		
		// 4) 서버에 파일 목록이 있을 경우에만 비교 시작
		if(serverImageList.size() > 0 ) { // isEmpty
			
			// 5) 서버 파일 목록 순차 접근
			for(File server : serverImageList) {
				
				// 6) 서버에 존재하는 파일이
				//    DB(dbImageList)에 없다면 삭제
				
				
				// 스플릿으로 얻어오기
				// C:\workspace\6_Framework\boardProject\src\main\webapp\resources\images\board\이미지명
				//String[] temp = server.toString().split("\\\\"); // 
				//String s = temp[temp.length -1]; // 마지막 인덱스 번호는 length -1
			
				
				// 파일 객체에서 파일 이름 얻어오기
				// server.getName()
				
				// List.indexOf(객체) = 객체가 List에 있으면 해당 인덱스 반환
				//					   없으면 -1 반환
				if(dbImageList.indexOf(server.getName()) == -1) { // db에 없는거 삭제함
				// db 파일 목록            서버 파일 이름
					
					System.out.println(server.getName() + "삭제");
					
					server.delete(); // File.delete() : 파일 삭제
					
				}
				
			} // for문 종료
			
			System.out.println("----------- 이미지파일 삭제 스케쥴러 종료 -----------");
			
		}
		
	}
	
}

/*
 * @Scheduled
 * 
 * * Spring에서 제공하는 스케줄러 - 스케줄러 : 시간에 따른 특정 작업(Job)의 순서를 지정하는 방법.
 * 
 * 설정 방법 
 * 1) servlet-context.xml -> Namespaces 탭 -> task 체크 후 저장
 * 2) servlet-context.xml -> Source 탭 -> <task:annotation-driven/> 추가
 * 
 *
 * @Scheduled 속성 3개중 하나만 사용 가능
 * 
 *  - fixedDelay : 이전 작업이 끝난 시점으로 부터 고정된 시간(ms)을 설정.
 *    @Scheduled(fixedRate = 10000) // 이전 작업이 시작된 후 10초 뒤에 실행
 *    
 *  - fixedRate : 이전 작업이 수행되기 시작한 시점으로 부터 고정된 시간(ms)을 설정.
 *    @Scheduled(fixedDelay  = 10000) // 이전 작업이 끝난 후 10초 뒤에 실행
 *    
 *  - cron 속성 : UNIX계열 잡 스케쥴러 표현식으로 작성 - cron="초 분 시 일 월 요일 [년도]" - 요일 : 1(SUN) ~ 7(SAT) 
 *    ex) 2019년 9월 16일 월요일 10시 30분 20초 cron="20 30 10 16 9 2 " // 연도 생략 가능
 * 
 * 
 * 
 * - 특수문자 * : 모든 수. 
 * - : 두 수 사이의 값. ex) 10-15 -> 10이상 15이하 
 * , : 특정 값 지정. ex) 3,4,7 -> 3,4,7 지정 
 * / : 값의 증가. ex) 0/5 -> 0부터 시작하여 5마다 
 * ? : 특별한 값이 없음. (월, 요일만 해당) 
 * L : 마지막. (월, 요일만 해당)
 * @Scheduled(cron="0 * * * * *") // 매 분마다 실행
 * 
 * 
 * 
 * 
 * * 주의사항 - @Scheduled 어노테이션은 매개변수가 없는 메소드에만 적용 가능.
 * 
 */
