<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>HUNS</title>
	
</head>
<body>
	
	<!-- https://huns.co.kr/      : 훈스 -->
	<%@include file="header.jsp" %>
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- 사이드바 메뉴 -->
			<%@include file="sidebar.jsp" %>
		</div> <!-- 사이드바 end -->
		<div class="col-md-10 offset-2 content"> <!-- 본문 -->
			<%@include file="main.jsp" %>
		</div>
	</div> <!-- 사이드바, 메인 row -->
	
	<%@include file="footer.jsp" %>
	
	
</body>
</html>