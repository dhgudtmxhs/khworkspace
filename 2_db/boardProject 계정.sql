DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,

	"MEMBER_NICKNAME" VARCHAR2(30) NOT NULL,
	
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDR"	VARCHAR2(300)		NULL,
	"PROFILE_IMG"	VARCHAR2(300)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호(암호화 적용)';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 이름(별명)';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(- 없음)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 저장 경로';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';

COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N:탈퇴X, Y: 탈퇴O)';

COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원권한(1:일반, 2:관리자)';


ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

-- 탈퇴여부 CHECK 제약 조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_MEMBER_DEL_FL" 
CHECK("MEMBER_DEL_FL" IN ('N', 'Y'));

-- 권한 CHECK 제약 조건
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_AUTHORITY" 
CHECK("AUTHORITY" IN (1, 2));


-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;


-- 샘플 계정 추가
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@kh.or.kr', 'pass01!'
	, '유저일', '01012341234', '06234,,서울 강남구 테헤란로 14길 6,,5층',
	NULL, DEFAULT, DEFAULT, DEFAULT);


INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02@kh.or.kr', 'pass02!'
	, '이번유저', '01043214321', '06234,,서울 강남구 테헤란로 14길 6,,5층',
	NULL, DEFAULT, DEFAULT, DEFAULT);

COMMIT;



-- 로그인 SQL
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME,
	MEMBER_TEL, MEMBER_ADDR, PROFILE_IMG, AUTHORITY,
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE 
FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_PW = 'pass01!'
;

-- user01의 비밀번호 변경
UPDATE "MEMBER" SET
MEMBER_PW = '$2a$10$F0AXxoL89maHI6gz7LbtrOwdJQg1MDNyyeE1JaWp5//EAJYBboYju',

COMMIT;

-- 회원정보 변경
UPDATE "MEMBER"
SET MEMBER_NICKNAME = 'TEST', MEMBER_TEL = 'TEST', MEMBER_ADDR = 'TEST'
WHERE MEMBER_NO = 'TEST';
ROLLBACK;

-- 회원 번호 일치 여부 확인
SELECT MEMBER_PW FROM "MEMBER"
WHERE MEMBER_NO = 'TEST';

-- 회원 비밀번호 변경
UPDATE "MEMBER" SET MEMBER_PW = 'TEST' WHERE MEMBER_NO = 'TEST';

-- 회원 탈퇴 처리
UPDATE "MEMBER" 
SET AUTHORITY = '2'
WHERE MEMBER_NO = 'TEST';

-- 이메일로 닉네임찾기
SELECT MEMBER_NICKNAME FROM MEMBER
WHERE MEMBER_EMAIL = 'TEST';

-- 이메일 중복검사
SELECT COUNT(*) FROM MEMBER
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_DEL_FL = 'N';

-- 이메일로 회원 정보 조회
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_TEL, 
NVL(MEMBER_ADDR, '미작성') AS MEMBER_ADDR,
TO_CHAR(ENROLL_DATE, 'YYYY"년"MM"월"DD"일"HH24"시"MI"분"SS"초"') AS ENROLL_DATE
FROM MEMBER
WHERE MEMBER_EMAIL = 'user01@kh.or.kr'
AND MEMBER_DEL_FL = 'N';

--이메일이 일부라도 일치하는 모든 회원 조회
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME
FROM MEMBER
WHERE MEMBER_EMAIL LIKE '%${input}%'
AND MEMBER_DEL_FL = 'N'
ORDER BY MEMBER_NO;


--이메일 인증키 테이블
--DROP TABLE "AUTH_KEY";

CREATE TABLE "AUTH_KEY" (
   "AUTH_KEY_NO"   NUMBER      NOT NULL,
   "CODE"   CHAR(6)      NOT NULL,
   "EMAIL"   VARCHAR2(50)      NOT NULL,
   "CREATE_TIME"   DATE   DEFAULT SYSDATE   NOT NULL
);

