-- 함수 : 컬럼의 값을 읽어서 연산한 결과를 반환

-- 단일행(SINGLE ROW) 함수 : N개의 값을 읽어서 N개의 결과를 반환한다.

-- 그룹(GROUP) 함수 : N개의 값을 읽어서 1개의 결과를 반환한다.

-- 함수는 SELECT절, WHERE절, ORDER BY, GROUP BY, HAVING에서 사용 가능하다.

/********************* 단일행 함수 *********************/
-- LENGTH (문자열 | 컬럼) : 문자열의 길이를 반환
SELECT LENGTH('HELLO WORLD') FROM DUAL; -- 띄어쓰기 포함

-- 12글자인 이메일만 조회
SELECT EMAIL, LENGTH(EMAIL) FROM EMPLOYEE
WHERE LENGTH(EMAIL) = 12;

SELECT PHONE, LENGTH(PHONE) FROM EMPLOYEE
WHERE LENGTH(PHONE) = 10;

------------------------------------------------------------------------------

-- INSTR ('문자열' | 컬럼명, '찾을문자', [찾을 위치 시작 위치, [순번]) (찾을위치부터 생략할수도 있음)
-- 지정한 위치부터 지정한 순번재로 검색되는 문자의 시작 위치를 반환한다.

-- 문자열에서 맨 앞에 있는 B 위치 조회
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;

-- 문자열에서 5번째부터 검색해서 맨 앞에 있는 B의 위치를 조회한다.
SELECT INSTR('AABAACAABBAA', 'B', 5) FROM DUAL; --> 9 아홉번째가 나오는 모습
 
-- EMPLOYEE 테이블에서 사원명, 이메일, 이메일 중 '@' 위치를 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@') FROM EMPLOYEE; 

SELECT INSTR('APPLICATION', 'I', 8) FROM DUAL;

SELECT EMP_NAME, PHONE, INSTR(PHONE, '9') FROM EMPLOYEE;

-------------------------------------------------------------------------------

-- SUBSTR('문자열' | 컬럼명, 잘라내기 시작할 위치 [, 잘라낼 길이]) []생략 가능
-- 컬럼이나 문자열에서 지정한 위치부터 지정된 길이만큼 문자열을 잘라내서 반환한다.
-- 잘라낼 길이 생략 시 끝까지 잘라낸다.

--EMPLOYEE 테이블에서 사원명, 이메일 중 아이디만 조회 sun_di@or.kr (@앞 까지만 조회하겠다.)
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, (INSTR(EMAIL, '@')-1) ) AS 아이디 FROM EMPLOYEE
--ORDER BY SUBSTR(EMAIL, 1, (INSTR(EMAIL, '@')-1) );
--ORDER BY 3;
ORDER BY 아이디;

SELECT EMP_NAME, PHONE, SUBSTR(PHONE, 4) AS 번호만 FROM EMPLOYEE;
SELECT EMP_NAME, PHONE, SUBSTR(PHONE, 1, INSTR(PHONE, '8'))/*문자열 8 이 존재한 곳까지 잘라내기*/ FROM EMPLOYEE;

-------------------------------------------------------------------------------

