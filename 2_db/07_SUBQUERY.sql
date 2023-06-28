/*
        * SUBQUERY (서브쿼리)
        - 하나의 SQL 문 안에 포함된 또다른 SQL(SELECT)문
        - 메인쿼리(기존쿼리)를 위해 보조 역할을 하는 쿼리문
        --SELECT, FROM, WHERE, HAVING 절에서 사용 가능

*/

-- 서브 쿼리 예시 1)
-- 부서코드가 노옹철 사원과 같은 소속의 직원의
-- 이름, 부서코드 조회하기

-- 1) 사원명이 노옹철인 사람의 부서코드 조회
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

-- 2) 부서코드가 D9인 직원을 조회한다.
SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 부서코드가 노옹철사원과 같은 소속의 직원 명단 조회
--> 위 2개의 단계를 하나의 쿼리로 만든다. 
--> 1. 쿼리문을 서브쿼리로 사용한다.
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE -- 메인쿼리
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE 
WHERE EMP_NAME = '노옹철'); -- 서브쿼리 

-- 서브쿼리 예시 2.
-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의
-- 사번, 이름, 직급코드, 급여 조회

-- 1. 전 직원의 평균 급여 조회
SELECT AVG(SALARY) FROM EMPLOYEE;

-- 2. 직원들 중 급여가 평균(3047663) 보다 높은 직원 찾기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > 3047663; -- AVG(SALARY) 쓰면 그룹함수 오류
-- 위의 쿼리는 AVG(SALARY)가 그룹함수이기 때문에 단일 행 비교로 사용할 수 없습니다. 
-- 서브쿼리를 사용하여 단일 행값을 가져와야 합니다.

-- 3. 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

-------------------------------------------------------------------------------
/* 서브 쿼리 유형
    
    - 단일행(+단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개일 때
 
    - 다중행(+단일열) 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러개일 때

    - 다중열 서브쿼리 : 서브쿼리에 SELECT절에 나열된 항목의 수가 여러개일 떄

    - 다중행 다중열 서브쿼리 : 조회 결과 행 수와 열 수가 여러개일 때
    
    - 상관 서브쿼리 : 서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때
                    메인 쿼리 테이블의 값이 변경되면 서브쿼리의 결과값도 바뀌는 서브쿼리
                    
    - 스칼라 서브쿼리 : 상관 쿼리이면서 결과 값이 하나인 서브쿼리
    
    * 서브쿼리 유형에 따라 서브쿼리 앞에 붙은 연산자가 다르다.
                    
*/

-- 1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
--    서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
--    단일행 서브쿼리 앞에는 비교 연산자를 사용한다.
--    <, >, <=, >=, =, !=/^=<>

-- 전 직원의 급여 평균보다 많은 급여를 받는 직원의
-- 이름, 직급, 부서, 급여를 직급 순으로 정렬하여 조회

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY 
FROM EMPLOYEE
WHERE -- SALARY > 전 직원의 급여 평균
SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY 2;

-- 가장 적은 급여를 받는 직원의
-- 사번, 이름, 직급, 부서코드, 급여, 입사일을 조회해라

SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY 급여, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 노옹철 사원의 급여보다 많이 받는 직원의
-- 사번, 이름, 부서, 직급, 급여를 조회해라

--ANSI
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서, JOB_CODE 직급, SALARY 급여
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

--ORACLE
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_TITLE 부서, JOB_CODE 직급, SALARY 급여
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 부서 별(부서가 없는사람 포함) 급여의 합계 중 가장 큰 부서의 
-- 부서명, 급여 합계를 조회

-- 1) 부서별 급여 합 중 가장 큰 값 조회
SELECT MAX(SUM(SALARY)) 
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE;

-- 2) 부서별 급여 합이 17700000인 부서의 부서명과 급여 합 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000;

-- 3) 위의 두 서브쿼리 합 부서별 급여 합이 큰 부서의 부서명, 급여 합 조회

SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) 
                      FROM EMPLOYEE 
                      GROUP BY DEPT_CODE); -- 부서 별 값이 바껴도 이렇게쓰면 자동조회가 가능하다.
   
-------------------------------------------------------------------------------   
                
-- 2. 다중행 서브쿼리 (MULTI ROW SUBQUERY)
--    서브쿼리의 조회 결과 값의 개수가 여러행일 때

