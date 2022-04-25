<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	
</head>
<body>
	<!-- ���� ��ġ�� �ٸ� ���� �����ϱ� -->
	<%@include file="header.jsp" %>
	<div id="cs" class="carousel slide start" data-bs-ride="carousel" data-bs-interval="3000">
		<!-- ĳ���� �ε������� -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button type="button" data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#cs" data-bs-slide-to="2"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active"><img alt="" src="img/mainimg (1).jpg"></div>
			<div class="carousel-item"><img alt="" src="img/mainimg (2).jpg"></div>
			<div class="carousel-item"><img alt="" src="img/mainimg (3).jpg"></div>
		</div>
		<!-- �̹��� �̵� ��ư -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div> <!-- ĳ���� end -->
	<br>
	<div class="container text-center">
		<hr> <!-- �Ǽ� �±� -->
		<h3>New ARRIVAL</h3>
		<p>�Ż�ǰ</p>
	</div>	
	
	<div class="container">
		<div class="row">
		<% for(int i = 0 ; i<8; i++) { %>
			<div class="col-md-3">
				<div class="card"> <!-- ī������ -->
					<img class="card-img-top" alt="" src="img/item (1).gif"> <!-- �̹��� -->
					<div class="card-body">
						<p class="item">
							<span class="title">��Ű ���� ���� ���̵� ������</span>
							<br>
							<span class="content">���ϸ��� ���� �� �Ż� 10% ����</span>
							<br>
							<span class="price">34,800��</span> 
							<span class="price_now"> 31,300��</span> 
							<br>
							<span class="badge bg-info text-dark">����:1,382��</span>
							<span class="badge bg-warning text-dark">�ֹ� ����</span>
						</p>
					</div>
				</div>
			</div>
			<% } %>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>