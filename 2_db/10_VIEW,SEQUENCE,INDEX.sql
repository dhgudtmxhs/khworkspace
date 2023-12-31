/* VIEW

    - SELECT 문의 실행 결과(RESULT SET)을 저장하는 객체
    - 논리적 가상 테이블
    - 테이블 모양을 하고는 있지만, 실제 값을 저장하고 있진 않음
    
    ** VIEW 사용 목적 **
    1) 복잡한 SELECT문을 쉽게 재사용하기 위해서 사용한다.
    2) 테이블의 진짜 모습을 감출 수 있어 보안상 유리하다.
    
    *** VIEW 사용 시 주의사항 ***
    1) 가상의 테이블(실체 X)이기 때문에 ALTER 구문 사용 불가능
    2) VIEW를 이용한 DML(INSERT, UPDATE, DELETE)가 가능한 경우도 있지만
       제약이 많이 따르기 때문에 보통은 조회(SELECT)용도로 많이 사용한다.

    [VIEW 생성 방법]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 [(alias[,alias]...]
    AS subquery
    [WITH CHECK OPTION]
    [WITH READ ONLY];

    -- 1) [OR REPLACE] 옵션 : 기존에 동일한 뷰 이름이 존재하는 경우 덮어쓰고,
                             존재하지 않으면 새로 생성하겠다.
    
    -- 2)[FORCE / NOFORCE] 옵션
    --      FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰를 생성해라. 
    --> 서브쿼리(SELECT문)의 결과값이 없거나 서브쿼리에서 사용된 테이블이 존재하지 않아도?
    --     NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성하겠다.(기본값)
    
    -- 3) [WITH CHECK OPTION] 옵션 : 옵션을 설정한 컬럼의 값을 수정 불가능하게 함
    -- 4) [WITH READ ONLY 옵션] : 뷰에 대해 조회만 가능(DML 수행 불가)
*/

-- EMPLOYEE 테이블에서 
-- 모든 사원의 사번, 이름, 부서명, 직급명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> 이 형식의 테이블이 자주 사용하는 건데 매번 작성하기가 힘들다 -> VIEW를 생성한다.

-- 사번,이름,부서명,직급명 VIEW 생성
CREATE VIEW V_EMP    
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- ORA-01031: 권한이 불충분합니다.

GRANT CREATE VIEW TO ohs;
-- ohs 사용자 계정에 VIEW 생성 권한을 부여 (관리자 계정으로만 가능)

-- VIEW를 이용한 조회
SELECT * FROM V_EMP; -- 간단하게 확인 가능해짐

-------------------------------------------------------------------------------

-- ** OR REPLACE + 별칭 **

CREATE OR REPLACE VIEW V_EMP    
AS SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서명, JOB_NAME 직급명
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); 
-- ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.
-- OR REPLACE로 이름 같은 객체를 덮어쓴다. 이름 안같으면 그냥 새로운 VIEW 생성이고

SELECT * FROM V_EMP
WHERE JOB_NAME = '대리';
-- VIEW는 가상 테이블이라 컬럼이 있다고 컬럼명이 실존하는? 건 아님

SELECT * FROM V_EMP
WHERE 직급명 = '대리'; 
-- VIEW에서 컬럼명 별칭으로 '직급명' 으로 바꾸면 컬럼이 그냥 직급명이 되었다고 생각하면 될듯

-------------------------------------------------------------------------------

-- * VIEW를 이용한 DML 확인 * 

-- 테이블 복사
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- 복사한 테이블을 이용해서 VIEW 생성

CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID FROM DEPT_COPY2;

-- 뷰 생성 확인
SELECT * FROM V_DCOPY2;

-- 뷰를 이용한 INSERT
INSERT INTO V_DCOPY2 VALUES ('D0', 'L3');

-- 삽입 확인
SELECT * FROM V_DCOPY2; -- 잘 들어옴
--> 가상의 테이블인 VIEW에 데이터 삽입이 가능한걸까? 아니다.

-- 원본 테이블 확인
SELECT * FROM DEPT_COPY2; -- 'D0', 'NULL', 'L3'
--> VIEW에 삽입한 내용이 원본 테이블에 존재함
--> VIEW를 이용한 DML 구문이 원본에 영향을 미쳐버림

-- VIEW를 이용한 DML 사용 시 발생하는 문제점 == 제약조건 위배 현상
ROLLBACK;
SELECT * FROM DEPT_COPY2;
SELECT * FROM V_DCOPY2; -- 둘다 D0 사라짐

-- 원본 테이블 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
ALTER TABLE DEPT_COPY2
MODIFY DEPT_TITLE NOT NULL;

-- 현 상태에서 다시 VIEW를 이용한 INSERT 수행
INSERT INTO V_DCOPY2 VALUES('D0', 'L3');
-- ORA-01400: NULL을 ("OHS"."DEPT_COPY2"."DEPT_TITLE") 안에 삽입할 수 없습니다.
-- 뷰에 넣겠다고 적었지만 사실은 원본테이블에 넣겠다는 거임, 뷰에 넣으면 원본테이블에도 들어감
-- 근데 원본테이블이 NOT NULL임 --> 원본테이블은 VALUES 안의 값이 3개가 있어야되는데
-- 2개를 쓰면 하나가 NULL이 됨 -> VIEW를 이용한 INSERT 실패

-- 결론 : VIEW 가지고 DMP 웬만하면 하지말아라
-------------------------------------------------------------------------------

-- * WITH READ ONLY 옵션 *
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID FROM DEPT_COPY2
WITH READ ONLY; -- 읽기 전용의 VIEW를 생성(DML이 안됨)

