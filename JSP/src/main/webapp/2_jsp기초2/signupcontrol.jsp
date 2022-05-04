<%@page import="Dto.Member"%>
<%@page import="controller.Dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		//request : 서버가 클라이언트에게 요청
			//요청시 사용되는 인코딩
			//서블릿 -> 외국회사에서 만든 것 - > 한국어 지원 안 됨
		request.setCharacterEncoding("UTF-8");
		String id =	request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		//변수3개 - >dto - 객체화
		Member member = new Member(0 , id, password, name);
		
		//객체 ->dao 
		MemberDao memberDao = new MemberDao();
		//dao 메소드에 dto 넣기
		System.out.print("회원가입 컨트롤러");
		
		boolean result = memberDao.signup(member);
		
		if(result) {
			response.sendRedirect("main.jsp");
		}else {
			
		}
	
	%>