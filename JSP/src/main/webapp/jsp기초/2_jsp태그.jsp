<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp : html 과 java 를 동시에 작성하는 파일 -->
		<!-- html : <마크업> / java 태그 -->
	<!-- 선언문 -->
	<h3>선언문 태그 : 메모리 할당 [변수 생성, 객체 생성, 메소드 정의 불가]</h3>
	<h3>스크립트 태그 : 자바실행문</h3>
	<h3>표현식 태그 : 메모리 호출</h3>
	<!-- HTML 작성 공간 -->
	<p>html 에서 작성된 코드 </p>
	
	<%!
		int 변수1 = 10;
		Date date1 = new Date(); //객체 선언가능
		// System.out.println("jsp 파일에서 생성된 변수 " + 변수1);
		int 함수1() { return 2; } //함수 (인수와 반환이 있는 미리 작성된 코드)
		class 클래스1 {
			String 필드1 = "유재석";
		}
		클래스1 객체1 = new 클래스1(); //사용자 정의 클래스 객체 생성 O
	%>
	
	<% 
		int 변수2 = 20;
		Date date2 = new Date(); //객체 선언가능
		//자바 언어를 작성 할 수 있는 공간
		System.out.println("jsp 파일에서 생성된 변수 " + 변수2);
		System.out.println("jsp 파일에서 생성된 객체 " + date2);
		//int 함수2() { return 2; } //함수 (인수와 반환이 있는 미리 작성된 코드)
		class 클래스2 {
			String 필드2 = "유재석";
		}
		클래스2 객체2 = new 클래스2(); //사용자 정의 클래스 객체 생성
		함수1();
	%>
	
	<!-- 여기는 html 구역 -->
	선언문의 변수 : <%= 변수1 %> <br>
	선언문의 객체 : <%= date1 %> <br>
	선언문의 함수 : <%= 함수1() %> <br>
	선언문의 사용자 정의 객체 : <%= 객체1.필드1 %> <br>
	<br>
	스크립트문의 변수 : <%= 변수2 %> <br>
	스크립트문의 객체 : <%= date2 %> <br>
	스크립트문의 사용자 정의 객체 : <%= 객체2.필드2 %> <br>
	
	
	
</body>
</html>