/*
    >> 다중행 서브쿼리 앞에는 일반 비교연산자 ( =, <, > 같은 거) 사용하지 않는다.
    
     - IN / NOT IN : 여러 개의 결과값 중에서 "한 개라도 일치"하는 값이 있다면
                    혹은 없다면 이라는 의미(가장 많이 사용!)
                    
    - > ANY, < ANY : 여러개의 결과값 중에서 "한개라도" 큰 / 작은 경우
                     가장 작은 값보다 큰가? / 가장 큰 값 보다 작은가?
                     
    - > ALL, < ALL : 여러개의 결과값의 "모든 값보다" 큰 / 작은 경우
                     가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?
                     
    - EXISTS / NOT EXISTS : 값이 존재하는가? / 존재하지 않는가?

*/

-- 부서별 최고 급여를 받는 직원의
-- 이름, 직급, 부서, 급여를 부서순으로 정렬하여 조회

-- 1. 부서별 최고급여
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE; -- 7행 1열 // 한 행은 NULL임 지금

-- 2. 
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                    GROUP BY DEPT_CODE); -- 급여가 부서별 최고 급여 안에 들어갈 때만 출력하겠다.
                                         -- 부서 별 값이 바껴도 이렇게쓰면 자동조회가 가능하다.
                                         
-- 사수에 해당하는 직원에 대해 조회
-- 사번, 이름, 부서명, 직급명, 구분(사수 / 직원)

-- 1. 사수에 해당하는 사원 번호 조회
SELECT DISTINCT/*중복제거*/ MANAGER_ID  FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2. 직원의 사번, 이름 ,부서명, 직급명 조회(부서 없는 사람 포함)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 3. 사수에 해당하는 직원에 대한 정보 추출 조회 (이 때 , 구분은 '사수')
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT MANAGER_ID  
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL); --  단일 행 하위 질의에 2개 이상의 행이 리턴되었습니다.
                                               -- = 하면 결과가 하나여야함. 지금 값이 6개라 일반연산자 사용 불가능  

-- 4. 일반 직원에 해당하는 사원들(사수가 아닌 사람) 정보 조회 (이 때, 구분은 '사원' 으로)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID  
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL);

-- 5. (3,4)의 조회 결과를 하나로 합친다. -> SELECT절 SUBQUERY
-- *** SELECT 절에도 서브쿼리를 사용할 수 있다.

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, 
    CASE
        WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID  FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL) THEN '사수'
        ELSE '사원'
        END 구분
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
ORDER BY 5;
                          
-- 사번 200, 216 -> 사수 아니라면 '---'                                         
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, 
    CASE
        WHEN EMP_ID IN ('200', '216') THEN '사수'
        ELSE '---'
        END 구분
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
ORDER BY 5;

-- UNION 사용 예제 
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT MANAGER_ID  
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL)
                
UNION -- 합집합 중복포함 안함. 2개의 RESULT SET을 하나로 합침.        
                       
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN (SELECT DISTINCT MANAGER_ID  
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL);                

--대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원의
-- 사번, 이름, 직급, 급여를 조회해라
-- 단, >ANY 혹은 <ANY 연산자를 사용해라.


-- 1) 직급이 대리인 직원들의 사번, 이름 , 직급명, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE) 
WHERE JOB_NAME = '대리';

-- 1)과장 직급의 급여 조회하기
SELECT SALARY 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

-- 3) 대리 직급의 직원들 중에서 과장 직급의 최소 급여(2200000)보다 많이 받는 직원 조회
-- 3-1) MIN 이용하여 단일행 서브쿼리를 만든다.
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE) 
WHERE JOB_NAME = '대리'
AND SALARY > (SELECT MIN(SALARY) 
            FROM EMPLOYEE
            JOIN JOB USING(JOB_CODE)
            WHERE JOB_NAME = '과장');
            
--  > ANY, < ANY : 여러개의 결과값 중에서 "한개라도" 큰 / 작은 경우
--                  가장 작은 값보다 큰가? / 가장 큰 값 보다 작은가?

