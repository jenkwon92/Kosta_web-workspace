<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//post 요청 메서드일떄는 별도의 한글처리가 필요
	request.setCharacterEncoding("utf-8");
	String check = "";
	String name = request.getParameter("userName");
	/* String age=request.getParameter("userAge");
	if(Integer.parseInt(age)>=19){
		check ="성인";
	}else{
		check ="미성년";
	} */

	int age = Integer.parseInt(request.getParameter("userAge"));
	if (age >= 19) {
	%>
	성인
	<%
	} else {
	%>
	미성년
	<%
	}
	%>
	<%-- <%=check %><br> --%>
	<br>
	이름 : <%=name%><br> 
	나이 : <%=age%>
</body>
</html>