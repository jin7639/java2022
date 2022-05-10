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
				Board board = BoardDao.getBoardDao().getboard(bno); %>
			<div class="row topbtn  d-flex justify-content-end">
				<div class="col-md-2">
					<a href="boardlist.jsp"><button class="form-control">목록</button></a>
				</div>
		<% 	if( board.getMno() == MemberDao.getMemberDao().getmno(mid) ){%>
				<div class="col-md-2">
					<a href="delete?bno=<%=board.getBno()%>"><button class="form-control">삭제</button></a>
				</div>
				<div class="col-md-2">
					<a href="boardupdate.jsp?bno=<%=board.getBno()%>"><button class="form-control">수정</button></a>
				</div>
		<%}%>
			</div>
		<h2 class="boardview_title"><%=board.getBtitle()%></h2>
		<table class="table">
			<tr><td width="25%">번호 : <%=board.getBno()%></td>
			<td width="25%">작성자 : <%=board.getMid()%></td>
			<td width="25%">작성일 : <%=board.getBdate()%></td>
			<td width="25%">조회수 : <%=board.getBview()%></td></tr>
			<tr>
				<td colspan="4">
					<div class="boardview_content">
						<%=board.getBcontent()%>
					</div>
				</td>
			</tr>
			
			<%if( board.getBfile() != null){%>
			<tr><td colspan="4">첨부파일 　　　<a href="filedown?bfile=<%=board.getBfile()%>"><%=board.getBfile()%></a></td></tr>
			<%} %>
			<!-- ?는 get방식 -->
		</table>
		
		<%if( mid != null ){ %>
		
			<div class="row">
				<div class="col-md-10">
					<textarea id="rcontent" class="form-control" rows="3"></textarea>
				</div>
				<div class="col-md-2">
					<button class="btnreply py-4 my-1" onclick="replywrite(<%=bno%>)">등록</button>
				</div>
			</div>
		<%} else { %>
			<h5 class="text-center">비회원은 댓글을 달 수 없습니다.</h5>
		<%} %>
		
		<!-- ----------------댓글쓰기---------------------------------------------------------------------------- -->
		<table id="replytable">
			<%
			ArrayList<Reply> replylist = BoardDao.getBoardDao().replylist(bno); 
			for( Reply reply : replylist) {%>
			<tr>
				<td ><%=reply.getMid()%><br><%=reply.getRdate()%></td>
				<td colspan="2"><%=reply.getRcontent()%><br>
				<%if(mid != null && mid.equals(reply.getMid())){ %>
					<button class="btnreply" onclick="replyupdate(<%=reply.getRno()%>)">수정</button>
					<button class="btnreply" onclick="replydelete(<%=reply.getRno()%>)">삭제</button>
				<%} %>
				<%if( mid != null ){ %>
					<button class="btnreply" onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>)">댓글</button>
				<%} %>
				</td>
				<td></td>
			</tr>
			<tr><!-- 대댓글 입력창 -->
				<td></td>
				<td colspan="2"  id="<%=reply.getRno()%>"></td>
			</tr>
			
			<!-- 대댓글 출력창 -->
			<%ArrayList<Reply> rereplylist = BoardDao.getBoardDao().rereplylist(bno, reply.getRno());
				for(Reply rereply : rereplylist) {%>
					<tr>
						<td></td>
						<td width="10%" class="replywriter">
							<%=rereply.getMid() %> <br> 
							<span class="replydate"> <%=rereply.getRdate() %> </span>
						</td>
						<td width="80%">
							<%=rereply.getRcontent() %> <br> 
							<%if(mid != null && mid.equals(reply.getMid())){ %>
								<a href="#"><button class="btnreply">수정</button></a>
								<a href="#"><button class="btnreply"onclick="replydelete(<%=reply.getRno()%>)">삭제</button></a>
							<%} %>
						</td>
					</tr>
				<% }%>
			<% }%>
		</table>
		
	</div>
	
	<%@include file="../footer.jsp" %>
	<script src="/jspweb/js/board.js" type="text/javascript"></script>
</body>
</html>