<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	
		/* ��ũ ��ũ ���� �⺻�� ����*/
		a {
			text-decoration: none;
			color: black;
		}
		a:hover {
			color: orange;
		}
		#header {
		width: 1150px;
		margin: 0 auto;
		height: 100px;
		}
		#logo {
			float: left;
			margin: 20px 0 0 20px;
		}
		#menus {
			float: right;
		}
		#top_menu {
			text-align: right;
			margin-top: 20px;
		}
		#main_menu {
			margin-top: 20px;
			font-family: "�ü�";
			font-size: 20px;
		}
		#main_menu li{
			display: inline;
			margin-left: 80px;
		}
		
	</style>
</head>
<body>
	<div id="header">
		<div> <!-- �ΰ� -->
			<a href="index.jsp"><img id="logo" alt="" src="img/logo.png"></a>
		</div> 
		<div id="menus"><!-- �޴� -->
			<div id="top_menu">
				<a href="login.jsp">�α���</a> | 
				<a href="signup.jsp">ȸ������</a> | 
				<a href="board.jsp">��������</a> 
			</div>
			<ul id="main_menu">
				<li><a href="#">�����̷�</a></li>
				<li><a href="#">��������</a></li>
				<li><a href="#">�����۰�</a></li>
				<li><a href="#">������1</a></li>
				<li><a href="#">������2</a></li>
			</ul>
		</div> 
	</div>
</body>
</html>