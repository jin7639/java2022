package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3 {
	public static void main(String[] args) {//ms
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� : "); int year = scanner.nextInt();
		System.out.println("�� : "); int month = scanner.nextInt();
		
		�޷�(year, month);
		
	}//me


		//1.�޷� �޼ҵ�
	public static void �޷� ( int year, int month) {
		Scanner scanner = new Scanner(System.in);
		while(true) {//���ѷ��� [�������� :4��]
			//1.Ķ���� Ŭ���� �� ���� �ð�/��¥ ��ü ȣ��
			Calendar calendar = Calendar.getInstance();
			
			//�ش� ���� 1�� ���� ã��
				//1.����� ���� Ķ���� ����
			calendar.set(year, month-1, 1); //��)3��1��
				//2.3�� 1���� ����
				int sweek = calendar.get(Calendar.DAY_OF_WEEK);
				//3.3���� ������ ��
				int eday = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
			//3. ���
			System.out.println("\n\n********************** "+year+"��" + month+"�� ******************");
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		
			//���� �� 1���� ��ġ �տ� ���� ä���
			for (int i = 1; i < sweek; i++) {
				System.out.print("\t");
			}
			//1�Ϻ��� ������ ������ ���
			for(int i = 1; i<=eday ;i++) {
				//i = �ϼ� ���
				System.out.print(i+"\t");
				
				//����ϸ��� �ٹٲ�ó�� [ �����=7] ������ 7�������
				if (sweek % 7 == 0) System.out.println();
				
				//�Ϸ羿 ���� ����
				sweek++;
				
			}
			
			//��ư [1.������ 2.������ 3.�ٽð˻� 4.����]
		try {	
			System.out.println();
			System.out.println("1.������ 2.������ 3.�ٽð˻� 4.����");
			int ch = scanner.nextInt();
				
			if (ch == 1) {
				month -= 1;
				if (month == 0) {
					month =12;
					year -= 1;
				}
			}else if (ch == 2) {
				month += 1;
				if (month == 13) {
					month = 1;
					year +=1;
				}
			}else if (ch == 3) {
				System.out.println("���� : ");  year = scanner.nextInt();
				System.out.println("�� : "); month = scanner.nextInt();
			}else if (ch == 4) {
				System.out.println("�޷� ����");
				break;
			}
		}catch (Exception e) {//���࿡ try ���� ����[����]�� �߻��ϸ� �ش� �ڵ� ����
			System.out.println("�������� �Է��� �ƴմϴ�.");
		}
		
		}//while end
	}//�޷� end	
		
}//ce