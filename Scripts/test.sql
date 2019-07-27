show tables;

desc coupon;
desc food;
desc foodkind;
desc grade;
desc manager;
desc member;
desc menu;
desc post;
desc sale;

select f.name, f.price, fk.name from food f join foodkind fk on f.fk_no = fk.fk_no;

select * from food;

desc food;

select f.name, f.price, fk.fk_no
		from food f
		join foodkind fk
		on f.fk_no = fk.fk_no
		
truncate sale;

insert into sale values (1,1,now(),1,1,0,1,1);
insert into sale values (2,1,now(),3,1,0,1,1);
insert into sale values (3,1,now(),4,1,0,2,1);
insert into sale values (4,1,now(),5,1,0,2,1);
insert into sale values (5,1,now(),2,1,0,2,1);
insert into sale values (6,1,now(),1,1,0,3,1);
insert into sale values (7,1,now(),3,1,0,4,1);

select ssName, ssCount, ssTotalPrice, ssShare from stateFood;

select * from sale;

select no,sale_no,sale_time,order_cnt,order_kind,sale_type,f.name, m.name
from sale s left join food f on s.fd_no = f.fd_no join member as m on s.mb_no = m.mb_no;

select no,sale_no, sale_time, order_cnt, order_kind, sale_type, mb_no, fd_no from sale;
 		
select sale_time from sale where sale_time like "2019-07-26%";

select no,sale_no,sale_time,order_cnt,order_kind,sale_type,f.name, m.name from sale s left join food f on s.fd_no = f.fd_no join member as m on s.mb_no = m.mb_no where sale_time like "2019-07-26%";
	
select f.name as name, sum(order_cnt) as count, sum(order_cnt*f.price) as ssTotalPrice
from sale s left join food f on s.fd_no = f.fd_no 
group by s.fd_no
order by ssTotalPrice desc;

select * from manager;
select * from member;
set foreign_key_checks = 1;
truncate table member;

delete from member where mb_no = 3;

select mb_no, mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address from member;