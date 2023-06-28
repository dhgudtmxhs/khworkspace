package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.member.model.vo.Member;

public class BoardView {

	private Scanner sc = new Scanner(System.in);
	
	private BoardService service = new BoardService();
	
	
	/**
	 * 게시판 전용 메뉴 화면
	 * @param loginMember (로그인한 회원 정보)
	 */
	public void boardMenu(Member loginMember) {

		int menuNum = -1;
		
		do {
			
			try {
				
			    System.out.println("\n********** 게시판 메뉴 **********\n");
		            
	            System.out.println("1. 게시글 목록 조회");
	            System.out.println("2. 게시글 상세 조회(게시글 번호 입력)"); //pk 생성 -> 자동 인덱스 등록 -> 빨라짐
						            // 게시글 작성자와 로그인한 회원이 같을 때
						            // 게시글 수정(UPDATE), 게시글 삭제(DELETE)
	            System.out.println("3. 게시글 작성(INSERT)");
	            System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");
	            System.out.println("0. 회원 메뉴로 돌아가기");
				
				System.out.print("메뉴를 선택해주세요 >> ");
				menuNum = sc.nextInt();
				sc.nextLine();		  // 개행문자 제거
				System.out.println(); // 줄바꿈
				
				switch(menuNum) {
				
				case 1: selectAll(); break;
				case 2: selectOne(loginMember); break;
					// 상세 조회 시 게시글 수정/삭제(게시글 작성 == 로그인한 회원 비교)
					// 댓글(누가 작성? / 작성자가 수정, 삭제 확인)
					// -> loginMember를 매개변수로 전달
				
				case 3: insertBoard(loginMember.getMemberNo()); break; // no만있어도 가능
				case 4: searchBoard(); break;
				case 0: System.out.println("회원 메뉴로 돌아갑니다..."); break;
				default : System.out.println("메뉴에 작성된 번호를 입력해주세요.");break;
				
				}
				
			}catch(InputMismatchException e) {
				System.out.println("입력 형식이 올바르지 않습니다. 다시 시도해주세요.");
				sc.nextLine();
			}
			
		}while(menuNum != 0);
		
	}

