<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<h3>게시판 상세</h3>
		<%
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board board = BoardDao.getBoardDao().getboard(bno);
		%>
		<table>
			<tr><td>번호</td> <td><%=board.getBno()%></td></tr>
			<tr><td>작성자</td> <td><%=MemberDao.memberDao.getmid(board.getMno())%></td></tr>
			<tr><td>작성일</td> <td><%=board.getBdate()%></td></tr>
			<tr><td>제목</td> <td><%=board.getBtitle()%></td></tr>
			<tr><td>내용</td> <td><%=board.getBcontent()%></td></tr>
			<tr><td>첨부파일</td> <td><a href="filedown?bfile=<%=board.getBfile()%>"><%=board.getBfile()%></a></td></tr>
			<!-- ?는 get방식 -->
			
		</table>
		
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>