COMMENT ON COLUMN "AUTH_KEY"."AUTH_KEY_NO" IS '인증키 구분 번호(SEQ_AUTH_KEY_NO)';

COMMENT ON COLUMN "AUTH_KEY"."CODE" IS '코드';

COMMENT ON COLUMN "AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "AUTH_KEY" ADD CONSTRAINT "PK_AUTH_KEY" PRIMARY KEY (
   "AUTH_KEY_NO"
);

CREATE SEQUENCE SEQ_AUTH_KEY_NO NOCACHE;

UPDATE "AUTH_KEY" SET
CODE = #{authkey},
CREATE_TIME = sysdate
WHERE EMAIL = #{email};

INSERT INTO "AUTH_KEY" VALUES(SEQ_AUTH_KEY_NO.NEXTVAL, #{authkey}, #{email}, DEFAULT);

SELECT * FROM "AUTH_KEY";

SELECT COUNT(*) FROM "AUTH_KEY"
WHERE EMAIL = #{email}
AND CODE = #{inputKey}
;

--------------------------------------------------------------------------------------------------
--drop table board_type;

-- 게시판 종류
CREATE TABLE "BOARD_TYPE"(
   "BOARD_CODE" NUMBER CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY,
   "BOARD_NAME" VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CODE" 
IS '게시판 코드(SEQ_BOARD_CODE)';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NAME" 
IS '게시판 이름';

CREATE SEQUENCE SEQ_BOARD_CODE NOCACHE;

-- 게시판 종류 추가
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '공지사항');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '자유 게시판');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '테스트 게시판');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '질문 게시판');

INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '점심 게시판');

COMMIT;

SELECT * FROM "BOARD_TYPE";

----------------------------------------------------------------------

-- [게시판 DB 설정]

