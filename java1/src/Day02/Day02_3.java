package Day02;

import java.util.Scanner;

public class Day02_3 {//cs

	public static void main(String[] args) {//ms
		
		//문제1 : 급여계산
		Scanner scanner = new Scanner(System.in); //[자료형은 소문자, 클래스명은 대문자]
		
			//입력조건 : 기본급, 수당
		System.out.println("기본급 : ");	int num1 = scanner.nextInt();	
		System.out.println("수당 : ");	int num2 = scanner.nextInt();
		// 입력객체명.nextInt() : int형 데이터 가져오기
		// 입력객체명.next() : 문자열 데이터 가져오기
		
			//조건 : 실수령액 = 기본급 + 수당 - 세금[기본급10%]
		int tax = (int)(num1*0.1);
		int num3 = num1 + num2 - tax;
		
			//출력조건 : 실수령액 출력
		System.out.println("실수령액 : " + num3);
		
		
		
		
		
	}//me
	
	
	
}//ce
