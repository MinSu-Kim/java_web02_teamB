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

desc grade;
insert into grade values ('vip',10),('gold',7),('silver',5);
select * from grade;

desc coupon;
insert into coupon values (1,'생일쿠폰',10);
select * from coupon;

desc manager;
insert into manager values ('test1', password('rootroot'));
select * from manager;

-- select * from manager where pwd = password('rooroot');
-- select length(password('aaaa')) from dual;

desc member;

set foreign_key_checks = 0;
alter table member change column mb_no mb_no int(11) auto_increment;
set foreign_key_checks = 1;

alter table member change column Mileage mileage int(11);

insert into (name, birth, tel, mileage, grade, address) values ('김우빈',now(),0101234567,1200,'gold','서울') from member;