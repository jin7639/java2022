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
	<!-- ��� -->
	<%@include file="header.jsp" %>
	<!-- ��� �̹��� -->
	<%@include file="mainimg.jsp" %>
	<!-- ���� -->
	<h3>�α���</h3>
	<div class="content">
		<table>
			<tr>
				<td>���̵�</td>
				<td><input class="textinput" type="text"></td>
				<td rowspan="2"><input class="btnlogin" type="button" value="�α���"> </td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input class="textinput" type="password"></td>
			</tr>
		</table>
	</div>
	<!-- Ǫ�� -->
	<%@include file="footer.jsp" %>
</body>
</html>