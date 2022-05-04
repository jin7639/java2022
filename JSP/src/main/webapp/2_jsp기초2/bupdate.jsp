<%@page import="controller.Dao.MemberDao"%>
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
		request.setCharacterEncoding("UTF-8");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		session.setAttribute("bnum_edit", bnum);
	%>
	
	<form action="bupdatecontroller.jsp?b_num=<%=bnum%>" method="get">
		<input type="text" name="title"><br>
		<textarea rows="5" cols="10" name="content"></textarea><br>
		<input type="submit" value="수정">
		
	</form>
	
</body>
</html>