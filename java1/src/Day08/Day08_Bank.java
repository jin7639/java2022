package Day08;

import java.util.Scanner;

import Day08.Bankbook;
import Day08.Member;

public class Day08_Bank {//cs

	//����� ��ũ ���α׷�
		// �䱸����
		// ȸ�� �ֿ��� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣ ã��
		// ���� �ֿ��� : 1.���»���/ 2.�Ա� 3.��� 4.��ü /5.���� 6.���¸��
				//ȸ���� ���� ���� ���
				//������(�����)��  �����ǰ�� ����ϸ� ��ϵ� �����ǰ���� ȸ���� �����ؼ� ���
		// ���� : ����, �����ǰ, ȸ��
			//�ʵ�
			//�޼ҵ�
	
	
	//�ʱ� �޴�
		//1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣ ã��
			//1.ȸ������
				//�̸� ���̵� ��й�ȣ ����ó �Է¹ޱ�
				//���̵� �ߺ��˻� �ؼ� �ߺ� X�� ���ԿϷ�
			//2.�α���
				//1.���»���
					//���¹�ȣ �Է¹ޱ�
					//���� ��й�ȣ �Է¹ޱ�
				//2.�Ա� 
					//���¹�ȣ , �ݾ� �Է¹ޱ�
					
				//3.��� 
					//���¹�ȣ, �ݾ�, ��й�ȣ �Է¹ޱ�
				//4.��ü 
					//�����»�� ���¹�ȣ, �޴� ��� ���¹�ȣ/����, �ݾ� �Է¹ޱ�
				//5.���� 
					
				//6.���¸��
				
			//3.���̵�ã��
	
			//4.��й�ȣ ã��
		//�����ڸ޴�
			//1. ���� ��ǰ ��� 
			//2. �α׾ƿ�
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100]; //��� Ŭ�������� ����ϴ� ȸ�� ���
	static Bankbook[] bankbook = new Bankbook[1000];
	
	
	//0. �ڵ带 �о��ִ� ���� �޼ҵ�[������]
	public static void main(String[] args) {//ms
		Day08_Bank bank = new Day08_Bank();
		bank.menu();
		
	}//me
	
	//1.�ʱ�޴� �޼ҵ�
	void menu () {
		while(true) {//���ѷ���
			System.out.println("------------------����------------------");
			System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣ ã�� : ");
			int ch = scanner.nextInt();
			Member member = new Member();
			if ( ch == 1 ) {
				//ȸ������ �޼ҵ� ȣ��
				Boolean result = member.ȸ������();
				if( result ) {
					System.out.println("ȸ������ ����");
				} else { 
					System.out.println("ȸ������ ����");
					
				}
			}else if ( ch == 2 ) {
				//�α��� �޼ҵ� ȣ��
				String result = member.�α���();
					//1.�Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
				if (result == null) {
					System.out.println("������ ȸ�������� �����ϴ�.");
					
				} else if (result.equals("admin")) {
					//2.������ �޴� �޼ҵ� ȣ��
					adminmenu(); //���� �޼ҵ� ȣ��
				} else membermenu(result);
			}else if ( ch == 3 ) {
				
				
			}else if ( ch == 4) {
				
				
			}else {
				System.out.println("�� �� ���� ��ȣ�Դϴ�.");
			}
			
			
		}//while end
	}//menu end
	
	//2. �Ϲ�ȸ�� �޴� �޼ҵ�
		void membermenu (String loginid) {
			System.out.println("-------------------ȸ�� �޴�-------------------");
			System.out.println("1.���»��� 2.�Ա� 3.��� 4.��ü 5.���� 6.���¸�� ���� :");
			
			int ch2 = scanner.nextInt();
			Bankbook bankbook = new Bankbook();
			
			if ( ch2 == 1 ) { //���»���
				
				
			}else if ( ch2 == 2 ) {//�Ա�
				
				bankbook.�Ա�();
				
			}else if ( ch2 == 3 ) {//��� 
				
				bankbook.���();
				
			}else if ( ch2 == 4 ) {//��ü
				
				bankbook.��ü();
				
			}else if ( ch2 == 5 ) {//���� 
				
				
			}else if ( ch2 == 6 ) {//���¸��
				
				
			}else {
				System.out.println("�� �� ���� ��ȣ�Դϴ�.");
			}//if end
		}//membermenu end
	
	//�����ڸ޴�
	void adminmenu() {
		
	}
	
	
}//ce
