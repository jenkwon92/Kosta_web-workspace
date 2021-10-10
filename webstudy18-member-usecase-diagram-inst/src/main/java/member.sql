select * from member;

-- 로그인 sql 
select name,address from member where id='java' and password='a';
select name,address from member where id='java' and password='b';
-- DAO 
select name,address from member where id=?

select name,address from member where id=? and password=?;