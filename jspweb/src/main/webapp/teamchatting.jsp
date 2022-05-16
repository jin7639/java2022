<%@page import="dao.ChattingDao"%>
<%@page import="dto.Chatting"%>
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
	<%@include file="header.jsp" %>
	<div class="container my-5">
		<h3> 비회원제 실시간 채팅 페이지[ 소켓X 게시판형식O] </h3>
		<div class="col-md-4 offset-4">
		
			<div>
				접속된 IP : 
				<span id="ip"><%=request.getRemoteAddr() %></span>
				
			</div>
			<!-- overflow-y:scroll    div에 스크롤 만들기  -->
			<div id="contentlist" style="border: 1px solid black; height: 500px; overflow-y:scroll">
				* 채팅 내용이 표시되는 구역
				
			</div>
			
			<div class="row g-0"> <!-- g-0 : div div 사이간 여백 제거  -->
				<div class="col-md-3">
					<input type="text" id="nicname" class="form-control" placeholder="닉네임" size="10">
				</div>
				<div class="col-md-7">
					<input type="text" id="content" class="form-control" placeholder="내용" size="20">
				</div>
				<div class="col-md-2">
					<button onclick="send();" class="form-control">입력</button>
				</div>
			</div>
			
			<form id="uploadForm" class="row">
				<div class="col-md-9">
					<input  class="form-control" type="file" name="file" id="file" />
				</div>
				<div class="col-md-3">
					 <button  class="form-control" type="button" id="uploadBtn">사진전송</button>
				</div>
			    
			</form>

			
			
		</div>
	</div>
	<%@include file="footer.jsp" %>
	
	<script src="/jspweb/js/chatting.js" type="text/javascript"></script>
	
</body>
</html>