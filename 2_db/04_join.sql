/* 
[JOIN 용어 정리]
  오라클                                               SQL : 1999표준(ANSI)
----------------------------------------------------------------------------------------------------------------
등가 조인                                  내부 조인(INNER JOIN), JOIN USING / ON
                                            + 자연 조인(NATURAL JOIN, 등가 조인 방법 중 하나)
----------------------------------------------------------------------------------------------------------------
포괄 조인                               왼쪽 외부 조인(LEFT OUTER), 오른쪽 외부 조인(RIGHT OUTER)
                                            + 전체 외부 조인(FULL OUTER, 오라클 구문으로는 사용 못함)
----------------------------------------------------------------------------------------------------------------
자체 조인, 비등가 조인                          JOIN ON
----------------------------------------------------------------------------------------------------------------
카테시안(카티션) 곱                     교차 조인(CROSS JOIN)
CARTESIAN PRODUCT

- 미국 국립 표준 협회(American National Standards Institute, ANSI) 미국의 산업 표준을 제정하는 민간단체.
- 국제표준화기구 ISO에 가입되어 있음.
*/
-----------------------------------------------------------------------------------------------------------------------------

-- JOIN
-- 하나 이상의 테이블에서 데이터를 조회하기 위해 사용한다.
-- 수행 결과는 하나의 RESULT SET으로 나온다. 테이블 두개를 이어 붙인다??

/* 관계형 데이터베이스에서 SQL을 이용해 테이블 간 '관계'를 맺는 방법 

- 관계형 데이터베이스는 최소한의 데이터를 테이블에 담고 있어서 
  원하는 정보를 테이블에서 조회하려면 한 개 이상의 테이블에서
  데이터를 읽어와야 하는 경우가 많다.
  이 때, 테이블간 관계를 맺기위한 연결고리 역할이 필요한데,
  두 테이블에서 같은 데이터를 저장하는 컬럼이 연결고리가 된다. 
*/

-------------------------------------------------------------------------------

-- 직원 번호, 직원명, 부서코드 EMPLOYEE 테이블
-- 부서명 (DEPARTMENT) 조회하고자 할 때
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;
SELECT DEPT_ID, DEPT_TITLE 
FROM DEPARTMENT;
-- 기존에 서로 다른 테이블의 데이터를 조회할 경우 원래 이렇게 따로따로 했다.

SELECT EMP_ID, EMP_NAME, DEPT_CODE/*DEPT_ID도 가능*/, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- EMPLOYEE 테이블과 DEPARTMENT 테이블을 연결할 때
-- DEPT_CODE 컬럼과 DEPT_ID 컬럼이 같은 값을 가지고 있으므로
-- 해당 컬럼들을 기준으로 연결한다.


-- 1. 내부 조인(INNER JOIN) (== 등가 조인(EQUAL JOIN))
--> 연결되는 컬럼의 값이 일치하는 행들만 조인된다. (== 일치하는 값이 없는 행은 조인에서 제외된다.

-- 작성 방법 크게 ANSI 구문과 오라클 구문으로 나뉘고
-- ANSI에서 USING과 ON을 쓰는 방법으로 나뉜다.

-- * ANSI 표준 구문
-- ANSI는 미국 국립 표준 협회를 뜻한다. 
-- 미국의 산업 표준을 재정하는 민간단체로 국제표준화기구 ISO에 가입되어있다.
-- ANSI에서 제정한 표준을 ANSI라고 하고
-- 여기서 제정한 표준 중 가장 유명한 것이 ASCII코드이다.

-- * 오라클 전용 구문
-- FROM절에 쉼표(,)로 구분하여 합치게 될 테이블명을 기술하고
-- WHERE절에 합치기에 사용할 컬럼명을 명시한다.

--1) 연결에 사용할 두 컬럼명이 다른 경우
-- EMPLOYEE 테이블, DEPARTMENT 테이블을 참조하여
-- 사번,이름,부서코드,부서명 조회
-- EMPLOYEE 테이블에 DEPT_CODE 컬럼과 DEPARTMENT 테이블에 DEPT_ID 컬럼은
-- 서로 같은 부서 코드를 나타낸다.
--> 이를 통해 두 테이블이 관계가 있음을 알고 조인을 통해 데이터 추출이 가능하다.

-- ANSI
-- 연결에 사용할 컬럼명이 다른 경우 ON()을 사용
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID); -- 위에서 했던 거

