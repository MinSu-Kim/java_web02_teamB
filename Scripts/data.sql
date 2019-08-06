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

insert into coupon values ('서비스쿠폰',1,5);
insert into coupon values ('회원가입쿠폰',2,10);
insert into coupon values ('생일쿠폰',3,15);
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
select * from member;

select * from manager where mg_pwd = password('rootroot');
select * from manager where mg_id='jongho1227' and mg_pwd = password('whdgh123');

select * from sale;
select * from sale order by no desc limit 1;

select * from no_manager;
delete from no_manager where nmg_id = '1jongho1227';
insert into no_manager values ('1jongho1227', password('whdgh123'));

select * from member;



select * from member_coupon;

select * from coupon;

LOAD data LOCAL INFILE 'D:\\zipcode_DB\\대구광역시.txt' 
INTO table food.post
character set 'utf8'
fields TERMINATED by '|' 
IGNORE 1 lines 
(@zipcode, @sido, @d, @sigungu , @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d) 
set p_zipcode=@zipcode, p_sido=@sido, p_sigungu=@sigungu, p_doro=@doro, p_address1=@building1, p_address2=@building2;

select * from post;

insert into member(mb_no, mb_tel, mb_name) values (0, '01000000000','비회원');
delete from member where mb_no = 0;

select * from reservation;
select * from member_reservation;
select * from member_reservation2;
select * from member_reservation where rsv_time like concat(current_date(),'%');
select * from member_reservation4;

select * from reservation where rsv_cancel = 0;