-- TRIM([옵션] '문자열 | 컬럼명 [FROM '문자열' | 컬럼명] )
-- 주어진 컬럼이나 문자열의 앞, 뒤, 양쪽에 있는 지정된 문자를 제거한다.
--> 보통 양쪽 공백 제거에 많이 사용한다.

-- 옵션 : LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

SELECT '     K  H     ', TRIM(LEADING ' ' FROM '     K  H     ') FROM DUAL; -- 양쪽 공백 제거 (글자사이 공백은 안되는 모습)
SELECT '---KH---', TRIM(TRAILING/*BOTH*/ /*옵션주기*/ '-' FROM '---kh---') FROM DUAL;
-- BOTH 또는 생략 시 : 양쪽 '-' 기호 제거 -> BOTH 가 기본값이다.
-- LEADING : 앞쪽만 제거
-- TRAILING : 뒤쪽만 제거

SELECT '  A P P L E  ', TRIM('  A P P L E  ') FROM DUAL; -- 앞뒤 공백 사라짐
SELECT '  A P P L E  ', TRIM(TRAILING ' ' FROM '  A P P L E  ') FROM DUAL;

SELECT '     A PPLICATION ', TRIM(LEADING ' ' FROM '     A PPLICATION ') FROM DUAL;
-------------------------------------------------------------------------------

/* 숫자 관련 함수 */
-- ABS(숫자 | 컬럼명) : 절대 값을 알려준다.
SELECT ABS(10), ABS(-10) FROM DUAL; -- 둘다 10으로 나오는 모습(절대값)

-- MOD(숫자 | 컬럼명, 숫자 | 컬럼명) : 나머지 값 반환 -- %안쓰는 이유 = LIKE에서 써서 중복

--EMPLOYEE 테이블에서 사원의 월급을 100만원으로 나눴을 때 나머지 조회

SELECT EMP_NAME, SALARY, MOD(SALARY,1000000)/*SALARY / 100*/ AS 나머지
FROM EMPLOYEE;

SELECT SALARY, MOD(SALARY, 500000) AS 나머지 
FROM EMPLOYEE;

--ROUND(숫자 | 컬럼명 |[,소수점 위치]) : 반올림
SELECT 123.567, ROUND(123.567) FROM DUAL; -- 소수점 위치 생략하면 기본값 0, 소수점 첫째 자리에서 반올림한다.
SELECT 123.456, ROUND(123.456, 1/*반올림 할 소수점 위치*/) FROM DUAL; -- 소수점 첫째자리까지 == 소수점 둘째자리에서 반올림
SELECT 123.456, ROUND(123.456, 2/*반올림 할 소수점 위치*/) FROM DUAL; -- 소수점 둘째자리까지 == 소수점 셋째자리에서 반올림

SELECT 123.456, ROUND(123.456, 0) FROM DUAL; -- 소수점 1번째 자리에서 반올림
SELECT 123.456, ROUND(123.456, -1) FROM DUAL; -- 소수점 0번째 자리에서 반올림 == 정수 첫번째 자리에서 반올림 == 3에서 반올림해서 120
SELECT 123.456, ROUND(123.456, -2) FROM DUAL; -- 소수점 -1번째 자리에서 반올림 == 2에서 반올림해서 100

-------------------------------------------------------------------------------

--CEIL(숫자 | 컬럼명) : 올림
--FLOOR(숫자 | 컬럼명) : 내림

SELECT 123.5, CEIL(123.5), FLOOR(123.5) FROM DUAL; -- 기본값 소수점 위치 0 : 소수점 첫째자리에서 올린다.
SELECT 123.55, CEIL(123.55, 1), FLOOR(123.55, 1) FROM DUAL;

-- TRUNC (숫자 | 컬럼명 [,위치]) : 특정 위치 아래를 버린다.(절삭한다.)
SELECT TRUNC(123.456, 1)/*소수점 2번째자리부터 버리겠다.*/, TRUNC(123.456, -1)/* 소수점 -1번째 자리부터 버리겠다(0이 있어서 -1번쨰 자리)*/ FROM DUAL;

-- 버림, 내림의 차이점
SELECT TRUNC(-123.5), FLOOR(-123.5) FROM DUAL; -- 내림은 음수(-)에서 124로 내려가는 모습
SELECT ROUND(-123.5), CEIL(-123.5), FLOOR(-123.5), TRUNC(-123.5) FROM DUAL;
--     ROUND 반올림은 가장 가까운 정수 짝수인 -124로 반올림된다. ???
SELECT ROUND(-124.5) FROM DUAL;

-------------------------------------------------------------------------------
/*날짜(DATE) 관련 함수 */

-- SYSDATE : 시스템에 현재 시간(년,월,일,시,분,초)을 반환
SELECT SYSDATE FROM DUAL;

-- SYSTIMESTAMP : SYSDATE + MS 단위 추가 (1000분의 1초)
SELECT SYSTIMESTAMP FROM DUAL;

--MONTHS_BETWEEN(날짜, 날짜) : 두 날짜의 개월 수 차이를 반환한다.
SELECT ROUND(MONTHS_BETWEEN(SYSDATE, '2022,02,21'),1) || '개월' AS 수강기간 FROM DUAL;

--EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 개월 수 조회

SELECT * FROM EMPLOYEE;
SELECT EMP_NAME, HIRE_DATE, '근무 ' || (ROUND( MONTHS_BETWEEN(SYSDATE, HIRE_DATE ),0 ) / 12) || '년차' AS 연차 FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, 
'근무' || CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) || '개월 차' AS "근무개월수", 
'근무' ||CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) || '년 차' AS "근무 햇수"
FROM EMPLOYEE;

