insert into menu values(1, '주메뉴'),(2, '부메뉴'),(3, '음료');
select * from menu;

set foreign_key_checks = 0;

load data local infile 'd://foodKind.csv' into table food.foodkind
character set 'utf8'
fields terminated by ',';
select * from foodkind;

load data local infile 'd://food.csv' into table food.food
character set 'utf8'
fields terminated by ',';
select * from food;

set foreign_key_checks = 1;

insert into grade values ('vip',15),('gold',10),('silver',5);
insert into grade values ('bronze',0);
select * from grade;

insert into coupon values (1,'생일쿠폰',10);
insert into coupon values (2,'졸업쿠폰',5);
insert into coupon values (3,'쿠폰1',5), (4,'쿠폰2',5), (5,'쿠폰3',5);
select * from coupon;

desc manager;
insert into manager values ('test1', password('rootroot'));
insert into manager values ('jongho1227', password('whdgh123'));
select * from manager;

-- select * from manager where pwd = password('rooroot');
-- select length(password('aaaa')) from dual;

/*
set foreign_key_checks = 0;
alter table member change column mb_no mb_no int(11) auto_increment;
set foreign_key_checks = 1;
*/

insert into member(mb_no, mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, mb_withdrawal) values (1, '임종호',now(),'01044155014',1200,'vip','대구',true);
insert into member(mb_no, mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address, mb_withdrawal) values (2, '김재욱',now(),'01087654321',1500,'vip','서울',true);
select * from member;

select * from manager where mg_pwd = password('rootroot');
select * from manager where mg_id='jongho1227' and mg_pwd = password('whdgh123');

select * from sale;
select * from sale order by no desc limit 1;

-- member_coupon 데이터 추가
select * from member_coupon;
insert into member_coupon values (1, 1,0), (1,2,0), (2,1,0);
insert into member_coupon values (2,2,0);

select * from no_manager;
delete from no_manager where nmg_id = '1jongho1227';
insert into no_manager values ('1jongho1227', password('whdgh123'));

select * from member;

LOAD data LOCAL INFILE 'D:\\zipcode_DB\\대구광역시.txt' 
INTO table food.post
character set 'utf8'
fields TERMINATED by '|' 
IGNORE 1 lines 
(@zipcode, @sido, @d, @sigungu , @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d) 
set p_zipcode=@zipcode, p_sido=@sido, p_sigungu=@sigungu, p_doro=@doro, p_address1=@building1, p_address2=@building2;

select * from post;
select * from post where p_sigungu like "동구%";

select * from reservation;


truncate reservation;

drop view member_reservation;


create view member_reservation as

select rsv_no, m.mb_no, mb_name, mb_tel, mb_birth, rsv_number, rsv_time, rsv_tableNo, rsv_input_time, rsv_update_time, rsv_cancel from member m join reservation r on m.mb_no = r.mb_no;

select rsv_no, m.mb_no, mb_name, mb_tel, rsv_number, rsv_time, rsv_tableNo from member m join reservation r on m.mb_no = r.mb_no;

select subtime(now(),'0:30:0');

select * from member_reservation where rsv_time between subtime(now(),'0:30:0') and addtime(now(),'0:30:0');


select * from member_reservation;

select * from member;

select * member_reservation where mb_tel='01044155014';
select * from member_reservation where rsv_time like concat('2019-07-31','%');


select * from sale order by no desc limit 1;


-- sale data
insert into sale values (1,1,now(),1,1,0,1,1,"마일리지:100원",100,false);
insert into sale values (2,1,now(),3,1,0,1,1,"마일리지:100원",100,false);
insert into sale values (3,2,now(),4,1,0,2,1,"마일리지:100원",100,false);
insert into sale values (4,2,now(),5,1,0,2,1,"마일리지:100원",100,false);
insert into sale values (5,3,now(),2,1,0,2,1,"마일리지:100원",100,true);
insert into sale values (6,4,now(),1,1,0,3,1,"마일리지:100원",100,false);
insert into sale values (7,5,now(),3,1,0,4,1,"마일리지:100원",100,false);
