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
	
	<div class="container"> <!-- ���� -->
		<h3 class="text-centera">���� �۾���</h3>
		<form action="#" method="get"> <!-- �� ��� [�Է� ���� ���۰���] -->
		<div class="row">
			<div class="col-md-3">
				�ۼ��� : <input type="text" class="form-control">
			</div>
			<div class="col-md-3">
				��й�ȣ : <input type="password" class="form-control">
			</div>	
		</div>	
		<div class="row">
			<div class="col-md-8">
				���� : <input type="text"  class="form-control" placeholder="������ �ۼ����ּ���" max="50">			
			</div>
		</div>
			���� : <textarea rows="20" cols="" class="form-control"></textarea>
			
			<div class="row">
				<div class="col-md-3">
					÷������ : <input type="file" class="form-control">
				</div>
			</div>
			<div class="col-md-4 offset-4 row">
			<div class="col-md-4">
				<input type="submit" value="���" class="form-control">
			</div>
			<div class="col-md-4">
			<input type="reset" value="�ٽ� ����" class="form-control">
			</div>
			<div class="col-md-4">
				<a href="boardlist.jsp"><button  class="form-control">���</button></a>
			</div>
			
			</div>
		</form>
		
	</div>	
	<br><br><br><br><br><br><br><br>
	<!-- Ǫ��[����] �������� jsp -->
	<%@include file="footer.jsp" %>
</body>
</html>