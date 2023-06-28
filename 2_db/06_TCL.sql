-- TCL(TRANSACTION CONTROL LANGUAGE) : 트랜잭션 제어 언어
-- COMMIT(트랜잭션 종료 후 저장), ROLLBACK(트랜잭션 취소), SAVEPOINT(임시 저장) 

-- DML : 데이터 조작 언어 삽입, 수정, 삭제
--> 트랜잭션은 DML과 관련되어 있음

/* TRANSCATION 이란?
-- DATABASE의 논리적 연산 단위

-- 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아서 처리한다.

-- 트랜잭션의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML) 데이터 조작 언어

EX) INSERT 수행 ------------------------------>  DB 반영(X) (바로 반영이 되는게 아님)

    INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
    
    INSERT 10번 수행 --> 1개의 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영(X)
    
    1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영한다.
    
    2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                  마지막 COMMIT이 된 상태로 돌아간다.
                  
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아니라
                   저장 지점까지만 일부 ROLLBACK
                   
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; --> 포인트 1 지점까지만 데이터 변경사항을 삭제한다.
*/

--CREATE TABLE DEPARTMENT2 AS SELECT * FROM DEPARTMENT;

--DEPARTMENT2 테이블 현재 상태 확인

SELECT * FROM DEPARTMENT2;

-- D0, 경리부, L2 삽입
-- INSERT INTO DEPARTMENT2 (DEPT_ID, DEPT_TITLE, LOCATION_ID) VALUES ( 'D0', '경리부', 'L2');

INSERT INTO DEPARTMENT2
VALUES( 'D0', '경리부', 'L2'); -- 2번하면 2행 생김 똑같은 값으로 DB에 들어간 게 아니고 트랜잭션에 들어가 있는 것.
SELECT * FROM DEPARTMENT2; 

ROLLBACK;
SELECT * FROM DEPARTMENT2;

INSERT INTO DEPARTMENT2
VALUES( 'D0', '경리부', 'L2');

COMMIT;
ROLLBACK;
SELECT * FROM DEPARTMENT2;

-------------------------------------------------------------------------------

DELETE FROM DEPARTMENT2 WHERE DEPT_ID = 'D0';
-- DO 삭제 시점에 SAVEPOINT 지정
SAVEPOINT SP1;

-- D9 삭제
DELETE FROM DEPARTMENT2 WHERE DEPT_ID = 'D9';

SELECT * FROM DEPARTMENT2; -- 2개 사라짐

--일반 ROLLBACK
ROLLBACK;
SELECT * FROM DEPARTMENT2; -- D9, D0 다 돌아옴

-- SP1 세이브포인트까지 ROLLBACK
ROLLBACK TO SP1;
SELECT * FROM DEPARTMENT2; -- D9는 남아있고 D0은 삭제당했다.
-- D0을 삭제하고 SAVE했으니까 SAVE로 가면 그 전 D0을 삭제한건 실행되고 D9를 삭제한건 실행이 안된모습

ROLLBACK; --COMMIT으로 돌아감
SELECT * FROM DEPARTMENT2; -- 다시 10개나옴 

CREATE TABLE TEST2(
ASDF NUMBER);

