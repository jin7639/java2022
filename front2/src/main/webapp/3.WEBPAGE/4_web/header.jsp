<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<!-- 부트스트랩 css포함 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자가 정의한 css 포함 -->
	<link href="css/main.css" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<div class=" fixed-top bg-white">
		<div class="container">
			<div class="py-3"> <!-- 상단 메뉴 -->
			<!-- p: padding py: padding y축 -->
				<div class="row"> <!-- 가로 배치 -->
					<div class="col-md-4 offset-4 text-center">	<!-- 로고 -->
										<!-- text-center : 박스권 내 내용물을 가운데 정렬 -->
						<a href="main.jsp" class="header_logo">대체로 흐림</a> <!-- 링크 -->
					</div>
					<div class="col-md-4 d-flex justify-content-end"> <!-- 상단 메뉴 -->
						<ul class="nav">
							<li><a href="#">로그인</a> |</li>
							<li><a href="signup.jsp">회원가입</a> |</li>
							<li><a href="#">장바구니</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="navbar navbar-expand-md navbar-light bg-white"> <!-- 본 메뉴 -->
				<!-- 숨겨진 메뉴 펼치기 버튼 -->
				<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navcl">
					<ul class="navbar-nav col-md-12 justify-content-between">
						<li class="nav-item"><a href="#" class="nav-link">베스트 상품</a></li>
						<li class="nav-item"><a href="#" class="nav-link">신제품</a></li>
						<li class="nav-item"><a href="#" class="nav-link">아우터</a></li>
						<li class="nav-item"><a href="#" class="nav-link">셔츠</a></li>
						<li class="nav-item"><a href="#" class="nav-link">니트</a></li>
						<li class="nav-item"><a href="#" class="nav-link">바지</a></li>
						<li class="nav-item"><a href="#" class="nav-link">신발</a></li>
						<li class="nav-item"><a href="#" class="nav-link">악세사리</a></li>
						<li class="nav-item"><a href="#" class="nav-link">리뷰</a></li>
						<li class="nav-item"><a href="#" class="nav-link">스타일</a></li>
						<li class="nav-item"><a href="boardlist.jsp" class="nav-link">고객센터</a></li>
						<li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-search"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 부트스트랩 JS포함 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>