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
		<h3 class="boardlist_title">자유게시판</h3>
	
<!-- --------------------------------검색처리------------------------------------------------- -->
	<%
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		//세션을 이용한 검색처리 저장
		
		//검색이 있을 경우
		if (key != null && key != null){
			session.setAttribute("key", key); //세션 설정 [세션명, 세션데이터]
			session.setAttribute("keyword", keyword);
			
		}else {	//검색이 없을 경우
			key = (String)session.getAttribute("key");
			keyword = (String)session.getAttribute("keyword");
		}
	%>
	<!-- --------------------------------전체글/인기글 버튼------------------------------------------------- -->
		<div class="row boardlist_topbtn">
			<div class="col-md-1 offset-10">
				<a href="/jspweb/board/boardlist.jsp?key=&keyword="><button class="form-control">전체글</button></a>
			</div>
			<div class="col-md-1">
				<button class="form-control">인기글</button>
			</div>
		
		</div>
	<!-- --------------------------------게시물 목록 테이블------------------------------------------------- -->
		<table class="table table-hover text-center">	<!-- 테이블 -->
			<tr>
				<th width="10%">번호</th>
				<th width="50%">제목</th>
				<th width="15%">작성자</th>
				<th width="10%">조회수</th>
				<th width="15%">작성일</th>
			</tr>
			<!-- for문 -->
		<!-- --------------------------------페이징 계산 구역------------------------------------------------ -->
		<%
			//1.전체 게시물 개수
				//전체 개수
				int totalrow = BoardDao.getBoardDao().gettotalrow(key, keyword);
				//현재 페이지
				int currentpage = 1;
				//요청받은 페이지 번호
				String pagenum = request.getParameter("pagenum");
				if (pagenum == null){
					currentpage = 1;
				}else {
					currentpage =  Integer.parseInt(pagenum);
				}
			//2.페이지당 표시할 개시물 개수
			int listsize = 5;
				
			//추후에 사용자에게 입력받기
			//3.페이지당 게시물 시작 번호
			int startrow = (currentpage-1)*listsize;
				//1페이지 ->1
				//2페이지 ->5
				//3페이지 ->10
			//마지막 페이지 번호
				int lastpage;
				if(totalrow % listsize == 0){ 
					//전체게시물 나누기 화면 표시 게시물 수
					lastpage = totalrow / listsize;
				}else {
					lastpage = totalrow / listsize +1;
					//나머지가 있으면 나머지 게시물을 표시할 페이지 +1;
				}
				//페이징 표시 개수
				int btnsize =5 ;
			//페이징 버튼 시작 번호 1		6	11	16
			int startbtn = ( (currentpage-1) / btnsize) * btnsize + 1;
			//페이징 버튼 끝번호 5	10	15	20
			int endbtn = startbtn + btnsize - 1;
			if( endbtn > lastpage ) endbtn = lastpage;
			// 만약에 페이징버튼이 마지막페이지번호 보다 커지면 페이징버튼의 마지막페이지번호 설정
			
			ArrayList<Board> boardlist = BoardDao.getBoardDao().getBoardlist(startrow,listsize,key,keyword);
			for(Board board : boardlist){
				//System.out.println( board.toString());
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
				<td style="text-align: left"><a href="boardview.jsp?bno=<%=board.getBno()%>"><%=board.getBtitle()%></a>
				<span class="countreply">(<%=BoardDao.getBoardDao().countreply(board.getBno()) %>)</span></td>
				<td><%=board.getMid()%></td>
				<td><%=board.getBview()%></td>
				<td><%=board.getBdate()%></td>
			</tr>
			
			<%} %>
		</table>
		
	<!-- --------------------------------글쓰기 버튼------------------------------------------------ -->
		<% if (loginid != null){ %>
		<div class="col-md-1 offset-11">
			<a href="boardwrite.jsp" ><button class="form-control">글쓰기</button></a>
		</div>
		<%} %>
	</div>

	<!-- --------------------------------페이징 입력 구역------------------------------------------------ -->

		<div class="col-md-4 offset-4 d-flex justify-content-center">
  			<ul class="pagination">
  			<!-- 이전 버튼 -->
			 <%if( currentpage == 1  ){ // 현재페이지가 1이면 0페이지로 요청 못하게 제한두기  %>
			 	<li class="page-item">  <a class="page-link pagenum" href="boardlist.jsp">이전</a></li>
			 <%}else{ %>
			 	<li class="page-item">  <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage-1%> ">이전</a></li>
			 <%} %>
			 
			 <!-- 페이징 버튼 -->
			    <% for (int i = startbtn ; i <= endbtn; i++) {%>
			    	<li class="page-item">
			    		<a class="page-link" href="boardlist.jsp?pagenum=<%=i%>"><%=i%></a>
			    	</li>
			    <%} %>
			    
			    <!-- 다음 버튼 --> 
			 <%if( currentpage == lastpage  ){ // 현재페이지가 마지막페이지 이면 마지막페이지 이상으로 요청 못하게 제한두기  %>
			 	<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage%> ">다음</a></li>
			 <%}else{ %>
			 	<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage+1%> ">다음</a></li>
			 <%} %>
	 	 	</ul>
		</div>

	<!-- --------------------------------검색 입력 구역------------------------------------------------ -->
		<form action="boardlist.jsp?pagenum=<%=currentpage%>" class="col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3">
				<select class="form-select" name="key"> <!-- key :필드명 -->
					<option value="btitle">제목</option>
					<option value="bcontent">내용</option>
					<option value="mid">작성자</option>
				</select>
			</div>
			<div class="col-md-7">
				<input type="text" class="form-control" name="keyword"> <!-- keyword : 해당 필드의 값 -->
			</div>
			<div class="col-md-2">
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>
	
	<%@include file="../footer.jsp" %>
	
</body>
</html>