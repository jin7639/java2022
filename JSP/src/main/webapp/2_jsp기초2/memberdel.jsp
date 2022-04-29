<%@page import="javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag"%>
<%@page import="Dto.Member"%>
<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    request.setCharacterEncoding("UTF-8");
	String id =	(String)session.getAttribute("loginid");
    
	MemberDao memberDao = new MemberDao();
	boolean result = memberDao.memberdel(id);
	if(result) {
		response.sendRedirect("main.jsp");
		session.setAttribute("loginid", null);			
		
		System.out.print("delete");
		//서블릿 내장객체 :sessoin ex)장바구니
			//서버 내 메모리 생성
			//모든 페이지[파일]에서 접근할 수 있는 메모리
			//브라우저 마다 메모리 별도 생성
			
	}
    %>