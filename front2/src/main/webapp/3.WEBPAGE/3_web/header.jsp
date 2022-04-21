<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		li {
			list-style-type: none;
		}
		a{
			text-decoration: none;
			color: black;
		}
		#header {
			height: 50px;
		}
		#box {
			width: 1100px;
			margin: 0 auto;
		}
		#logo {
			float: left;
			font-size: 30px;
			font-weight: bold;
		}
		#header_menu {
			float: right;
		}
		#header_menu li {
			display: inline;
			margin-left: 30px;
		}
		#header_menu ul {
			margin-top: 10px;
			
		}
		#blue {
			color: blue;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="box">
			<div id="logo">
				<span id="blue">THE</span>
				<span> 스튜디오</span>
			</div>
			<div id="header_menu">
				<ul>
					<li><a href="#">스튜디오 소개</a></li>
					<li><a href="#">스튜디오 예약</a></li>
					<li><a href="#">블로그</a></li>
					<li><a href="#">포토 갤러리</a></li>
					<li><a href="#">오시는 길</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>