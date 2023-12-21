--[Q1] 사원중 IT_PROG 라는 직급으로 근문하는 직원의 사번, 이름, 입사일, 급여 를 조회 하시오
SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.HIRE_DATE, e.SALARY  
FROM EMPLOYEES e
WHERE 'IT_PROG' = e.JOB_ID;

--[Q2] 부서별 급여의 합계를 합계금액의 내림차순으로 조회 하시오
SELECT DEPARTMENT_ID, SUM(SALARY) AS total_salary
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY total_salary DESC ;

--[Q3] 모든 사원의  이름과 매니저의 이름을 조회 하시오( 매니저가 없는 사람도 조회 되도록 하시오)
SELECT e.first_name, m.FIRST_NAME 
FROM EMPLOYEES e
LEFT JOIN EMPLOYEES m ON e.MANAGER_ID = m.EMPLOYEE_ID ;

