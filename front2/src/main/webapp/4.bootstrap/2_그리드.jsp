<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>그리드</title>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	<!-- 박스권 : container -->
	<!-- 그리드 : 박스 12조각으로 나누기 -->
	<div class="container">
		<div class="row">
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
		</div>
		<div class="row">
			<div class="col-md-4">.col-md-1</div>
			<div class="col-md-8">.col-md-1</div>
		</div>
		<div class="row">
			<div class="col-md-4">.col-md-1</div>
			<div class="col-md-4">.col-md-1</div>
			<div class="col-md-4">.col-md-1</div>
		</div>
		<div class="row">
			<div class="col-md-6">.col-md-1</div>
			<div class="col-md-6">.col-md-1</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-8">외부 그리드내 8그리드</div>
					<div class="col-md-4">외부 그리드내 4그리드</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-6">외부4그리드 내 6그리드</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-5">col-md-5</div>
			<div class="col-md-5 offset-md-2">col-md-5</div> <!-- offser : 가운데 2그리드 비워두기 -->
		</div>
		<div class="row">
			<div class="col-md-4">col-md-4</div>
			<div class="col-md-7 offset-md-1">col-md-7</div>
		</div>
		<div class="row">
			<div class="col-md-5">col-md-5</div>
			<div class="col-md-8">col-md-8</div>
		</div>
	</div>
</body>
</html>