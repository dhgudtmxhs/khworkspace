package edu.kh.project.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;

@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	/* 목록 조회 : /board/1?cp=1 (cp : current page(현재 페이지) << 쿼리스트링으로 표현
	 * 상세 조회 : /board/1/1500?cp=1
	 * 
	 * ** 컨트롤러 따로 생성 예정 **
	 * 삽입 : /board2/insert?code=1 << 시작주소부터 다르게 함 (code == BOARD_CODE == 게시판 종류)
	 * 수정 : /board2/update?code=1&no=1500 (no == BOARD_NO, 게시글 번호)
	 * 삭제 : /board2/delete?code=1&no=1500 
	 * */

	
	// @PathVariable
	// URL 경로에 있는 값을 매개변수로 이용할 수 있게 하는 어노테이션
	// 게시판 들어가면 /board/1 , /board/5 이런식으로 주소가 나옴
	
	// + request scope 범위로 세팅
	// 이 때, 세팅되는 이름은 @PathVariable("boardCode") 의 이름과 같음
	
	// /board?code=1
	// /board?code=2 이런식으로 원래 쓰던 쿼리스트링 형식으로도 쓸 수 있지만
	
	// @PathVariable을 사용하는 경우
	// - 자원(resource)을 구분/식별할 때 사용
	// ex) https://github.com/UserName
	// ex) /board/1 -> 1번(공지사항) 게시판
	// ex) /board/2 -> 2번(자유 게시판) 게시판
	
	
	// @Query String을 사용하는 경우
	// - @PathVaribale 외의 모든 경우일때 사용
	// - 정렬, 필터링 // 주로 필터링, 정렬, 검색과 같이 선택적인 조건이나 파라미터를 전달해야 할 때 사용됩니다.
	// ex) search.naver.com?query=날씨 // 
	// ex) search.naver.com?query=점심 // 선택적 조건 느낌?
	// ex) /board2/insert?code=1
	// ex) /board2/insert?code=2
	// -> 삽입이라는 공통된 동작 수행
	//	  단, code에 따라 어디에 삽입할 지 지정(필터링)
	
	// ex) board/list?order=recent (최신순)
	// ex) board/list?order=most (인기순)
	
	// 둘 중 뭘 써야할지 헷갈리는 부분이 있음 -> 팀 내 상의
	
	// @PathVariable("boardCode") int boardCode 부분 때문에 @GetMapping("/{boardCode}")와 같이 경로를 설정할 수 있습니다.
	// 게시글 목록 조회				// controller의 mapping = "/board"
	@GetMapping("/{boardCode}") // <a href="/board/${boardType.BOARD_CODE}">
	public String selectBoardList(@PathVariable("boardCode") int boardCode
								// getMapping("/{boardCode}") 와 같은 값
								 ,@RequestParam(value="cp", required=false, defaultValue="1") int cp 
								 // cp가 없을 경우를 대비 -> 없으면 1
								 ,Model model) {
		//boardCode 확인
		//System.out.println("boardCode : " +  boardCode);
		
		// 게시글 목록 조회 서비스 호출
		Map<String, Object> map = service.selectBoardTypeList(boardCode, cp);
		
		model.addAttribute("map", map);
		// model.addAttribute(map); 하면 key, value 둘다 객체돼서? 이렇게 쓰면 안됨
		// 조회 결과를 request scope에 세팅 후 forward
		
		return "board/boardList";
	}
	
	// @PathVariable : 주소에 지정된 부분을 변수에 저장 , request scope 세팅
	
	// 게시글 상세 조회
	@GetMapping("/{boardCode}/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo
							 ,@PathVariable("boardCode") int boardCode
							 ,Model model 								
							 ,RedirectAttributes ra) { 
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		// 게시글 상세 조회 서비스 호출
		Board board = service.selectBoard(map);
		
		String path = null;
		
		if(board != null) { // 조회 결과가 있을 경우
 			
			path = "board/boardDetail"; // forward할 경로
			model.addAttribute("board", board);
			
		}else { // 조회 결과가 없을 경우
			
			path = "redirect:/board/" + boardCode; // 게시판 첫페이지로 리다이렉트 (pathvariable)
			
			ra.addFlashAttribute("message", "해당 게시글이 존재하지 않습니다.");
			
		}
		
		return path;
		//  <a href="/board/${boardCode}/${board.boardNo}?cp=${pagination.currentPage}">${board.boardTitle}</a>
		//  http://localhost/board/2/1500?cp=1
		
	}
	
}
