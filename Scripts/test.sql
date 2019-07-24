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

