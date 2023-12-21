-- 문제 1.  
-- 각  사원(employee)에  대해서  사번(employee_id),  이름(first_name),  부서명
-- (department_name), 매니저(manager)의 이름(first_name)을 조회하세요. 
-- // 105명  
select e.EMPLOYEE_ID, e.FIRST_NAME, d.DEPARTMENT_NAME, m.FIRST_NAME MANAGER
from EMPLOYEES e
join DEPARTMENTS d on E.DEPARTMENT_ID = d.DEPARTMENT_ID 
join EMPLOYEES m on e.MANAGER_ID = m.EMPLOYEE_ID;
 
 
-- 문제2. 
-- 지역(regions)에 속한 나라들을 지역이름(region_name), 나라이름(country_name)으로 출력
-- 하되 지역이름, 나라이름 순서대로 내림차순으로 정렬하세요. 
-- //25개국 
select r.REGION_NAME, c .country_name
from countries c
join REGIONS r ON r.REGION_ID = c.region_id
order by R.REGION_NAME desc, c.country_name desc; 
 
 
-- 문제3. 
-- 각 부서(department)에 대해서 부서번호(department_id), 부서이름(department_name), 매
-- 니저(manager)의 이름(first_name), 위치(locations)한 도시(city), 나라(countries)의 이
-- 름(countries_name) 그리고 지역구분(regions)의 이름(region_name)까지 전부 출력해 보세
-- 요. 
-- //11개 
select d.DEPARTMENT_ID, d.DEPARTMENT_NAME, m.FIRST_NAME, l.CITY, c.country_name, r.region_name
from DEPARTMENTS d
join EMPLOYEES m on d.MANAGER_ID = m.EMPLOYEE_ID
join LOCATIONS l on l.LOCATION_ID = d.LOCATION_ID
join COUNTRIES c on c.COUNTRY_ID = l.COUNTRY_ID
join REGIONS r on r.REGION_ID = c.REGION_ID;

 
-- 문제4. 어려움..
-- ‘Public Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. 
-- (현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사
-- 원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력합니다. 
-- //2명 
SELECT e.employee_id, e.first_name || ' ' || e.last_name AS full_name
FROM employees e
JOIN job_history jh ON e.employee_id = jh.employee_id
JOIN jobs j ON jh.job_id = j.job_id
WHERE j.job_title = 'Public Accountant'
AND e.employee_id NOT IN (
    SELECT employee_id
    FROM job_history
    WHERE end_date IS NULL
);
 
 
-- 문제5. 
-- 직원들의 사번(employee_id),  이름(first_name),  성(last_name)과  부서  이름
-- (department_name)을 조회하여 성(last_name)순서로 오름차순 정렬하세요 
-- //106 명  (+  부서가 없는 사람도 조회 되도록.. 107명) 
SELECT e.employee_id, e.first_name, e.last_name, NVL(d.department_name, 'No Department') AS department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
ORDER BY e.last_name ASC;

 
 
 
 
-- 문제6. 
-- 자신의  매니저보다  채용일(hire_date)이  빠른  사원의  사번(employee_id), 성(last_name)과  채용
-- 일(hire_date)을  조회하세요   
-- // 37  명 
SELECT e.employee_id, e.last_name, e.hire_date
FROM employees e
WHERE e.hire_date < (
    SELECT m.hire_date
    FROM employees m
    WHERE e.manager_id = m.employee_id
);
