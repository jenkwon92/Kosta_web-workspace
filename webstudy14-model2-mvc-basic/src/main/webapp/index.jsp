<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Model2 MVC</h3>
	<%-- 
		client ----->AllMemberCountServlet <---> MemberDAO <---> Database
								|
								| forward
							allmembercount.jsp
	 --%>
	<ul>
		<li><a href="AllMemberCountServlet">총회원수 조회</a>
		<li><a href="findMemberById-form.jsp">아이디로 회원검색</a>
	</ul>
	<img src="Model2-1.png"><br>
	<img src="forward-redirect.png">
</body>
</html>