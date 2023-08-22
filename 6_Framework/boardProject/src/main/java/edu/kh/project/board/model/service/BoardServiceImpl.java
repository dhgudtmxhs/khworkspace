package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.boardDAO;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private boardDAO dao;

	// 게시판 종류 목록 조회
	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return dao.selectBoardTypeList();
	}

	
	// 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardTypeList(int boardCode, int cp) {
		
		// 1. 특정 게시판의 삭제되지 않은 게시글 수 조회
		int listCount = dao.getListCount(boardCode); // 어느게시판인지만 구분
		
		// 2. 1번 조회 결과 + cp를 이용해 Pagination 객체 생성
		// -> 내부 필드가 모두 계산되어 초기화된다.
		Pagination pagination = new Pagination(cp, listCount);
		
		// 3. 특정 게시판에서
		// 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
		
		// 전체 게시글 수 : 100개,  현재 페이지 2페이지 -> 90~81 까지 조회
		
		// 어떤 게시판(boardCode)에서
		// 몇 페이지(pagination.currentPage)에 대한
		// 게시글 몇 개(pagination.limit) 조회
		
		List<Board> boardList = dao.selectBoardList(pagination, boardCode);
		
		// 4. pagination, boardList를 Map에 담아서 반환
		Map<String, Object> map = new HashMap<>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
				
	}

	// 게시글 상세 조회
	// join하면 쓸데없는 행? 들이 같이 딸려나와서 select 3번하는게 더 낫다.
	@Override
	public Board selectBoard(Map<String, Object> map) {
		return dao.selectBoard(map);
	}
	
	
	
	
	
}
