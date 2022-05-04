<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
		<% String mid = (String)session.getAttribute("login"); 	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<%@include file="info_sidebar.jsp" %>
			</div>
			<div class="col-md-9 my-5">
				<h3 class="text-center">회원탈퇴</h3>
				<hr>
				<div class="container text-center">
					<h3>회원탈퇴 확인</h3>
				
					<input type="password" id="mpassword" name="mpassword" placeholder="비밀번호를 입력해주세요">
					<button id="btnmpassword" onclick="passwordcheck('<%=mid%>')">확인</button>
					<span id="checkmsg" class="text-center"></span>
					<button id="btndelete" style="display: none; " onclick="mdelete('<%=mid%>')">탈퇴</button>
				
				</div>
			</div>
		</div>
	</div>
	
	<!-- 사용자정의 js파일 포함 -->
	<script src="../js/info.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>