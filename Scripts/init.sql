-- 음식
DROP SCHEMA IF EXISTS food;

-- 음식
CREATE SCHEMA food;

-- 음식
CREATE TABLE food.food (
	fd_no    INT         NOT NULL COMMENT '음식번호', -- 음식번호
	fd_price INT         NULL     COMMENT '음식가격', -- 음식가격
	fd_name  VARCHAR(40) NULL     COMMENT '음식명', -- 음식명
	fk_no    INT         NULL     COMMENT '음식종류번호' -- 음식종류번호
)
COMMENT '음식';

-- 음식
ALTER TABLE food.food
	ADD CONSTRAINT PK_food -- 음식 기본키
		PRIMARY KEY (
			fd_no -- 음식번호
		);

-- 음식종류
CREATE TABLE food.foodKind (
	fk_no   INT         NOT NULL COMMENT '음식종류번호', -- 음식종류번호
	fk_name VARCHAR(40) NOT NULL COMMENT '음식종류명', -- 음식종류명
	menu_no INT         NULL     COMMENT '메뉴번호' -- 메뉴번호
)
COMMENT '음식종류';

-- 음식종류
ALTER TABLE food.foodKind
	ADD CONSTRAINT PK_foodKind -- 음식종류 기본키
		PRIMARY KEY (
			fk_no -- 음식종류번호
		);

-- 회원
CREATE TABLE food.member (
	mb_no      INT         NOT NULL COMMENT '회원번호', -- 회원번호
	mb_name    VARCHAR(10) NULL     COMMENT '회원명', -- 회원명
	mb_birth   DATE        NULL     COMMENT '생년월일', -- 생년월일
	mb_tel     VARCHAR(13) NULL     COMMENT '전화번호', -- 전화번호
	mb_mileage INT         NULL     COMMENT '마일리지', -- 마일리지
	mb_grade   CHAR(10)    NULL     COMMENT '고객등급', -- 고객등급
	mb_address VARCHAR(50) NULL     COMMENT '주소' -- 주소
)
COMMENT '회원';

-- 회원
ALTER TABLE food.member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			mb_no -- 회원번호
		);

ALTER TABLE food.member
	MODIFY COLUMN mb_no INT NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 쿠폰
CREATE TABLE food.coupon (
	cp_no       INT         NOT NULL COMMENT '쿠폰번호', -- 쿠폰번호
	cp_name     VARCHAR(10) NULL     COMMENT '쿠폰명', -- 쿠폰명
	cp_discount INT         NULL     COMMENT '할인율' -- 할인율
)
COMMENT '쿠폰';

-- 쿠폰
ALTER TABLE food.coupon
	ADD CONSTRAINT PK_coupon -- 쿠폰 기본키
		PRIMARY KEY (
			cp_no -- 쿠폰번호
		);

ALTER TABLE food.coupon
	MODIFY COLUMN cp_no INT NOT NULL AUTO_INCREMENT COMMENT '쿠폰번호';

-- 등급
CREATE TABLE food.grade (
	grade      CHAR(10) NOT NULL COMMENT '고객등급', -- 고객등급
	g_discount INT      NULL     COMMENT '할인율' -- 할인율
)
COMMENT '등급';

-- 등급
ALTER TABLE food.grade
	ADD CONSTRAINT PK_grade -- 등급 기본키
		PRIMARY KEY (
			grade -- 고객등급
		);

-- 회원,쿠폰
CREATE TABLE food.member_coupon (
	mb_no INT NOT NULL COMMENT '회원번호', -- 회원번호
	cp_no INT NOT NULL COMMENT '쿠폰번호' -- 쿠폰번호
)
COMMENT '회원,쿠폰';

-- 회원,쿠폰
ALTER TABLE food.member_coupon
	ADD CONSTRAINT PK_member_coupon -- 회원,쿠폰 기본키
		PRIMARY KEY (
			mb_no, -- 회원번호
			cp_no  -- 쿠폰번호
		);

