<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/productadd.css" rel="stylesheet">
</head>
<body>
	<h3 class="admin_title">제품등록 페이지</h3>
	
	<form id="addform" >
		<div class="row my-2">
			<div class="col-md-2">
				<span>제품명</span>
			</div>
			<div class="col-md-5">
				<input class="form-control" type="text" id="pname" name="pname" placeholder="제품명">
			</div>
		</div>
		<div class="row my-2">
			<div class="col-md-2">
				<span>가격</span>
			</div>
			<div class="col-md-5">
				<input class="form-control"  type="text" id="pprice" name="pprice" placeholder="가격">
			</div>
		</div>
		<div class="row my-2">
			<div class="col-md-2">
				<span>할인율</span>
			</div>
			<div class="col-md-5">
				<input class="form-control"  type="text" id="pdiscount" name="pdiscount" placeholder="할인율">
			</div>
		</div>
		<div class="row my-2">
			<div class="col-md-2">
				<span>카테고리</span>
			</div>
			<div class="col-md-5">
				<button class="form-control"  onclick="categorybtn()" type="button">카테고리추가</button>
			</div>
		</div>
		
		<div class="row col-md-5 offset-2 my-2" id="categoryinput"></div>
		<div class="col-md-5 offset-2 my-2" id="categorybox"></div><!-- *DB에 저장된 카테고리 radio버튼으로 표시 [ DB -> java 서블릿 -> JS -> HTML] -->
		<div class="row">
			<div class="col-md-2">
				<span>대표이미지</span>
			</div>
			<div class="col-md-5">
				<input class="form-control" type="file" id="pimg" name="pimg">
			</div>
		</div>
		<div class="row my-2">
			<div class=" col-md-1">
				<button class="form-control" type="button" onclick="productadd()">등록</button>
			</div>
			<div class=" col-md-1">
				<input class="form-control col-md-1" type="reset" value="취소">
			</div>
		</div>
	</form>
	<div class="col-md-4">
		<h5>대표이미지 미리보기</h5>
		<img id="preview" width="100%">
	</div>
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>
</body>
</html>