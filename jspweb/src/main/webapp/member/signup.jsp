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
	<div class="container"  >
		<h3>회원가입 페이지</h3>
		<form id="signupform" action="../signup" method="post">
			아이디 : <input type="text" id="mid" name="mid" placeholder="user id">
			<span id="idcheck"></span><br>
			비밀번호 : <input type="password" id="mpassword" name="mpassword" placeholder="user password"><br>
			비밀번호 확인 : <input type="password" id="mpasswordcheck" placeholder="user password">
			<span id="passwordcheck"></span><br>
			이름 : <input type="text" id="mname" name="mname" placeholder="user name">
			<span id="namecheck"></span><br>
			전화번호 : <input type="text" id="mphone" name="mphone" placeholder="user email">
			<span id="phonecheck"></span><br>
			이메일 : <input type="text" id="memail" name="memail" placeholder="user email">@
			<input type="text" id="memailaddress">
			<select id="emailselect" name="emailselect" style="height: 30px">
				<option value="" style="height: 30px"> 직접 입력 </option>
				<option value="naver.com" style="height: 30px">naver.com</option>
				<option value="gmail.com" style="height: 30px">gmail.com</option>
			</select>
			<span id="emailcheck"></span><br>
			
			주소 : <input type="text" id="address1" name="address1" placeholder="우편번호">
			<input type="button" onclick="findaddress()" value="우편번호 찾기">
			<span id="addresscheck"></span><br>
			<input type="text" id="address2" name="address2" placeholder="도로명주소" >
			<input type="text" id="address3" name="address3" placeholder="지번주소" >
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="address4" name="address4" placeholder="상세주소"><br>
			
			<button onclick="signup()" type="button">가입하기</button>
		</form>
	</div>
	<!-- 주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	
	<%@include file="../footer.jsp" %>
</body>
</html>