<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Nav bar</title>
</head>
<body>
	<%@include file="1_��ġ.jsp" %>
	<div class="container">
		<div class="navbar navbar-expand-md">
		<a href="#" class="navbar-brand">�ΰ�</a>
		<!-- �޴� ������ �۾����� ��� -->
			<button class="navvar-toggler btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#navmenu" 				aria-controls="navbar-contents" aria-expanded="false"  aria-label="Toggle navigation">
				<span class="navvar-toggler-icon ">��ư</span>
			</button>			
			<div class="collapse navbar-collapse" id="navmenu"> <!-- md ���� ȭ��ũ�� 760px���ϰ� �Ǹ� �޴� ����� -->
				<ul class="navbar-nav"> <!-- �׺���̼� ��� -->
					<li class="nav-item"><a href="#" class="nav-link">�޴�1</a></li>
					<li class="nav-item"><a href="#" class="nav-link">�޴�2</a></li>
					<li class="nav-item"><a href="#" class="nav-link">�޴�3</a></li>
					<li class="nav-item dropdown"><!-- ��Ӵٿ� �޴� -->
						<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Dropdowns</a>
						
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">��Ӵٿ� �޴�1</a>
							<a href="#" class="dropdown-item">��Ӵٿ� �޴�2</a>
							<a href="#" class="dropdown-item">��Ӵٿ� �޴�3</a>
						</div>
					</li>
				</ul> <!-- �׺���̼� ��� �� -->
				
				<form action="">
					<div class="row">
						<div class="col-md-7">
						<input type="text" class="form-control" placeholder="�˻���">
						</div>
						<div class="col-md-5">
						<button class="btn btn-info" type="submit">�˻�</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>