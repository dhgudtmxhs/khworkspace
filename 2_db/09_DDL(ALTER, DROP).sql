-- festival 계정
DROP TABLE MEMBER;

CREATE TABLE MEMBER (

    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEMBER_PW VARCHAR2(200) NOT NULL,
    MEMBER_EMAIL VARCHAR2(100) NOT NULL UNIQUE,
    MEMBER_NICKNAME VARCHAR2(30) NOT NULL UNIQUE,
    MEMBER_NAME VARCHAR2(30) NOT NULL,
    MEMBER_BIRTH VARCHAR2(30) NOT NULL,
    MEMBER_REGION VARCHAR2(200) NOT NULL,
    MEMBER_TC VARCHAR2(20) NOT NULL,
    MEMBER_PHONE VARCHAR2(20) NOT NULL,
    MEMBER_GENDER VARCHAR2(6) NOT NULL,
    MEMBER_NATIONALITY VARCHAR2(12) NOT NULL,
    MEMBER_PROFILEIMAGE VARCHAR2(4000),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    SECESSION_FL CHAR(1) DEFAULT 'N',
    ADMIN_FL CHAR(1) DEFAULT 'N'

);

CREATE SEQUENCE SEQ_MEMBER_NO1
INCREMENT BY 1;

COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원 번호';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디(중복X)';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '회원 이메일(중복X)';
COMMENT ON COLUMN MEMBER.MEMBER_NICKNAME IS '회원 닉네임(중복X)';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_BIRTH IS '회원 생년월일( - 미포함)';
COMMENT ON COLUMN MEMBER.MEMBER_REGION IS '회원 주 활동지역';
COMMENT ON COLUMN MEMBER.MEMBER_TC IS '회원 통신사';
COMMENT ON COLUMN MEMBER.MEMBER_PHONE IS '전화번호( - 미포함)';
COMMENT ON COLUMN MEMBER.MEMBER_GENDER IS '회원 성별';
COMMENT ON COLUMN MEMBER.MEMBER_NATIONALITY IS '회원 국적';
COMMENT ON COLUMN MEMBER.MEMBER_PROFILEIMAGE IS '회원 프로필 이미지';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';
COMMENT ON COLUMN MEMBER.SECESSION_FL IS '탈퇴 여부(Y:탈퇴, N:미탈퇴)';
COMMENT ON COLUMN MEMBER.ADMIN_FL IS '관리자 여부(Y:관리자, N:일반 회원)';

ALTER TABLE MEMBER
ADD CHECK(ADMIN_FL IN('Y', 'N'));

INSERT INTO MEMBER VALUES
(SEQ_MEMBER_NO.NEXTVAL, 'testid', 'testpw', 'testemail', 'testnick', 
'testname', '200020202', '서울', 'skt', '01033339999', '남자', '내국인', 'img', default, default, default);



-- DDL(Data Definition Language) : 데이터 정의 언어로
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제하는(DROP) 구문

-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;

--------------------------------------------------------------------------------
-- 1. 제약조건 추가 / 삭제

-- * 작성법 중 [] 대괄호 : 생략할 수 도, 안할 수 도 있다.

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;

-- 서브쿼리를 이용해서 DEPARTMENT 테이블 복사
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT; -- 처음 생성 시 CHECK, NOT NULL 만 넘어온다.
SELECT * FROM DEPT_COPY;

-- DEPT_COPY 테이블에 PK 추가
ALTER TABLE DEPT_COPY
ADD PRIMARY KEY(DEPT_ID); --DEPT ID 컬럼에 PRIMARY KEY 추가

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가해주기(제약조건 명 : DEPT_TITLE_UNIQUE)
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DEPT_TITLE_UNIQUE UNIQUE(DEPT_TITLE);

-- DEPT_COPY 테이블의 LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성할 수 있는 값은 L1,L2,L3,L4,L5
-- 제약조건명: LOCATION_ID_CHK
ALTER TABLE DEPT_COPY
ADD CONSTRAINT LOCATION_ID_CHK CHECK(LOCATION_ID IN ('L1','L2','L3','L4','L5'));

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가하기
ALTER TABLE DEPT_COPY
ADD DEPT_TITLE NOT NULL; -- ORA-02263: 열의 데이터 유형을 지정해 주십시오
                         -- NOT NULL 제약조건은 다루는 방법이 다르다.
ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE NOT NULL; -- NOT NULL은 ADD가 아닌 MODIFY를 사용해야 한다.

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE CONSTRAINT SYS_C007724 NOT NULL; -- 제약조건명 생략 가능

--NOT NULL을 제외한 제약조건은 추가적인 조건(ADD/DROP)으로 인식된다.
--NOT NULL은 기존 컬럼의 성질을 변경하는 것으로 인식됨(MODIFY) 꼭 기억. 추가/삭제가 아니라 변경으로만 처리한다!!

