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
		<a href="index.jsp">Home</a>
		<hr>
		<%
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		if (vo != null) {
		%>
		<form action="UpdateMemberServlet" method="post">
			<input type="text" name="id" value="<%=vo.getId()%>"	readonly="readonly"><br> 
			<input type="text" name="password" value="<%=vo.getPassword()%>" required="required"><br>
			<input type="text" name="name" value="<%=vo.getName()%>"	required="required"><br> 
			<input type="text" name="address" value="<%=vo.getAddress()%>" required="required"><br>
			<button>수정하기</button>
		</form>
		<%
		} else {
			response.sendRedirect("index.jsp");//로그인 상태가 아니면 index.jsp로 이동시킨다 
		}
		%>
	</div>
</body>
</html>








