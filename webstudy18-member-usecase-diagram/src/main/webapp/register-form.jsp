<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<div class="container">
<a href="index.jsp">Home</a><hr>
<%-- 가입하기 submit 을 누르면 
	    패스워드와 패스워드 확인란에 동일한 패스워드를 입력했을 때만 submit 되게 javascript로 
	    구현해본다 
	    일치하지 않으면 alert으로 패스워드와 패스워드 확인이 일치하지 않습니다 후 전송하지 않는다 
 --%>
 <script type="text/javascript">
 	function checkRegForm() {
		if(document.getElementById("pass").value!=document.getElementById("confirmPass").value){
			alert("패스워드와 패스워드 확인이 일치하지 않습니다");
			return false; //false를 리턴하면 전송되지 않는다 
		}
	}
 </script>
<form action="RegisterMemberServlet" method="post" onsubmit="return checkRegForm()">
<input type="text" name="id" required="required" placeholder="아이디"><br>	
<input type="password" name="password" id="pass" required="required" placeholder="패스워드"><br>	
<input type="password" name="confirmPassword" id="confirmPass" required="required" placeholder="패스워드확인"><br>	
<input type="text" name="name" required="required" placeholder="이름"><br>	
<input type="text" name="address" required="required" placeholder="주소"><br>	
<button type="submit">가입하기</button>
</form>
</div>
</body>
</html>










