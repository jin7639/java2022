<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- ���[����] �������� jsp -->
	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline">���� ��</h3>
	
	
	<!-- ��ư -->
	<div>
		<a href="boardilst.jsp"><button class="btn btn-outline-info">���</button></a>
		<a href="boardilst.jsp"><button class="btn btn-outline-info">����</button></a>	<!-- �ۼ��ڸ� ���� [��ȿ�� �˻�] -->
		<a href="boardilst.jsp"><button class="btn btn-outline-info">����</button></a>	<!-- �ۼ��ڸ� ���� [��ȿ�� �˻�] -->
		<a href="boardilst.jsp"><button class="btn btn-outline-info">�亯</button></a> <!-- �����ڸ� ���� [��ȿ�� �˻�]-->
	</div>
	<!-- �ۼ��ڰ� �Է��� ���� -->
	<div>
		<div>
			<span>�ۼ���</span>
			<span>���缮</span>
		</div>
		<div>
			<span>���ǳ�¥</span>
			<span>2022-04-24 10:10</span>
		</div>
	</div>
	<div>
		<input type="text" value="���ǵ����"class="form-control" readonly="readonly">
		<br>
	</div>
	<div>
		<textarea rows="10" cols="" class="form-control" readonly="readonly" style="resize:none">ȯ�ҹ���</textarea>
	</div>
	<div class="row my-4"> <!-- ÷�ε� ���� -->
		<h4>÷�λ���</h4>
		<div class="col-md-3">
			<img alt="" src="img/item (1).gif" width="100%">
		</div>
		<div class="col-md-3">
			<img alt="" src="img/item (1).gif" width="100%">
		</div>
		<div class="col-md-3">
			<img alt="" src="img/item (1).gif" width="100%">
		</div>
		<div class="col-md-3">
			<img alt="" src="img/item (1).gif" width="100%">
		</div>
	</div>
	
	<!-- �����ڰ� �亯�� ���� -->
	<div>
		<textarea rows="" cols="" class="form-control" readonly="readonly" style="resize:none"></textarea>
	</div>
	</div>
	<br><br><br><br><br><br><br><br>
	<!-- Ǫ��[����] �������� jsp -->
	<%@include file="footer.jsp" %>
</body>
</html>