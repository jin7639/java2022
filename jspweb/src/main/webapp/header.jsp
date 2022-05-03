<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비 약간</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자지정 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
</head>
<body>
	<%
		String loginid = (String)session.getAttribute("login");	//세션호출
	%>
	
	
	<div class="container">
	<!-- 공통 -->
		<a href="/jspweb/main.jsp">HOME</a>
	<!-- 로그아웃 상태 -->
		<% if (loginid == null){ %>
		<a href="/jspweb/member/login.jsp">로그인</a>
		<a href="/jspweb/member/signup.jsp">회원가입</a>
		<%} %>
	<!-- 로그인 상태 -->
		<% if (loginid != null) {%>
		<span><%=loginid%>님</span>
		<a href="logout">로그아웃</a>
		<a href="/jspweb/member/memberinfo.jsp">회원정보</a>
		<%} %>
	</div>
	
	
	<!-- 사용자지정 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>