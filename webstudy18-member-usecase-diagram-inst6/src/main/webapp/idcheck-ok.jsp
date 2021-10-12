<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	//현재 팝업을 띄운 본창의 hidden tag에 인증받은 아이디를 할당한다
	opener.document.getElementById("flag").value="<%=request.getParameter("id")%>"
	function closePopup(){
		opener.documet.getElementById("pass").focus();
		self.close();
	}
	</script>
<%-- onunload 는 창의 끄기 버튼을 누를때 발생하는 이벤트 --%>
<body bgcolor="yellow" onunload="closePopup()">
<%=request.getParameter("id")%> 아이디 사용가능합니다
<button type="button" onclick="closePopup()">확인</button>
</body>
</html>