<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/myshopping.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<%@include file="info_sidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<h3 class="text-center">주문현황</h3>
				<div id="orderbox">
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="/jspweb/js/myshopping.js"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>