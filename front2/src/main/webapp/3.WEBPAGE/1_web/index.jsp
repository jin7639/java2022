<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		/* 기본값으로 여백이 들어가는 경우 기본 여백 제거*/
		* {
			margin: 0px;
			padding: 0px;
		}
	</style>
</head>
<body>
	 <!-- <% %>jsp문법: 속성 태그 [자바 사용가능] -->
	<%@include file="header.jsp" %>
	<%@include file="mainimg.jsp" %>
	<%@include file="main.jsp" %>
	<%@include file="footer.jsp" %>
</body>
</html>