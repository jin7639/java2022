<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더[파일] 가져오기 jsp -->
	<%@include file="header.jsp" %>
	
	<br><br><br><br><br><br><br><br>
	<div class="container "> <!-- container : 박스권 -->
		<h3>고객센터</h3>
		<div class="col-md-5 offset-7  row g-0 my-4">
			<div class="col-md-3">
				<select class="form-select">
					<option>키워드</option>
					<option>번호</option>
					<option>제목</option>
					<option>작성자</option>
				</select>
			</div>
			<div class="col-md-6">
				<input type="text" class="form-control">
			</div>
			<div class="col-md-3">
				<button class="form-control">검색</button>
			</div>
		</div>
		<div>
			<table class="table table-hover"> <!-- 테이블테그 -->
				<tr class="text-center">	<!-- 행 태그 -->
					<th>번호</th>
					<th>문의상태</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<tr>
					<td>4</td><td>접수</td><td><a href="boardview.jsp">환불해주세요</a></td><td>유재석</td><td>2022-01-25</td>
				</tr>
				<tr>
					<td>3</td><td>처리</td><td>사이즈문의</td><td>유재석</td><td>2022-01-25</td>
				</tr>
				<tr>
					<td>4</td><td>접수</td><td>환불해주세요</td><td>유재석</td><td>2022-01-25</td>
				</tr>
				<tr>
					<td>1</td><td>처리</td><td>주소변경문의</td><td>유재석</td><td>2022-01-25</td>
				</tr>
			</table>
			<div class="row">
				<div class="col-md-4 offset-4 my-3">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">이전</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">다음</a></li>
					</ul>
				</div>
				<div class="col-md-2 offset-2 my-3">
					<a href="boardwrite.jsp"><button class="form-control">문의하기</button></a>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br><br>
	
	<!-- 푸터[파일] 가져오기 jsp -->
	<%@include file="footer.jsp" %>
</body>
</html>