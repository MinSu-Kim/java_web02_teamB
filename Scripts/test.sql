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

select * from `member`;
select * from grade;

insert into sale values (1,1,now(),1,1,0,1,1);
insert into sale values (2,1,now(),3,1,0,1,1);
insert into sale values (3,1,now(),4,1,0,2,1);
insert into sale values (4,1,now(),5,1,0,2,1);
insert into sale values (5,1,now(),2,1,0,2,1);
insert into sale values (6,1,now(),1,1,0,3,1);
insert into sale values (7,1,now(),3,1,0,4,1);

insert into sale values (8,2,now(),1,1,0,1,1);
insert into sale values (9,2,now(),3,1,0,1,1);
insert into sale values (10,2,now(),4,1,0,2,1);
insert into sale values (11,3,now(),5,1,0,2,1);
insert into sale values (12,3,now(),2,1,0,2,1);
insert into sale values (13,3,now(),1,1,0,3,1);
insert into sale values (14,3,now(),3,1,0,4,1);

insert into sale values (15,4,now(),3,1,0,32,1);
insert into sale values (16,5,now(),5,1,0,14,1);
insert into sale values (17,5,now(),2,1,0,42,2);
insert into sale values (18,6,now(),1,1,0,32,2);
insert into sale values (19,6,now(),1,1,0,33,2);
insert into sale values (20,6,now(),1,1,0,13,2);

select ssName, ssCount, ssTotalPrice, ssShare from stateFood;



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
create view payment as
select s.sale_no as payNo , s.sale_time as payTime, group_concat(f.fd_name) as payMenu ,sum(f.fd_price) as payPrice,s.sale_type as payType ,m.mb_name as payMemeber from sale s join food f on s.fd_no=f.fd_no  join member m on s.mb_no = m.mb_no group by s.sale_no;

select payNo,payTime,payMenu,payPrice,payType,payMemeber from payment where payTime like "2019-07-27%";


select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, group_concat(cp_name) coupon
from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_no = c.cp_no
group by mb_no;

select payNo,payTime,payMenu,payPrice,payDiscountInfo,payDiscountPrice,payType,payMemeber from payment


select * from sale;
select * from foodkind;
select * from food;
select f.fd_no, f.fd_price, f.fd_name, f.fk_no, fk.fk_name, fk.menu_no from food f left join foodkind fk on f.fk_no = fk.fk_no where f.fk_no = 1;
saleDiscountPrice


select * from `member`;


select * from sale;
select * from member_coupon;

select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, group_concat(cp_name) coupon
from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_no = c.cp_no
group by mb_no;
		
	
select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, group_concat(cp_name) coupon
from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_no = c.cp_no
group by m.mb_no having right(mb_tel,8) like "%87654321%";

select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, group_concat(cp_name) coupon, mb_withdrawal
from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_no = c.cp_no
group by mb_no having not m.mb_no = 0;

update member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_no = c.cp_no set c.cp_use = true where m.mb_no = 1 and c.cp_name = '생일쿠폰';
select * from coupon;