-- 3-2) 문제대로 ANY 이용해서 풀기            
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE) 
WHERE JOB_NAME = '대리'
AND SALARY < ANY (SELECT SALARY 
            FROM EMPLOYEE
            JOIN JOB USING(JOB_CODE)
            WHERE JOB_NAME = '과장');
-- -< ANY 하면 () 안의 여러개의 결과값 중 가장 큰 값보다 작은가? 라고 물어보는 것           
 -- > ANY 하면 ()안의 여러개의 결과값 중 가장 작은 값보다 크냐? 물어보는 것 

-- 차장 직급의 급여의 가장 큰 값보다 많이 받는 과장 직급의 직원
-- 사번, 이름, 직급, 급여를 조회하세요

-- > ALL, < ALL : 여러개의 결과값의 "모든 값보다" 큰 / 작은 경우
--                가장 큰 값 보다 큰가? / 가장 작은 값 보다 작은가?


SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY 
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE) 
WHERE JOB_NAME = '과장'
AND SALARY > (SELECT MAX(SALARY) 
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '차장');
/*AND SALARY > ALL (SELECT SALARY
                FROM EMPLOYEE
                JOIN JOB USING(JOB_CODE)
                WHERE JOB_NAME = '차장');*/ -- 차장 안의 모든 값보다 큰가?

-- LOCATION 테이블에서 NATIONAL_CODE가 KO인 경우의 LOCAL_CODE와
-- DEPARTMENT 테이블의 LOCATION_ID와 동일한 DEPT_ID가 
-- EMPLOYEE테이블의 DEPT_CODE와 동일한 사원을 구하시오.
SELECT * FROM LOCATION;

-- 1) LOCATION 테이블을 통해 NATIONAL_CODE가 KO인 LOCAL_CODE 조회
SELECT LOCAL_CODE
FROM LOCATION
WHERE NATIONAL_CODE = 'KO'; -- L1(단일행 서브쿼리)

-- 2) DEPARTMENT 테이블에서 위의 결과와 동일한 LOCATION_ID를 가지고 있는 DEPT_ID를 조회
SELECT DEPT_ID 
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE
                    FROM LOCATION
                    WHERE NATIONAL_CODE = 'KO');
                    
-- 3) 최종적으로 EMPLOYEE 테이블에서 위의 결과들과 동일한 DEPT_CODE를 가지는 사원 조회

SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_ID -- 다중행
                    FROM DEPARTMENT                                 
                    WHERE LOCATION_ID = (SELECT LOCAL_CODE
                                                FROM LOCATION
                                                WHERE NATIONAL_CODE = 'KO')); -- 단일행
                
-------------------------------------------------------------------------------

-- 3. 다중열 서브쿼리 (단일 행 [=결과값이 한 행이다.])
--    서브쿼리 SELECT절에 나열된 컬럼 수가 여러개 일 때

-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는
-- 사원의 이름, 직급, 부서, 입사일을 조회한다.
SELECT * FROM EMPLOYEE; -- ENT_DATE

-- 1) 퇴사한 여직원 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2'
AND ENT_YN = 'Y';

-- 2) 퇴사한 여직원과 같은 부서, 같은 직급 (다중 열 서브 쿼리)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT  DEPT_CODE
                FROM EMPLOYEE
                WHERE SUBSTR(EMP_NO, 8, 1) = '2'
                AND ENT_YN = 'Y')
AND JOB_CODE = (SELECT  JOB_CODE
                FROM EMPLOYEE
                WHERE SUBSTR(EMP_NO, 8, 1) = '2'
                AND ENT_YN = 'Y'); -- 이렇게 나누기 보다

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT  DEPT_CODE, JOB_CODE -- 순서 바꾸면 안됨. -- 다중열 서브쿼리 
                FROM EMPLOYEE
                WHERE SUBSTR(EMP_NO, 8, 1) = '2'
                AND ENT_YN = 'Y'); -- 간단하게 쉼표로 2개 다 한번에 처리

-- 숙제 --
-- 1. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오 (단, 노옹철 사원은 제외)
-- 사번, 이름, 부서코드, 직급코드, 부서명, 직급명

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- NATURAL JOIN JOB = 컬럼명, 데이터 타입이 다 일치해야 사용
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '노옹철')
AND EMP_NAME != '노옹철';

-- 2. 2000년도에 입사한 사원의 부서와 직급이 같은 사원을 조회하시오
--    사번, 이름, 부서코드, 직급코드, 고용일

