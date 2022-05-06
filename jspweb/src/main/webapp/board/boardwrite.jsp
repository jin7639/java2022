<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- SUMMERNOTE - 게시판 API -->
	<!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
	<a href="boardlist.jsp"><button>글목록</button></a>
		<h3>글쓰기</h3>
		<hr>
		<form action="../board/write" method="get">
			제목 : <input type="text" name="btitle">
			내용 : <input type="text" name="bcontent" id="summernote">
			첨부파일 : <input type="file" name="bfile">
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</div>
	<%@include file="../footer.jsp" %>
	<!-- include summernote css/js -->
	 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <!--  썸머노트 한글 버전 cdn -->
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
    <!-- 사용자정의 js -->
    <script src="/jspweb/js/board.js" type="text/javascript"></script>
</body>
</html>