-- ORACLE
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT -- FROM절에 사용할 테이블을 모두 작성해버리기
WHERE DEPT_CODE = DEPT_ID; -- WHERE절에 같은 값을 가지고 있는 컬럼을 작성
-- = 을 쓰기 때문에 EQUAL 조인이라고도 한다.

-- DEPARTMENT 테이블, LOCATION 테이블을 참조하여
-- 부서명, 지역명 조회
SELECT * FROM LOCATION; -- LOCAL_CODE   // NATIONAL_CODE
SELECT * FROM DEPARTMENT; -- LOCAION_ID

-- ANSI
SELECT LOCATION_ID/*LOCAL_CODE 가능*/, NATIONAL_CODE
FROM DEPARTMENT/*LOCATION 가능, 쓰면 JOING DEPARTMENT로 바꾸면 댐*/
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);

--ORACLE
SELECT LOCATION_ID/*LOCAL_CODE 가능*/, NATIONAL_CODE
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

-- 2) 연결에 사용할 두 컬럼명이 같은 경우
-- EMPLOYEE, JOB 참조
-- 사번,이름 직급코드, 직급명 조회
SELECT * FROM JOB; -- JOB_CODE, JOB_NAME
SELECT * FROM EMPLOYEE; -- JOB_CODE 가 같다.

-- ANSI
-- 연결에 사용할 컬럼명이 같은 경우 USING(컬럼명을 사용한다.) // ON 자리에 -> USING
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

--ORACLE
-- 별칭을 사용한다. 테이블 별로 별칭을 등록할 수 있음
SELECT EMP_ID, EMP_NAME, E.JOB_CODE/*E.을 하거나 J.을 해도 상관없는데 아무것도 안써주면 열의 정의가 애매합니다 나옴.*/ --JOB_NAME
FROM EMPLOYEE E, JOB J -- 별칭 이런식으로 생성해준다.
WHERE E.JOB_CODE = J.JOB_CODE; -- 열의 정의가 애매합니다. 어디 테이블의 JOB_CODE인지 모른다.

/*** 내부 조인의 문제점 ***/
-- 연결에 사용되는 컬럼의 값이 NULL 이면 조회 결과에 포함되지 않는다.

-------------------------------------------------------------------------------

-- 2. 외부 조인(OUTER JOIN)

-- 두 테이블의 지정하는 "컬럼값이 일치하지 않는 행도 조인에 포함"을 시킨다.
-- 반드시 OUTER JOIN임을 명시해야 한다.

