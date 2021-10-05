<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-2-checkbox-action.jsp</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<%
	String ma[] = request.getParameterValues("menu");
	%>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>MENU</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < ma.length; i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=ma[i] %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>







