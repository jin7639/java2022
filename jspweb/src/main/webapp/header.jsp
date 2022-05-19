<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자지정 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<!-- 폰트어썸 -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<%String loginid = (String)session.getAttribute("login");	//세션호출 %>
	
	
	<div class="container">
		<div class="py-3">
			<div class="row">
				<div class="col-md-4">
					<a href="/jspweb/main.jsp" class="header_logo">EZEN SHOP</a>
				</div>
				<div class="col-md-4 offset-4 d-flex justify-content-end">
					<ul class="nav">
						<!-- 로그아웃 상태 -->
						<% if (loginid == null){ %>
							<li><a href="/jspweb/member/login.jsp" class="header_topmenu">로그인</a></li>
							<li><a href="/jspweb/member/signup.jsp" class="header_topmenu">회원가입</a></li>
						<%} %>
						<!-- 로그인 상태 -->
						<% if (loginid != null) {%>
							<li><span class="header_topmenu"><%=loginid%>님</span></li>
							<li><a href="/jspweb/logout" class="header_topmenu">로그아웃</a></li>
							<li><a href="/jspweb/member/myshopping.jsp" class="header_topmenu">나의쇼핑</a></li>
						<!-- 로그인 된 아이디가 admin이면 -->
							<% if (loginid.equals("admin")) {%>
							<li><a href="/jspweb/admin/dashboard.jsp" class="header_topmenu">관리자</a></li>
						
						<%} }%>
							<li><a href="/jspweb/board/boardlist.jsp?key=&keyword=" class="header_topmenu">자유게시판</a></li>
					</ul>
				</div>
			</div>
		</div>
	<!-- 공통 -->
		<div class="navbar navbar-expand-md navbar-light bg-white">
			<ul class="navbar-nav col-md-12 justify-content-between">
				<li class="nav-item"><a href="#" style="color: #030066">BIGSIZE!</a></li>
				<li class="nav-item"><a href="#" style="color: #00d8f0">MUSCLE-FIT</a></li>
				<li class="nav-item"><a href="#" style="color: #0100ff">1+1이벤트</a></li>
				<li class="nav-item dropdown">
					<a href="#">아우터</a> <!-- data-bs-toggle="dropdown" : 해당 태그를 클릭했을때 드랍다운 열기 -->
					<!-- Drop Down -->
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">패딩, 점퍼</a>
						<a class="dropdown-item" href="#">코트</a>
						<a class="dropdown-item" href="#">재킷</a>
						<a class="dropdown-item" href="#">가디건</a>
						<a class="dropdown-item" href="#">HANDMADE</a>
						<a class="dropdown-item" href="#">양털, 아노락, 후드집업</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a href="#">상의</a> 
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">니트</a>
						<a class="dropdown-item" href="#">가디건</a>
						<a class="dropdown-item" href="#">셔츠</a>
						<a class="dropdown-item" href="#">티셔츠</a>
						<a class="dropdown-item" href="#">후드, 맨투맨</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a href="#">바지</a> 
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">청바지</a>
						<a class="dropdown-item" href="#">슬랙스, 치노팬츠</a>
						<a class="dropdown-item" href="#">밴딩팬츠, 조거팬츠</a>
						<a class="dropdown-item" href="#">반바지</a>
					</div>
				</li>
				<li class="nav-item"><a href="#">슈즈</a></li>
				<li class="nav-item"><a href="#">악세사리</a></li>
				<li class="nav-item"><a href="/jspweb/bluemarble.jsp">BEST</a></li>
				<li class="nav-item"><a href="/jspweb/teamchatting.jsp">트레이닝</a></li>
				<li class="nav-item"><a href="#" style="color: #ffbb00">모델처럼입자!</a></li>
				<li class="nav-item"><a href="#" style="color: #ff0000">50% 할인</a><br></li>
				<li class="nav-item"><input type="text" class="header_input" size="13"></li>
				<li class="nav-item"><a href="#"><i class="fas fa-search"></i></a></li>
				<li class="nav-item"><a href="/jspweb/product/productcart.jsp">장바구니<span class="shoppingbox">3</span></a></li>
			</ul>
			
		</div>
		
	</div>
	
	
	<!-- 사용자지정 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>