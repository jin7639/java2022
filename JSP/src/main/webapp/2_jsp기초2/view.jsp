<%@page import="Dto.Board"%>
<%@page import="controller.Dao.MemberDao"%>
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
		int bnum = Integer.parseInt(request.getParameter("bnum"));
	
		MemberDao memberDao = new MemberDao();
		Board board = memberDao.get(bnum);
	
		//만약 로그인된 정보와 작성자가 동일할 경우 삭제 수정 표시
		String loginid = (String)session.getAttribute("loginid");
		if( loginid != null && loginid.equals(board.getBwriter())) {
				//null은 equals 안됨
	%>	
		<a href="bupdate.jsp?bnum=<%=bnum%>"><button>수정</button> </a>
		
		<a href="bdelete.jsp?bnum=<%=bnum%>"><button>삭제</button> </a>
	<% 	
		}
	%>

	<a href="main.jsp"><button>목록</button></a>
	
	<div>제목 : <%=board.getBtitle() %> </div>
	<div>작성자 :<%=board.getBwriter() %>  </div>
	<div>날짜 :<%=board.getBdate() %>  </div>
	<div>내용 :<%=board.getBcontent() %> </div>
	
</body>
</html>