package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시판 종류 목록 조회
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList(); // intercepter

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectBoardTypeList(int boardCode, int cp); // boardController 
	// intercepter 는 list안의 map(게시판 전부 다 갖고옴), boardcontroller는 map(게시판 하나씩 갖고옴)
	/** 게시글 상세 조회
	 * @param map
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);

	/** 게시글 좋아요
	 * @param map
	 * @return result
	 */
	int boardLikeCheck(Map<String, Object> map);

	/** 좋아요 처리 서비스
	 * @param paramMap
	 * @return count
	 */
	int like(Map<String, Integer> paramMap);

	/** 조회수 증가 서비스
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);

	
	
	
	
}