-------------------------------------------------------------------------------

--ADD_MONTHS(날짜, 숫자) : 날짜에 숫자만큼의 개월 수를 더한다.
SELECT ADD_MONTHS(SYSDATE, 4)+ 7/*날짜 더하기*/ FROM DUAL;

--LAST_DAY(날짜) : 해당 달의 마지막 날짜를 구한다.
SELECT LAST_DAY(SYSDATE) + 20 FROM DUAL; -- 마지막 날에 20 더함
SELECT LAST_DAY('2023/04/01') FROM DUAL; 

-------------------------------------------------------------------------------

-- EXTRACT : 년, 월, 일 정보를 추출하여 리턴한다.
-- EXTRACT(YEAR FROM 날짜) : 년도만 추출
-- EXTRACT(MONTH FROM 날짜) : 월만 추출
-- EXTRACT(DAY FROM 날짜) : 일만 추출

-- EMPLOYEE 테이블에서 각 사원의 이름, 입사년도, 입사 월, 입사 일 조회

SELECT EMP_NAME 이름, 
EXTRACT(YEAR FROM HIRE_DATE) || '년' 입사년도, 
EXTRACT(MONTH FROM HIRE_DATE) || '월' 입사월, 
EXTRACT(DAY FROM HIRE_DATE) || '일' 입사일 FROM EMPLOYEE
WHERE EXTRACT(MONTH FROM HIRE_DATE) = 1
ORDER BY 2;

-------------------------------------------------------------------------------

/* 형변환 함수 */

-- 문자열(CHAR), 숫자(NUMBER), 날짜(DATE) 끼리 형 변환이 가능하다.

/* 문자열로 변환 */
-- TO_CHAR(날짜, [포맷]) : 날짜형 데이터를 문자형 데이터로 변경한다.
-- TO_CHAR(숫자, [포맷]) : 숫자형 데이터를 문자형 데이터로 변경한다.

-- <패턴>
-- 9 : 숫자 한 칸을 의미, 여러개 작성 시 오른쪽 정렬
-- 0 : 숫자 한 칸을 의미, 여러개 작성 시 오른쪽 정렬 + 빈칸에 0 추가해줌.
-- L : 현재 DB에 설정된 나라의 화폐 기호

SELECT TO_CHAR(1234, '99999') FROM DUAL; -- 빈칸 왼쪽에 생기고 오른쪽 정렬
SELECT TO_CHAR(1234, '000000000') FROM DUAL; -- 빈칸이 0으로 생김

SELECT TO_CHAR(1000000, '9,999,999') FROM DUAL; -- 1,000,000
SELECT TO_CHAR(1000000, 'L9,999,999') FROM DUAL; 
SELECT TO_CHAR(1000000, '$9,999,999') FROM DUAL; 

-- 직원들의 급여를 '\(원)999,999,999' 형식으로 조회
SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999') AS 급여 FROM EMPLOYEE;

--날짜에 TO_CHAR 적용하기

-- YYYY : 년도 / YY : 년도(짧게)
-- RRRR : 년도 / RR : 년도(짧게)
-- MM : 월 
-- DD : 일

-- AM 또는 PM : 오전/오후 표시

-- HH : 시간 / HH24 : 24시간 표기법
-- MI : 분
-- SS : 초
-- DAY : 요일(전체) 수요일 / DY : 요일(요일명만 표시) 수

