<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
		request.setCharacterEncoding("UTF-8");
		int bnum = (int)session.getAttribute("bnum2");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
	   	MemberDao memberDao = new MemberDao();
	   	
	   	boolean result = memberDao.update(bnum, title, content);
	   	
	   	if( result ) {
	   		response.sendRedirect("");
	   		
	   	}
   	%>