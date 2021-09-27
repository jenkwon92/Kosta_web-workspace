SELECT * FROM member;
CREATE table member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL
)

INSERT INTO member VALUES('java','a','아이유','오리');
INSERT INTO member VALUES('servlet','s','강하늘','종로');
COMMIT

SELECT COUNT(*) FROM member;
