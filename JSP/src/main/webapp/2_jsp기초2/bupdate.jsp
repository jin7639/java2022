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
	
	<form action="updatecontroller.jsp" method="get">
		<input type="text" name="title">
		<textarea rows="5" cols="10" name="content"></textarea>
		<input type="submit" value="작성">
		
	</form>
	
	
	<% 
		//글 작성 페이지 로드
		response.sendRedirect("write.jsp");
		//원래 있던 글 불러오기
		
		//수정
		
		//저장
		int bnum = Integer.parseInt(request.getParameter("bnum"));
	    
	   	MemberDao memberDao = new MemberDao();
	   	
	   	boolean result = memberDao.bupadate(bnum);
	   	
	   	if( result ) {
	   		response.sendRedirect("write.jsp?bnum=bnum");
	   		
	   	}
   	%>
	
</body>
</html>