SELECT SYSDATE, TO_CHAR(SYSDATE, 'DAY AM HH24:MI:SS') FROM DUAL;

-- 직원들의 입사일을 '2017년 12월 06일 (수)' 형식으로 출력
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" (DY)') AS 입사일 FROM EMPLOYEE;
--> 년, 월, 일은 오라클에 등록된 날짜 표기 패턴이 아니라 YYYY년 MM월 DD일을 쓸 수 없다.
--> 기존에 없던 패턴 추가시 ""(쌍따옴표)로 감싸줘서 문자열 그대로를 출력하게 한다.

-------------------------------------------------------------------------------

/* 날짜로 변환 TO_DATE */
-- TO_DATE(문자형 데이터, [포맷]) : 문자형 데이터를 날짜로 변경한다.
-- TO_DATE(숫자형 데이터, [포맷]) : 숫자형 데이터를 날짜로 변경한다.
--> 지정된 포맷으로 날짜를 인식한다.

SELECT '2023-05-17', (TO_DATE('2023-05-17')), 
(TO_DATE('2023-05-17', 'YYYY-MM-DD')),TO_CHAR(TO_DATE('2023-05-17'),'DAY') FROM DUAL; -- 00:00:00 까지 나옴. 내가 설정해논 날짜 데이터로 변경된 모습

SELECT TO_DATE('20100103') FROM DUAL; -- 문자를 변환
SELECT TO_DATE(20100103) FROM DUAL; -- 숫자를 변환

SELECT TO_DATE('041030 143000', 'YYMMDD HH24MISS') FROM DUAL;

SELECT TO_CHAR(TO_DATE('041030 143000', 'YYMMDD HH24MISS'), 'YYYY/MM/DD HH24"시"MI"분"' ) FROM DUAL;
-- 문자열을 날짜로 변경한 뒤 다시 문자열로 변경한 것

-- EMPLOYEE 테이블에서 각 직원이 태어난 생년월일 조회

SELECT EMP_NAME, EMP_NO FROM EMPLOYEE;

SELECT EMP_NAME, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD') FROM EMPLOYEE;

-- Y : 현재 세기(21세기 == 2000년대) 
-- R : 1세기 기준으로 절반(50년) 이상이면 이전 세기(1900년대)
--                  절반(50년) 미만이면 현재 세기(2000년대) 

-------------------------------------------------------------------------------

/* 숫자 형변환 */
-- TO_NUMBER(문자데이터, [포맷]) : 문자형 데이터를 숫자형 데이터로 변경

--SELECT '1,000,000' + 10 FROM DUAL;
SELECT TO_NUMBER('1,000,000', '9,999,999') + 10 FROM DUAL;

-------------------------------------------------------------------------------

/* NULL 처리 함수 */

-- NVL(컬럼명, 컬럼값이 NULL일때 바꿀 값) : NULL인 컬럼 값을 다른 값으로 변경한다.

-- EMPLOYEE 이름, 급여, 보너스, 급여*보너스 조회
SELECT EMP_NAME, SALARY, NVL(BONUS, 0), SALARY * NVL(BONUS, 0) FROM EMPLOYEE; -- 한 계산식이 한 표에서만 처리되니까

-- NVL2(컬럼명, 바꿀값1, 바꿀값2)
-- 해당 컬럼의 값이 있으면 바꿀값1로 변경
-- 해당 컬럼이 NULL이면 바꿀값2로 변경

--EMPLOYEE 테이블에서 기존 보너스를 받던 사원의 보너스를 0.8로 변경
-- 보너스를 받지 못했던 사원의 보너스를 0.3으로 변경하여 이름, 기존보너스, 변경된 보너스 조회
SELECT EMP_NAME, NVL(BONUS, 0) AS 기존보너스 , NVL2(BONUS, 0.8, 0.3) AS 변경된보너스 FROM EMPLOYEE;

