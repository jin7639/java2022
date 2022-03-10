package Day07;

import java.util.Scanner;

public class Day07_5_BookApplication {//cs

	//BookApplication Ŭ���� : ����� �����ڵ�
	//Book Ŭ���� : ���� �����ڵ�
	//Member Ŭ���� : ȸ�� �����ڵ�
	
	//���� �뿩 console ���α׷� [ Ŭ�������� ]
		//1. Ŭ����
			//1. book
				//�ʵ� : ISBN(�ߺ��Ұ�), ������, �۰�, �����뿩����, �뿩ȸ��
				//�޼ҵ� : 1.�����˻� 2.������� 3.�����뿩 4.�����ݳ� (//������ �޼ҵ� : 1.������� 2.��������)
			//2. member
				//�ʵ� : ��ȣ, ���̵�, ��й�ȣ, �̸�, ����ó
				//�޼ҵ� : 1.ȸ������, 2.�α���, 3. ���̵�ã�� 4. ��й�ȣ ã�� 5.�α׾ƿ�
				
	//2. ȭ�鼳��
			//1.�ʱ� �޴� [1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��]
			//2.�Ϲ�ȸ�� �޴� [1.�����˻� 2. ������� 3.�����뿩 4.�����ݳ� 5.�α׾ƿ�]
			//3.������ �޴� [1.������� 2.������� 3.�������� (4.����) 5.�α׾ƿ�]
	
	
	//main �ۿ� ������ �����ϴ� ���� : ��� �޼ҵ忡�� ����ϱ� ���ؼ�
		//�������� : {��������} ��ȣ������ ����� ������ { }���� �� ����
			//���� �ٸ� { } ��ȣ ������ ���� ->��������
		//static ��������
			//���α׷� ���۽� �޸� �Ҵ� / ���α׷� ����� �޸� �ʱ�ȭ
			//�� ������ ��� �޸𸮸� �Ҵ��ϰ� ����
			//���α׷� ���������� ��� ���� ���Ǵ� �޸� [����]
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100]; //��� Ŭ�������� ����ϴ� ȸ�� ���
	static Book[] books = new Book[1000];
	
	//0. �ڵ带 �о��ִ� ���� �޼ҵ�[������]
	public static void main(String[] args) {//ms
		//�޼ҵ� ȣ��
			// menu();	
			//����ȣ�� �Ұ���
				//static : �޸� �켱�Ҵ��̱⶧���� static �� �޼ҵ�, �ʵ带 �� ����
				//main �޼ҵ� static �޼ҵ� �̱� ������ static�޼ҵ常 ȣ�Ⱑ��
			//�ܺ�ȣ��
				//1.��ü ����(�޸��Ҵ�) ->�޸� ȣ��
		Day07_5_BookApplication application = new Day07_5_BookApplication();
		application.menu();
	}//me
	
	//1. �ʱ�޴� �޼ҵ�
		void menu () {
			while (true) {//���ѷ��� [�������� ����]
				
				System.out.println("---------------���� �뿩 ���α׷�----------------");
				System.out.println("1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� : ");
				int ch = scanner.nextInt();
				Member member = new Member();	//1~4�� { }�ȿ��� ��� ���
				if (ch == 1) {
					//ȸ������ �޼ҵ� ȣ��
					Boolean result = member.ȸ������();
					if( result ) {
						System.out.println("ȸ������ ����");
					} else { 
						System.out.println("ȸ������ ����");
						
					}
				}else if (ch == 2) {
					//�α��� �޼ҵ� ȣ��
					String result = member.�α���();
						//1.�Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
					if (result == null) {
						System.out.println("������ ȸ�������� �����ϴ�.");
						
					} else if (result.equals("admin")) {
						//2.������ �޴� �޼ҵ� ȣ��
						adminmenu(); //���� �޼ҵ� ȣ��
						
					} else {
						//�Ϲ�ȸ�� �޴�
						System.out.println(result + " ��, �ݰ����ϴ�!");
						membermenu(result); //
						
					}
					
				}else if (ch == 3) {
					//���̵� ã�� �޼ҵ� ȣ��
					member.���̵�ã��();
				}else if (ch == 4) {
					//��й�ȣ ã�� �޼ҵ� ȣ��
					member.��й�ȣã��();
					
				}else {
					System.err.println("�� �� ���� ��ȣ�Դϴ�.");
				}//if end
			}//while end
		}//menu end
	
	
	//2. �Ϲ�ȸ�� �޴� �޼ҵ�
	void membermenu (String loginid) {
		System.out.println("-----------------ȸ�� �޴�-------------------");
		System.out.println("1.�����˻� 2.������� 3.�����뿩4.�����ݳ� 5.�α׾ƿ�");
		
		int ch = scanner.nextInt();
		
		Book book = new Book(); //�� �����ڷ� ��ü ->�޼ҵ� ȣ���
		
		if ( ch == 1 ) { 
			
			book.�����˻�();
			
		}else if ( ch == 2 ) {
			
			book.�������();
			
		}else if ( ch == 3 ) { 
			
			book.�����뿩(loginid);
			
		}else if ( ch == 4 ) { 
			
			book.�����ݳ�(loginid);
			
		}else if ( ch == 5 ) { 
			
			
		}else { 
			System.out.println("�� �� ���� ��ȣ�Դϴ�.");
		}
	}
	
	
	//3. ������ �޴� �޼ҵ�
	void adminmenu () {
		System.out.println("-------------------������ �޴�-----------------");
		System.out.println("1.������� 2.������� 3.�������� 4.�α׾ƿ�");
		
		int ch = scanner.nextInt();
		
		Book book = new Book();
	
		if (ch == 1) {
			
			book.�������();
			
		} else if (ch == 2 ) {
			
			book.�������();
			
		} else if (ch == 3 ) {
			
			book.��������();
			
		} else if (ch == 4 ) {
		
			
		} else {
			System.out.println("�� �� ���� ��ȣ�Դϴ�.");
			
		}
	}
	
	
	
	
	
	
	
	
}//ce
