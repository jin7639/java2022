<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		.carousel-item img{
			align-items: center;
		}
	</style>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	<!-- 이미지 슬라이드 : 캐러셀 -->
	<div class="container"> <!-- 박스권 -->
		<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000" >
			<!-- 캐러셀 인디케이터 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="" src="../img/강아지.jpg">
					<div class="carousel-caption">
       					 <h5>WARNING!</h5>
       					 <p>너무 귀여움.</p>
      				</div>
				</div>
				<div class="carousel-item">
					<img alt="" src="../img/강아지.jpg">
				</div>
				<div class="carousel-item">
					<img alt="" src="../img/강아지.jpg">
				</div>
			</div>
			<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
		</div>
	</div>
</body>
</html>