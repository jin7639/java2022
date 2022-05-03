<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
		request.setCharacterEncoding("UTF-8");
		int bnum = (int)session.getAttribute("bnum_edit");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
	   	MemberDao memberDao = new MemberDao();
	   	
	   	boolean result = memberDao.update(title, content, bnum);
	   	
	   	if( result ) {
	   		response.sendRedirect("main.jsp");
	    	session.setAttribute("bnum_edit", null);
	   		
	   	}
   	%>