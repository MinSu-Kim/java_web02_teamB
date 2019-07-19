-- ����
DROP SCHEMA IF EXISTS `food`;

-- ����
CREATE SCHEMA `food`;

-- ����
CREATE TABLE `food`.`food` (
	`fd_no` INT         NOT NULL COMMENT '���Ĺ�ȣ', -- ���Ĺ�ȣ
	`price` INT         NULL     COMMENT '���İ���', -- ���İ���
	`name`  VARCHAR(40) NULL     COMMENT '���ĸ�', -- ���ĸ�
	`fk_no` INT         NULL     COMMENT '����������ȣ' -- ����������ȣ
)
COMMENT '����';

-- ����
ALTER TABLE `food`.`food`
	ADD CONSTRAINT `PK_food` -- ���� �⺻Ű
		PRIMARY KEY (
			`fd_no` -- ���Ĺ�ȣ
		);

-- ��������
CREATE TABLE `food`.`foodKind` (
	`fk_no` INT         NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	`name`  VARCHAR(40) NULL     COMMENT '����������' -- ����������
)
COMMENT '��������';

-- ��������
ALTER TABLE `food`.`foodKind`
	ADD CONSTRAINT `PK_foodKind` -- �������� �⺻Ű
		PRIMARY KEY (
			`fk_no` -- ����������ȣ
		);

-- ȸ��
CREATE TABLE `food`.`member` (
	`mb_no`   INT         NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	`name`    VARCHAR(10) NULL     COMMENT 'ȸ����', -- ȸ����
	`birth`   DATE        NULL     COMMENT '�������', -- �������
	`tel`     INT         NULL     COMMENT '��ȭ��ȣ', -- ��ȭ��ȣ
	`Mileage` INT         NULL     COMMENT '���ϸ���', -- ���ϸ���
	`grade`   CHAR(10)    NULL     COMMENT '�����', -- �����
	`address` VARCHAR(50) NULL     COMMENT '�ּ�' -- �ּ�
)
COMMENT 'ȸ��';

-- ȸ��
ALTER TABLE `food`.`member`
	ADD CONSTRAINT `PK_member` -- ȸ�� �⺻Ű
		PRIMARY KEY (
			`mb_no` -- ȸ����ȣ
		);

-- ����
CREATE TABLE `food`.`coupon` (
	`cp_no`    INT         NOT NULL COMMENT '������ȣ', -- ������ȣ
	`name`     VARCHAR(10) NULL     COMMENT '������', -- ������
	`discount` INT         NULL     COMMENT '������' -- ������
)
COMMENT '����';

-- ����
ALTER TABLE `food`.`coupon`
	ADD CONSTRAINT `PK_coupon` -- ���� �⺻Ű
		PRIMARY KEY (
			`cp_no` -- ������ȣ
		);

-- ���
CREATE TABLE `food`.`grade` (
	`grade`    CHAR(10) NOT NULL COMMENT '�����', -- �����
	`discount` INT      NULL     COMMENT '������' -- ������
)
COMMENT '���';

-- ���
ALTER TABLE `food`.`grade`
	ADD CONSTRAINT `PK_grade` -- ��� �⺻Ű
		PRIMARY KEY (
			`grade` -- �����
		);

-- ȸ��,����
CREATE TABLE `food`.`member_coupon` (
	`mb_no` INT NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	`cp_no` INT NOT NULL COMMENT '������ȣ' -- ������ȣ
)
COMMENT 'ȸ��,����';

-- ȸ��,����
ALTER TABLE `food`.`member_coupon`
	ADD CONSTRAINT `PK_member_coupon` -- ȸ��,���� �⺻Ű
		PRIMARY KEY (
			`mb_no`, -- ȸ����ȣ
			`cp_no`  -- ������ȣ
		);