--2000년도에 입사한 사원
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE SUBSTR(HIRE_DATE, 1, 4) = 2000;

--2000 유재식과 부서, 직급이 같은 사원 (J3,해외영업2부, D6)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE (DEPT_TITLE, JOB_NAME) IN ( SELECT DEPT_TITLE, JOB_NAME FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SUBSTR(HIRE_DATE, 1, 4) = 2000);

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000);


SELECT * FROM JOB;
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

-- 3. 77년생 여자 사원과 동일한 부서이면서 동일한 사수를 가지고 있는 사원을 조회하시오
--    사번, 이름, 부서코드, 사수번호, 주민번호, 고용일  

-- 77년생 여자 사원 찾기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID, EMP_NO, HIRE_DATE
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 1, 2) = '77' AND SUBSTR(EMP_NO, 8,1) = '2';
-- 217	전지연	D1	214	770808-2665412	2007-03-20 00:00:00

-- 전지연과 동일한 부서이면서 동일한 사수를 가지고 있는 사원 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID, EMP_NO, HIRE_DATE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE (DEPT_TITLE, MANAGER_ID) IN 
(SELECT DEPT_TITLE, MANAGER_ID
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 1, 2) = '77' AND SUBSTR(EMP_NO, 8,1) = '2');
-------------------------------------------------------------------------------

-- 4. 다중행, 다중열 서브쿼리
--    서브쿼리 조회 결과 행 수와 열 수가 여러개 일 때

-- 본인 직급의 평균 급여를 받고 있는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, 급여와 급여 평균은 만원 단위로 계산하세요 TRUNC(컬럼명, -4)

-- 1) 급여를 200, 600만 받는 직원 (200만, 600만이 평균 급여라 생각 할 경우)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2000000, 6000000);

-- 2) 직급별 평균 급여
SELECT JOB_CODE, TRUNC(AVG(SALARY), -4) -- 만원 단위로 끊기
FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 3) 본인 직급의 평균 급여를 받고 있는 직원
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -4) 
                                    FROM EMPLOYEE
                                    GROUP BY JOB_CODE);

-------------------------------------------------------------------------------

-- 5. 상[호연]관 서브쿼리 
-- 원래 서브쿼리부터 해석하는데, 메인쿼리를 1행씩 우선 해석하고, 서브쿼리를 나중에 해석한다.
-- 상관 쿼리는 메인쿼리가 사용하는 테이블 값을 서브쿼리가 이용해서 결과를 만든다.
-- 메인쿼리의 테이블 값이 변경되면 서브쿼리의 결과값도 바뀌게 되는 구조다.

-- 상관쿼리는 먼저 메인쿼리를 한 행을 조회하고
-- 해당 행이 서브쿼리의 조건을 충족하는지 확인하여 SELECT를 진행한다.

-- 직급별 급여 평균보다 급여를 많이 받는 직원의
-- 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE E1
WHERE SALARY/*E1꺼*/ > (SELECT AVG(SALARY)/*E2꺼*/ FROM EMPLOYEE E2 
                        WHERE E1.JOB_CODE = E2.JOB_CODE); -- J1부터 ... J1 = J1, J2= J2, ......
                        
/*
EMPLOYEE 테이블에서 EMP_NAME, JOB_CODE, SALARY 컬럼을 선택합니다.
E1에 EMPLOYEE 테이블을 할당합니다.
E1의 SALARY가, E1과 같은 JOB_CODE를 가진 EMPLOYEE 테이블의 AVG(SALARY)보다 큰 경우를 선택합니다.
INNER SELECT 안쪽 쿼리 구문에서는, E2에 EMPLOYEE 테이블을 할당합니다.
E1과 같은 JOB_CODE를 가진 EMPLOYEE 테이블의 평균 SALARY를 반환합니다.
OUTER SELECT 바깥쪽 쿼리 구문에서는, E1의 EMP_NAME, JOB_CODE, SALARY를 반환합니다.
*/


-- 1) 메인쿼리 1행 해석 
-- 2) 해석된 메인쿼리 1행을 이용해 서브쿼리 조회
-- 3) 서브쿼리 결과를 이용해서 메인쿼리 해석중인 1행을 대상으로 조회

