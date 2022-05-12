<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품등록 페이지</h3>
	<form action="productadd" method="post" enctype="multipart/form-data">
		제품명 <input type="text" id="pname" name="pname" placeholder="제품명"><br>
		가격 <input type="text" id="pprice" name="pprice" placeholder="가격"><br>
		할인율 <input type="text" id="pdiscount" name="pdiscount" placeholder="할인율"><br>
		카테고리 <button onclick="categorybtn()" type="button">카테고리추가</button><br>
		<div id="categoryinput"></div>
		<div id="categorybox"></div><!-- *DB에 저장된 카테고리 radio버튼으로 표시 [ DB -> java 서블릿 -> JS -> HTML] -->
		대표이미지 <input type="file" id="pimg" name="pimg"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	<script src="/jspweb/js/productadd.js" type="text/javascript"></script>
</body>
</html>