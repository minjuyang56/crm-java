-- 문제1. 
-- 가장 늦게 입사한 직원의 이름(first_name last_name)과 급여(salary)과 근무하는 부서 이
-- 름(department_name)은? 
 
select e.first_name||' '||e.last_name as "이름", 
       e.salary as "급여", 
       d.department_name as "부서이름", 
       e.hire_date 
from employees e , departments d 
where e.department_id = d.department_id  
and e.hire_date = (select max(hire_date) 
                     from employees) ; 

 
-- 문제2. 
-- 평균급여(salary)가 가장 높은 부서 직원들의 직원번호(employee_id), 이름(firt_name), 성
-- (last_name)과  업무(job_title), 급여(salary)를 조회하시오.
select a.employee_id as "사번", 
       a.first_name as "이름", 
  a.last_name as "성", 
  a.salary as "급여", 
       b.avg_salary, 
       j.job_title 
  from employees a, 
       (select department_id,  
               avg(salary) as avg_salary 
        from employees 
        group by department_id ) b, 
        jobs j 
 where a.department_id = b.department_id 
   and b.avg_salary = (select max( avg(salary) ) 
                       from employees 
                       group by department_id) 
   and a.job_id = j.job_id; 
 
 
 
-- 문제3. 
-- 평균 급여(salary)가 가장 높은 부서는?  
select d.department_name, a.avg_salary 
from departments d, 
     (select avg(salary) avg_salary, department_id 
      from employees 
      group by department_id) a 
where d.department_id = a.department_id       
and a.avg_salary = (select max(avg(salary)) max_salary 
                   from employees 
                   group by department_id); 
 
 
 
 
SELECT department_name 
  FROM departments 
 WHERE department_id = (  SELECT department_id 
                            FROM employees 
                        GROUP BY department_id 
                      HAVING AVG (salary) = (SELECT MAX (AVG (salary)) 
                                               FROM employees 
                                           GROUP BY department_id)); 

 
 
-- 문제4. 
-- 평균 급여(salary)가 가장 높은 지역은?  
select region_name 
from regions 
where region_id =  (select r.region_id 
                    from employees e, 
                         departments d, 
                         locations l, 
                         countries c, 
                         regions r 
                    where e.department_id = d.department_id 
                    and   d.location_id = l.location_id 
                    and   l.country_id = c.country_id 
                    and   c.region_id = r.region_id 
                    group by r.region_id 
                    having avg(salary) = (select max(avg(salary)) 
                                          from employees e, 
                                               departments d, 
                                               locations l, 
                                               countries c, 
                                               regions r 
                                          where e.department_id = d.department_id 
                                          and   d.location_id = l.location_id 
                                          and   l.country_id = c.country_id 
                                          and   c.region_id = r.region_id 
                                          group by r.region_id)); 
 

-- 문제5. 
-- 평균 급여(salary)가 가장 높은 업무는?  
select job_title 
from jobs 
where job_id = (select job_id 
                from employees 
                group by job_id 
                having avg(salary) = (select max(avg(salary)) 
                                      from employees 
                                      group by job_id));