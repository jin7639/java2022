<%@page import="dao.Dao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	int custno =Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	MemberDto memberDto =new MemberDto(custno,custname, phone,address,joindate, grade,city);
	
	Dao dao = new Dao();
	boolean result = dao.update(memberDto);
	if (result) {
		response.getWriter().print(
			"<script type='text/javascript' charset='UTF-8'>"
			+ "alert('회원수정이 완료 되었습니다!' );"
			+"location.href ='index.jsp';"		
			+ "</script>"
			);
	}
	%>
</body>
</html>