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
		<div class="col-md-6 offset-3 my-5">
			<form class="loginform" action="../login" method="post">
				<p>아이디</p>
				<input class="form-control" type="text" name="mid">
				<p>비밀번호</p>
				<input class="form-control mb-3" type="password" name="mpassword">
				<input class="form-control btn btn-dark" type="submit" value="로그인">
				<div >
					<%
						//로그인 실패시
						String result = request.getParameter("result");
						if(result != null && result.equals("2")){ %>
							<div class="text-center my-2">동일한 회원정보가 없습니다.</div>
					<%	}%>
				</div>
				
			</form>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>