-------------------------------------------------------------------------------

--DEPT_COPY에 추가한 제약조건 중 PK만 빼고 모두 삭제하기
ALTER TABLE DEPT_COPY 
DROP CONSTRAINT DEPT_TITLE_UNIQUE;

ALTER TABLE DEPT_COPY
DROP CONSTRAINT LOCATION_ID_CHK;

ALTER TABLE DEPT_COPY
DROP CONSTRAINT SYS_C007723; -- NOT NULL 위에서 CONSTRAINT로 안해줫음 -- DEPT_COPY 에서 DEPT_TITLE로 찾음.

ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE CONSTRAINT SYS_C007710 NULL; -- 이렇게도 삭제 가능
-- DROP도 가능한데 햇갈리면 MODIFY로만 해라

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE CONSTRAINT SYS_C007724 NULL; -- MODIFY로 NOT NULL 없앨 때는 NULL을 뒤에 붙여줘야 한다. 
-- 제약조건명 생략 가능

DROP TABLE DEPT_COPY;

-------------------------------------------------------------------------------

--2 컬럼 추가/수정/삭제

-- 컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);

-- 컬럼 수정 : ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입; (데이터 타입 변경)
--            ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값'; (기본값 변경)

-- ** 데이터 타입 수정 시 컬럼에 저장된 데이터 크기 미만으로는 변경할 수 없다.
-- 이름이 AAA 3BYTE 인데 VARCHAR2(2) 이런식으로 변경할 수 없다.

-- 컬럼 삭제 : ALTER TABLE 테이블명 DROP (삭제할 컬럼명);
--            ALTER TABLE 테이블명 DROP COLUMN 삭제할 컬럼명;

-- 삭제하다가 컬럼이 한 개 남았을 때는 컬럼이 삭제가 안된다.
-- 테이블이란? 행과 열로 이루어진 데이터베이스의 가장 기본적인 객체이기 때문에
-- 테이블에는 최소 1개 이상의 컬럼이 존재해야 해서 모든 컬럼을 삭제할 수는 없다.

-- (추가)

-- DEPT_COPY 테이블에 CNAME VARCHAR2(20) 컬럼 추가
-- ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);
ALTER TABLE DEPT_COPY
ADD(CNAME VARCHAR2(20));

SELECT * FROM DEPT_COPY; --> CNAME 컬럼 추가 확인

-- (추가)
-- DEPT_COPY 테이블에 LNAME VARCHAR2(30) 기본값 '한국' 컬럼 추가
ALTER TABLE DEPT_COPY
ADD(LNAME VARCHAR2(30) DEFAULT '한국'); 
-- LNAME 에 대한 기본값이 NULL 이 아닌 '한국'으로 다 만들어주겠다.

SELECT * FROM DEPT_COPY;

-- (수정)
-- DEPT_COPY 테이블의 DEPT_ID 컬럼의 데이터 타입을 CHAR(2) -> VARCHAR2(3)으로 변경

-- 컬럼 수정 : ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입; (데이터 타입 변경)
--            ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값'; (기본값 변경)

ALTER TABLE DEPT_COPY
MODIFY DEPT_ID VARCHAR2(3);

ALTER TABLE EMPLOYEE2
MODIFY JOB_CODE VARCHAR2(20);

ALTER TABLE DEPT_COPY
ALTER COLUMN DEPT_ID VARCHAR(30) NOT NULL;


-- DEPT_TITLE 컬럼의 데이터 타입을 VARCHAR2(10)으로 변경
ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(10); -- 안의 값이 10 이상임
-- ORA-01441: 일부 값이 너무 커서 열 길이를 줄일 수 없음
-- 해외영업1부 이런거 16바이트임

-- (기본값 수정)
-- LNAME 기본값을 '한국' -> '대한민국'으로 변경
ALTER TABLE DEPT_COPY
MODIFY LNAME DEFAULT '대한민국'; -- 안바꼇음
-- 기본값을 변경했다고 해서 기존에 저장된 기본값이 변경되진 않는다.
-- 열이 더 생기면 그건 '대한민국' 기본값으로 될 듯

UPDATE DEPT_COPY
SET LNAME = '대한민국'; -- 이렇게 바꿔야 기존의 기본값을 바꿀 수 있다.

UPDATE DEPT_COPY
SET LNAME = DEFAULT; -- DEFAULT를 대한민국으로 바꿔서 DEFAULT를 이용해서 수정 가능

ROLLBACK;

-- (삭제)
-- DEPT_COPY에 추가한 컬럼(CNAME, LNAME) 삭제
-- ALTER TABLE 테이블명 DROP(삭제할 컬럼명);

ALTER TABLE DEPT_COPY
DROP(CNAME);

