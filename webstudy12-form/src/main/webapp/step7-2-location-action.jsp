<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step7-2-location-action.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("userAge"));
%>
<% if(age>=19){%>
	<%=name %> 님 즐거운 성인영화 관람되세요
<% }else{%>
	<script>
		alert("<%=name %>님 나이 더 먹고 오세요");
		//지정한 경로로 이동시킨다, 아래처럼 query string을 이용해 데이터를 전달할 수 있다
		location.href="step7-3-child.jsp?name=<%=name%>";
	</script>
<%} %>
</body>
</html>