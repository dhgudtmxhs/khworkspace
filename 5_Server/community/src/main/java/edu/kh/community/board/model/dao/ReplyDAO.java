package edu.kh.community.board.model.dao;

import static edu.kh.community.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.community.board.model.vo.Reply;



public class ReplyDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReplyDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = ReplyDAO.class.getResource("/edu/kh/community/sql/reply-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	
	/** 댓글 목록 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{
		List<Reply> replyList = new ArrayList<Reply>();
		
		try {
			
			String sql = prop.getProperty("selectReplyList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Reply reply = new Reply();

				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setCreateDate(rs.getString("CREATE_DT"));
				reply.setBoardNo(rs.getInt("BOARD_NO"));
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setMemberNickname(rs.getString("MEMBER_NICK"));
				reply.setProfileImage(rs.getString("PROFILE_IMG"));
				
				replyList.add(reply);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return replyList;
	}


}
