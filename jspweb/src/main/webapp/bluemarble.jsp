<%@page import="dao.CityDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.City"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/city.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
	<%ArrayList<City> citylist = CityDao.getCityDao().getCitylist(); %>
	<table>
		<%int i = 0;%>
		<% for(i = 0; i < 16; i++ ){ %>
			<% if(i <5 || i >10){ 
				if(i == 0 || i == 11){%>
					<tr>
						<td class="city">
							<%=citylist.get(i).getCname() %><br>
							<%=citylist.get(i).getPland() %>만원<br>
							
						</td>
				<% }else if(i == 4|| i == 15){%>
						<td class="city">
							<%=citylist.get(i).getCname() %><br>
							<%=citylist.get(i).getPland() %>만원
						</td>
					</tr>
				<% }else {%>
						<td class="city">
							<%=citylist.get(i).getCname() %><br>
							<%=citylist.get(i).getPland() %>만원
						</td>
				<% }%>
			<% }%>
			<%if(i==5 || i ==7 ||i == 9) {%>
			<tr>
				<td class="city">
					<%=citylist.get(i).getCname() %><br>
					<%=citylist.get(i).getPland() %>만원
				</td>
				<td colspan="3"></td>
			<%} %>
			<%if(i==6 || i ==8 ||i == 10) {%>
				<td class="city">
					<%=citylist.get(i).getCname() %><br>
					<%=citylist.get(i).getPland() %>만원
				</td>
			</tr>
			<% }%>
		<% }%>
	</table>
	</div>
	<%@include file="footer.jsp" %>
	
</body>
</html>