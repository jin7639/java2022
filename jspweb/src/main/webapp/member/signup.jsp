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
	<div class="container">
		<h3 class=" text-center">회원가입 페이지</h3>
		<div class="container col-md-6 offset-3">
			<form class="signupform" id="signupform" action="../signup" method="post">
				<div>
					<p>아이디</p>
					<input class="form-control" type="text" id="mid" name="mid" placeholder="user id">
					<span id="idcheck"></span>
				</div>
				<div>
					<p>비밀번호</p>
					<input class="form-control" type="password" id="mpassword" name="mpassword" placeholder="user password">
				</div>
				<div>
					<p>비밀번호 확인</p>
					<input class="form-control" type="password" id="mpasswordcheck" placeholder="user password">
					<span id="passwordcheck"></span>
				</div>
				<div>
					<p>이름</p>
					<input class="form-control" type="text" id="mname" name="mname" placeholder="user name">
					<span id="namecheck"></span>
				</div>
				<div>
					<p>전화번호</p>
					<input class="form-control" type="text" id="mphone" name="mphone" placeholder="user phone">
					<span id="phonecheck"></span>
				</div>
				<div >
					<p>이메일</p>
					<div id="emailform" class="row">
						<div class="col-md-5">
							<input class="form-control" type="text" id="memail" name="memail" placeholder="user email">
						</div>
						<div class="col-md-1">
							<span>@</span>
						</div>
						<div class="col">
							<input class="form-control" type="text" id="memailaddress" name="memailaddress">
						</div>
						<div class="col">
							<select class=" form-control" id="emailselect" name="emailselect">
								<option value="" style="height: 30px"> 직접 입력 </option>
								<option value="naver.com" style="height: 30px">naver.com</option>
								<option value="gmail.com" style="height: 30px">gmail.com</option>
							</select>
						</div>
					</div>
					
					<span id="emailcheck"></span>
				</div>
				
				<div>
					<p>주소</p>
					<div class="row mb-1">
						<div class="col-md-8">
							<input class=" form-control" type="text" id="address1" name="address1" placeholder="우편번호">
						</div>
						<div class="col-md-4">
							<input class=" form-control " type="button" onclick="findaddress()" value="우편번호 찾기">
						</div>
					</div>
					<input class=" form-control mb-1" type="text" id="address2" name="address2" placeholder="도로명주소" >
					<input class=" form-control mb-1" type="text" id="address3" name="address3" placeholder="지번주소" >
					<span id="guide" style="color:#999;display:none"></span>
					<input class=" form-control mb-3" type="text" id="address4" name="address4" placeholder="상세주소">
					<span id="addresscheck"></span><br>
				</div>
				<button class=" form-control btn btn-dark" onclick="signup()" type="button">가입하기</button>
			</form>
		</div>
	</div>
	<!-- 주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	
	<%@include file="../footer.jsp" %>
</body>
</html>