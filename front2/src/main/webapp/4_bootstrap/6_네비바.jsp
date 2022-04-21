<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Nav bar</title>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	<div class="container">
		<div class="navbar navbar-expand-md">
		<a href="#" class="navbar-brand">로고</a>
		<!-- 메뉴 사이즈 작아지는 경우 -->
			<button class="navvar-toggler btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu" 				aria-controls="navbar-contents" aria-expanded="false"  aria-label="Toggle navigation">
				<span class="navvar-toggler-icon ">버튼</span>
			</button>			
			<div class="collapse navbar-collapse" id="navmenu"> <!-- md 기준 화면크기 760px이하가 되면 메뉴 사라짐 -->
				<ul class="navbar-nav"> <!-- 네비게이션 목록 -->
					<li class="nav-item"><a href="#" class="nav-link">메뉴1</a></li>
					<li class="nav-item"><a href="#" class="nav-link">메뉴2</a></li>
					<li class="nav-item"><a href="#" class="nav-link">메뉴3</a></li>
					<li class="nav-item dropdown"><!-- 드롭다운 메뉴 -->
						<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Dropdowns</a>
						
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">드롭다운 메뉴1</a>
							<a href="#" class="dropdown-item">드롭다운 메뉴2</a>
							<a href="#" class="dropdown-item">드롭다운 메뉴3</a>
						</div>
					</li>
				</ul> <!-- 네비게이션 목록 끝 -->
				
				<form action="">
					<div class="row">
						<div class="col-md-7">
						<input type="text" class="form-control" placeholder="검색어">
						</div>
						<div class="col-md-5">
						<button class="btn btn-info" type="submit">검색</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>