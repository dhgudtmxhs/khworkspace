--DB(DATABASE)- 데이터들의 저장소
--
--DBMS 설치 - 사용자와 DB 사이에서 사용자의 요구에 따라 정보를 생성해주고 DB를 관리해주는 소프트웨어
--ORACLE, MYSQL
--
--ORACLE은 DBMS
--SQL SERVER는 ORACLE에 대한 DBMS
--
--ORACLE에서 비밀번호 설정 ->
--
--SQL SERVER에서
--사용자 계정 생성 : NAME = sys 관리자 계정
--사용자 이름 : sys as sysdba
--비밀번호 : oracle ( 오라클 설치할때 정한 비밀번호)
--관리자 계정으로 만드는 건 따로 권한 주거나 하지 않아도 됨
--
--관리자 계정으로 사용자 계정 생성 

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- 오라클 12c 버전부터 사용자명 앞에 c##을 붙여야 하는데 11c버전과 호환되게 만들어줘서 c##은 안붙여도 된다.

CREATE USER testman IDENTIFIED BY test;

GRANT CREATE SESSION TO testman; 
-- 맨위 문장 안썻다면 이름 쓸 때 마다 C##testman 해야함
-- CREATE SESSION 주지 않으면 testman 사용자 계정 생성 불가능
GRANT CONNECT, RESOURCE, CREATE VIEW TO testman;
-- 위 처럼 권한 부여

ALTER USER testman DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
-- testman의 기본 테이블스페이스를 시스템으로 변경하고 시스템 테이블스페이스에 대해 무제한 할당량을 부여한다.
-- testman이 시스템 테이블스페이스에 테이블을 생성할 수 있으며, 할당량에 대한 제한이 없다.

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER testman IDENTIFIED BY test;
GRANT CREATE SESSION TO testman;
GRANT CONNECT, RESOURCE, CREATE VIEW TO testman;
ALTER USER testman DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
DROP USER testman CASCADE;

SELECT * FROM EMPLOYEE;
SELECT EMP_NAME FROM EMPLOYEE;
SELECT SALARY, SALARY+1000000 FROM EMPLOYEE;
SELECT SALARY, SALARY*12 FROM EMPLOYEE;

--중요 오늘 날짜 조회
SELECT SYSDATE FROM DUAL; -- DEVELOPER에 처음엔 년/월/일로 되어있음 (YYYY-MM-DD)
-- 날짜 데이터 연산 가능 (일 단위)
SELECT SYSDATE, SYSDATE+1, SYSDATE-1 FROM DUAL;

SELECT EMP_NAME, HIRE_DATE, (SYSDATE-HIRE_DATE) / 365 FROM EMPLOYEE; -- 일단위로 연산함

SELECT EMP_ID AS 사번, EMP_NAME 이름, EMP_NO "번 호", JOB_CODE AS " 잡 코 드 " FROM EMPLOYEE;

SELECT DEPT_CODE FROM EMPLOYEE;
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE; -- NULL도 나옴

SELECT EMP_ID FROM EMPLOYEE WHERE DEPT_CODE ='D9';

SELECT EMP_NAME FROM EMPLOYEE
WHERE SALARY >=2000000 AND DEPT_CODE = 'D6'; --이면서

SELECT EMP_NAME FROM EMPLOYEE
WHERE SALARY >=2000000 OR DEPT_CODE = 'D6'; --이거나

-- AND 연산자는 OR 연산자보다 우선순위다.
SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND JOB_CODE = 'J3' OR EMP_ID=206;

SELECT EMP_NAME FROM EMPLOYEE
WHERE SALARY BETWEEN 2500000 AND 5000000;

SELECT EMP_NAME FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '1990/01/01' AND '1999/12/31';

SELECT EMP_ID, EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%이%';

SELECT EMP_ID, EMP_NAME FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하';


SELECT EMP_ID, EMP_NAME, EMAIL FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#'; -- # 뒤에 한 글자만(_) 일반 문자 취급한다.

-- IN = OR
-- NOT IN = AND

-- || 컬럼 연결 
SELECT EMP_NAME || '의 급여는' || SALARY || '원 입니다.' FROM EMPLOYEE;

-- ASC = 오름차순 NULLS LAST
-- DESC = 내림차순 NULLS FIRST

-- NULL은 IS NULL, IS NOT NULL만 가능 IN 등으로 비교하면 공집합나옴

-- ORDER BY는 숫자, 문자, 날짜 모두 사용 가능

-- WHERE절에서 SELECT문 별칭 사용 불가

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE
ORDER BY DEPT_CODE, SALARY DESC; -- DEPT CODE를 기준으로 SALARY를 내림차순 정렬한다.
-- DEPT_CODE가 오름차순이니깐 D1에 대해 내림차순, D2에 대해 내림차순 이런식으로 정렬된다.

