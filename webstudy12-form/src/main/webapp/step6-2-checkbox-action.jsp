<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
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
	String[] menu = request.getParameterValues("menu");
	/* ArrayList<String> list = new ArrayList<String>();
	for(int i=0; i<request.getParameterValues("menu").length;i++){
		list.add(request.getParameterValues("menu")[i]);
	} */
	%>
	<table>
		<thead>
			<tr>
				<th>NO</th>
				<th>Menu</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < menu.length; i++) {
			%>
			<%-- <% for(int i=0; i<list.size();i++){ %> --%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=menu[i]%></td>
				<%-- 	<td><%=i+1 %></td><td><%=list.get(i)%></td> --%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>