<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Dao dao = new Dao();
	ArrayList<MemberDto> list = dao.getprice();
	
	%>
	<%@include file="header.jsp" %>
	<%@include file="menu.jsp" %>
	
	<table>
		<tr>
			<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
		</tr>
		<%
		for(MemberDto dto : list){
			String gradetitle = null;
			if(dto.getGrade().equals("A")){
				gradetitle = "VIP";
			}else if(dto.getGrade().equals("B")){
				gradetitle = "일반";
			}else {
				gradetitle = "직원";
			}
		
		%>
		
			<tr>
				<td><%=dto.getCustno()%></td>
				<td><%=dto.getCustname() %></td>
				<td><%=gradetitle%></td>
				<td><%=dto.getSumprice()%></td>
			</tr>
		<%} %>
	</table>
	
	<%@include file="footer.jsp" %>
</body>
</html>