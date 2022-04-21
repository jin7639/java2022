<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Form</title>
</head>
<body>
<%@include file="1_설치.jsp" %>
	<form>	<!-- 기본 form -->
		<label>이름</label>
		<input type="text" placeholder="이름">
		<label>이메일</label>
		<input type="text" placeholder="이메일">
		<button type="submit">확인</button>
	</form>
	
	<form>	<!-- 부트스트랩 form -->
		<div class="form-group"> <!-- 컨트롤 묶음 -->
			<label>이름</label>
			<input class="form-control" type="text" placeholder="이름">
		</div>
		<div class="form-group">
			<label>이메일</label>
			<input class="form-control" type="text" placeholder="이메일">
		</div>
		<div class="form-group">
			<button type="submit">확인</button>
		</div>
	</form>
	
	<!-- form-control : 컨트롤 형식 -->
	<input type="text" class="form-control">
	<input type="password" class="form-control">
	<input type="datetime-local" class="form-control">
	<textarea rows="5" cols="15"></textarea>
	<div class="form-check">
		<input type="checkbox" class="form-check-input">
		<label class="form-check-label" for="exampleCheck1">체크체크</label>
	</div>
	<div class="form-check">
 		 <input class="form-check-input" type="radio" >
 		 <label class="form-check-label" >radio 버튼</label>
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
				<img alt="" src="../img/강아지.jpg" width="100%" class="rounded">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%" style="border-radius: 20px">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
			<div class="col-md-3">
				<img alt="" src="../img/강아지.jpg" width="100%">
			</div>
		</div>
	</div>
</body>
</html>