package edu.kh.project.board.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.member.model.dto.Member;

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


	// /board/like 같은 애들도 다 pathvariable이 받게 됨 /board/1 이런식과 같음
	// 문제점 : 요청 주소와 @PathVariable로 가져다 쓸 주소의 레벨이 같다면
	// 		  구분하지 않고 모두 매핑되는 문제가 발생한다.
	//	    -> 요청을 했는데 원하는 메소드가 실행이 안된다.
	// 해결방법 : @PathVariable 지정 시 정규 표현식 사용
	// 								{키:정규표현식}

	//경로 변수는 URL 경로의 다른 부분에서 값을 캡처하는 데 사용됩니다. URL 패턴 내에서 중괄호 '{}'로 묶여 있습니다. 
	//'@GetMapping("/{boardCode}")'를 사용하여 메서드 매핑을 정의할 때 'boardCode'라는 경로 변수를 사용하여 URL 패턴을 지정합니다.
	// 예를 들어:'/board/1'은 URL 패턴 '/board/{boardCode}'와 일치하며 'boardCode' 경로 변수로 '1' 값을 캡처합니다.
	// 요악하면, 중괄호 '{}'는 URL 패턴에서 경로 변수를 정의하고 식별하는 데 사용되며
	//'@GetMapping' 주석에서 경로 변수를 URL에서 추출하여 메서드 매개 변수로 전달해야 하는 위치를 올바르게 나타내는 데 필요합니다.
	
	// 경로 변수와 정규식 패턴을 조합하는 것은 그냥 Spring의 기능 중 하나임 

	// @PathVariable("boardCode") int boardCode 부분 때문에 @GetMapping("/{boardCode}")와 같이 경로를 설정할 수 있습니다.
	// 게시글 목록 조회				// controller의 mapping = "/board"
	@GetMapping("/{boardCode:[0-9]+}") // <a href="/board/${boardType.BOARD_CODE}">
	// boardCode는 1자리 이상 숫자 +(1개이상)
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
		return "board/boardList"; // map에 put된 boardCode
	}

	// @PathVariable : 주소에 지정된 부분을 변수에 저장 , request scope 세팅

	// 게시글 상세 조회
	@GetMapping("/{boardCode}/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo
			,@PathVariable("boardCode") int boardCode
			,Model model 								
			,RedirectAttributes ra
			,@SessionAttribute(value="loginMember", required=false /*필수는 아니도록. 없으면 null*/) Member loginMember 

			// 쿠키를 이용한 조회수 증가에 사용
			,HttpServletRequest req
			,HttpServletResponse resp

			) throws ParseException {

		Map<String, Object> map = new HashMap<>();

		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);

		// 게시글 상세 조회 서비스 호출
		Board board = service.selectBoard(map);

		String path = null;

		if(board != null) { // 조회 결과가 있을 경우

			// ------------------------------------------------
			// 현재 로그인 상태인 경우
			// 로그인한 회원이 해당 게시글에 좋아요를 눌렀는지 확인

			if(loginMember != null) { // @SessionAttribute
				// 회원 번호를 map에 추가 (위에서 쓰던 map임)
				map.put("memberNo", loginMember.getMemberNo());
				// map엔 boardCode, boardNo, memberNo 담긴 상태



				// 좋아요 여부 확인 서비스 호출
				int result = service.boardLikeCheck(map);


				if(result > 0) { 	// 좋아요 누른적 있다면
					model.addAttribute("likeCheck", "on"); // on 자리 아무거나 써도됨 (K:V)
					// model -> request scope고 forward해서 jsp에서  <c:if test="${empty likeCheck}"> 가 가능하다.
					// 처음 상세페이지 띄울 때 확인만 하고 빈하트 꽉찬하트로 구분한 뒤
					// js에서 클릭할때마다 insert, delete하고 좋아요 수 update까지
				}
			}

			// ------------------------------------------------

			// 쿠키를 이용한 조회수 증가 처리

			// 1) 비회원, 로그인한 회원의 글이 아닌 경우
			if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {

				// 2) 쿠키 얻어오기
				Cookie c = null;

				// 요청에 담겨있는 모든 쿠키 얻어오기
				Cookie[] cookies = req.getCookies();

				if(cookies != null) { // 쿠키가 존재할 경우

					// 쿠키 중 "readBoardNo"라는 쿠키를 찾아서 c에 대입
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("readBoardNo")) {
							c = cookie;
							break;

						}

					}

				}

				// 3) 기존 쿠키가 없거나(c == null)
				//	  존재는 하나 현재 게시글 번호가
				//    쿠키에 저장되지 않은 경우(오늘 해당 게시글을 본 적이 없다)
				int result = 0;

				if(c == null) {

					// 쿠키가 존재 X -> 하나 새로 생성
					c = new Cookie( "readBoardNo", "|" + boardNo + "|" ); // 톰캣 8.5 이상부터는 쿠키에 ,/=띄어쓰기 작성 불가능
					// @PathVariable

					// 조회수 증가하는 서비스 호출
					result = service.updateReadCount(boardNo);

				} else {

					// 쿠키가 있다
					// -> 현재 게시글 번호가 쿠키에 있는지 확인

					// Cookie.getValue() : 쿠키에 저장된 모든 값을 읽어와서 String으로 반환해준다.

					// String.indexOf("문자열")
					// : 찾는 문자열이 몇 번 인덱스에 존재하는지 반환
					//   단, 없으면 -1을 반환
					if(c.getValue().indexOf("|" + boardNo + "|") == -1) { 
						// 쿠키에 현재 게시글 번호가 없다면

						// 기존 값에 게시글 번호를 추가해서 다시 세팅
						c.setValue(c.getValue() + "|" + boardNo + "|");

						// 조회수 증가 서비스 호출
						result = service.updateReadCount(boardNo);

					}

				} // 3) 종료

				// 4) 조회수 증가 성공 시
				// 쿠키가 적용되는 경로, 수명(당일 23시 59분 59초) 지정

				if(result > 0) {

					// 조회된 board 조회 수와 DB 조회 수 동기화
					board.setReadCount(board.getReadCount() + 1);

					// 적용 경로 설정
					c.setPath("/"); // "/" 이하 경로 요청시 쿠키를 서버로 전달한다.

					// 수명 지정
					Calendar cal = Calendar.getInstance(); // 싱글톤 패턴 (미리 만들어진 하나의 객체만을 이용해서 코드를 수행한다.)
					cal.add(cal.DATE, 1); // 1일 세팅

					// 날짜 표기법 변경 객체 (DB의 TO_CHAR()와 비슷)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

					// Java.util
					Date a = new Date(); // 현재 시간

					Date temp = new Date(cal.getTimeInMillis()); // 내일 (24시간 후)
					// 2023-08-24 12:17:40 에서 0:0:0으로

					Date b = sdf.parse(sdf.format(temp)); // 내일 0시 0분 0초

					// 내일 0시 0분 0초 - 현재 시간 -> 쿠키의 수명
					long diff = (b.getTime() - a.getTime()) / 1000;
					// 내일 0시 0분 0초까지 남은 시간을 초 단위로 반환

					c.setMaxAge((int)diff); // 수명 설정

					resp.addCookie(c); // 응답 객체를 이용해서 클라이언트에게 전달

				}

			}

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

	// json 넘어올때 똑같은 dto가있으면 dto로 바꾸고 아니면 map으로 바꾼다.
	@PostMapping(value = "/like")
	@ResponseBody // 반환되는 값이 비동기 요청한 곳으로 돌아가게 함
	public int like(@RequestBody Map<String, Integer> paramMap) {

		System.out.println(paramMap);
		return service.like(paramMap);
		
	}

}