-- 사수가 있는 직원의 사번, 이름, 부서명, 사수사번 조회하기
-- EXISTS : 서브쿼리에 해당하는 행이 1개라도 존재하면 조회결과에 포함한다.

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, MANAGER_ID
FROM EMPLOYEE MAIN
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) -- 했을때 EMP_ID 안에 있는 숫자로만 MANAGER 아이디 찾는다?
--WHERE MANAGER_ID IS NOT NULL; -- 222	이태림	기술지원부	100 <-- 는 존재하지 않음
WHERE EXISTS(SELECT EMP_ID FROM EMPLOYEE SUB
            WHERE SUB.MANAGER_ID = MAIN.EMP_ID ); -- GROUP BY로 풀 수 없음 NOT NULL로 제거가안됨
/*
SELECT EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE E1
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE
                WHERE 'J1'= JOB_CODE); -- 없
                
SELECT EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE E1
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE
                WHERE 'J2'= JOB_CODE);          
                
SELECT EMP_NAME, JOB_CODE, SALARY 
FROM EMPLOYEE E1
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE
                WHERE 'J3'= JOB_CODE);                  
*/

-- 부서별 입사일이 가장 빠른 사원의
-- 사번, 이름, 부서명(NULL 이면 '소속없음'), 직급명, 입사일을 조회하고
-- 입사일이 빠른 순으로 조회하세요.
-- 단, 퇴사한 직원은 제외하고 조회하세요.

SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '소속없음'), JOB_NAME, HIRE_DATE , DEPT_CODE
FROM EMPLOYEE MAIN
LEFT JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)

WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE) FROM EMPLOYEE SUB
                    WHERE MAIN.DEPT_CODE = SUB.DEPT_CODE
                    AND ENT_YN = 'N')
                    ORDER BY HIRE_DATE;

-- 특정 부서 D5 가장 빠른 입사일
SELECT MIN(HIRE_DATE) 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; -- 1994-07-07 00:00:00

--SUB와 MAIN은 상관 서브쿼리를 사용하기 위한 별칭(alias)입니다.

--자체 조회와 상관 서브쿼리는 각각의 상황에 따라 사용하면 됩니다.

--일반적으로 자체 조회는 INNER JOIN을 사용하거나, 복잡한 JOIN 조건이 필요할 때 사용됩니다. 

--반면에 상관 서브쿼리는 하나의 테이블에서 자기 자신과 JOIN할 때 자주 사용됩니다.

--또한, 자체 조회는 레코드 집합을 필터링하고 JOIN하는 것이 주 목적이지만, 

--상관 서브쿼리는 주 쿼리의 조건으로 사용되어 레코드를 필터링하는 것이 주목적입니다.

-- 자체조인은 하나의 테이블에서 데이터를 추출하고, 
-- 상관커리는 여러 테이블에서 데이터를 추출하는데, 서브쿼리를 사용하여 조건에 맞는 레코드를 찾아 출력한다.

-------------------------------------------------------------------------------

-- 6. 스칼라 서브쿼리
--    SELECT절에 사용되는 서브쿼리 결과로 1행(단일행)만 반환한다.
        --> SELECT절에 작성하는 단일행 서브쿼리        
--     SQL에서 단일 값을 '스칼라'라고 함.

SELECT EMP_NAME, SALARY, (SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE) 평균
FROM EMPLOYEE;

-- 각 직원들이 속한 직급의 급여 평균 조회
SELECT EMP_NAME, SALARY, JOB_CODE, (SELECT FLOOR(AVG(SALARY)) FROM EMPLOYEE B
                                     WHERE A.JOB_CODE = B.JOB_CODE) 평균
FROM EMPLOYEE A
ORDER BY JOB_CODE;

-- 모든 사원의 사번, 이름, 관리자사번, 관리자명을 조회
-- 단, 관리자가 없는 경우 '없음'으로 표시
SELECT * FROM EMPLOYEE;
SELECT EMP_ID, EMP_NAME, NVL(MANAGER_ID, '없음') AS 관리자사번, 
NVL((SELECT EMP_NAME FROM EMPLOYEE B WHERE A.MANAGER_ID = B.EMP_ID), '없음') AS 관리자이름
FROM EMPLOYEE A;