-- OUTER JOIN과 비교할 INNER JOIN 쿼리문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
/*INNER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 그냥 JOIN을 쓰면 그게 INNER 조인이다!!!

-- LEFT [OUTER] JOIN : 합치기에 사용한 두 테이블 중 왼편에 기술된 테이블의
--                     컬럼 수를 기준으로 JOIN한다.

-- ANSI 표준
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID); -- DEPT_TITLE의 NULL인 사람들이 나오는 모습
--> JOIN 구문 기준으로 왼쪽에 작성된 테이블의 모든 행이 결과(RESULT SET)에 포함된다.

-- 오라클 구문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- (+)만 추가하면 NULL인 사람들 나옴 
-- 왼쪽 오른쪽 테이블에 같은 값 없으면 오른쪽에 있는 테이블에서 억지로 추가(NULL)해주겠다는 뜻

-- 2) RIGHT [OUTER] JOIN : 합치기에 사용한 두 테이블 중 오른쪽에 기술된 테이블의 
--                         오른편에 기술된 테이블의 컬럼수를 기준으로 JOIN한다. 

-- ANSI 
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
RIGHT OUTER JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID); -- 오른쪽 기준으로 해서 왼쪽테이블 NAME이 NULL로나옴

-- ORACLE
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- 3) FULL [OUTER] JOIN : 합치기에 사용한 두테이블이 가진 모든 행을 결과에 포함시키겠다.
-- ORACLE 구문은 FULL [OUTER] JOIN 사용 불가능

-- ANSI
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
FULL OUTER JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- ORACLE로 해보기
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+); -- outer-join된 테이블은 1개만 지정할 수 있습니다. 
-- ORACLE구문은 FULL OUTER JOIN이 안되는 모습

-------------------------------------------------------------------------------

-- 3. 교차 조인(CROSS JOIN == CARTESIAN PRODUCT) -- 잘안씀. 모든 경우의 수를 출력한다고 생각
-- 조인되는 테이블의 각 행들이 모두 매핑된 데이터가 검색되는 방법(곱집합)

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
CROSS JOIN DEPARTMENT; 

------------------------------------------------------------------------------

--4. 비등가 조인(NON EQUAL JOIN) -- 얘도 잘 안씀

-- '='(등호)를 사용하지 않는 조인문
-- 지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식 
SELECT EMP_NAME, SALARY, E.SAL_LEVEL, S.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON(SALARY BETWEEN MIN_SAL AND MAX_SAL); -- 얻어온 값이 MIN SAL과 MAX SAL 안에 있으면..?

------------------------------------------------------------------------------

-- 5. 자체 조인(SELF JOIN)

-- 같은 테이블을 조인
-- 자기 자신과 조인을 맺음
--> 똑같은 테이블 두 개가 조인

-- 사번, 이름, 사수 번호, 사수 이름 조회
SELECT * FROM EMPLOYEE; -- MANAGER_ID, 사수 이름은 없음

--ANSI 표준
SELECT E.EMP_ID, E.EMP_NAME, NVL(E.MANAGER_ID, '없음'), NVL(M.EMP_NAME, '없음')
FROM EMPLOYEE E
LEFT OUTER JOIN EMPLOYEE M ON(E.MANAGER_ID = M.EMP_ID); 
-- INNER JOIN 하면 NULL인 애들의 행 자체가 다 사라져버림

--ORACLE 구문
SELECT E.EMP_ID, E.EMP_NAME, NVL(E.MANAGER_ID, '없음'), NVL(M.EMP_ID, '없음')
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID(+); -- ANSI랑 순서 왜 다름? + 왜 안쓰는지? 모르겟음

------------------------------------------------------------------------------

-- 6. 자연 조인(NATURAL JOIN)
-- 동일한 타입과 이름을 가진 컬럼이 있는 테이블 간의 조인을 간단히 표현하는 방법
-- 반드시 두 테이블 간의 동일한 컬럼명, 타입을 가진 컬럼이 필요
-- 없을 경우, 교차조인이 됨 // USING 안쓰고 자연스럽게 조인하겠다.

SELECT EMP_NAME, JOB_NAME
FROM EMPLOYEE
--JOIN JOB USING(JOB_CODE); 가 원래 했던 것
NATURAL JOIN JOB; -- 내가 JOB_CODE가 겹치는 걸 아니까 그냥 이렇게 써도 조인된다는 것.

------------------------------------------------------------------------------

-- 7. 다중 조인
-- N개의 테이블을 조회할 때 사용한다. (순서 중요)
-- ** JOIN인 순서대로 하나씩 진행된다. ** 

-- EMPLOYEE, DEPARTMENT, LOCATION 조인

-- ANSI 표준
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) -- 이게 뒤로가면 "부적합한 식별자" 오류남. 순서 잘 지켜야 한다.
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE);
-- (EMPLOYEE + DEPARTMENT) 후 JOIN LOCATION 한다.

-- ORACLE 구문
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID -- EMPLOYEE와 DEPARTMENT 조인시킴
AND LOCATION_ID = LOCAL_CODE; -- (EMPLOYEE + DEPARTMENT) 에서 LOCATION에 조인시킴

-- 다중 조인 연습 문제
-- 직급이 대리이면서 아시아 지역에 근무하는 직원을 조회해라
-- 사번, 이름, 직급명, 부서명, 근무지역명, 급여를 조회하세요.

--ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE JOB_NAME = '대리' AND LOCAL_NAME LIKE 'ASIA%';


--ORACLE
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E, JOB B, DEPARTMENT, LOCATION
WHERE E.JOB_CODE = B.JOB_CODE -- 안 쓰면 안댐
AND DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE
AND JOB_NAME = '대리' AND LOCAL_NAME LIKE 'ASIA%';

------------------------------------------------------------------------------
--숙제-- 전부 다 ANSI 구문으로 풀어오기

-- 1. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 '전'씨인 직원들의 
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오.
--ANSI
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME 
FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
--NATURAL JOIN JOB
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE SUBSTR(EMP_NO, 1, 1) = '7' AND SUBSTR(EMP_NO, 8, 1) = '2' AND EMP_NAME LIKE '전%';

-- ORACLE
SELECT EMP_NAME, EMP_NO, DEPT_TITLE, JOB_NAME 
FROM EMPLOYEE A, JOB B, DEPARTMENT
WHERE A.JOB_CODE = B.JOB_CODE 
AND DEPT_CODE = DEPT_ID
AND SUBSTR(EMP_NO, 1, 1) = '7' AND SUBSTR(EMP_NO, 8, 1) = '2' AND EMP_NAME LIKE '전%';

-- 2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
--ANSI
SELECT EMP_ID, EMP_NAME, DEPT_TITLE 
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE EMP_NAME LIKE '%형%';

--ORACLE
SELECT EMP_ID, EMP_NAME, DEPT_TITLE 
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
AND EMP_NAME LIKE '%형%';

-- 3. 해외영업 1부, 2부에 근무하는 사원의 
-- 사원명, 직급명, 부서코드, 부서명을 조회하시오.
--ANSI
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE IN ('해외영업1부', '해외영업2부');

--ORCALE
SELECT EMP_NAME, JOB_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE A, JOB B, DEPARTMENT
WHERE A.JOB_CODE = B.JOB_CODE
AND DEPT_CODE = DEPT_ID
AND DEPT_TITLE IN ('해외영업1부', '해외영업2부');

--4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.

--ANSI
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME 
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
LEFT JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
WHERE BONUS IS NOT NULL;

--ORACLE
SELECT EMP_NAME, BONUS, DEPT_TITLE, LOCAL_NAME 
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID(+)
AND LOCATION_ID = LOCAL_CODE(+)
AND BONUS IS NOT NULL;

--5. 부서가 있는 사원의 사원명, 직급명, 부서명, 지역명 조회
--ANSI
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE); --INNER -> NULL 제외

--ORACLE
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE A, JOB B, DEPARTMENT, LOCATION
WHERE A.JOB_CODE = B.JOB_CODE
AND DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE;

-- 6. 급여등급별 최소급여(MIN_SAL)를 초과해서 받는 직원들의
--사원명, 직급명, 급여, 연봉(보너스포함)을 조회하시오.
--연봉에 보너스포인트를 적용하시오.
SELECT * FROM SAL_GRADE;
--ANSI
SELECT EMP_NAME, JOB_NAME, SALARY, ( (SALARY + (SALARY * NVL (BONUS,0) ) ) * 12) /*SARALY * 1+NVL(BONUS,0) * 12 */ AS 연봉
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN SAL_GRADE USING(SAL_LEVEL)
WHERE SALARY > MIN_SAL;

