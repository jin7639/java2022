package Day01;

import java.util.Scanner;

public class Day01_3 { //cs

	public static void main(String[] args) {//ms
		
		
			//�Է�
				//Ű���� ----> ��ǻ�� [0,1]
		
		// Scanner : �Է� Ŭ���� [ �Է¿� ���õ� ��� ���� ]
		Scanner �Է°�ü = new Scanner(System.in);
		// 1. Scanner : �Է� Ŭ����
			//2. scanner : ��ü�̸� [ �ƹ��ų� ]
				//3. new : �޸� �Ҵ�
					//4. Scanner() : ������
						//5. System.in : �Է� [ Ű���� ---> ��ǻ��]
						// * System.out : ��� [��ǻ�� ---> �����]
		System.out.print(" �̸� �Է� : ");
		
		//�Է¹��� �����͸� �Է°�ü���� �����ͼ� String ��ü�� ����
		String �̸� = �Է°�ü.next();
		//1. String : ���ڿ� Ŭ����
		//2.�̸� : ��ü�̸� [�ƹ��ų�]
			//3. �Է°�ü.next() : �Է°�ü ���� ����� ������ ��������
		
		// String ��ü�� ����� ���� ���
		System.out.println(" �Է��Ͻ� �̸��� : " + �̸�);
			// "���ڿ�" + ��ü�� [������]
				// + : 1. ���ϱ� ������ 2. ���� ������
		
	}//me
	
	
	
}//ce
