<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<div class="container">
<h3>Model2 MVC 회원관리</h3>
<%-- 1. 아이디로 회원검색 --%>
<form action="FindMemberByIdServlet">
<input type="text" name="memberId" required="required" placeholder="아이디">
<button type="submit">검색</button>
</form>
<br>
<%-- 2. 로그인 --%>
로그인
<form action="LoginServlet"  method="post">
<input type="text" name="memberId" required="required" placeholder="아이디">
<input type="password" name="memberPass" required="required" placeholder="비밀번호">
<button type="submit">검색</button>
</form>
</div>
</body>
</html>