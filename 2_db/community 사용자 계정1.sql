SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_NICK = ?
AND SECESSION_FL = 'N';

SELECT MEMBER_EMAIL, MEMBER_NICK, MEMBER_TEL, MEMBER_ADDR, TO_CHAR(ENROLL_DT, 'YYYY"년" MM"월" DD"일"') AS ENROLL_DATE FROM MEMBER
WHERE MEMBER_EMAIL = ?;

		SELECT MEMBER_EMAIL, MEMBER_NICK, MEMBER_TEL, MEMBER_ADDR, TO_CHAR(ENROLL_DT, 'YYYY"년" MM"월" DD"일"') AS ENROLL_DATE FROM MEMBER
		WHERE MEMBER_EMAIL = 'gudtjr1355@gmail.com';
        
-- 회원 목록 조회(회원 번호, 이메일 , 닉네임)
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICK
FROM MEMBER
WHERE SECESSION_FL = 'N'
ORDER BY MEMBER_NO ASC;

-------------------------------------------------------------------------------

-- "" 쌍따옴표가 없으면 테이블명, 컬럼명, 시퀀스 명 등을 무조건 대문자로만 저장하게 된다.
-- "" 쌍따옴표가 있으면 대소문자를 구분한다.


-- 게시판 종류
DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CD"	NUMBER           PRIMARY KEY,
	"BOARD_NM"	VARCHAR2(50)     NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


-- 게시판 (게시글 저장 테이블)
DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"UPDATE_DT"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CD"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';

COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';

COMMENT ON COLUMN "BOARD"."UPDATE_DT" IS '마지막 수정일';

COMMENT ON COLUMN "BOARD"."READ COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자회원번호';

COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE BOARD
ADD PRIMARY KEY(BOARD_NO); -- 제약조건명 생략하고 추가 -> (SYS_XXXXX) 형식으로 나옴

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_CD" -- 제약조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블 BOARD_TYPE의 PK와 연결됨.

ALTER TABLE BOARD
ADD CONSTRAINT "CHK_BOARD_ST" -- 체크 제약조건 걸겠다.
CHECK ("BOARD_ST" IN('N', 'Y')); -- N, Y 둘 중 하나만 들어오게 하겠다.

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_MEMBER"
FOREIGN KEY("MEMBER_NO")
REFERENCES MEMBER; -- MEMBER의 PK 참조하겠다.

-- BOARD NO용 시퀀스
CREATE SEQUENCE SEQ_BOARD_NO1;
CREATE SEQUENCE SEQ_BOARD_NO2;
CREATE SEQUENCE SEQ_BOARD_NO3;

-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1, '공지사항');
INSERT INTO BOARD_TYPE VALUES(2, '자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3, '질문 게시판');

SELECT * FROM BOARD_TYPE;

-- BOARD 테이블에 샘플 데이터 삽입(PL/SQL) 이용

BEGIN
    FOR I IN 1..2 LOOP -- I가 증가하는 숫자, 1부터 500까지 반복(FOR문) for(){ <- 까지에 해당함 닫는괄호 없음

        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO2.NEXTVAL, 
               SEQ_BOARD_NO2.CURRVAL || '번째 게시글',
               SEQ_BOARD_NO2.CURRVAL || '번째 게시글 내용입니다.',
               DEFAULT,
               DEFAULT,
               DEFAULT,
               DEFAULT,
               126, -- 회원번호
               1); -- 게시판 이름
    
    END LOOP; -- }

END;
/
COMMIT;

ALTER TABLE MEMBER ADD ADMIN_FL CHAR(1);
ALTER TABLE MEMBER
ADDCHECK(ADMIN_FL IN('T', 'F'));

-- 공지사항 게시판 확인
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD = 1;

-- 자유 게시판 조회
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD = 2;

-- 질문 게시판 조회
SELECT COUNT(*) FROM BOARD WHERE BOARD_CD = 3;

