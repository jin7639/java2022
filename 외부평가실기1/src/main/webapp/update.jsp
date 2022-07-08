<%@page import="dto.MemberDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.Dao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	<%
	Dao dao = new Dao();
	int custno = Integer.parseInt( request.getParameter("Custno"));
	MemberDto memberDto = dao.getmember(custno);
	%>
	<form action="updatecontroller.jsp?custno=<%=custno%>" method="post" id="update" name="update">
		<div>회원번호(자동발생)<input type="text" name="custno" value="<%=custno%>" id="custno" ></div>
		<div>회원성명<input type="text" name="custname" id="custname" value="<%=memberDto.getCustname()%>"></div>
		<div>회원전화<input type="text" name="phone" id="phone" value="<%=memberDto.getPhone()%>"></div>
		<div>회원주소<input type="text" name="address" id="address" value="<%=memberDto.getAddress()%>"></div>
		<div>가입일자<input type="text" name="joindate" id="joindate"  value="<%=memberDto.getJoindate()%>"></div>
		<div>고객등급[A:VIP, B:일반, C:직원]<input type="text" id="grade" name="grade" value="<%=memberDto.getGrade()%>"></div>
		<div>도시코드<input type="text" name="city" id="city" value="<%=memberDto.getCity()%>"></div>
		<div>
			<button type ="button" onclick="updatecheck()">수정</button>
			<button type ="button" onclick="location.href='list.jsp'" >조회</button>
		</div>
	</form>
		
	<%@include file="footer.jsp" %>
	<script src="/외부평가실기1/js/update.js" type="text/javascript"></script>
</body>

</html>