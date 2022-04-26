<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="4000"> <!-- 캐러셀 -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active"><img alt="" src="img/211228_main1.jpg"></div>
					<div class="carousel-item"><img alt="" src="img/211228_main2.jpg"></div>
					<div class="carousel-item"><img alt="" src="img/211228_main3.jpg"></div>
				</div>
				<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
				<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
			
			<div class="container main"> <!-- 제품 --> 
				<div class="itembox">
					<div class="text-center">
						<strong>BEST SELLET</strong>
						<p class="stronginfo">#베스트셀러</p>
					</div>
					<div class="row">
					<% for(int i = 0; i < 6; i++) {%>
						<div class="col-md-4">
							<div class="card"> <!-- 카드형식 -->
								<img class="card-img-top" alt="" src="img/item (1).webp">
								<div class="card-body">
									 <p class="card-text">
										 <span class="title">[1+1]플레인 와이드 밴딩팬츠</span>
									 	<hr>
									 	<span class="price">29,800원</span> <br>
									 	<span class="type">2 color / 2 size</span>
									 </p>
								</div>
							</div>
						</div>
					<% } %>
					</div>
				</div>
				<div class="itembox">
					<div class="text-center">
						<strong>NEW ARRIVALS</strong>
						<p class="stronginfo">#이번주 신상품</p>
					</div>
					<div class="row">
					<% for(int i = 0; i < 6; i++) {%>
						<div class="col-md-4">
							<div class="card"> <!-- 카드형식 -->
								<img class="card-img-top" alt="" src="img/item (2).webp">
								<div class="card-body">
									 <p class="card-text">
										 <span class="title">[1+1]롱&숏 맞춤 레이어드 반팔티</span>
									 	<hr>
									 	<span class="price">23,900원</span> <br>
									 	<span class="type">2 type / 3 color / 4 size</span>
									 </p>
								</div>
							</div>
						</div>
					<% } %>
					</div>
				</div>
				<div class="container text-center instagram">
					<p class="insta">INSTAGRAM</p>
					<p class="insta_id">@abcgram</p>
				</div>
		</div> <!-- 본문 end -->
</body>
</html>