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
	
	<div class="container">
		<h3 class="text-center titleline">문의 글</h3>
	
	
	<!-- 버튼 -->
	<div>
		<a href="boardilst.jsp"><button class="btn btn-outline-info">목록</button></a>
		<a href="boardilst.jsp"><button class="btn btn-outline-info">삭제</button></a>	<!-- 작성자만 가능 [유효성 검사] -->
		<a href="boardilst.jsp"><button class="btn btn-outline-info">수정</button></a>	<!-- 작성자만 가능 [유효성 검사] -->
		<a href="boardilst.jsp"><button class="btn btn-outline-info">답변</button></a> <!-- 관리자만 가능 [유효성 검사]-->
	</div>
	<!-- 작성자가 입력한 내용 -->
	<div>
		<div>
			<span>작성자</span>
			<span>유재석</span>
		</div>
		<div>
			<span>문의날짜</span>
			<span>2022-04-24 10:10</span>
		</div>
	</div>
	<div>
		<input type="text" value="문의드려요"class="form-control" readonly="readonly">
		<br>
	</div>
	<div>
		<textarea rows="10" cols="" class="form-control" readonly="readonly" style="resize:none">환불문의</textarea>
	</div>
	<div class="row my-4"> <!-- 첨부된 사진 -->
		<h4>첨부사진</h4>
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
	
	<!-- 관리자가 답변한 내용 -->
	<div>
		<textarea rows="" cols="" class="form-control" readonly="readonly" style="resize:none"></textarea>
	</div>
	</div>
	<br><br><br><br><br><br><br><br>
	<!-- 푸터[파일] 가져오기 jsp -->
	<%@include file="footer.jsp" %>
</body>
</html>