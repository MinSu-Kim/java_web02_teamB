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
insert into member values(0,"비회원",now(),"111111111",0,"vip","o");
select * from grade;
insert into sale values (1,1,now(),1,1,0,1,1,"마일리지:100원",100,false);
insert into sale values (2,1,now(),3,1,0,1,1,"마일리지:100원",100,false);
insert into sale values (3,1,now(),4,1,0,2,1,"마일리지:100원",100,false);
insert into sale values (4,1,now(),5,1,0,2,1,"마일리지:100원",100,false);
insert into sale values (5,1,now(),2,1,0,2,1,"마일리지:100원",100,true);
insert into sale values (6,1,now(),1,1,0,3,1,"마일리지:100원",100,false);
insert into sale values (7,1,now(),3,1,0,4,1,"마일리지:100원",100,false);

insert into sale values (8,2,now(),1,1,0,1,1);
insert into sale values (9,2,now(),3,1,0,1,1);
insert into sale values (10,2,now(),4,1,0,2,1);
insert into sale values (11,3,now(),5,1,0,2,1);
insert into sale values (12,5,now(),4,1,0,2,1,"마일리지:100원",100,true);
insert into sale values (13,3,now(),1,1,0,3,1);
insert into sale values (14,3,now(),3,1,0,4,1);

insert into sale values (15,7,'2019-07-30',4,1,0,2,1,"마일리지:100원",100,false);
insert into sale values (16,5,now(),5,1,0,14,1);
insert into sale values (17,5,now(),2,1,0,42,2);
insert into sale values (18,6,now(),1,1,0,32,2);
insert into sale values (19,6,now(),1,1,0,33,2);
insert into sale values (20,6,now(),1,1,0,13,2);
select * from sale;
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

select payNo,payTime,payMenu,payPrice,payType,payMemeber from payment where payTime like "2019%";


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


select s.sale_no as payNo , s.sale_time as payTime, group_concat(f.fd_name) as payMenu ,
sum(f.fd_price*s.sale_order_cnt)-s.sale_discount_price as payPrice,s.sale_type as payType , s.sale_discount_info as payDiscountInfo,sale_discount_price as payDiscountPrice, 
m.mb_name as payMemeber from sale s join food f on s.fd_no=f.fd_no  join member m on s.mb_no = m.mb_no group by s.sale_no;

select * from post where replace(p_doro,' ','') like replace('%현충 로 6길%',' ','');

desc sale;

show tables;
select * from sale;
delete from sale where sale_no = 19;

select * from payment;

update sale set sale_cancel = 0 where sale_no=1;

select s.sale_no as payNo , s.sale_time as payTime, group_concat(f.fd_name) as payMenu ,
sum(f.fd_price*s.sale_order_cnt)-s.sale_discount_price as payPrice,s.sale_type as payType , s.sale_discount_info as payDiscountInfo,sale_discount_price as payDiscountPrice, 
m.mb_name as payMemeber, s.sale_cancel as payCancel from sale s join food f on s.fd_no=f.fd_no  join member m on s.mb_no = m.mb_no group by s.sale_no;


select s.sale_no as payNo , s.sale_time as payTime, group_concat(f.fd_name) as payMenu ,
sum(f.fd_price*s.sale_order_cnt)-s.sale_discount_price as payPrice,s.sale_type as payType , s.sale_discount_info as payDiscountInfo,sale_discount_price as payDiscountPrice, 
m.mb_name as payMemeber, s.sale_cancel as payCancel, s.mb_no as payMemberNo from sale s join food f on s.fd_no=f.fd_no  join member m on s.mb_no = m.mb_no group by s.sale_no having;

select * from payment where payMemeber="김창민";




select sub1.name as ssName, sub1.count as ssCount, sub1.ssTotalPrice
	ssTotalPrice , round(sub1.ssTotalPrice/sub2.sum1*100,1) as ssShare
	from(
	select f.fd_name as name, sum(sale_order_cnt) as count, f.fd_price as price,s.sale_cancel,
	sum(sale_order_cnt*f.fd_price) as ssTotalPrice
	from sale s left join food f on s.fd_no = f.fd_no where s.sale_cancel = 0
	group by s.fd_no
	order by ssTotalPrice desc) sub1 join (
	select sum(sale_order_cnt*f.fd_price) as sum1
	from sale s left join food f on s.fd_no = f.fd_no where s.sale_cancel = 0
	)sub2;


select * from member;
update member set mb_mileage = mb_mileage+100 where mb_no = 1;


select * from coupon;
select * from member_coupon;
update member_coupon set cp_use = 1 where cp_no=2 and mb_no=1;


update member set mb_count = mb_count+1  where mb_no = 2;
select * from grade;
select sum(payPrice) as totalPrice from payment where payMemberNo = 2;


select * from member;
select * from payment;

select * from member;

select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, g_discount, mb_address from member m  join grade g on m.mb_grade = g.grade;
select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, g_discount, mb_address from member m  join grade g on m.mb_grade = g.grade where mb_no=1;
		


select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, group_concat(c.cp_name) coupon, mb_withdrawal, mb_join, cp_use
		from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_name = c.cp_name
		group by mb_no having mb_withdrawal = true
		
select * from member m left join member_coupon mc on m.mb_no = mc.mb_no where cp_use = false;

select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, c.cp_name as coupon, mb_withdrawal, mb_join
		from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_name = c.cp_name left join grade g on m.mb_grade = g.grade
		where mc.cp_use = 0;
	
		select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, c.cp_name as coupon, mb_withdrawal, mb_join
		from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_name = c.cp_name left join grade g on m.mb_grade = g.grade
		
		
		
		select m.mb_no, m.mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, g_discount, mb_address, c.cp_no, c.cp_name as coupon, c.cp_discount
		from member m left join member_coupon mc on m.mb_no = mc.mb_no left join coupon c on mc.cp_name = c.cp_name left join grade g on m.mb_grade = g.grade
		where  mc.cp_use = 0 ;
	
	update member m left join member_coupon mc on m.mb_no = mc.mb_no 
		left join coupon c on mc.cp_name = c.cp_name set mc.cp_use = #{whether} where m.mb_no = #{no} and c.cp_name = #{cpname}
		
		select * from member_coupon;
select * from member;

INSERT INTO food.`member`
(mb_no, mb_tel, mb_name, mb_birth, mb_mileage, mb_grade, mb_address, mb_withdrawal, mb_count, mb_join)
VALUES(4, '01022222222', '손흥민', '2019-07-07', 10000, 'bronze', '대구광역시 달서구 성지로16길 11 0', 1, 0, now());

select sum(payPrice) as totalPrice from payment where payMemberNo =1 and payCancel=0;
select payNo,payTime,payMenu,payType,payDiscountInfo,payDiscountPrice,payMemeber,payCancel,payMemberNo,sum(payPrice) as payPrice from payment where payCancel=0 group by payMemberNo;

select payNo,payTime,payMenu,payType,payDiscountInfo,payDiscountPrice,payMemeber,payCancel,payMemberNo,sum(payPrice) as payPrice from payment where payCancel=0 AND payTime like "2019-08-10%" group by payMemberNo;

select * from sale;

select * from payment order by payNo desc;

select payNo,payOrderKind,payTime,payMenu,payType,payDiscountInfo,payDiscountPrice,payMemeber,payCancel,payMemberNo,sum(payPrice) as payPrice from payment where payCancel=0 group by payMemberNo order by payNo desc;

truncate event;

select * from event;


