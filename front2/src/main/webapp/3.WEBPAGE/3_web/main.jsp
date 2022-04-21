<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#main {
			clear: both;
		}
		.main_top {
			float: left;
			width: 540px;
			margin-bottom: 100px;
		}
		.main_top_txt {
			display: inline;
			width: 400px;
			float: right;
			margin-right: 30px;
			line-height: 180%
		}
		#main_bottom {
			margin-bottom: 100px;
		}
		.studio_items {
			display: inline;
			float: left;
			width: 270px;
			margin-bottom: 100px;
		}
		.studio {
			font-weight: bold;
		}
		.studio_items img {
			width: 270px;
		}
		
	</style>
</head>
<body>
	<div id="main">
		<div id="box">
			<div id="main_top" >
				<div id="top_left" class="main_top">
					<img src="img/icon1.png">
					<div class="main_top_txt">
						<h3>예약 안내</h3>
						<p>스튜디오 대여는 사전에 인터넷 예약을 하셔야 합니다.
						예약은 1일 이전까지 가능합니다.</p>
					</div>
				</div>
				<div id="top_right" class="main_top">
					<img src="img/icon2.png">
					<div class="main_top_txt">
						<h3>포토 갤러리</h3>
						<p>취업사진, 가족 사진, 프로필 사진, 우정 사진 등 개인 또는 단체가 이용할 수 있습니다.</p>
					</div>
				</div>
			</div>
			<div id="main_bottom">
				<ul class="studio_items">
					<li><img alt="" src="img/image1.jpg"></li>
					<li class="studio">촬영 스튜디오</li>
					<li class="detail">카메라, 조명 등 촬영 장비 완비</li>
				</ul>
				<ul class="studio_items">
					<li><img alt="" src="img/image2.jpg"></li>
					<li class="studio">촬영 스튜디오</li>
					<li class="detail">카메라, 조명 등 촬영 장비 완비</li>
				</ul>
				<ul class="studio_items">
					<li><img alt="" src="img/image3.jpg"></li>
					<li class="studio">촬영 스튜디오</li>
					<li class="detail">카메라, 조명 등 촬영 장비 완비</li>
				</ul>
				<ul class="studio_items">
					<li><img alt="" src="img/image4.jpg"></li>
					<li class="studio">촬영 스튜디오</li>
					<li class="detail">카메라, 조명 등 촬영 장비 완비</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>