<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자지정 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<link href="/jspweb/css/admin.css" rel="stylesheet">
	<!-- 폰트어썸 -->
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<!-- marquee : 텍스트 슬라이드 / 속성 : scrollamount="속도"-->
	<marquee scrollamount="10" class="my-2">공지사항 자리 입니다</marquee>
	
	<div id="sidebar" style="z-index: 1;">
		<ul>
			<li><h6>EZEN SHOP<br>관리자모드</h6></li>
			<li><button onclick="pagechange('productlist')">제품 목록</button></li>
			<li><button onclick="pagechange('productadd')">제품 등록</button></li>
			<li><button onclick="pagechange('productstock')">제품 재고</button></li>
			<li><button onclick="#">주문 현황</button></li>
			<li><button onclick="#">주문 배송</button></li>
			<li><button onclick="pagechange('productsales')">매출 관리</button></li>
			<li><a href="/jspweb/main.jsp">홈페이지로 이동</a></li>
			<li><a href="/jspweb/logout">로그아웃</a></li>
		</ul>
		<!-- 사이드바 열기/닫기 버튼으로 사용 -->
		<span id="sidebarbtn" class="sidebarbtn">||||</span>
	</div>
	<!-- 페이지 전환시 페이지가 포함되는 구역 -->
	<div id="mainbox" class="container">
		<h3>관리자 메인 페이지</h3>
	</div>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 차트 cdn -->
	<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/locales/de_DE.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/geodata/germanyLow.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/fonts/notosans-sc.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/percent.js"></script>
	<!-- 사용자지정 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<script src="/jspweb/js/dashboard.js" type="text/javascript"></script>
</body>
</html>