INSERT INTO V_DCOPY2 VALUES('D0','L1');
-- SQL 오류: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.

-------------------------------------------------------------------------------

/* SEQUENCE(순서, 연속)
 - 순차적 번호 자동 발생기 역할의 객체
 EX) 1 2 3 4 5 6 7 8 9 ...
 
 *** SEQUENCE를 사용하는 방법 : PRIMARY KEY 컬럼에 사용될 값을 생성하는 용도로 사용한다.
 
  [작성법]
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  -- 10, -10으로 설정하면 1~10까지 갔다가 -10부터 ~10까지 
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둔다.
--> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로
-- 매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상된다.

    ** 시퀀스 사용 방법 **
    1) 시퀀스명.NEXTVAL : 다음 시퀀스 번호를 얻어온다. (INCREMENT BY만큼 증가된 값)
                         단, 시퀀스 생성 후 첫 호출인 경우 START WITH의 값을 얻어온다.
                         
    2) 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어온다.
                         단, 시퀀스 생성 후 NEXTVAL 호출 없이 CURRVAL를 호출하면 오류 발생한다.                        
*/

-- 테이블 복사
CREATE TABLE EMPLOYEE_COPY4
AS SELECT EMP_ID, EMP_NAME FROM EMPLOYEE;

-- EMPLOYEE_COPY4의 EMP_ID 컬럼에 PK 제약조건 추가
ALTER TABLE EMPLOYEE_COPY4
ADD PRIMARY KEY(EMP_ID); -- 테이블 복사할때 제약조건은 NOT NULL만 넘어온다.

SELECT * FROM EMPLOYEE_COPY4;

-- 223부터 시작하여 5씩 증가하는 시퀀스 생성
CREATE SEQUENCE SEQ_EMP_ID/*시퀀스 이름*/
START WITH 223
INCREMENT BY 5;

-- NEXTVAL 호출 없이 CURRVAL 호출 하면 발생하는 오류 확인
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;
-- ORA-08002: 시퀀스 SEQ_EMP_ID.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다.

-- NEXTVAL 호출 1 (NEXTVALUE)
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- 최초 호출 == START WITH 값 (223)

-- NEXTVAL 호출 2
SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- INCREMENT BY 5 (228)

-- CURRVAL 호출 (CURRENT VALUE)
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL; -- NEXTVAL 호출 후 호출하면 CURRVAL에서 오류 안나는 모습
-- 현재 시퀀스 번호 == 마지막 NEXTVAL의 출력 번호

-- 실제 사용
SELECT * FROM EMPLOYEE_COPY4;

INSERT INTO EMPLOYEE_COPY4 VALUES(SEQ_EMP_ID.NEXTVAL, '홍길동'); -- 233 (그 전 228에서 5 증가 // 쓸 때마다 5 증가)
INSERT INTO EMPLOYEE_COPY4 VALUES(SEQ_EMP_ID.NEXTVAL, '김길동'); -- 238
INSERT INTO EMPLOYEE_COPY4 VALUES(SEQ_EMP_ID.NEXTVAL, '박길동'); -- 243

ROLLBACK;
SELECT * FROM EMPLOYEE_COPY4; -- INSERT 한 값들 사라짐
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL; -- 롤백했는데 223이 아닌 243이 나온다.
-- 시퀀스는 롤백을 수행한다고 해서 돌아가지 않는다. 계속 증가된 상태를 유지한다.

-------------------------------------------------------------------------------

-- SEQUENCE 변경(ALTER)
/*
  [작성법]
  ALTER SEQUENCE 시퀀스이름
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

   --> 시퀀스 변경 시 시작 번호는 변경할 수 없음
   
   
//--[STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본 -- 변경에선 안씀//   
   *시퀀스를 잘못 다루어 번호가 공백이 있어서 다시 처음부터 시작하고 싶은 경우
   --> 시퀀스 삭제 후 재생성해야만 한다.
*/

-- SEQ.EMP_ID의 증가값을 5 -> 1
ALTER SEQUENCE SEQ_EMP_ID
INCREMENT BY 1;

SELECT SEQ_EMP_ID.NEXTVAL FROM DUAL; -- (243) -> (244)

-- SEQUENCE 삭제
DROP SEQUENCE SEQ_EMP_ID;

-- VIEW 삭제
DROP VIEW V_DCOPY2;

-------------------------------------------------------------------------------

/* INDEX(색인)

    SQL 명령문 중 SELECT의 처리 속도를 향상시키기 위해
    컬럼에 대해서 생성하는 객체
    
    인덱스 내부 구조는 B* 트리 형식으로 되어있음
        
    * 인덱스 장점
    - 이진 트리 형식으로 구성되어 있어 자동 정렬 및 검색 속도가 빠르다.
    - 조회 시 전체 테이블 내용을 조회하는 것이 아닌
    - 인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에
    - 시스템 부하가 낮아져 전체적인 성능이 향상된다.
    
    * 인덱스 단점
    - 데이터 변경(UPDATE, INSERT, DELETE)DML 작업이 빈번한 경우 오히려 성능이 저하되는 문제가 발생한다.
    - 인덱스도 하나의 객체여서 이를 저장하기 위한 별도의 공간이 필요하고 인덱스 생성 시간이 필요하다.

    --인덱스 생성 방법--

    [작성법]
    CREATE [UNIQUE] INDEX 인덱스명
    ON 테이블명 (컬럼명, 컬럼명, ... | 함수명, 함수계산식);
    
    -- 인덱스가 자동으로 생성되는 경우
    --> PK 또는 UNIQUE 제약조건이 설정되는 경우
*/

