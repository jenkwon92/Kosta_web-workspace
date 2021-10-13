<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">Home</a><br>
<hr>
<%=request.getParameter("carNo") %> 차량정보 <br>
<%=request.getAttribute("carInfo") %>
</body>
</html>