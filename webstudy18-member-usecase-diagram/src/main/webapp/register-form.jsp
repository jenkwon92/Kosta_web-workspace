<%@page import="org.kosta.webstudy18.controller.IdCheckServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
 <%String path = (String)request.getAttribute("path"); %>
 
 <script type="text/javascript">
 	function checkRegForm() {
		if(document.getElementById("pass").value!=document.getElementById("confirmPass").value){
			alert("패스워드와 패스워드 확인이 일치하지 않습니다");
			return false; //false를 리턴하면 전송되지 않는다 
		}else if (validation()==false){ //중복확인안한상태
			alert("아이디 중복확인해주세요");
			return false;
		}
	}
 	
 	  function idCheck(){
 		  request.setAttribute("id",document.getElementsByName("id"));
          var name = "아이디중복확인";
          var option = "width = 500, height = 500, top = 100, left = 200, location = no"
          window.open("IdCheckServlet", name, option);
       }
       
      /*  function popup(){
    	 	  var gsWin = window.open("about:blank", "winName", "width=400,height=300,top=100,left=200");
    	      var fr = document.getElementById("id");
    	        fr.action = "IdCheckServlet";
    	        fr.target = "winName";
    	        fr.submit();

       } */
 </script>
<form action="RegisterMemberServlet" method="post" onsubmit="return checkRegForm()">
<input type="text" name="id" id="id" required="required" placeholder="아이디">	<input type="button" value="중복확인" onclick="idCheck()"><br>
<input type="password" name="password" id="pass" required="required" placeholder="패스워드"><br>	
<input type="password" name="confirmPassword" id="confirmPass" required="required" placeholder="패스워드확인"><br>	
<input type="text" name="name" required="required" placeholder="이름"><br>	
<input type="text" name="address" required="required" placeholder="주소"><br><br>
<button type="submit">가입하기</button>
</form>
</div>
</body>
</html>










