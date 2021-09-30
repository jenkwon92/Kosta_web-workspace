<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-1-checkbox</title>
</head>
<body>
<script type="text/javascript">
	function checkMenu(){
		let flag = false;
		let menu = document.getElementsByName("menu");
		for(let i=0; i<menu.length; i++){
			if(menu[i].checked){ //return true를 하지 않아도 onsubmit에서는 return false일 경우에만 전송하지 않음. 값이 없을 경우에는 그냥 전송
				flag = true;
				break;
			}//if
		}//for
			if(flag==false){
				alert("메뉴를 선택하세요");
				return false;
			}
		}//function
</script>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("마라탕");
	list.add("라면");
	list.add("닭강정");
%>
<form action="step6-2-checkbox-action.jsp" method="get" onsubmit="return checkMenu()">
	<%for (int i=0; i<list.size(); i++){ %>
	<input type="checkbox" name="menu" value="<%=list.get(i)%>"><%=list.get(i) %> <br> 
	<%} %>
	<input type="submit" value="주문">
</form>
<%--
	javascript 로 checkbox 에 하나 이상 체크가 되어 있지 않으면
	alert() 으로 메뉴를 선택하세요 후 전송시키지 않는다
 --%>
</body>
</html>