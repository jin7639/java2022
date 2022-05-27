<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container my-5">
		<div class="col-sm-6 offset-3 chattingbox">
			<div class="row">
				<div class="col-sm-4"><!-- 접속자 목록 -->
					<h5 class="enter_title">접속자 목록</h5>
					<div id="enterlist">
					
					</div>
				</div>
				<div class="col-sm-8"><!-- 채팅창 -->
					<div id="contentbox" class="contentbox">
						<div class="alarm">
							<span>유재석 님이 입장하셨습니다.</span>
						</div>
					</div>
					<% String mid = (String)session.getAttribute("login"); %>
					<input type="hidden" value="<%=mid%>" id="mid">
					<div class="row g-0"><!-- 입력상자 -->
						<div class="col-sm-10">
							<textarea id="incontent" rows="2" cols="" class="form-control" onkeyup="enterkey('<%=mid%>')"></textarea>
						</div>
						<div class="col-sm-2">
							<button class="form-control sendbtn" onclick="send('<%=mid%>')">전송</button>
						</div>
					</div>
					<div class="btnbox">
						<span>첨부파일</span>
						<span>이모티콘</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/chatting2.js" type="text/javascript"></script>
</body>
</html>