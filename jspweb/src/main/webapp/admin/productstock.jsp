<%@page import="dao.ProductDao"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품 재고</h3>

	카테고리	
	<select id="categorybox"><!-- 카테고리이 출력되는 부분 -->
	</select>
	
	 제품 목록
	<select id="productbox"><!-- 제품 목록이 출력되는 부분 -->
	</select>
	<form style="display: none" id="stockaddform">
		색상 <input type="text" id="scolor">
		사이즈 <input type="text" id="ssize">
		수량 <input type="text" id="samount">
		<button type="button" onclick="stockadd()">재고추가</button>
	</form>
	<table class="table" id="stocklistbox">
		
	</table>
	<script src="/jspweb/js/productstock.js" type="text/javascript"></script>
</body>
</html>