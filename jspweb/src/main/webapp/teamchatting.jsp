<%@page import="dao.ChattingDao"%>
<%@page import="dto.Chatting"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<h3>비회원제 실시간 채팅페이지</h3>
		<div id="contents" style="overflow-y:scroll; width: 500px; height: 500px; border: 1px solid black; margin: 0 auto;">
			
		</div>
		<div style="width: 500px; margin: 0 auto;">
			<input type="text" id="cname" placeholder="닉네임">
			<input type="text" id="ccontent" placeholder="내용">
			<button type="button" onclick="cwrite()">입력</button>
		</div>
	</div>
	<%@include file="footer.jsp" %>
	
	<script src="/jspweb/js/chatting.js" type="text/javascript"></script>
	
</body>
</html>