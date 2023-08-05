DROP TABLE MEMBER;

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		PRIMARY KEY,
	"MEMBER_ID"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(200)		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_NICKNAME"	VARCHAR2(50)		NOT NULL,
	"MEMBER_NAME"	VARCHAR2(20)		NOT NULL,
	"MEMBER_BIRTH"	VARCHAR2(8)		NOT NULL,
	"MEMBER_REGION"	VARCHAR2(50)		NOT NULL,
	"MEMBER_GENDER"	CHAR(3)		NOT NULL,
	"MEMBER_NT"	VARCHAR(10)	DEFAULT 'KOR'	NOT NULL,
	"MEMBER_PHONE"	VARCHAR(20)		NOT NULL,
	"ENROLL_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"ADMIN_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"SECESSION_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_PROFILE"	VARCHAR2(4000)		NULL,
	"MEMBER_MESSAGE"	VARCHAR2(400)		NULL
);

--		SELECT  MEMBER_NO, MEMBER_ID, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_NAME, MEMBER_BIRTH, MEMBER_REGION, MEMBER_GENDER, MEMBER_NT,
--        MEMBER_PHONE, ENROLL_DT, ADMIN_FL, MEMBER_PROFILE, MEMBER_MESSAGE FROM MEMBER
--		WHERE MEMBER_ID = ? AND MEMBER_PW = ? AND SECESSION_FL = 'N'

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ID" IS '회원 아이디';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 닉네임';

COMMENT ON COLUMN "MEMBER"."MEMBER_NAME" IS '회원 이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_BIRTH" IS '회원 생년월일';

COMMENT ON COLUMN "MEMBER"."MEMBER_REGION" IS '회원 활동 지역';

COMMENT ON COLUMN "MEMBER"."MEMBER_GENDER" IS '회원 성별';

COMMENT ON COLUMN "MEMBER"."MEMBER_NT" IS '내국인/외국인';

COMMENT ON COLUMN "MEMBER"."MEMBER_PHONE" IS '휴대폰 번호';

COMMENT ON COLUMN "MEMBER"."ENROLL_DT" IS '가입일';

COMMENT ON COLUMN "MEMBER"."ADMIN_FL" IS '관리자 권한';

COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴여부';

COMMENT ON COLUMN "MEMBER"."MEMBER_PROFILE" IS '회원 이미지파일';

COMMENT ON COLUMN "MEMBER"."MEMBER_MESSAGE" IS '프로필 메시지';

DROP SEQUENCE SEQ_MEMBER_NO;

CREATE SEQUENCE SEQ_MEMBER_NO INCREMENT BY 1;

INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, 'testid', 'testpw', 'testemail', 'testnick', 'testname', 19971030, '서울', '남', DEFAULT, '01033339999', DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYYMMDD'), ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, NULL, NULL);
rollback;
commit;
	SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT,
	    TO_CHAR(CREATE_DT, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') CREATE_DT,
	    TO_CHAR(UPDATE_DT, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') UPDATE_DT,
	    READ_COUNT, MEMBER_NICKNAME, MEMBER_PROFILE, MEMBER_NO, BOARD_NM
		FROM BOARD
		JOIN MEMBER USING(MEMBER_NO)
		JOIN BOARD_TYPE USING(BOARD_CD)
		WHERE BOARD_NO = ?
		AND BOARD_ST = 'N';

SEQ_MEMBER_NO.NEXTVAL, 'testid', 'testpw', 'testemail', 'testnick', 'testname', 
TO_DATE('19971030', 'YYYYMMDD'), '서울', '남', DEFAULT, '01033339999', DEFAULT, DEFAULT, DEFAULT, NULL, NULL;

-- 게시판 종류 

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
   "BOARD_CD"   NUMBER      PRIMARY KEY,
   "BOARD_NM"   VARCHAR2(50)      NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';
COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


-- 게시판 (게시글 저장 테이블)
-- DROP TABLE "BOARD";

--CREATE TABLE "INFO_BOARD" (
--   "FESTIVAL_NO"   NUMBER      NOT NULL,
--   "FESTIVAL_TITLE"   VARCHAR2(150)      NOT NULL,
--   "FESTIVAL_CONTENT"   VARCHAR2(300)      NOT NULL,
--   "FESTIVAL_DT"   VARCHAR2      NULL,
--   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
--   "BOARD_CD"   NUMBER      NOT NULL
--);
--
--table{
--    no -> fk 1
--    
--    
--
--}
	   	

COMMENT ON COLUMN "BOARD"."FESTIVAL_NO" IS '축제번호(시퀀스)';
COMMENT ON COLUMN "BOARD"."FESTIVAL_TITLE" IS '축제제목';
COMMENT ON COLUMN "BOARD"."FESTIVAL_CT" IS '축제내용';
COMMENT ON COLUMN "BOARD"."FESTIVAL_DT" IS '축제날짜';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE BOARD
ADD PRIMARY KEY(BOARD_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_CD" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

ALTER TABLE BOARD
ADD CONSTRAINT "CHK_BOARD_ST"
CHECK("BOARD_ST" IN('N','Y'));

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_MEMBER"
FOREIGN KEY("MEMBER_NO")
REFERENCES MEMBER;

-- BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_BOARD_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
       
-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1,'공지사항');
INSERT INTO BOARD_TYPE VALUES(2,'자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3,'축제후기 게시판');
INSERT INTO BOARD_TYPE VALUES(4,'축제정보');
INSERT INTO BOARD_TYPE VALUES(5,'동행자구하기 게시판 ');
-- BOARD 테이블 샘플 데이터 삽입(PL / SQL)

SELECT * FROM MEMBER;

BEGIN
    FOR I IN 1..500 LOOP
        
        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO.NEXTVAL,
               SEQ_BOARD_NO.CURRVAL || '번째 게시글',
               SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용입니다.',
               DEFAULT,DEFAULT,DEFAULT,DEFAULT,1,3
               
        );
        
    END LOOP;
END;
/

UPDATE MEMBER SET MEMBER_REGION = 'test', MEMBER_EMAIL = 'test', MEMBER_PHONE = 'test', MEMBER_PW = 'test', MEMBER_NICKNAME = 'test' 
	   	WHERE MEMBER_NO= '1' AND MEMBER_PW = 'testpw';


-- 게시판 종류 

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
   "BOARD_CD"   NUMBER      PRIMARY KEY,
   "BOARD_NM"   VARCHAR2(50)      NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';


-- 게시판 (게시글 저장 테이블)
DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
   "BOARD_NO"   NUMBER      NOT NULL,
   "BOARD_TITLE"   VARCHAR2(150)      NOT NULL,
   "BOARD_CONTENT"   VARCHAR2(4000)      NOT NULL,
   "CREATE_DT"   DATE   DEFAULT SYSDATE   NOT NULL,
   "UPDATE_DT"   DATE      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "BOARD_ST"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_NO"   NUMBER      NOT NULL,
   "BOARD_CD"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."UPDATE_DT" IS '마지막수정일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '작성자 회원 번호';
COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE BOARD
ADD PRIMARY KEY(BOARD_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_CD" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

ALTER TABLE BOARD
ADD CONSTRAINT "CHK_BOARD_ST"
CHECK("BOARD_ST" IN('N','Y'));

ALTER TABLE BOARD
ADD CONSTRAINT "FK_BOARD_MEMBER"
FOREIGN KEY("MEMBER_NO")
REFERENCES MEMBER;

-- BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_BOARD_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
       
-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1,'공지사항');
INSERT INTO BOARD_TYPE VALUES(2,'자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3,'축제후기 게시판');

-- BOARD 테이블 샘플 데이터 삽입(PL / SQL)

SELECT * FROM MEMBER;
BEGIN
    FOR I IN 1..500 LOOP
        
        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO.NEXTVAL,
               SEQ_BOARD_NO.CURRVAL || '번째 게시글',
               SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용입니다.',
               DEFAULT,DEFAULT,DEFAULT,DEFAULT,1,5
               
        );
        
    END LOOP;
END;
/
commit;
		SELECT COUNT(*) FROM BOARD
		WHERE BOARD_CD = '1'
		AND BOARD_ST = 'N';
        
        DROP TABLE INFO_BOARD;

CREATE TABLE "INFO_BOARD" (
   "FESTIVAL_NO"   NUMBER      NOT NULL,
   "FESTIVAL_TITLE"   VARCHAR2(150)      NOT NULL,
   "FESTIVAL_CT"   VARCHAR2(300)      NOT NULL,
   "FESTIVAL_IMG"  VARCHAR2(500) NOT NULL,
   "FESTIVAL_DT"   VARCHAR2(100)      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "BOARD_CD"   NUMBER      NOT NULL
);

COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_NO" IS '축제번호(시퀀스)';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_TITLE" IS '축제제목';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_CT" IS '축제내용';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_IMG" IS '축제내용';
COMMENT ON COLUMN "INFO_BOARD"."FESTIVAL_DT" IS '축제날짜';
COMMENT ON COLUMN "INFO_BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "INFO_BOARD"."BOARD_CD" IS '게시판 코드';

-- BOARD 테이블 제약조건 추가
ALTER TABLE INFO_BOARD
ADD PRIMARY KEY(FESTIVAL_NO); -- 제약조건명 생략(SYS_XXXX)

ALTER TABLE INFO_BOARD
ADD CONSTRAINT "FK_BOARD_CD1" -- 제약 조건명 지정
FOREIGN KEY("BOARD_CD") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "BOARD_TYPE"; -- 참조할 테이블

-- INFO_BOARD_NO용 시퀀스
CREATE SEQUENCE SEQ_FESTIVAL_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값
       
-- BOARD_TYPE 데이터 삽입
INSERT INTO BOARD_TYPE VALUES(1,'공지사항');
INSERT INTO BOARD_TYPE VALUES(2,'자유 게시판');
INSERT INTO BOARD_TYPE VALUES(3,'축제후기 게시판');
INSERT INTO BOARD_TYPE VALUES(4,'축제정보');
INSERT INTO BOARD_TYPE VALUES(5,'동행자구하기 게시판 ');
-- INFO-BOARD 테이블 샘플 데이터 삽입(PL / SQL)

BEGIN
    FOR I IN 1..180 LOOP
        
        INSERT INTO INFO_BOARD
        VALUES(SEQ_FESTIVAL_NO.NEXTVAL,
               SEQ_FESTIVAL_NO.CURRVAL || '번째 제목',
               SEQ_FESTIVAL_NO.CURRVAL || '번째 게시글 내용입니다.',
               '/resources/images/board/test.png',
               DEFAULT,DEFAULT,4
        );
        
    END LOOP;
END;
/
commit;


/

DROP SEQUENCE SEQ_FESTIVALDETAIL_NO;

CREATE SEQUENCE SEQ_FESTIVALDETAIL_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값

BEGIN
    FOR I IN 1..180 LOOP
        
        INSERT INTO FESTIVAL_DETAIL
        VALUES(SEQ_FESTIVALDETAIL_NO.NEXTVAL,
               '해당 축제 상세내용',
               ' 해당 축제 상세정보.'
        );
        
    END LOOP;
END;      
       

CREATE TABLE "FESTIVAL_DETAIL" (
	"FESTIVAL_NO"	NUMBER		NOT NULL,
	"FESTIVAL_CONTENT"	VARCHAR2(2000)		NOT NULL,
	"FESTIVAL_DETAILINFO"	VARCHAR2(500)		NOT NULL

);

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_NO" IS '축제번호';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_CONTENT" IS '축제 상세설명';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_DETAILINFO" IS '축제 상세정보';


ALTER TABLE "FESTIVAL_DETAIL"
ADD CONSTRAINT "FK_FESTIVAL_DETAIL" -- 제약 조건명 지정
FOREIGN KEY("FESTIVAL_NO") -- BOARD의 BOARD_CODE 컬럼에 FK 지정
REFERENCES "INFO_BOARD"; -- 참조할 테이블

COMMIT;

UPDATE INFO_BOARD SET
BOARD_CD ='1';

UPDATE BOARD SET
BOARD_CD ='2';


UPDATE BOARD SET
BOARD_CD ='5'
WHERE BOARD_CD ='2'
AND BOARD_NO BETWEEN 1500 AND 2000;

COMMIT;


UPDATE BOARD SET
BOARD_CD ='2'
WHERE BOARD_CD ='1';

UPDATE BOARD SET BOARD_ST = 'Y' WHERE BOARD_NO = 999;

rollback;

SELECT SEQ_BOARD_NO.NEXTVAL FROM DUAL;
-------------------------------------------------------------

--DROP TABLE BOARD_IMG;

CREATE TABLE "BOARD_IMG" (
	"IMG_NO"	NUMBER		PRIMARY KEY,
	"IMG_LEVEL"	NUMBER		NULL,
	"IMG_RENAME"	VARCHAR(200)		NULL,
	"IMG_ORIGINAL"	VARCHAR(200)		NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호';

COMMENT ON COLUMN "BOARD_IMG"."IMG_LEVEL" IS '이미지 레벨';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '이미지 경로 및 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '이미지 원래 이름';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '게시글번호(시퀀스)';

CREATE SEQUENCE SEQ_BOARDIMG_NO
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1; 
       
      -- DROP SEQUENCE SEQ_BOARDIMG_NO;

ALTER TABLE "BOARD_IMG"
ADD CONSTRAINT "FK_BOARD_IMG"
FOREIGN KEY("BOARD_NO")
REFERENCES "BOARD";

--SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, FESTIVAL_DT, READ_COUNT, BOARD_CD, FESTIVAL_AREA, FESTIVAL_CAT, 
--       FESTIVAL_CONTENT, FESTIVAL_DETAILINFO, IMG_NO, IMG_RENAME, IMG_LEVEL
--FROM INFO_BOARD
--JOIN FESTIVAL_DETAIL USING(FESTIVAL_NO)
--JOIN FESTIVAL_IMG ON(FESTIVAL_NO = IMG_NO)
--WHERE FESTIVAL_NO = ?

SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, FESTIVAL_DT, READ_COUNT, BOARD_CD, FESTIVAL_AREA, FESTIVAL_CAT, 
       FESTIVAL_CONTENT, FESTIVAL_DETAILINFO
FROM INFO_BOARD
JOIN FESTIVAL_DETAIL USING(FESTIVAL_NO)
WHERE FESTIVAL_NO = 2;

UPDATE INFO_BOARD SET READ_COUNT = READ_COUNT + 1 WHERE FESTIVAL_NO = ?;

ROLLBACK;
UPDATE INFO_BOARD SET READ_COUNT = READ_COUNT +1 WHERE FESTIVAL_NO = 1;

rollback;

CREATE TABLE "DIB" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"FESTIVAL_NO"	NUMBER		NOT NULL
);

ALTER TABLE "DIB"
ADD CONSTRAINT "FK_DIB_MEMEBERNO"
FOREIGN KEY("MEMBER_NO")
REFERENCES "MEMBER";

ALTER TABLE "DIB"
ADD CONSTRAINT "FK_DIB_FESTIVALNO"
FOREIGN KEY("FESTIVAL_NO")
REFERENCES "INFO_BOARD";

COMMENT ON COLUMN "DIB"."MEMBER_NO" IS '회원번호(시퀀스)';

COMMENT ON COLUMN "DIB"."FESTIVAL_NO" IS '축제번호';

-- MEMBER_NO로 찜한 축제의 이미지 불러오기
SELECT IMG_RENAME
FROM MEMBER
JOIN DIB USING (MEMBER_NO)
JOIN INFO_BOARD USING(FESTIVAL_NO)
JOIN FESTIVAL_IMG ON(FESTIVAL_NO = IMG_NO)
WHERE MEMBER_NO = ? AND IMG_LEVEL = 0;

INSERT INTO INFO_BOARD	VALUES(	1	,	'서울K가족축제'	,	'성·결혼·가족의 가치와 윤리를 중심으로 저출산·고령화 정책과 성교육을 촉구하고, 그 문화를 확산시키기 위하여 K-Family Festival in Seoul 2023(서울K가족축제)를 개최한다.
가족의 가치와 의미를 되살리는 서울K가족축제에는 10여개 이상의 시민사회단체들이 협력하며 축제를 준비한다.
각 나라의 문화권별 결혼과 가족에 대한 모습을 공유하고, 한국 사회에 만연한 저출산·고령화 문제의 심각성과 이를 해결하기 위한 다양한 정책 제안 토크콘서트를 비롯해 가족이 함께 즐길 수 있는 다양한 참여 프로그램이 준비된다. 아울러 다양한 공연과 체험형 부스도 준비되어 있으며, 어린이부터 노년층까지 모든 연령층이 즐길 수 있는 프로그램들로 채워진다.축제와 관련해서는 저출산·고령화 문제 해결을 위한 가족 정책 공모전, 행복한 가족사진 공모전도 진행된다.'	,	'2023.06.30 ~ 2023.07.02'	,	120	,	'서울특별시'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	2	,	'물총축제'	,	'4년 만에 ‘물총축제’가 개최된다. -2023 물총축제-의 콘셉트는 -I AM ALIVE-이다.
참가자들이 도심에서 서로 물총을 쏘며일상에서의 해방감을 맛보는 유일한 축제로
행사장 내 다양한 프로그램을 참여하며 살아있음을 온몸으로 느끼는 페스티벌이 될 것이다.
2023 물총축제는 거리에서 탈피해 좀 더 넓고 활동성 좋은 문화비축기지에서 즐길 수 있다.
행사장 곳곳에서 쏟아지는 다채로운 워터 어트랙션과 신나는 DJ 음악,
물을 활용한 짜릿한 프로그램을 시민들께 선보일 예정이다.'	,	'2023.08.12 ~ 2023.08.13'	,	200	,	'서울특별시'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	3	,	'서울세계불꽃축제'	,	'서울세계불꽃축제는 바쁜 매일을 살아가는 시민의 일상에 즐거움을 선사하기 위해 한화그룹에서 2000년부터 사회공헌 사업으로 꾸준히 진행해 온 대한민국 최고의 축제이다.
매년 세계적인 수준의 불꽃 전문 기업들이 초청되어 여의도의 밤 하늘을 무대로 환상적인 불꽃 연출을 선보이며, 주간에도 다채로운 부대행사가 진행된다.
특히, (주)한화가 자랑하는 멀티미디어 불꽃쇼는 불꽃과 음악, 레이저 연출이 결합된 아시아 최고 수준의 불꽃쇼로써 매년 100만명 이상의 시민들이 이를 보기 위해 여의도를 찾는다.'	,	'2022.10.08 ~ 2022.10.08'	,	850	,	'서울특별시'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	4	,	'거리예술 캬라반 ‘가을’'	,	'2014년 거리예술 시즌제로 시작된 거리예술 캬라반은 도심 속 시민 일상 공간인 광장, 공원 등을 찾아가 거리예술 작품을 선보이는 서울문화재단 서울거리예술창작센터의 프로그램이다. 오는 10일부터 9월 25일까지 매주말마다 광화문광장, 서울숲, 선유도공원에서 음악극·무용·서커스·연희 총 6편의 거리공연이 24회 이어진다.'	,	'2022.09.10 ~ 2022.09.25'	,	200	,	'서울특별시'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	5	,	'서울거리공연 [버스커페스티벌]'	,	'다양한 아티스트! 다양한 구성의 다양한 공연!
버스커콘서트와 노들섬 다양한 공간에서의 거리공연
(노들스퀘어 / 뮤직라운지"류" /노들서가 루프탑, 테라스)'	,	'2022.08.26 ~ 2022.08.28'	,	350	,	'서울특별시'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	6	,	'응봉산 개나리축제'	,	'행사 내용
제22회 응봉산 개나리축제가 "환경과 미래, 응봉산과 지구를 잇다"라는 주제로 2019년 3월 29일 부터 3월31일까지 개최된다.
봄을 알리는 전령사, 개나리가 만개한 응봉산에서 화창하고 따뜻하게 맞이하는 봄은 우리의 마음을 설레게 합니다. 서울에서 가장 먼저 오는 응봉산에서 어린이들에게는 꿈과 희망을, 동행한 학부모(구민)에게는 낭만과 추억이 깃든 즐거운 한마당 축제의 다채로운 프로그램이 진행된다.
봄의 기운을 가득 품은 응봉산에서 사랑하는 가족, 연인, 친구들과 행복한 추억을 만드시기 바란다.'	,	'2022.03.26 ~ 2022.03.27'	,	333	,	'서울특별시'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	7	,	'율봄식물원 봉선화 시즌'	,	'봉선화 꽃 피는 여름~가을. 율봄식물원 야외 정원 곳곳 봉선화와 서양 봉선화(산파첸스)가 분홍의 고운 빛을 물들이고 있다.
봉선화는 여름에서 가을까지 꽤나 오랜 기간 아름다운 꽃을 피워낸다. 율봄의 야외 정원에서 은은하게 피어나는 봉선화 매력을 느껴보자. 율봄식물원.농업예술원은 2만 여평 야외 공간에 조성된 실외 식물원으로 계절별로 피고 지는 다양한 꽃과 나무를 관람할 수 있다. 또한 곳곳에 마련된 벤치와 평상에서 초록의 청정 자연을 만끽하는 휴식이 가능하다. 봉선화 시즌을 맞아 봉선화 손톱 꽃물들이기로 특별한 추억도 만들 수 있다.'	,	'2023.07.31 ~ 2023.09.10'	,	456	,	'경기도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	8	,	'무지개숲 니지모리스튜디오'	,	'대우, 태풍으로 부터 지켜달라는 제를 더불어 니지모리스튜디오를 마을 사람들과 손님분들께서 돌봐주어 감사한 마음을 전한다.
균열을 못 견디고 결국 원수가 되어버린 소라노가문과 아이노가문 마츠리 기간 동안은 두 가문이 정해진 결투를 통해 화합을 이루며 대우, 태풍, 화마로 부터 니지모리(무지개숲)를 보호하고 행복과 강녕을 기원하며 신에게 즐겁게 제를 지내는 축제이다.'	,	'2023.07.22 ~ 2023.08.06'	,	20	,	'경기도'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	9	,	'쁘띠프랑스 이탈리아마을 베니스가면축제'	,	'한국 안에 작은 유럽마을 쁘띠프랑스  이탈리아마을은, 코로나 이후 마스크 없이 다닐 수 있는 첫 여름을 맞이하여 세계 10대 축제 중 하나로 손꼽히는 이탈리아 베니치아의 가면축제를 주요 테마로 행사를 진행한다. 인근 청평호반의 시원한 경치와 함께 쁘띠프랑스 이탈리아마을에 방문하여, 교육적이고 재미있는 문화행사를 가족, 연인과 함께 즐겨보길 바란다.'	,	'2023.07.01 ~ 2023.08.31'	,	170	,	'경기도'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	10	,	'세미원 연꽃문화제'	,	'세미원은 맑고 풍요로운 한강을 만들기 위해 수생정화 능력이 뛰어난 연꽃을 주로 식재하여 여름이 되면 야외정원 가득 연꽃이 피어난다. 매혹적인 홍련과 단아한 백련, 세계적인 연꽃 연구가 페리 슬로컴이 개발·기증한 페리연꽃을 비롯해 빛의 화가 모네를 떠올리게 하는 수련, 사람이 탈 수 있을 정도의 큰 잎을 가진 빅토리아 수련, 국내에서 세미원만 보유하고 있는 희귀 수련 등 다양한 수생식물을 관람할 수 있다.
양평 두물머리에 위치한 물과 꽃의 정원 세미원이 7월 1일부터 8월 15일까지 연꽃문화제를 개최한다. 연꽃문화제 기간 동안 세미원은 휴관일 없이 매일 아침 9시부터 밤 8시까지 운영한다.
여름밤 시원한 강바람을 쐬며 달빛을 머금은 연꽃을 감상하는 것도 세미원 연꽃문화제를 즐기는 하나의 방법이다.'	,	'2023.07.01 ~ 2023.08.15'	,	200	,	'경기도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	11	,	'DMZ OPEN 페스티벌'	,	'DMZ 생태가치확산과 한반도평화 공감대 형성을 위해 DMZ 생태ㆍ평화ㆍ역사ㆍ학술ㆍ스포츠ㆍ문화ㆍ관광 등 다양한 페스티벌 추진한다.
임진각 평화누리와 DMZ 접경지역에서는 평화를 기원하는 아름다운 화합의 선율이 연주되며, 연천/파주 지역에서는 평화와 생태의 상징을 전시한다. 지속가능한 DMZ와 생태보존을 주제로 각종 포럼이 김포/파주 일원에서 개최된다. 비무장지대 DMZ를 직접 보고 걷고 체험하며 즐길 수 있는 스포츠 행사도 함께 한다. 정정70년 DMZ를 모두 보고, 느끼고, 생각한다.'	,	'2023.05.20 ~ 2023.11.11'	,	10	,	'경기도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	12	,	'인천펜타포트 락 페스티벌'	,	'인천펜타포트락페스티벌은 매년 여름 송도달빛축제공원에서 개최되는 인천펜타포트음악축제의 메인 행사이다. 락을 테마로한 국내 대표 아웃도어 음악축제로 국내 뮤지션뿐만 아니라 해외 유명 뮤지션들이 함께 참여하며 글로벌 음악축제로 자리매김하고 있다. 행사 3일 간 공연과 함께 누구나 참여할 수 있는 다양한 이벤트존과, F/B, 캠핑존 등 다채로운 프로그램들도 즐길 수 있다.'	,	'2023.08.04 ~ 2023.08.06'	,	320	,	'인천'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	13	,	'인천개항장 문화재 야행'	,	'인천개항장은 문화재가 주는 독특한 분위기와 시선, 낯설지만 새로운, 유니크한 매력이 있다. 역사와 미래가 공존하는 상징적인 공간으로 문화재와 함께 과거,현재,미래를 오고가는 시간여행으로 초대한다.
140여년 전 개항과 함께 우리나라 최초, 최고의 근대문화와 문물을 받아들인 개항시기 가장 화려하고 활력이 넘쳤던 거리 인천 개항장 오래된 것과 다시 만남, 2023년 개항장의 문을 열다.'	,	'2023.08.26 ~ 2023.10.22'	,	5	,	'인천'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	14	,	'소래포구 축제'	,	'소래포구축제는 2001년에 시작되어 올해로 23회를 맞는 수도권대표 해양생태축제이다. 새우, 꽃게, 젓갈 등이 넘쳐나는 소래포구는 연간 7백만명의 관광객이 즐겨찾는 관광명소이며, 소래습지생태공원, 새우타워, 해오름호수 등 볼거리가 많다. 매년 가을 개최되는 소래포구축제에서 대하·꽃게잡기 등 수산물 체험행사, 다양한 문화공연, 이벤트와 함께 즐거운 추억을 만들기 바란다.'	,	'2023.09.15 ~ 2023.09.17'	,	441	,	'인천'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	15	,	'인천 독서대전'	,	'책이 가진 재미와 다정함의 힘을 느낄 수 있는 인천 대표 책문화예술축제이다.
도서관, 서점, 출판, 문화예술계가 모여 시민참여형 행사를 개최하고 독서공동체 형성을 위한 성장토대를 마련한다.'	,	'2023.09.22 ~ 2023.09.24'	,	3	,	'인천'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	16	,	'Re:023 대전 엑스포93'	,	'한빛탑 물빛광장에서 77일간 페스티벌
DMFW 워터페스티벌, 청년푸드트럭,엑스포 어린이놀이터, 맥주페스티벌, 프리/플리 마켓 등 이있다.'	,	'2023.06.12 ~ 2023.08.27'	,	500	,	'대전'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	17	,	'누들대전 페스티벌'	,	'누들대전 페스티벌은 대전광역시와 대전일보사가 공동으로 진행하는 축제로 대전의 새로운 관광자원 발굴을 위해 기획되었다.
구호물자로 시작된 대전의 가락국수부터 전국 최대규모를 가진 칼국수, 원조의 맛을 지키고 있는 냉면 등 대전에 있는 다양한 면요리를 맛볼 수 있다.'	,	'2023.08.11 ~ 2023.08.13'	,	111	,	'대전'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	18	,	'대전 0시 축제'	,	'‘대전 0시 축제’는 ‘잘 있거라 나는 간다~대전발 0시 50분~’이라는 추억의 대중가요 ‘대전 부르스’를 모티브로 한 축제이다. 대전이 가진 모든 재미를 꺼지지 않게 지속시킨다는 의미의 ‘잠들지 않는 대전, 꺼지지 않는 재미’로 축제의 캐치프레이즈가 정해졌다. 대한민국을 넘어 세계인이 함께 즐기는 글로벌 축제가 될 것이다.
대전 0시 축제는 ‘시간여행 축제’라는 차별화된 주제를 바탕으로 대전의 과거와 현재, 미래를 만날 수 있는 존(zone)으로 나눠진다.'	,	'2023.08.11 ~ 2023.08.17'	,	226	,	'대전'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	19	,	'대전 국제 와인 EXPO'	,	'대전 국제 와인 EXPO는 와인과 문화가 함께하는 대한민국 대표 와인 축제이다.
국제와인기구(OIV)의 승인을 받은 세계 3대 와인 품평회 중 하나인 "아시아와인트로피"와 연계하여 이탈리아, 프랑스, 독일 등 30여 개국에서 생산한 다양한 와인을 한자리에서 만나볼 수 있는 국내 최대의 와인 전문 박람회이다. 와인 산업 종사자에게는 비즈니스 교류의 장을, 일반 참관객에게는 각국의 문화와 와인을 접할 수 있는 기회를 제공한다. 와인 전문가는 물론 와인 애호가도 참가하여 와인에 대한 폭넓은 지식을 마련할 수 있는 "국제와인컨퍼런스", "한국 국가대표 소믈리에 경기대회" 등의 연계행사와 각종 문화 공연과 같은 다채로운 부대행사도 마련된다. 아시아 최대 규모의 와인 시음존에서 취향에 딱 맞는 나만의 와인을 찾아보자!'	,	'2023.09.03 ~ 2023.09.10'	,	177	,	'대전'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	20	,	'유성 재즈/맥주페스타'	,'유성온천문화축제의 계절별 분산개최 방안으로 개최되는 2023 유성 재즈/맥주페스타는 한여름밤 재즈음악회와 수제맥주가 어우러지는 고품격 여름문화행사이다. 특히 행사기간중 전국의 유명 수제맥주와 함께 다양한 장르의 재즈공연을 볼 수 있다.'	,	'2023.08.18 ~ 2023.08.20'	,	188	,	'대전'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	21	,	'도시캠핑대전'	,	'캠핑과 박람회, 공연이 어우러진 환상적인 축제 "2023 도시캠핑대전"이 전국의 캠핑족들을 초대한다.
대전광역시가 후원하고 BSN이 주최하는 "2023 도시캠핑대전"이 오는 9월 15일(금)부터 17일(일)까지 2박 3일간 대전시 갑천변 일원 및 DCC대전컨벤션센터 제2전시장에서 진행된다. 캠핑축제(도시캠핑대전)와 박람회(국제캠핑/레포츠페어)가 동시에 개최되는 복합캠핑페스티벌로, 도심 속에서 캠핑을 즐기는 한편 최신 캠핑 트렌드도 만나볼 수 있다.'	,	'2023.09.15 ~ 2023.09.17'	,	344	,	'대전'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	22	,	'대전효문화뿌리축제'	,	'대전효문화뿌리축제는 천혜의 자연환경 속에 위치한 뿌리공원, 한국족보박물관, 효문화마을, 효문화진흥원을 아우르는 효문화 인프라로 효의 가치와 의미를 경험하며 자신의 뿌리를 찾아보고 가족의 정을 느낄 수 있는 축제이다. 전국에 어르신과 청소년, 그리고 3대가 함께 어울리며 즐길 수 있는 축제의 장이 되어 전국에 효 실천 문화 확산 계기를 마련하고자 한다.'	,	'2023.10.13 ~ 2023.10.15'	,	40	,	'대전'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	23	,	'이월드 트로피컬 아쿠아 빌리지'	,'대구의 무더위를 시원하게 날려버릴 여름 시즌!
""이월드 트로피컬 아쿠아빌리지""에서 낮에는 하와이안 휴양존으로 떠나는 ‘아쿠아 빌리지’와 초특급 물총 전쟁 "아쿠아플레이", 밤에는 물과 함께 즐기는 신나는 DJ 파티, "썸머 워터 플레이 파티"를 선보인다.
올해 새롭게 선보이는 이월드 아쿠아 플레이는 이월드 카멜백 앞 어드벤처 광장 전체가 아쿠아 플레이존으로 변신하여, 낮에는 초대형 워터캐논과 함께하는 초특급 물총전쟁 ‘아쿠아플레이’, 밤에는 아쿠아플레이에 바로 이어 물에 젖은 채로 음악에 또 한 번 미치는 ‘썸머 나이트 파티’까지 선보일 예정이다. 일상에 지친 스트레스와 한 여름밤의 무더위를 날려보자.
또한 이번 <아쿠아 빌리지>는 하와이 풍의 휴양지 느낌으로 변신하여, 더위를 날리는 짜릿한 워터슬라이드 <익스트림 워터 슬라이더>, 수심 1.2M의 성인용 풀부터 수심 60cm의 어린이용 풀까지 어린이부터 어른까지 모두 다 즐길 수 있는 초대형 스위밍 풀을 오픈한다. 대구 도심 속 휴양지 이월드 아쿠아 빌리지에서 시원하게, 신나게 놀아보자.
이월드 트로피컬 아쿠아 빌리지는 6월 10일 오픈하여 8월 27일까지 진행된다.이월드에서 물과 함께 즐기는 컨텐츠로 올 여름 더위를 날려 보자.'	,	'2023.06.10 ~ 2023.08.27'	,	477	,	'대구'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	24	,	'이월드 퍼플 아일랜드'	,	'이월드에서는 5월 가정의 달을 맞이해 꿈과 꽃, 그리고 불꽃이 피어나는 <이월드 퍼플 아일랜드>를 개최한다. 블라썸피크닉 1탄 벚꽃, 2탄 튤립 트래블을 이은 3탄 퍼플 아일랜드에서는 블라썸 피크닉의 대미를 장식할 다양한 꽃들의 향연을 선보일 예정이다. 이월드 퍼플 아일랜드에서 꼭 즐겨야 할 것은 "사루비아 가든", "수국 포레스트가든", "로얄 판타지 불꽃쇼"이며, 프린스/프린세스 컨셉의 비비포포와 함께 즐기는 "블라썸 로얄" 또한 이월드 퍼플 아일랜드를 놓치면 안 되는 이유이다.
<이월드 퍼플 아일랜드>에서는 사루비아 가든, 수국 포레스트 가든 등 5월 내내 보라색을 메인 컬러로 새로운 볼거리를 제공한다. 올해 새롭게 선보이는 사루비아 가든은 플라워가든에 위치해 압도적인 대규모 보라 사루비아들의 향연을 연출하고, 에메랄드 그린 나무들과 함께 2천 평 가득 보라 사루비아로 물들은 이국적인 장면이 특징이다. 대구에서 볼 수 없었던 규모의 사루비아 가든을 이월드에서 만나보자.'	,	'2023.06.07 ~ 2023.08.27'	,	411	,	'대구'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	25	,	'대구 문화재 야행'	,	'1669년, 조선 현종 10년, 폐지되었던 감영이 부활하고 경상감영에 새로운 관찰사가 오시는 날
감영은 향연(饗宴) 준비로 한창 들떠 있다.
잔칫날 빠질 수 없는 음식들과 공연이 마련되었고,
사람들은 새로운 관찰사에 대한 기대와 호기심
그리고 관찰사에게 잘 보이려 꽃단장을 한 여인들과 뛰노는 아이들 …
새로운 관찰사 역시 부활된 경상감영에서의 생활이 기대되고 설렌다.
드디어 기다리던 향연(饗宴)이 시작되었다.
과연 그 시절, 달 밝은 여름 밤
경상감영에서는 어떤 일이 벌어지고 있을까?'	,	'2023.08.18 ~ 2023.08.19'	,	4	,	'대구'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	26	,	'대구치맥페스티벌'	,	'하늘이 내린 최고의 조합, 치킨과 맥주! 매년 여름, 대구에서 치킨과 맥주의 기막힌 조합을 테마로 한 대구치맥페스티벌이 열린다. 치맥페스티벌이라는 말 그대로 축제 기간 동안 맛있는 치킨과 시원한 맥주를 마음껏 즐기며 가수들의 공연을 관람할 수 있다. 유명 치킨프렌차이즈들이 참여하기 때문에 다양한 치킨을 한자리에서 골고루 맛볼 수 있는 절호의 기회이기도 하다. 시원한 얼음물에 발을 담그고 치맥을 즐길 수 있는 공간도 마련되어 있다. 유명 가수들의 축하공연과 DJ들의 신나는 EDM파티가 열리며, 밤 9시 9분에는 모두 함께 건배를 외치는 치맥 99 건배 타임이라는 재미있는 이벤트도 진행된다.'	,	'2023.08.30 ~ 2023.09.03'	,	770	,	'대구'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	27	,	'수성못페스티벌'	,	'수성못페스티벌은 대구시민이 가장 즐겨 찾는 수성못에서 시민들에게 놀랍고 신선한 예술체험을 선사하는 축제로 사랑받고 있다. ‘대구광역시 우수지역축제 평가’에서 2019년, 2020년 2년 연속 1위에 선정됐으며, 대구를 대표하는 축제로 자리매김했다. 예술가와 시민이 만나 감동을 주고받는 수성문화재단의 정체성을 나타내는 사업 중 하나이다.'	,	'2023.09.22 ~ 2023.09.24'	,	111	,	'대구'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	28	,	'Beer Fest Gwangju'	,	'2022년에 이어 2023년 8월, 김대중컨벤션센터 전시장과 야외광장에서 2023 Beer Fest Gwangju가 열린다. 여름 무더위를 날릴 맥주는 기본, 광주 대표음식을 포함한 다양한 먹거리가 준비된다. 또한 DJ, 가수 등 흥을 돋게 할 음악 공연들과 체험 이벤트들도 즐길 수 있다.'	,	'2023.08.09 ~ 2023.08.12'	,	40	,	'광주'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	29	,	'광주 추억의 충장축제'	,	'매년 10월, 광주를 대표하는 번화가 충장로의 특징을 살린 추억의 충장축제가 열린다. 축제의 가장 큰 볼거리인 ‘충장 월드퍼레이드’에는 광주 13개 동에서 서로 다른 테마로 퍼레이드에 참석하며 경연 퍼레이드, 영화 콘셉트 퍼레이드, 아시아 국가 퍼레이드 등 다양한 퍼레이드가 쉴 새 없이 진행된다. 또한, 70~00년대 충장로의 모습을 재현한 추억의 테마거리도 조성된다. 옛날 다방에서 차를 마시거나 흑백사진관에서 멋진 흑백사진을 찍는 등 MZ세대를 비롯한 다양한 세대가 즐거운 레트로 체험을 할 수 있다. 특히 축제 본연의 특성인 놀이성, 일탈을 통한 해방감, 공동체로서의 대동감을 느낄 수 있다.'	,	'2023.10.05 ~ 2023.10.09'	,	5	,	'광주'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	30	,	'광주 서창 억새축제'	,	'영산강변 테마가있는 산책로를 걸으며 특색있는 걷기프로그램과 함께 FUN한 가을포토존에서 인생샷을 찍고 즐길수있는 축제이다.
3.5km에 이르는 대규모 억새군락지에 펼쳐진 다양한 문화예술 행사와 체험프로그램 및 감성이 녹아든 도심속에 있는 가을을 최대로 만끽할 수 있는 생태환경축제이다.'	,	'2023.10.06 ~ 2023.10.10'	,	20	,	'광주'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	31	,	'광주문화재야행'	,	'광주 역사의 중심인 동구의 문화재와 광주의 역사를 달빛 아래에서 만나보는 ‘광주문화재야행’은 지역의 문화유산과 주변의 문화시설을 연계하여 다양한 역사문화체험의 기회를 제공하는 야간향유형 문화재 관광축제이다.
8야(夜)로 구성된 광주문화재야행은 야경(야간경관), 야로(역사투어), 야사(체험), 야화(전시), 야설(공연), 야식(음식), 야식(장터), 야숙(숙박)을 통해 동구의 문화재를 다채롭게 경험할 수 있다.'	,	'2023.06.16 ~ 2023.06.17'	,	111	,	'광주'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	32	,	'광주 국화전시회'	,	'김대중컨벤션센터는 호남권 최대 전시컨벤션센터이다.
2022년 10월, 김대중컨벤션센터 야외광장에서 국화축제가 열린다.
공연 및 체험행사, 플리마켓, 화훼직거래장터 등 다양한 부대행사가 함께 진행된다.
푸드트럭도 준비되어있어 다양한 먹거리와 함께 국화를 즐길 수 있다.
가을의 꽃내음을 김대중컨벤션센터 야외광장에서 만끽하길 바란다.'	,	'2023.10.07 ~ 2023.10.23'	,	77	,	'광주'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	33	,	'부산바다축제'	,	'"제27회 부산바다축제"는 부산 여름 대표 축제로 2023년8월1일부터 6일까지 총 6일간 개최되며, 해운대·다대포 해수욕장 일원에서 진행된다.
본 축제는 전국 최대 규모 힙합 풀파티인 "Night Pool Party"와 눈부신 노을 아래 펼쳐지는 "원더풀 컬러풀"을 중심으로 여러 연계행사들이 구성될 예정이다. 이 외에도 바다에서 즐길 수 있는 다채로운 프로그램들을 만나볼 수 있으며 누구나 자유롭게 관람 및 참여 가능하다.'	,	'2023.08.01 ~ 2023.08.06'	,	555	,	'부산'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	34	,	'좀비런 부산'	,	'2023 좀비런 부산은 "레트로-좀비타운"컨셉으로 추격전, 좀비파티, 좀비무기 팝업스토어 등이 가득찬 가장 도발적이고, 진한 컨셉질의 체험형 축제이다.
500명이 넘는 수많은 좀비들과 친구처럼 사진도 찍고, 춤도 추지만 때로는 아찔한 추격전이 펼쳐지게 된다.좀비타운로 뚝 떨어진 여러 사람들과 함께 팀을 이루어, 당신을 공격하는 악질 좀비들로부터 생존하자. 미국 90년대 느낌의 레트로 좀비월드에선 수많은 종류의 좀비들을 만날 수 있다. 웨이트리스, 청소부, 경찰, 의사, 간호사 등 다양한 컨셉의 좀비들을 만나보자.'	,	'2023.08.05 ~ 2023.08.05'	,	177	,	'부산'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	35	,	'부산수제맥주마스터스챌린지'	,	'2023 부산수제맥주마스터스챌린지는 부산지역 수제맥주 브랜드의 경쟁력 강화를 위해 전문가와 일반 시민들이 평가를 진행하여 올해 부산지역 최고의 수제맥주를 뽑아보는 시민 참여형 축제이다.
시민들이 직접 참여하는 수제맥주 심사부터 아이들이 즐길 수 있는 피자만들기 체험과 어른들이 즐길 수 있는 수제맥주 만들기 체험 등 남녀노소 모두가 즐길 수 있는 다양한 부대행사와 이벤트가 준비되어 있으니 8월 18일 ~ 8월 20일까지 영화의전당으로 와서 부산수제맥주의 맛을 느껴보길 바란다.'	,	'2023.08.18 ~ 2023.08.20'	,	331	,	'부산'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	36	,	'부산국제매직페스티벌'	,	'행사 내용
부산국제매직페스티벌은 2006년부터 시작되어 문화콘텐츠 산업의 떠오르는 블루오션인 ‘매직’을 테마로 한 국내 100만 매직 매니아의 꿈의 축제인 국내 유일 세계 최대 규모의 마술 페스티벌이다.
올해 10월까지 진행되는 제18회 부산국제매직페스티벌에는 매직서커스[봄], 매직컨벤션, 제5회 버스킹챔피언십, 매직서커스[가을], 한가위 매직 판타지아 등 다양한 행사들이 준비되어있다.'	,	'2023.04.15 ~ 2023.10.29'	,	3	,	'부산'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	37	,	'부산국제록페스티벌'	,	'2023 부산국제록페스티벌은 2000년 첫 개최된 이래 2023년 제24회를 맞는 국내 최장수 록페스티벌로 부산에서 펼쳐지는 역동적인 아시아 대표 록페스티벌로 자리매김 하고 있다. 부산을 비롯한 전국의 인디밴드들과 국내외 최정상 밴드 공연으로 사상구 삼락생태공원에서 개최되고 있으며, 국내 최고 수준의 라인업을 자랑하고 있다. 2023 부산국제록페스티벌은 국제교류 활성화를 통한 아티스트 교류사업을 진행해오고 있다.'	,	'2023.10.07 ~ 2023.10.08'	,	453	,	'부산'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	38	,	'워터버블페스티벌'	,	'2023 워터 버블 페스티벌은 2014년 ""모두가 주인공이 될 수 있는 축제를 만들어보자"" 라는 비전으로 기획되었다.
연령, 성별을 떠나 모두가 함께하는 체험형축제를 추구하고 있다.'	,	'2023.08.12 ~ 2023.08.12'	,	177	,	'울산'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	39	,	'울산조선해양축제'	, '2023 울산조선해양축제는 2023년 8월 25일(금)~26일(토) 2일간 해양관광도시 울산광역시 동구 일산해수욕장에서 열리는 행사이다.
25일 금요일 축하공연으로 이루어진 개막식을 시작으로 26일에 기발한배 콘테스트, 나이트런 일산과 같은 전 연령대를 아우르는 킬러 콘텐츠가 펼쳐진다.
또한 맨손 고기잡기 체험, 동구관광투어와 같은 다채로운 체험·참여·전시·투어 프로그램을 제공한다. 이 외에도 일산 EDM Party, 야심한 밤에 버스킹 등 여러 장르의 무대 프로그램이 있다. 그뿐만 아니라 일산 썸머빌리지와 같은 해변 휴게공간도 마련되어 즐길 거리가 풍부하다.'	,	'2023.08.25 ~ 2023.08.26'	,	5	,	'울산'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	40	,	'울산공업축제'	,	'2023울산공업축제는 대한민국 경제 수도 울산 시민들의 대화합을 위해 35년 만에 부활한 축제이다.
대한민국 경제 발전을 이끌었던 울산, 그 속에서 삶을 꾸려왔던 시민들의 화합의 장으로 다양한 볼거리와 즐길거리를 제공할 예정이다.
공업수도를 상징하는 공업탑에서 출발하는 퍼레이드는 축제의 시작을 열며, 울산의 위대함을 보여주는 화려한 개막식으로 이어진다.
2023울산공업축제가 개최되는 나흘 동안 태화강남구둔치와 태화강국가정원 야외공연장, 그리고 왕버들마당에서는 남녀노소 모두가 즐길 수 있는 다채로운 프로그램이 준비되어 울산의 화합을 도모할 예정이다.'	,	'2023.06.01 ~ 2023.06.04'	,	55	,	'울산'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	41	,	'울산대공원 장미축제'	,	'울산대공원 장미원에서 개최되는 제15회 울산대공원 장미축제는 국내 최고의 장미원에서 피어나는 아름답고 다양한 300백만송이의 장미 감상과 고품격 공연 프로그램, 시민참여 체험행사 등이 5일간 펼쳐진다.'	,	'2023.05.24 ~ 2023.05.28'	,	12	,	'울산'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	42	,	'조치원복숭아축제'	,	'홍보 판매를 위한 조치원복숭아축제가 8월 4일부터 6일까지 조치원에서 진행된다.
이번 행사는 호우 피해로 판로에 어려움을 겪고 있는 복숭아 농가를 돕기 위해 홍보판매 중심으로 행사를 준비했다.
세종시민운동장, 도도리파크, 중심가로, 세종전통시장 등 조치원 전역에서 “115년 역사의 신선한 조치원 복숭아”를 만나보자.'	,	'2023.08.04 ~ 2023.08.06'	,	31	,	'세종특별자치시'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	43	,	'세종축제'	,	'시민참여형 도시문화축제인 세종축제는 한글 특화, 미래기술 활용, 전통문화 활성화 등 세종시만의 정체성을 반영하여 기획한 축제이다. 대형 수상극, 버스킹, 한글놀이터 등 다양한 공연과 체험 향유부터 시민들이 함께 기획하고 운영하는 프로그램까지 누구나 주인공이 되는 축제를 10월에 만나볼 수 있다.'	,	'2023.10.06 ~ 2023.10.09'	,	77	,	'세종특별자치시'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	44	,	'베어트리파크 철쭉제 "봄과 철쭉"'	, '베어트리파크에서는 철쭉이 개화하는 시기인 4월 15일(토)부터 5월 7일(일)까지 봄꽃 페스티벌 ‘철쭉제’가 열린다.
매화와 벚꽃이 지는 4월 중순, 봄꽃의 대미를 장식할 철쭉이 베어트리파크 전체를 수 놓는다. 베어트리파크에는 붉은 꽃잎의 영산홍, 흰 꽃이 피는 백철쭉, 진한 보랏빛의 대왕철쭉 등 다양한 색의 철쭉 9만여 그루가 화려하게 피어난다. 특히 입구의 오색연못에서는 수백 마리의 비단잉어와 철쭉이 만나 화려한 색채로 장관을 이룬다.'	,	'2023.04.15 ~ 2023.05.07'	,	5	,	'세종특별자치시'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	45	,	'세종파크뮤직페스티벌'	,	'세종문화예술회관 일대에서 연예인, 지역아티스트 공연 및 푸드트럭, 플리마켓, 무제한 맥주부스 등 다양한 프로그램들이 6월 3일(토)부터 6월 4일(일)까지 2일간 진행된다.
올해로 2회차를 맞이하여 세종파크뮤직페스티벌에는 키즈페스티벌 프로그램을 따로 만들어 전연령이 즐길 수 있는 축제를 마련하였다.'	,	'2023.06.03 ~ 2023.06.04'	,	3	,	'세종특별자치시'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	46	,	'철원 화강 다슬기축제'	,	'철원 화강 다슬기축제는 매년 8월 초에 강원도 철원군 김화읍 화강 쉬리공원 일대에서 개최하는 가족관광형 여름축제이다. 2007년 김화 남대천 주민연구발전회가 주관이 되어 시작된 마을축제는 2009년부터 철원 화강 다슬기축제 추진위원회가 조직되어 지역주민과 가족단위 관광객을 대상으로 하는 축제로 발전시켰다. 2016년부터는 철원군축제위원회가 설립되어 축제를 주관하고 있고 다슬기를 테마로 한 체험프로그램과 워터슬라이드, 수영장 등 각종 물놀이시설을 확충하여 매년 10만여 명이 참가하는 전국 규모의 축제로 발전하였으며, 2019년 강원도 우수축제로 선정되는 등 철원을 대표하는 지역추제로 자리매김하고 있다.'	,	'2023.08.03 ~ 2023.08.06'	,	10	,	'강원도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	47	,	'텐스푼 음악축제'	,	'온가족이 즐기는 클래식과 재즈, 국악, 음악극 등 다양한 장르의 음악을 만나본다.
"텐스푼"은 여러 사람이 힘을 합해 한 사람을 돕는다는 의미의 "열 개의 숟가락"이자, 2024 강원동계청소년올림픽의 슬로건인 "함께할 때 빛나는 우리"를 뜻하기도 한다. 효자동의 담작은도서관, 근대문화유산 중 하나인 죽림동 성당, 그리고 춘천시를 대표하는 소극장인 축제극장몸짓까지 이어지며 각각의 완성도 높은 무대와 차별화된 프로그램의 현대 음악 축제이다.'	,	'2023.08.03 ~ 2023.08.05'	,	4	,	'강원도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	48	,	'홍천강 별빛음악 맥주축제'	,	'홍천강 별빛음악 맥주축제는 전국 최대 규모의 맥주공장인 하이트 강원공장에서 갓 생상된 생맥주와 홍천군에 소재한 수제맥주사(브라이트바흐, 에이앤씨브루잉, 용오름), 마을에서 생산한 시골수제맥주, 세계맥주인 블랑과 파올라너를 맛볼 수 있다.
또 전국 최초의 Wet(젖다) Dance 대회와 함께 신나는 EDM, 렙, 힙합 등 다양한 장르의 무대공연을 관람할 수 있다.'	,	'2023.08.01 ~ 2023.08.06'	,	88	,	'강원도'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	49	,	'경포 썸머 페스티벌'	,	'4년만에 돌아온 경포썸머페스티벌은 아름다운 강릉의 경포 해수욕장에서 펼쳐지는 해변 축제로 머쉬베놈, HYNN, 노라조, 육중완밴드 등 매일 인기가수가 출연하는 대형 콘서트는 물론, 맥주와 지역먹거리를 먹으며 휴식을 취할 수 있는 쿨썸머파크, 미래의 청춘 뮤지션을 발굴하는 MBC해변가요제, 경포 EDM DJ 페스티벌 등 다양한 체험과 이벤트가 준비되어 있는 종합 페스티벌이다.'	,	'2023.07.30 ~ 2023.08.06'	,	177	,	'강원도'	,	'연인'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	50	,	'정선 함백산야생화축제'	,	'자동차로 오를 수 있는 가장 높은 고개인 만항재에서 천천히 머물며 자연을 음미할 수 있는 힐링 체험을 제공하는 축제이다. 낮 최고기온 20도 시원한 기온 속에서 만항재 야생화 군락지와 다양한 볼거리, 체험프로그램을 즐길 수 있다.'	,	'2023.07.29 ~ 2023.08.06'	,	33	,	'강원도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	51	,	'태백 해바라기축제'	,	'제 19회 태백해바라기 축제를 개최한다. 2023년에는 7/21(금)~8/15(화)까지 자연스럽고 평화로운 구와우 마을에서 백만송이 해바라기꽃을 피워놓는다. 해바라기 군락이 마치 동화 속에 온 듯한 경험을 선사하는 곳, 태백 해바라기 축제'	,	'2023.07.21 ~ 2023.08.15'	,	99	,	'강원도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	52	,	'둔내고랭지토마토축제'	,	'제12회 둔내고랭지토마토축제가 8월 12일부터 8월 14일까지 3일간 고원 청정고장인 횡성군 둔내면 종합체육공원 일원에서 "최고의 토마토와 함께하는 여름 가족 축제!"란 주제로 개최된다.
올해 둔내고랭지토마토축제는 더 넓어진 토마토풀장이 하루 2번 운영되며 작년보다 더욱 다양한 볼거리, 먹거리, 체험거리를 준비하였다.
또한 한여름 무더위를 날려버린 태기산 K-POP COOL 페스티벌도 기대해 주길 바란다.'	,	'2023.08.12 ~ 2023.08.14'	,	144	,	'강원도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	53	,	'국토정중앙 양구 배꼽축제'	,	'국토의 정중앙에 위치한 양구에서는 9월 2일부터 4일까지 "2022 국토정중앙 양구 배꼽축제 <100X LAND FESTIVAL>"가 열린다.
놀이공원부터 음악마을, 동화마을, 양구군만의 특별한 농특산물과 먹거리를 한데 만나보실 수 있다.'	,	'2023.09.01 ~ 2023.09.03'	,	88	,	'강원도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	54	,	'한여름 단양 수상 페스티벌'	,	'단양호 수상레포츠 활성화를 위해 수상 페스티벌을 개최하여 지역경기 활성화를 도모하고, 땅길, 하늘길에 이어 물길을 개척하여 "떠오르는 수상관광의 메카, 단양!" 으로 도약하고자 한다.'	,	'2023.08.11 ~ 2023.08.13'	,	341	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	55	,	'산골공연 예술잔치'	,	'산골공연예술잔치는 2004년 첫해를 시작으로 지금까지 해마다 여름이면 펼쳐지는 공연예술축제이다. 극단 터, 자계예술촌, 예술무대 산, 극단 초인, 놀이패 신명, 극단 노뜰, 유진규네 몸짓, 씨알누리, 극단 경험과 상상 등 국내 여러 주목할 만한 단체 및 개인의 작품들이 산골무대를 채워주고 함께 만들어 온, 작지만 매우 알찬 공연예술축제 이다. 2023년 제20회 산골공연예술잔치는 8월 1일부터 10일간 특별전시로 탁영호 작가의 [오래된 지금] 미술 전시가 진행되고 8월 12일(토), 13일(일) 양일간 음악, 전통연희, 연극 등의 공연작품이 무대에 올려진다.'	,	'2023.08.12 ~ 2023.08.13'	,	5	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	56	,	'영동포도축제'	,	'매년 8월 말이 되면 포도의 고장인 영동에서 열리는 대표적인 축제이다. 전국 최대의 재배면적(2,209ha)과 품질 좋은 포도를 전국에 알리기 위해 축제이며, 단순히 포도를 먹기만 하는 축제 아니라 포도를 직접 따는 체험부터 포도를 이용해서 와인, 포도즙 등 여러 가지 제품을 만들고, 포도밟기 등 수십 가지의 다양한 체험들이 함께하는 오감만을 만족할 수 있는 즐거운 축제의 장이다. 수도권에서 멀지 않아 당일치기로도 즐길 수 있으며, 어린아이에게 눈높이를 맞춘 다양한 행사까지 준비되어 있다.'	,	'2023.08.24 ~ 2023.08.27'	,	57	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	57	,	'청주문화재야행'	,	'2023 청주문화재야행은 오는 8월 25일부터 28일까지 3일간 개최된다. 청주만의 유‧무형 문화재와 원도심의 역사를 품은 청주문화재야행! 2023년은 "주성야독(舟城夜讀), 달빛 아래 청주를 읽다."라는 주제로 진행된다. 밤에 배우는 천오백년 청주(주성)의 이야기! 가족, 친구, 연인 간에 추억을 만들 수 있도록 8夜의 다양한 프로그램들이 가득 채워져 있다. 2016년부터 2023년까지 8회 연속 개최되고 있는 청주문화재야행! 한여름밤 달빛 아래에서 청주를 즐겨보자.'	,	'2023.08.25 ~ 2023.08.27'	,	1	,	'충청북도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	58	,	'괴산고추축제'	,	'지역 특산물 괴산청결고추와 문화가 결합된 괴산의 대표 문화관광축제이다. 유기농업군 괴산의 명성에 걸맞는 유기농 관련 프로그램과 핵심 콘텐츠인 황금고추를 찾아라, 속풀이 고추난타를 통해 진정한 축제의 뜨거운 맛을 느낄 수 있다.'	,	'2023.08.31 ~ 2023.09.03'	,	8	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	59	,	'청원생명축제'	,	'청원생명축제는 2008년부터 친환경을 테마로 구성된 대표적인 축제이다.
순수자연으로 더욱 빛나는 명품농산물인 청원생명브랜드를 홍보하고, 테마가 있는 전시와 다양한 체험행사 및 문화공연을 통해 관람객의 다양한 볼거리를 제공하며, 자라나는 학생들에게는 농업의 현재와 미래, 다양한 문화를 느낄 수 있는 교육의 장을 마련하고자 노력하고 있다.'	,	'2023.10.06 ~ 2023.10.15'	,	44	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	60	,	'영동난계국악축제'	,	'영동난계국악축제는 다양한 국악기 제작과 연주 체험 등을 할 수 있는 반세기가 넘는 역사를 가진 국악축제이다. 영동군 대표 특산물인 와인 축제와도 동시개최되어 국악의 아름다운 선율과 달콤한 와인과 함께 축제를 즐길 수 있다.'	,	'2023.10.12 ~ 2023.10.15'	,	32	,	'충청북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	61	,	'보령머드축제'	,	'세계인과 함께하는 신나는 머드체험! 국적이나 인종,언어,연령 등을 뛰어넘어 모두가 하나 되어 즐길 수 있는 체험형 여름축제이다. 바다를 바라보며 머드를 온몸으로 느낄 수 있는 일반존과 온 가족이 함께 즐기는 패밀리존으로 구성되어 있다.
낮에는 머드를 흠뻑 적시며 시원하게 보낼 수 있고, 밤에는 다양한 공연,불꽃쇼 등으로 낭만의 여름밤도 함께 즐길 수 있다.'	,	'2023.07.21 ~ 2023.08.06'	,	644	,	'충청남도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	62	,	'천리포수목원 무궁화축제'	,	'천리포수목원이 즐거움이 무궁무진 무궁화를 주제로 제5회 무궁화축제를 개최한다.
이번 축제는 지역과 함께하는 축제라 더욱 뜻깊다. 축제 프로그램 중 "무궁화 마켓"은 태안 소재 소상공인과 함께 준비한 플리마켓이다. 이밖에도 매일 새롭게 무궁화축제를 즐길 수 있도록 해설, 체험, 포토존 등 다양한 이벤트를 마련했다. 축제 프로그램에 참여하면 비공개 지역이었던 무궁화동산도 입장 가능하다. 이곳에선 350여 종의 무궁화를 만나볼 수 있다. 이번 여름 천리포수목원 무궁화동산에서 나라꽃 무궁화가 주는 특별한 추억을 남기시기 바란다.'	,	'2023.08.05 ~ 2023.08.15'	,	111	,	'충청남도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	63	,	'아트밸리 아산 신정호 SUMMER FESTIVAL'	,	'5일 동안 개최되는 아트밸리 아산 신정호 SUMMER FESTIVAL은 8.11-13. 아트밸리 아산 제2회 ROCK 페스티벌, 8. 14.- 15. 제2회 신정호 아트밸리 별빛음악제/ 뮤지컬[영웅] 갈라 콘서트 등 다양한 음악 행사이다.
장소는 충남 아산시 신정호 야외음악당에서 개최된다.
다양한 프로그램뿐만 아니라 행사 기간 내에 푸드존 운영과 셔틀버스 운영을 통해 시민들의 먹거리와 교통 편의성을 제공한다. 주요 출연진은 노브레인 육중완밴드 몽니 홀리뱅 크라인넛 딘딘 임태경 하림 한윤비 밴드 양준모 등이 있다.'	,	'2023.08.11 ~ 2023.08.15'	,	278	,	'충청남도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	64	,	'천안문화도시 페스타'	,	'천안시는 2019년 법정문화도시로 지정된 이후, 매년 시민들을 위한 페스타를 개최한다.
미디어아트쇼, 거리퍼포먼스, 플리마켓, 체험부스, 버스킹 등이 운영되어 화려한 볼거리 및 풍성한 즐길거리를 제공한다.'	,	'2023.08.11 ~ 2023.08.15'	,	499	,	'충청남도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	65	,	'공주 문화재야행'	,	'문화재야행은 문화재가 집적·밀집된 지역을 거점으로 지역의 특색 있는
역사문화자원을 활용한 문화재 야간관람(개방), 체험, 공연, 전시 등 문화재 야간문화 향유 프로그램이다.
공주시는 2017년부터 문화재청 문화재야행 사업을 함께하고 있다.
공주문화재야행은 공주 제민천 일원 근대 문화재(구 공주읍사무소, 제일교회 등)를 중심으로 이루어지며,
8가지 야간 테마를 주제로 한 프로그램을 진행한다.'	,	'2023.09.08 ~ 2023.09.10'	,	124	,	'충청남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	66	,	'부여 문화재 야행'	,	'문화재의 이야기에 취하는 부여 문화재 야행이 관광객을 기다린다.
문화재 야행 사업은 문화유산을 중심으로 주변의 다양한 문화예술 콘텐츠를 연계 활용해 야간에 특화된 문화체험 프로그램으로 지역경제와 관광산업 활성화를 도모하고자 문화재청에서 진행하는 공모사업으로 사비백제의 찬란한 역사를 지닌 부여의 문화재 활용 및 홍보를 위해 우리 지역 관·민이 공동 협력하여 대표 관관 콘텐츠로의 발전과 지역 경제 활성화에 기여한다. 이번 2023 부여 문화재 야행『성왕 사비로와』는 백제의 아름다운 문화유산 정림사지를 중심으로 주변의 문화시설 콘텐츠를 활용한 야간 문화향유 프로그램이다.'	,	'2023.09.15 ~ 2023.09.17'	,	146	,	'충청남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	67	,	'안동 문화재야행<월영야행>'	,	'안동의 대표적인 여름밤 문화행사이다. 매년 8월 월영교 일대에서 안동의 유무형 문화재를 활용한 공연, 전시, 체험이 운영된다. 월영교 인근에는 안동 석빙고, 선성현 객사 등의 문화재가 산재하고 있으며 월영야행에서는 야간에 관련 문화재들을 즐길 수 있다. 특히, 월영교 위 설치되는 전통등간은 월영야행의 대표 프로그램이다.'	,	'2023.07.29 ~ 2023.08.06'	,	4	,	'경상북도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	68	,	'김천나이트투어 "직지골야행"'	,	'김천의 관광지 방문 및 다양한 체험을 중심으로 진행되는 야간관광프로그램이다. 계절별 수확시기에 맞춰 진행되는 지역 농산물 수확체험을 시작으로 괘방령 장원급제길 소원빌기, 직지사 아래 직지상가 맛고을에서 김천지역의 음식을 맛본다. 밤이 되면 직지문화공원 야경 아래 김천의 특산물로 만든 간식거리를 맛보며 다양한 가족체험프로그램이 진행된다.'	,	'2023.03.25 ~ 2023.11.04'	,	47	,	'경상북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	69	,	'청도 프로방스 빛축제'	,	'1996년 청도 테마랜드로 오픈하였다.
2012년 청도프로방스 포토랜드로 새롭게 단장하여 여러분을 맞이한지 10년이 흘렀다.
프랑스의 정감있는 프로방스마을을 청도에 그대로 재현하였다.
투명한 햇살 아래 무르익은 포도, 광활하게 펼쳐진 보랏빛의 라벤다,
풍요로운 대자연 속에 독특한 문화와 예술이 살아 숩 쉬는 그 곳은 바로
프랑스 남동부 지역의 프로방스 마을이다.
고흐, 세잔, 샤갈, 마티스 등이 사랑한 그 곳
프로방스 마을로의 로맨틱한 여행과 빛축제를 즐길수 있는 곳이다.
낮에는 100여가지 다양한 포토존과 아기자기한 소품, 예쁜 집들이
여러분을 맞이하고 어둠이 내리면 눈부시게 빛나는 빛 축제로 변신하는 곳이다.'	,	'2023.02.01 ~ 2023.11.30'	,	144	,	'경상북도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	70	,	'오감만족 문경새재맨발페스티벌'	,	'매년 만명이상이 모이는 문경새재 제1관문~3관문 사이 황톳길 7km를 맨발로 걷는 행사. 인기 가수 초청 공연과 행사장 곳곳 맨발로 참여할 수 있는 게임 다수 마련. 다양한 종류의 부스 운영을 통해 맨발 걷기 뿐만 아니라 다채로운 프로그램에 참여할 수 있다. 또한 일반인 노래자랑과 아이들을 위한 프로그램 마련으로 남녀노소 불문하고 가족과 연인 친구가 함께 문경새재의 풍광을 즐기면서 건강까지 챙길 수 있다. 3관문에 완주하는 사람에게는 선착순으로 매달도 증정한다.'	,	'2023.08.19 ~ 2023.08.19'	,	88	,	'경상북도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	71	,	'예천 삼강주막 나루터축제'	,	'낙동강 1,300리 마지막 남은 주막, 예천 삼강주막 일원에서 펼쳐지는 삼강주막 나루터 축제는 낙동강, 내성천, 금천 세 강이 합쳐지는 독특하고 아름다운 지형에서 이름을 딴 삼강, 물과 사람이 모이는 나루터, 그리고 나그네 술 한 사발의 낭만이 흐르는 주막이라는 스토리가 어우러진 축제 한마당이다. 매년 많은 관광객이 찾는 예천의 대표적인 축제로 옛 주막의 정취를 느끼며 힐링하기 딱 좋은 축제이다.'	,	'2023.09.29 ~ 2023.10.01'	,	13	,	'경상북도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	72	,	'안동국제탈춤페스티벌'	,	'안동에는 유네스코가 세계유산으로 지정한 한국의 역사마을에서 800년 전부터 전승되어 오던 하회별신굿탈놀이가 있다. 마을 공동체들은 탈놀이를 통해 마을의 안녕과 풍농을 기원했고, 별신굿을 통해 새로운 세상을 만들어 왔다. 이러한 안동의 문화자산인 하회별신굿탈놀이를 안동국제탈춤페스티벌로 승화시켰다. 특히, 안동의 다양한 문화자원과 안동에서 탈과 탈춤이 가지는 문화 가치 지향점에 대한 철학을 바탕으로 1997년 안동국제탈춤페스티벌이 시작되었다. 안동이 자랑하는 안동국제탈춤페스티벌은 현재 대한민국 정부가 인정한 대한민국 명예대표 문화관광축제이다. 탈과 탈춤, 그리고 축제가 가지는 신명과 대동의 힘으로 지난 26년간 대한민국을 대표하고 항상 일등자리에서 지역민들을 하나로 만드는 대동의 장을 구현하였으며, 세계인의 가슴을 울리는 프로그램으로 함께하고 있는 축제이다.'	,	'2023.10.02 ~ 2023.10.09'	,	111	,	'경상북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	73	,	'하동섬진강문화재첩축제'	,	'2015년부터 개최된 하동섬진강문화재첩축제는 섬진강의 문화, 하동재첩, 축제를 결합한 종합 관광, 산업축제의 가능성을 제시한 대한민국 대표 여름 축제로 매년 7~8월경 하동 송림공원과 섬진강변에서 개최되며, 무더운 더위 속에서 뜨거운 열정과 동서화합을 느낄수 있는 축제이다.'	,	'2023.08.04 ~ 2023.08.06'	,	66	,	'경상남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	74	,	'합천 바캉스 축제'	,	'지역주민과 관광객이 함께 만들고 즐기는 주민 주도형 축제
맑은 물과 모래사장을 활용한 안전하고 편안한 힐링 공간 제공'	,	'2023.07.29 ~ 2023.08.06'	,	10	,	'경상남도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	75	,	'사천시 삼천포항 자연산 전어축제'	,	'『사천시 삼천포항 자연산 전어축제』는 사천시 삼천포항의 대표 수산물인 전어를 주제로 개최하는 먹거리 축제로서 외래 관광객 및 시민들의 지속적인 관심과 사랑을 받아 전국적인 먹거리 축제로 성장·발전하고 있으며 현재 제19회까지 개최하게 되었다.
금년 2023년에『제20회 사천시 삼천포항 자연산 전어축제』라는 타이틀로 전어 풍어기에 맞추어서 명성 높은 사천시 전어 맛을 전국에 알리고, 또한 지역어민 및 수산업과 수산 관련업에 종사하시는 시민들의 소득증대와 더 나아가 깨끗한 청정해역 사천시와 사천시의 수산물을 알리고자 전어축제를 개최하고자 한다.'	,	'2023.08.10 ~ 2023.08.13'	,	236	,	'경상남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	76	,	'진주문화재야행'	,	'진주시와 문화재청, 경상남도가 주최, (재)진주문화관광재단이 주관하는 2023 진주문화재야행이 2023년 8월 11일부터 8월 13일까지 3일 동안 경남 진주시 진주성과 원도심 전통시장 일원에서 진행된다. 작년에 이어 두 번째 개최되는 ‘진주문화재 야행’은 진주시민과 전 국민이 모금운동을 통해 일본에서 환수한 최초의 문화유산 「김시민 선무공신 교서」를 재조명해 ‘국난극복, 진주목사의 귀환’이라는 주제로 개최되며, 8야(夜)를 내용으로 진주성 내 김시민장군전공비를 비롯한 많은 문화재를 탐방할 수 있다. 특히, 향교에서 하룻밤을 보내는 이색 문화재 숙박체험, 진주올빰야시장과 연계한 먹거리 투어 등 다채로운 세부 프로그램과 동반행사를 통해 한여름 밤 진주의 문화를 선보일 계획이다.'	,	'2023.08.11 ~ 2023.08.13'	,	1	,	'경상남도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	77	,	'거제맥주축제'	,	'2023 거제맥주축제 한여름 무더위 켈리와 함께하는 시원한 맥주로 날려버릴 수 있다.
장승포수변공원 밤바다에서 펼쳐지는 인기가수와 함께하는 거제맥주축제
사전예매, 현장예매로 무제한 맥주를 즐길 수 있다.'	,	'2023.08.16 ~ 2023.08.19'	,	274	,	'경상남도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	78	,	'산청세계전통의약항노화엑스포'	,	'"미래의 약속, 세계속의 전통의약" 이라는 주제로 지리산과 힐링의 고장 산청군에서 9월 15일부터 10월 19일까지 35일간 산청세계전통의약항노화엑스포가 개최된다.'	,	'2023.09.15 ~ 2023.10.19'	,	100	,	'경상남도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	79	,	'호러 홀로그램 페스티벌'	,	'익산 대표 이색 관광지인 익산 교도소 세트장에서 펼쳐지는 홀로그램 퍼포먼스 체험을 통한 차별화된 공포 페스티벌이다. 공포 실감 콘텐츠와 방문객이 직접 참여하는 오감 콘텐츠를 접목한 유일무이한 교도소 공포체험으로 풍부하고 몰입도 높은 콘텐츠를 통해 오싹하고 생생한 공포를 느낄 수 있다.
페스티벌 기간 동안 펼쳐지는 특별이벤트인 공포 코스튬 콘테스트,공포 음악회와 교도소 운동장에서 함께 공포영화를 관람하는 공포시네마, 공포테마의 식음료를 즐기고 휴식을 취할 수 있는 어둠의 피크닉 등을 운영하여 볼거리,즐길거리가 풍성한 이색 축제를 즐길 수 있다.'	,	'2023.08.01 ~ 2023.08.06'	,	401	,	'전라북도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	80	,	'장수 쿨밸리 페스티벌'	,	'대한민국 최초 계곡 축제 개최를 기념하고 장수군의 브랜드 가치 향상과 지역경제 활성화를 이끌어 내보자는 취지로 아날로그 세대에게는 아련한 향수를, 디지털 세대에겐 호기심을 자극하여, 신구세대가 함께 추억을 만들어 가자는 목적을 두고 추억과 트랜드를 접목한 시원한 여름 축제이다.'	,	'2023.07.28 ~ 2023.08.06'	,	5	,	'전라북도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	81	,	'부안워터페스티벌'	,	'부안 변산해수욕장의 아름다운 해변을 바라면서 워터축제를 즐길 수 있는 부안워터페스티벌!!
워터슬라이드 + 에어바운스 + 워터풀 + 놀이기구 등 마감시간까지 이용가능 하다!'	,	'2023.07.08 ~ 2023.08.20'	,	70	,	'전라북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	82	,	'변산비치파티'	,	'변산비치파티는 전북 부안군 변산해수욕장에서 열리는 해변 파티형식의 축제이다. 국내 유명 댄서들의 축하공연과 비치댄스 경연대회가 열리며, 다양한 체험 프로그램이 준비된 체험존과 물놀이를 즐기는 워터플레이존, 물총싸움존과 인생샷을 남길 모래조각존으로 구성되어있다. 낮에는 뜨겁지만 시원한 물놀이, 밤에는 즐거운 공연과 불꽃놀이로 여름날의 추억을 쌓을 수 있다.'	,	'2023.08.04 ~ 2023.08.06'	,	356	,	'전라북도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	83	,	'부안문화재야행'	,	'부안 문화재 야행은 문화재 집적·밀집된 지역을 거점으로 지역의 특색있는 역사문화자원을 활용한 문화재 야간관람(개방), 체험, 공연, 전시 등으로 이루어진 문화재 야간문화 향유 프로그램이다. 부안읍 내의 당산을 비롯한 문화재를 활용한 8夜를 가족과 친구, 연인간의 행복한 추억을 만들수 있도록 풍성한 프로그램이 준비되어 있다.'	,	'2023.08.10 ~ 2023.08.12'	,	19	,	'전라북도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	84	,	'동편제 국악 축제'	,	'전라북도 남원시 운봉읍은 우리나라 3대 악성 중 한명인 옥보고가 거문고를 크게 발전시킨 곳으로 알려져 있다.
운봉읍 화수리에 위치하고 있는 비전·전촌마을은 판소리 중시조인 송흥록, 국창 박초월의 생가와 국악의 성지가 있어 판소리 명인들의 고향이자 유적지로 동편제 태동지라 불리고 있다.
또한, 이성계의 황산대첩을 기념해 세운 사적 104호 황산대첩비가 있으며 지리산 둘레길 2코스가 지나고 있어 아름다운 자연 절경과 시골의 정겨움이 느껴지는 곳이다. 동편제 판소리 유·무형의 역사적 자산을 배경으로 마을에서는 [동편제 체험관] 등을 운영하며 마을의 이야기를 알리기 위한 활동이 활발하다.'	,	'2023.09.02 ~ 2023.09.03'	,	6	,	'전라북도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	85	,	 '익산보석문화도시 AR보물찾기 진!짜! 축제',	'제2회 익산보석문화도시 AR보물찾기 진!짜! 축제는 2023. 09. 01.(금) ~ 09. 03.(일) 3일간 운영된다.
메인 행사1. AR 보물찾기 Let Go! 골드 RUN! 다이아 3캐럿의 주인공은? 익산귀금속보석산업단지 및 익산보석박물관 일원의 거리와 공간을 탐색할 수 있는 보물찾기 프로그램이 운영된다.
메인 행사2. 보석 RPG "골드바를 얻으려는 자! 뛰어라, 익산즈러너!"라는 익산귀금속보석산업단지의 거리와 공간을 탐색할 수 있는 미션형 체험 프로그램이 운영된다.
익산 내 귀금속 보석 산업 종사자 및 전문가와 연계하여 보석의 가치를 산업이 아닌 문화로 전환될 수 있도록 테마형 축제 프로그램을 운영하게 되었다.'	,	'2023.09.01 ~ 2023.09.03'	,	78	,	'전라북도'	,	'연애'	,	1)	;


INSERT INTO INFO_BOARD	VALUES(	86	,	'정남진 장흥 물축제'	,	'정남진 장흥 물축제는 2020 ~ 2023 문화체육관광부 문화관광지정축제로 선정된 여름 대표축제 중 하나이다.
탐진강의 맑은 물, 장흥댐 호수 등 청정수자원을 기반으로 하여, ""물”이라는 하나의 테마로 모든 프로그램을 연결 시켰으며, 주ㆍ야간 계속되는 다채로운 프로그램은 남녀노소를 불문하고 누구나 함께할 수 있다.
어른에게는 바쁜 일상 속에서 잊고 있었던 순수함을 되살려 줄 것이며, 아이에게는 최고의 놀이터가 되어 준다.'	,	'2023.07.29 ~ 2023.08.06'	,	174	,	'전라남도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	87	,	'거문도백도은빛바다체험행사'	,	'빼어난 풍광과 산해진미의 매력에 푹 빠지는 곳, 거문도에서 제21회 거문도백도은빛바다체험행사가 개최된다. 천혜의 항구가 펼쳐지는 이곳에서 지인망 끌기, 맨손활어잡기, 얼음속 보물찾기, 고둥잡기 등 가족이 함께 즐길 수 있는 체험행사가 가득하다. 갈치, 삼치 등 싱싱한 해산물 거문도 해풍쑥 체험도 가능한 이번 행사는 오는 8월 4일 ~ 5일까지 거문도 삼호교 물양장 일원에서 개최된다.'	,	'2023.08.04 ~ 2023.08.05'	,	60	,	'전라남도'	,	'힐링'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	88	,	'영광불갑산상사화축제'	,	'매년 9월 상사화 개화시기에 맞춰, 국내 최대 붉은 꽃무릇 군락지를 이루는 영광군 불갑사관광지에서 개최되는 축제이다. 상사화는 꽃과 잎이 만날 수 없어 그리움, 애틋함, 참사랑을 상징한다. 제23회 영광불갑산상사화축제는 ‘상사화 꽃길 속으로, 천년의 사랑 속으로’를 주제로 9월15일부터 24일까지 개최된다. 온 산을 붉게 수놓는 상사화와 함께하는 꽃길걷기, 상사화 소원의 길, 상사화 미디어파사드, 상사화 달빛야행 등의 대표 프로그램과 상사화를 테마로 한 다양한 경연, 공연, 체험, 전시행사가 펼쳐진다. 올해는 온오프라인을 연계한 프로그램 개발, 다회용기 사용을 통한 친환경 축제, 상사화 아카이빙을 통한 추억 되새기기, 영광군 관광지와 연계한 이벤트 강화, 편의시설 확대 등 더욱 새롭게 관광객을 맞이할 계획이다.'	,	'2023.09.15 ~ 2023.09.24'	,	34	,	'전라남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	89	,	'무안연꽃축제'	,	'무안군이 주최하는 <무안연꽃축제>는 남도의 대표적인 여름축제로서, 단일 연꽃축제로는 전국 최대이다. 1997년 시작되었고, 매년 여름 일로읍 복용리 회산 백련지 일원에서 개최된다. 동양최대 10만평을 가득 채운 초록빛 연잎 사이로 고결함을 드러내듯 올곧이 하얀꽃망울을 틔우는 백련을 볼 수 있으며 자연의 한가운데서 다채로운 행사와 함께 여름의 낭만을 담아갈 수 있다.'	,	'2023.07.20 ~ 2023.07.23'	,	77	,	'전라남도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	90	,	'목포항구축제'	,	'목포항구축제는 해양문화역사를 바탕으로 우리 고유의 해양문화를 보존하며, 국내 유일 콘텐츠인 "파시"를 주제로 파시경매 등 시민과 함께 화합하고 나아가는 퍼레이드 등 목포항의 낭만을 가득 담은 행사로 찾아오는 관광객들에게 즐거움과 축제를 선사하는 가을 축제이다.'	,	'2023.10.20 ~ 2023.10.22'	,	87	,	'전라남도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	91	,	'곡성세계장미축제'	,	'매 년 5월, 수억만 송이의 장미가 향연을 이루는 곡성세계장미축제가 곡성 기차마을 장미공원에서 개최된다.
쉽게 볼 수 없는 전 세계 명품 장미를 한 곳에서 볼 수 있는 국내 유일의 기회로 열흘 이상 이어지는 곡성세계장미축제는 매년 30만명 이상이 찾는 대표 꽃 축제이다.
축제장은 늘 다양한 이벤트와 공연, 즐길거리가 가득하여 가족, 친구, 연인들의 발길이 끊이질 않는다.
75,000㎡를 가득 채운 장미향에 취하고 싶다면 매년 5월 개최되는 <곡성세계장미축제>를 놓치지 말기를 바란다.'	,	'2023.05.20 ~ 2023.05.29'	,	244	,	'전라남도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	92	,	'명량대첩축제'	,	'명량대첩축제는 삼도수군통제사로 재임명된 이순신 장군의 조선수군과 전라도 어민이 1597년 9월 16일 울돌목에서 일본 수군을 물리친 세계사에서 유례없는 명량해전을 기념하는 호국 역사문화축제이다.
전라남도, 해남군, 진도군이 함께 2008년부터 15회째 개최하는 이번 축제는 ICT 기술을 활용한 XR이머시브 3D영상 미디어해전과, 연화불꽃 드론이 공중해전을 펼치고 다양한 프로그램과 경관조명 등 볼거리로 관광객들의 이목을 끌 예정이다.'	,	'2023.09.08 ~ 2023.09.10'	,	111	,	'전라남도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	93	,	'9.81파크 "하늘 나는 피카츄 프로젝트"'	,	'9.81파크 제주가 "하늘을 나는 피카츄 프로젝트 in JEJU"와 함께한다.
「하늘 나는 피카츄 프로젝트」는 사람과 사람, 사람과 지역을 이어줌으로써 여행의 즐거움을 제공하는 프로젝트다.
9.81파크 제주에서는 해당 기간 동안 "포켓몬 레이싱"과, "포켓몬 링˚˚고" 등
9.81파크 제주의 대표 액티비티들을 포켓몬과 함께 즐길 수 있는 다양한 서비스를 제공한다.
특히, "981 포켓몬 풀패키지", "아이와 함께 포켓몬 풀패키지" 이용 시
레이싱 시작 전 선택한 포켓몬의 이름을 크게 외치면 부스터와 포켓몬 영상을 받을 수 있는
"나와라 포켓몬"을 경험할 수 있으며, 한정판 특전까지 받을 수 있다.'	,	'2023.07.28 ~ 2023.10.31'	,	177	,	'제주도'	,	'연애'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	94	,	'휴애리 유럽 수국축제'	,	'서귀포시 남원읍 신례리에 위치한 휴애리 자연생활공원은 제주도민과 제주를 찾는 관광객에게 보다 나은 볼거리를 제공하고 또 힐링의 공간이 되고자 오는 7월 15일부터 “휴애리 유럽 수국축제”를 개최한다고 밝혔다.
이번 2023 휴애리 유럽 수국축제는 정성스럽게 키운 유럽수국을 공원 곳곳에서 감상할 수 있어 제주도민과 관광객에게 인기가 좋은 여름철 제주 대표 축제가 될 것으로 예상된다.
전년도 보다 더 풍성하게 준비될 이번 휴애리 유럽 수국축제는 신혼여행, 웨딩스냅, 우정스냅 등 인생사진 찍기 좋은 장소로 인정받은 제주여행의 필수 코스 로 인정받고있다. 가족, 연인, 친구와 함께 다양한 수국포토존 에서 아름다운 추억을 만들 수 있을 것으로 예상한다.'	,	'2023.07.17 ~ 2023.09.15'	,	51	,	'제주도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	95	,	'한림공원 연꽃축제'	,	'이번 연꽃축제는 백련꽃이 만발한 연못정원 일대에서 개최되며 홍련, 백련을 비롯하여 세계에서 가장 큰 연꽃인 빅토리아 수련과 각양각색의 열대수련, 파피루스, 워터칸나, 물양귀비 등 희귀한 100여종의 연꽃과 수생식물들이 전시되고 있다.
연꽃과 함께하는 인증샷 이벤트와 더불어 시원한 폭포수의 물줄기와 연꽃이 만발한 연못정원은 여름철 무더위를 말끔히 씻어줄 것이다.
또한 한림공원 내에 있는 천연기념물 236호 협재·쌍용동굴은 한 여름철에도 동굴 내부의 온도가 20°C 내외를 유지하고 있어 천연의 냉방 속에서 신비한 용암세계를 구경할 수 있다.'	,	'2023.07.07 ~ 2023.08.31'	,	40	,	'제주도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	96	,	'제주민속촌 귀몽'	,	'귀몽 캐릭터들의 흥미진진한 스토리! 눈앞에서 펼쳐지는 공포의 시간을 마주하게 된다.
제주 지박령들과 만나는 오싹한 공포체험부터 미디어아트와 비보잉 공연, 먹거리 야시장까지 즐거움이 가득한 공포의 세계로 빠져보자.'	,	'2023.07.01 ~ 2023.11.05'	,	344	,	'제주도'	,	'도심'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	97	,	'스누피 가든 SUMMER CAMP'	,	'6월 10일부터 8월 31일까지 SUMMER CAMP 축제가 곧 다가올 여름방학을 기념하여 제주도 구좌읍 송당리에 위치한 스누피가든 박물관과 2만 5천평의 정원 곳곳에서 진행된다.
이번 축제에서는 여름방학 SUMMER CAMP 컨셉으로 특별 전시가 진행되며 스누피가든 건물 곳곳에 꾸며진 VMD를 통해 여름방학 분위기를 즐길 수 있다.
여름방학을 맞이해 방문하는 가족단위 고객들을 위한 모스이끼 액자 만들기, 테라리움 만들기 등 다양한 체험도 준비되어 있어 다채로운 즐거움을 선사할 예정이다.'	,	'2023.06.10 ~ 2023.08.31'	,	77	,	'제주도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	98	,	'제주레저힐링축제'	,	'레저와 힐링 두 가지 컨셉이 확실한 축제로 2023 제주레저힐링축제가 돌아왔다.
다양한 레저 체험 콘텐츠 14종과 힐링 체험 콘텐츠 6종 그리고 3일간 유명 뮤지션들과 함께하는 가슴 가득히 감동을 전할 콘서트까지 열린다.
가장 제주다운 공간에서 레저와 힐링 모두를 느끼는 쉽지 않은 기회이다.
제주도민과 관광객 모두를 초대한다.'	,	'2023.09.01 ~ 2023.09.03'	,	456	,	'제주도'	,	'가족'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	99	,	'마노르블랑 수국축제'	,	'마노르블랑은 서귀포시에 위치한 정원이 아름다운 수목원/식물원/카페 이다. 이곳은 작년에 이어 올해도 유럽수국축제를 맞이하고 있다. 축제기간은 4월부터 8월까지이다. 우리나라 최남단에 위치하고 있어 노지 수국들이 우리나라에서 가장 빨리 개화중이다. 제주 수국을 비롯하여 전세계 30여종 7천여본 수국은 오직 마노르블랑에서만 만날수있다. 작년에 비해 더 많고 다양한 수국들로 준비되었고 사랑과 정성으로 가꾸어진 다양한 수국들을 마노르블랑 곳곳에서 만날 수 있다.
또한 산방산과 송악산 사이로 형제섬과 사계앞바다가 보이는 환상적인 조망은 마노르블랑에서만 만날 수 있다. 환상적인 조망과 함께 수국 인생샷을 남길 수 있는 다양한 산책로와 포토존이 준비되어 있고 야외 잔디정원에서는 피아노 연주 버스킹을 즐길 수 있다. 이곳 마노르블랑은 지금 유럽수국축제의 향연이 펼쳐지고 있다.'	,	'2023.04.20 ~ 2023.08.31'	,	101	,	'제주도'	,	'꽃'	,	1)	;

INSERT INTO INFO_BOARD	VALUES(	100	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	101	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	102	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	103	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	104	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	105	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	106	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	107	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	108	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	109	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	110	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	111	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	112	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	113	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	114	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	115	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	116	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	117	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	118	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	119	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	120	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	121	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	122	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	123	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	124	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	125	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	126	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	127	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	128	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	129	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	130	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	131	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	132	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	133	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	134	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	135	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	136	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	137	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	138	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	139	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	140	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	141	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	142	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	143	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	144	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	145	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	146	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	147	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	148	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	149	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	150	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	151	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	152	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	153	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	154	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	155	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	156	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	157	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	158	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	159	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	160	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	161	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	162	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	163	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	164	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	165	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	166	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	167	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	168	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	169	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	170	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	171	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	172	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	173	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	174	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	175	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	176	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	177	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	178	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	179	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);
INSERT INTO INFO_BOARD	VALUES(	180	,	'학원좀나와조'	,'학원좀나와줘',DEFAULT,0,DEFAULT,DEFAULT,1);











