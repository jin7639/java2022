<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- 부트스트랩 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css -->
	<link href="index.css" rel="stylesheet" >
	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>
	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5"> <!-- 상단고정 --> 
		<div class="col-md-7 offset-5 d-flex justify-content-end"> <!-- 헤더 메뉴( 오른쪽 배치 )  -->
			<ul class="nav"> <!-- 해당 리스트[ ul , ol ] 가로 배치[ inline ] -->
				<li class="tophead"> <a href="login.jsp">LOGIN</a></li>
				<li class="tophead"> <a href="#">JOIN</a> </li>
				<li class="tophead"> <a href="#">CART</a> </li>
				<li class="tophead"> <a href="#">MY PAGE</a> </li>
				<li class="tophead"> <a href="#">SNS</a> </li>
				<li class="tophead"> <a href="#">BOOKMARK</a> </li>
			</ul>
		</div>
	</div>
	<!-- 부트스트랩 js cdn  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>