-- 연습문제 --
-- EMPLOYEE 사원명, 입사일- 오늘, 오늘-입사일 조회
-- 단, 입사일-오늘의 별칭은 "근무일수1"
-- 오늘-입사일의 별칭은 "근무일수2"로 하고 
-- 모두 정수(내림)처리, 양수가 되도록 처리

SELECT EMP_NAME, FLOOR((HIRE_DATE-SYSDATE)) AS "근무일수1",FLOOR(SYSDATE-HIRE_DATE) AS "근무일수2" FROM EMPLOYEE
ORDER BY 2, 3 DESC;

--EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT * FROM EMPLOYEE
--WHERE MOD(EMP_ID,2) = 1; 
WHERE SUBSTR(EMP_ID, -1, 1) IN ('1','3','5','7','9');

--EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회

SELECT * FROM EMPLOYEE 
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;

-- 월까지 계산이 필요합니다. 아래와 같이 수정하면 됩니다.
--SELECT * FROM EMPLOYEE
--WHERE MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12 >= 20;

-- EMPLOYEE 테이블에서
-- 직원명과 주민번호를 조회
-- 단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
-- 예 : 홍길동 771120-1******

SELECT EMP_NAME, (SUBSTR(EMP_NO, 1, 8)) || '******' 
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 보너스가 적용된 1년치 급여 + ￦57,000,000 으로 표시 
-- (급여 + (급여 * 보너스) ) * 12

SELECT EMP_NAME, JOB_CODE, 
TO_CHAR( (SALARY + (SALARY * NVL(BONUS, 0))) * 12 , 'L999,999,999') AS "연봉(원)" 
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE,
-- 급여 * (1 + 보너스) * 12
TO_CHAR( SALARY * (1 + NVL(BONUS,0)) * 12, 'L999,999,999' )FROM EMPLOYEE;

-- 숙제 --
-- EMPLOYEE 테이블에서
-- 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
-- 사번 사원명 부서코드 입사일 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D9') AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;
--WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;

-- EMPLOYEE 테이블에서
-- 직원명, 입사일, 입사한 달의 근무일수 조회
-- 단, 입사한 날도 근무일수에 포함해서 +1 할 것
SELECT EMP_NAME, HIRE_DATE, EXTRACT(MONTH FROM HIRE_DATE) || '월' AS "입사한 달", 
(EXTRACT(DAY FROM LAST_DAY(HIRE_DATE)) - (EXTRACT(DAY FROM HIRE_DATE)) + 1) AS "입사한 달의 근무일수"
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE,
LAST_DAY(HIRE_DATE) - EXTRACT(DAY FROM HIRE_DATE) + 1 " 근무일수 "
FROM EMPLOYEE;

--ADD_MONTHS(날짜, 숫자) : 날짜에 숫자만큼의 개월 수를 더한다.
--LAST_DAY(날짜) : 해당 달의 마지막 날짜를 구한다.

-- EMPLOYEE 테이블에서
-- 직원명, 부서코드, 생년월일, 나이 조회
-- 단, 생년월일은 주민번호에서 추출해서, 
-- ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
-- 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산.
-- (년도만을 이용한 나이 구하기,   만 나이 구하기 둘다 시도해보세요!)

SELECT EMP_NAME, DEPT_CODE, 
    SUBSTR(EMP_NO, 1, 2) || '년' ||
    SUBSTR(EMP_NO, 3, 2) || '월' ||
    SUBSTR(EMP_NO, 5, 2) || '일' AS 생년월일,
    EXTRACT(YEAR FROM SYSDATE) - 
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) AS "나이" 
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, 
    TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD'), 'RR"년" MM"월" DD"일" ') AS 생년월일,
    EXTRACT(YEAR FROM SYSDATE) - 
    EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) +1 AS "나이" ,
    (MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD') ) / 12) AS 만나이;
    FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD') ) / 12) AS 만나이2;
    
    

FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD'), 'RR"년" MM"월" DD"일" ') AS 생년월일,
(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) +1)  AS 실제나이, 
-- 실제나이 : 해당 연도가 아직 끝나지 않았기 때문에 한살 추가 // 2023 - 1997 = 26
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR'))  AS 만나이
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD'), 'RR"년" MM"월" DD"일" ') AS 생년월일,
(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) +1)  AS 실제나이, 
-- 실제나이 : 해당 연도가 아직 끝나지 않았기 때문에 한살 추가 // 2023 - 1997 = 26
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR'))  +
    CASE 
    WHEN EXTRACT(MONTH FROM SYSDATE) - EXTRACT(MONTH FROM TO_DATE(SUBSTR(EMP_NO, 3, 4), 'MM')) < 0 THEN -1
    WHEN EXTRACT(MONTH FROM SYSDATE) - EXTRACT(MONTH FROM TO_DATE(SUBSTR(EMP_NO, 3, 4), 'MM')) >= 0 THEN +0
    END AS 만나이
