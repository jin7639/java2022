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
		<div class="col-md-2 sidemenu"> <!-- ���̵�� �޴� -->
			<%@include file="sidebar.jsp" %>
		</div> <!-- ���̵�� end -->
		<div class="col-md-10 offset-2 content"> <!-- ���� -->
			<div class="container loginbox offset-4">
				<h2 class="text-center">LOGIN</h2>
				<div class="login text-center">
					<form action="">
						<div class="row">
							<div class="col-md-8 logintxt">
								<input class="form-control" type="text" placeholder="���̵�">
								<input class="form-control"type="password" placeholder="��й�ȣ">
							</div>
							<div class="col-md-4">
								<button type="button" class="btn btn-dark btnlogin">LOGIN</button>
							</div>
							<div class="logincate text-center">
								<span><input type="checkbox">���̵� ���� |</span>
								<span>���̵� ã�� |</span>
								<span>��й�ȣ ã��</span>
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
					<p>��ȸ���� ���, �ֹ����� �ֹ���ȣ�� �ֹ���ȸ�� �����մϴ�.</p>
					<div class="row nologinrow">
						<div class="col-md-6">�ֹ��ڸ�</div>
						<div class="col-md-6">
							<input type="text">
						</div>
					</div>
					<div class="row nologinrow">
						<div class="col-md-6">�ֹ���ȣ</div>
						<div class="col-md-6">
							<input type="text" placeholder="������(-) ����">
						</div>
					</div>
					<div class="row nologinrow">
						<div class="col-md-6">��ȸ���ֹ� ��й�ȣ</div>
						<div class="col-md-6">
							<input type="text">
						</div>
					</div>
					<div>
						<button type="button" class="btn btn-outline-secondary">��ȸ�� �α���</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div> <!-- ���̵��, ���� row -->
	
	<%@include file="footer.jsp" %>

		
	
	
</body>
</html>