--ALTER TABLE 테이블명 DROP COLUMN 삭제할 컬럼명
ALTER TABLE DEPT_COPY
DROP COLUMN LNAME; -- 괄호를 안쓰면 컬럼명 앞에 COLUMN을 붙여주는 식으로도 가능

SELECT * FROM DEPT_COPY;

-- DEPT_COPY 테이블의 모든 컬럼 삭제
SELECT * FROM DEPT_COPY; -- 컬럼 3개 있는 것 확인
ALTER TABLE DEPT_COPY DROP(DEPT_TITLE);
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;

ALTER TABLE DEPT_COPY DROP(DEPT_ID);
-- ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다.

ROLLBACK; 
-- 트랜잭션(DML[INSERT,UPDATE,DELETE]을 이용한 데이터 변경사항)을 삭제하고 마지막 커밋상태로 돌아간다.
-- CREATE/ ALTER/ DROP 같은 DDL은 ROLLBACK의 대상이 아님.

-- * DDL / DML을 혼용해서 사용 할 경우 발생하는 문제점
-- DML을 수행하여 트랜잭션에 변경사항이 저장된 상태에서
-- COMMIT / ROLLBACK 없이 DDL 구문을 수행하게 되면
-- DDL 수행과 동시에 선행 DML이 자동으로 COMMIT되어버린다.
-- DML이 트랜잭션에 남아있다가 COMMIT 하면 DB로 가는 건데 
-- 트랜잭션에 DML이 남아있을 떄 DDL을 실행하면 DDL이 트랜잭션에 남아있는 DML을 밀어버림

--> 결론 : DML/DDL 혼용해서 사용하지 말자.

INSERT INTO DEPT_COPY VALUES('D0');
ROLLBACK; -- 트랜잭션에서 'D0' INSERT 내용을 삭제
SELECT * FROM DEPT_COPY;

INSERT INTO DEPT_COPY VALUES('D0'); --DML 수행
ALTER TABLE DEPT_COPY 
MODIFY DEPT_ID VARCHAR2(4); -- DDL 수행
ROLLBACK;
SELECT * FROM DEPT_COPY; -- D0이 안사라짐 -> DDL이 DML 밀어서 COMMIT되어버림.

-------------------------------------------------------------------------------

--ALTER TABLE DEPT_COPY
--DROP COLUMN

-- 3. 테이블 삭제

-- [작성법] 
-- DROP TABLE 테이블명 [CASCADE CONSTRAINTS]; -- CASCADE 부모 삭제시 자식도 삭제

CREATE TABLE TB1(
    TB1_PK NUMBER PRIMARY KEY,
    TB1_COL NUMBER    
);

CREATE TABLE TB2(
    TB2_PK NUMBER PRIMARY KEY,
    TB2_COL NUMBER REFERENCES TB1 /*컬럼명 생략했음*/ -- TB1 테이블의 PK값을 참조 //생략하면 기본값 PK임 PK는 하나밖에없고
);

--일반 삭제 (DEPT_COPY)
DROP TABLE DEPT_COPY; 

-- ** 관계가 형성된 테이블 중 부모테이블(TB1) 삭제 **
DROP TABLE TB1;
-- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다.
--> 다른 테이블이 TB1 테이블을 참조하고 있어서 삭제 불가능

-- 해결 방법 1 : 자식 -> 부모 테이블 순서로 삭제한다.
DROP TABLE TB2; 
DROP TABLE TB1; -- 가능

-- 해결 방법 2 : CASCADE CONSTRAINTS 옵션 사용
--> 제약 조건까지 모두 삭제
--> == FOREIGN KEY 제약 조건으로 인해 삭제가 원래는 불가능하지만, 제약조건을 없애버려서 FOREIGN KEY 관계를 해제했음
-- TB1_PK NUMBER PRIMARY KEY 의 PRIMARY KEY를 없애버려서 관계 끊는다는말인듯

DROP TABLE TB1 CASCADE CONSTRAINTS; --삭제 성공
DROP TABLE TB2;

-------------------------------------------------------------------------------

--4.컬럼, 제약조건, 테이블 이름 변경(RENAME)

-- 테이블 복사
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT;

-- 복사한 테이블에 PK 추가
ALTER TABLE DEPT_COPY 
ADD CONSTRAINTS PK_DCOPY PRIMARY KEY(DEPT_ID);

-- 1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 변경명
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME; 
SELECT * FROM DEPT_COPY;

-- 2) 제약조건"명" 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 변경명;
ALTER TABLE DEPT_COPY
RENAME CONSTRAINT PK_DCOPY TO DEPT_COPY_PK;

-- 3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 변경명; -- RENAME 뒤 테이블명 안적음
ALTER TABLE DEPT_COPY RENAME TO DCOPY;
SELECT * FROM DEPT_COPY;
SELECT * FROM DCOPY;








