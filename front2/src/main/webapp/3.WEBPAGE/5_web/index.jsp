<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>HUNS</title>
	
</head>
<body>
	
	<!-- https://huns.co.kr/      : �ƽ� -->
	<%@include file="header.jsp" %>
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- ���̵�� �޴� -->
			<%@include file="sidebar.jsp" %>
		</div> <!-- ���̵�� end -->
		<div class="col-md-10 offset-2 content"> <!-- ���� -->
			<%@include file="main.jsp" %>
		</div>
	</div> <!-- ���̵��, ���� row -->
	
	<%@include file="footer.jsp" %>
	
	
</body>
</html>