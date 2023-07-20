package edu.kh.community.board.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.community.board.model.dao.ReplyDAO;
import edu.kh.community.board.model.vo.Reply;

public class ReplyService {

	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회 service
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List selectReplyList(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Reply> replyList = dao.selectReplyList(conn, boardNo);
		
		close(conn);
		
		return replyList;
	}

	
	
}
