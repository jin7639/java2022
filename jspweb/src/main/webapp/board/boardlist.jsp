<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
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
		<h3>자유게시판</h3>
		<% if (loginid != null){ %>
		<a href="boardwrite.jsp">글쓰기</a>
		<%} %>
		<table class="table">	<!-- 테이블 -->
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th> <th>조회수</th> <th>작성일</th>
			</tr>
			<!-- for문 -->
				<%

				ArrayList<Board> boardlist = BoardDao.getBoardDao().getBoardlist();
				for(Board board : boardlist){
					//System.out.println( board.toString());
					
					//현재 날짜
					Date today = new Date();
					SimpleDateFormat sdfday = new SimpleDateFormat ("yyyy-MM-dd");
					String now = sdfday.format(today);

				for (int i = 0; i < boardlist.size(); i++) {
						//작성일 날짜/시간쪼개기
					String writedate = boardlist.get(i).getBdate();
						String writeday = writedate.substring(0,10);
						System.out.print(writeday);
						String writedatetime;
						//오늘-작성일 비교
						if (writeday.equals(now)) {
							//작성일 표시값 다시 넣기
							writedatetime = writeday;
						}else {
							writedatetime = writedate.substring(10);
						}
					} 
				%>
			<tr>
				<td><%=board.getBno()%></td>
				<td><%=board.getBtitle()%></td>
				<td><%=MemberDao.memberDao.getmid(board.getMno())%></td>
				<td><%=board.getBview()%></td>
				<td><%=writedatetime%></td>
			</tr>
			
			<%} %>
		</table>
	</div>

	<%@include file="../footer.jsp" %>
	
</body>
</html>