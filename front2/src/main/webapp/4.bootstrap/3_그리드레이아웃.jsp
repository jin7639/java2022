<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>그리드 레이아웃</title>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<ul>
					<li> 메뉴1 </li>
					<li> 메뉴2 </li>
					<li> 메뉴3 </li>
					<li> 메뉴4 </li>
				</ul>
			</div>
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-5 offset-2">col-md-5 offset-2</div>
					<div class="col-md-5">col-md-5</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>