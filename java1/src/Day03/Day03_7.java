package Day03;

import java.util.Scanner;

public class Day03_7 {//ce
	public static void main(String[] args) {//ms
		
		//���� ���� [��𼭵� ����� �� �ִ� ����]
		boolean run = true; // ���� ���� ���� / true = ���� false = ����
		int balance = 0; // ���ݾ� ����
		
		Scanner scanner = new Scanner(System.in); // �Է°�ü
		
		while (run) {
			System.out.println("--------------------------------");
			System.out.println("|1.���� | 2.��� | 3.�ܰ� | 4.���� |");
			System.out.println("--------------------------------");
			System.out.println("����> ");
			int ���� = scanner.nextInt();
			if( ���� == 1) {
				System.out.println("���ݾ� : "); int ���ݾ� = scanner.nextInt();
						//�Է¹��� ���ݾ��� ���忡 �ֱ�
				balance += ���ݾ�;
			} else if (���� == 2) {
				System.out.println("��ݾ� : "); int ��ݾ� = scanner.nextInt();
				//���࿡ ��ݾ��� ���ݾ׺��� �� ũ�� �ܾ׺���
				if (��ݾ� > balance) {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				//�ƴϸ� ��ݽ���
				balance -= ��ݾ�;
			} else if (���� == 3) {
				System.out.println("�ܰ� : " + balance);
						
			} else if (���� == 4) {
				break;
			}else {//�׿�
				System.out.println("�� �� ���� ��ȣ �Դϴ�.");
			}
			
		}
		
		 scanner.close(); 
		
	}//me
	
}//ce
