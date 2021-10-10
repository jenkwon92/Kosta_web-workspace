select * from member;

-- 로그인 sql 
select name,address from member where id='java' and password='a';
select name,address from member where id='java' and password='b';
select name,address from member where id='java1' and password='a';
-- 회원수정 sql 
update member set password='a', name='아이유3',address='수원' where id='java';

-- DAO 
select password,name,address from member where id=?

select name,address from member where id=? and password=?;