<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String driver = "oracle.jdbc.OracleDriver";
	Class.forName(driver);
	String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Connection con=DriverManager.getConnection(url,"scott","tiger");
	String sql ="SELECT COUNT(*) FROM member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	int count = 0;
	if(rs.next())
		count = rs.getInt(1);
	rs.close();
	pstmt.close();
	con.close();
%>
<h3>초기 웹개발방식 :  jsp 와 database</h3>
<h4>총 회원수 <%=count %>명</h4>
</body>
</html>