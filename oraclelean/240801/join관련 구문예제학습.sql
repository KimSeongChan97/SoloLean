select * from departments;
select * from employees;


-- inner join : 같은 것끼리만 조인
-- 사원테이블과 부서테이블에서 부서가 같을 경우 사원번호, 부서번호, 부서이름을 출력하시오
select   employee_id,
employees.department_id, 
department_name
from employees, departments
where employees.department_id = departments.department_id; -- oracle

select   employee_id,
e.department_id, 
department_name
from employees e, departments d 
where e.department_id = d.department_id; --축약

select employee_id, department_id, department_name 
from employees 
join departments using(department_id); -- ansi 표준

-- 부서테이블(DEPARTMENTS d)과 위치테이블(LOCATIONS l)을 연결하여 부서가 
-- 위치한 도시를 알아내시오
select * from departments;
select * from locations;
select d.department_id, -- department의 부서 id
        l.city -- locations 의 도시이름
from departments d -- departments 의 별칭
join locations l -- locations 의 별칭
-- DEPARTMENTS 테이블과 LOCATIONS 테이블의 location_id를 기준으로 조인
on d.location_id = l.location_id;

select department_id, city
from departments
join locations using(location_id);








