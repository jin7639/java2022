<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<%@include file="header.jsp" %>
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- 사이드바 메뉴 -->
			<%@include file="sidebar.jsp" %>
		</div> <!-- 사이드바 end -->
		<div class="col-md-10 offset-2 content"> <!-- 본문 -->
			<div class="container loginbox offset-4">
				<h2 class="text-center">LOGIN</h2>
				<div class="login text-center">
					<form action="">
						<div class="row">
							<div class="col-md-8 logintxt">
								<input class="form-control" type="text" placeholder="아이디">
								<input class="form-control"type="password" placeholder="비밀번호">
							</div>
							<div class="col-md-4">
								<button type="button" class="btn btn-dark btnlogin">LOGIN</button>
							</div>
							<div class="logincate text-center">
								<span><input type="checkbox">아이디 저장 |</span>
								<span>아이디 찾기 |</span>
								<span>비밀번호 찾기</span>
							</div>
						</div>
					</form>
				</div>
				<div class="join">
					<ul class="row">
						<li class="col-md-5 btnsns"><a href="#"><img alt="" src="img/btn_naver_login.gif"></a></li>
						<li class="col-md-5 btnsns"><a href="#"><img alt="" src="img/btn_facebook_login.gif"></a></li>
						<li class="col-md-5 btnsns"><a href="#"><img alt="" src="img/btn_kakao_login.gif"></a></li>
						<li class="col-md-5 btnsns"><a href="#"><img alt="" src="img/btn_apple_login.gif"></a></li>
					</ul>
					<button type="button" class="btn btn-secondary btnsnslogin ">JOIN US</button>
				</div>
				<div class="nologin">
					<p>비회원의 경우, 주문시의 주문번호로 주문조회가 가능합니다.</p>
					<div class="row nologinrow">
						<div class="col-md-6">주문자명</div>
						<div class="col-md-6">
							<input type="text">
						</div>
					</div>
					<div class="row nologinrow">
						<div class="col-md-6">주문번호</div>
						<div class="col-md-6">
							<input type="text" placeholder="하이픈(-) 포함">
						</div>
					</div>
					<div class="row nologinrow">
						<div class="col-md-6">비회원주문 비밀번호</div>
						<div class="col-md-6">
							<input type="text">
						</div>
					</div>
					<div>
						<button type="button" class="btn btn-outline-secondary">비회원 로그인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div> <!-- 사이드바, 메인 row -->
	
	<%@include file="footer.jsp" %>

		
	
	
</body>
</html>