<%@page import="dao.Dao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Dao dao = new Dao();
	%>
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	
	<h2>쇼핑몰 회원관리 프로그램</h2>
	<%@include file="footer.jsp" %>
</body>

</html>