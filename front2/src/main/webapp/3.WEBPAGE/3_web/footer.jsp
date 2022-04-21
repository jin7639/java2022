<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#footer {
			clear: both;
			background-color: #292c32;
			color: white;
			height: 250px;
		}
		#footer_1, #footer_2, #footer_3 {
			display: inline;
			float: left;
			margin: 50px 0px;
		}
		#footer_1 {
			width: 350px;
		}
		#footer_2 {
			width: 550px;
		}
		#footer_3 {
			width: 150px;
		}
		#footer_3 li {
			float: left;
			margin-left: 5px;
		}
		.footer_1_title {
			font-weight: bold;
		}
		.tel {
			font-size: 30px;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<div id="footer">
		<div id="box">
			<div id="footer_1">
				<ul>
					<li class="footer_1_title">고객 센터</li>
					<li class="tel">Tel : 1588 - 1588</li>
				</ul>
			</div>
			<div id="footer_2">
				<ul>
					<li>회사소개 | 개인정보처리방침 | 이용약관 | 제휴안내</li>
					<li>주소 : 경기도 용인시 수지구 정평로 123</li>
					<li>email : photo@korea.com</li>
					<li>COPYRIGHT @2021 The 스튜디오. ALL RIGHT RESERVED.</li>
				</ul>
			</div>
			<div id="footer_3">
				<ul>
					<li><img alt="" src="img/facebook.png"></li>
					<li><img alt="" src="img/blog.png"></li>
					<li><img alt="" src="img/instagram.png"></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>