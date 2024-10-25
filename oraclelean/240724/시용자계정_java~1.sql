select * from dbtest;
delete dbtest;

update dbtest set age=age+1 where name like '%코%'; -- lock 걸림

commit;




