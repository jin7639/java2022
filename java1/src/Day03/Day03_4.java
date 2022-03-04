package Day03;

import java.util.Scanner;

public class Day03_4 {//cs
	
	public static void main(String[] args) {//ms
		
//		제어문 : 1. if문 2. switch문
//			if : 논리검사( true 혹은 false)	/경우의 수가 정해져있지 않은 경우 사용
//				>= <= < > == !=
//			switch : 데이터검사				/경우의 수가 정해져 있는 경우 사용
//				동일한 case이면 실행문 처리 후 -> 다음 case로 이동
//				형태
//					switch(검사대상) {
//						case '값' : 실행문; 
//						case '값' : 실행문; 
//						case '값' : 실행문; 
//						default : 실행문;
//					}
//				break; : 가장 가까운 반복문 탈출
		//예제1 : 점수가 90점 이면 A, 80이면 B, 70이면 C, 그외는 탈락
		int 점수 = 80;
		if (점수 == 90) System.out.println("A");
		else if (점수 == 80) System.out.println("B");
		else if (점수 == 70) System.out.println("C");
		else System.out.println("탈락");
		
		switch (점수) {
		case 90 : System.out.println("A"); break;
		case 80 : System.out.println("B"); break;
		case 70 : System.out.println("C"); break;
		default : System.out.println("탈락"); break;
		}
		
		
		//예제2
		int 버튼 = 3;
		switch (버튼) {
		case 1: System.out.println("1층으로 이동");	break;
		case 2: System.out.println("2층으로 이동");	break;
		case 3: System.out.println("3층으로 이동");	break;
		case 4: System.out.println("4층으로 이동");	break;
		default:System.out.println("정지");	break;
		}
		
		//예제3
		char 등급 = 'B';
		switch (등급){
		case 'A' : 
		case 'B' : System.out.println("우수회원"); break;
		case 'C' : 
		case 'D' : System.out.println("일반회원"); break;
		default:System.out.println("손님"); break;
		}
		
		//예제4
		String 직급 = "과장";
		switch (직급) {
		case "부장":System.out.println("700만원");	break;
		case "과장":System.out.println("500만원");	break;

		default: System.out.println("300만원");
			break;
		}
		
		//문제1 : 국 영 수 점수를 입력받아 평균이 90이상이면 A,80이상이면 B, 나머지 탈락 [switch]
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("국어 : "); int 국어 = scanner.nextInt();
		System.out.println("영어 : "); int 영어 = scanner.nextInt();
		System.out.println("수학 : "); int 수학 = scanner.nextInt();
		 
		int 평균 = (국어 + 영어 + 수학)/3;
		
		switch (평균/10) { //평균 점수 십의 자리 구하기
			case 9 : System.out.println("A"); break;
			case 8 : System.out.println("B"); break;
			default: System.out.println("탈락"); break;
		}
		
		 scanner.close(); 
		
		
		
		
		
		
		
		
	}//me
	

}//ce
