<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-fail</title>
</head>
<body>
<!-- forward 방식은 request가 살아있기때문에 getAttribute 가능 
	클라이언트가 전송한 form data <---getParameter
	setAttribute한 data <----getAttribute
-->
<script type="text/javascript">
	alert("<%=request.getAttribute("id")%> 아이디에 대한 고객정보가 없습니다");
	location.href="index.jsp";
</script>
</body>
</html>