-------------------------------------------------------------------------------

-- 7. 인라인 뷰(INLINE-VIEW)
--      FROM 절에서 서브쿼리를 사용하는 경우로
--      서브쿼리가 만든 결과의 집합(RESULT SET)을 테이블 대신에 사용한다.

-- 인라인 뷰를 활용한 TOP-N분석
-- 전 직원 중 급여가 높은 상위 5명의
-- 순위, 이름, 급여 조회

-- 1. 급여 높은 순서로 조회
SELECT EMP_NAME, SALARY 
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 2. 조회되는 행 앞에 1부터 순서대로 1씩 증가하는 번호 붙이기
-- ROWNUM : 행 번호를 나타내는 가상의 컬럼(1부터 1씩 증가한다)
SELECT ROWNUM, EMP_NAME 
FROM EMPLOYEE;

-- 3. ROWNUM을 조건에 사용하기
SELECT ROWNUM, EMP_NAME
FROM EMPLOYEE
WHERE ROWNUM <= 5;

-- 4. 1,2,3번을 토대로 급여 상위 5명 조회 시도
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
--> SELECT 해석 순서를 고려하지 않아서 제대로 조회되지 않는다.
--> 이 문제를 해결하기 위해서는 [인라인 뷰]가 필요하다.

-- 해결 1) 급여 내림차순 조회
SELECT EMP_NAME, SALARY 
FROM EMPLOYEE
ORDER BY SALARY DESC;
--> 해결 1의 조회 결과 RESULT SET 을 가상의 테이블(==VIEW)로 취급할 예정

--> 해결 2) 해결 1의 조화결과를 FROM절에 사용한 후
--          상위 5행만 조회하기

SELECT ROWNUM, EMP_NAME, SALARY FROM 
                                    (SELECT EMP_NAME, SALARY 
                                     FROM EMPLOYEE
                                     ORDER BY SALARY DESC ) -- FROM절 내부에 포함된 가상의 테이블 == 인라인 뷰
WHERE ROWNUM <= 5;

--급여 평균이 3위안에 드는 부서의 부서코드와 부서명, 평균급여를 조회하겠다.

SELECT /*ROWNUM,*/ DEPT_CODE, DEPT_TITLE , 평균급여 -- FLOOR(AVG(SALARY)) 사용 불가능
FROM (SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) 평균급여 FROM EMPLOYEE
        LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
        GROUP BY DEPT_CODE, DEPT_TITLE
        ORDER BY 3 DESC) -- 인라인 뷰
WHERE ROWNUM <= 6;      

-------------------------------------------------------------------------------

--8. WITH 
--        서브쿼리에 이름을 붙여주고 사용 시 이름을 사용하게 함
--        인라인뷰로 사용될 서브쿼리에 주로 사용됨
--        실행 속도도 빨라진다는 장점이 있다.

-- 전 직원의 급여 순위
-- 순위, 이름, 급여 조회
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY 
        FROM EMPLOYEE
        ORDER BY SALARY DESC); -- 를 함수로 만든다?는 느낌
        
-- TOP_SAL 라는 이름의 서브쿼리를 미리 생성
WITH TOP_SAL AS ( SELECT EMP_NAME, SALARY 
        FROM EMPLOYEE
        ORDER BY SALARY DESC )
       
SELECT ROWNUM, EMP_NAME, SALARY
FROM TOP_SAL;
        
-------------------------------------------------------------------------------

-- 9. RANK() OVER 1등2등2등4등 / DENSE_RANK() OVER 1등2등2등3등

-- RANK() OVER : 동일한 순위 이후의 등수를 동일한 인원 수 만큼 건너뛰고 순위를 계산한다.
--               EX) 공동 1위가 2명이면 다음 순위는 2위가 아니라 3위가 된다.

SELECT RANK() OVER(ORDER BY SALARY DESC) AS 순위, EMP_NAME, SALARY FROM EMPLOYEE;
-- 인라인 뷰 안해도 간편하게 순위가 만들어지는 모습

-- DENSE_RANK() OVER : 동일한 순위의 등수를 이후의 순위로 계산한다.
--                     EX) 공동 1위가 2명이여도 다음 순위는 2위

SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위, EMP_NAME, SALARY FROM EMPLOYEE;








