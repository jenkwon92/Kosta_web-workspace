<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-radio-action</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");//post request method이므로 한글처리 	
%>
<%=request.getParameter("menu") %> 주문완료!
</body>
</html>