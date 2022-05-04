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
	<%String loginid = (String)session.getAttribute("login");	//세션호출 %>
	
	
	<div class="container">
	<!-- 공통 -->
		<a href="/jspweb/main.jsp">HOME</a>
		<a href="#">BIGSIZE!</a>
		<a href="#">MUSCLE-FIT</a>
		<a href="#">1+1이벤트</a>
		<a href="#">아우터</a>
		<a href="#">상의</a>
		<a href="#">바지</a>
		<a href="#">슈즈</a>
		<a href="#">악세사리</a>
		<a href="#">BEST</a>
		<a href="#">모델처럼입자!</a>
		<a href="#">50% 할인</a><br>
		<input type="text">
		<button>검색</button>
		<a href="#"><img alt="" src="">장바구니</a>
		
	<!-- 로그아웃 상태 -->
		<% if (loginid == null){ %>
		<a href="/jspweb/member/login.jsp">로그인</a>
		<a href="/jspweb/member/signup.jsp">회원가입</a>
		<%} %>
	<!-- 로그인 상태 -->
		<% if (loginid != null) {%>
		<span><%=loginid%>님</span>
		<a href="/jspweb/logout">로그아웃</a>
		<a href="/jspweb/member/myshopping.jsp">나의쇼핑</a>
		<%} %>
		<a href="#">고객센터</a>
	</div>
	
	
	<!-- 사용자지정 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>