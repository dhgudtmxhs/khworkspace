package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.community.board.model.dao.BoardDAO;
import edu.kh.community.board.model.vo.Board;
import edu.kh.community.board.model.vo.BoardDetail;
import edu.kh.community.board.model.vo.BoardImage;
import edu.kh.community.board.model.vo.Pagination;
import edu.kh.community.common.Util;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	/** 게시글 목록 조회 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(int type, int cp) throws Exception{

		Connection conn = getConnection();
		
		// 1. 게시판 이름 조회 DAO 호출
		String boardName = dao.selectBoardName(conn, type);
		
		// 2-1. 특정 게시판 전체 게시글 수 조회 DAO 호출
		int listCount = dao.getListCount(conn, type);
		
		// 2-2. 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
		Pagination pagination = new Pagination(cp, listCount); // currentPage = cp , 
		
		System.out.println(pagination);
		
		// 3. 게시글 목록 조회
		
		List<Board> boardList = dao.selectBoardList(conn, pagination, type); // type= 몇번게시판에서
				
		// 4. Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map; // Map 객체 반환
		
	}

	/** 게시글 상세조회 Service
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		// 1) 게시글(BOARD 테이블) 관련 내용만 조회
		BoardDetail detail = dao.selectBoardDetail(conn, boardNo);
		
		if(detail != null) { // 게시글 상세 조회 결과가 있을 경우에만
			
			// 2) 게시글에 첨부된 이미지(BOARD_IMG 테이블) 조회
			List<BoardImage> imageList = dao.selectImageList(conn, boardNo);
			
			// -> 조회된 imageList를 BoardDetail 객체에 세팅 // 지금 5행이 list에 담겨이씀
			detail.setImageList(imageList); // private List<BoardImage> imageList; 
			
		}
		close(conn);
		
		return detail;
	}

	
	/** 게시글 등록 Service
	 * @param detail
	 * @param imageList
	 * @param boardCode
	 * @return boardNo
	 * @throws Exception
	 */
	public int insertBoard(BoardDetail detail, List<BoardImage> imageList, int boardCode) throws Exception{
		
		Connection conn = getConnection();
		
		// 1. 다음 작성할 게시글 번호 얻어오기
		// -> BOARD 테이블 INSERT / BOARD_IMG 테이블 INSERT / 반환값 (상세조회 번호)
		int boardNo = dao.nextBoardNo(conn); // 밑에서 쓰기 위해 시퀀스 게시글 번호 가져오기
		
		// 2. 게시글 부분만 삽입(detail, boardCode 사용)
		detail.setBoardNo(boardNo); // 조회된 다음 게시글 번호 세팅
		
		// 1) XSS 방지 처리(제목/내용) 에 스크립트 적거나 하는거
		detail.setBoardTitle(Util.XSSHandling( detail.getBoardTitle() ) );
		detail.setBoardContent(Util.XSSHandling( detail.getBoardContent() ) );
		
		// 2) 개행문자 처리(내용)
		detail.setBoardContent(Util.newLineHandling( detail.getBoardContent() ) );
		
		int result = dao.insertBoard(conn, detail, boardCode);
		
		if(result > 0) { // 게시글 DB BOARD TABLE에 삽입 성공 시  
			
			// 3. 이미지 정보만 삽입(imageList 사용)
			for(BoardImage image : imageList) { // 하나씩 꺼내서 DAO 수행
				image.setBoardNo(boardNo); // 게시글 번호 세팅
				
				result = dao.insertBoardImage(conn, image); // executeUpdate를 for문으로 한 개 씩 돌리겠다.
			
				if(result == 0) { // for문 안이라 한 번의 executeUpdate가 실패하면 
					break;
				}
				
			} // for문 끝
			
			
		} // if문 끝 (게시글 삽입 성공)
		
		if(result > 0) { 
			commit(conn);
		
		}else { // 2, 3 번에서 한 번이라도 실패한 경우 // 위에서 result == 0 일떄 break;
			rollback(conn);
			boardNo = 0; // 게시글 번호를 0으로 바꿔서 실패했음을 컨트롤러로 전달해준다.
		}
		
		close(conn);
		
		return boardNo;
	}

	/** 게시글 수정 Service
	 * @param detail
	 * @param imageList
	 * @param deleteList
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(BoardDetail detail, List<BoardImage> imageList, String deleteList) throws Exception {

		Connection conn = getConnection();
		
		// 1. 게시글 부분(제목, 내용, 마지막 수정일)
		
		// 1) XSS 방지 처리(제목, 내용)
		detail.setBoardTitle(Util.XSSHandling(detail.getBoardTitle()));
		detail.setBoardContent(Util.XSSHandling(detail.getBoardContent()));
		// 2) 개행문자 처리(내용)
		detail.setBoardContent(Util.newLineHandling(detail.getBoardContent()));
		
		// 3) DAO 호출
		int result = dao.updateBoard(conn, detail);
		
		if(result == 1) {
			
			// 2. 이미지 부분 수정(기존 -> 변경, 없다가 -> 추가)
			for(BoardImage img : imageList) {
				
				img.setBoardNo(detail.getBoardNo()); // 게시글 번호 세팅
				
				// img(변경명 : a.jpg / 원본명 : 1.jpg / 게시글번호 : 1526 / 이미지레벨 : 4)
				
				/*
				 		UPDATE BOARD_IMG SET IMG_RENAME = ?, IMG_ORIGINAL = ?
						WHERE BOARD_NO = ? AND IMG_LEVEL = ?
				 */
				
				// 이미지 1개씩 수정 (for문 안임)
				result = dao.updateBoardImage(conn, img);
				
				if(result == 1) {
				
				}
				
				if(result == 0){ //result == 0 : 수정 실패 -> 기존에 없다가 새로 추가된 이미지
								// img_level = 4를 for문 돌면서 수정에서 넣었는데 where로 찾으니까 원래 없었던 경우에 수정 실패가 나서 result == 0 이 오게 됨
								// -> insert를 진행해야 한다.
					result =  dao.insertBoardImage(conn, img);
					
				}
				
			} // 향상된 for문 끝

			// 3. 이미지 삭제
			// deleteList ( "1,2,3" 이런 모양, 없으면 ""(빈 문자열) )
			
			if(!deleteList.equals("")){ // 삭제된 이미지 레벨이 기록되어 있을 때만 삭제를 하겠다.
			
				result = dao.deleteBoardImage(conn, deleteList, detail.getBoardNo());
				
			}
			
		} // 게시글 수정 성공 시 (if 문 끝)
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}	

}
