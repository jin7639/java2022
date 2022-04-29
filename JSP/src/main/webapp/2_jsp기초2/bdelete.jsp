<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <%
    
    	int bnum = Integer.parseInt(request.getParameter("bnum"));
    
    	MemberDao memberDao = new MemberDao();
    	
    	boolean result = memberDao.bdelete(bnum);
    	
    	if( result ) {
    		response.sendRedirect("main.jsp");
    	}
    
    
    
    %>