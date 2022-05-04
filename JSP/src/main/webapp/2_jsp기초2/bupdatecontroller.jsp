<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	int bnum_edit = (int)session.getAttribute("bnum_edit");
	
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
   	MemberDao memberDao = new MemberDao();
   	
   	boolean result = memberDao.update(bnum_edit, title, content);
   	
   	if( result ) {
   		response.sendRedirect("main.jsp");
    	session.setAttribute("bnum_edit", null);
   		
   	}
%>