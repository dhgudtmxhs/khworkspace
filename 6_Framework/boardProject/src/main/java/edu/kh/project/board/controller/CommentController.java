package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;

// @Controller + @ResponseBody
@RestController // 요청 / 응답 처리 ( 지금 모든 요청 응답이 비동기 )
// -> REST API 구축하기 위한 Controller
public class CommentController {

	@Autowired
	private CommentService service;

	// 댓글 목록 조회
	@GetMapping(value = "/comment", produces="application/json; charset=UTF-8")
	public List<Comment> select(@RequestParam("boardNo") int boardNo) {
		return service.select(boardNo); // HttpMessageConverter가 List -> JSON으로 변환
	}

	// 댓글 삽입
	@PostMapping(value = "/comment")
	public int insert(@RequestBody Comment comment) { // HttpMessageConverter dto, map으로 알아서 바꿔준다 
		// 요청 데이터(JSON)을
		// HttpMessageConverter가 해석해서 Java 객체(Comment)에 대입 해준다.

		/*
		   const data = {"commentContent" : commentContent.value,
			                  "memberNo" : loginMemberNo,
			                  "boardNo" : boardNo} 
		
		 * public class Comment {
			    private String commentContent;
			    private int boardNo	;
			    private int memberNo;
		   }

		 * */
		return service.insert(comment);
	}
	
	@DeleteMapping("/comment")
	public int delete(@RequestBody int commentNo) { // body에 하나밖에 없음
		// ajax 요청 시 body에 담겨있는 하나밖에 없는 데이터는
		// 매개변수 int commentNo에 담기게 된다.

		return service.delete(commentNo);
	}
	
	@PutMapping("/comment")
	public int update(@RequestBody Comment comment) {
		return service.update(comment);
	}
	
	
	

}