CREATE TABLE "BOARD" (
   "BOARD_NO"   NUMBER      NOT NULL,
   "BOARD_TITLE"   VARCHAR2(150)      NOT NULL,
   "BOARD_CONTENT"   VARCHAR2(4000)      NOT NULL,
   "B_CREATE_DATE"   DATE   DEFAULT SYSDATE   NOT NULL,
   "B_UPDATE_DATE"   DATE      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "BOARD_DEL_FL"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL,
   "BOARD_CODE"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."B_CREATE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."B_UPDATE_DATE" IS '마지막 수정일(수정 시 UPDATE)';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_DEL_FL" IS '삭제 여부(N : 삭제X , Y : 삭제O)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';

COMMENT ON COLUMN "BOARD"."BOARD_CODE" IS '게시판 코드 번호';

----------------------------------------------------------------------

CREATE TABLE "BOARD_IMG" (
   "IMG_NO"   NUMBER      NOT NULL,
   "IMG_PATH"   VARCHAR2(300)      NOT NULL,
   "IMG_RENAME"   VARCHAR2(30)      NOT NULL,
   "IMG_ORIGINAL"   VARCHAR2(300)      NOT NULL,
   "IMG_ORDER"   NUMBER      NOT NULL,
   "BOARD_NO"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호(SEQ_IMG_NO)';

COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 저장 폴더 경로';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '변경된 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '원본 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORDER" IS '이미지 파일 순서 번호';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '이미지가 첨부된 게시글 번호';


----------------------------------------------------------------------


CREATE TABLE "BOARD_LIKE" (
   "BOARD_NO"   NUMBER      NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_NO" IS '게시글 번호';

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '좋아요 누른 회원 번호';


----------------------------------------------------------------------


CREATE TABLE "COMMENT" (
   "COMMENT_NO"   NUMBER      NOT NULL,
   "COMMENT_CONTENT"   VARCHAR2(4000)      NOT NULL,
   "C_CREATE_DATE"   DATE   DEFAULT SYSDATE   NOT NULL,
   "COMMENT_DEL_FL"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "BOARD_NO"   NUMBER      NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL,
   "PARENT_NO"   NUMBER   
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호(SEQ_COMMENT_NO)';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."C_CREATE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DEL_FL" IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '댓글이 작성된 게시글 번호';

COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '댓글 작성자 회원 번호';

COMMENT ON COLUMN "COMMENT"."PARENT_NO" IS '부모 댓글 번호';

----------------------------------------------------------------------


ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
   "BOARD_NO"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "PK_BOARD_IMG" PRIMARY KEY (
   "IMG_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "PK_BOARD_LIKE" PRIMARY KEY (
   "BOARD_NO",
   "MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
   "COMMENT_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
   "MEMBER_NO"
)
REFERENCES "MEMBER" (
   "MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
   "BOARD_CODE"
)
REFERENCES "BOARD_TYPE" (
   "BOARD_CODE"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMG_1" FOREIGN KEY (
   "BOARD_NO"
)
REFERENCES "BOARD" (
   "BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
   "BOARD_NO"
)
REFERENCES "BOARD" (
   "BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
   "MEMBER_NO"
)
REFERENCES "MEMBER" (
   "MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
   "BOARD_NO"
)
REFERENCES "BOARD" (
   "BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
   "MEMBER_NO"
)
REFERENCES "MEMBER" (
   "MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_COMMENT_TO_COMMENT_1" FOREIGN KEY (
   "PARENT_NO"
)
REFERENCES "COMMENT" (
   "COMMENT_NO"
);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE; -- 게시글 번호
CREATE SEQUENCE SEQ_IMG_NO NOCACHE; -- 게시글 이미지 번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글 번호


-- BOARD 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1500 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              SEQ_BOARD_NO.CURRVAL || '번째 게시글',
              SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1, 
              CEIL(DBMS_RANDOM.VALUE(0,5))  -- 0은 나올 확률이 거의? 없음 0이 나올려면 0.00000... 이런식이 되어야한다고 함
      );
   END LOOP;
END;
/

select * from member
where member_no = '1';

select * from board_type;

select count(*) from board;
commit;

--BOARD_CODE가 1(공지사항)인 게시글을 최신순으로 조회 (삭제된글 제외)
SELECT * FROM BOARD
WHERE BOARD_CODE = '1'
AND BOARD_DEL_FL = 'N'
ORDER BY BOARD_NO DESC;

-- COMMENT 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..1000 LOOP
      INSERT INTO "COMMENT" 
      VALUES(SEQ_COMMENT_NO.NEXTVAL, 
            SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
            DEFAULT, DEFAULT,
             CEIL(DBMS_RANDOM.VALUE(0,1500)), -- 1500개 게시글에 대해 1000개의 댓글을 랜덤생성
             1, NULL);
   END LOOP;
END;
/

SELECT * FROM "COMMENT";

COMMIT;

-- 게시글 샘플 이미지 넣기
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 
       '20230821141913_00001.jpg', 'dog1.jpg', 0, 1495);
                                        -- 레벨, --게시글 number 

INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 
       '20230821141913_00002.jpg', 'dog2.jpg', 0, 1494);
       
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 
        '20230821141913_00003.jpg', 'dog3.jpg', 0, 1493);

INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 
        '20230821141913_00004.jpg', 'dog4.jpg', 0, 1486);

INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 
        '20230821141913_00005.jpg', 'dog5.jpg', 0, 1479);

COMMIT;

-- BOARD_CODE로 조회했을 때 제일 위에있는 BOARD_NO 쪽에 넣어주는게 보기 편함
SELECT BOARD_NO FROM BOARD
WHERE BOARD_CODE = 1
ORDER BY 1 DESC;

-- 특정 게시판의 삭제되지 않은 게시글 수 조회
SELECT COUNT(*) FROM BOARD
WHERE BOARD_CODE = #{boardCode}
AND BOARD_DEL_FL = 'N';

