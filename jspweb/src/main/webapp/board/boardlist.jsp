<%@page import="java.text.SimpleDateFormat"%>
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

					//작성일 날짜/시간쪼개기
					String writedate = board.getBdate().substring(0,10);
					//오늘-작성일 비교
					if (!now.equals(writedate)) {
						//작성일 표시값 다시 넣기
						writedate = board.getBdate().substring(0,10);
					}else {
						writedate = board.getBdate().substring(10);
					}
				%>
			<!-- 
				행을 클릭했을때 이동
					<tr onclick="location.href='boardview.jsp'" style="cursor: pointer;">
			
				*언어별 링크 이동 방법 [상세 페이지 이동시 식별 번호 같이 이동해야함]
				1. HTML : 파일명(경로).jsp?변수명=값
				2. JS : "location.href='파일명(경로).jsp?변수명=값'"
				3. java : response.sendRedirect("파일명(경로).jsp?변수명=값");
			
			-->
			 <tr>
				<td><%=board.getBno()%></td>
				<td><a href="boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle()%></a></td>
				<td><%=MemberDao.memberDao.getmid(board.getMno())%></td>
				<td><%=board.getBview()%></td>
				<td><%=writedate%></td>
			</tr>
			
			<%} %>
		</table>
	</div>

	<%@include file="../footer.jsp" %>
	
</body>
</html>