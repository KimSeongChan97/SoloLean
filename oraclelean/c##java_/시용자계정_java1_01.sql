create synonym hr_emp for hr.employees;

select * from user_synonyms;

select * from hr.employees;

select * from hr_emp;

drop synonym hr_emp;

create synonym hr_dep for hr.departments;

select * from user_synonyms;