-- 게시판 이름 조회
SELECT BOARD_NM FROM BOARD_TYPE
WHERE BOARD_CD = 3;

commit;

-- 특정 게시판의 전체 게시글 수 조회
-- (단, 삭제글은 제외)
SELECT COUNT(*) FROM BOARD
WHERE BOARD_CD = 1
AND BOARD_ST = 'N';

-- 특정 게시판에서 일정한 범위의 목록 조회
    
SELECT * FROM(
    
    SELECT ROWNUM RNUM, A.* FROM    (SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICK, TO_CHAR(CREATE_DT, 'YYYY-MM-DD') AS CREATE_DT, READ_COUNT
                                    FROM BOARD
                                    JOIN MEMBER USING(MEMBER_NO)
                                    WHERE BOARD_CD = 1 
                                    AND BOARD_ST = 'N'
                                    ORDER BY BOARD_NO DESC) A

)
WHERE RNUM BETWEEN 11 AND 20; -- ROWNUM에 별칭 안주면 무조건 1부터 시작함


SELECT B.* FROM MEMBER M
JOIN BOARD B ON(M.MEMBER_NO = B.MEMBER_NO);

-- 게시판 이미지 테이블 생성
CREATE TABLE BOARD_IMG(
    
        IMG_NO NUMBER PRIMARY KEY,
        IMG_RENAME VARCHAR2(500) NOT NULL,
        IMG_ORIGINAL VARCHAR2(500) NOT NULL,
        IMG_LEVEL NUMBER NOT NULL,
        BOARD_NO NUMBER REFERENCES BOARD
);

COMMENT ON COLUMN BOARD_IMG.IMG_NO IS '이미지 번호';
COMMENT ON COLUMN BOARD_IMG.IMG_RENAME IS '이미지 저장 경로 + 변경명';
COMMENT ON COLUMN BOARD_IMG.IMG_ORIGINAL IS '이미지 원본명';
COMMENT ON COLUMN BOARD_IMG.IMG_LEVEL IS '이미지 위치 지정 번호';
COMMENT ON COLUMN BOARD_IMG.BOARD_NO IS '게시글 번호';

-- 이미지 번호 시퀀스 생성
CREATE SEQUENCE SEQ_IMG_NO1 NOCACHE; -- 시퀀스 1씩

-- 샘플 데이터
INSERT INTO BOARD_IMG VALUES(
        SEQ_IMG_NO1.NEXTVAL, '/resources/images/board/sample1.jpg', 'cat1.jpg', 0, 500
);

INSERT INTO BOARD_IMG VALUES(
        SEQ_IMG_NO1.NEXTVAL, '/resources/images/board/sample2.jpg', 'cat2.jpg', 1, 500
);

INSERT INTO BOARD_IMG VALUES(
        SEQ_IMG_NO1.NEXTVAL, '/resources/images/board/sample3.jpg', 'cat3.jpg', 2, 500
);

INSERT INTO BOARD_IMG VALUES(
        SEQ_IMG_NO.NEXTVAL, '/resources/images/board/sample4.jpg', 'cat4.jpg', 3, 500
);

INSERT INTO BOARD_IMG VALUES(
        SEQ_IMG_NO.NEXTVAL, '/resources/images/board/sample5.jpg', 'cat5.jpg', 4, 500
);

COMMIT;

-- 게시글 상세 조회
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT,
    TO_CHAR(CREATE_DT, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') CREATE_DT,
    TO_CHAR(UPDATE_DT, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') CREATE_DT,
    READ_COUNT, MEMBER_NICK, PROFILE_IMG, MEMBER_NO, BOARD_NM
FROM BOARD
JOIN MEMBER USING(MEMBER_NO)
JOIN BOARD_TYPE USING(BOARD_CD)
WHERE BOARD_NO = 500
AND BOARD_ST = 'N';

-- 특전 게시글에 첨부된 이미지 목록 조회
SELECT * FROM BOARD_IMG
WHERE BOARD_NO = 500
ORDER BY IMG_LEVEL;









