<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테이블</title>
</head>
<body>
	<%@include file="1_설치.jsp" %>
	
	<table>	<!-- 기본 테이블 -->
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>2</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>3</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
	</table>
	
	<table class="table">	<!-- 부트스트랩 테이블 -->
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>2</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>3</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
	</table>
	<table class="table table-hover">	<!-- 부트스트랩 테이블 -->
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>2</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>3</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
	</table>
	<table class="table table-hover table-bordered ">	<!-- 부트스트랩 테이블 -->
		<tr class="table-primary"> <!-- 테이블 색상 -->
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>2</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td>3</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
	</table>
	<table class="table table-hover table-bordered ">	<!-- 부트스트랩 테이블 -->
		<tr class="table-primary"> <!-- 테이블 색상 -->
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td><td class="align-bottom">테이블 테스트</td><td>홍길동</td>
		</tr>
		<tr>
			<td >2</td><td >This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.</td><td>홍길동</td>
		</tr>
		<tr>
			<td>3</td><td>테이블 테스트</td><td>홍길동</td>
		</tr>
	</table>
</body>
</html>