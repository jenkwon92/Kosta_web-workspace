<%@page import="org.kosta.webstudy18.model.MemberVO"%>
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
<hr>
<br>
<%-- 2. 로그인 --%>
로그인
<form action="LoginServlet"  method="post">
<input type="text" name="memberId" required="required" placeholder="아이디">
<input type="password" name="memberPass" required="required" placeholder="비밀번호">
<button type="submit">검색</button>
</form>
<br>
<% 
	MemberVO vo = (MemberVO) session.getAttribute("MemberVO");
	if(vo!=null){
%>
	<%=vo.getName() %>님 로그인 중입니다.
	<br><br>
<form action="LogoutServlet">
	<button type="submit" >로그아웃</button>
</form>
<form action="update-form.jsp">
	<button type="submit" >회원정보수정</button>
</form>
<%}else{ %>
	로그인 되어있지 않습니다
<%} %>
<br>
<hr>
<br>
<%-- 4. 주소로 회원검색 --%>
<form action="FindMemberListByAddressServlet">
<input type="text" name="memberAddress" required="required" placeholder="주소">
<button type="submit">검색</button>
</form>
<br>
<hr>


<%-- 5.회원가입 --%>
<a href="register-form.jsp">회원가입</a>
<br>
</div>
</body>
</html>