-- 단일행(SINGLE ROW) 함수 : N개의 값을 읽어서 N개의 결과를 반환한다.
-- 그룹(GROUP) 함수 : N개의 값을 읽어서 1개의 결과를 반환한다.

SELECT LENGTH('HELLO WORLD') FROM DUAL;

SELECT EMAIL, LENGTH(EMAIL) FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', 5) FROM DUAL;

SELECT EMP_NAME, PHONE, SUBSTR(PHONE, 4) AS 번호만 FROM EMPLOYEE; --4번째부터 다출력
SELECT EMP_NAME, PHONE, SUBSTR(PHONE, 4, 3) AS 번호만 FROM EMPLOYEE; --4번째부터 3글자

-- TRIM([옵션] '문자열 | 컬럼명 [FROM '문자열' | 컬럼명] )
-- 주어진 컬럼이나 문자열의 앞, 뒤, 양쪽에 있는 지정된 문자를 제거한다.
--> 보통 양쪽 공백 제거에 많이 사용한다.

SELECT '     K  H     ', TRIM( '     K  H     ') FROM DUAL;
SELECT '     K  H     ', TRIM(LEADING ' ' FROM '     K  H     ') FROM DUAL;
SELECT '     K  H     ', TRIM(TRAILING ' ' FROM '     K  H     ') FROM DUAL;
-- LEADING = 앞쪽 TRAILING = 뒤쪽 BOTH = 양쪽,기본값

SELECT -10, ABS(-10) FROM DUAL;
SELECT SALARY, MOD(SALARY, 1000000) FROM EMPLOYEE;
--MOD(SALARY, 500000) SALARY를 500000으로 나눈 "나머지" 출력

SELECT ROUND(123.456) FROM DUAL; -- 기본값 0 => 소수점 1자리
SELECT ROUND(123.456, -1) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;

-- CEIL 올림 FLOOR 내림 TRUNC 버림
SELECT TRUNC(-123.5), FLOOR(-123.5) FROM DUAL;
SELECT ROUND(-123.5), CEIL(-123.5), FLOOR(-123.5), TRUNC(-123.5) FROM DUAL;
-- FLOOR 내리니까 -123.5 에서 -124 ROUND도 -124 왜임? 가장 가까운 정수 짝수인 -124로 반올림된대

SELECT SYSTIMESTAMP FROM DUAL;

SELECT ROUND(MONTHS_BETWEEN(SYSDATE, '2022,02,21')) FROM DUAL;

SELECT MONTHS_BETWEEN(SYSDATE, '2022-02-02') FROM DUAL;

SELECT EMP_NAME, HIRE_DATE, 
'근무 ' || (ROUND( MONTHS_BETWEEN(SYSDATE, HIRE_DATE ),0 ) /12) || '년차' AS 연차 FROM EMPLOYEE;

SELECT EMP_NAME, (SUBSTR(EMP_NO, 1, 8)) || '******' 
FROM EMPLOYEE;

-- (급여 + (급여 * 보너스) ) * 12
SELECT EMP_NAME, JOB_CODE, 
TO_CHAR( (SALARY + (SALARY * NVL(BONUS, 0))) * 12 , 'L999,999,999') AS "연봉(원)" FROM EMPLOYEE;

-- 급여 * (1 + 보너스) * 12
SELECT EMP_NAME, JOB_CODE,
TO_CHAR( SALARY * (1 + NVL(BONUS,0)) * 12, 'L999,999,999' )FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY,
DECODE(JOB_CODE, 'J7', SALARY * 1.1, 'J6', SALARY * 1.15, 'J5', SALARY * 1.2, 
        SALARY * 1.05/*아무것도 일치하지 않을 때*/ ) AS 인상급여
FROM EMPLOYEE;

-- DECODE (계산식 | 컬럼명, 조건값1, 선택값1, 조건값2, 선택값2......, 아무것도 일치하지 않을 때)
SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') AS 성별 FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE, SALARY,
DECODE(JOB_CODE, 'J7', SALARY * 1.1, 'J6', SALARY * 1.15, 'J5', SALARY * 1.2, 
        SALARY * 1.05/*아무것도 일치하지 않을 때*/ ) AS 인상급여
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY,
    CASE
        WHEN SALARY >= 5000000 THEN '고급'
        WHEN SALARY BETWEEN 3000000 AND 5000000 THEN '중급'
        WHEN SALARY < 3000000 THEN '초급'
    END AS 구분
FROM EMPLOYEE
ORDER BY 4 ;

--그룹함수
SELECT SUM(SALARY) FROM EMPLOYEE; 







