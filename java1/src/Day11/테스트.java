package Day11;

import java.util.Scanner;

import Day06.Member;

public class �׽�Ʈ {

	public static void main(String[] args) {
		
		Students[] �л��迭 = new Students[100];
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("------------------------------");
				System.out.println("        ��     ��      ǥ       ");
				System.out.println("------------------------------");
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s \n","��ȣ","�̸�","����","����","����","����","���","����");
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s \n",no, name, ko, en, math);
				//�������
				
				System.out.println("------------------------------");
				System.out.println("1.�л����� ��� 2.�л����� ����");
				int ch = scanner.nextInt();
				if (ch == 1) {
					//1. ��ȣ �̸� ���� ���� ���� 
					System.out.println("----------�л����� ���-----------");
					System.out.println("��ȣ : "); String no = scanner.next();
					System.out.println("�̸� : "); String name = scanner.next();
					System.out.println("���� : "); int ko = scanner.nextInt();
					System.out.println("���� : "); int en = scanner.nextInt();
					System.out.println("���� : "); int math = scanner.nextInt();
					
					//2. ��ü ����
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
