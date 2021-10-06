CREATE TABLE web_product(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)
CREATE SEQUENCE web_product_seq;

INSERT INTO web_product(id,name,maker,price) VALUES(web_product_seq.nextval,'카스','두산',1500);
INSERT INTO web_product(id,name,maker,price) VALUES(web_product_seq.nextval,'테라','진로',1700);
INSERT INTO web_product(id,name,maker,price) VALUES(web_product_seq.nextval,'참이슬','진로',1300);

commit