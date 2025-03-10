-- 음식
DROP SCHEMA IF EXISTS food;

-- 음식
CREATE SCHEMA food;

-- 음식
CREATE TABLE food.food (
	fd_no         INT         NOT NULL COMMENT '음식번호', -- 음식번호
	fd_price      INT         NULL     COMMENT '음식가격', -- 음식가격
	fd_name       VARCHAR(40) NULL     COMMENT '음식명', -- 음식명
	fk_no         INT         NULL     COMMENT '음식종류번호', -- 음식종류번호
	fd_img        VARCHAR(50) NULL     COMMENT '음식사진', -- 음식사진
	fd_withdrawal TINYINT     NULL     DEFAULT false COMMENT '삭제여부', -- 삭제여부
	fd_name_eng   VARCHAR(60) NULL     COMMENT '음식영어', -- 음식영어
	fd_explain    TEXT        NULL     COMMENT '음식설명' -- 음식설명
)
COMMENT '음식';

-- 음식
ALTER TABLE food.food
	ADD CONSTRAINT PK_food -- 음식 기본키
		PRIMARY KEY (
			fd_no -- 음식번호
		);

ALTER TABLE food.food
	MODIFY COLUMN fd_no INT NOT NULL AUTO_INCREMENT COMMENT '음식번호';

-- 음식종류
CREATE TABLE food.foodKind (
	fk_no       INT         NOT NULL COMMENT '음식종류번호', -- 음식종류번호
	fk_name     VARCHAR(40) NOT NULL COMMENT '음식종류명', -- 음식종류명
	menu_no     INT         NULL     COMMENT '메뉴번호', -- 메뉴번호
	fk_name_eng VARCHAR(60) NULL     COMMENT '음식종류영어' -- 음식종류영어
)
COMMENT '음식종류';

-- 음식종류
ALTER TABLE food.foodKind
	ADD CONSTRAINT PK_foodKind -- 음식종류 기본키
		PRIMARY KEY (
			fk_no -- 음식종류번호
		);

ALTER TABLE food.foodKind
	MODIFY COLUMN fk_no INT NOT NULL AUTO_INCREMENT COMMENT '음식종류번호';

-- 회원
CREATE TABLE food.member (
	mb_no         INT         NOT NULL COMMENT '회원번호', -- 회원번호
	mb_tel        VARCHAR(13) NOT NULL COMMENT '전화번호', -- 전화번호
	mb_name       VARCHAR(10) NULL     COMMENT '회원명', -- 회원명
	mb_birth      DATE        NULL     COMMENT '생년월일', -- 생년월일
	mb_mileage    INT         NULL     COMMENT '마일리지', -- 마일리지
	mb_grade      CHAR(10)    NULL     COMMENT '고객등급', -- 고객등급
	mb_address    TEXT		  NULL     COMMENT '주소', -- 주소
	mb_withdrawal TINYINT     NULL     COMMENT '탈퇴여부', -- 탈퇴여부
	mb_count      INT         NULL     DEFAULT 0 COMMENT '결제건수', -- 결제건수
	mb_join       DATETIME    NULL     COMMENT '가입일' -- 가입일
)
COMMENT '회원';

-- 회원
ALTER TABLE food.member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			mb_no -- 회원번호
		);

-- 쿠폰
CREATE TABLE food.coupon (
	cp_name     VARCHAR(10) NOT NULL COMMENT '쿠폰명', -- 쿠폰명
	cp_no       INT         NULL     COMMENT '쿠폰번호', -- 쿠폰번호
	cp_discount INT         NULL     COMMENT '할인율' -- 할인율
)
COMMENT '쿠폰';

-- 쿠폰
ALTER TABLE food.coupon
	ADD CONSTRAINT PK_coupon -- 쿠폰 기본키
		PRIMARY KEY (
			cp_name -- 쿠폰명
		);

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
	mc_no   INT         NOT NULL COMMENT '번호', -- 번호
	mb_no   INT         NOT NULL COMMENT '회원번호', -- 회원번호
	cp_name VARCHAR(10) NOT NULL COMMENT '쿠폰명', -- 쿠폰명
	cp_use  TINYINT     NULL     DEFAULT false COMMENT '사용유무' -- 사용유무
)
COMMENT '회원,쿠폰';

