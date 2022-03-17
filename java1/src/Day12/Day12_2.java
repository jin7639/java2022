package Day12;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class Day12_2 {//cs
	
	public static void main(String[] args) {//ms
//		//p.499
//		//String 메소드
//		String ssn = "010624-1230123";
//		char sex = ssn.charAt(7);
//		switch (sex) {//switch 제어문 [switch(검사대상)]
//		case '1':	//sex 변수값이 문자 1, 3이면
//		case '3': System.out.println("남자");
//			break;
//		case '2'://sex 변수 값이 문자 '2','4'면
//		case '4': System.out.println("여자");
//			break;
//		}
		
		//자바 메모리 [JVM]
			//스택 메모리 : 지역변수
			//힙 메모리 : 객체
			//메소드 메모리
		
		
		
//		//p.501 equals() : 문자열비교
//			//기본자료형 사용하는 변수는 연산자 사용가능 [==]
//			//String 클래스 사용하는 객체는 == 연산자 사용불가능[equals]
//		String strVar1 = new String("신민철");
//		String strVar2 = "신문철";	//객체는 new 연산자 필수 이지만 String 클래스는 자동생성 가능
//		
//		//2.문자열 비교
//		if (strVar1 == srtVar2) {
//			System.out.println("같은 String 객체를 참조");
//		}else {
//			System.out.println("다른 String 객체를 참조");
//		}
//		//3.
//		if (strVar1.equals(strVar2)) {
//			System.out.println("같은 문자열을 가짐");
//		}else {
//			System.out.println("다른 문자열을 가짐");
//		}
//		//502
//		String str= "안녕하세요";
//		
//		byte[]	bytes1 =  str.getBytes();
//		System.out.println(bytes1.length);
//		//바이트열 ->문자열 변환
//		String str1 = new String(bytes1);
//		System.out.println("바이트열 -> 문자열 : "+ str1);
//		
//		
		try {
//			//1.인코딩타입 [인코딩/디코딩 : 변환 방식]
//			
//			//1.EUC-KR[한글/영문 : 2바이트씩]
//			byte[]	bytes2 = str.getBytes("EUC-KR");//일반예외 발생
//			System.out.println("EUC-KR 길이 : " + bytes2.length);
//			String str2 =new String( bytes2, "EUC-KR");
//			System.out.println("바이트열 -> 문자열 : " + str2);
//			
//			//2.UTF-8 [전세계용어]
//			byte[]	bytes3 = str.getBytes("UTF-8");//일반예외 발생
//			System.out.println("UTF-8 길이 : " + bytes3.length);
//			String str3 =new String( bytes3, "UTF-8");
//			System.out.println("바이트열 -> 문자열 : " + str3);
//	
//		//504
//			String subject = "자바 프로그래밍";
//			int location = subject.indexOf("프로그래밍");
//			System.out.println("location");
//			
//			//문자열 내 특정문자열 위치[인덱스]찾기 /만약에 없으면 -[없다]
//			if(subject.indexOf("자바") != -1 ) {//인덱스는 0번 시작
//				System.out.println("자바 관련 책");
//			}else {
//				System.out.println("자바와 관련 없음");
//			}
//			
//			//505
//			
//			String ssn2 = "754861515485";
//			int length = ssn2.length(); //
//			if (length == 13 ) {
//				System.out.println("주민번호 자리수가 맞습니다.");
//			}else {
//				System.out.println("주민번호 자리수가 틀립니다.");
//			}
			
		System.out.println("-----------------------------------");	
			//p.506 replace ("기존문자","새로운 문자")
		String oldStr = ("자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.");
		String newSrt = oldStr.replace("자바", "JAVA");
						//문자열.replace("기존문자","새로운 문자");
			
		System.out.println(oldStr);
		System.out.println(newSrt);
		
		//507 Substring(인덱스기준) vs split(문자기준) :문자열자르기
			String ssn3 = "880815-1234567";
			String firstNum = ssn3.substring(0,6);	//시작인덱스, 마지막 인덱스 전
			System.out.println(firstNum);
			
			String secondNum = ssn3.substring(7);	//인덱스 [~ 마지막까지]
			System.out.println(secondNum);
			//split
			System.out.println("앞부분 : "+ ssn3.split("-")[0]);
			System.out.println("뒷부분 : "+ ssn3.split("-")[1]);
//			[0] = 880815 [1] = 1234567
			//508
				//영문문자열.toLowerCase("영문") -> 영문 [소문자로 변환]
				//영문문자열.toUpperCase()-> 영문 [대문자로 변환]
			//509
				//문자열.trim() : 앞뒤 공백제거
			//510 valueOF() : 기본타입 [int,double 등] ->문자열 변환
			String str2 = String.valueOf(10);	//int 형 10 ->String 10으로 변환
			String str3 = String.valueOf(10.5);
			String str4 = String.valueOf(true);
			String str5 = 10+"";	//int 형을 String 변수에 저장[불가능]
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
	}//me

}//ce
