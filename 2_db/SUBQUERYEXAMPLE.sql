SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

--1
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연')
AND EMP_NAME NOT IN '전지연';

--2 

SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE WHERE SUBSTR(HIRE_DATE,1,4) > '2000');

--3

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE JOIN JOB USING (JOB_CODE) WHERE EMP_NAME = '노옹철')
AND EMP_NAME != '노옹철';

--4
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SUBSTR(HIRE_DATE, 1, 10) HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) IN (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE SUBSTR(HIRE_DATE,1,4) = '2000');

--5
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID, EMP_NO, HIRE_DATE
FROM EMPLOYEE
WHERE(DEPT_CODE, MANAGER_ID) IN 
(SELECT DEPT_CODE, MANAGER_ID FROM EMPLOYEE WHERE SUBSTR(EMP_NO,1,2) = '77' AND SUBSTR(EMP_NO,8,1) ='2');

--6
SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '소속없음'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE) FROM EMPLOYEE WHERE ENT_YN = 'N' GROUP BY DEPT_CODE)
ORDER BY HIRE_DATE;

SELECT MIN(HIRE_DATE) FROM EMPLOYEE WHERE ENT_YN = 'N';
SELECT MIN(HIRE_DATE) FROM EMPLOYEE WHERE ENT_YN = 'N' GROUP BY DEPT_CODE;

--7
SELECT EMP_ID, EMP_NAME, JOB_CODE, FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) "만 나이",
TO_CHAR(SALARY * (1 + NVL(BONUS, 0)) * 12, 'L999,999,999') "보너스포함연봉"
FROM EMPLOYEE A
ORDER BY 4 DESC;

SELECT EMP_ID, EMP_NAME, A.JOB_CODE, FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) "만 나이",
TO_CHAR(SALARY * (1 + NVL(BONUS, 0)) * 12, 'L999,999,999') "보너스포함연봉"
FROM EMPLOYEE A
JOIN JOB J ON (A.JOB_CODE = J.JOB_CODE)
WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12) = 
(SELECT MIN(FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6), 'RRMMDD')) / 12)) FROM EMPLOYEE B WHERE A.JOB_CODE = B.JOB_CODE)
ORDER BY 4 DESC;

SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;