<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<!-- ��Ʈ��Ʈ�� css���� -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- ����ڰ� ������ css ���� -->
	<link href="css/main.css" rel="stylesheet">
	<!-- fontawesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<div class=" fixed-top bg-white">
		<div class="container">
			<div class="py-3"> <!-- ��� �޴� -->
			<!-- p: padding py: padding y�� -->
				<div class="row"> <!-- ���� ��ġ -->
					<div class="col-md-4 offset-4 text-center">	<!-- �ΰ� -->
										<!-- text-center : �ڽ��� �� ���빰�� ��� ���� -->
						<a href="main.jsp" class="header_logo">��ü�� �帲</a> <!-- ��ũ -->
					</div>
					<div class="col-md-4 d-flex justify-content-end"> <!-- ��� �޴� -->
						<ul class="nav">
							<li><a href="#">�α���</a> |</li>
							<li><a href="signup.jsp">ȸ������</a> |</li>
							<li><a href="#">��ٱ���</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="navbar navbar-expand-md navbar-light bg-white"> <!-- �� �޴� -->
				<!-- ������ �޴� ��ġ�� ��ư -->
				<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcl">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navcl">
					<ul class="navbar-nav col-md-12 justify-content-between">
						<li class="nav-item"><a href="#" class="nav-link">����Ʈ ��ǰ</a></li>
						<li class="nav-item"><a href="#" class="nav-link">����ǰ</a></li>
						<li class="nav-item"><a href="#" class="nav-link">�ƿ���</a></li>
						<li class="nav-item"><a href="#" class="nav-link">����</a></li>
						<li class="nav-item"><a href="#" class="nav-link">��Ʈ</a></li>
						<li class="nav-item"><a href="#" class="nav-link">����</a></li>
						<li class="nav-item"><a href="#" class="nav-link">�Ź�</a></li>
						<li class="nav-item"><a href="#" class="nav-link">�Ǽ��縮</a></li>
						<li class="nav-item"><a href="#" class="nav-link">����</a></li>
						<li class="nav-item"><a href="#" class="nav-link">��Ÿ��</a></li>
						<li class="nav-item"><a href="boardlist.jsp" class="nav-link">������</a></li>
						<li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-search"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- ��Ʈ��Ʈ�� JS���� -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>