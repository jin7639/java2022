<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Form</title>
</head>
<body>
<%@include file="1_��ġ.jsp" %>
	<form>	<!-- �⺻ form -->
		<label>�̸�</label>
		<input type="text" placeholder="�̸�">
		<label>�̸���</label>
		<input type="text" placeholder="�̸���">
		<button type="submit">Ȯ��</button>
	</form>
	
	<form>	<!-- ��Ʈ��Ʈ�� form -->
		<div class="form-group"> <!-- ��Ʈ�� ���� -->
			<label>�̸�</label>
			<input class="form-control" type="text" placeholder="�̸�">
		</div>
		<div class="form-group">
			<label>�̸���</label>
			<input class="form-control" type="text" placeholder="�̸���">
		</div>
		<div class="form-group">
			<button type="submit">Ȯ��</button>
		</div>
	</form>
	
	<!-- form-control : ��Ʈ�� ���� -->
	<input type="text" class="form-control">
	<input type="password" class="form-control">
	<input type="datetime-local" class="form-control">
	<textarea rows="5" cols="15"></textarea>
	<div class="form-check">
		<input type="checkbox" class="form-check-input">
		<label class="form-check-label" for="exampleCheck1">üũüũ</label>
	</div>
	<div class="form-check">
 		 <input class="form-check-input" type="radio" >
 		 <label class="form-check-label" >radio ��ư</label>
	</div>
	<div class="container row">
		<div class="col-md-2"><input type="text" class="form-control"></div>
		<div class="col-md-2 offset-3"><input type="text" class="form-control"></div>
		<div class="col-md-2 offset-3"><input type="text" class="form-control"></div>
	</div>
	
	<button type="button" class="btn btn-primary">Button</button>
	<button type="button" class="btn btn-success">Button</button>
	<button type="button" class="btn btn-danger">Button</button>
	<button type="button" class="btn btn-outline-primary">Button</button>
	<button type="button" class="btn btn-outline-dark">Button</button>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img alt="" src="../img/������.jpg" width="100%" class="rounded">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/������.jpg" width="100%" style="border-radius: 20px">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/������.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/������.jpg" width="100%">
			</div>
		</div>
	</div>
</body>
</html>