<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
	<form action="../login"></form>
		<input type="text" name="mid">
		<input type="password" name="mpassword">
		
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>