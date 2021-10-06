CREATE TABLE web_product(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	maker VARCHAR2(100) NOT NULL,
	price NUMBER NOT NULL
)

CREATE SEQUENCE web_product_seq;

INSERT INTO web_product VALUES(web_product_seq.nextval,'카스','두산',1500);
INSERT INTO web_product(id,name,maker,price) VALUES(web_product_seq.nextval,'테라','진로',1700);
INSERT INTO web_product(id,name,maker,price) VALUES(web_product_seq.nextval,'참이슬','진로',1300);

COMMIT