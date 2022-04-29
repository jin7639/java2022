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
	while(true) { //무한 루프 종료 조건 : 1. 9칸모드 알이 있을 경우 2. 승리자가 나왔을때
		///////////////////게임판 출력 [배열 내 모든 인덱스 출력 ]////////////////////
		for(int i = 0; i<게임판.length; i++) {%>
			<input type="submit" name="select" value="<%=i+1%>">
		<%
			//배수 찾기 : 값 % 수 == 0
			if (i % 3 == 2) {%>
				<br>
			<%
			}
		}
		
		///////////////////////플레이어가 위치(인덱스) 선택///////////////////////
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
		
		////////////////////////// 3.승리자 판단 ///////////////////////
		
		//1. 가로로 승리
		for ( int i=0; i<=6; i+=3) {
			//i는 0부터 6까지 3씩 증가 -> 0 3 6 -> 3회
			if (게임판[i].equals(게임판[i+1]) && 게임판[i].equals(게임판[i+2])) {
				승리알 = 게임판[i]; //동일한 알을 승리알 변수에 대입
			}
		}
		
		//2. 세로로 승리
		for (int i = 0 ; i <= 2 ; i++) {
			//i는 0부터 2까지 1씩 증가 ->0 1 2 -> 3회
			if (게임판[i].equals(게임판[i+3]) && 게임판[i].equals(게임판[i+6])) {
				승리알 = 게임판[i]; //동일한 알을 승리알 변수에 대입
			}
		}
		
		//3. 대각선 승리
	
			if (게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8])) {
				승리알 = 게임판[4]; //동일한 알을 승리알 변수에 대입
			}
			if (게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
				승리알 = 게임판[4]; //동일한 알을 승리알 변수에 대입
			}
			
		///////////////////////4.게임종료///////////////////////////
		if( 승리알.equals("[O]")) {
			System.out.println("플레이어 승리 [게임종료]");
			break;
		}
		
		if( 승리알.equals("[X]")) {
			System.out.println("컴퓨터 승리 [게임종료]");
			break;
		}
		
		
	}//while1 end [게임종료]
	///////////////////게임판 출력 [배열 내 모든 인덱스 출력 ]////////////////////
	for(int i = 0; i<게임판.length; i++) {
		System.out.print(게임판[i]);
		//배수 찾기 : 값 % 수 == 0
		if (i % 3 == 2) {
			System.out.println();
		}
	}
	//************************************무승부****************************//
	//알의 개수가 9개(공백이 0개)가 되면 무승부 판정
	
	}//me
	%>

</body>
</html>