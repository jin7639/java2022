<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <%
    	//session.invalidate(); //모든 세션 초기화 -> 장바구니 지우다가 로그인도 지워짐
    	session.setAttribute("loginid", null); //null값은 메모리를 자동 해체 시킴
    	
    	response.sendRedirect("main.jsp");
    
    
    
    %>