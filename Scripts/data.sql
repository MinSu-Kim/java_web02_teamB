load data local infile 'd://foodKind.csv' into table food.foodkind
character set 'utf8'
fields terminated by ',';

update foodkind set fk_no = 1 where fk_no = 0;

select * from foodkind;

load data local infile 'd://food.csv' into table food.food
character set 'utf8'
fields terminated by ',';

update food set fd_no = 1 where fd_no = 0;
select * from food;
delete from food where fd_no = 75;

desc grade;
insert into grade values ('vip',15),('gold',10),('silver',5);
insert into grade values ('bronze',0);
select * from grade;

desc coupon;
insert into coupon values (1,'생일쿠폰',10);
select * from coupon;

desc manager;
insert into manager values (1, 'test1', password('rootroot'));
insert into manager values (2, 'jongho1227', password('whdgh123'));
select * from manager;

-- select * from manager where pwd = password('rooroot');
-- select length(password('aaaa')) from dual;

desc member;
select name from foodkind where menu_no=1;
/*
set foreign_key_checks = 0;
alter table member change column mb_no mb_no int(11) auto_increment;
set foreign_key_checks = 1;
*/

insert into member(name, birth, tel, mileage, grade, address) values ('김우빈',now(),'01012345678',1200,'gold','서울');
insert into member(name, birth, tel, mileage, grade, address) values ('김재욱',now(),'01087654321',1500,'vip','서울');
select * from member;

insert into post values ('42448', '대명로54길','대명동');

insert into menu values(1, '주메뉴'),(2, '부메뉴'),(3, '음료');
select * from menu;
select name from foodkind where menu_no =1;
select * from foodkind;
select * from manager where pwd = password('rootroot');
select * from manager where id='jongho1227' and pwd = password('whdgh123');