--만나이 계산법 : 현재연도 - 출생연도 ** 올해 생일이 지난 경우 만나이 = 현재연도 - 출생년도 - 1
FROM EMPLOYEE; -- 월 같으면 5/8인경우 5/17일이면 생일 안지났는데 일까지 계산을 어케함?

SELECT EMP_NAME, DEPT_CODE,
TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD'), 'YYYY"년" MM"월" DD"일') AS 생년월일,
(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1) AS 실제나이,
(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) -
CASE
WHEN TO_DATE(SUBSTR(EMP_NO, 3, 4)||'0101', 'MMDD') > SYSDATE THEN 1
ELSE 0
END +
TRUNC((SYSDATE - TO_DATE(SUBSTR(EMP_NO, 3, 4)||SUBSTR(EMP_NO, 5, 2)||SUBSTR(EMP_NO, 7, 2), 'YYYYMMDD')) / 365) ) AS 만나이일
FROM EMPLOYEE;


-------------------------------------------------------------------------------
/*선택 함수*/
-- 여러가지 경우에 따라 알맞은 결과를 선택할 수 있다.

-- DECODE (계산식 | 컬럼명, 조건값1, 선택값1, 조건값2, 선택값2......, 아무것도 일치하지 않을 때)
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환
-- 일치하는 값을 확인 (자바의 switch 같음)

-- 직원들의 성별 구분하기
SELECT EMP_NAME, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') AS 성별 FROM EMPLOYEE; 

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7인 직원은 급여의 10%를 인상하고
-- 직급코드가 J6인 직원은 급여의 15%를 인상하고
-- 직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 그 외 직급의 직원은 급여의 5%만 인상한다.
-- 직원 테이블에서 직원명, 직급코드, 급여, 인상급여(위 조건)을 조회하세요

SELECT EMP_NAME, JOB_CODE, SALARY,
DECODE(JOB_CODE, 'J7', SALARY * 1.1, 'J6', SALARY * 1.15, 'J5', SALARY * 1.2, 
        SALARY * 1.05/*아무것도 일치하지 않을 때*/ ) AS 인상급여
FROM EMPLOYEE;

-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END

-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환
-- 조건은 범위 값 가능

SELECT EMP_NAME, 
    CASE
        WHEN SUBSTR(EMP_NO, 8, 1) = '1' THEN '남자'
        WHEN SUBSTR(EMP_NO, 8, 1) = '2' THEN '여자'
    END AS 성별
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사번, 사원명, 급여를 조회
-- 급여가 500만원 이상이면 '고급'
-- 급여가 300~500만원이면 '중급'
-- 그 미만은 '초급'으로 출력처리하고 별칭은 '구분'으로 한다.
-- 부서코드가 'D6'인 직원만 조회
-- 직급코드 오름차순 정렬

SELECT EMP_ID, EMP_NAME, SALARY,
    CASE
        WHEN SALARY >= 5000000 THEN '고급'
        WHEN SALARY BETWEEN 3000000 AND 5000000 THEN '중급'
        --네, 정확하게 말하면 5000000원을 받는 사람은 '중고급'에 해당됩니다. 즉, 중급과 고급 둘 다 해당됩니다.
        -- 걍 고급이 위에있어서 고급부터 되는듯
        WHEN SALARY < 3000000 THEN '초급'
    END AS 구분
