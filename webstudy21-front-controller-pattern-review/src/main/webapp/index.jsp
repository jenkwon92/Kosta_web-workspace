<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 MVC FrontController Pattern</title>
</head>
<body>
<h3>Model2 MVC FrontController Pattern Review</h3>
<form action="FrontControllerServlet">
<input type="hidden" name="command" value="FindProductByIdController">
<input type="text" name="productId" placeholder="상품검색" required="required">
<button type="submit">검색</button>

</form>
</body>
</html>