<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<!-- SUMMERNOTE - 게시판 API -->
	<!-- 썸머노트 부트스트랩 3버전 -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- include summernote css -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<div class="row topbtn d-flex justify-content-end">
			<div class="col-md-1">
				<a href="boardlist.jsp"><button class="form-control">목록</button></a>
			</div>
		</div>
		<h3>글쓰기</h3>
		<hr>
		<form action="../board/write" method="post" enctype="multipart/form-data">
			<!-- form 전송 인코딩 타입 : 기본타입은 첨부파일 불가능 -->
			<!-- form 첨부파일 전송 인코딩 타입 : enctype="multipart/form-data" -->
			제목  <input type="text" name="btitle" class="form-control mb-4">
			<textarea rows="" cols="" id="summernote" name="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile">
			<!-- 
			 첨부파일(여러개) : <input type="file" multiple="multiple">
			 -->
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</div>
	<!-- include summernote css/js -->
	 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	 <!-- 썸머노트 부트스트랩 3버전 -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    <!-- 사용자정의 js -->
    <script src="/jspweb/js/board.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>