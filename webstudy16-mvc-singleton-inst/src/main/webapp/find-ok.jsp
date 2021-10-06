<%@page import="org.kosta.webstudy16.model.ProductVO"%>
<%@page import="org.kosta.webstudy16.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find-ok</title>
</head>
<body>
<% 
	ProductVO vo = (ProductVO)request.getAttribute("ProductVO");
%>
아이디 :<%=vo.getId() %> <br>
상품명 : <%=vo.getName() %> <br>
제조사 : <%=vo.getMaker() %> <br>
가격 : <%=vo.getPrice() %>
</body>
</html>