package Day02;

import java.util.Scanner;

public class Day02_3 {//cs

	public static void main(String[] args) {//ms
		
		//����1 : �޿����
		Scanner scanner = new Scanner(System.in); //[�ڷ����� �ҹ���, Ŭ�������� �빮��]
		
			//�Է����� : �⺻��, ����
		System.out.println("�⺻�� : ");	int num1 = scanner.nextInt();	
		System.out.println("���� : ");	int num2 = scanner.nextInt();
		// �Է°�ü��.nextInt() : int�� ������ ��������
		// �Է°�ü��.next() : ���ڿ� ������ ��������
		
			//���� : �Ǽ��ɾ� = �⺻�� + ���� - ����[�⺻��10%]
		int tax = (int)(num1*0.1);
		int num3 = num1 + num2 - tax;
		
			//������� : �Ǽ��ɾ� ���
		System.out.println("�Ǽ��ɾ� : " + num3);
		
		
		
		
		
	}//me
	
	
	
}//ce
