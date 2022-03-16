package Day11;

import java.util.Scanner;

import Day06.Member;

public class 테스트 {

	public static void main(String[] args) {
		
		Students[] 학생배열 = new Students[100];
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("------------------------------");
				System.out.println("        성     적      표       ");
				System.out.println("------------------------------");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s \n","번호","이름","국어","영어","수학","총점","평균","석차");
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s \n",no, name, ko, en, math);
				//점수출력
				
				System.out.println("------------------------------");
				System.out.println("1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();
				if (ch == 1) {
					//1. 번호 이름 국어 영어 수학 
					System.out.println("----------학생점수 등록-----------");
					System.out.println("번호 : "); String no = scanner.next();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어 : "); int ko = scanner.nextInt();
					System.out.println("영어 : "); int en = scanner.nextInt();
					System.out.println("수학 : "); int math = scanner.nextInt();
					
					//2. 객체 생성
					Students students = new Students(no, name, ko, en, math);
					
					
					
					
					
				}else if (ch == 2) {
					
				}else {
					
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}
		
		
		
	}
	
	
}
