<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/productcart.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="container">
		<table id="liketable" class="table my-5">
		</table>
		<div class="col-sm-2">
			<button class="form-control" onclick="cancel(-1)">전체 삭제</button>
		</div>
		<div class="row">
			<div class="col-sm-3 offset-3">
				<a href="/jspweb/main.jsp"><button class="form-control py-4" >계속 쇼핑하기</button></a>
			</div>
			<div class="col-sm-3">
				<a href="/jspweb/product/orderpay.jsp">
					<button class="form-control py-4" style="background-color: darkblue; color: white;">구매하기</button>
				</a>
			</div>
		</div>
	</div>
	
	
	<%@include file = "../footer.jsp" %>
	<script src="/jspweb/js/likelist.js" type="text/javascript"></script>
</body>
</html>