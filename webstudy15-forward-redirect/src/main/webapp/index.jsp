<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward redirect 이동방식</title>
</head>
<body>
<%--
			index.jsp --- ForwardTestServlet ---MockDAO
										|
										| forward
										|
									forward-result.jsp
 --%>
<a href="ForwardTestServlet">forward 이동방식 테스트</a> <br><br>
<%--
			index.jsp --- RedirectTestServlet ---MockDAO
										|
										| forward
										|
									redirect-result.jsp
 --%>
<a href="RedirectTestServlet">redirect 이동방식 테스트</a>
</body>
</html>