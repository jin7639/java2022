<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//signupcontroller.jsp 파일에서 request 내장객체를 이용한 입력받은 데이터를 요청한다.
	request.setCharacterEncoding("UTF-8");
	String mid = request.getParameter("mid");
	String mpassword = request.getParameter("mpassword");
	String mname = request.getParameter("mname");
	String mphone = request.getParameter("mphone");
	String memil = request.getParameter("memail");
	String maddress = request.getParameter("maddress");
%>