package Day08;

import java.util.Scanner;

import Day08.Day08_Bank;
import Day08.Member;

public class Bankbook {//cs
	
	//1.�ʵ�
	String account; //���¹�ȣ
	String name;	//������
	int balance; 	//�����ܾ�
	//2.������
		//1.�� ������ : �޼ҵ� ȣ���
	public Bankbook() {}
	
		//2.��� �ʵ� ������
	public Bankbook(String account, String name, int balance) {
		this.account = account;
		this.name = name;
		this.balance = balance;
	}
	
	//3.�޼ҵ� 
		//1.���»��� 
	
		//2.�Ա� 
			void �Ա�() {
				System.out.println("�Ա��� ���� ��ȣ : "); String depositaccount = Day08_Bank.scanner.next();
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(depositaccount)) {
						System.out.println("�Ա��� �ݾ� : ");	int amount = Day08_Bank.scanner.nextInt();
						temp.balance += amount;
						System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�. �ܾ� : "+ temp.balance);
						return;
					}
				} System.out.println("�������� �ʴ� �����Դϴ�.");
			}//�Ա� end
	
		//3.��� 
			void ���() {
				System.out.println("����� ���� ��ȣ : "); String withdrawaccount = Day08_Bank.scanner.next();
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(withdrawaccount)) {
						System.out.println("���� �ܾ� : " + temp.balance);
						System.out.println("����� �ݾ� : ");	int amount = Day08_Bank.scanner.nextInt();
						if (temp.balance >= amount) {
							
							System.out.println("����� �Ϸ�Ǿ����ϴ�.");
							//���� �ܾ� ����
							temp.balance -= amount;
							System.out.println("���� �ܾ� : " + temp.balance);
							return;
							
						}else {
							System.out.println("�ܾ��� �����մϴ�.");
						}
						return; //����
					}
				} System.out.println("�������� �ʴ� �����Դϴ�.");
			}
	
		//4.��ü 
	//	��ݰ��� �ݾ� �޴»�� ���� ���¹�ȣ ������ ��� ���º�й�ȣ
			
			void ��ü() {
				System.out.println("����� ���� ��ȣ : "); 	String sendaccount = Day08_Bank.scanner.next();
				//���� �ܾ� �ҷ�����
				for(Bankbook temp : Day08_Bank.bankbook) {
					if (temp != null && temp.account.equals(sendaccount)) {
						//������ �ƴϸ鼭 ������ ���¹�ȣ�� ã��
						System.out.println("���� �ܾ� : " + temp.balance);
						return; //����
					}else {//�� ã������ ã�� id ����ϰ� �� ã������ �˸� ���
						System.out.println("�������� �ʴ� �����Դϴ�.");
						return;
					}
				}
				
				System.out.println("������ �ݾ� : ");		int sendamount = Day08_Bank.scanner.nextInt();
				if (temp.balance >= sendamount) {
					System.out.println("�Ա��Ͻ� ���� : "); 		String depositbank = Day08_Bank.scanner.next();
					System.out.println("�Ա��Ͻ� ���� ��ȣ : "); 		String depositaccount = Day08_Bank.scanner.next();
//
//					System.out.println("��ü �Ϸ��Ͽ����ϴ�.");
//					//���� �ܾ� ����
//					temp.balance -= sendamount;
//					System.out.println("���� �ܾ� : " + temp.balance);
//					return;
//					
				}else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
			}//��ü end
	
		//5.���� 
			
			
		//6.���¸��
	

}//ce