-- �Ǹ�
CREATE TABLE `food`.`sale` (
	`sal_no`     INT      NOT NULL COMMENT '�ǸŹ�ȣ', -- �ǸŹ�ȣ
	`fd_no`      INT      NOT NULL COMMENT '���Ĺ�ȣ', -- ���Ĺ�ȣ
	`date`       DATE     NULL     COMMENT '��¥', -- ��¥
	`time`       DATETIME NULL     COMMENT '�ð�', -- �ð�
	`order_cnt`  INT      NULL     COMMENT '�ֹ�����', -- �ֹ�����
	`mb_no`      INT      NULL     COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	`order_kind` TINYINT  NULL     COMMENT '�ֹ�����' -- �ֹ�����
)
COMMENT '�Ǹ�';

-- �Ǹ�
ALTER TABLE `food`.`sale`
	ADD CONSTRAINT `PK_sale` -- �Ǹ� �⺻Ű
		PRIMARY KEY (
			`sal_no` -- �ǸŹ�ȣ
		);

-- ������
CREATE TABLE `food`.`manager` (
	`m_no` INT         NULL COMMENT '�����ڹ�ȣ', -- �����ڹ�ȣ
	`id`   VARCHAR(20) NULL COMMENT '������id', -- ������id
	`pwd`  VARCHAR(20) NULL COMMENT '������pw' -- ������pw
)
COMMENT '������';

-- �����ȣ
CREATE TABLE `food`.`post` (
	`zipcode`  CHAR(5)      NULL COMMENT '�����ȣ', -- �����ȣ
	`doro`     VARCHAR(100) NULL COMMENT '�õ�', -- �õ�
	`old_doro` VARCHAR(100) NULL COMMENT '������' -- ������
)
COMMENT '�����ȣ';

-- ����
ALTER TABLE `food`.`food`
	ADD CONSTRAINT `FK_foodKind_TO_food` -- �������� -> ����
		FOREIGN KEY (
			`fk_no` -- ����������ȣ
		)
		REFERENCES `food`.`foodKind` ( -- ��������
			`fk_no` -- ����������ȣ
		);

-- ȸ��
ALTER TABLE `food`.`member`
	ADD CONSTRAINT `FK_grade_TO_member` -- ��� -> ȸ��
		FOREIGN KEY (
			`grade` -- �����
		)
		REFERENCES `food`.`grade` ( -- ���
			`grade` -- �����
		);

-- ȸ��,����
ALTER TABLE `food`.`member_coupon`
	ADD CONSTRAINT `FK_member_TO_member_coupon` -- ȸ�� -> ȸ��,����
		FOREIGN KEY (
			`mb_no` -- ȸ����ȣ
		)
		REFERENCES `food`.`member` ( -- ȸ��
			`mb_no` -- ȸ����ȣ
		);

-- ȸ��,����
ALTER TABLE `food`.`member_coupon`
	ADD CONSTRAINT `FK_coupon_TO_member_coupon` -- ���� -> ȸ��,����
		FOREIGN KEY (
			`cp_no` -- ������ȣ
		)
		REFERENCES `food`.`coupon` ( -- ����
			`cp_no` -- ������ȣ
		);

-- �Ǹ�
ALTER TABLE `food`.`sale`
	ADD CONSTRAINT `FK_food_TO_sale` -- ���� -> �Ǹ�
		FOREIGN KEY (
			`fd_no` -- ���Ĺ�ȣ
		)
		REFERENCES `food`.`food` ( -- ����
			`fd_no` -- ���Ĺ�ȣ
		);

-- �Ǹ�
ALTER TABLE `food`.`sale`
	ADD CONSTRAINT `FK_member_TO_sale` -- ȸ�� -> �Ǹ�
		FOREIGN KEY (
			`mb_no` -- ȸ����ȣ
		)
		REFERENCES `food`.`member` ( -- ȸ��
			`mb_no` -- ȸ����ȣ
		);
	
-- ������ ���Ѻο�
grant all privileges 
on food.* 
to 'user_food'@'localhost' 
identified by 'rootroot';