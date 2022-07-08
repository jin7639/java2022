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
	int custno = dao.getlastcustno()+1;
	
	LocalDate date = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
	String nowdate = formatter.format(date);
	%>
	<form action="membersave" method="post" id="join" name="join">
		<div>회원번호(자동발생)<input type="text" name="custno" value="<%=custno%>" id="custno"></div>
		<div>회원성명<input type="text" name="custname" id="custname"></div>
		<div>회원전화<input type="text" name="phone" id="phone"></div>
		<div>회원주소<input type="text" name="address" id="address"></div>
		<div>가입일자<input type="text" name="joindate" id="joindate" value="<%=nowdate%>"></div>
		<div>고객등급[A:VIP, B:일반, C:직원]<input type="text" id="grade" name="grade"></div>
		<div>도시코드<input type="text" name="city" id="city"></div>
		<div>
			<button type ="button" onclick="joincheck()">등록</button>
			<button type ="button" onclick="location.href='list.jsp'" >조회</button>
		</div>
	</form>
		
	<%@include file="footer.jsp" %>
	<script src="/외부평가실기1/js/membersave.js" type="text/javascript"></script>
</body>

</html>