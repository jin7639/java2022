package Day01;

import java.util.Scanner; // import : 가져오다

public class Day01_4 {//cs

	public static void main(String[] args) {//ms
		
		// 예제1 : 한 명의 이름, 1교시, 2교시, 3교시 출석 여부를 입력받아 출력
			// 입력 -> 저장 -> 출력
		
		// 1. 입력객체 선언
		Scanner 입력객체 = new Scanner(System.in);
	
		// 2. 입력받을 데이터 안내
		System.out.printf(" 이름 : ");
		
		// 3. 입력받은 데이터 가져오기 -> 다른곳 (String:문자열)에 저장
		String 이름 = 입력객체.next();
			// = : 대입( 오른쪽 값이 왼쪽 저장 [대입] )
		
		// 안내 출력					// 입력받아 다른 객체로 저장
		System.out.print("1교시 : "); String 교시1 = 입력객체.next();
		System.out.print("2교시 : "); String 교시2 = 입력객체.next();
		System.out.print("3교시 : "); String 교시3 = 입력객체.next();
		
		// 4. 출력
		System.out.println("\t\t[[출석부]]");
		System.out.println("-------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		System.out.println(이름 +"\t" + 교시1 +"\t" + 교시2 +"\t" + 교시3);
		System.out.printf("%s\t%s\t%s\t%s\t%s\n", 이름 , 교시1 , 교시2 , 교시3, "" );
		System.out.println("------------------------------");
		
		//문제1 : 회원가입 표 작성
		
		//데이터 입력
		System.out.println("아이디 : ");
		String 아이디 = 입력객체.next();
		System.out.println("비밀번호 : ");
		String 비밀번호 = 입력객체.next();
		System.out.println("성명 : ");
		String 성명 = 입력객체.next();
		System.out.println("이메일 : ");
		String 이메일 = 입력객체.next();
		
		//출력
		System.out.println(">>>>>>회원가입 완료 아래 정보를 확인해주세요<<<<<<");
		System.out.println("아이디\t비밀번호\t성명\t이메일");
		System.out.println(아이디 +"\t" +비밀번호+"\t"+ 성명+"\t"+이메일);
		
		
		
	}//me
	
}//ce
