<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
</head>
<body>
	<!-- 현재 위치에 다른 파일 포함하기 -->
	<%@include file="header.jsp" %>
	<div id="cs" class="carousel slide start" data-bs-ride="carousel" data-bs-interval="3000">
		<!-- 캐러셀 인디케이터 -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active"><img alt="" src="img/mainimg (1).jpg"></div>
			<div class="carousel-item"><img alt="" src="img/mainimg (2).jpg"></div>
			<div class="carousel-item"><img alt="" src="img/mainimg (3).jpg"></div>
		</div>
		<!-- 이미지 이동 버튼 -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div> <!-- 캐러셀 end -->
	<br>
	<div class="container text-center">
		<hr> <!-- 실선 태그 -->
		<h3>New ARRIVAL</h3>
		<p>신상품</p>
	</div>	
	
	<div class="container">
		<div class="row">
		<% for(int i = 0 ; i<8; i++) { %>
			<div class="col-md-3">
				<div class="card"> <!-- 카드형식 -->
					<img class="card-img-top" alt="" src="img/item (1).gif"> <!-- 이미지 -->
					<div class="card-body">
						<p class="item">
							<span class="title">재키 핀턱 스판 와이드 슬랙스</span>
							<br>
							<span class="content">데일리로 예쁜 옷 신상 10% 할인</span>
							<br>
							<span class="price">34,800원</span> 
							<span class="price_now"> 31,300원</span> 
							<br>
							<span class="badge bg-info text-dark">리뷰:1,382개</span>
							<span class="badge bg-warning text-dark">주문 폭주</span>
						</p>
					</div>
				</div>
			</div>
			<% } %>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>