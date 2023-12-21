-- 문제1. 
-- 평균 급여보다 적은 급여을 받는 직원은 몇 명이나 있습니까? 
-- //56명  평균: 6461.83
SELECT COUNT(*)
FROM employees
WHERE salary < (
    SELECT AVG(salary)
    FROM employees
);


-- 문제2.
-- 각  부서별로  최고의  급여를  받는  사원의  직원번호(employee_id),  성(last_name)과  급여
-- (salary),  부서번호(department_id)를  조회하세요.  단 조회결과는 급여의 내림차순으로 정렬
-- 되어 나타나야 합니다.  
-- //11명   
select e.EMPLOYEE_ID, e.LAST_NAME, e.SALARY, e.DEPARTMENT_ID
from EMPLOYEES e
order by salary DESC;

-- 각 부서별로 최고의 급여를 받는 사원을 찾는 쿼리
select DEPARTMENT_ID, max(SALARY)
from EMPLOYEES
group by DEPARTMENT_ID;

-- 두개의 쿼리 통합
select e.EMPLOYEE_ID, e.LAST_NAME, e.SALARY, e.DEPARTMENT_ID
from EMPLOYEES e
where (DEPARTMENT_ID, SALARY) IN (
    select DEPARTMENT_ID, max(SALARY)
    from EMPLOYEES
    group by DEPARTMENT_ID
)
order by salary DESC;


-- 문제3. 
-- 각 업무(job) 별로 급여(salary)의 총합을 구하고자 합니다. 급여 총합이 가장 높은 업무부터 
-- 업무명(job_title)과 급여 총합을 조회하시오  
-- //19 직급 
select JOB_TITLE, sum(salary) 
from EMPLOYEES
JOIN JOBS j ON EMPLOYEES.JOB_ID = j.JOB_ID
group by JOB_TITLE
order by sum(salary) desc;

-- 문제4. 
-- 자신의  부서  평균  급여보다  급여(salary)가  많은  직원의  직원번호(employee_id),  성(last_name)
-- 과  급여(salary)을  조회하세요   
-- //38명
select e.EMPLOYEE_ID, e.LAST_NAME
from EMPLOYEES e
where SALARY > (
    select AVG(SALARY)
    from EMPLOYEES
    where DEPARTMENT_ID = e.department_id
);