--ORACLE
SELECT EMP_NAME, JOB_NAME, SALARY, SALARY * (1+NVL(BONUS,0)) * 12  AS 연봉
FROM EMPLOYEE A, JOB B, SAL_GRADE C
WHERE A.JOB_CODE = B.JOB_CODE
AND A.SAL_LEVEL = C.SAL_LEVEL
AND SALARY > MIN_SAL;

-- 7.한국(KO)과 일본(JP)에 근무하는 직원들의 
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.
SELECT * FROM NATIONAL; -- NATIONAL_CODE
SELECT * FROM LOCATION; -- NATIONAL_CODE

--ANSI
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME AS 지역명, NATIONAL_NAME AS 국가명
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
WHERE NATIONAL_NAME IN('한국', '일본');

--ORACLE
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME AS 지역명, NATIONAL_NAME AS 국가명
FROM EMPLOYEE, DEPARTMENT, LOCATION A, NATIONAL B
WHERE DEPT_CODE = DEPT_ID
AND LOCATION_ID = LOCAL_CODE
AND A.NATIONAL_CODE = B.NATIONAL_CODE
AND NATIONAL_NAME IN('한국', '일본');   


-- 8. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- SELF JOIN 사용

--ANSI
SELECT A.EMP_NAME AS 사원명, A.DEPT_CODE AS 부서코드, B.EMP_NAME AS 동료이름
FROM EMPLOYEE A
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN EMPLOYEE B ON(A.DEPT_CODE = B.DEPT_CODE/*부서코드가 같으면서*/) -- AND A.EMP_NAME != B.EMP_NAME/*동료이름에 내이름 안들어가게*/ )로도 가능
WHERE A.EMP_NAME != B.EMP_NAME
ORDER BY 사원명;

--ORACLE
SELECT A.EMP_NAME AS 사원명, A.DEPT_CODE AS 부서코드, B.EMP_NAME AS 동료이름
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.DEPT_CODE = B.DEPT_CODE
AND A.EMP_NAME != B.EMP_NAME
ORDER BY 사원명;
-- 9. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, JOIN, IN 사용할 것

--ANSI
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE BONUS IS NULL
AND JOB_CODE IN ('J4', 'J7');

--ORACLE
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE A, JOB B
WHERE A.JOB_CODE = B.JOB_CODE
AND BONUS IS NULL
AND A.JOB_CODE IN ('J4', 'J7');