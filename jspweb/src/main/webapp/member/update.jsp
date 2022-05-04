<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
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
	
	<%
		//1.세션에 저장된 회원 ID호출
		String mid = (String)session.getAttribute("login");
		//2.회원정보 가져오기
		Member member = MemberDao.getMemberDao().getmember(mid);
	
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<%@include file="info_sidebar.jsp" %>
			</div>
			<div class="col-md-9 my-5">
				<%if(request.getParameter("result") !=null && request.getParameter("result").equals("1")){%>
					<div>회원정보가 수정되었습니다.</div>
				<%}else if (request.getParameter("result") !=null && request.getParameter("result").equals("2")){ %>
					<div>회원정보 수정 실패 관리자에게 문의하세요</div>
				<%} else if (request.getParameter("result") !=null && request.getParameter("result").equals("3")){ %>
					<div>비밀번호가 일치하지 않습니다.</div>
				<%} %>
				<h3 class="text-center">회원수정</h3>
				<hr>
				<form action="../update" method="post">
					<input type="hidden" name="mnum" value="<%=member.getMnum()%>">
					<div>
						<p>아이디</p>
						<%=member.getMid() %>
					</div>
					<div>
						<p>비밀번호</p>
						<button name="mpassword" type="button" onclick="passwordchange()">비밀번호 변경</button>
						<div id="passwordbox" style="display: none;">
							<input type="password" name="oldpassword">
							<input type="password" name="newpassword">
						</div>
					</div>
					<div>
						<p>이름</p>
						<input value="<%=member.getMname()%>" class="form-control" type="text" id="mname" name="mname" placeholder="user name">
					</div>
					<div>
						<p>전화번호</p>
						<input value="<%=member.getMphone()%>" class="form-control" type="text" id="mphone" name="mphone" placeholder="user phone">
					</div>
					<div >
						<p>이메일</p>
						<div id="emailform" class="row">
							<div class="col-md-5">
								<input class="form-control" value="<%=member.getMemail().split("@")[0] %>" type="text" id="memail" name="memail" placeholder="user email">
							</div>
							<div class="col-md-1">
								<span>@</span>
							</div>
							<div class="col">
								<input class="form-control" value="<%=member.getMemail().split("@")[1] %>" type="text" id="memailaddress" name="memailaddress">
							</div>
							<div class="col">
								<select class=" form-control" id="emailselect" name="emailselect">
									<option value="" style="height: 30px"> 직접 입력 </option>
									<option value="naver.com" style="height: 30px">naver.com</option>
									<option value="gmail.com" style="height: 30px">gmail.com</option>
								</select>
							</div>
						</div>
					</div>
					<div>
						<p>주소</p>
						<div class="row mb-1">
							<div class="col-md-8">
								<input class=" form-control" type="text" id="address1" name="address1" value="<%=member.getMaddress().split("_")[0]%>" placeholder="우편번호">
							</div>
							<div class="col-md-4">
								<input class=" form-control " type="button" onclick="findaddress()" value="우편번호 찾기">
							</div>
						</div>
						<input class=" form-control mb-1" type="text" id="address2" name="address2" value="<%=member.getMaddress().split("_")[1]%>" placeholder="도로명주소" >
						<input class=" form-control mb-1" type="text" id="address3" name="address3" value="<%=member.getMaddress().split("_")[2]%>" placeholder="지번주소" >
						<span id="guide" style="color:#999;display:none"></span>
						<input class=" form-control mb-3" type="text" id="address4" name="address4" value="<%=member.getMaddress().split("_")[3]%>" placeholder="상세주소">
						<span id="addresscheck"></span><br>
					</div>
					<input type="submit" value="적용">
					<a href="info.jsp"><button type="button" >취소</button></a> 
				</form>
			</div>
		</div>
	</div>
	
	<!-- 주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>