<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복</title>
<script type="text/javascript">
	opener.document.getElementById("flag").value="";
	function closePopup(){
		//본창의 아이디 text안에 입력한 아이디 value를 삭제하고 포커스를 준다 
		let idComp = opener.document.getElementById("id");
		idComp.value="";
		idComp.focus();
		self.close();
	}
</script>
</head>
<body>
<%= request.getParameter("id")%> 아이디 중복되어 사용불가합니다<br><br>
<button onclick="closePopup()">확인</button>

</body>
</html>