-- 회원,쿠폰
ALTER TABLE food.member_coupon
	ADD CONSTRAINT PK_member_coupon -- 회원,쿠폰 기본키
		PRIMARY KEY (
			mc_no -- 번호
		);

ALTER TABLE food.member_coupon
	MODIFY COLUMN mc_no INT NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 결제
CREATE TABLE food.sale (
	no                  INT         NOT NULL COMMENT '번호', -- 번호
	sale_no             INT         NOT NULL COMMENT '주문번호', -- 주문번호
	sale_time           DATETIME    NULL     COMMENT '시간', -- 시간
	sale_order_cnt      INT         NULL     COMMENT '주문수량', -- 주문수량
	sale_order_kind     TINYINT     NULL     COMMENT '주문종류', -- 주문종류
	sale_type           INT         NULL     COMMENT '결제방식', -- 결제방식
	fd_no               INT         NULL     COMMENT '음식번호', -- 음식번호
	mb_no               INT         NULL     COMMENT '회원번호', -- 회원번호
	sale_discount_info  VARCHAR(30) NULL     COMMENT '할인정보', -- 할인정보
	sale_discount_price INT         NULL     COMMENT '할인금액', -- 할인금액
	sale_cancel         TINYINT     NULL     DEFAULT false COMMENT '결제취소여부' -- 결제취소여부
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
	p_zipcode  CHAR(5)      NULL COMMENT '우편번호', -- 우편번호
	p_sido     VARCHAR(20)  NULL COMMENT '시도', -- 시도
	p_sigungu  VARCHAR(20)  NULL COMMENT '시군구', -- 시군구
	p_doro     VARCHAR(100) NULL COMMENT '신도로', -- 신도로
	p_address1 INT(5)       NULL COMMENT '상세주소1', -- 상세주소1
	p_address2 INT(5)       NULL COMMENT '상세주소2' -- 상세주소2
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

-- 예약
CREATE TABLE food.reservation (
	rsv_no          INT        NOT NULL COMMENT '예약번호', -- 예약번호
	rsv_number      int        NOT NULL COMMENT '인원', -- 인원
	rsv_time        DATETIME   NOT NULL COMMENT '시간', -- 시간
	mb_no           INT        NULL     COMMENT '회원번호', -- 회원번호
	rsv_tableNo     VARCHAR(5) NOT NULL COMMENT '테이블번호', -- 테이블번호
	rsv_input_time  DATETIME   NOT NULL COMMENT '등록날짜', -- 등록날짜
	rsv_update_time DATETIME   NULL     COMMENT '수정날짜', -- 수정날짜
	rsv_cancel      TINYINT    NOT NULL DEFAULT false COMMENT '예약취소' -- 예약취소
)
COMMENT '예약';

-- 예약
ALTER TABLE food.reservation
	ADD CONSTRAINT PK_reservation -- 예약 기본키
		PRIMARY KEY (
			rsv_no -- 예약번호
		);

ALTER TABLE food.reservation
	MODIFY COLUMN rsv_no INT NOT NULL AUTO_INCREMENT COMMENT '예약번호';

-- 이벤트
CREATE TABLE food.event (
	e_no         INT          NOT NULL COMMENT '이벤트번호', -- 이벤트번호
	e_name       VARCHAR(20)  NOT NULL COMMENT '작성자', -- 작성자
	e_title      TEXT         NOT NULL COMMENT '이벤트제목', -- 이벤트제목
	e_text       TEXT         NULL     COMMENT '이벤트내용', -- 이벤트내용
	e_img        VARCHAR(100) NULL     COMMENT '대표이미지', -- 대표이미지
	e_start_date DATETIME     NULL     COMMENT '시작날짜', -- 시작날짜
	e_end_date   DATETIME     NULL     COMMENT '마감날짜', -- 마감날짜
	e_ing        TINYINT      NULL     COMMENT '진행여부' -- 진행여부
)
COMMENT '이벤트';

-- 이벤트
ALTER TABLE food.event
	ADD CONSTRAINT PK_event -- 이벤트 기본키
		PRIMARY KEY (
			e_no -- 이벤트번호
		);

ALTER TABLE food.event
	MODIFY COLUMN e_no INT NOT NULL AUTO_INCREMENT COMMENT '이벤트번호';

-- 공지사항
CREATE TABLE food.notice (
	no_no      INT         NOT NULL COMMENT '게시판번호', -- 게시판번호
	no_title   VARCHAR(50) NULL     COMMENT '게시판제목', -- 게시판제목
	no_content TEXT        NULL     COMMENT '게시판내용', -- 게시판내용
	no_read_nt INT         NULL     DEFAULT 0 COMMENT '조회수', -- 조회수
	no_writer  VARCHAR(20) NULL     COMMENT '작성자', -- 작성자
	no_regdate DATETIME    NULL     COMMENT '등록일', -- 등록일
	no_moddate DATETIME    NULL     COMMENT '수정일', -- 수정일
	no_delete  TINYINT     NULL     DEFAULT false COMMENT '삭제여부' -- 삭제여부
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE food.notice
	ADD CONSTRAINT PK_notice -- 공지사항 기본키
		PRIMARY KEY (
			no_no -- 게시판번호
		);

ALTER TABLE food.notice
	MODIFY COLUMN no_no INT NOT NULL AUTO_INCREMENT COMMENT '게시판번호';

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
			cp_name -- 쿠폰명
		)
		REFERENCES food.coupon ( -- 쿠폰
			cp_name -- 쿠폰명
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

-- 예약
ALTER TABLE food.reservation
	ADD CONSTRAINT FK_member_TO_reservation -- 회원 -> 예약
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

use food;

-- 음식판매 통계 쿼리 (view)
create view stateFood as 
select sub1.name as ssName, sub1.count as ssCount, sub1.ssTotalPrice
	ssTotalPrice , round(sub1.ssTotalPrice/sub2.sum1*100,1) as ssShare
	from(
	select f.fd_name as name, sum(sale_order_cnt) as count, f.fd_price as price,s.sale_cancel,
	sum(sale_order_cnt*f.fd_price) as ssTotalPrice
	from sale s left join food f on s.fd_no = f.fd_no where sale_cancel = 0
	group by s.fd_no
	order by ssTotalPrice desc) sub1 join (
	select sum(sale_order_cnt*f.fd_price) as sum1
	from sale s left join food f on s.fd_no = f.fd_no where sale_cancel = 0
	)sub2;

-- 결제 통계 쿼리 (view)
create view payment as
select s.sale_no as payNo , s.sale_time as payTime, group_concat(f.fd_name) as payMenu ,s.sale_order_kind as payOrderKind,
sum(f.fd_price*s.sale_order_cnt)-s.sale_discount_price as payPrice,s.sale_type as payType , s.sale_discount_info as payDiscountInfo,sale_discount_price as payDiscountPrice, 
m.mb_name as payMemeber, s.sale_cancel as payCancel, s.mb_no as payMemberNo from sale s join food f on s.fd_no=f.fd_no  join member m on s.mb_no = m.mb_no group by s.sale_no;

-- 예약정보 뷰
create view member_reservation as
select rsv_no, m.mb_no, mb_name, mb_tel, mb_birth, rsv_number, rsv_time, rsv_tableNo, rsv_input_time, rsv_update_time, rsv_cancel from member m join reservation r on m.mb_no = r.mb_no;
create view member_reservation2 as -- 오늘 예약한 애들
select * from member_reservation where rsv_time like concat(current_date(),'%');

create view member_reservation3 as -- 오늘 예약한 애들중에 취소 안한애들
select * from member_reservation2 where rsv_cancel = 0;

create view member_reservation4 as -- 전체 예약중에 취소 안한 예약.
select * from reservation where rsv_cancel = 0;