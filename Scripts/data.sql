load data local infile 'd://foodKind.csv' into table food.foodkind
character set 'utf8'
fields terminated by ',';

update foodkind set fk_no = 1 where fk_no = 0;
select * from foodkind;

load data local infile 'd://food.csv' into table food.food
character set 'utf8'
fields terminated by ',';

set foreign_key_checks = 1;
truncate food;

update food set fd_no = 1 where fd_no = 0;
select * from food;
delete from food where fd_no = 75;

desc grade;
insert into grade values ('vip',15),('gold',10),('silver',5);
insert into grade values ('bronze',0);
select * from grade;

desc coupon;
insert into coupon values (1,'생일쿠폰',10,0);
select * from coupon;

desc manager;
insert into manager values ('test1', password('rootroot'));
insert into manager values ('jongho1227', password('whdgh123'));
select * from manager;

-- select * from manager where pwd = password('rooroot');
-- select length(password('aaaa')) from dual;

desc member;
select fk_name from foodkind where menu_no=1;

/*
set foreign_key_checks = 0;
alter table member change column mb_no mb_no int(11) auto_increment;
set foreign_key_checks = 1;
*/

insert into member(mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address) values ('김우빈',now(),'01012345678',1200,'gold','서울');
insert into member(mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address) values ('김재욱',now(),'01087654321',1500,'vip','서울');
select * from member;

insert into menu values(1, '주메뉴'),(2, '부메뉴'),(3, '음료');
select * from menu;
select fk_name from foodkind where menu_no =1;
select * from foodkind;
select * from sale;
select * from manager where mg_pwd = password('rootroot');
select * from manager where mg_id='jongho1227' and mg_pwd = password('whdgh123');


-- sale 테이블 데이터
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

select * from sale;

select * from sale order by no desc limit 1;

-- member_coupon 데이터 추가
select * from coupon;
insert into coupon values (2, '졸업쿠폰',5,0);

select * from member_coupon;
insert into member_coupon values (1, 1), (1,2), (2,1);


select * from no_manager;
delete from no_manager where nmg_id = '1jongho1227';
insert into no_manager values ('1jongho1227', password('whdgh123'));


insert into member(mb_name, mb_birth, mb_tel, mb_mileage, mb_grade, mb_address) values ('이다희',now(),'01087654321',1500,'gold','서울');
select * from member;
select last_insert_id();

