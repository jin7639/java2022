package Day01;

import java.util.Scanner;

public class Day01_6 {//ms

	public static void main(String[] args) {//ms
		
		//문제2 : 하나의 방문록
		
		//1. 입력객체 선언
		Scanner scanner = new Scanner(System.in);
		
		//2. 입력할 대상 안내
		System.out.println("순번 : ");
		System.out.println("작성자 : ");
		System.out.println("내용 : ");
		System.out.println("날짜 : ");
		
		//3. 입력받은 데이터 다른 곳에 저장
		String num = scanner.next();
		String name = scanner.next();
		String comments = scanner.next();
		String date = scanner.next();
		
		//4.출력
		System.out.println("----------방명록----------");
		System.out.println("|순번|작성자|내용    |날짜  |");
		System.out.println("|"+ num +"  |" + name +"|"+ comments +"|"+ date +"|" );
		
		
		
	}//me
	
	
}//me
