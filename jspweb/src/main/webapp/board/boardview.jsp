<%@page import="dto.Reply"%>
<%@page import="java.util.ArrayList"%>
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
		<h3>게시물 상세</h3>
		<%
			int bno = Integer.parseInt(request.getParameter("bno"));
			String mid = (String)session.getAttribute("login");
			if(session.getAttribute(mid+bno) == null) {
					
				//조회수 증가 처리
				BoardDao.getBoardDao().increview(bno);
				//조회수 중복 방지 [세션]
				session.setAttribute(mid+bno, true);
						//세션명 :아이디+게시물 번호, 세션값 true
				session.setMaxInactiveInterval(60*60*24);
			}
			
			Board board = BoardDao.getBoardDao().getboard(bno);
			if( board.getMno() == MemberDao.getMemberDao().getmno(mid) ){
		%>
				<a href="delete?bno=<%=board.getBno()%>">삭제 </a>
				<a href="boardupdate.jsp?bno=<%=board.getBno()%>">수정 </a>
		<%} %>
		<a href="boardlist.jsp">목록</a>
		<table>
			<tr><td>제목</td> <td><%=board.getBtitle()%></td></tr>
			<tr><td>번호</td> <td><%=board.getBno()%></td></tr>
			<tr><td>작성자</td> <td><%=board.getMid()%></td></tr>
			<tr><td>작성일</td> <td><%=board.getBdate()%></td></tr>
			<tr><td>조회수</td> <td><%=board.getBview()%></td></tr>
			<tr><td>내용</td> <td><%=board.getBcontent()%></td></tr>
			
			<%if( board.getBfile() != null){%>
			<tr><td>첨부파일</td> <td><a href="filedown?bfile=<%=board.getBfile()%>"><%=board.getBfile()%></a></td></tr>
			<%} %>
			<!-- ?는 get방식 -->
		</table>
		
		<h4>댓글</h4>
		<input type="text" id="rcontent">
		<button onclick="replywrite(<%=bno%>)">등록</button>
		
		<table id="replytable">
			<% 
			ArrayList<Reply> replylist = BoardDao.getBoardDao().replylist(bno); 
			for( Reply reply : replylist) {
			%>
			<tr>
				<td><%=reply.getMid()%><br><%=reply.getRdate()%></td>
				<td><%=reply.getRcontent()%><br>
					<button>수정</button>
					<button>삭제</button>
					<button onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>)">댓글</button>
				</td>
				<td></td>
			</tr>
			<tr><!-- 대댓글 입력창 -->
				<td></td>
				<td id="<%=reply.getRno()%>"></td>
			</tr>
		</table>
		<%} %>
		
	</div>
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
</body>
</html>