-- 특정 게시판의 목록 조회
-- 1. 최신 순서
-- 2. 한 페이지(1~10행)만 조회
-- 3. 삭제된 글 제외

-- mybatis가 없었을 때 해야했던 기본형
-- 1~10행 조회
SELECT * FROM(
    SELECT A.* FROM(
                SELECT ROWNUM NUM, BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME,
                        TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD') B_CREATE_DATE,
                        READ_COUNT
                FROM "BOARD"
                JOIN "MEMBER" USING(MEMBER_NO)
                WHERE BOARD_DEL_FL = 'N'
                AND BOARD_CODE = 1
                ORDER BY BOARD_NO DESC
             ) A
)
WHERE NUM BETWEEN 11 AND 20; 


-- ROWNUM = 가상컬럼 BETWEEN 11~20 안됨 -> ROWNUM에 별칭줌 -> 진짜 컬럼으로 인식이 됨 -> SELECT로 다시 감쌈



-- 마이바티스 o
-- RowBounds 객체 이용
SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME,
        TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD') B_CREATE_DATE,
        READ_COUNT
FROM "BOARD"
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1
ORDER BY BOARD_NO DESC;

    
	SELECT BOARD_NO, BOARD_TITLE, MEMBER_NICKNAME, READ_COUNT, 
            CASE  -- 현재시간 - 생성된 시간 < 1분 미만이면
               WHEN SYSDATE - B_CREATE_DATE < 1/24/60
               THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60 * 60 ) || '초 전'
               WHEN SYSDATE - B_CREATE_DATE < 1/24 -- 1시간 미만이면
               THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24 * 60) || '분 전'
               WHEN SYSDATE - B_CREATE_DATE < 1 -- 1일 미만이면
               THEN FLOOR( (SYSDATE - B_CREATE_DATE) * 24) || '시간 전'
               ELSE TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD')
            END B_CREATE_DATE,
         (SELECT COUNT(*) FROM "COMMENT" C
          WHERE C.BOARD_NO = B.BOARD_NO) COMMENT_COUNT,
          
         (SELECT COUNT(*) FROM BOARD_LIKE L
          WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT,
          
         (SELECT IMG_PATH || IMG_RENAME FROM BOARD_IMG I
         WHERE I.BOARD_NO = B.BOARD_NO 
         AND IMG_ORDER = 0) THUMBNAIL
      FROM "BOARD" B -- 상관쿼리
      JOIN "MEMBER" USING(MEMBER_NO)
      WHERE BOARD_DEL_FL = 'N'
      AND BOARD_CODE = 1
      ORDER BY BOARD_NO DESC;
      
-- 게시글 상세 조회
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_CODE,
       READ_COUNT, MEMBER_NICKNAME, MEMBER_NO, PROFILE_IMG,
       TO_CHAR(B_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') B_CREATE_DATE,
       TO_CHAR(B_UPDATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') B_UPDATE_DATE,
       (SELECT COUNT(*) FROM BOARD_LIKE L WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT
FROM BOARD B                                            -- 메인쿼리 실행했을때 담길?
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 1
AND BOARD_NO = 1495;
      
--- 게시글 좋아요 샘플 데이터 삽입
INSERT INTO BOARD_LIKE VALUES(1495, 1);
INSERT INTO BOARD_LIKE VALUES(1495, 2);
COMMIT;
      
SELECT * FROM BOARD_LIKE;

-- 특정 게시글의 좋아요 개수 카운트 
SELECT COUNT(*) 
FROM BOARD_LIKE L
WHERE L.BOARD_NO = 1495;

-- 특정 게시글에 대한 이미지 조회(IMG_ORDER 오름차순)
SELECT * FROM BOARD_IMG
WHERE BOARD_NO = 1495
ORDER BY IMG_ORDER;

INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL,
        '/resources/images/board/',
        '20230821141913_00001.jpg',
        'dog1.jpg',
        1, 1495);
        
INSERT INTO BOARD_IMG
VALUES(SEQ_IMG_NO.NEXTVAL,
        '/resources/images/board/',
        '20230821141913_00002.jpg',
        'dog2.jpg',
        2, 1495);

commit;

-- 특정 게시글에 대한 댓글 목록 조회(바뀔 예정)
SELECT COMMENT_NO, COMMENT_CONTENT,
    TO_CHAR(C_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') C_CREATE_DATE,
    BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
FROM "COMMENT"
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_NO = 1495
ORDER BY COMMENT_NO;

-- 회원 프로필 이미지 변경
UPDATE MEMBER SET
PROFILE_IMG = '/resources/images/member/flower2.jpg'
WHERE MEMBER_NO = 1;
COMMIT;

-- 좋아요 여부 확인
SELECT COUNT(*) FROM BOARD_LIKE
WHERE BOARD_NO = 1495 -- 게시글 번호
AND MEMBER_NO = 1; -- 로그인한 회원의 번호

	SELECT COMMENT_NO, COMMENT_CONTENT,
    TO_CHAR(C_CREATE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') C_CREATE_DATE,
    BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
	FROM "COMMENT"
	JOIN MEMBER USING(MEMBER_NO)
	WHERE BOARD_NO = 1495   
	ORDER BY COMMENT_NO;
    
    
    		SELECT * FROM
		BOARD_TYPE ORDER BY 1;
        
-- 좋아요 삽입
INSERT INTO BOARD_LIKE VALUES(1495, 4);


-- 좋아요 삭제
DELETE FROM BOARD_LIKE 
WHERE BOARD_NO = 1495
AND MEMBER_NO = 4;

COMMIT;

-- 현재 게시글의 좋아요 개수 조회
SELECT COUNT(*) FROM BOARD_LIKE
WHERE BOARD_NO = 1495;

-- 조회수 증가
UPDATE BOARD 
SET READ_COUNT = READ_COUNT + 1
WHERE BOARD_NO = 1495;

COMMIT;

-- 프로필 이미지 수정
UPDATE MEMBER
SET PROFILE_IMG = 'A'
WHERE MEMBER_NO = 1;

ROLLBACK;

SELECT * FROM BOARD ORDER BY BOARD_NO DESC;

select * from board_img order by img_no desc;
-- 한번에 여러개 INSERT 하기

-- INSERT ALL : 여러 테이블에 동시에 INSERT 하는 구문
--> 시퀀스 생성 구문을 작성하지 못한다. --> 안 씀

INSERT INTO BOARD_IMG
SELECT SEQ_IMG_NO.NEXTVAL, A.*
FROM(SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
        0 IMG_ORDER, 1515 BOARD_NO 
FROM DUAL

UNION ALL -- 합집합 + 교집합

SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
        1 IMG_ORDER, 1515 BOARD_NO 
FROM DUAL

UNION ALL 

SELECT '웹접근경로' IMG_PATH, '변경명' IMG_RENAME, '원본명' IMG_ORIGINAL,
        2 IMG_ORDER, 1515 BOARD_NO 
FROM DUAL) A;

-- 게시글 수정
UPDATE BOARD 
SET BOARD_TITLE = 'test', BOARD_CONTENT = 'TEST'
WHERE BOARD_NO = 1515;

ROLLBACK;

-- 이미지 삭제
DELETE FROM BOARD_IMG
WHERE BOARD_NO = #{boardNo}
AND IMG_ORDER IN(${deleteList}); -- in(1, 2, 3) 형식

-- 이미지 수정
UPDATE BOARD_IMG
SET IMG_PATH = #{imagePath}, IMG_ORIGINAL = #{imageOriginal}, IMG_RENAME = #{imageReName}
WHERE IMG_ORDER =#{imageOrder} AND BOARD_NO = #{boardNo};

