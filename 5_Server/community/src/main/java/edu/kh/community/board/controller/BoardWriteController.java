package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.community.board.model.service.BoardService;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.common.MyRenamePolicy;
import edu.kh.community.member.model.vo.Member;

// 컨트롤러 : 요청에 따라 알맞은 Service를 호출하고 결과에 따라 응답을 제어한다.
@WebServlet("/board/write") // onclick="location.href='write?mode=insert&type=${param.type}'"
public class BoardWriteController extends HttpServlet{

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String mode = req.getParameter("mode"); //  onclick="location.href='write?mode=insert&type=${param.type}'"
													//  insert인지 update인지 구분
			
				// insert는 별도 처리 없이 jsp로 위임
			
				// update는 기존 게시글 내용을 조회하는 처리가 필요하다.
			
			if(mode.equals("update")) {
				
				int boardNo = Integer.parseInt(req.getParameter("no"));
				
				// 게시글 상세조회 서비스를 이용해서 기존 내용 조회
				
				// BoardService service = new BoardService(); -> 한번만 쓸거라 밑처럼
				// 객체를 생성해서 변수에 저장을 안함 -> 1회성으로 사용하겠다.
				BoardDetail detail = new BoardService().selectBoardDetail(boardNo);
				
				// 개행문자 처리 해제(<br> -> \n 으로)
				detail.setBoardContent(detail.getBoardContent().replaceAll("<br>", "\n"));
				
				req.setAttribute("detail", detail); // jsp에서 사용할 수 있도록 req에 값 세팅
				
			}
			
			// if update 아직 안적었고 일단 insert면 여기 jsp로 연결
			String path = "/WEB-INF/views/board/boardWriteForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			// insert/update 구분 없이 전달 받은 파라미터 모두 꺼내서 정리하기
			
			// *** enctype="multipart/form-data" 인코딩 미지정 형식의 요청 ***
			// -> HttpServletRequest로 파라미터 못얻어온다.
			// --> MultipartRequest를 이용(cos.jar 라이브러리 제공)
			// ---> 업로드 최대 용량, 저장 실제 경로, 파일명 변경 정책, 문자 파라미터 인코딩 설정 필요
			
			int maxSize = 1024 * 1024 * 100; // 업로드 최대 용량 = 100MB
			
			HttpSession session = req.getSession(); 
	         
			String root = session.getServletContext().getRealPath("/"); //webapp 폴더까지 경로 /community/src/main/webapp
			
	        String folderPath = "/resources/images/board/"; // 파일을 저장할 폴더 경로

	        String filePath = root + folderPath; // /community/src/main/webapp + /resources/images/board/ 
	        
	        String encoding = "UTF-8"; // 파라미터 중 파일을 제외한 파라미터(문자열)의 인코딩을 지정한다.
	        
	        
	        // ** MultipartRequest 객체 생성 **
	        // -> 객체가 생성됨과 동시에 파라미터로 전달된 파일이 지정된 경로에 저장됨 그냥 이 객체는 그렇게 해줌
	        MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
	        // 이미지 파일을 resources images 폴더 안에 저장하는것
	        
	        // ------------------------------------------------------------------------------------------------------ //
	        
	        // MultipartRequest.getFileNames()
	        // - 요청 파라미터 중 모든 file 타입 태그의 name 속성 값을 얻어와
	        // 	 Enumeration 형태로 반환 (Iterator의 과거버전)
	        // 	 --> 해당 객체에 여러 값이 담겨 있고 이를 순서대로 얻어오는 방법을 제공 
	        //			(보통 순서가 없는 모음(Set과 같은 경우)에서 하나씩 꺼낼 때 사용)
	        
	        Enumeration<String> files = mpReq.getFileNames();
	        // file 타입 태그의 name 속성 0,1,2,3,4가 순서가 "섞인" 상태로 얻어와짐
	        
	        // * 업로드된 이미지의 정보를 모아둘 List 생성
	        List<BoardImage> imageList = new ArrayList<BoardImage>();
	        
	        while(files.hasMoreElements()) { // 다음 요소가 있으면 true // rs.next 느낌
	        	String name = files.nextElement(); // 다음 요소(name 속성 값)을 얻어온다.
	        	
	        	//System.out.println("name : " + name);
	        	// file 타입 태그의 name 속성 값이 얻어와진다.
	        	// + 업로드가 안된 file 타입 태그의 name도 얻어와진다.
	        	
	        	String rename = mpReq.getFilesystemName(name); // 변경된 파일명 ex) 20230725111026_95415.png
	        	String original = mpReq.getOriginalFileName(name); // 원본 파일명 ex) dog3.jpg
	        	
	        	//System.out.println("rename : " + rename);
	        	//System.out.println("original : " + original);
	        	
	        	if(rename != null) { // 업로드된 파일이 있을 경우 ==
	        						 // 현재 files에서 얻어온 name 속성을 이용해
	        						 // 원본 또는 변경을 얻어왔을 때 그 값이 null 이 아닌 경우 // orginal != null을 해도 상관 없을듯
	        		
	        		// 이미지 정보를 담은 객체(BoardImage)를 생성
	        		BoardImage image = new BoardImage();
	        		
	        		image.setImageOriginal(original); // 원본명 (다운로드 시 원본명으로 다운로드되게끔)
	        		image.setImageReName(folderPath + rename); // 폴더 경로 + 변경명
	        		image.setImageLevel(Integer.parseInt(name)); // 이미지 위치 0은 썸네일
	        		
	        		imageList.add(image); // 리스트에 추가
	        		
					/*
					  public class BoardImage {
					  
						  private int imageNo; 
						  private String imageReName;
						  private String imageOriginal; 
						  private int imageLevel; 
						  private int boardNo;
					  
					  }
					  
					 */
	        		
	        	} // if문 끝
	        	
	        } // while문 끝
	        
	        
	        