	/**
	 * 게시글 검색
	 */
	private void searchBoard() {
		  
		System.out.println("\n[게시글 검색]\n");
		
		int menuNum = -1;
		
		do {
			
			try {
				
				System.out.println("--- 검색 조건을 선택해주세요 ---");
				
				System.out.println("1. 제목");
				System.out.println("2. 내용");
				System.out.println("3. 제목+내용");
				System.out.println("4. 작성자");
				System.out.println("0. 돌아가기");
				
				System.out.println("선택 >>");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {

				case 0 : System.out.println("\n 게시판 메뉴로 돌아갑니다...\n"); break;
				case 1 : case 2 : case 3 : case 4 : 
					// 검색어 입력 -> Service 호출
					
					System.out.println("검색어 : ");
					String keyword = sc.nextLine();
					
					List<Board> boardList = service.searchBoard(menuNum, keyword);
					
					if(boardList.isEmpty()) { // 검색 결과가 비어있다 == 검색 결과 없음
					
						System.out.println("\n 검색 결과가 없습니다.\n");
					}else {
						System.out.println("------------------------------------------------------------------------");
		                System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n",
		                           "글번호", "제목", "", "작성자", "", "작성일", "" , "조회수");
		                System.out.println("------------------------------------------------------------------------");
		                  
		                  // 향상된 for문
		                for(Board b : boardList) {
		                     
		                 System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n",
		                           b.getBoardNo(), b.getBoardTitle(), b.getReplyCount(),
		                           b.getMemberName(), b.getCreateDate().toString(), b.getReadCount());
		                  }
					}
					
					break;
				
				default : System.out.println("\n 메뉴에 작성된 번호를 입력해주세요.\n");
					
				
				}
				
			}catch(InputMismatchException e) {
				System.out.println("\n 입력 형식이 올바르지 않습니다. 다시 시도 해주세요.\n");
				sc.nextLine();  // 입력 버퍼에 남은 잘못된 문자열 제거
				e.printStackTrace();
				
			}catch(Exception e) {
				System.out.println("\n<게시글 검색 중 예외 발생>\n");
				e.printStackTrace();
				break; // 검색 반복문 종료
			}
			
			
			
			
			
		}while(menuNum != 0);
		
		
	}

	private void insertBoard(int memberNo) {
		
		System.out.println("\n[게시글 작성]\n");
		
		System.out.print("게시글 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.print("\n게시글 내용 (종료 시 @exit 입력)\n");
		String boardContent = inputContent();
		
		
		Board board = new Board();
		
		board.setMemberNo(memberNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		try {
		
			int result = service.insertBoard(board);
			
			if(result > 0) System.out.println("[" + boardTitle + "]" + " 게시글 작성 성공");
			else		   System.out.println("게시글 작성 실패");
			
		}catch(Exception e) {
			System.out.println("게시글 작성 중 오류 발생");
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 게시글 목록 조회
	 */
	private void selectAll() {

		System.out.println("[게시글 목록 조회]");
		
		try {
			
			// 게시글 목록 조회 Service 호출 후 결과 반환 받기
			List<Board> boardList = service.selectAll();
			
			if(boardList.isEmpty()) {
				System.out.println("게시글이 없습니다.");
			}else {
				System.out.println();
				System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("ㅣ번호ㅡㅡㅡㅡㅡ제목ㅡㅡㅡㅡㅡㅡㅡㅡ작성일자ㅡㅡ조회수ㅡㅡ작성자ㅡㅡㅡ댓글 수ㅣ");
				System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				for(Board a : boardList) {// 숙제
					
					System.out.printf("ㅣ %-5d %-12s %-11s %-5d %-7s %d  ㅣ%n", 
							
				a.getBoardNo(), a.getBoardTitle(), a.getCreateDate().toString(), a.getReadCount(), a.getMemberName(), a.getReplyCount());
					System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				}
			}
			
		}catch(Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
			
		}
		
	}


	/** 게시글 상세 조회
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {
		
		System.out.println("[게시글 상세 조회]");
		
		System.out.print("조회할 게시글 번호 입력 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();

		// 게시글 상세조회 Service를 호출 후 결과 반환(게시글 1개의 정보 == Board)
		
		try {
		
		Board board = service.selectOne(boardNo);	
			
		// -------------------------------------------
        // 상세 조회용 메뉴 출력
        
		if(board != null) {// 조회된 게시글이 있을 경우
			
			// System.out.println(board);
			
			//댓글 목록 조회
			 System.out.println("\n------------------------------------------------------------");
	            System.out.printf("번호 : %d     |  제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("작성자 : %s\n"
	                        + "작성일 : %s\n"
	                        + "조회수 : %d\n", 
	                        board.getMemberName(), board.getCreateDate(), board.getReadCount());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("\n%s\n\n", board.getBoardContent());
	            System.out.println("------------------------------------------------------------");
	            
	            // 댓글 목록 조회
	            System.out.println("\n[댓글]");
	            for( Reply r : board.getReplyList() ) {
	               System.out.printf("<%d> | %s | %s\n", 
	                     r.getReplyNo(), r.getMemberName(), r.getCreateDate());
	               
	               System.out.println(r.getReplyContent());
	               System.out.println(".............................................................\n");
	            }
	               System.out.println("===== 상세 조회 메뉴 =====");
	               
	               System.out.println("1. 댓글 삽입"); // 어떤 회원이든 가능
	               
	               // 댓글 번호 입력 받아
	               // 댓글을 작성한 회원 번호 == 로그인한 회원 번호
	               // -> 수정/삭제
	               System.out.println("2. 댓글 수정"); 
	               System.out.println("3. 댓글 삭제");   
	               // 댓글 번호 입력 -> 댓글이 있는지 확인 -> 해당 댓글이 로그인한 회원꺼가 맞는지 검사
	               
	               // 상세 조회된 게시글의 회원 번호 == 로그인한 회원 번호
	               // -> 게시글 수정/삭제
	               
	               if(board.getMemberNo() == loginMember.getMemberNo()) {
	               System.out.println("4. 게시글 수정");
	               System.out.println("5. 게시글 삭제");
	               }
	               
	               System.out.println("0. 게시판 메뉴로 돌아가기");
	               
	               System.out.print("메뉴 선택 >> ");
	               int menuNum = sc.nextInt();
	               sc.nextLine();
	       		   
	               switch(menuNum) {
	               case 0: System.out.println("게시판 메뉴로 돌아갑니다...\n"); break;
	               case 1: insertReply(loginMember, boardNo); break;
	               
	               case 2: case 3: 
	               		String tmp = menuNum == 2 ? "\n[댓글 수정]\n" : "\n[댓글 삭제]\n";
	               		System.out.println(tmp);
	               		
	               		System.out.print("댓글 번호 입력 : ");
	               		int inputNo = sc.nextInt();
	               		sc.nextLine();
	               		
	               		// 입력 받은 댓글 번호가 댓글 목록에 있는지 확인
	               		
	               		Reply reply = null; // 확인된 댓글 참조할 변수
	               		
	               		for(Reply r : board.getReplyList()) { // 반복 접근
	               			
	               			if(r.getReplyNo() == inputNo) { // board.getReplyListNo() == inputNo
	               				
	               				reply = r; // 같은 no의 댓글 다 가져온다
	               				break;
	               				
	               			}
	               			
	               		}
	               		
	               		if(reply == null) { // 같은 댓글 번호가 목록에 없는 경우
	               			System.out.println("\n 해당 댓글이 존재하지 않습니다.\n");
	               		
	               		}else { // 같은 댓글 번호가 목록에 있을 경우
	               			
	               			// 해당 댓글의 회원 번호(작성자)와
	               			// 로그인한 회원의 번호가 같은지 확인
	               			// -> 같을 경우 로그인한 사람의 댓글이다.
	               			
	               			if(reply.getMemberNo() == loginMember.getMemberNo()) {
	               				
	               				if(menuNum == 2) updateReply(inputNo); // 댓글 수정
	               				else			 deleteReply(inputNo);
	               				
	               			} else {
	               				System.out.println("\n현재 로그인한 회원의 댓글이 아닙니다. \n");
	               			}
	               			
	               			
	               		}
	               		
	               		break;
	               		
	               case 4: case 5: 
	            	   // 게시글 작성자 번호 == 로그인 회원 번호
	            	   if(board.getMemberNo()==loginMember.getMemberNo()) {
	            		   
	            		   //4번 게시글 수정
	            		   if(menuNum ==4){
	            			   updateBoard(boardNo);
	            			   
	            		   }else { // 5번  
	            			   	deleteBoard(boardNo);

	            	   }

	            	   }else {
	            		   System.out.println("메뉴에 표시된 번호만 입력해 주세요.");
	            	   }
	            	   break;
	               
	               default : System.out.println("메뉴에 표시된 번호만 입력 해주세요.");
	
	               }
		}else {
			System.out.println("\n존재하지 않는 게시글 번호입니다.\n");
		}
		
		
		}catch(Exception e) {
			System.out.println("\n<게시글 상세 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
	
	}


	/** 댓글 삭제
	 * @param inputNo
	 */
	private void deleteReply(int inputNo) {
			
		char ch = ' ';
		int result = 0;
	
		while(true) {
			
			System.out.println("정말 삭제하시겠습니까?(Y/N) : ");
			ch = sc.next().toUpperCase().charAt(0);
			
			if( ch == 'Y') {
				String cap = capcha();
				System.out.println("다음 보안문자를 입력해주세요 >>" + cap);

				System.out.println("보안 문자 입력");
				String input = sc.next();
				
				if(input.equals(cap)) {
					
					try {
						
						result = service.deleteReply(inputNo);
						
						if(result >0) System.out.println(inputNo +"번 댓글 삭제 성공\n");
						else		  System.out.println("댓글 삭제 실패");
						
					}catch(Exception e) {
						System.out.println("\n<게시글 삭제 중 예외 발생>\n");
						e.printStackTrace();
					}
					break;
				}else {
					System.out.println("\n 보안문자가 일치하지 않습니다.(삭제 취소)\n");
					break;
				}
				// Y일때 끝
			}else if( ch == 'N') {
				System.out.println("삭제 취소");
				break;
				
			}else {
				System.out.println("Y나 N으로 입력해주세요.");
			}
			
		}
		
	}

	
	/** 댓글 수정
	 * @param inputNo
	 */
	private void updateReply(int inputNo) {
		
		System.out.println("수정할 내용 입력(종료 시 @exit 입력)");
		String input = inputContent();
		
		Reply reply = new Reply();
		
		reply.setReplyContent(input);
		reply.setReplyNo(inputNo);
		
		try {
		
			int result = service.updateReply(reply);
			
			
			if(result > 0) System.out.println(input +"번 댓글이 수정되었습니다.\n");
			else		   System.out.println("\n 댓글 수정 실패\n");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/** 댓글 작성
	 * @param loginMember
	 * @param boardNo
	 * 
	 */
	private void insertReply(Member loginMember, int boardNo) {
	
		System.out.println("[댓글 작성]");
		
		System.out.println("댓글 내용 입력(종료 시 @exit 입력)\n");
		String replyContent = inputContent();
		
		// 회원 번호, 게시글 번호, 댓글 내용 보내줘서 얻어오기 -> 하나의 reply 객체를 생성
		Reply reply = new Reply();
		
		reply.setMemberNo(loginMember.getMemberNo());
		reply.setBoardNo(boardNo);
		reply.setReplyContent(replyContent);
		
		try {
		int result = service.insertReply(reply);
		
		if(result > 0 ) System.out.println("댓글 작성 완료");
		else			System.out.println("댓글 작성 실패");
		
		}catch(Exception e) {
			System.out.println("\n<댓글 작성 중 예외 발생>\n");
			e.printStackTrace();
		}
		
	}

	/** 게시글 수정
	 * @param boardNo
	 */
	private void updateBoard(int boardNo) {
		
		System.out.println("\n[게시글 수정]\n");
		
		System.out.print("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("\n수정할 내용(종료 시 @exit 입력) \n");
		
		String boardContent = inputContent(); // 내용 입력 메소드 호출 후 결과 반환 받기
		
		// 게시글 번호 / 수정한 제목 + 내용을 한번에 저장할 Board 객체 생성
		Board board = new Board();
		
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		try {
			
			int result = service.updateBoard(board);
			
			if(result > 0) System.out.println(boardNo + "번 게시글 수정되었습니다.\n");
			else		   System.out.println("\n[수정 실패]\n");
			
		}catch(Exception e) {
			System.out.println("\n 게시글 수정 과정에서 예외 발생\n");
			e.printStackTrace();
		}
		
	}
		
	/* String(객체)
	 * - 불변성(immutable) <-> 가변성(mutable)
	 * 
	 * -> 한 번 생성된 String 객체에 저장된 문자열은 변하지 않는다
	 * 
	 * ex) String str = "abc"; 	// Heap 영역에 String 객체가 생성되고
	 * 							// 생성된 객체에 "abc" 문자열 저장
	 * 
	 *	 str = "123"; // Heap 영역에 새로운 String 객체가 생성되고
	 * 				// 생성된 객체에 "123" 문자열 저장 후
	 * 				// 객체 주소를 str에 대입
	 * 
	 * ex) String str = "abc";
	 * 
	 * 		str += "123"; // 123이 저장된 String 객체 생성 후
	 * 				      // "abc"와 "123"이 합쳐진 String 객체가 추가로 별도 생성
	 * 				      // 그 후 "abc123" 객체의 주소를 str에 저장
	 * 
	 * ** String의 문제점 **
	 * 
	 * - String에 저장된 값을 바꾸거나 누적하려고 할 때 마다
	 *   String 객체가 무분별하게 생성된다 --> 메모리 낭비(메모리 누수)
	 *   
	 * ** 해결 방법 **
	 * - StringBuffer / StringBuilder (가변성)
	 * - 클래스를 자바에서 기본으로 제공함  
	 * 
	 * 	(StringBuffer / StringBuilder는 사용 방법은 똑같음)
	 *  -> 차이점은 동기/비동기 차이밖에 없다.
	 * 
	 * 
	 * 
	 * */
	
	/** 게시글/댓글 내용 입력 메소드
	 * @return content
	 */
	private String inputContent() {
		
		//String content = "";
		StringBuffer content = new StringBuffer(); // 컬렉션처럼 (10)이렇게 안해도 알아서 늘고 줄음
		
		String input = null;
		
		while(true) { // @exit가 입력될 때 까지 무한히 문자열을 입력 받아
			  // 하나의 변수에 누적
			input = sc.nextLine();
	
			if(input.equals("@exit")){ // @exit이 입력 된 경우
				break;
			} else {
					// 줄 바꾸며 누적
				//content += input + "\n";
				content.append(input);
				content.append("\n");
				// StringBuffer에 저장된 문자열의 제일 뒤에 input을 추가(누적)하겠다.
				// append : (제일 뒤에)덧붙이다, 추가하다, 첨부하다.
				
				//-> 하나의 StringBuffer 객체에 문자열이 계속 누적된다. == (가변)
				// 	 추가적인 String 객체 생성이 없다.
				
			}
		}
		return content.toString(); // StringBuffer에 오버라이딩된 toString()
								   // -> 저장된 문자열을 String 형태로 반환한다.

	}

	private void deleteBoard(int boardNo) {
		// "정말 삭제 하시겠습니까?(Y/N)" -- 제대로 입력 될 떄 까지
		// -> 'Y' 입력시
		// -> 보안문자 생성
		// -> 보안문자가 일치하는 경우에만 삭제 진행한다.
		
		System.out.println("\n[게시글 삭제]\n");
		char ch = ' ';
		int result = 0;
		
		while(true) {
			
			System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
			ch = sc.next().toUpperCase().charAt(0);
			
			if(ch == 'Y' || ch =='N') { // 반복 종료
				break;
			}else {
				System.out.println("'Y' 또는 'N'을 입력하세요.\n");
			}
		}
		
		if(ch == 'Y') { // 삭제하려는 경우
			String cap = capcha();
			System.out.print("다음 보안문자를 입력해주세요 >>" + cap);
			
			System.out.print("보안 문자 입력 : ");
			String input = sc.next();
			
			if(input.equals(cap)) { // 입력 받은 문자열과 보안 문자가 같을 때
				// 삭제 구문
			try {	
				
				result = service.deleteBoard(boardNo);
			
				if(result > 0) System.out.println(boardNo + "번 개시글 삭제 완료");
				else System.out.println("삭제 실패");
				
				
			}catch(Exception e) {
				System.out.println("\n<게시글 삭제 중 예외 발생>\n");
				e.printStackTrace();
			}
				
			}else {
				// 취소
				System.out.println("\n 보안문자가 일치하지 않습니다.(삭제 취소)\n");
			}
		}else {
			// 삭제 취소
			System.out.println("\n 삭제를 취소했습니다. \n");
		}
		
	}

	/** 보안문자 생성 메소드(랜덤 영어소문자 5개)
	 * @return cap
	 */
	private String capcha() {
		String cap = "";
		
		for(int i = 0; i < 5; i++) {
			cap += (char)(Math.random() * 26 + 'a');
					// int 형변환 : 97 ~ 122
					// char 형변환 : 'a' ~ 'z'
		}
		return cap;
	}

}
