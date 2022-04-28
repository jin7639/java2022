<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% //자바 작성하는 공간
		//폼이 전송하기 전에는 요청 불가 -> 요청시 null값
		
		//현재 달력 가져오기
		Calendar calendar = Calendar.getInstance(); //왜 new를 안쓰나요?? A.본인클래스 내장 -???
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONDAY)+1;
		boolean ch = false; //출력가능 달력이면 false
		
		//2. 요청 변수가 있을 경우 [요청변수가 null 아니면]
		if( request.getParameter("year") != null && request.getParameter("month") != null ) {
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));
			
			//만약 월이 0이하이면 연도 -1 월 = 12 설정
			if(month < 1 ) {
				month = 12; year--;
			}
			//만약에 월이 12 초과이면 연도 +1 월 = 1 설정
			if( month > 12 ) {
				month = 1; year++;
			}
			//지원불가 연도 1900년 이하
			
			if (year < 1900 || year > 2300 || month < 0 || month > 12) {
				ch = true; //출력 불가능 달력이면 true
			}
			
		}else { //요청 변수 없을 경우 [요청변수가 null 이면]
				
		}
		
		//3.입력받으로 값으로 달력 설정
		calendar.set(year, month-1, 1); //month-1 차감하는 이유 : 0월=>1월, 11월=>12월
		int sweek = calendar.get( Calendar.DAY_OF_WEEK); //해당 월의 시작 요일 구하기
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//해당 월의 마지막 일 구하기
		
	%>
	
	<!-- html 작성 공간  -->
	
	<form action="4_달력.jsp" method="get">
		<!-- action = "폼이 전송될 위치(파일명)" -->
		
		<input type="text" name="year" placeholder="연도">
		<input type="text" name="month" placeholder="월">
		<input type="submit" value="검색">
	</form>
	
	<p>입력한 연도 <%=year %></p>
	<p>입력한 달 <%=month %></p>
	
	<form action="4_달력.jsp" method="get">
		<input type="submit" value="이전">
		<input type="text" name="year" value="<%=year%>">
		<input type="text" name="month" value="<%=month-1%>">
	</form>
	
	<form action="4_달력.jsp" method="get">
		<input type="submit" value="다음">
		<input type="text" name="year" value="<%=year%>">
		<input type="text" name="month" value="<%=month+1%>">
	</form>
	<%if(ch == true) {%>
		<div>표현 할 수 없는 달력입니다.</div>
	<%}%>
	<table>
		<tr>
			<th>일요일</th>
			<th>월요일</th>
			<th>화요일</th>
			<th>수요일</th>
			<th>목요일</th>
			<th>금요일</th>
			<th>토요일</th>
		</tr>
		<tr>
			<!-- 시작 요일 까지 공백을 채움 -->
			<% for(int i = 1; i <sweek; i++){ %>
				<td></td>
			<% } %>
			<!-- 1일 부터 마지막 일까지 1씩 증가하면서 출력 -->
			<% for (int i = 1; i<=eday; i++) { %>
				<td><%=i %></td>			
				<!-- 일주일 마다 줄바꿈 == 7일마다 == 토요일마다 -->
				
				<% if(sweek % 7 == 0) { %>
					</tr> <tr>			
				<% } %>
				
				<% sweek++; %>
				
			<% } %>
		</tr>
	</table>
	
	
</body>
</html>