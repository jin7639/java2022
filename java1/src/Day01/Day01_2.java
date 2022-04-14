package Day01;

public class Day01_2 { // c s
	 /* 1. 출력
			1. print() 출력만
			2. printf() 출력에 꾸미기
				형식
					%s 문자열 대체
					%d 정수
					%f 실수
				제어문자
					\n 줄바꿈
					\t 들여쓰기 tab
			3. printIn() 출력 후 줄바꿈
			
		1.System : 시스템 클래스 [입출력 관련 만들어진 코드 제공]
		2.out : 출력 스트림
		3.print() : 출력 함수
		4. ; : 한줄 코드 끝 알림
	// * 시스템 클래스 내 out 이라는 출력 스트림을 통해
	 *  print 함수를 사용해서 console에 원하는 대로 출력할 수 있다.
	 */
	public static void main(String[] args) { //m s
		// 기본출력
		System.out.print("얍얍"); // ; 코드 단위 종료
		System.out.print("java_day_01"); // 문자처리 ""
		System.out.print(001); // 숫자는 "" 처리 X
			//예약어 제외 모든 문자는  "" 처리

		//2. 자동완성 ( syso + ctrl + 스페이스바)
		System.out.println("001");
		System.out.println(001);
		
		//3. 형식출력
		System.out.printf("%s", "얍얍");
		System.out.printf("java %d일차", 1);
		
		//예제1 [출석부]
		System.out.println("\n\t\t[[출석부]]");
		System.out.println("----------------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		System.out.println("강호동\t출석\t출석\t결석");
		System.out.println("유재석\t결석\t출석\t결석");
		System.out.println("----------------------------------------");
		
		//예제2 
		System.out.printf("\n\t\t%s", "[[출석부]]\n");
		System.out.printf("----------------------------------------\n");
		System.out.printf("%s \t%s \t%s \t%s \t%s \n", "이름","1교시","2교시","3교시","비고");
		System.out.printf("%s \t%s \t%s \t%s \t%s \n", "강호동","출석","출석","결석"," ");
		
		//문제1 : 고양이
		 	// \출력하려면 \\ 두 번 써야함
			// "출력하려면 \" 로 써야함
		System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");
		System.out.println("");
		
		//문제2 : 강아지
		System.out.println("|\\_/|");
		System.out.println("|q p|    /)");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`");
		System.out.println("||_/=\\\\__|");
		
		
	}//me
	
	
} //c e
