<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- SUMMERNOTE - 게시판 API -->
	<!-- 썸머노트 부트스트랩 3버전 -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- include summernote css -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   
</head>
<body>
	<%@include file="../header.jsp" %>
	<%
		int bno = Integer.parseInt(request.getParameter("bno"));
		Board board = BoardDao.getBoardDao().getboard(bno);
		%>
	
	<div class="container">
	<a href="boardlist.jsp"><button>글목록</button></a>
		<h3>글쓰기</h3>
		<hr>
		<form action="../board/update?bno=<%=board.getBno() %>" method="post" enctype="multipart/form-data">
			<!-- form 전송 인코딩 타입 : 기본타입은 첨부파일 불가능 -->
			<!-- form 첨부파일 전송 인코딩 타입 : enctype="multipart/form-data" -->
			제목 : <input type="text" name="btitle" value="<%=board.getBtitle()%>">
			내용 : <textarea rows="" cols="" id="summernote" name="bcontent">
			<%=board.getBcontent()%>
			</textarea>
			<%if(board.getBfile() != null){ %>
			첨부파일 : <%=board.getBfile()%> 
			<button type="button" onclick="filedelete(<%=board.getBno()%>)">파일삭제</button>
			 <%} %>
			<!-- 
			 첨부파일(여러개) : <input type="file" multiple="multiple">
			 -->
			<input type="file" name="bfile">
			 
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