FROM EMPLOYEE
ORDER BY 4 ;

-------------------------------------------------------------------------------
/*그룹 함수*/
-- 하나 이상의 행을 그룹으로 묶어 연산하여 총합, 평균 등의 하나의 결과 행으로 반환하는 함수

-- SUM(숫자가 기록된 컬럼명) : 합계
-- 모든 직원의 급여 합
SELECT SUM(SALARY) FROM EMPLOYEE; 

-- 부서코드가 'D9'인 직원들의 급여 합
SELECT DEPT_CODE, SUM(SALARY) AS D9SUM FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';
-- SELECT 에 1개 더넣으면 왜안됨?

--AVG(숫자가 기록된 컬럼명) : 평균
--전 직원 급여 평균
SELECT ROUND(AVG(SALARY)) FROM EMPLOYEE;

-- MIN(컬럼명) : 최소값
-- MAX(컬럼명) : 최대값
--> 타입 제한 없음 (숫자 : 대/소 날짜 : 과거/미래, 문자열 : 문자 순서)

--EMPLOYEE 가장 낮은 급여, 가장 빠른 입사일, 알파벳 순서가 가장 빠른 이메일
SELECT MIN(SALARY), MIN(HIRE_DATE), MIN(EMAIL) FROM EMPLOYEE;
-- 그룹 함수는 여러개를 동시 작성 가능한데
-- 이때 결과는 실제 테이블 한 행이 아니고
-- 각 그룹함수 별 독립된 결과이다. 셀러리 열 전체에서 검색, ...... 이런식
SELECT EMAIL FROM EMPLOYEE
ORDER BY EMAIL;

-- 사번이 200이 아닌 사람들 중에서
-- EMPLOYEE 테이블에서 가장 높은 급여,
-- 가장 늦은 입사일,
-- 알파벳 순서가 가장 늦은 이메일
SELECT MAX(SALARY), MAX(HIRE_DATE), MAX(EMAIL) 
FROM EMPLOYEE
--WHERE EMP_ID NOT IN ('200'); -- (200) 도 가능
-- SQL에서 숫자 상수와 문자열 상수는 구분하지 않습니다. 
-- 따라서 '200'과 200은 같은 값을 나타냅니다. 즉, 두 문장은 같은 조건을 나타냅니다.
WHERE EMP_ID != 200;

-- DISTINCT : 조회 시 컬럼에 포함된 중복 값을 한 번만 표시할 때 사용한다.
-- 1) DISTINCT는 SELECT문에 딱 한번만 작성할 수 있다.
-- 2) DISTINCT는 SELECT문 가장 앞에 작성되어야 한다.

-- * COUNT ( * | 컬럼명) : 행 개수를 헤아려서 리턴
-- COUNT ([DISTINCT] 컬럼명) : 중복을 제거한 행 개수를 헤아려서 리턴
-- COUNT(*) : NULL을 포함한 전체 행 개수를 리턴
-- COUNT(컬럼명) : NULL을 제외한 실제 값이 기록된 행 개수를 리턴함

-- 전체 행의 개수 == 전체 직원 수
SELECT COUNT(*) FROM EMPLOYEE; -- 23개 행이 나온다.

-- DEPT_CODE가 NULL이 아닌 행의 개수
SELECT COUNT(*) FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL; -- != 쓰지 않음
-- 왜 != NULL 은 0나오고 != 'NULL' 하면 됨???

-- COUNT(컬럼명) : NULL을 제외한 실제 값이 기록된 행 개수를 리턴함
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE;

-- EMPLOYEE 테이블에 있는 부서 개수
SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE; 

-- EMPLOYEE 테이블에 있는 남자 직원 수 조회
SELECT COUNT(*) AS 남자직원수 FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1';

SELECT COUNT(
    CASE
        WHEN SUBSTR(EMP_NO, 8, 1) = '1' THEN '남자'
        END) AS 남자
FROM EMPLOYEE;

SELECT SUM(DECODE(SUBSTR(EMP_NO, 8, 1), '1', 1)) 
FROM EMPLOYEE;