-- 결제
CREATE TABLE food.sale (
	no         INT      NOT NULL COMMENT '번호', -- 번호
	sale_no    INT      NOT NULL COMMENT '주문번호', -- 주문번호
	sale_time  DATETIME NULL     COMMENT '시간', -- 시간
	order_cnt  INT      NULL     COMMENT '주문수량', -- 주문수량
	order_kind TINYINT  NULL     COMMENT '주문종류', -- 주문종류
	sale_type  INT      NULL     COMMENT '결제방식', -- 결제방식
	fd_no      INT      NULL     COMMENT '음식번호', -- 음식번호
	mb_no      INT      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '결제';

-- 결제
ALTER TABLE food.sale
	ADD CONSTRAINT PK_sale -- 결제 기본키
		PRIMARY KEY (
			no -- 번호
		);

ALTER TABLE food.sale
	MODIFY COLUMN no INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 관리자
CREATE TABLE food.manager (
	mg_id  VARCHAR(20) NOT NULL COMMENT '관리자id', -- 관리자id
	mg_pwd CHAR(41)    NOT NULL COMMENT '관리자pw' -- 관리자pw
)
COMMENT '관리자';

-- 관리자
ALTER TABLE food.manager
	ADD CONSTRAINT PK_manager -- 관리자 기본키
		PRIMARY KEY (
			mg_id -- 관리자id
		);

-- 우편번호
CREATE TABLE food.post (
	zipcode  CHAR(5)      NULL COMMENT '우편번호', -- 우편번호
	doro     VARCHAR(100) NULL COMMENT '시도', -- 시도
	old_doro VARCHAR(100) NULL COMMENT '구도로' -- 구도로
)
COMMENT '우편번호';

-- 메뉴분류
CREATE TABLE food.menu (
	menu_no   INT         NOT NULL COMMENT '메뉴번호', -- 메뉴번호
	menu_kind VARCHAR(10) NOT NULL COMMENT '메뉴종류' -- 메뉴종류
)
COMMENT '메뉴분류';

-- 메뉴분류
ALTER TABLE food.menu
	ADD CONSTRAINT PK_menu -- 메뉴분류 기본키
		PRIMARY KEY (
			menu_no -- 메뉴번호
		);

-- 비관리자
CREATE TABLE food.no_manager (
	nmg_id  VARCHAR(20) NOT NULL COMMENT '비관리자id', -- 비관리자id
	nmg_pwd char(41)    NOT NULL COMMENT '비관리자pw' -- 비관리자pw
)
COMMENT '비관리자';

-- 비관리자
ALTER TABLE food.no_manager
	ADD CONSTRAINT PK_no_manager -- 비관리자 기본키
		PRIMARY KEY (
			nmg_id -- 비관리자id
		);

-- 음식
ALTER TABLE food.food
	ADD CONSTRAINT FK_foodKind_TO_food -- 음식종류 -> 음식
		FOREIGN KEY (
			fk_no -- 음식종류번호
		)
		REFERENCES food.foodKind ( -- 음식종류
			fk_no -- 음식종류번호
		);

-- 음식종류
ALTER TABLE food.foodKind
	ADD CONSTRAINT FK_menu_TO_foodKind -- 메뉴분류 -> 음식종류
		FOREIGN KEY (
			menu_no -- 메뉴번호
		)
		REFERENCES food.menu ( -- 메뉴분류
			menu_no -- 메뉴번호
		);

-- 회원
ALTER TABLE food.member
	ADD CONSTRAINT FK_grade_TO_member -- 등급 -> 회원
		FOREIGN KEY (
			mb_grade -- 고객등급
		)
		REFERENCES food.grade ( -- 등급
			grade -- 고객등급
		);

-- 회원,쿠폰
ALTER TABLE food.member_coupon
	ADD CONSTRAINT FK_member_TO_member_coupon -- 회원 -> 회원,쿠폰
		FOREIGN KEY (
			mb_no -- 회원번호
		)
		REFERENCES food.member ( -- 회원
			mb_no -- 회원번호
		);

-- 회원,쿠폰
ALTER TABLE food.member_coupon
	ADD CONSTRAINT FK_coupon_TO_member_coupon -- 쿠폰 -> 회원,쿠폰
		FOREIGN KEY (
			cp_no -- 쿠폰번호
		)
		REFERENCES food.coupon ( -- 쿠폰
			cp_no -- 쿠폰번호
		);

-- 결제
ALTER TABLE food.sale
	ADD CONSTRAINT FK_food_TO_sale -- 음식 -> 결제
		FOREIGN KEY (
			fd_no -- 음식번호
		)
		REFERENCES food.food ( -- 음식
			fd_no -- 음식번호
		);

-- 결제
ALTER TABLE food.sale
	ADD CONSTRAINT FK_member_TO_sale -- 회원 -> 결제
		FOREIGN KEY (
			mb_no -- 회원번호
		)
		REFERENCES food.member ( -- 회원
			mb_no -- 회원번호
		);
	
-- 계정과 권한부여
grant all privileges 
on food.* 
to 'user_food'@'localhost' 
identified by 'rootroot';