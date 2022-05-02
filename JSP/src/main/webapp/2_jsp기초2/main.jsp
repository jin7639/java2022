<%@page import="dto.Board"%>
<%@page import="controller.Dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0429</title>
</head>
<body>
	<h3>회원제 게시판</h3>
	
	<%
		String loginid = (String)session.getAttribute("loginid"); //세션 오브젝트로 불러옴 - > 형변환 필요
		
		if( loginid != null ){ %>
			<div><%=loginid %>님, 안녕하세요 </div>
			<a href="write.jsp"><button>글쓰기</button></a>
			<a href="logout.jsp"><button>로그아웃</button> </a>
			<a href="memberdel.jsp"><button>회원탈퇴</button> </a>
		<% }else {%>
			<a href="signup.jsp"><button>회원가입</button></a>
			<form action="logincontroller.jsp" method="get">
				<input type="text" name="id">
				<input type="password" name="password">
				<input type="submit" value="로그인">
			</form>
		<%}
	%>
	
	<table>
		<tr>
			<th>번호</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<!-- 반복문 -->
		<%
			MemberDao memberDao = new MemberDao();
			ArrayList<Board> boardlist = memberDao.list();
			for(Board temp : boardlist) {
		%>
				<tr>
					<td><%=temp.getBnum() %> </td>
					<td><%=temp.getBdate() %> </td>
					<td><%=temp.getBwriter() %> </td>
					<td><%=temp.getBtitle() %> </td>
					<td><a href="view.jsp?bnum=<%=temp.getBnum() %>"><%=temp.getBcontent()%></a></td>
						<!-- href="파일명?변수명=값" get 방식-->
				</tr>
			<%
			}
		%>
		
	</table>
</body>
</html>