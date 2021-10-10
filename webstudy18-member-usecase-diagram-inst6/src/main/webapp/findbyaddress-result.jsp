<%@page import="org.kosta.webstudy18.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyaddress-result</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<a href="index.jsp">Home</a>
		<h3><%=request.getParameter("address") %>에 사는 회원리스트</h3>
		<%
		@SuppressWarnings("unchecked")
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
		%>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>




