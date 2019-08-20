insert into menu values(1, '주메뉴'),(2, '부메뉴'),(3, '음료');

load data local infile 'd://foodKind.csv' into table food.foodkind
character set 'utf8'
fields terminated by ',';

load data local infile 'd://food.csv' into table food.food
character set 'utf8'
fields terminated by ',';

insert into grade values ('vip',15),('gold',10),('silver',5),('bronze',0);

insert into coupon values ('서비스쿠폰',1,5),('회원가입쿠폰',2,10),('생일쿠폰',3,15);

insert into manager values ('jongho1227', password('whdgh123'));

-- select * from manager where pwd = password('rooroot');
-- select length(password('aaaa')) from dual;

/*
set foreign_key_checks = 0;
set foreign_key_checks = 1;
*/

insert into no_manager values ('1jongho1227', password('whdgh123'));

LOAD data LOCAL INFILE 'D:\\zipcode_DB\\대구광역시.txt' 
INTO table food.post
character set 'utf8'
fields TERMINATED by '|' 
IGNORE 1 lines 
(@zipcode, @sido, @d, @sigungu , @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d) 
set p_zipcode=@zipcode, p_sido=@sido, p_sigungu=@sigungu, p_doro=@doro, p_address1=@building1, p_address2=@building2;

insert into member(mb_no, mb_tel, mb_name) values (0, '01000000000','비회원');


select * from menu;
select * from foodKind;
select * from food;
select * from grade;
select * from coupon;
select * from manager;
select * from no_manager;
select * from member;
select * from member_coupon;
select * from sale;
select * from post;
select * from reservation;
select * from notice;
select * from event;