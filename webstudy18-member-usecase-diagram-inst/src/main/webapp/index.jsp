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
<%-- 비로그인 상태일때는 로그인 폼을 제공한다 --%>
<br><br>
<form action="LoginServlet" method="post">
<input type="text" name="id" placeholder="아이디" required="required"><br>
<input type="password" name="password" placeholder="패스워드" required="required"><br>
<button type="submit">로그인</button>
</form>
<%-- 로그인 상태일때는 누구님 반갑습니다 , 로그아웃 링크를 제공한다  --%>
</div>
</body>
</html>
































