package Day03;

import java.util.Scanner;

public class Day03_3 {//cs
	
	public static void main(String[] args) {//ms
		
		Scanner scanner = new Scanner(System.in);
		
		//����6
		//������ �Է¹޾� 90�� �̻��̸� �հ� �ƴϸ� ���հ�
		
//		System.out.println("����6) ���� : " ); int ����6 = scanner.nextInt();
//		
//		if (����6 >=90 ) {System.out.println("�հ�");}
//		else System.out.println("���հ�");
//		
//		//����7
//		//������ �Է¹޾� ������ 90�� �̻��̸� A, 80 �̻��̸� B, 70 �̻��̸� C, �� �� �����
//		System.out.println("����7) ���� : " ); int ����7 = scanner.nextInt();
//		
//		if (����7 >= 90) {System.out.println("A");} 
//		else if (����7 >= 80) {System.out.println("B");}
//		else if (����7 >= 70) {System.out.println("C");}
//		else System.out.println("�����");
//		
		//����8 : �α��� ������
		//[�Է�] ���̵�� ��й�ȣ
		//[����] ȸ�����̵� admin �̰� ��й�ȣ�� 1234�� ��쿡�� �α��� ����. �ƴϸ� ���� ���
//		System.out.println("����8) ���̵� : " ); String id = scanner.next();
			//char �ڷ��� [���� 1�� ����]
			//�ڷ������� ���ڿ��� ������ �� ����
				//1.String Ŭ���� ����ϸ� ���ڿ� ���尡��
				//2.char �迭/���� ����ϸ� ����
//		System.out.println("����8) ��й�ȣ : " ); int pw = scanner.nextInt();
			//�� �Ǵµ� �� �ȵǴ��� �𸣰��� --> ����!
				// ��ü�� ����Ұ�
				// '�ڹ�' >= <= == > < != [�Ұ���]
				// �ڷ��� ����ϴ� ������ ������ ��� ����
				// Ŭ���� ����ϴ� ��ü�� ������ ��� �Ұ� -> �޼ҵ�
					//���ڿ� �񱳽� .equals
					//���ڿ�1.equals(���ڿ�2)
		
//		if (id == "admin" && pw == 1234 ) { System.out.println("�α��� ����");}
//		else System.out.println("�α��� ����");
//		boolean �α��μ��� = false;
//			//boolean : 1��Ʈ true Ȥ�� false ����
//		if( id.equals("admin")) { //id�� ��ü�̱� ������ == �Ұ��� //��ü�񱳽ÿ��� .equals
//			if( pw == 1234) {
//				System.out.println("�α��� ����");
//				�α��μ��� = true;
//			}
//			else {//pw �� 1234�� �ƴϸ�
//				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
//			}
//		}else {//id �� admin�� �ƴϸ�
//			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
//			}
//		if (�α��μ��� == false ) {System.out.println("�α��� ����");}
		//����9
		//[�Է�] ������ �����Է¹ޱ�
		//[����] ����� 90�̻��̸鼭 ���� 100���̸� ������, ����100�̸� ���� ���, ����100�̸� ���� ��� ���
				
		System.out.println("����9) ���� : " ); int ���� = scanner.nextInt();
		System.out.println("����9) ���� : " ); int ���� = scanner.nextInt();
		System.out.println("����9) ���� : " ); int ���� = scanner.nextInt();
		
		int ��� = (���� + ���� + ����)/3;
		if(��� >= 90) {//����� 90�̻��̸�
			
			//if ��ø
			if ( ���� == 100) System.out.println("������");
			if ( ���� == 100) System.out.println("������");
			if ( ���� == 100) System.out.println("���п��");
			
		} else if (��� >= 80) { //����� 80�̻��̸�
			
			if ( ���� >=90 ) System.out.println("�������");
			if ( ���� >=90 ) System.out.println("�������");
			if ( ���� >=90 ) System.out.println("�������");
			
		}else {System.out.println("�����");} //�׿�
		
		
		 scanner.close(); 
		
		
	}//me
	

}//cs
