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
INSERT INTO `member` (mb_no,mb_tel,mb_name,mb_birth,mb_mileage,mb_grade,mb_address,mb_withdrawal,mb_count,mb_join) VALUES 
(1,'01033333333','김창민','2013-08-01',1000,'silver','서울 강남구 강남대로 238',1,11,'2015-06-13 15:35:58.000'),
(2,'01022222222','임종호','2013-06-03',1000,'silver','대구 남구 경상길 5',1,6,'2015-08-13 15:37:10.000'),
(3,'01011111111','변지영','2013-02-12',1000,'vip','제주특별자치도 서귀포시 가가로 14',1,20,'2019-01-13 15:38:20.000');

INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(1,'2019-01-20 11:50:11.000',3,0,1,30,1,'',0,0)
,(1,'2019-01-20 11:50:11.000',1,0,1,33,1,'',0,0)
,(2,'2019-01-20 11:50:18.000',3,0,1,32,1,'',0,0)
,(3,'2019-01-20 11:50:28.000',1,0,0,21,1,'',0,0)
,(3,'2019-02-20 11:50:28.000',3,0,0,25,1,'',0,0)
,(3,'2019-02-20 11:50:28.000',2,0,0,24,1,'',0,0)
,(4,'2019-02-20 11:50:47.000',1,0,0,21,1,'마일리지:100원',100,0)
,(4,'2019-02-20 11:50:47.000',1,0,0,22,1,'마일리지:100원',100,0)
,(4,'2019-03-20 11:50:47.000',2,0,0,70,1,'마일리지:100원',100,0)
,(5,'2019-03-20 11:50:56.000',1,0,1,21,1,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(5,'2019-03-20 11:50:56.000',1,0,1,22,1,'',0,0)
,(5,'2019-03-20 11:50:56.000',1,0,1,24,1,'',0,0)
,(6,'2019-03-20 11:51:12.000',1,0,1,20,1,'마일리지:200원',200,0)
,(6,'2019-03-20 11:51:12.000',3,0,1,22,1,'마일리지:200원',200,0)
,(6,'2019-03-20 11:51:12.000',1,0,1,24,1,'마일리지:200원',200,0)
,(6,'2019-03-20 11:51:12.000',3,0,1,72,1,'마일리지:200원',200,0)
,(7,'2019-03-20 11:51:27.000',2,0,1,31,1,'등급할인:silver(5%)',3050,0)
,(7,'2019-03-20 11:51:27.000',2,0,1,33,1,'등급할인:silver(5%)',3050,0)
,(7,'2019-04-20 11:51:27.000',1,0,1,12,1,'등급할인:silver(5%)',3050,0)
,(8,'2019-04-20 11:51:35.000',1,0,1,31,1,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(9,'2019-04-20 11:52:38.000',2,1,0,9,1,'',0,0)
,(10,'2019-04-20 11:52:46.000',2,1,0,18,1,'',0,0)
,(11,'2019-05-20 11:53:04.000',2,1,1,19,1,'마일리지 : 500원',500,0)
,(11,'2019-05-20 11:53:04.000',1,0,1,18,1,'마일리지 : 500원',500,0)
,(12,'2019-05-20 11:53:17.000',2,0,1,19,2,'',0,0)
,(12,'2019-05-20 11:53:17.000',1,0,1,23,2,'',0,0)
,(13,'2019-05-20 11:53:34.000',2,1,0,10,2,'쿠폰 :회원가입쿠폰(10%)',5720,0)
,(13,'2019-05-20 11:53:34.000',2,1,0,14,2,'쿠폰 :회원가입쿠폰(10%)',5720,0)
,(14,'2019-05-20 11:54:07.000',1,1,0,13,2,'',0,0)
,(14,'2019-05-20 11:54:07.000',3,1,0,14,2,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(14,'2019-06-20 11:54:07.000',1,1,0,10,2,'',0,0)
,(15,'2019-06-20 11:54:16.000',3,1,1,19,2,'',0,0)
,(15,'2019-06-20 11:54:16.000',2,1,1,18,2,'',0,0)
,(16,'2019-06-20 11:54:57.000',3,0,1,25,2,'등급할인 : bronze(0%)',0,0)
,(16,'2019-06-20 11:54:57.000',2,1,1,40,2,'등급할인 : bronze(0%)',0,0)
,(16,'2019-06-20 11:54:57.000',1,1,1,44,2,'등급할인 : bronze(0%)',0,0)
,(17,'2019-06-20 11:55:13.000',2,0,0,19,2,'',0,0)
,(17,'2019-06-20 11:55:13.000',1,1,0,23,2,'',0,0)
,(17,'2019-06-20 11:55:13.000',2,0,0,53,2,'',0,0)
,(17,'2019-06-20 11:55:13.000',3,1,0,57,2,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(18,'2019-06-20 11:55:36.000',3,1,1,57,3,'',0,0)
,(18,'2019-06-20 11:55:36.000',3,1,1,58,3,'',0,0)
,(18,'2019-06-20 11:55:36.000',2,1,1,59,3,'',0,0)
,(18,'2019-06-20 11:55:36.000',2,1,1,55,3,'',0,0)
,(19,'2019-07-20 11:55:48.000',2,0,0,69,3,'',0,0)
,(20,'2019-07-20 11:55:57.000',3,1,1,69,3,'',0,0)
,(20,'2019-07-20 11:55:57.000',2,0,1,73,3,'',0,0)
,(20,'2019-07-20 11:55:57.000',1,1,1,68,3,'',0,0)
,(20,'2019-07-20 11:55:57.000',1,0,1,72,3,'',0,0)
,(21,'2019-07-20 11:56:07.000',1,1,1,69,3,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(22,'2019-08-10 11:56:17.000',1,0,1,10,3,'',0,0)
,(23,'2019-08-10 11:56:40.000',1,1,1,2,3,'쿠폰 :회원가입쿠폰(10%)',1180,0)
,(24,'2019-08-10 11:56:48.000',1,1,1,19,3,'',0,0)
,(24,'2019-08-10 11:56:48.000',1,1,1,23,3,'',0,0)
,(25,'2019-08-11 11:56:56.000',1,1,1,3,3,'',0,0)
,(25,'2019-08-11 11:56:56.000',1,1,1,4,3,'',0,0)
,(26,'2019-08-11 11:57:52.000',1,0,1,3,3,'',0,0)
,(27,'2019-08-11 11:57:57.000',1,0,1,30,3,'',0,0)
,(28,'2019-08-12 11:58:04.000',1,0,0,22,3,'',0,0)
,(29,'2019-08-12 11:58:12.000',1,0,1,21,3,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(29,'2019-08-12 11:58:12.000',1,0,1,25,3,'',0,0)
,(30,'2019-08-13 11:58:29.000',47,0,0,20,3,'',0,0)
,(30,'2019-08-13 11:58:29.000',1,0,0,21,3,'',0,0)
,(31,'2019-08-20 11:58:46.000',1,0,1,20,3,'',0,0)
,(32,'2019-08-20 11:59:10.000',1,0,0,10,3,'',0,0)
,(33,'2019-08-20 11:59:16.000',1,0,1,11,3,'',0,0)
,(33,'2019-08-20 11:59:16.000',1,0,1,12,3,'',0,0)
,(33,'2019-08-20 11:59:16.000',1,0,1,14,3,'',0,0)
,(34,'2019-08-20 11:59:23.000',1,0,1,20,3,'',0,0)
,(34,'2019-08-20 11:59:23.000',1,0,1,23,3,'',0,0)
;
INSERT INTO sale (sale_no,sale_time,sale_order_cnt,sale_order_kind,sale_type,fd_no,mb_no,sale_discount_info,sale_discount_price,sale_cancel) VALUES 
(35,'2019-08-20 11:59:29.000',1,0,0,42,3,'',0,0)
,(36,'2019-08-20 11:59:38.000',1,0,0,54,3,'',0,0)
,(37,'2019-08-20 11:59:45.000',1,0,0,31,3,'',0,0)
,(37,'2019-08-20 11:59:45.000',1,0,0,32,3,'',0,0)
;


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