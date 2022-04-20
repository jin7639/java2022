<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#content {
			width: 1150px;
			margin: 0 auto;
		}
		h3 {
			text-align: center;
		}
		table {
			margin: 0 auto;
		}
		.textinput {
			height: 30px;
		}
		.btnlogin {
			width: 100px;
			height: 80px;
		}
	</style>
</head>
<body>
	<!-- 헤더 -->
	<%@include file="header.jsp" %>
	<!-- 헤더 이미지 -->
	<%@include file="mainimg.jsp" %>
	<!-- 본문 -->
	<h3>로그인</h3>
	<div class="content">
		<table>
			<tr>
				<td>아이디</td>
				<td><input class="textinput" type="text"></td>
				<td rowspan="2"><input class="btnlogin" type="button" value="로그인"> </td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input class="textinput" type="password"></td>
			</tr>
		</table>
	</div>
	<!-- 푸터 -->
	<%@include file="footer.jsp" %>
</body>
</html>