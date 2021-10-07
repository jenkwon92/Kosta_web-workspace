<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- LoginServlet에 할당한 session 의 회원의 객체에서 name을 얻어와서 보여준다 --%>
<% MemberVO vo = (MemberVO)session.getAttribute("mvo") ;%>
<%=vo.getName() %>님 로그인 OK
</body>
</html>