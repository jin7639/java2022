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
				System.out.println("                         ��     ��      ǥ                       ");
				System.out.println("---------------------------------------------------------------");
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
			
				for (int i = 0; i < student.length; i++) {
					if (student[i] != null) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%.0f\t%.2f\t%d \n",
								student[i].getNumber(),student[i].getName(),student[i].getKorean(),student[i].getEnglish(),
								student[i].getMath(),student[i].getSum(),student[i].getAvg(),i+1);
					}
				}
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("�޴� : 1.�л����� ��� 2.�л����� ����");
				int ch = scanner.nextInt();
				
				if (ch == 1) {//���� ���
					System.out.println("---------------------------���� ���-------------------------------");
					System.out.println("��ȣ : "); int number = scanner.nextInt();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("���� ���� : "); int korean = scanner.nextInt();
					System.out.println("���� ���� : "); int english = scanner.nextInt();
					System.out.println("���� ���� : "); int math = scanner.nextInt();
					
					double sum = korean + english + math;
					double avg = sum / 3;
					
					//����

					Student student1 = new Student(number, name, korean, english, math, sum, avg);
					
					for (int i = 0; i < student.length; i++) {
						if (student[i] == null) {
							student[i] = student1;
							break;
						}
					}//for end	
					
					//����
					for (int i = 0; i < student.length; i++) {
				        for (int j = 0; j < student.length-1; j++) {
				            if (student[j+1] != null && student[j].getSum()< student[j+1].getSum()) {
				                Student temp = student[j];
				                student[j] = student[j+1];
				                student[j+1] = temp;
				            }
				        } 
						
					}
				}else if (ch == 2) {//���� ����
					System.out.println("������ �л� ��ȣ : "); int del_no = scanner.nextInt();
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
						System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
					}
					
					//����
					for (int i = 0; i < student.length; i++) {
				        for (int j = 0; j < student.length-1; j++) {
				            if (student[j].getSum()< student[j+1].getSum()) {
				                Student temp = student[j];
				                student[j] = student[j+1];
				                student[j+1] = temp;
				            }
				        } 
						
					}
				}else {//�׿�
					System.out.println("�� �� ���� �Է��Դϴ�.");
				}
				
			
			} 
			catch (Exception e) {
				scanner = new Scanner(System.in);
			}
			
		}//while end
		
	}//me
	
}//ce
