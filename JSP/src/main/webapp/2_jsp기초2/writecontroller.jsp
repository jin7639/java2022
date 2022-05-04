<%@page import="Dto.Board"%>
<%@page import="controller.Dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("UTF-8"); //요청시 데이터 인코딩 타입 설정
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	String writer = (String)session.getAttribute("loginid"); //세션 호출시 기본 자료형은 object -> 강제 형변환
    	Date now = new Date(); //현재 시스템 날짜, 시간
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd"); //날짜 모양 
    	String date = sf.format(now); //현재 날짜 format
    	
    	//객체화
    	Board board = new Board( 0 , title, content, writer, date);
    	
    	//dao
    	MemberDao memberDao = new MemberDao();
    
    	boolean result = memberDao.write(board);
    	if( result ) {
    		response.sendRedirect("main.jsp");
    	}
    
    %>
    