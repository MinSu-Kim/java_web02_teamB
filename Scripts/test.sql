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


insert into sale values (1,1,now(),1,1,0,1,1);
insert into sale values (2,1,now(),3,1,0,1,1);
insert into sale values (3,1,now(),4,1,0,2,1);
insert into sale values (4,1,now(),5,1,0,2,1);
insert into sale values (5,1,now(),2,1,0,2,1);
insert into sale values (6,1,now(),1,1,0,3,1);
insert into sale values (7,1,now(),3,1,0,4,1);


select @rank := @rank+1 as rank, name, count, price, ssTotalPrice, round(ssTotalPrice/sum(ssTotalPrice) * 100,1) as percent
from(
select f.name as name, sum(order_cnt) as count, f.price as price, sum(order_cnt*f.price) as ssTotalPrice
from sale s left join food f on s.fd_no = f.fd_no
group by s.fd_no
order by ssTotalPrice desc) sub1
cross join (select @rank:=0) sub2;