<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
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
		<div class="row">
			<div class="col-md-3">
				<%@include file="info_sidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<h3>내가 쓴 글</h3>
				<table class="table">	<!-- 테이블 -->
					<tr>
						<th>번호</th> <th>제목</th> <th>작성자</th> <th>조회수</th> <th>작성일</th>
					</tr>
					<!-- for문 -->
					<%
					int mno = MemberDao.getMemberDao().getmno(loginid);
					ArrayList<Board> boardlist = BoardDao.getBoardDao().getMyBoardlist(mno);
					for(Board board : boardlist){
						//System.out.println( board.toString());
							
					%>
					
					 <tr>
						<td><%=board.getBno()%></td>
						<td><a href="../board/boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle()%></a></td>
						<td><%=board.getMid()%></td>
						<td><%=board.getBview()%></td>
						<td><%=board.getBdate()%></td>
				<%} %>
				</table>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>