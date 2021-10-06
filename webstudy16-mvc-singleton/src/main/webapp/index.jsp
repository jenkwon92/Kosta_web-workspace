<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 MVC, Singleton</title>
</head>
<body>
<h4> Model2 MVC + Singleton Design Pattern</h4>
<%--
		index.jsp ----FindProductByIdServlet --- ProductDAO ------------------Database
																		findProductById (String id) :ProductVO
 											|
 											| forward
 											|
 											find-fail or find-ok
 
 --%>
<form action="FindProductByIdServlet"></form>
<input type="number" name="productId" placeholder="상품아이디" required="required">
<button>검색</button>
</body>
</html>