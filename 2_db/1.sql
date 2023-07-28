UPDATE BOARD SET BOARD_ST = 'Y' WHERE BOARD_NO = ? ;

ROLLBACK;

-- 2번 게시판의 전체 게시글 수 조회
SELECT COUNT(*) FROM BOARD
WHERE BOARD_ST = 'N'
AND BOARD_CD = 2;

-- 2번 게시판에서 제목에 "50"이 포함된 전체 게시글 수 조회
SELECT COUNT(*) FROM BOARD
WHERE BOARD_ST = 'N'
AND BOARD_CD = 2 
AND BOARD_TITLE LIKE '%50%'; -- 제목

-- 2번 게시판에서 내용에 "50"이 포함된 전체 게시글 수 조회
SELECT COUNT(*) FROM BOARD
WHERE BOARD_ST = 'N'
AND BOARD_CD = 2 
AND BOARD_CONTENT LIKE '%50%';

-- 2번 게시판에서 제목 + 내용에 "50"이 포함된 전체 게시글 수 조회
SELECT COUNT(*) FROM BOARD
WHERE BOARD_ST = 'N'
AND BOARD_CD = 2 
AND (BOARD_TITLE LIKE '%50%' OR BOARD_CONTENT LIKE '%50%');

-- 2번 게시판에서 작성자에 "유저일"이 포함된 전체 게시글 수 조회
SELECT COUNT(*) FROM BOARD
JOIN MEMBER USING (MEMBER_NO)
WHERE BOARD_ST = 'N'
AND BOARD_CD = 2 
AND MEMBER_NICK LIKE '%유저일%';

SELECT * FROM(
    
    SELECT ROWNUM RNUM, A.* FROM(
		        SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICK, TO_CHAR(CREATE_DT, 'YYYY-MM-DD') AS CREATE_DT, READ_COUNT
		        FROM BOARD
		        JOIN MEMBER USING(MEMBER_NO)
		        WHERE BOARD_CD = ?
		        AND BOARD_ST = 'N'
                
                -- condition
                
		        ORDER BY BOARD_NO DESC
		    ) A 
		)
		WHERE RNUM BETWEEN ? AND ?


