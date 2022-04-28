<%@page import="java.util.Random"%>
<%@page import="java.util.Scanner"%>
<%@page import="javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	Day4-6
	<form action="5_틱택토.jsp" method="get">
		<input type="submit" name="select" value="1">
		<input type="submit" name="select" value="2">
		<input type="submit" name="select" value="3"><br>
		<input type="submit" name="select" value="4">
		<input type="submit" name="select" value="5">
		<input type="submit" name="select" value="6"><br>
		<input type="submit" name="select" value="7">
		<input type="submit" name="select" value="8">
		<input type="submit" name="select" value="9"><br>
	</form>
	<%	int select = 0;
		if( request.getParameter("select") != null ) {
			select = Integer.parseInt(request.getParameter("select"));%>
			<input type="button" value="<%=select%>" disabled="disabled">
	<%}%>
	
	<%
		
		while(true) {
			System.out.print("위치 선택 : ");
			int 위치 = scanner.nextInt();
			if (게임판[위치].equals("[ ]")) {
					//선택한 위치가 공백이면 알 두기
					게임판[위치] = "[O]";
					break;
				}else {
					System.out.println("해당 위치에 둘 수 없습니다. [재선택]");
			}//if end
		}//while2 end [플레이어 정상입력]
		
		////////////////////2.컴퓨터가 선택/////////////////////////////////
		
		while(true) {
			Random random = new Random(); //난수 객체
			int 위치 = random.nextInt(9); //0~8 사이의 난수 생성 [int]
			
			if (게임판[위치].equals("[ ]")) {
					//난수 위치가 공백이면 알 두기
					게임판[위치] = "[X]";
					break;
				}//if end
		}//while2 end [난수가 공백위치를 생성하면 break;]
	
	%>

</body>
</html>