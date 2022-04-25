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
	
	<div class="container"> <!-- 본문 -->
		<h3 class="text-centera">문의 글쓰기</h3>
		<form action="#" method="get"> <!-- 폼 양식 [입력 받을 전송가능] -->
		<div class="row">
			<div class="col-md-3">
				작성자 : <input type="text" class="form-control">
			</div>
			<div class="col-md-3">
				비밀번호 : <input type="password" class="form-control">
			</div>	
		</div>	
		<div class="row">
			<div class="col-md-8">
				제목 : <input type="text"  class="form-control" placeholder="제목을 작성해주세요" max="50">			
			</div>
		</div>
			내용 : <textarea rows="20" cols="" class="form-control"></textarea>
			
			<div class="row">
				<div class="col-md-3">
					첨부파일 : <input type="file" class="form-control">
				</div>
			</div>
			<div class="col-md-4 offset-4 row">
			<div class="col-md-4">
				<input type="submit" value="등록" class="form-control">
			</div>
			<div class="col-md-4">
			<input type="reset" value="다시 쓰기" class="form-control">
			</div>
			<div class="col-md-4">
				<a href="boardlist.jsp"><button  class="form-control">목록</button></a>
			</div>
			
			</div>
		</form>
		
	</div>	
	<br><br><br><br><br><br><br><br>
	<!-- 푸터[파일] 가져오기 jsp -->
	<%@include file="footer.jsp" %>
</body>
</html>