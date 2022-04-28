<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!-- 
    	전 페이지로 부터 request (요청)
    	request : 서블릿 클래스에서 제공해주는 내장 객체 (미리 만들어진 객체)
    	request.getParameter("요청할 변수의 name값")
    		-> 문자 String 만 가능
    			형변환 : 문자 -> 정수열 Integer.parseInt
     -->
     
     <%
     	//스크립트 = 자바 언어를 작성하고 실행하는 공간
     	String 이름 = request.getParameter("name");
     	String 색상 = request.getParameter("color");
     	// 제어문
     	boolean admin = true;
     	if(!이름.equals("관리자")) {
			admin = false;     		
     	}
     	int 반복횟수 = Integer.parseInt(request.getParameter("number"));
     %>
     
     <html>
     	<body style="background-color: <%=색상%>">
     		작성한 이름 : <%=이름 %> <br>
     		선택한 색상 : <%=색상 %> <br>
     		<!-- 제어문 -->
     		<%
     			if(admin == true ) {
   		
			%>
   		<div> 관리자 이군요</div>
   		
   			<% 	
     			}
     		%>
     		
     		
     		<%
     		
    		// 공백 b는 입력받은수-현재줄수 까지 1씩증가->공백출력
    		for ( int i = 1; i <= 반복횟수; i++) {
    			//1. 공백찍기
    			for (int b = 1; b<= 반복횟수-i; b++) { %>
    				<span style="color: white">　</span>	
    		<% 	}
    			//2. 별찍기
    			for (int s = 1 ; s<=i+i-1 ; s++) { %>
    					<span style="color: white">★</span>	
    			<%}%>
    			<br>
    		<%}%>
     		
     	</body>
     </html>