	        // * 이미지를 제외한 게시글 관련 정보 *
	        String boardTitle = mpReq.getParameter("boardTitle"); // 그냥 리퀘스트로 얻어오면 다 null나옴
			
	        String boardContent = mpReq.getParameter("boardContent");
	        
	        int boardCode = Integer.parseInt(mpReq.getParameter("type")); // boardNo 인듯? // hidden input에 담겨있음
	        
	        Member loginMember = (Member)session.getAttribute("loginMember");
	        
	        int memberNo = loginMember.getMemberNo(); // 회원 번호
	        
	        // 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기
	        BoardDetail detail = new BoardDetail();
	        
	        detail.setBoardTitle(boardTitle);
	        detail.setBoardContent(boardContent);
	        detail.setMemberNo(memberNo);
	        // boardCode는 별도 매개변수로 전달할거라 set안함
	        
	        // ---------------------------게시글 작성에 필요한 기본 파라미터 얻어오기 끝-------------------------------- //
	        
	        BoardService service = new BoardService();
	        
	        // insert/update 에 따라 파라미터 얻어오고 서비스 호출
	        String mode = mpReq.getParameter("mode"); // hidden input
	        
	        if(mode.equals("insert")) { // 삽입
	        	
	        	// 게시글 삽입 서비스 호출 후 결과 반환 받기
	        	// -> 반환된 게시글 번호를 이용해서 상세조회로 redirect 예정
	        	int boardNo = service.insertBoard(detail, imageList, boardCode);
	        	
	        	String path = null;
	        	
	        	if(boardNo > 0 ) { // 성공
	        		session.setAttribute("message", "게시글이 등록되었습니다.");
	        		
	        		// detail?no=2000&type=2
	        		path = "detail?no=" + boardNo + "&type=" + boardCode;
	        		
	        		//http://localhost:8080/community/board/detail?no=1000 까지만 있으면 해당 게시글 가지고 뒤는 쿼리스트링이라 상관 x
	        		// 그냥 게시글 들어갈 땐 cp가 있는데 만들었을 때의 주소는 cp가 없음. 그차이밖에 업슴
	        		
	        	}else { // 실패
	        		session.setAttribute("message", "게시글 등록 실패");
	        		
	        		// write?mode=insert&type=2 실패했을 때 이 위치로 돌아가야함
	        		path = "write?mode=" + mode + "&type=" + boardCode;
	        		
	        	}
	        	
	        	resp.sendRedirect(path); // 리다이렉트
	        	
	        }
	        
	        if(mode.equals("update")) { // 수정
	        	
	        	// 앞선 코드는 동일(업로드된 이미지 저장, imageList 생성, 제목/내용 파라미터 동일)
	        	
	        	// + update일 때 추가된 내용
	        	// 어떤 게시글 수정? -> 파라미터 no
	        	// 나중에 목록으로 버튼 만들 때 사용할 현재 페이지 -> 파라미터 cp
	        	// 이미지 중 x버튼을 삭제할 이미지 레벨 목록 -> 파라미터 deleteList
	        	int boardNo = Integer.parseInt(mpReq.getParameter("no"));
	        	
	        	int cp = Integer.parseInt(mpReq.getParameter("cp"));
	        	
	        	String deleteList = mpReq.getParameter("deleteList");
	        	
	        	// 게시글 수정 서비스 호출 후 결과 반환 받기
	        	detail.setBoardNo(boardNo);
	        	
	        	// detail, imageList, deleteList
	        	int result = service.updateBoard(detail, imageList, deleteList);
	        	
	        	String path = null;
	        	String message = null;
	        	
	        	if(result > 0 ) { // 성공
	        		
	        		// detail?no=1000&type=1&cp=20
	        		path = "detail?no=" + boardNo + "&type=" + boardCode + "&cp=" + cp; // 상세조회 페이지 요청 주소
	        		
	        		message = "게시글이 수정되었습니다.";
	        	
	        	}else { // 실패

	        		// 수정화면으로 이동
	        		
	        		// 상세조회 -> 수정화면 -> 수정 -> (성공)상세조회
	        		//						   -> (실패)수정화면

	        		// write?mode=update&type=1&cp=5&no=1621
	        		path = req.getHeader("referer");
	        		// referer : HTTP 요청 흔적(요청 바로 이전 페이지 주소)
	        		
	        		
	        		message = "게시글 수정 실패";
	        		
	        	}
	        	
	        	session.setAttribute("message", message);
	        	resp.sendRedirect(path);
	        }
	        
	        
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
