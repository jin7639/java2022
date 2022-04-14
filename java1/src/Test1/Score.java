package Test1;

import java.util.Iterator;
import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] student = new Student[100];
		
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("                         성     적      표                       ");
				System.out.println("---------------------------------------------------------------");
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
			
				for (int i = 0; i < student.length; i++) {
					if (student[i] != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%.0f\t%.2f\t%d \n",
								student[i].getNumber(),student[i].getName(),student[i].getKorean(),student[i].getEnglish(),
								student[i].getMath(),student[i].getSum(),student[i].getAvg(),i+1);
					}
				}
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("메뉴 : 1.학생점수 등록 2.학생점수 삭제");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//점수 등록
					System.out.println("---------------------------점수 등록-------------------------------");
					System.out.println("번호 : "); int number = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어 점수 : "); int korean = scanner.nextInt();
					System.out.println("영어 점수 : "); int english = scanner.nextInt();
					System.out.println("수학 점수 : "); int math = scanner.nextInt();
					
					double sum = korean + english + math;
					double avg = sum / 3;
					
					//저장

					Student student1 = new Student(number, name, korean, english, math, sum, avg);
					
					for (int i = 0; i < student.length; i++) {
						if (student[i] == null) {
							student[i] = student1;
							break;
						}
					}//for end	
					
					//석차
					for (int i = 0; i < student.length; i++) {
				        for (int j = 0; j < student.length-1; j++) {
				            if (student[j+1] != null && student[j].getSum()< student[j+1].getSum()) {
				                Student temp = student[j];
				                student[j] = student[j+1];
				                student[j+1] = temp;
				            }
				        } 
						
					}
				}else if (ch == 2) {//점수 삭제
					System.out.println("삭제할 학생 번호 : "); int del_no = scanner.nextInt();
					boolean del_st = false;
					for (int i = 0; i < student.length; i++) {
						if (student[i].getNumber() == del_no) {
							student[i] = null;
							for (int j = i; j < student.length-1; j++) {
								student[j] = student[j+1];
							}
							del_st = true;
							break;
						}else {
							del_st = false;
						}
					}
					if (del_st == false) {
						System.out.println("일치하는 학생이 없습니다.");
					}
					
					//석차
					for (int i = 0; i < student.length; i++) {
				        for (int j = 0; j < student.length-1; j++) {
				            if (student[j].getSum()< student[j+1].getSum()) {
				                Student temp = student[j];
				                student[j] = student[j+1];
				                student[j+1] = temp;
				            }
				        } 
						
					}
				}else {//그외
					System.out.println("알 수 없는 입력입니다.");
				}
				
			
			} 
			catch (Exception e) {
				scanner = new Scanner(System.in);
			}
			
		}//while end
		
	}//me
	
}//ce
