<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		h3 {
			text-align: center;
		}
		li {
			list-style-type: none;
		}
		#join {
			width: 600px;
			margin: 0 auto;
			border-top: solid 2px #eeeeee;
			border-bottom: solid 2px #eeeeee;
			padding: 30px;
		}
		#button {
			margin-top: 20px;
			margin-left: 60%;
		}
		.cols {
			padding: 3px;
		}
		.cols li{
			display: inline-block;
		}
		.col1 {
			width: 150px
		}
		.col2 input {
			width: 200px;
			height: 20px;
		}
		.hello {
			vertical-align:top;
		}
		.button {
			padding: 10px;
		}
	
	</style>

</head>
<body>
	<!-- 헤더 -->
	<%@include file="header.jsp" %>
	<!-- 헤더 이미지 -->
	<%@include file="mainimg.jsp" %>
	<!-- 본문 -->
	<h3>회원 가입 폼</h3>
	<form>
		<ul id="join"> <!-- 전체 -->
			<li>	<!-- 행 tr-->	
				<ul class="cols">
					<li class="col1">아이디</li> <!-- column/td 1 -->
					<li class="col2"><input type="text"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">비밀번호</li>
					<li class="col2"><input type="password"></li>
				</ul>
			
			</li>
			<li>
				<ul class="cols">
					<li class="col1">비밀번호 확인</li>
					<li class="col2"><input type="password"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">이름</li>
					<li class="col2"><input type="text"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">이메일</li>
					<li><input type="text">@
						<select>
							<option> 직접 입력 </option>
							<option> naver.com </option>
							<option> gmail.com </option>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">이메일 수신</li>
					<li >
					<input type="radio" name="email" checked="checked">수신
					<input type="radio" name="email">비수신
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">가입 경로</li>
					<li >
						<input type="checkbox" name="access1">친구추천
						<input type="checkbox" name="access2">인터넷 검색
						<input type="checkbox" name="access3">기타
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1 hello">인사말</li>
					<li><textarea rows="6" cols="40"></textarea>
					</li>
				</ul>
			</li>
		</ul>
	</form>
	<div id="button">
		<input class="button" type="button" value="저장하기">
		<input class="button" type="button" value="취소하기">
	</div>
	<!-- 푸터 -->
	<%@include file="footer.jsp" %>
</body>
</html>