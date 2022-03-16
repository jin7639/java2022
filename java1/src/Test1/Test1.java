package Test1;

import java.util.Iterator;
import java.util.Scanner;

import Day11.Students;

public class Test1 {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student1[] student1 = new Student1[100];
		
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("                         성     적      표                       ");
				System.out.println("---------------------------------------------------------------");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s \n","번호","이름","국어","영어","수학","총점","평균","석차");
				
				for (int i = 0; i < student1.length; i++) {
					if (student1[i] != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%.0f\t%.2f\t%d \n", 
								student1[i].getNumber(), student1[i].getName(), student1[i].getKorean(), 
								student1[i].getEnglish(), student1[i].getMath(),student1[i].getSum(),student1[i].getAvg(),i+1);
					}//if end
				}//for end
				System.out.println("---------------------------------------------------------------");
				System.out.println("1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();	
				
				if (ch == 1) {
					
					System.out.println("----------학생점수 등록-----------");
					System.out.println("번호 : "); int number = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어점수 : "); int korean = scanner.nextInt();
					System.out.println("영어점수 : "); int english = scanner.nextInt();
					System.out.println("수학점수 : "); int math = scanner.nextInt();
					
					double sum = korean + english + math ; 
					double avg = sum / 3;
					
					Student1 st1 = new Student1(number, name, korean, english, math, sum, avg);
					
					for (int i = 0; i < student1.length; i++) {
						if (student1[i] == null ) {
							student1[i] = st1;
							
						}
						for (int j = i + 1; j < student1.length; j++) {
							if (student1[i].getSum() < student1[j].getSum()) {
								Student1 temp = student1[i];
								student1[i] = student1[j];
								student1[j] = temp;
							}
					}//for end
//					
//					for (int i = 0; i < student1.length - 1; i++) {
//						for (int j = i + 1; j < student1.length; j++) {
//							if (student1[i].getSum() < student1[j].getSum()) {
//								Student1 temp = student1[i];
//								student1[i] = student1[j];
//								student1[j] = temp;
//							}
//						}
//					}//forend
					
				}else if (ch == 2) {
					System.out.println("dnd");
				}else {
					System.out.println("알 수 없는 입력입니다.");
				}
				
					
				
			} catch (Exception e) {
				System.out.println("알 수 없는 입력입니다.");
				scanner = new Scanner(System.in);
			}//catch end
				
		}//while end
		
	}//me
	
}//ce
